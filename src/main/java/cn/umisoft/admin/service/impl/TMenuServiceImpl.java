package cn.umisoft.admin.service.impl;

import cn.umisoft.admin.entity.TMenu;
import cn.umisoft.admin.mapper.TMenuMapper;
import cn.umisoft.admin.repository.TMenuRepository;
import cn.umisoft.admin.service.ITMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Override
    public List<TMenu> findAllByRoleId(String roleId) {
        return this.baseRepository.findAllByRoleId(roleId);
    }
}
