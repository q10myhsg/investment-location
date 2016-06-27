package cn.fangcheng.mybatis.po;

import java.util.ArrayList;
import java.util.List;

public class MallDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallDataExample() {
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

        public Criteria andMallIdIsNull() {
            addCriterion("mall_id is null");
            return (Criteria) this;
        }

        public Criteria andMallIdIsNotNull() {
            addCriterion("mall_id is not null");
            return (Criteria) this;
        }

        public Criteria andMallIdEqualTo(Integer value) {
            addCriterion("mall_id =", value, "mallId");
            return (Criteria) this;
        }

        public Criteria andMallIdNotEqualTo(Integer value) {
            addCriterion("mall_id <>", value, "mallId");
            return (Criteria) this;
        }

        public Criteria andMallIdGreaterThan(Integer value) {
            addCriterion("mall_id >", value, "mallId");
            return (Criteria) this;
        }

        public Criteria andMallIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mall_id >=", value, "mallId");
            return (Criteria) this;
        }

        public Criteria andMallIdLessThan(Integer value) {
            addCriterion("mall_id <", value, "mallId");
            return (Criteria) this;
        }

        public Criteria andMallIdLessThanOrEqualTo(Integer value) {
            addCriterion("mall_id <=", value, "mallId");
            return (Criteria) this;
        }

        public Criteria andMallIdIn(List<Integer> values) {
            addCriterion("mall_id in", values, "mallId");
            return (Criteria) this;
        }

        public Criteria andMallIdNotIn(List<Integer> values) {
            addCriterion("mall_id not in", values, "mallId");
            return (Criteria) this;
        }

        public Criteria andMallIdBetween(Integer value1, Integer value2) {
            addCriterion("mall_id between", value1, value2, "mallId");
            return (Criteria) this;
        }

        public Criteria andMallIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mall_id not between", value1, value2, "mallId");
            return (Criteria) this;
        }

        public Criteria andRes1IsNull() {
            addCriterion("res_1 is null");
            return (Criteria) this;
        }

        public Criteria andRes1IsNotNull() {
            addCriterion("res_1 is not null");
            return (Criteria) this;
        }

        public Criteria andRes1EqualTo(Integer value) {
            addCriterion("res_1 =", value, "res1");
            return (Criteria) this;
        }

        public Criteria andRes1NotEqualTo(Integer value) {
            addCriterion("res_1 <>", value, "res1");
            return (Criteria) this;
        }

        public Criteria andRes1GreaterThan(Integer value) {
            addCriterion("res_1 >", value, "res1");
            return (Criteria) this;
        }

        public Criteria andRes1GreaterThanOrEqualTo(Integer value) {
            addCriterion("res_1 >=", value, "res1");
            return (Criteria) this;
        }

        public Criteria andRes1LessThan(Integer value) {
            addCriterion("res_1 <", value, "res1");
            return (Criteria) this;
        }

        public Criteria andRes1LessThanOrEqualTo(Integer value) {
            addCriterion("res_1 <=", value, "res1");
            return (Criteria) this;
        }

        public Criteria andRes1In(List<Integer> values) {
            addCriterion("res_1 in", values, "res1");
            return (Criteria) this;
        }

        public Criteria andRes1NotIn(List<Integer> values) {
            addCriterion("res_1 not in", values, "res1");
            return (Criteria) this;
        }

        public Criteria andRes1Between(Integer value1, Integer value2) {
            addCriterion("res_1 between", value1, value2, "res1");
            return (Criteria) this;
        }

        public Criteria andRes1NotBetween(Integer value1, Integer value2) {
            addCriterion("res_1 not between", value1, value2, "res1");
            return (Criteria) this;
        }

        public Criteria andRes3IsNull() {
            addCriterion("res_3 is null");
            return (Criteria) this;
        }

        public Criteria andRes3IsNotNull() {
            addCriterion("res_3 is not null");
            return (Criteria) this;
        }

        public Criteria andRes3EqualTo(Integer value) {
            addCriterion("res_3 =", value, "res3");
            return (Criteria) this;
        }

        public Criteria andRes3NotEqualTo(Integer value) {
            addCriterion("res_3 <>", value, "res3");
            return (Criteria) this;
        }

        public Criteria andRes3GreaterThan(Integer value) {
            addCriterion("res_3 >", value, "res3");
            return (Criteria) this;
        }

        public Criteria andRes3GreaterThanOrEqualTo(Integer value) {
            addCriterion("res_3 >=", value, "res3");
            return (Criteria) this;
        }

        public Criteria andRes3LessThan(Integer value) {
            addCriterion("res_3 <", value, "res3");
            return (Criteria) this;
        }

        public Criteria andRes3LessThanOrEqualTo(Integer value) {
            addCriterion("res_3 <=", value, "res3");
            return (Criteria) this;
        }

        public Criteria andRes3In(List<Integer> values) {
            addCriterion("res_3 in", values, "res3");
            return (Criteria) this;
        }

        public Criteria andRes3NotIn(List<Integer> values) {
            addCriterion("res_3 not in", values, "res3");
            return (Criteria) this;
        }

        public Criteria andRes3Between(Integer value1, Integer value2) {
            addCriterion("res_3 between", value1, value2, "res3");
            return (Criteria) this;
        }

        public Criteria andRes3NotBetween(Integer value1, Integer value2) {
            addCriterion("res_3 not between", value1, value2, "res3");
            return (Criteria) this;
        }

        public Criteria andRes5IsNull() {
            addCriterion("res_5 is null");
            return (Criteria) this;
        }

        public Criteria andRes5IsNotNull() {
            addCriterion("res_5 is not null");
            return (Criteria) this;
        }

        public Criteria andRes5EqualTo(Integer value) {
            addCriterion("res_5 =", value, "res5");
            return (Criteria) this;
        }

        public Criteria andRes5NotEqualTo(Integer value) {
            addCriterion("res_5 <>", value, "res5");
            return (Criteria) this;
        }

        public Criteria andRes5GreaterThan(Integer value) {
            addCriterion("res_5 >", value, "res5");
            return (Criteria) this;
        }

        public Criteria andRes5GreaterThanOrEqualTo(Integer value) {
            addCriterion("res_5 >=", value, "res5");
            return (Criteria) this;
        }

        public Criteria andRes5LessThan(Integer value) {
            addCriterion("res_5 <", value, "res5");
            return (Criteria) this;
        }

        public Criteria andRes5LessThanOrEqualTo(Integer value) {
            addCriterion("res_5 <=", value, "res5");
            return (Criteria) this;
        }

        public Criteria andRes5In(List<Integer> values) {
            addCriterion("res_5 in", values, "res5");
            return (Criteria) this;
        }

        public Criteria andRes5NotIn(List<Integer> values) {
            addCriterion("res_5 not in", values, "res5");
            return (Criteria) this;
        }

        public Criteria andRes5Between(Integer value1, Integer value2) {
            addCriterion("res_5 between", value1, value2, "res5");
            return (Criteria) this;
        }

        public Criteria andRes5NotBetween(Integer value1, Integer value2) {
            addCriterion("res_5 not between", value1, value2, "res5");
            return (Criteria) this;
        }

        public Criteria andOffice1IsNull() {
            addCriterion("office_1 is null");
            return (Criteria) this;
        }

        public Criteria andOffice1IsNotNull() {
            addCriterion("office_1 is not null");
            return (Criteria) this;
        }

        public Criteria andOffice1EqualTo(Integer value) {
            addCriterion("office_1 =", value, "office1");
            return (Criteria) this;
        }

        public Criteria andOffice1NotEqualTo(Integer value) {
            addCriterion("office_1 <>", value, "office1");
            return (Criteria) this;
        }

        public Criteria andOffice1GreaterThan(Integer value) {
            addCriterion("office_1 >", value, "office1");
            return (Criteria) this;
        }

        public Criteria andOffice1GreaterThanOrEqualTo(Integer value) {
            addCriterion("office_1 >=", value, "office1");
            return (Criteria) this;
        }

        public Criteria andOffice1LessThan(Integer value) {
            addCriterion("office_1 <", value, "office1");
            return (Criteria) this;
        }

        public Criteria andOffice1LessThanOrEqualTo(Integer value) {
            addCriterion("office_1 <=", value, "office1");
            return (Criteria) this;
        }

        public Criteria andOffice1In(List<Integer> values) {
            addCriterion("office_1 in", values, "office1");
            return (Criteria) this;
        }

        public Criteria andOffice1NotIn(List<Integer> values) {
            addCriterion("office_1 not in", values, "office1");
            return (Criteria) this;
        }

        public Criteria andOffice1Between(Integer value1, Integer value2) {
            addCriterion("office_1 between", value1, value2, "office1");
            return (Criteria) this;
        }

        public Criteria andOffice1NotBetween(Integer value1, Integer value2) {
            addCriterion("office_1 not between", value1, value2, "office1");
            return (Criteria) this;
        }

        public Criteria andOffice3IsNull() {
            addCriterion("office_3 is null");
            return (Criteria) this;
        }

        public Criteria andOffice3IsNotNull() {
            addCriterion("office_3 is not null");
            return (Criteria) this;
        }

        public Criteria andOffice3EqualTo(Integer value) {
            addCriterion("office_3 =", value, "office3");
            return (Criteria) this;
        }

        public Criteria andOffice3NotEqualTo(Integer value) {
            addCriterion("office_3 <>", value, "office3");
            return (Criteria) this;
        }

        public Criteria andOffice3GreaterThan(Integer value) {
            addCriterion("office_3 >", value, "office3");
            return (Criteria) this;
        }

        public Criteria andOffice3GreaterThanOrEqualTo(Integer value) {
            addCriterion("office_3 >=", value, "office3");
            return (Criteria) this;
        }

        public Criteria andOffice3LessThan(Integer value) {
            addCriterion("office_3 <", value, "office3");
            return (Criteria) this;
        }

        public Criteria andOffice3LessThanOrEqualTo(Integer value) {
            addCriterion("office_3 <=", value, "office3");
            return (Criteria) this;
        }

        public Criteria andOffice3In(List<Integer> values) {
            addCriterion("office_3 in", values, "office3");
            return (Criteria) this;
        }

        public Criteria andOffice3NotIn(List<Integer> values) {
            addCriterion("office_3 not in", values, "office3");
            return (Criteria) this;
        }

        public Criteria andOffice3Between(Integer value1, Integer value2) {
            addCriterion("office_3 between", value1, value2, "office3");
            return (Criteria) this;
        }

        public Criteria andOffice3NotBetween(Integer value1, Integer value2) {
            addCriterion("office_3 not between", value1, value2, "office3");
            return (Criteria) this;
        }

        public Criteria andOffice5IsNull() {
            addCriterion("office_5 is null");
            return (Criteria) this;
        }

        public Criteria andOffice5IsNotNull() {
            addCriterion("office_5 is not null");
            return (Criteria) this;
        }

        public Criteria andOffice5EqualTo(Integer value) {
            addCriterion("office_5 =", value, "office5");
            return (Criteria) this;
        }

        public Criteria andOffice5NotEqualTo(Integer value) {
            addCriterion("office_5 <>", value, "office5");
            return (Criteria) this;
        }

        public Criteria andOffice5GreaterThan(Integer value) {
            addCriterion("office_5 >", value, "office5");
            return (Criteria) this;
        }

        public Criteria andOffice5GreaterThanOrEqualTo(Integer value) {
            addCriterion("office_5 >=", value, "office5");
            return (Criteria) this;
        }

        public Criteria andOffice5LessThan(Integer value) {
            addCriterion("office_5 <", value, "office5");
            return (Criteria) this;
        }

        public Criteria andOffice5LessThanOrEqualTo(Integer value) {
            addCriterion("office_5 <=", value, "office5");
            return (Criteria) this;
        }

        public Criteria andOffice5In(List<Integer> values) {
            addCriterion("office_5 in", values, "office5");
            return (Criteria) this;
        }

        public Criteria andOffice5NotIn(List<Integer> values) {
            addCriterion("office_5 not in", values, "office5");
            return (Criteria) this;
        }

        public Criteria andOffice5Between(Integer value1, Integer value2) {
            addCriterion("office_5 between", value1, value2, "office5");
            return (Criteria) this;
        }

        public Criteria andOffice5NotBetween(Integer value1, Integer value2) {
            addCriterion("office_5 not between", value1, value2, "office5");
            return (Criteria) this;
        }

        public Criteria andTravel1IsNull() {
            addCriterion("travel_1 is null");
            return (Criteria) this;
        }

        public Criteria andTravel1IsNotNull() {
            addCriterion("travel_1 is not null");
            return (Criteria) this;
        }

        public Criteria andTravel1EqualTo(Integer value) {
            addCriterion("travel_1 =", value, "travel1");
            return (Criteria) this;
        }

        public Criteria andTravel1NotEqualTo(Integer value) {
            addCriterion("travel_1 <>", value, "travel1");
            return (Criteria) this;
        }

        public Criteria andTravel1GreaterThan(Integer value) {
            addCriterion("travel_1 >", value, "travel1");
            return (Criteria) this;
        }

        public Criteria andTravel1GreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_1 >=", value, "travel1");
            return (Criteria) this;
        }

        public Criteria andTravel1LessThan(Integer value) {
            addCriterion("travel_1 <", value, "travel1");
            return (Criteria) this;
        }

        public Criteria andTravel1LessThanOrEqualTo(Integer value) {
            addCriterion("travel_1 <=", value, "travel1");
            return (Criteria) this;
        }

        public Criteria andTravel1In(List<Integer> values) {
            addCriterion("travel_1 in", values, "travel1");
            return (Criteria) this;
        }

        public Criteria andTravel1NotIn(List<Integer> values) {
            addCriterion("travel_1 not in", values, "travel1");
            return (Criteria) this;
        }

        public Criteria andTravel1Between(Integer value1, Integer value2) {
            addCriterion("travel_1 between", value1, value2, "travel1");
            return (Criteria) this;
        }

        public Criteria andTravel1NotBetween(Integer value1, Integer value2) {
            addCriterion("travel_1 not between", value1, value2, "travel1");
            return (Criteria) this;
        }

        public Criteria andTravel3IsNull() {
            addCriterion("travel_3 is null");
            return (Criteria) this;
        }

        public Criteria andTravel3IsNotNull() {
            addCriterion("travel_3 is not null");
            return (Criteria) this;
        }

        public Criteria andTravel3EqualTo(Integer value) {
            addCriterion("travel_3 =", value, "travel3");
            return (Criteria) this;
        }

        public Criteria andTravel3NotEqualTo(Integer value) {
            addCriterion("travel_3 <>", value, "travel3");
            return (Criteria) this;
        }

        public Criteria andTravel3GreaterThan(Integer value) {
            addCriterion("travel_3 >", value, "travel3");
            return (Criteria) this;
        }

        public Criteria andTravel3GreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_3 >=", value, "travel3");
            return (Criteria) this;
        }

        public Criteria andTravel3LessThan(Integer value) {
            addCriterion("travel_3 <", value, "travel3");
            return (Criteria) this;
        }

        public Criteria andTravel3LessThanOrEqualTo(Integer value) {
            addCriterion("travel_3 <=", value, "travel3");
            return (Criteria) this;
        }

        public Criteria andTravel3In(List<Integer> values) {
            addCriterion("travel_3 in", values, "travel3");
            return (Criteria) this;
        }

        public Criteria andTravel3NotIn(List<Integer> values) {
            addCriterion("travel_3 not in", values, "travel3");
            return (Criteria) this;
        }

        public Criteria andTravel3Between(Integer value1, Integer value2) {
            addCriterion("travel_3 between", value1, value2, "travel3");
            return (Criteria) this;
        }

        public Criteria andTravel3NotBetween(Integer value1, Integer value2) {
            addCriterion("travel_3 not between", value1, value2, "travel3");
            return (Criteria) this;
        }

        public Criteria andTravel5IsNull() {
            addCriterion("travel_5 is null");
            return (Criteria) this;
        }

        public Criteria andTravel5IsNotNull() {
            addCriterion("travel_5 is not null");
            return (Criteria) this;
        }

        public Criteria andTravel5EqualTo(Integer value) {
            addCriterion("travel_5 =", value, "travel5");
            return (Criteria) this;
        }

        public Criteria andTravel5NotEqualTo(Integer value) {
            addCriterion("travel_5 <>", value, "travel5");
            return (Criteria) this;
        }

        public Criteria andTravel5GreaterThan(Integer value) {
            addCriterion("travel_5 >", value, "travel5");
            return (Criteria) this;
        }

        public Criteria andTravel5GreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_5 >=", value, "travel5");
            return (Criteria) this;
        }

        public Criteria andTravel5LessThan(Integer value) {
            addCriterion("travel_5 <", value, "travel5");
            return (Criteria) this;
        }

        public Criteria andTravel5LessThanOrEqualTo(Integer value) {
            addCriterion("travel_5 <=", value, "travel5");
            return (Criteria) this;
        }

        public Criteria andTravel5In(List<Integer> values) {
            addCriterion("travel_5 in", values, "travel5");
            return (Criteria) this;
        }

        public Criteria andTravel5NotIn(List<Integer> values) {
            addCriterion("travel_5 not in", values, "travel5");
            return (Criteria) this;
        }

        public Criteria andTravel5Between(Integer value1, Integer value2) {
            addCriterion("travel_5 between", value1, value2, "travel5");
            return (Criteria) this;
        }

        public Criteria andTravel5NotBetween(Integer value1, Integer value2) {
            addCriterion("travel_5 not between", value1, value2, "travel5");
            return (Criteria) this;
        }

        public Criteria andCollege1IsNull() {
            addCriterion("college_1 is null");
            return (Criteria) this;
        }

        public Criteria andCollege1IsNotNull() {
            addCriterion("college_1 is not null");
            return (Criteria) this;
        }

        public Criteria andCollege1EqualTo(Integer value) {
            addCriterion("college_1 =", value, "college1");
            return (Criteria) this;
        }

        public Criteria andCollege1NotEqualTo(Integer value) {
            addCriterion("college_1 <>", value, "college1");
            return (Criteria) this;
        }

        public Criteria andCollege1GreaterThan(Integer value) {
            addCriterion("college_1 >", value, "college1");
            return (Criteria) this;
        }

        public Criteria andCollege1GreaterThanOrEqualTo(Integer value) {
            addCriterion("college_1 >=", value, "college1");
            return (Criteria) this;
        }

        public Criteria andCollege1LessThan(Integer value) {
            addCriterion("college_1 <", value, "college1");
            return (Criteria) this;
        }

        public Criteria andCollege1LessThanOrEqualTo(Integer value) {
            addCriterion("college_1 <=", value, "college1");
            return (Criteria) this;
        }

        public Criteria andCollege1In(List<Integer> values) {
            addCriterion("college_1 in", values, "college1");
            return (Criteria) this;
        }

        public Criteria andCollege1NotIn(List<Integer> values) {
            addCriterion("college_1 not in", values, "college1");
            return (Criteria) this;
        }

        public Criteria andCollege1Between(Integer value1, Integer value2) {
            addCriterion("college_1 between", value1, value2, "college1");
            return (Criteria) this;
        }

        public Criteria andCollege1NotBetween(Integer value1, Integer value2) {
            addCriterion("college_1 not between", value1, value2, "college1");
            return (Criteria) this;
        }

        public Criteria andCollege3IsNull() {
            addCriterion("college_3 is null");
            return (Criteria) this;
        }

        public Criteria andCollege3IsNotNull() {
            addCriterion("college_3 is not null");
            return (Criteria) this;
        }

        public Criteria andCollege3EqualTo(Integer value) {
            addCriterion("college_3 =", value, "college3");
            return (Criteria) this;
        }

        public Criteria andCollege3NotEqualTo(Integer value) {
            addCriterion("college_3 <>", value, "college3");
            return (Criteria) this;
        }

        public Criteria andCollege3GreaterThan(Integer value) {
            addCriterion("college_3 >", value, "college3");
            return (Criteria) this;
        }

        public Criteria andCollege3GreaterThanOrEqualTo(Integer value) {
            addCriterion("college_3 >=", value, "college3");
            return (Criteria) this;
        }

        public Criteria andCollege3LessThan(Integer value) {
            addCriterion("college_3 <", value, "college3");
            return (Criteria) this;
        }

        public Criteria andCollege3LessThanOrEqualTo(Integer value) {
            addCriterion("college_3 <=", value, "college3");
            return (Criteria) this;
        }

        public Criteria andCollege3In(List<Integer> values) {
            addCriterion("college_3 in", values, "college3");
            return (Criteria) this;
        }

        public Criteria andCollege3NotIn(List<Integer> values) {
            addCriterion("college_3 not in", values, "college3");
            return (Criteria) this;
        }

        public Criteria andCollege3Between(Integer value1, Integer value2) {
            addCriterion("college_3 between", value1, value2, "college3");
            return (Criteria) this;
        }

        public Criteria andCollege3NotBetween(Integer value1, Integer value2) {
            addCriterion("college_3 not between", value1, value2, "college3");
            return (Criteria) this;
        }

        public Criteria andCollege5IsNull() {
            addCriterion("college_5 is null");
            return (Criteria) this;
        }

        public Criteria andCollege5IsNotNull() {
            addCriterion("college_5 is not null");
            return (Criteria) this;
        }

        public Criteria andCollege5EqualTo(Integer value) {
            addCriterion("college_5 =", value, "college5");
            return (Criteria) this;
        }

        public Criteria andCollege5NotEqualTo(Integer value) {
            addCriterion("college_5 <>", value, "college5");
            return (Criteria) this;
        }

        public Criteria andCollege5GreaterThan(Integer value) {
            addCriterion("college_5 >", value, "college5");
            return (Criteria) this;
        }

        public Criteria andCollege5GreaterThanOrEqualTo(Integer value) {
            addCriterion("college_5 >=", value, "college5");
            return (Criteria) this;
        }

        public Criteria andCollege5LessThan(Integer value) {
            addCriterion("college_5 <", value, "college5");
            return (Criteria) this;
        }

        public Criteria andCollege5LessThanOrEqualTo(Integer value) {
            addCriterion("college_5 <=", value, "college5");
            return (Criteria) this;
        }

        public Criteria andCollege5In(List<Integer> values) {
            addCriterion("college_5 in", values, "college5");
            return (Criteria) this;
        }

        public Criteria andCollege5NotIn(List<Integer> values) {
            addCriterion("college_5 not in", values, "college5");
            return (Criteria) this;
        }

        public Criteria andCollege5Between(Integer value1, Integer value2) {
            addCriterion("college_5 between", value1, value2, "college5");
            return (Criteria) this;
        }

        public Criteria andCollege5NotBetween(Integer value1, Integer value2) {
            addCriterion("college_5 not between", value1, value2, "college5");
            return (Criteria) this;
        }

        public Criteria andBusesIsNull() {
            addCriterion("buses is null");
            return (Criteria) this;
        }

        public Criteria andBusesIsNotNull() {
            addCriterion("buses is not null");
            return (Criteria) this;
        }

        public Criteria andBusesEqualTo(Integer value) {
            addCriterion("buses =", value, "buses");
            return (Criteria) this;
        }

        public Criteria andBusesNotEqualTo(Integer value) {
            addCriterion("buses <>", value, "buses");
            return (Criteria) this;
        }

        public Criteria andBusesGreaterThan(Integer value) {
            addCriterion("buses >", value, "buses");
            return (Criteria) this;
        }

        public Criteria andBusesGreaterThanOrEqualTo(Integer value) {
            addCriterion("buses >=", value, "buses");
            return (Criteria) this;
        }

        public Criteria andBusesLessThan(Integer value) {
            addCriterion("buses <", value, "buses");
            return (Criteria) this;
        }

        public Criteria andBusesLessThanOrEqualTo(Integer value) {
            addCriterion("buses <=", value, "buses");
            return (Criteria) this;
        }

        public Criteria andBusesIn(List<Integer> values) {
            addCriterion("buses in", values, "buses");
            return (Criteria) this;
        }

        public Criteria andBusesNotIn(List<Integer> values) {
            addCriterion("buses not in", values, "buses");
            return (Criteria) this;
        }

        public Criteria andBusesBetween(Integer value1, Integer value2) {
            addCriterion("buses between", value1, value2, "buses");
            return (Criteria) this;
        }

        public Criteria andBusesNotBetween(Integer value1, Integer value2) {
            addCriterion("buses not between", value1, value2, "buses");
            return (Criteria) this;
        }

        public Criteria andSubwayIsNull() {
            addCriterion("subway is null");
            return (Criteria) this;
        }

        public Criteria andSubwayIsNotNull() {
            addCriterion("subway is not null");
            return (Criteria) this;
        }

        public Criteria andSubwayEqualTo(Integer value) {
            addCriterion("subway =", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayNotEqualTo(Integer value) {
            addCriterion("subway <>", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayGreaterThan(Integer value) {
            addCriterion("subway >", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayGreaterThanOrEqualTo(Integer value) {
            addCriterion("subway >=", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayLessThan(Integer value) {
            addCriterion("subway <", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayLessThanOrEqualTo(Integer value) {
            addCriterion("subway <=", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayIn(List<Integer> values) {
            addCriterion("subway in", values, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayNotIn(List<Integer> values) {
            addCriterion("subway not in", values, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayBetween(Integer value1, Integer value2) {
            addCriterion("subway between", value1, value2, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayNotBetween(Integer value1, Integer value2) {
            addCriterion("subway not between", value1, value2, "subway");
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