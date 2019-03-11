package cn.umisoft.admin.controller;

import cn.umisoft.admin.entity.RUserGroupRoleGroup;
import cn.umisoft.admin.service.IRUserGroupRoleGroupService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户分组-角色分组，中间表 前端控制器
 * </p>
 *
 * @author hujie@umisoft.cn
 * @since 2019-01-16
 */
@RestController
@RequestMapping("/admin/user-group-role-group")
public class RUserGroupRoleGroupController extends UmiRController<IRUserGroupRoleGroupService, RUserGroupRoleGroup>{
    public RUserGroupRoleGroupController() {
        this.mappingFields.add("userGroupId");
        this.mappingFields.add("roleGroupId");
    }
}
