package cn.umisoft.admin.service.impl;

import cn.umisoft.admin.entity.RMenuRole;
import cn.umisoft.admin.entity.TMenu;
import cn.umisoft.admin.mapper.TMenuMapper;
import cn.umisoft.admin.repository.RMenuRoleRepository;
import cn.umisoft.admin.repository.TMenuRepository;
import cn.umisoft.admin.service.ITMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 前端路由菜单信息表 服务实现类
 * </p>
 *
 * @author hujie@umisoft.cn
 * @since 2019-01-21
 */
@Service
public class TMenuServiceImpl extends UmiServiceImpl<TMenuMapper, TMenuRepository, TMenu> implements ITMenuService {

    @Autowired
    protected RMenuRoleRepository menuRoleRepository;

    @Override
    public List<TMenu> findAllByRoleId(String roleId) {
        return this.baseRepository.findAllByRoleId(roleId);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    @Override
    public Map<String, Map<String, String>> syncMenus(List<TMenu> menus) {

        Map<String, Map<String, String>> result = new HashMap<String, Map<String, String>>();
        result.put("insert", new HashMap<String, String>());
        result.put("update", new HashMap<String, String>());
        result.put("delete", new HashMap<String, String>());

        Map<String, String> ids = this.baseMapper.selectAllIdMap();

        for (TMenu menu : menus) {
            if (ids.get(menu.getId()) == null) { // 全新的路由
                this.baseMapper.insert(menu);
                result.get("insert").put(menu.getId(), menu.getName());
            } else { // 已存在的
                this.baseMapper.updateById(menu);
                result.get("update").put(menu.getId(), menu.getName());
                ids.remove(menu.getId()); // 操作完成，移除，最终剩下的则为前端路由移除的
            }
        }
        // 剩下的部分为前端路由移除了，后端没有移除的藏数据，逻辑删除即可
        for (String id : ids.keySet()) {
            try {
                TMenu menu = getEntityClass().newInstance();
                menu.setId((String)id);
                this.baseMapper.deleteByIdWithFill(menu);
                result.get("delete").put(id, ids.get(id));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Map<String, Set<String>> findAllRouterRoles() {
        Map<String, Set<String>> result = new HashMap<String, Set<String>>();
        List<RMenuRole> menuRoles = this.menuRoleRepository.findAll();
        for (RMenuRole menuRole : menuRoles) {
            Set<String> roles = result.get(menuRole.getMenuId());
            if (roles == null) {
                roles = new HashSet<String>();
            }
            roles.add(menuRole.getRoleId());
            result.put(menuRole.getMenuId(), roles);
        }
        return result;
    }
}
