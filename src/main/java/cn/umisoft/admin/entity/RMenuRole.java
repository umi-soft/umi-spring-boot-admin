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
 * 菜单-角色中间表
 * </p>
 *
 * @author hujie@umisoft.cn
 * @since 2019-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("R_MENU_ROLE")
@Entity
@Table(name = "R_MENU_ROLE")
@Where(clause = "deleted = 0")
public class RMenuRole extends UmiEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableField("MENU_ID")
    @Column(name = "MENU_ID")
    private String menuId;

    /**
     * 角色ID
     */
    @TableField("ROLE_ID")
    @Column(name = "ROLE_ID")
    private String roleId;
}
