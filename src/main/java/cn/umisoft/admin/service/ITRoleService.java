package cn.umisoft.admin.service;

import cn.umisoft.admin.entity.TRole;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author hujie@umisoft.cn
 * @since 2019-01-21
 */
public interface ITRoleService extends IUmiService<TRole> {

    /**
     * @description: <p>根据部门ID，查看该部门直接分配的所有角色列表</p>
     * @author: hujie@umisoft.cn
     * @date: 2019/3/7 12:11 AM
     */
    List<TRole> findAllByDeptId(String deptId);
    /**
     * @description: <p>根据用户ID，查看该用户直接分配的所有角色列表</p>
     * @author: hujie@umisoft.cn
     * @date: 2019/3/7 12:11 AM
     */
    List<TRole> findAllByUserId(String userId);
    /**
     * @description: <p>根据路由菜单ID，查看该路由菜单直接分配的所有角色列表</p>
     * @author: hujie@umisoft.cn
     * @date: 2019/3/7 12:11 AM
     */
    List<TRole> findAllByMenuId(String menuId);
}
