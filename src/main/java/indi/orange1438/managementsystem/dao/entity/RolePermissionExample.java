/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 */
public class RolePermissionExample {
    // 排序字段
    protected String orderByClause;

    // 过滤重复数据
    protected boolean distinct;

    // 查询条件
    protected List<Criteria> oredCriteria;

    /** 
     * 构造查询条件
     */
    public RolePermissionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /** 
     * 设置排序字段
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /** 
     * 获取排序字段
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /** 
     * 设置过滤重复数据
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /** 
     * 是否过滤重复数据
     */
    public boolean isDistinct() {
        return distinct;
    }

    /** 
     * 获取当前的查询条件实例
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /** 
     * 增加或者的查询条件,用于构建或者查询
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /** 
     * 创建一个新的或者查询条件
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /** 
     * 创建一个查询条件
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /** 
     * 内部构建查询条件对象
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /** 
     * 清除查询条件
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 角色权限表sys_role_permission的基本动态SQL对象.
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRolePermissionIdIsNull() {
            addCriterion("ROLE_PERMISSION_ID is null");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdIsNotNull() {
            addCriterion("ROLE_PERMISSION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdEqualTo(Long value) {
            addCriterion("ROLE_PERMISSION_ID =", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdNotEqualTo(Long value) {
            addCriterion("ROLE_PERMISSION_ID <>", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdGreaterThan(Long value) {
            addCriterion("ROLE_PERMISSION_ID >", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ROLE_PERMISSION_ID >=", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdLessThan(Long value) {
            addCriterion("ROLE_PERMISSION_ID <", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdLessThanOrEqualTo(Long value) {
            addCriterion("ROLE_PERMISSION_ID <=", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdIn(List<Long> values) {
            addCriterion("ROLE_PERMISSION_ID in", values, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdNotIn(List<Long> values) {
            addCriterion("ROLE_PERMISSION_ID not in", values, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdBetween(Long value1, Long value2) {
            addCriterion("ROLE_PERMISSION_ID between", value1, value2, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdNotBetween(Long value1, Long value2) {
            addCriterion("ROLE_PERMISSION_ID not between", value1, value2, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Long value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Long value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Long value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Long value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Long value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Long> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Long> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Long value1, Long value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Long value1, Long value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNull() {
            addCriterion("PERMISSION_ID is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNotNull() {
            addCriterion("PERMISSION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdEqualTo(Long value) {
            addCriterion("PERMISSION_ID =", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotEqualTo(Long value) {
            addCriterion("PERMISSION_ID <>", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThan(Long value) {
            addCriterion("PERMISSION_ID >", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PERMISSION_ID >=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThan(Long value) {
            addCriterion("PERMISSION_ID <", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThanOrEqualTo(Long value) {
            addCriterion("PERMISSION_ID <=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIn(List<Long> values) {
            addCriterion("PERMISSION_ID in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotIn(List<Long> values) {
            addCriterion("PERMISSION_ID not in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdBetween(Long value1, Long value2) {
            addCriterion("PERMISSION_ID between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotBetween(Long value1, Long value2) {
            addCriterion("PERMISSION_ID not between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andAddRightsIsNull() {
            addCriterion("ADD_RIGHTS is null");
            return (Criteria) this;
        }

        public Criteria andAddRightsIsNotNull() {
            addCriterion("ADD_RIGHTS is not null");
            return (Criteria) this;
        }

        public Criteria andAddRightsEqualTo(Boolean value) {
            addCriterion("ADD_RIGHTS =", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsNotEqualTo(Boolean value) {
            addCriterion("ADD_RIGHTS <>", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsGreaterThan(Boolean value) {
            addCriterion("ADD_RIGHTS >", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ADD_RIGHTS >=", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsLessThan(Boolean value) {
            addCriterion("ADD_RIGHTS <", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsLessThanOrEqualTo(Boolean value) {
            addCriterion("ADD_RIGHTS <=", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsIn(List<Boolean> values) {
            addCriterion("ADD_RIGHTS in", values, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsNotIn(List<Boolean> values) {
            addCriterion("ADD_RIGHTS not in", values, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsBetween(Boolean value1, Boolean value2) {
            addCriterion("ADD_RIGHTS between", value1, value2, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ADD_RIGHTS not between", value1, value2, "addRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsIsNull() {
            addCriterion("DELETE_RIGHTS is null");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsIsNotNull() {
            addCriterion("DELETE_RIGHTS is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsEqualTo(Boolean value) {
            addCriterion("DELETE_RIGHTS =", value, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsNotEqualTo(Boolean value) {
            addCriterion("DELETE_RIGHTS <>", value, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsGreaterThan(Boolean value) {
            addCriterion("DELETE_RIGHTS >", value, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("DELETE_RIGHTS >=", value, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsLessThan(Boolean value) {
            addCriterion("DELETE_RIGHTS <", value, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsLessThanOrEqualTo(Boolean value) {
            addCriterion("DELETE_RIGHTS <=", value, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsIn(List<Boolean> values) {
            addCriterion("DELETE_RIGHTS in", values, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsNotIn(List<Boolean> values) {
            addCriterion("DELETE_RIGHTS not in", values, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsBetween(Boolean value1, Boolean value2) {
            addCriterion("DELETE_RIGHTS between", value1, value2, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("DELETE_RIGHTS not between", value1, value2, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsIsNull() {
            addCriterion("EDIT_RIGHTS is null");
            return (Criteria) this;
        }

        public Criteria andEditRightsIsNotNull() {
            addCriterion("EDIT_RIGHTS is not null");
            return (Criteria) this;
        }

        public Criteria andEditRightsEqualTo(Boolean value) {
            addCriterion("EDIT_RIGHTS =", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsNotEqualTo(Boolean value) {
            addCriterion("EDIT_RIGHTS <>", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsGreaterThan(Boolean value) {
            addCriterion("EDIT_RIGHTS >", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("EDIT_RIGHTS >=", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsLessThan(Boolean value) {
            addCriterion("EDIT_RIGHTS <", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsLessThanOrEqualTo(Boolean value) {
            addCriterion("EDIT_RIGHTS <=", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsIn(List<Boolean> values) {
            addCriterion("EDIT_RIGHTS in", values, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsNotIn(List<Boolean> values) {
            addCriterion("EDIT_RIGHTS not in", values, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsBetween(Boolean value1, Boolean value2) {
            addCriterion("EDIT_RIGHTS between", value1, value2, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("EDIT_RIGHTS not between", value1, value2, "editRights");
            return (Criteria) this;
        }

        public Criteria andViewRightsIsNull() {
            addCriterion("VIEW_RIGHTS is null");
            return (Criteria) this;
        }

        public Criteria andViewRightsIsNotNull() {
            addCriterion("VIEW_RIGHTS is not null");
            return (Criteria) this;
        }

        public Criteria andViewRightsEqualTo(Boolean value) {
            addCriterion("VIEW_RIGHTS =", value, "viewRights");
            return (Criteria) this;
        }

        public Criteria andViewRightsNotEqualTo(Boolean value) {
            addCriterion("VIEW_RIGHTS <>", value, "viewRights");
            return (Criteria) this;
        }

        public Criteria andViewRightsGreaterThan(Boolean value) {
            addCriterion("VIEW_RIGHTS >", value, "viewRights");
            return (Criteria) this;
        }

        public Criteria andViewRightsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("VIEW_RIGHTS >=", value, "viewRights");
            return (Criteria) this;
        }

        public Criteria andViewRightsLessThan(Boolean value) {
            addCriterion("VIEW_RIGHTS <", value, "viewRights");
            return (Criteria) this;
        }

        public Criteria andViewRightsLessThanOrEqualTo(Boolean value) {
            addCriterion("VIEW_RIGHTS <=", value, "viewRights");
            return (Criteria) this;
        }

        public Criteria andViewRightsIn(List<Boolean> values) {
            addCriterion("VIEW_RIGHTS in", values, "viewRights");
            return (Criteria) this;
        }

        public Criteria andViewRightsNotIn(List<Boolean> values) {
            addCriterion("VIEW_RIGHTS not in", values, "viewRights");
            return (Criteria) this;
        }

        public Criteria andViewRightsBetween(Boolean value1, Boolean value2) {
            addCriterion("VIEW_RIGHTS between", value1, value2, "viewRights");
            return (Criteria) this;
        }

        public Criteria andViewRightsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("VIEW_RIGHTS not between", value1, value2, "viewRights");
            return (Criteria) this;
        }

        public Criteria andImportRightsIsNull() {
            addCriterion("IMPORT_RIGHTS is null");
            return (Criteria) this;
        }

        public Criteria andImportRightsIsNotNull() {
            addCriterion("IMPORT_RIGHTS is not null");
            return (Criteria) this;
        }

        public Criteria andImportRightsEqualTo(Boolean value) {
            addCriterion("IMPORT_RIGHTS =", value, "importRights");
            return (Criteria) this;
        }

        public Criteria andImportRightsNotEqualTo(Boolean value) {
            addCriterion("IMPORT_RIGHTS <>", value, "importRights");
            return (Criteria) this;
        }

        public Criteria andImportRightsGreaterThan(Boolean value) {
            addCriterion("IMPORT_RIGHTS >", value, "importRights");
            return (Criteria) this;
        }

        public Criteria andImportRightsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IMPORT_RIGHTS >=", value, "importRights");
            return (Criteria) this;
        }

        public Criteria andImportRightsLessThan(Boolean value) {
            addCriterion("IMPORT_RIGHTS <", value, "importRights");
            return (Criteria) this;
        }

        public Criteria andImportRightsLessThanOrEqualTo(Boolean value) {
            addCriterion("IMPORT_RIGHTS <=", value, "importRights");
            return (Criteria) this;
        }

        public Criteria andImportRightsIn(List<Boolean> values) {
            addCriterion("IMPORT_RIGHTS in", values, "importRights");
            return (Criteria) this;
        }

        public Criteria andImportRightsNotIn(List<Boolean> values) {
            addCriterion("IMPORT_RIGHTS not in", values, "importRights");
            return (Criteria) this;
        }

        public Criteria andImportRightsBetween(Boolean value1, Boolean value2) {
            addCriterion("IMPORT_RIGHTS between", value1, value2, "importRights");
            return (Criteria) this;
        }

        public Criteria andImportRightsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IMPORT_RIGHTS not between", value1, value2, "importRights");
            return (Criteria) this;
        }

        public Criteria andExportRightsIsNull() {
            addCriterion("EXPORT_RIGHTS is null");
            return (Criteria) this;
        }

        public Criteria andExportRightsIsNotNull() {
            addCriterion("EXPORT_RIGHTS is not null");
            return (Criteria) this;
        }

        public Criteria andExportRightsEqualTo(Boolean value) {
            addCriterion("EXPORT_RIGHTS =", value, "exportRights");
            return (Criteria) this;
        }

        public Criteria andExportRightsNotEqualTo(Boolean value) {
            addCriterion("EXPORT_RIGHTS <>", value, "exportRights");
            return (Criteria) this;
        }

        public Criteria andExportRightsGreaterThan(Boolean value) {
            addCriterion("EXPORT_RIGHTS >", value, "exportRights");
            return (Criteria) this;
        }

        public Criteria andExportRightsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("EXPORT_RIGHTS >=", value, "exportRights");
            return (Criteria) this;
        }

        public Criteria andExportRightsLessThan(Boolean value) {
            addCriterion("EXPORT_RIGHTS <", value, "exportRights");
            return (Criteria) this;
        }

        public Criteria andExportRightsLessThanOrEqualTo(Boolean value) {
            addCriterion("EXPORT_RIGHTS <=", value, "exportRights");
            return (Criteria) this;
        }

        public Criteria andExportRightsIn(List<Boolean> values) {
            addCriterion("EXPORT_RIGHTS in", values, "exportRights");
            return (Criteria) this;
        }

        public Criteria andExportRightsNotIn(List<Boolean> values) {
            addCriterion("EXPORT_RIGHTS not in", values, "exportRights");
            return (Criteria) this;
        }

        public Criteria andExportRightsBetween(Boolean value1, Boolean value2) {
            addCriterion("EXPORT_RIGHTS between", value1, value2, "exportRights");
            return (Criteria) this;
        }

        public Criteria andExportRightsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("EXPORT_RIGHTS not between", value1, value2, "exportRights");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("CREATOR is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("CREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("CREATOR =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("CREATOR <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("CREATOR >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("CREATOR >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("CREATOR <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("CREATOR <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("CREATOR like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("CREATOR not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("CREATOR in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("CREATOR not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("CREATOR between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("CREATOR not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("MODIFY_TIME =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("MODIFY_TIME <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("MODIFY_TIME >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("MODIFY_TIME <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("MODIFY_TIME in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("MODIFY_TIME not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("MODIFIER is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("MODIFIER is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("MODIFIER =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("MODIFIER <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("MODIFIER >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIER >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("MODIFIER <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("MODIFIER <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("MODIFIER like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("MODIFIER not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("MODIFIER in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("MODIFIER not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("MODIFIER between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("MODIFIER not between", value1, value2, "modifier");
            return (Criteria) this;
        }
    }

    /**
     * 角色权限表sys_role_permission的映射实体
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 角色权限表sys_role_permission的动态SQL对象.
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}