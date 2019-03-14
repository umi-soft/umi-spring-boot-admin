package cn.umisoft.admin.mapper;

import cn.umisoft.admin.entity.TMenu;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * <p>
 * 前端路由菜单信息表 Mapper 接口
 * </p>
 *
 * @author hujie@umisoft.cn
 * @since 2019-01-13
 */
public interface TMenuMapper extends UmiMapper<TMenu> {

    @MapKey("id")
    @Select("SELECT ID AS id, NAME as name FROM T_MENU WHERE DELETED = 0")
    Map<String, String> selectAllIdMap();
}
