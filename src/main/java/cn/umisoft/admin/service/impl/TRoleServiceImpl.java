package cn.umisoft.admin.service.impl;

import cn.umisoft.admin.entity.TRole;
import cn.umisoft.admin.mapper.TRoleMapper;
import cn.umisoft.admin.repository.TRoleRepository;
import cn.umisoft.admin.service.ITRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author hujie@umisoft.cn
 * @since 2019-01-21
 */
@Service
public class TRoleServiceImpl extends UmiServiceImpl<TRoleMapper, TRoleRepository, TRole> implements ITRoleService {
    @Override
    public List<TRole> findAllByDeptId(String deptId) {
        return this.baseRepository.findAllByDeptId(deptId);
    }
    @Override
    public List<TRole> findAllByUserId(String userId) {
        return this.baseRepository.findAllByUserId(userId);
    }

    @Override
    public List<TRole> findAllByMenuId(String menuId) {
        return this.baseRepository.findAllByMenuId(menuId);
    }
}
