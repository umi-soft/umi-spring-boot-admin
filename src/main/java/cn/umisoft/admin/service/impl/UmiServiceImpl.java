package cn.umisoft.admin.service.impl;

import cn.umisoft.admin.entity.UmiEntity;
import cn.umisoft.admin.mapper.UmiMapper;
import cn.umisoft.admin.service.IUmiService;
import cn.umisoft.admin.util.reflect.IEntityHelper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: hujie@umisoft.cn
 * @date: 2019/1/21 2:57 PM
 */
public class UmiServiceImpl<M extends UmiMapper<T>,R extends JpaRepository<T, String>, T extends UmiEntity> extends ServiceImpl<M, T> implements IUmiService<T>, IEntityHelper<T> {

    @Value("${mybatis-plus.global-config.db-config.logic-delete-value}")
    protected Integer logicDeleteValue;
    @Value("${mybatis-plus.global-config.db-config.logic-not-delete-value}")
    protected Integer logicNotDeleteValue;

    @Autowired
    protected R baseRepository;

    @Override
    public boolean removeById(Serializable id) {
        T entity = null;
        try {
            entity = getEntityClass().newInstance();
            entity.setId((String)id);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return SqlHelper.delBool(this.baseMapper.deleteByIdWithFill(entity));
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean removeByMap(Map<String, Object> map) {
        Assert.notEmpty(map, "error: columnMap must not be empty", new Object[0]);
        UpdateWrapper uw = new UpdateWrapper();
        for (String entityFieldName : map.keySet()) {
            String dbFieldName = getEntityTableFieldValue(entityFieldName);
            uw.eq(dbFieldName, map.get(entityFieldName));
        }
        T entity = getEntityInstance();
        uw.set("DELETED", logicDeleteValue);
        // 确保可记录最秀修改人与修改事件
        return SqlHelper.delBool(this.baseMapper.update(entity, uw));
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean resetByMap(List<T> entities, Map<String, Set<Object>> mappingInfo, int batchSize) {
        for (String entityFieldName : mappingInfo.keySet()) {
            String dbFieldName = getEntityTableFieldValue(entityFieldName);
            for (Object entityFieldValue : mappingInfo.get(entityFieldName)) {
                T entity = getEntityInstance();
                UpdateWrapper uw = new UpdateWrapper();
                uw.in(dbFieldName, entityFieldValue);
                uw.set("DELETED", logicDeleteValue);
                // 确保可记录最秀修改人与修改事件
                this.baseMapper.update(entity, uw);
            }
        }
        // 以下代码借鉴了父类 ServiceImpl asveBatch方法
        String sqlStatement = this.sqlStatement(SqlMethod.INSERT_ONE);
        SqlSession batchSqlSession = this.sqlSessionBatch();
        Throwable e1 = null;
        try {
            int i = 0;
            for(T entity : entities) {
                i ++;
                batchSqlSession.insert(sqlStatement, entity);
                if (i >= 1 && i % batchSize == 0) {
                    batchSqlSession.flushStatements();
                }
            }
            batchSqlSession.flushStatements();
            return true;
        } catch (Throwable e2) {
            e1 = e2;
            throw e2;
        } finally {
            if (batchSqlSession != null) {
                if (e1 != null) {
                    try {
                        batchSqlSession.close();
                    } catch (Throwable e3) {
                        e1.addSuppressed(e3);
                    }
                } else {
                    batchSqlSession.close();
                }
            }
        }
    }
}
