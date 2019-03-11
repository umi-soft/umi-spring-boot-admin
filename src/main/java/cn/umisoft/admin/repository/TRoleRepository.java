package cn.umisoft.admin.repository;

import cn.umisoft.admin.entity.TRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <p>
 * 角色信息表 Repository 接口
 * </p>
 *
 * @author hujie@umisoft.cn
 * @since 2019-01-13
 */
public interface TRoleRepository extends JpaRepository<TRole, String> {

    /**
     * @description: <p>根据部门ID，查看该部门直接分配的所有角色列表</p>
     * @author: hujie@umisoft.cn
     * @date: 2019/3/7 12:11 AM
     */
    @Query("from TRole where id in ( select roleId from RDeptRole where deptId = ?1)")
    List<TRole> findAllByDeptId(String deptId);
    /**
     * @description: <p>根据用户ID，查看该用户直接分配的所有角色列表</p>
     * @author: hujie@umisoft.cn
     * @date: 2019/3/7 12:11 AM
     */
    @Query("from TRole where id in ( select roleId from RUserRole where userId = ?1)")
    List<TRole> findAllByUserId(String userId);
    /**
     * @description: <p>根据路由菜单ID，查看该路由菜单直接分配的所有角色列表</p>
     * @author: hujie@umisoft.cn
     * @date: 2019/3/7 12:11 AM
     */
    @Query("from TRole where id in ( select roleId from RMenuRole where menuId = ?1)")
    List<TRole> findAllByMenuId(String menuId);

}
