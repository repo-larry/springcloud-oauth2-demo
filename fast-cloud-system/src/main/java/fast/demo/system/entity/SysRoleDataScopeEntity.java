package fast.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import fast.demo.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色数据权限
 *
 * @author 阿沐 babamu@126.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_data_scope")
public class SysRoleDataScopeEntity extends BaseEntity {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 机构ID
     */
    private Long orgId;

}