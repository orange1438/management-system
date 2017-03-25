/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 */
public class PermissionExample {
    // 排序字段
    protected String orderByClause;

    // 过滤重复数据
    protected boolean distinct;

    // 查询条件
    protected List<Criteria> oredCriteria;

    /** 
     * 构造查询条件
     */
    public PermissionExample() {
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
     * 权限点许可表sys_permission的基本动态SQL对象.
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

        public Criteria andPermissionNameIsNull() {
            addCriterion("PERMISSION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNotNull() {
            addCriterion("PERMISSION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameEqualTo(String value) {
            addCriterion("PERMISSION_NAME =", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotEqualTo(String value) {
            addCriterion("PERMISSION_NAME <>", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThan(String value) {
            addCriterion("PERMISSION_NAME >", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThanOrEqualTo(String value) {
            addCriterion("PERMISSION_NAME >=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThan(String value) {
            addCriterion("PERMISSION_NAME <", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThanOrEqualTo(String value) {
            addCriterion("PERMISSION_NAME <=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLike(String value) {
            addCriterion("PERMISSION_NAME like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotLike(String value) {
            addCriterion("PERMISSION_NAME not like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIn(List<String> values) {
            addCriterion("PERMISSION_NAME in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotIn(List<String> values) {
            addCriterion("PERMISSION_NAME not in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameBetween(String value1, String value2) {
            addCriterion("PERMISSION_NAME between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotBetween(String value1, String value2) {
            addCriterion("PERMISSION_NAME not between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
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

        public Criteria andAddTitleIsNull() {
            addCriterion("ADD_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andAddTitleIsNotNull() {
            addCriterion("ADD_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andAddTitleEqualTo(String value) {
            addCriterion("ADD_TITLE =", value, "addTitle");
            return (Criteria) this;
        }

        public Criteria andAddTitleNotEqualTo(String value) {
            addCriterion("ADD_TITLE <>", value, "addTitle");
            return (Criteria) this;
        }

        public Criteria andAddTitleGreaterThan(String value) {
            addCriterion("ADD_TITLE >", value, "addTitle");
            return (Criteria) this;
        }

        public Criteria andAddTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ADD_TITLE >=", value, "addTitle");
            return (Criteria) this;
        }

        public Criteria andAddTitleLessThan(String value) {
            addCriterion("ADD_TITLE <", value, "addTitle");
            return (Criteria) this;
        }

        public Criteria andAddTitleLessThanOrEqualTo(String value) {
            addCriterion("ADD_TITLE <=", value, "addTitle");
            return (Criteria) this;
        }

        public Criteria andAddTitleLike(String value) {
            addCriterion("ADD_TITLE like", value, "addTitle");
            return (Criteria) this;
        }

        public Criteria andAddTitleNotLike(String value) {
            addCriterion("ADD_TITLE not like", value, "addTitle");
            return (Criteria) this;
        }

        public Criteria andAddTitleIn(List<String> values) {
            addCriterion("ADD_TITLE in", values, "addTitle");
            return (Criteria) this;
        }

        public Criteria andAddTitleNotIn(List<String> values) {
            addCriterion("ADD_TITLE not in", values, "addTitle");
            return (Criteria) this;
        }

        public Criteria andAddTitleBetween(String value1, String value2) {
            addCriterion("ADD_TITLE between", value1, value2, "addTitle");
            return (Criteria) this;
        }

        public Criteria andAddTitleNotBetween(String value1, String value2) {
            addCriterion("ADD_TITLE not between", value1, value2, "addTitle");
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

        public Criteria andDeleteTitleIsNull() {
            addCriterion("DELETE_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTitleIsNotNull() {
            addCriterion("DELETE_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTitleEqualTo(String value) {
            addCriterion("DELETE_TITLE =", value, "deleteTitle");
            return (Criteria) this;
        }

        public Criteria andDeleteTitleNotEqualTo(String value) {
            addCriterion("DELETE_TITLE <>", value, "deleteTitle");
            return (Criteria) this;
        }

        public Criteria andDeleteTitleGreaterThan(String value) {
            addCriterion("DELETE_TITLE >", value, "deleteTitle");
            return (Criteria) this;
        }

        public Criteria andDeleteTitleGreaterThanOrEqualTo(String value) {
            addCriterion("DELETE_TITLE >=", value, "deleteTitle");
            return (Criteria) this;
        }

        public Criteria andDeleteTitleLessThan(String value) {
            addCriterion("DELETE_TITLE <", value, "deleteTitle");
            return (Criteria) this;
        }

        public Criteria andDeleteTitleLessThanOrEqualTo(String value) {
            addCriterion("DELETE_TITLE <=", value, "deleteTitle");
            return (Criteria) this;
        }

        public Criteria andDeleteTitleLike(String value) {
            addCriterion("DELETE_TITLE like", value, "deleteTitle");
            return (Criteria) this;
        }

        public Criteria andDeleteTitleNotLike(String value) {
            addCriterion("DELETE_TITLE not like", value, "deleteTitle");
            return (Criteria) this;
        }

        public Criteria andDeleteTitleIn(List<String> values) {
            addCriterion("DELETE_TITLE in", values, "deleteTitle");
            return (Criteria) this;
        }

        public Criteria andDeleteTitleNotIn(List<String> values) {
            addCriterion("DELETE_TITLE not in", values, "deleteTitle");
            return (Criteria) this;
        }

        public Criteria andDeleteTitleBetween(String value1, String value2) {
            addCriterion("DELETE_TITLE between", value1, value2, "deleteTitle");
            return (Criteria) this;
        }

        public Criteria andDeleteTitleNotBetween(String value1, String value2) {
            addCriterion("DELETE_TITLE not between", value1, value2, "deleteTitle");
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

        public Criteria andEditTitleIsNull() {
            addCriterion("EDIT_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andEditTitleIsNotNull() {
            addCriterion("EDIT_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andEditTitleEqualTo(String value) {
            addCriterion("EDIT_TITLE =", value, "editTitle");
            return (Criteria) this;
        }

        public Criteria andEditTitleNotEqualTo(String value) {
            addCriterion("EDIT_TITLE <>", value, "editTitle");
            return (Criteria) this;
        }

        public Criteria andEditTitleGreaterThan(String value) {
            addCriterion("EDIT_TITLE >", value, "editTitle");
            return (Criteria) this;
        }

        public Criteria andEditTitleGreaterThanOrEqualTo(String value) {
            addCriterion("EDIT_TITLE >=", value, "editTitle");
            return (Criteria) this;
        }

        public Criteria andEditTitleLessThan(String value) {
            addCriterion("EDIT_TITLE <", value, "editTitle");
            return (Criteria) this;
        }

        public Criteria andEditTitleLessThanOrEqualTo(String value) {
            addCriterion("EDIT_TITLE <=", value, "editTitle");
            return (Criteria) this;
        }

        public Criteria andEditTitleLike(String value) {
            addCriterion("EDIT_TITLE like", value, "editTitle");
            return (Criteria) this;
        }

        public Criteria andEditTitleNotLike(String value) {
            addCriterion("EDIT_TITLE not like", value, "editTitle");
            return (Criteria) this;
        }

        public Criteria andEditTitleIn(List<String> values) {
            addCriterion("EDIT_TITLE in", values, "editTitle");
            return (Criteria) this;
        }

        public Criteria andEditTitleNotIn(List<String> values) {
            addCriterion("EDIT_TITLE not in", values, "editTitle");
            return (Criteria) this;
        }

        public Criteria andEditTitleBetween(String value1, String value2) {
            addCriterion("EDIT_TITLE between", value1, value2, "editTitle");
            return (Criteria) this;
        }

        public Criteria andEditTitleNotBetween(String value1, String value2) {
            addCriterion("EDIT_TITLE not between", value1, value2, "editTitle");
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

        public Criteria andViewTitleIsNull() {
            addCriterion("VIEW_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andViewTitleIsNotNull() {
            addCriterion("VIEW_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andViewTitleEqualTo(String value) {
            addCriterion("VIEW_TITLE =", value, "viewTitle");
            return (Criteria) this;
        }

        public Criteria andViewTitleNotEqualTo(String value) {
            addCriterion("VIEW_TITLE <>", value, "viewTitle");
            return (Criteria) this;
        }

        public Criteria andViewTitleGreaterThan(String value) {
            addCriterion("VIEW_TITLE >", value, "viewTitle");
            return (Criteria) this;
        }

        public Criteria andViewTitleGreaterThanOrEqualTo(String value) {
            addCriterion("VIEW_TITLE >=", value, "viewTitle");
            return (Criteria) this;
        }

        public Criteria andViewTitleLessThan(String value) {
            addCriterion("VIEW_TITLE <", value, "viewTitle");
            return (Criteria) this;
        }

        public Criteria andViewTitleLessThanOrEqualTo(String value) {
            addCriterion("VIEW_TITLE <=", value, "viewTitle");
            return (Criteria) this;
        }

        public Criteria andViewTitleLike(String value) {
            addCriterion("VIEW_TITLE like", value, "viewTitle");
            return (Criteria) this;
        }

        public Criteria andViewTitleNotLike(String value) {
            addCriterion("VIEW_TITLE not like", value, "viewTitle");
            return (Criteria) this;
        }

        public Criteria andViewTitleIn(List<String> values) {
            addCriterion("VIEW_TITLE in", values, "viewTitle");
            return (Criteria) this;
        }

        public Criteria andViewTitleNotIn(List<String> values) {
            addCriterion("VIEW_TITLE not in", values, "viewTitle");
            return (Criteria) this;
        }

        public Criteria andViewTitleBetween(String value1, String value2) {
            addCriterion("VIEW_TITLE between", value1, value2, "viewTitle");
            return (Criteria) this;
        }

        public Criteria andViewTitleNotBetween(String value1, String value2) {
            addCriterion("VIEW_TITLE not between", value1, value2, "viewTitle");
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

        public Criteria andImportTitleIsNull() {
            addCriterion("IMPORT_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andImportTitleIsNotNull() {
            addCriterion("IMPORT_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andImportTitleEqualTo(String value) {
            addCriterion("IMPORT_TITLE =", value, "importTitle");
            return (Criteria) this;
        }

        public Criteria andImportTitleNotEqualTo(String value) {
            addCriterion("IMPORT_TITLE <>", value, "importTitle");
            return (Criteria) this;
        }

        public Criteria andImportTitleGreaterThan(String value) {
            addCriterion("IMPORT_TITLE >", value, "importTitle");
            return (Criteria) this;
        }

        public Criteria andImportTitleGreaterThanOrEqualTo(String value) {
            addCriterion("IMPORT_TITLE >=", value, "importTitle");
            return (Criteria) this;
        }

        public Criteria andImportTitleLessThan(String value) {
            addCriterion("IMPORT_TITLE <", value, "importTitle");
            return (Criteria) this;
        }

        public Criteria andImportTitleLessThanOrEqualTo(String value) {
            addCriterion("IMPORT_TITLE <=", value, "importTitle");
            return (Criteria) this;
        }

        public Criteria andImportTitleLike(String value) {
            addCriterion("IMPORT_TITLE like", value, "importTitle");
            return (Criteria) this;
        }

        public Criteria andImportTitleNotLike(String value) {
            addCriterion("IMPORT_TITLE not like", value, "importTitle");
            return (Criteria) this;
        }

        public Criteria andImportTitleIn(List<String> values) {
            addCriterion("IMPORT_TITLE in", values, "importTitle");
            return (Criteria) this;
        }

        public Criteria andImportTitleNotIn(List<String> values) {
            addCriterion("IMPORT_TITLE not in", values, "importTitle");
            return (Criteria) this;
        }

        public Criteria andImportTitleBetween(String value1, String value2) {
            addCriterion("IMPORT_TITLE between", value1, value2, "importTitle");
            return (Criteria) this;
        }

        public Criteria andImportTitleNotBetween(String value1, String value2) {
            addCriterion("IMPORT_TITLE not between", value1, value2, "importTitle");
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

        public Criteria andExportTitleIsNull() {
            addCriterion("EXPORT_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andExportTitleIsNotNull() {
            addCriterion("EXPORT_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andExportTitleEqualTo(String value) {
            addCriterion("EXPORT_TITLE =", value, "exportTitle");
            return (Criteria) this;
        }

        public Criteria andExportTitleNotEqualTo(String value) {
            addCriterion("EXPORT_TITLE <>", value, "exportTitle");
            return (Criteria) this;
        }

        public Criteria andExportTitleGreaterThan(String value) {
            addCriterion("EXPORT_TITLE >", value, "exportTitle");
            return (Criteria) this;
        }

        public Criteria andExportTitleGreaterThanOrEqualTo(String value) {
            addCriterion("EXPORT_TITLE >=", value, "exportTitle");
            return (Criteria) this;
        }

        public Criteria andExportTitleLessThan(String value) {
            addCriterion("EXPORT_TITLE <", value, "exportTitle");
            return (Criteria) this;
        }

        public Criteria andExportTitleLessThanOrEqualTo(String value) {
            addCriterion("EXPORT_TITLE <=", value, "exportTitle");
            return (Criteria) this;
        }

        public Criteria andExportTitleLike(String value) {
            addCriterion("EXPORT_TITLE like", value, "exportTitle");
            return (Criteria) this;
        }

        public Criteria andExportTitleNotLike(String value) {
            addCriterion("EXPORT_TITLE not like", value, "exportTitle");
            return (Criteria) this;
        }

        public Criteria andExportTitleIn(List<String> values) {
            addCriterion("EXPORT_TITLE in", values, "exportTitle");
            return (Criteria) this;
        }

        public Criteria andExportTitleNotIn(List<String> values) {
            addCriterion("EXPORT_TITLE not in", values, "exportTitle");
            return (Criteria) this;
        }

        public Criteria andExportTitleBetween(String value1, String value2) {
            addCriterion("EXPORT_TITLE between", value1, value2, "exportTitle");
            return (Criteria) this;
        }

        public Criteria andExportTitleNotBetween(String value1, String value2) {
            addCriterion("EXPORT_TITLE not between", value1, value2, "exportTitle");
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
     * 权限点许可表sys_permission的映射实体
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 权限点许可表sys_permission的动态SQL对象.
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