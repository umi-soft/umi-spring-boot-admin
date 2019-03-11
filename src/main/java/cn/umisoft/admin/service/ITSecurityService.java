package cn.umisoft.admin.service;

import cn.umisoft.admin.entity.TSecurity;

import java.util.List;

/**
 * <p>
 * 安全资源定义信息表 服务类
 * </p>
 *
 * @author hujie@umisoft.cn
 * @since 2019-01-21
 */
public interface ITSecurityService extends IUmiService<TSecurity> {
    /**
     * @description: <p>根据路由菜单ID，查看该路由菜单直接分配的所有后端资源权限列表</p>
     * @author: hujie@umisoft.cn
     * @date: 2019/3/7 12:11 AM
     */
    List<TSecurity> findAllByMenuId(String menuId);
}
