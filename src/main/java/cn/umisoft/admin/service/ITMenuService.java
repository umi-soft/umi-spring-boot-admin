package cn.umisoft.admin.service;

import cn.umisoft.admin.entity.TMenu;

import java.util.List;

/**
 * <p>
 * 前端路由菜单信息表 服务类
 * </p>
 *
 * @author hujie@umisoft.cn
 * @since 2019-01-21
 */
public interface ITMenuService extends IUmiService<TMenu> {
    /**
     * @description: <p>根据角色ID查询该角色直接分配的前端路由菜单权限</p>
     * @author: hujie@umisoft.cn
     * @date: 2019/3/7 7:11 PM
     * @param: roleId
     * @return: List<TMenu>
     */
    List<TMenu> findAllByRoleId(String roleId);
}
