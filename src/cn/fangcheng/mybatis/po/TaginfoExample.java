package cn.fangcheng.mybatis.po;

import java.util.ArrayList;
import java.util.List;

public class TaginfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaginfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andTagIdIsNull() {
            addCriterion("tag_id is null");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNotNull() {
            addCriterion("tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andTagIdEqualTo(Integer value) {
            addCriterion("tag_id =", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotEqualTo(Integer value) {
            addCriterion("tag_id <>", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThan(Integer value) {
            addCriterion("tag_id >", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag_id >=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThan(Integer value) {
            addCriterion("tag_id <", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThanOrEqualTo(Integer value) {
            addCriterion("tag_id <=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdIn(List<Integer> values) {
            addCriterion("tag_id in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotIn(List<Integer> values) {
            addCriterion("tag_id not in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdBetween(Integer value1, Integer value2) {
            addCriterion("tag_id between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tag_id not between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNull() {
            addCriterion("tag_name is null");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNotNull() {
            addCriterion("tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andTagNameEqualTo(String value) {
            addCriterion("tag_name =", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotEqualTo(String value) {
            addCriterion("tag_name <>", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThan(String value) {
            addCriterion("tag_name >", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("tag_name >=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThan(String value) {
            addCriterion("tag_name <", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThanOrEqualTo(String value) {
            addCriterion("tag_name <=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLike(String value) {
            addCriterion("tag_name like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotLike(String value) {
            addCriterion("tag_name not like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameIn(List<String> values) {
            addCriterion("tag_name in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotIn(List<String> values) {
            addCriterion("tag_name not in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameBetween(String value1, String value2) {
            addCriterion("tag_name between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotBetween(String value1, String value2) {
            addCriterion("tag_name not between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagDeepIsNull() {
            addCriterion("tag_deep is null");
            return (Criteria) this;
        }

        public Criteria andTagDeepIsNotNull() {
            addCriterion("tag_deep is not null");
            return (Criteria) this;
        }

        public Criteria andTagDeepEqualTo(Byte value) {
            addCriterion("tag_deep =", value, "tagDeep");
            return (Criteria) this;
        }

        public Criteria andTagDeepNotEqualTo(Byte value) {
            addCriterion("tag_deep <>", value, "tagDeep");
            return (Criteria) this;
        }

        public Criteria andTagDeepGreaterThan(Byte value) {
            addCriterion("tag_deep >", value, "tagDeep");
            return (Criteria) this;
        }

        public Criteria andTagDeepGreaterThanOrEqualTo(Byte value) {
            addCriterion("tag_deep >=", value, "tagDeep");
            return (Criteria) this;
        }

        public Criteria andTagDeepLessThan(Byte value) {
            addCriterion("tag_deep <", value, "tagDeep");
            return (Criteria) this;
        }

        public Criteria andTagDeepLessThanOrEqualTo(Byte value) {
            addCriterion("tag_deep <=", value, "tagDeep");
            return (Criteria) this;
        }

        public Criteria andTagDeepIn(List<Byte> values) {
            addCriterion("tag_deep in", values, "tagDeep");
            return (Criteria) this;
        }

        public Criteria andTagDeepNotIn(List<Byte> values) {
            addCriterion("tag_deep not in", values, "tagDeep");
            return (Criteria) this;
        }

        public Criteria andTagDeepBetween(Byte value1, Byte value2) {
            addCriterion("tag_deep between", value1, value2, "tagDeep");
            return (Criteria) this;
        }

        public Criteria andTagDeepNotBetween(Byte value1, Byte value2) {
            addCriterion("tag_deep not between", value1, value2, "tagDeep");
            return (Criteria) this;
        }

        public Criteria andTagIdParentIsNull() {
            addCriterion("tag_id_parent is null");
            return (Criteria) this;
        }

        public Criteria andTagIdParentIsNotNull() {
            addCriterion("tag_id_parent is not null");
            return (Criteria) this;
        }

        public Criteria andTagIdParentEqualTo(Integer value) {
            addCriterion("tag_id_parent =", value, "tagIdParent");
            return (Criteria) this;
        }

        public Criteria andTagIdParentNotEqualTo(Integer value) {
            addCriterion("tag_id_parent <>", value, "tagIdParent");
            return (Criteria) this;
        }

        public Criteria andTagIdParentGreaterThan(Integer value) {
            addCriterion("tag_id_parent >", value, "tagIdParent");
            return (Criteria) this;
        }

        public Criteria andTagIdParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag_id_parent >=", value, "tagIdParent");
            return (Criteria) this;
        }

        public Criteria andTagIdParentLessThan(Integer value) {
            addCriterion("tag_id_parent <", value, "tagIdParent");
            return (Criteria) this;
        }

        public Criteria andTagIdParentLessThanOrEqualTo(Integer value) {
            addCriterion("tag_id_parent <=", value, "tagIdParent");
            return (Criteria) this;
        }

        public Criteria andTagIdParentIn(List<Integer> values) {
            addCriterion("tag_id_parent in", values, "tagIdParent");
            return (Criteria) this;
        }

        public Criteria andTagIdParentNotIn(List<Integer> values) {
            addCriterion("tag_id_parent not in", values, "tagIdParent");
            return (Criteria) this;
        }

        public Criteria andTagIdParentBetween(Integer value1, Integer value2) {
            addCriterion("tag_id_parent between", value1, value2, "tagIdParent");
            return (Criteria) this;
        }

        public Criteria andTagIdParentNotBetween(Integer value1, Integer value2) {
            addCriterion("tag_id_parent not between", value1, value2, "tagIdParent");
            return (Criteria) this;
        }

        public Criteria andTagTypeIsNull() {
            addCriterion("tag_type is null");
            return (Criteria) this;
        }

        public Criteria andTagTypeIsNotNull() {
            addCriterion("tag_type is not null");
            return (Criteria) this;
        }

        public Criteria andTagTypeEqualTo(Byte value) {
            addCriterion("tag_type =", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeNotEqualTo(Byte value) {
            addCriterion("tag_type <>", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeGreaterThan(Byte value) {
            addCriterion("tag_type >", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("tag_type >=", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeLessThan(Byte value) {
            addCriterion("tag_type <", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeLessThanOrEqualTo(Byte value) {
            addCriterion("tag_type <=", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeIn(List<Byte> values) {
            addCriterion("tag_type in", values, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeNotIn(List<Byte> values) {
            addCriterion("tag_type not in", values, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeBetween(Byte value1, Byte value2) {
            addCriterion("tag_type between", value1, value2, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("tag_type not between", value1, value2, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagGroupIdIsNull() {
            addCriterion("tag_group_id is null");
            return (Criteria) this;
        }

        public Criteria andTagGroupIdIsNotNull() {
            addCriterion("tag_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andTagGroupIdEqualTo(Integer value) {
            addCriterion("tag_group_id =", value, "tagGroupId");
            return (Criteria) this;
        }

        public Criteria andTagGroupIdNotEqualTo(Integer value) {
            addCriterion("tag_group_id <>", value, "tagGroupId");
            return (Criteria) this;
        }

        public Criteria andTagGroupIdGreaterThan(Integer value) {
            addCriterion("tag_group_id >", value, "tagGroupId");
            return (Criteria) this;
        }

        public Criteria andTagGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag_group_id >=", value, "tagGroupId");
            return (Criteria) this;
        }

        public Criteria andTagGroupIdLessThan(Integer value) {
            addCriterion("tag_group_id <", value, "tagGroupId");
            return (Criteria) this;
        }

        public Criteria andTagGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("tag_group_id <=", value, "tagGroupId");
            return (Criteria) this;
        }

        public Criteria andTagGroupIdIn(List<Integer> values) {
            addCriterion("tag_group_id in", values, "tagGroupId");
            return (Criteria) this;
        }

        public Criteria andTagGroupIdNotIn(List<Integer> values) {
            addCriterion("tag_group_id not in", values, "tagGroupId");
            return (Criteria) this;
        }

        public Criteria andTagGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("tag_group_id between", value1, value2, "tagGroupId");
            return (Criteria) this;
        }

        public Criteria andTagGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tag_group_id not between", value1, value2, "tagGroupId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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