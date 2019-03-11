package cn.umisoft.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * 用户分组-角色分组，中间表
 * </p>
 *
 * @author hujie@umisoft.cn
 * @since 2019-01-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("R_USER_ROLE_GROUP")
@Entity
@Table(name = "R_USER_ROLE_GROUP")
@Where(clause = "deleted = 0")
public class RUserGroupRoleGroup extends UmiEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户分组ID
     */
    @TableField("USER_GROUP_ID")
    @Column(name = "USER_GROUP_ID")
    private String userGroupId;

    /**
     * 角色角色ID
     */
    @TableField("ROLE_GROUP_ID")
    @Column(name = "ROLE_GROUP_ID")
    private String roleGroupId;

}
