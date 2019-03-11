package cn.umisoft.admin.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @description: 事实表实体超类
 * @author: hujie@umisoft.cn
 * @date: 2019/1/21 10:51 AM
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@MappedSuperclass
public class UmiEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.UUID)
    @Id
    @Column(name = "ID", unique = true, length = 60)
    private String id;

    /**
     * 是否删除
     */
    @TableField(value = "DELETED", fill = FieldFill.INSERT)
    @TableLogic
    @JSONField(serialize = false)
    @Column(name = "DELETED")
    private Integer deleted;

    /**
     * 创建人
     */
    @TableField(value = "CREATED_BY", fill = FieldFill.INSERT)
    @Column(name = "CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField(value = "CREATED_DATE", fill = FieldFill.INSERT)
    @Column(name = "CREATED_DATE")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    /**
     * 最后修改人，初始时与创建人相同
     */
    @TableField(value = "MODIFIED_BY", fill = FieldFill.UPDATE)
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    /**
     * 最后修改事件，初始时与创建时间相同
     */
    @TableField(value = "MODIFIED_DATE", fill = FieldFill.UPDATE)
    @Column(name = "MODIFIED_DATE")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedDate;
}
