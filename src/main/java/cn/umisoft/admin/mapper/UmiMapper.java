package cn.umisoft.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description:
 * @Author: hujie@umisoft.cn
 * @Date: 2019/1/26 11:22 PM
 */
public interface UmiMapper<T> extends BaseMapper<T> {
    /**
     * @description: <p>封装逻辑删除，逻辑删除一律采用该方法</p>
     * @author: hujie@umisoft.cn
     * @date: 2019/1/26 11:22 PM
     * @param: entity
     * @return: 受影响数据条数
     */
    int deleteByIdWithFill(T entity);
}
