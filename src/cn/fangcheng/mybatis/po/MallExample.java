package cn.fangcheng.mybatis.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MallExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andMallNameIsNull() {
            addCriterion("mall_name is null");
            return (Criteria) this;
        }

        public Criteria andMallNameIsNotNull() {
            addCriterion("mall_name is not null");
            return (Criteria) this;
        }

        public Criteria andMallNameEqualTo(String value) {
            addCriterion("mall_name =", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameNotEqualTo(String value) {
            addCriterion("mall_name <>", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameGreaterThan(String value) {
            addCriterion("mall_name >", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameGreaterThanOrEqualTo(String value) {
            addCriterion("mall_name >=", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameLessThan(String value) {
            addCriterion("mall_name <", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameLessThanOrEqualTo(String value) {
            addCriterion("mall_name <=", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameLike(String value) {
            addCriterion("mall_name like", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameNotLike(String value) {
            addCriterion("mall_name not like", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameIn(List<String> values) {
            addCriterion("mall_name in", values, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameNotIn(List<String> values) {
            addCriterion("mall_name not in", values, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameBetween(String value1, String value2) {
            addCriterion("mall_name between", value1, value2, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameNotBetween(String value1, String value2) {
            addCriterion("mall_name not between", value1, value2, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallDescIsNull() {
            addCriterion("mall_desc is null");
            return (Criteria) this;
        }

        public Criteria andMallDescIsNotNull() {
            addCriterion("mall_desc is not null");
            return (Criteria) this;
        }

        public Criteria andMallDescEqualTo(String value) {
            addCriterion("mall_desc =", value, "mallDesc");
            return (Criteria) this;
        }

        public Criteria andMallDescNotEqualTo(String value) {
            addCriterion("mall_desc <>", value, "mallDesc");
            return (Criteria) this;
        }

        public Criteria andMallDescGreaterThan(String value) {
            addCriterion("mall_desc >", value, "mallDesc");
            return (Criteria) this;
        }

        public Criteria andMallDescGreaterThanOrEqualTo(String value) {
            addCriterion("mall_desc >=", value, "mallDesc");
            return (Criteria) this;
        }

        public Criteria andMallDescLessThan(String value) {
            addCriterion("mall_desc <", value, "mallDesc");
            return (Criteria) this;
        }

        public Criteria andMallDescLessThanOrEqualTo(String value) {
            addCriterion("mall_desc <=", value, "mallDesc");
            return (Criteria) this;
        }

        public Criteria andMallDescLike(String value) {
            addCriterion("mall_desc like", value, "mallDesc");
            return (Criteria) this;
        }

        public Criteria andMallDescNotLike(String value) {
            addCriterion("mall_desc not like", value, "mallDesc");
            return (Criteria) this;
        }

        public Criteria andMallDescIn(List<String> values) {
            addCriterion("mall_desc in", values, "mallDesc");
            return (Criteria) this;
        }

        public Criteria andMallDescNotIn(List<String> values) {
            addCriterion("mall_desc not in", values, "mallDesc");
            return (Criteria) this;
        }

        public Criteria andMallDescBetween(String value1, String value2) {
            addCriterion("mall_desc between", value1, value2, "mallDesc");
            return (Criteria) this;
        }

        public Criteria andMallDescNotBetween(String value1, String value2) {
            addCriterion("mall_desc not between", value1, value2, "mallDesc");
            return (Criteria) this;
        }

        public Criteria andMallCtimeIsNull() {
            addCriterion("mall_ctime is null");
            return (Criteria) this;
        }

        public Criteria andMallCtimeIsNotNull() {
            addCriterion("mall_ctime is not null");
            return (Criteria) this;
        }

        public Criteria andMallCtimeEqualTo(Date value) {
            addCriterion("mall_ctime =", value, "mallCtime");
            return (Criteria) this;
        }

        public Criteria andMallCtimeNotEqualTo(Date value) {
            addCriterion("mall_ctime <>", value, "mallCtime");
            return (Criteria) this;
        }

        public Criteria andMallCtimeGreaterThan(Date value) {
            addCriterion("mall_ctime >", value, "mallCtime");
            return (Criteria) this;
        }

        public Criteria andMallCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mall_ctime >=", value, "mallCtime");
            return (Criteria) this;
        }

        public Criteria andMallCtimeLessThan(Date value) {
            addCriterion("mall_ctime <", value, "mallCtime");
            return (Criteria) this;
        }

        public Criteria andMallCtimeLessThanOrEqualTo(Date value) {
            addCriterion("mall_ctime <=", value, "mallCtime");
            return (Criteria) this;
        }

        public Criteria andMallCtimeIn(List<Date> values) {
            addCriterion("mall_ctime in", values, "mallCtime");
            return (Criteria) this;
        }

        public Criteria andMallCtimeNotIn(List<Date> values) {
            addCriterion("mall_ctime not in", values, "mallCtime");
            return (Criteria) this;
        }

        public Criteria andMallCtimeBetween(Date value1, Date value2) {
            addCriterion("mall_ctime between", value1, value2, "mallCtime");
            return (Criteria) this;
        }

        public Criteria andMallCtimeNotBetween(Date value1, Date value2) {
            addCriterion("mall_ctime not between", value1, value2, "mallCtime");
            return (Criteria) this;
        }

        public Criteria andMallOpeningDateIsNull() {
            addCriterion("mall_opening_date is null");
            return (Criteria) this;
        }

        public Criteria andMallOpeningDateIsNotNull() {
            addCriterion("mall_opening_date is not null");
            return (Criteria) this;
        }

        public Criteria andMallOpeningDateEqualTo(Date value) {
            addCriterionForJDBCDate("mall_opening_date =", value, "mallOpeningDate");
            return (Criteria) this;
        }

        public Criteria andMallOpeningDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("mall_opening_date <>", value, "mallOpeningDate");
            return (Criteria) this;
        }

        public Criteria andMallOpeningDateGreaterThan(Date value) {
            addCriterionForJDBCDate("mall_opening_date >", value, "mallOpeningDate");
            return (Criteria) this;
        }

        public Criteria andMallOpeningDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mall_opening_date >=", value, "mallOpeningDate");
            return (Criteria) this;
        }

        public Criteria andMallOpeningDateLessThan(Date value) {
            addCriterionForJDBCDate("mall_opening_date <", value, "mallOpeningDate");
            return (Criteria) this;
        }

        public Criteria andMallOpeningDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mall_opening_date <=", value, "mallOpeningDate");
            return (Criteria) this;
        }

        public Criteria andMallOpeningDateIn(List<Date> values) {
            addCriterionForJDBCDate("mall_opening_date in", values, "mallOpeningDate");
            return (Criteria) this;
        }

        public Criteria andMallOpeningDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("mall_opening_date not in", values, "mallOpeningDate");
            return (Criteria) this;
        }

        public Criteria andMallOpeningDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mall_opening_date between", value1, value2, "mallOpeningDate");
            return (Criteria) this;
        }

        public Criteria andMallOpeningDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mall_opening_date not between", value1, value2, "mallOpeningDate");
            return (Criteria) this;
        }

        public Criteria andMallClosedDateIsNull() {
            addCriterion("mall_closed_date is null");
            return (Criteria) this;
        }

        public Criteria andMallClosedDateIsNotNull() {
            addCriterion("mall_closed_date is not null");
            return (Criteria) this;
        }

        public Criteria andMallClosedDateEqualTo(Date value) {
            addCriterionForJDBCDate("mall_closed_date =", value, "mallClosedDate");
            return (Criteria) this;
        }

        public Criteria andMallClosedDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("mall_closed_date <>", value, "mallClosedDate");
            return (Criteria) this;
        }

        public Criteria andMallClosedDateGreaterThan(Date value) {
            addCriterionForJDBCDate("mall_closed_date >", value, "mallClosedDate");
            return (Criteria) this;
        }

        public Criteria andMallClosedDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mall_closed_date >=", value, "mallClosedDate");
            return (Criteria) this;
        }

        public Criteria andMallClosedDateLessThan(Date value) {
            addCriterionForJDBCDate("mall_closed_date <", value, "mallClosedDate");
            return (Criteria) this;
        }

        public Criteria andMallClosedDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mall_closed_date <=", value, "mallClosedDate");
            return (Criteria) this;
        }

        public Criteria andMallClosedDateIn(List<Date> values) {
            addCriterionForJDBCDate("mall_closed_date in", values, "mallClosedDate");
            return (Criteria) this;
        }

        public Criteria andMallClosedDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("mall_closed_date not in", values, "mallClosedDate");
            return (Criteria) this;
        }

        public Criteria andMallClosedDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mall_closed_date between", value1, value2, "mallClosedDate");
            return (Criteria) this;
        }

        public Criteria andMallClosedDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mall_closed_date not between", value1, value2, "mallClosedDate");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNull() {
            addCriterion("district_id is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNotNull() {
            addCriterion("district_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdEqualTo(Integer value) {
            addCriterion("district_id =", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotEqualTo(Integer value) {
            addCriterion("district_id <>", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThan(Integer value) {
            addCriterion("district_id >", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("district_id >=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThan(Integer value) {
            addCriterion("district_id <", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThanOrEqualTo(Integer value) {
            addCriterion("district_id <=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIn(List<Integer> values) {
            addCriterion("district_id in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotIn(List<Integer> values) {
            addCriterion("district_id not in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdBetween(Integer value1, Integer value2) {
            addCriterion("district_id between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotBetween(Integer value1, Integer value2) {
            addCriterion("district_id not between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andMallAddressIsNull() {
            addCriterion("mall_address is null");
            return (Criteria) this;
        }

        public Criteria andMallAddressIsNotNull() {
            addCriterion("mall_address is not null");
            return (Criteria) this;
        }

        public Criteria andMallAddressEqualTo(String value) {
            addCriterion("mall_address =", value, "mallAddress");
            return (Criteria) this;
        }

        public Criteria andMallAddressNotEqualTo(String value) {
            addCriterion("mall_address <>", value, "mallAddress");
            return (Criteria) this;
        }

        public Criteria andMallAddressGreaterThan(String value) {
            addCriterion("mall_address >", value, "mallAddress");
            return (Criteria) this;
        }

        public Criteria andMallAddressGreaterThanOrEqualTo(String value) {
            addCriterion("mall_address >=", value, "mallAddress");
            return (Criteria) this;
        }

        public Criteria andMallAddressLessThan(String value) {
            addCriterion("mall_address <", value, "mallAddress");
            return (Criteria) this;
        }

        public Criteria andMallAddressLessThanOrEqualTo(String value) {
            addCriterion("mall_address <=", value, "mallAddress");
            return (Criteria) this;
        }

        public Criteria andMallAddressLike(String value) {
            addCriterion("mall_address like", value, "mallAddress");
            return (Criteria) this;
        }

        public Criteria andMallAddressNotLike(String value) {
            addCriterion("mall_address not like", value, "mallAddress");
            return (Criteria) this;
        }

        public Criteria andMallAddressIn(List<String> values) {
            addCriterion("mall_address in", values, "mallAddress");
            return (Criteria) this;
        }

        public Criteria andMallAddressNotIn(List<String> values) {
            addCriterion("mall_address not in", values, "mallAddress");
            return (Criteria) this;
        }

        public Criteria andMallAddressBetween(String value1, String value2) {
            addCriterion("mall_address between", value1, value2, "mallAddress");
            return (Criteria) this;
        }

        public Criteria andMallAddressNotBetween(String value1, String value2) {
            addCriterion("mall_address not between", value1, value2, "mallAddress");
            return (Criteria) this;
        }

        public Criteria andMallBuildingSizeIsNull() {
            addCriterion("mall_building_size is null");
            return (Criteria) this;
        }

        public Criteria andMallBuildingSizeIsNotNull() {
            addCriterion("mall_building_size is not null");
            return (Criteria) this;
        }

        public Criteria andMallBuildingSizeEqualTo(Integer value) {
            addCriterion("mall_building_size =", value, "mallBuildingSize");
            return (Criteria) this;
        }

        public Criteria andMallBuildingSizeNotEqualTo(Integer value) {
            addCriterion("mall_building_size <>", value, "mallBuildingSize");
            return (Criteria) this;
        }

        public Criteria andMallBuildingSizeGreaterThan(Integer value) {
            addCriterion("mall_building_size >", value, "mallBuildingSize");
            return (Criteria) this;
        }

        public Criteria andMallBuildingSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mall_building_size >=", value, "mallBuildingSize");
            return (Criteria) this;
        }

        public Criteria andMallBuildingSizeLessThan(Integer value) {
            addCriterion("mall_building_size <", value, "mallBuildingSize");
            return (Criteria) this;
        }

        public Criteria andMallBuildingSizeLessThanOrEqualTo(Integer value) {
            addCriterion("mall_building_size <=", value, "mallBuildingSize");
            return (Criteria) this;
        }

        public Criteria andMallBuildingSizeIn(List<Integer> values) {
            addCriterion("mall_building_size in", values, "mallBuildingSize");
            return (Criteria) this;
        }

        public Criteria andMallBuildingSizeNotIn(List<Integer> values) {
            addCriterion("mall_building_size not in", values, "mallBuildingSize");
            return (Criteria) this;
        }

        public Criteria andMallBuildingSizeBetween(Integer value1, Integer value2) {
            addCriterion("mall_building_size between", value1, value2, "mallBuildingSize");
            return (Criteria) this;
        }

        public Criteria andMallBuildingSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("mall_building_size not between", value1, value2, "mallBuildingSize");
            return (Criteria) this;
        }

        public Criteria andMallBusinessSizeIsNull() {
            addCriterion("mall_business_size is null");
            return (Criteria) this;
        }

        public Criteria andMallBusinessSizeIsNotNull() {
            addCriterion("mall_business_size is not null");
            return (Criteria) this;
        }

        public Criteria andMallBusinessSizeEqualTo(Integer value) {
            addCriterion("mall_business_size =", value, "mallBusinessSize");
            return (Criteria) this;
        }

        public Criteria andMallBusinessSizeNotEqualTo(Integer value) {
            addCriterion("mall_business_size <>", value, "mallBusinessSize");
            return (Criteria) this;
        }

        public Criteria andMallBusinessSizeGreaterThan(Integer value) {
            addCriterion("mall_business_size >", value, "mallBusinessSize");
            return (Criteria) this;
        }

        public Criteria andMallBusinessSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mall_business_size >=", value, "mallBusinessSize");
            return (Criteria) this;
        }

        public Criteria andMallBusinessSizeLessThan(Integer value) {
            addCriterion("mall_business_size <", value, "mallBusinessSize");
            return (Criteria) this;
        }

        public Criteria andMallBusinessSizeLessThanOrEqualTo(Integer value) {
            addCriterion("mall_business_size <=", value, "mallBusinessSize");
            return (Criteria) this;
        }

        public Criteria andMallBusinessSizeIn(List<Integer> values) {
            addCriterion("mall_business_size in", values, "mallBusinessSize");
            return (Criteria) this;
        }

        public Criteria andMallBusinessSizeNotIn(List<Integer> values) {
            addCriterion("mall_business_size not in", values, "mallBusinessSize");
            return (Criteria) this;
        }

        public Criteria andMallBusinessSizeBetween(Integer value1, Integer value2) {
            addCriterion("mall_business_size between", value1, value2, "mallBusinessSize");
            return (Criteria) this;
        }

        public Criteria andMallBusinessSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("mall_business_size not between", value1, value2, "mallBusinessSize");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaIsNull() {
            addCriterion("mall_cover_area is null");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaIsNotNull() {
            addCriterion("mall_cover_area is not null");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaEqualTo(String value) {
            addCriterion("mall_cover_area =", value, "mallCoverArea");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaNotEqualTo(String value) {
            addCriterion("mall_cover_area <>", value, "mallCoverArea");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaGreaterThan(String value) {
            addCriterion("mall_cover_area >", value, "mallCoverArea");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaGreaterThanOrEqualTo(String value) {
            addCriterion("mall_cover_area >=", value, "mallCoverArea");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaLessThan(String value) {
            addCriterion("mall_cover_area <", value, "mallCoverArea");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaLessThanOrEqualTo(String value) {
            addCriterion("mall_cover_area <=", value, "mallCoverArea");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaLike(String value) {
            addCriterion("mall_cover_area like", value, "mallCoverArea");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaNotLike(String value) {
            addCriterion("mall_cover_area not like", value, "mallCoverArea");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaIn(List<String> values) {
            addCriterion("mall_cover_area in", values, "mallCoverArea");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaNotIn(List<String> values) {
            addCriterion("mall_cover_area not in", values, "mallCoverArea");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaBetween(String value1, String value2) {
            addCriterion("mall_cover_area between", value1, value2, "mallCoverArea");
            return (Criteria) this;
        }

        public Criteria andMallCoverAreaNotBetween(String value1, String value2) {
            addCriterion("mall_cover_area not between", value1, value2, "mallCoverArea");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameIsNull() {
            addCriterion("developer_name is null");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameIsNotNull() {
            addCriterion("developer_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameEqualTo(String value) {
            addCriterion("developer_name =", value, "developerName");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameNotEqualTo(String value) {
            addCriterion("developer_name <>", value, "developerName");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameGreaterThan(String value) {
            addCriterion("developer_name >", value, "developerName");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameGreaterThanOrEqualTo(String value) {
            addCriterion("developer_name >=", value, "developerName");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameLessThan(String value) {
            addCriterion("developer_name <", value, "developerName");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameLessThanOrEqualTo(String value) {
            addCriterion("developer_name <=", value, "developerName");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameLike(String value) {
            addCriterion("developer_name like", value, "developerName");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameNotLike(String value) {
            addCriterion("developer_name not like", value, "developerName");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameIn(List<String> values) {
            addCriterion("developer_name in", values, "developerName");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameNotIn(List<String> values) {
            addCriterion("developer_name not in", values, "developerName");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameBetween(String value1, String value2) {
            addCriterion("developer_name between", value1, value2, "developerName");
            return (Criteria) this;
        }

        public Criteria andDeveloperNameNotBetween(String value1, String value2) {
            addCriterion("developer_name not between", value1, value2, "developerName");
            return (Criteria) this;
        }

        public Criteria andMallFloorSizeIsNull() {
            addCriterion("mall_floor_size is null");
            return (Criteria) this;
        }

        public Criteria andMallFloorSizeIsNotNull() {
            addCriterion("mall_floor_size is not null");
            return (Criteria) this;
        }

        public Criteria andMallFloorSizeEqualTo(Integer value) {
            addCriterion("mall_floor_size =", value, "mallFloorSize");
            return (Criteria) this;
        }

        public Criteria andMallFloorSizeNotEqualTo(Integer value) {
            addCriterion("mall_floor_size <>", value, "mallFloorSize");
            return (Criteria) this;
        }

        public Criteria andMallFloorSizeGreaterThan(Integer value) {
            addCriterion("mall_floor_size >", value, "mallFloorSize");
            return (Criteria) this;
        }

        public Criteria andMallFloorSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mall_floor_size >=", value, "mallFloorSize");
            return (Criteria) this;
        }

        public Criteria andMallFloorSizeLessThan(Integer value) {
            addCriterion("mall_floor_size <", value, "mallFloorSize");
            return (Criteria) this;
        }

        public Criteria andMallFloorSizeLessThanOrEqualTo(Integer value) {
            addCriterion("mall_floor_size <=", value, "mallFloorSize");
            return (Criteria) this;
        }

        public Criteria andMallFloorSizeIn(List<Integer> values) {
            addCriterion("mall_floor_size in", values, "mallFloorSize");
            return (Criteria) this;
        }

        public Criteria andMallFloorSizeNotIn(List<Integer> values) {
            addCriterion("mall_floor_size not in", values, "mallFloorSize");
            return (Criteria) this;
        }

        public Criteria andMallFloorSizeBetween(Integer value1, Integer value2) {
            addCriterion("mall_floor_size between", value1, value2, "mallFloorSize");
            return (Criteria) this;
        }

        public Criteria andMallFloorSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("mall_floor_size not between", value1, value2, "mallFloorSize");
            return (Criteria) this;
        }

        public Criteria andMallHandbookIsNull() {
            addCriterion("mall_handbook is null");
            return (Criteria) this;
        }

        public Criteria andMallHandbookIsNotNull() {
            addCriterion("mall_handbook is not null");
            return (Criteria) this;
        }

        public Criteria andMallHandbookEqualTo(String value) {
            addCriterion("mall_handbook =", value, "mallHandbook");
            return (Criteria) this;
        }

        public Criteria andMallHandbookNotEqualTo(String value) {
            addCriterion("mall_handbook <>", value, "mallHandbook");
            return (Criteria) this;
        }

        public Criteria andMallHandbookGreaterThan(String value) {
            addCriterion("mall_handbook >", value, "mallHandbook");
            return (Criteria) this;
        }

        public Criteria andMallHandbookGreaterThanOrEqualTo(String value) {
            addCriterion("mall_handbook >=", value, "mallHandbook");
            return (Criteria) this;
        }

        public Criteria andMallHandbookLessThan(String value) {
            addCriterion("mall_handbook <", value, "mallHandbook");
            return (Criteria) this;
        }

        public Criteria andMallHandbookLessThanOrEqualTo(String value) {
            addCriterion("mall_handbook <=", value, "mallHandbook");
            return (Criteria) this;
        }

        public Criteria andMallHandbookLike(String value) {
            addCriterion("mall_handbook like", value, "mallHandbook");
            return (Criteria) this;
        }

        public Criteria andMallHandbookNotLike(String value) {
            addCriterion("mall_handbook not like", value, "mallHandbook");
            return (Criteria) this;
        }

        public Criteria andMallHandbookIn(List<String> values) {
            addCriterion("mall_handbook in", values, "mallHandbook");
            return (Criteria) this;
        }

        public Criteria andMallHandbookNotIn(List<String> values) {
            addCriterion("mall_handbook not in", values, "mallHandbook");
            return (Criteria) this;
        }

        public Criteria andMallHandbookBetween(String value1, String value2) {
            addCriterion("mall_handbook between", value1, value2, "mallHandbook");
            return (Criteria) this;
        }

        public Criteria andMallHandbookNotBetween(String value1, String value2) {
            addCriterion("mall_handbook not between", value1, value2, "mallHandbook");
            return (Criteria) this;
        }

        public Criteria andMallLongitudeIsNull() {
            addCriterion("mall_longitude is null");
            return (Criteria) this;
        }

        public Criteria andMallLongitudeIsNotNull() {
            addCriterion("mall_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andMallLongitudeEqualTo(Integer value) {
            addCriterion("mall_longitude =", value, "mallLongitude");
            return (Criteria) this;
        }

        public Criteria andMallLongitudeNotEqualTo(Integer value) {
            addCriterion("mall_longitude <>", value, "mallLongitude");
            return (Criteria) this;
        }

        public Criteria andMallLongitudeGreaterThan(Integer value) {
            addCriterion("mall_longitude >", value, "mallLongitude");
            return (Criteria) this;
        }

        public Criteria andMallLongitudeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mall_longitude >=", value, "mallLongitude");
            return (Criteria) this;
        }

        public Criteria andMallLongitudeLessThan(Integer value) {
            addCriterion("mall_longitude <", value, "mallLongitude");
            return (Criteria) this;
        }

        public Criteria andMallLongitudeLessThanOrEqualTo(Integer value) {
            addCriterion("mall_longitude <=", value, "mallLongitude");
            return (Criteria) this;
        }

        public Criteria andMallLongitudeIn(List<Integer> values) {
            addCriterion("mall_longitude in", values, "mallLongitude");
            return (Criteria) this;
        }

        public Criteria andMallLongitudeNotIn(List<Integer> values) {
            addCriterion("mall_longitude not in", values, "mallLongitude");
            return (Criteria) this;
        }

        public Criteria andMallLongitudeBetween(Integer value1, Integer value2) {
            addCriterion("mall_longitude between", value1, value2, "mallLongitude");
            return (Criteria) this;
        }

        public Criteria andMallLongitudeNotBetween(Integer value1, Integer value2) {
            addCriterion("mall_longitude not between", value1, value2, "mallLongitude");
            return (Criteria) this;
        }

        public Criteria andMallLatitudeIsNull() {
            addCriterion("mall_latitude is null");
            return (Criteria) this;
        }

        public Criteria andMallLatitudeIsNotNull() {
            addCriterion("mall_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andMallLatitudeEqualTo(Integer value) {
            addCriterion("mall_latitude =", value, "mallLatitude");
            return (Criteria) this;
        }

        public Criteria andMallLatitudeNotEqualTo(Integer value) {
            addCriterion("mall_latitude <>", value, "mallLatitude");
            return (Criteria) this;
        }

        public Criteria andMallLatitudeGreaterThan(Integer value) {
            addCriterion("mall_latitude >", value, "mallLatitude");
            return (Criteria) this;
        }

        public Criteria andMallLatitudeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mall_latitude >=", value, "mallLatitude");
            return (Criteria) this;
        }

        public Criteria andMallLatitudeLessThan(Integer value) {
            addCriterion("mall_latitude <", value, "mallLatitude");
            return (Criteria) this;
        }

        public Criteria andMallLatitudeLessThanOrEqualTo(Integer value) {
            addCriterion("mall_latitude <=", value, "mallLatitude");
            return (Criteria) this;
        }

        public Criteria andMallLatitudeIn(List<Integer> values) {
            addCriterion("mall_latitude in", values, "mallLatitude");
            return (Criteria) this;
        }

        public Criteria andMallLatitudeNotIn(List<Integer> values) {
            addCriterion("mall_latitude not in", values, "mallLatitude");
            return (Criteria) this;
        }

        public Criteria andMallLatitudeBetween(Integer value1, Integer value2) {
            addCriterion("mall_latitude between", value1, value2, "mallLatitude");
            return (Criteria) this;
        }

        public Criteria andMallLatitudeNotBetween(Integer value1, Integer value2) {
            addCriterion("mall_latitude not between", value1, value2, "mallLatitude");
            return (Criteria) this;
        }

        public Criteria andMallLogoIsNull() {
            addCriterion("mall_logo is null");
            return (Criteria) this;
        }

        public Criteria andMallLogoIsNotNull() {
            addCriterion("mall_logo is not null");
            return (Criteria) this;
        }

        public Criteria andMallLogoEqualTo(String value) {
            addCriterion("mall_logo =", value, "mallLogo");
            return (Criteria) this;
        }

        public Criteria andMallLogoNotEqualTo(String value) {
            addCriterion("mall_logo <>", value, "mallLogo");
            return (Criteria) this;
        }

        public Criteria andMallLogoGreaterThan(String value) {
            addCriterion("mall_logo >", value, "mallLogo");
            return (Criteria) this;
        }

        public Criteria andMallLogoGreaterThanOrEqualTo(String value) {
            addCriterion("mall_logo >=", value, "mallLogo");
            return (Criteria) this;
        }

        public Criteria andMallLogoLessThan(String value) {
            addCriterion("mall_logo <", value, "mallLogo");
            return (Criteria) this;
        }

        public Criteria andMallLogoLessThanOrEqualTo(String value) {
            addCriterion("mall_logo <=", value, "mallLogo");
            return (Criteria) this;
        }

        public Criteria andMallLogoLike(String value) {
            addCriterion("mall_logo like", value, "mallLogo");
            return (Criteria) this;
        }

        public Criteria andMallLogoNotLike(String value) {
            addCriterion("mall_logo not like", value, "mallLogo");
            return (Criteria) this;
        }

        public Criteria andMallLogoIn(List<String> values) {
            addCriterion("mall_logo in", values, "mallLogo");
            return (Criteria) this;
        }

        public Criteria andMallLogoNotIn(List<String> values) {
            addCriterion("mall_logo not in", values, "mallLogo");
            return (Criteria) this;
        }

        public Criteria andMallLogoBetween(String value1, String value2) {
            addCriterion("mall_logo between", value1, value2, "mallLogo");
            return (Criteria) this;
        }

        public Criteria andMallLogoNotBetween(String value1, String value2) {
            addCriterion("mall_logo not between", value1, value2, "mallLogo");
            return (Criteria) this;
        }

        public Criteria andMallParkingIsNull() {
            addCriterion("mall_parking is null");
            return (Criteria) this;
        }

        public Criteria andMallParkingIsNotNull() {
            addCriterion("mall_parking is not null");
            return (Criteria) this;
        }

        public Criteria andMallParkingEqualTo(Integer value) {
            addCriterion("mall_parking =", value, "mallParking");
            return (Criteria) this;
        }

        public Criteria andMallParkingNotEqualTo(Integer value) {
            addCriterion("mall_parking <>", value, "mallParking");
            return (Criteria) this;
        }

        public Criteria andMallParkingGreaterThan(Integer value) {
            addCriterion("mall_parking >", value, "mallParking");
            return (Criteria) this;
        }

        public Criteria andMallParkingGreaterThanOrEqualTo(Integer value) {
            addCriterion("mall_parking >=", value, "mallParking");
            return (Criteria) this;
        }

        public Criteria andMallParkingLessThan(Integer value) {
            addCriterion("mall_parking <", value, "mallParking");
            return (Criteria) this;
        }

        public Criteria andMallParkingLessThanOrEqualTo(Integer value) {
            addCriterion("mall_parking <=", value, "mallParking");
            return (Criteria) this;
        }

        public Criteria andMallParkingIn(List<Integer> values) {
            addCriterion("mall_parking in", values, "mallParking");
            return (Criteria) this;
        }

        public Criteria andMallParkingNotIn(List<Integer> values) {
            addCriterion("mall_parking not in", values, "mallParking");
            return (Criteria) this;
        }

        public Criteria andMallParkingBetween(Integer value1, Integer value2) {
            addCriterion("mall_parking between", value1, value2, "mallParking");
            return (Criteria) this;
        }

        public Criteria andMallParkingNotBetween(Integer value1, Integer value2) {
            addCriterion("mall_parking not between", value1, value2, "mallParking");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyIsNull() {
            addCriterion("mall_property_company is null");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyIsNotNull() {
            addCriterion("mall_property_company is not null");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyEqualTo(String value) {
            addCriterion("mall_property_company =", value, "mallPropertyCompany");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyNotEqualTo(String value) {
            addCriterion("mall_property_company <>", value, "mallPropertyCompany");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyGreaterThan(String value) {
            addCriterion("mall_property_company >", value, "mallPropertyCompany");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("mall_property_company >=", value, "mallPropertyCompany");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyLessThan(String value) {
            addCriterion("mall_property_company <", value, "mallPropertyCompany");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyLessThanOrEqualTo(String value) {
            addCriterion("mall_property_company <=", value, "mallPropertyCompany");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyLike(String value) {
            addCriterion("mall_property_company like", value, "mallPropertyCompany");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyNotLike(String value) {
            addCriterion("mall_property_company not like", value, "mallPropertyCompany");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyIn(List<String> values) {
            addCriterion("mall_property_company in", values, "mallPropertyCompany");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyNotIn(List<String> values) {
            addCriterion("mall_property_company not in", values, "mallPropertyCompany");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyBetween(String value1, String value2) {
            addCriterion("mall_property_company between", value1, value2, "mallPropertyCompany");
            return (Criteria) this;
        }

        public Criteria andMallPropertyCompanyNotBetween(String value1, String value2) {
            addCriterion("mall_property_company not between", value1, value2, "mallPropertyCompany");
            return (Criteria) this;
        }

        public Criteria andMallRentSizeIsNull() {
            addCriterion("mall_rent_size is null");
            return (Criteria) this;
        }

        public Criteria andMallRentSizeIsNotNull() {
            addCriterion("mall_rent_size is not null");
            return (Criteria) this;
        }

        public Criteria andMallRentSizeEqualTo(Integer value) {
            addCriterion("mall_rent_size =", value, "mallRentSize");
            return (Criteria) this;
        }

        public Criteria andMallRentSizeNotEqualTo(Integer value) {
            addCriterion("mall_rent_size <>", value, "mallRentSize");
            return (Criteria) this;
        }

        public Criteria andMallRentSizeGreaterThan(Integer value) {
            addCriterion("mall_rent_size >", value, "mallRentSize");
            return (Criteria) this;
        }

        public Criteria andMallRentSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mall_rent_size >=", value, "mallRentSize");
            return (Criteria) this;
        }

        public Criteria andMallRentSizeLessThan(Integer value) {
            addCriterion("mall_rent_size <", value, "mallRentSize");
            return (Criteria) this;
        }

        public Criteria andMallRentSizeLessThanOrEqualTo(Integer value) {
            addCriterion("mall_rent_size <=", value, "mallRentSize");
            return (Criteria) this;
        }

        public Criteria andMallRentSizeIn(List<Integer> values) {
            addCriterion("mall_rent_size in", values, "mallRentSize");
            return (Criteria) this;
        }

        public Criteria andMallRentSizeNotIn(List<Integer> values) {
            addCriterion("mall_rent_size not in", values, "mallRentSize");
            return (Criteria) this;
        }

        public Criteria andMallRentSizeBetween(Integer value1, Integer value2) {
            addCriterion("mall_rent_size between", value1, value2, "mallRentSize");
            return (Criteria) this;
        }

        public Criteria andMallRentSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("mall_rent_size not between", value1, value2, "mallRentSize");
            return (Criteria) this;
        }

        public Criteria andMallTelIsNull() {
            addCriterion("mall_tel is null");
            return (Criteria) this;
        }

        public Criteria andMallTelIsNotNull() {
            addCriterion("mall_tel is not null");
            return (Criteria) this;
        }

        public Criteria andMallTelEqualTo(String value) {
            addCriterion("mall_tel =", value, "mallTel");
            return (Criteria) this;
        }

        public Criteria andMallTelNotEqualTo(String value) {
            addCriterion("mall_tel <>", value, "mallTel");
            return (Criteria) this;
        }

        public Criteria andMallTelGreaterThan(String value) {
            addCriterion("mall_tel >", value, "mallTel");
            return (Criteria) this;
        }

        public Criteria andMallTelGreaterThanOrEqualTo(String value) {
            addCriterion("mall_tel >=", value, "mallTel");
            return (Criteria) this;
        }

        public Criteria andMallTelLessThan(String value) {
            addCriterion("mall_tel <", value, "mallTel");
            return (Criteria) this;
        }

        public Criteria andMallTelLessThanOrEqualTo(String value) {
            addCriterion("mall_tel <=", value, "mallTel");
            return (Criteria) this;
        }

        public Criteria andMallTelLike(String value) {
            addCriterion("mall_tel like", value, "mallTel");
            return (Criteria) this;
        }

        public Criteria andMallTelNotLike(String value) {
            addCriterion("mall_tel not like", value, "mallTel");
            return (Criteria) this;
        }

        public Criteria andMallTelIn(List<String> values) {
            addCriterion("mall_tel in", values, "mallTel");
            return (Criteria) this;
        }

        public Criteria andMallTelNotIn(List<String> values) {
            addCriterion("mall_tel not in", values, "mallTel");
            return (Criteria) this;
        }

        public Criteria andMallTelBetween(String value1, String value2) {
            addCriterion("mall_tel between", value1, value2, "mallTel");
            return (Criteria) this;
        }

        public Criteria andMallTelNotBetween(String value1, String value2) {
            addCriterion("mall_tel not between", value1, value2, "mallTel");
            return (Criteria) this;
        }

        public Criteria andMallTypeIsNull() {
            addCriterion("mall_type is null");
            return (Criteria) this;
        }

        public Criteria andMallTypeIsNotNull() {
            addCriterion("mall_type is not null");
            return (Criteria) this;
        }

        public Criteria andMallTypeEqualTo(String value) {
            addCriterion("mall_type =", value, "mallType");
            return (Criteria) this;
        }

        public Criteria andMallTypeNotEqualTo(String value) {
            addCriterion("mall_type <>", value, "mallType");
            return (Criteria) this;
        }

        public Criteria andMallTypeGreaterThan(String value) {
            addCriterion("mall_type >", value, "mallType");
            return (Criteria) this;
        }

        public Criteria andMallTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mall_type >=", value, "mallType");
            return (Criteria) this;
        }

        public Criteria andMallTypeLessThan(String value) {
            addCriterion("mall_type <", value, "mallType");
            return (Criteria) this;
        }

        public Criteria andMallTypeLessThanOrEqualTo(String value) {
            addCriterion("mall_type <=", value, "mallType");
            return (Criteria) this;
        }

        public Criteria andMallTypeLike(String value) {
            addCriterion("mall_type like", value, "mallType");
            return (Criteria) this;
        }

        public Criteria andMallTypeNotLike(String value) {
            addCriterion("mall_type not like", value, "mallType");
            return (Criteria) this;
        }

        public Criteria andMallTypeIn(List<String> values) {
            addCriterion("mall_type in", values, "mallType");
            return (Criteria) this;
        }

        public Criteria andMallTypeNotIn(List<String> values) {
            addCriterion("mall_type not in", values, "mallType");
            return (Criteria) this;
        }

        public Criteria andMallTypeBetween(String value1, String value2) {
            addCriterion("mall_type between", value1, value2, "mallType");
            return (Criteria) this;
        }

        public Criteria andMallTypeNotBetween(String value1, String value2) {
            addCriterion("mall_type not between", value1, value2, "mallType");
            return (Criteria) this;
        }

        public Criteria andMallUnderFloorIsNull() {
            addCriterion("mall_under_floor is null");
            return (Criteria) this;
        }

        public Criteria andMallUnderFloorIsNotNull() {
            addCriterion("mall_under_floor is not null");
            return (Criteria) this;
        }

        public Criteria andMallUnderFloorEqualTo(Byte value) {
            addCriterion("mall_under_floor =", value, "mallUnderFloor");
            return (Criteria) this;
        }

        public Criteria andMallUnderFloorNotEqualTo(Byte value) {
            addCriterion("mall_under_floor <>", value, "mallUnderFloor");
            return (Criteria) this;
        }

        public Criteria andMallUnderFloorGreaterThan(Byte value) {
            addCriterion("mall_under_floor >", value, "mallUnderFloor");
            return (Criteria) this;
        }

        public Criteria andMallUnderFloorGreaterThanOrEqualTo(Byte value) {
            addCriterion("mall_under_floor >=", value, "mallUnderFloor");
            return (Criteria) this;
        }

        public Criteria andMallUnderFloorLessThan(Byte value) {
            addCriterion("mall_under_floor <", value, "mallUnderFloor");
            return (Criteria) this;
        }

        public Criteria andMallUnderFloorLessThanOrEqualTo(Byte value) {
            addCriterion("mall_under_floor <=", value, "mallUnderFloor");
            return (Criteria) this;
        }

        public Criteria andMallUnderFloorIn(List<Byte> values) {
            addCriterion("mall_under_floor in", values, "mallUnderFloor");
            return (Criteria) this;
        }

        public Criteria andMallUnderFloorNotIn(List<Byte> values) {
            addCriterion("mall_under_floor not in", values, "mallUnderFloor");
            return (Criteria) this;
        }

        public Criteria andMallUnderFloorBetween(Byte value1, Byte value2) {
            addCriterion("mall_under_floor between", value1, value2, "mallUnderFloor");
            return (Criteria) this;
        }

        public Criteria andMallUnderFloorNotBetween(Byte value1, Byte value2) {
            addCriterion("mall_under_floor not between", value1, value2, "mallUnderFloor");
            return (Criteria) this;
        }

        public Criteria andMallUpperFloorIsNull() {
            addCriterion("mall_upper_floor is null");
            return (Criteria) this;
        }

        public Criteria andMallUpperFloorIsNotNull() {
            addCriterion("mall_upper_floor is not null");
            return (Criteria) this;
        }

        public Criteria andMallUpperFloorEqualTo(Byte value) {
            addCriterion("mall_upper_floor =", value, "mallUpperFloor");
            return (Criteria) this;
        }

        public Criteria andMallUpperFloorNotEqualTo(Byte value) {
            addCriterion("mall_upper_floor <>", value, "mallUpperFloor");
            return (Criteria) this;
        }

        public Criteria andMallUpperFloorGreaterThan(Byte value) {
            addCriterion("mall_upper_floor >", value, "mallUpperFloor");
            return (Criteria) this;
        }

        public Criteria andMallUpperFloorGreaterThanOrEqualTo(Byte value) {
            addCriterion("mall_upper_floor >=", value, "mallUpperFloor");
            return (Criteria) this;
        }

        public Criteria andMallUpperFloorLessThan(Byte value) {
            addCriterion("mall_upper_floor <", value, "mallUpperFloor");
            return (Criteria) this;
        }

        public Criteria andMallUpperFloorLessThanOrEqualTo(Byte value) {
            addCriterion("mall_upper_floor <=", value, "mallUpperFloor");
            return (Criteria) this;
        }

        public Criteria andMallUpperFloorIn(List<Byte> values) {
            addCriterion("mall_upper_floor in", values, "mallUpperFloor");
            return (Criteria) this;
        }

        public Criteria andMallUpperFloorNotIn(List<Byte> values) {
            addCriterion("mall_upper_floor not in", values, "mallUpperFloor");
            return (Criteria) this;
        }

        public Criteria andMallUpperFloorBetween(Byte value1, Byte value2) {
            addCriterion("mall_upper_floor between", value1, value2, "mallUpperFloor");
            return (Criteria) this;
        }

        public Criteria andMallUpperFloorNotBetween(Byte value1, Byte value2) {
            addCriterion("mall_upper_floor not between", value1, value2, "mallUpperFloor");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteIsNull() {
            addCriterion("mall_website is null");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteIsNotNull() {
            addCriterion("mall_website is not null");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteEqualTo(String value) {
            addCriterion("mall_website =", value, "mallWebsite");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteNotEqualTo(String value) {
            addCriterion("mall_website <>", value, "mallWebsite");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteGreaterThan(String value) {
            addCriterion("mall_website >", value, "mallWebsite");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("mall_website >=", value, "mallWebsite");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteLessThan(String value) {
            addCriterion("mall_website <", value, "mallWebsite");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteLessThanOrEqualTo(String value) {
            addCriterion("mall_website <=", value, "mallWebsite");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteLike(String value) {
            addCriterion("mall_website like", value, "mallWebsite");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteNotLike(String value) {
            addCriterion("mall_website not like", value, "mallWebsite");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteIn(List<String> values) {
            addCriterion("mall_website in", values, "mallWebsite");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteNotIn(List<String> values) {
            addCriterion("mall_website not in", values, "mallWebsite");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteBetween(String value1, String value2) {
            addCriterion("mall_website between", value1, value2, "mallWebsite");
            return (Criteria) this;
        }

        public Criteria andMallWebsiteNotBetween(String value1, String value2) {
            addCriterion("mall_website not between", value1, value2, "mallWebsite");
            return (Criteria) this;
        }

        public Criteria andMallWeiboIsNull() {
            addCriterion("mall_weibo is null");
            return (Criteria) this;
        }

        public Criteria andMallWeiboIsNotNull() {
            addCriterion("mall_weibo is not null");
            return (Criteria) this;
        }

        public Criteria andMallWeiboEqualTo(String value) {
            addCriterion("mall_weibo =", value, "mallWeibo");
            return (Criteria) this;
        }

        public Criteria andMallWeiboNotEqualTo(String value) {
            addCriterion("mall_weibo <>", value, "mallWeibo");
            return (Criteria) this;
        }

        public Criteria andMallWeiboGreaterThan(String value) {
            addCriterion("mall_weibo >", value, "mallWeibo");
            return (Criteria) this;
        }

        public Criteria andMallWeiboGreaterThanOrEqualTo(String value) {
            addCriterion("mall_weibo >=", value, "mallWeibo");
            return (Criteria) this;
        }

        public Criteria andMallWeiboLessThan(String value) {
            addCriterion("mall_weibo <", value, "mallWeibo");
            return (Criteria) this;
        }

        public Criteria andMallWeiboLessThanOrEqualTo(String value) {
            addCriterion("mall_weibo <=", value, "mallWeibo");
            return (Criteria) this;
        }

        public Criteria andMallWeiboLike(String value) {
            addCriterion("mall_weibo like", value, "mallWeibo");
            return (Criteria) this;
        }

        public Criteria andMallWeiboNotLike(String value) {
            addCriterion("mall_weibo not like", value, "mallWeibo");
            return (Criteria) this;
        }

        public Criteria andMallWeiboIn(List<String> values) {
            addCriterion("mall_weibo in", values, "mallWeibo");
            return (Criteria) this;
        }

        public Criteria andMallWeiboNotIn(List<String> values) {
            addCriterion("mall_weibo not in", values, "mallWeibo");
            return (Criteria) this;
        }

        public Criteria andMallWeiboBetween(String value1, String value2) {
            addCriterion("mall_weibo between", value1, value2, "mallWeibo");
            return (Criteria) this;
        }

        public Criteria andMallWeiboNotBetween(String value1, String value2) {
            addCriterion("mall_weibo not between", value1, value2, "mallWeibo");
            return (Criteria) this;
        }

        public Criteria andMallWeixinIsNull() {
            addCriterion("mall_weixin is null");
            return (Criteria) this;
        }

        public Criteria andMallWeixinIsNotNull() {
            addCriterion("mall_weixin is not null");
            return (Criteria) this;
        }

        public Criteria andMallWeixinEqualTo(String value) {
            addCriterion("mall_weixin =", value, "mallWeixin");
            return (Criteria) this;
        }

        public Criteria andMallWeixinNotEqualTo(String value) {
            addCriterion("mall_weixin <>", value, "mallWeixin");
            return (Criteria) this;
        }

        public Criteria andMallWeixinGreaterThan(String value) {
            addCriterion("mall_weixin >", value, "mallWeixin");
            return (Criteria) this;
        }

        public Criteria andMallWeixinGreaterThanOrEqualTo(String value) {
            addCriterion("mall_weixin >=", value, "mallWeixin");
            return (Criteria) this;
        }

        public Criteria andMallWeixinLessThan(String value) {
            addCriterion("mall_weixin <", value, "mallWeixin");
            return (Criteria) this;
        }

        public Criteria andMallWeixinLessThanOrEqualTo(String value) {
            addCriterion("mall_weixin <=", value, "mallWeixin");
            return (Criteria) this;
        }

        public Criteria andMallWeixinLike(String value) {
            addCriterion("mall_weixin like", value, "mallWeixin");
            return (Criteria) this;
        }

        public Criteria andMallWeixinNotLike(String value) {
            addCriterion("mall_weixin not like", value, "mallWeixin");
            return (Criteria) this;
        }

        public Criteria andMallWeixinIn(List<String> values) {
            addCriterion("mall_weixin in", values, "mallWeixin");
            return (Criteria) this;
        }

        public Criteria andMallWeixinNotIn(List<String> values) {
            addCriterion("mall_weixin not in", values, "mallWeixin");
            return (Criteria) this;
        }

        public Criteria andMallWeixinBetween(String value1, String value2) {
            addCriterion("mall_weixin between", value1, value2, "mallWeixin");
            return (Criteria) this;
        }

        public Criteria andMallWeixinNotBetween(String value1, String value2) {
            addCriterion("mall_weixin not between", value1, value2, "mallWeixin");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelIdIsNull() {
            addCriterion("spider_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelIdIsNotNull() {
            addCriterion("spider_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelIdEqualTo(Integer value) {
            addCriterion("spider_channel_id =", value, "spiderChannelId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelIdNotEqualTo(Integer value) {
            addCriterion("spider_channel_id <>", value, "spiderChannelId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelIdGreaterThan(Integer value) {
            addCriterion("spider_channel_id >", value, "spiderChannelId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("spider_channel_id >=", value, "spiderChannelId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelIdLessThan(Integer value) {
            addCriterion("spider_channel_id <", value, "spiderChannelId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("spider_channel_id <=", value, "spiderChannelId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelIdIn(List<Integer> values) {
            addCriterion("spider_channel_id in", values, "spiderChannelId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelIdNotIn(List<Integer> values) {
            addCriterion("spider_channel_id not in", values, "spiderChannelId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("spider_channel_id between", value1, value2, "spiderChannelId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("spider_channel_id not between", value1, value2, "spiderChannelId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelWebIdIsNull() {
            addCriterion("spider_channel_web_id is null");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelWebIdIsNotNull() {
            addCriterion("spider_channel_web_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelWebIdEqualTo(Integer value) {
            addCriterion("spider_channel_web_id =", value, "spiderChannelWebId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelWebIdNotEqualTo(Integer value) {
            addCriterion("spider_channel_web_id <>", value, "spiderChannelWebId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelWebIdGreaterThan(Integer value) {
            addCriterion("spider_channel_web_id >", value, "spiderChannelWebId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelWebIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("spider_channel_web_id >=", value, "spiderChannelWebId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelWebIdLessThan(Integer value) {
            addCriterion("spider_channel_web_id <", value, "spiderChannelWebId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelWebIdLessThanOrEqualTo(Integer value) {
            addCriterion("spider_channel_web_id <=", value, "spiderChannelWebId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelWebIdIn(List<Integer> values) {
            addCriterion("spider_channel_web_id in", values, "spiderChannelWebId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelWebIdNotIn(List<Integer> values) {
            addCriterion("spider_channel_web_id not in", values, "spiderChannelWebId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelWebIdBetween(Integer value1, Integer value2) {
            addCriterion("spider_channel_web_id between", value1, value2, "spiderChannelWebId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelWebIdNotBetween(Integer value1, Integer value2) {
            addCriterion("spider_channel_web_id not between", value1, value2, "spiderChannelWebId");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotIsNull() {
            addCriterion("spider_channel_hot is null");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotIsNotNull() {
            addCriterion("spider_channel_hot is not null");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotEqualTo(Integer value) {
            addCriterion("spider_channel_hot =", value, "spiderChannelHot");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotNotEqualTo(Integer value) {
            addCriterion("spider_channel_hot <>", value, "spiderChannelHot");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotGreaterThan(Integer value) {
            addCriterion("spider_channel_hot >", value, "spiderChannelHot");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("spider_channel_hot >=", value, "spiderChannelHot");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotLessThan(Integer value) {
            addCriterion("spider_channel_hot <", value, "spiderChannelHot");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotLessThanOrEqualTo(Integer value) {
            addCriterion("spider_channel_hot <=", value, "spiderChannelHot");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotIn(List<Integer> values) {
            addCriterion("spider_channel_hot in", values, "spiderChannelHot");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotNotIn(List<Integer> values) {
            addCriterion("spider_channel_hot not in", values, "spiderChannelHot");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotBetween(Integer value1, Integer value2) {
            addCriterion("spider_channel_hot between", value1, value2, "spiderChannelHot");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotNotBetween(Integer value1, Integer value2) {
            addCriterion("spider_channel_hot not between", value1, value2, "spiderChannelHot");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotOldIsNull() {
            addCriterion("spider_channel_hot_old is null");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotOldIsNotNull() {
            addCriterion("spider_channel_hot_old is not null");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotOldEqualTo(Integer value) {
            addCriterion("spider_channel_hot_old =", value, "spiderChannelHotOld");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotOldNotEqualTo(Integer value) {
            addCriterion("spider_channel_hot_old <>", value, "spiderChannelHotOld");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotOldGreaterThan(Integer value) {
            addCriterion("spider_channel_hot_old >", value, "spiderChannelHotOld");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotOldGreaterThanOrEqualTo(Integer value) {
            addCriterion("spider_channel_hot_old >=", value, "spiderChannelHotOld");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotOldLessThan(Integer value) {
            addCriterion("spider_channel_hot_old <", value, "spiderChannelHotOld");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotOldLessThanOrEqualTo(Integer value) {
            addCriterion("spider_channel_hot_old <=", value, "spiderChannelHotOld");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotOldIn(List<Integer> values) {
            addCriterion("spider_channel_hot_old in", values, "spiderChannelHotOld");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotOldNotIn(List<Integer> values) {
            addCriterion("spider_channel_hot_old not in", values, "spiderChannelHotOld");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotOldBetween(Integer value1, Integer value2) {
            addCriterion("spider_channel_hot_old between", value1, value2, "spiderChannelHotOld");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotOldNotBetween(Integer value1, Integer value2) {
            addCriterion("spider_channel_hot_old not between", value1, value2, "spiderChannelHotOld");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotUpIsNull() {
            addCriterion("spider_channel_hot_up is null");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotUpIsNotNull() {
            addCriterion("spider_channel_hot_up is not null");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotUpEqualTo(Integer value) {
            addCriterion("spider_channel_hot_up =", value, "spiderChannelHotUp");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotUpNotEqualTo(Integer value) {
            addCriterion("spider_channel_hot_up <>", value, "spiderChannelHotUp");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotUpGreaterThan(Integer value) {
            addCriterion("spider_channel_hot_up >", value, "spiderChannelHotUp");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotUpGreaterThanOrEqualTo(Integer value) {
            addCriterion("spider_channel_hot_up >=", value, "spiderChannelHotUp");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotUpLessThan(Integer value) {
            addCriterion("spider_channel_hot_up <", value, "spiderChannelHotUp");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotUpLessThanOrEqualTo(Integer value) {
            addCriterion("spider_channel_hot_up <=", value, "spiderChannelHotUp");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotUpIn(List<Integer> values) {
            addCriterion("spider_channel_hot_up in", values, "spiderChannelHotUp");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotUpNotIn(List<Integer> values) {
            addCriterion("spider_channel_hot_up not in", values, "spiderChannelHotUp");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotUpBetween(Integer value1, Integer value2) {
            addCriterion("spider_channel_hot_up between", value1, value2, "spiderChannelHotUp");
            return (Criteria) this;
        }

        public Criteria andSpiderChannelHotUpNotBetween(Integer value1, Integer value2) {
            addCriterion("spider_channel_hot_up not between", value1, value2, "spiderChannelHotUp");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameIsNull() {
            addCriterion("mall_search_name is null");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameIsNotNull() {
            addCriterion("mall_search_name is not null");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameEqualTo(String value) {
            addCriterion("mall_search_name =", value, "mallSearchName");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameNotEqualTo(String value) {
            addCriterion("mall_search_name <>", value, "mallSearchName");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameGreaterThan(String value) {
            addCriterion("mall_search_name >", value, "mallSearchName");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameGreaterThanOrEqualTo(String value) {
            addCriterion("mall_search_name >=", value, "mallSearchName");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameLessThan(String value) {
            addCriterion("mall_search_name <", value, "mallSearchName");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameLessThanOrEqualTo(String value) {
            addCriterion("mall_search_name <=", value, "mallSearchName");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameLike(String value) {
            addCriterion("mall_search_name like", value, "mallSearchName");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameNotLike(String value) {
            addCriterion("mall_search_name not like", value, "mallSearchName");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameIn(List<String> values) {
            addCriterion("mall_search_name in", values, "mallSearchName");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameNotIn(List<String> values) {
            addCriterion("mall_search_name not in", values, "mallSearchName");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameBetween(String value1, String value2) {
            addCriterion("mall_search_name between", value1, value2, "mallSearchName");
            return (Criteria) this;
        }

        public Criteria andMallSearchNameNotBetween(String value1, String value2) {
            addCriterion("mall_search_name not between", value1, value2, "mallSearchName");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlIsNull() {
            addCriterion("mall_baike_url is null");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlIsNotNull() {
            addCriterion("mall_baike_url is not null");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlEqualTo(String value) {
            addCriterion("mall_baike_url =", value, "mallBaikeUrl");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlNotEqualTo(String value) {
            addCriterion("mall_baike_url <>", value, "mallBaikeUrl");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlGreaterThan(String value) {
            addCriterion("mall_baike_url >", value, "mallBaikeUrl");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("mall_baike_url >=", value, "mallBaikeUrl");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlLessThan(String value) {
            addCriterion("mall_baike_url <", value, "mallBaikeUrl");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlLessThanOrEqualTo(String value) {
            addCriterion("mall_baike_url <=", value, "mallBaikeUrl");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlLike(String value) {
            addCriterion("mall_baike_url like", value, "mallBaikeUrl");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlNotLike(String value) {
            addCriterion("mall_baike_url not like", value, "mallBaikeUrl");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlIn(List<String> values) {
            addCriterion("mall_baike_url in", values, "mallBaikeUrl");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlNotIn(List<String> values) {
            addCriterion("mall_baike_url not in", values, "mallBaikeUrl");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlBetween(String value1, String value2) {
            addCriterion("mall_baike_url between", value1, value2, "mallBaikeUrl");
            return (Criteria) this;
        }

        public Criteria andMallBaikeUrlNotBetween(String value1, String value2) {
            addCriterion("mall_baike_url not between", value1, value2, "mallBaikeUrl");
            return (Criteria) this;
        }

        public Criteria andMallInWebIsNull() {
            addCriterion("mall_in_web is null");
            return (Criteria) this;
        }

        public Criteria andMallInWebIsNotNull() {
            addCriterion("mall_in_web is not null");
            return (Criteria) this;
        }

        public Criteria andMallInWebEqualTo(Byte value) {
            addCriterion("mall_in_web =", value, "mallInWeb");
            return (Criteria) this;
        }

        public Criteria andMallInWebNotEqualTo(Byte value) {
            addCriterion("mall_in_web <>", value, "mallInWeb");
            return (Criteria) this;
        }

        public Criteria andMallInWebGreaterThan(Byte value) {
            addCriterion("mall_in_web >", value, "mallInWeb");
            return (Criteria) this;
        }

        public Criteria andMallInWebGreaterThanOrEqualTo(Byte value) {
            addCriterion("mall_in_web >=", value, "mallInWeb");
            return (Criteria) this;
        }

        public Criteria andMallInWebLessThan(Byte value) {
            addCriterion("mall_in_web <", value, "mallInWeb");
            return (Criteria) this;
        }

        public Criteria andMallInWebLessThanOrEqualTo(Byte value) {
            addCriterion("mall_in_web <=", value, "mallInWeb");
            return (Criteria) this;
        }

        public Criteria andMallInWebIn(List<Byte> values) {
            addCriterion("mall_in_web in", values, "mallInWeb");
            return (Criteria) this;
        }

        public Criteria andMallInWebNotIn(List<Byte> values) {
            addCriterion("mall_in_web not in", values, "mallInWeb");
            return (Criteria) this;
        }

        public Criteria andMallInWebBetween(Byte value1, Byte value2) {
            addCriterion("mall_in_web between", value1, value2, "mallInWeb");
            return (Criteria) this;
        }

        public Criteria andMallInWebNotBetween(Byte value1, Byte value2) {
            addCriterion("mall_in_web not between", value1, value2, "mallInWeb");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursIsNull() {
            addCriterion("weekday_hours is null");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursIsNotNull() {
            addCriterion("weekday_hours is not null");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursEqualTo(String value) {
            addCriterion("weekday_hours =", value, "weekdayHours");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursNotEqualTo(String value) {
            addCriterion("weekday_hours <>", value, "weekdayHours");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursGreaterThan(String value) {
            addCriterion("weekday_hours >", value, "weekdayHours");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursGreaterThanOrEqualTo(String value) {
            addCriterion("weekday_hours >=", value, "weekdayHours");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursLessThan(String value) {
            addCriterion("weekday_hours <", value, "weekdayHours");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursLessThanOrEqualTo(String value) {
            addCriterion("weekday_hours <=", value, "weekdayHours");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursLike(String value) {
            addCriterion("weekday_hours like", value, "weekdayHours");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursNotLike(String value) {
            addCriterion("weekday_hours not like", value, "weekdayHours");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursIn(List<String> values) {
            addCriterion("weekday_hours in", values, "weekdayHours");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursNotIn(List<String> values) {
            addCriterion("weekday_hours not in", values, "weekdayHours");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursBetween(String value1, String value2) {
            addCriterion("weekday_hours between", value1, value2, "weekdayHours");
            return (Criteria) this;
        }

        public Criteria andWeekdayHoursNotBetween(String value1, String value2) {
            addCriterion("weekday_hours not between", value1, value2, "weekdayHours");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursIsNull() {
            addCriterion("weekend_hours is null");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursIsNotNull() {
            addCriterion("weekend_hours is not null");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursEqualTo(String value) {
            addCriterion("weekend_hours =", value, "weekendHours");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursNotEqualTo(String value) {
            addCriterion("weekend_hours <>", value, "weekendHours");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursGreaterThan(String value) {
            addCriterion("weekend_hours >", value, "weekendHours");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursGreaterThanOrEqualTo(String value) {
            addCriterion("weekend_hours >=", value, "weekendHours");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursLessThan(String value) {
            addCriterion("weekend_hours <", value, "weekendHours");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursLessThanOrEqualTo(String value) {
            addCriterion("weekend_hours <=", value, "weekendHours");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursLike(String value) {
            addCriterion("weekend_hours like", value, "weekendHours");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursNotLike(String value) {
            addCriterion("weekend_hours not like", value, "weekendHours");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursIn(List<String> values) {
            addCriterion("weekend_hours in", values, "weekendHours");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursNotIn(List<String> values) {
            addCriterion("weekend_hours not in", values, "weekendHours");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursBetween(String value1, String value2) {
            addCriterion("weekend_hours between", value1, value2, "weekendHours");
            return (Criteria) this;
        }

        public Criteria andWeekendHoursNotBetween(String value1, String value2) {
            addCriterion("weekend_hours not between", value1, value2, "weekendHours");
            return (Criteria) this;
        }

        public Criteria andBusinessCircleIdIsNull() {
            addCriterion("business_circle_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessCircleIdIsNotNull() {
            addCriterion("business_circle_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessCircleIdEqualTo(Integer value) {
            addCriterion("business_circle_id =", value, "businessCircleId");
            return (Criteria) this;
        }

        public Criteria andBusinessCircleIdNotEqualTo(Integer value) {
            addCriterion("business_circle_id <>", value, "businessCircleId");
            return (Criteria) this;
        }

        public Criteria andBusinessCircleIdGreaterThan(Integer value) {
            addCriterion("business_circle_id >", value, "businessCircleId");
            return (Criteria) this;
        }

        public Criteria andBusinessCircleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("business_circle_id >=", value, "businessCircleId");
            return (Criteria) this;
        }

        public Criteria andBusinessCircleIdLessThan(Integer value) {
            addCriterion("business_circle_id <", value, "businessCircleId");
            return (Criteria) this;
        }

        public Criteria andBusinessCircleIdLessThanOrEqualTo(Integer value) {
            addCriterion("business_circle_id <=", value, "businessCircleId");
            return (Criteria) this;
        }

        public Criteria andBusinessCircleIdIn(List<Integer> values) {
            addCriterion("business_circle_id in", values, "businessCircleId");
            return (Criteria) this;
        }

        public Criteria andBusinessCircleIdNotIn(List<Integer> values) {
            addCriterion("business_circle_id not in", values, "businessCircleId");
            return (Criteria) this;
        }

        public Criteria andBusinessCircleIdBetween(Integer value1, Integer value2) {
            addCriterion("business_circle_id between", value1, value2, "businessCircleId");
            return (Criteria) this;
        }

        public Criteria andBusinessCircleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("business_circle_id not between", value1, value2, "businessCircleId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andMallHasContactIsNull() {
            addCriterion("mall_has_contact is null");
            return (Criteria) this;
        }

        public Criteria andMallHasContactIsNotNull() {
            addCriterion("mall_has_contact is not null");
            return (Criteria) this;
        }

        public Criteria andMallHasContactEqualTo(Byte value) {
            addCriterion("mall_has_contact =", value, "mallHasContact");
            return (Criteria) this;
        }

        public Criteria andMallHasContactNotEqualTo(Byte value) {
            addCriterion("mall_has_contact <>", value, "mallHasContact");
            return (Criteria) this;
        }

        public Criteria andMallHasContactGreaterThan(Byte value) {
            addCriterion("mall_has_contact >", value, "mallHasContact");
            return (Criteria) this;
        }

        public Criteria andMallHasContactGreaterThanOrEqualTo(Byte value) {
            addCriterion("mall_has_contact >=", value, "mallHasContact");
            return (Criteria) this;
        }

        public Criteria andMallHasContactLessThan(Byte value) {
            addCriterion("mall_has_contact <", value, "mallHasContact");
            return (Criteria) this;
        }

        public Criteria andMallHasContactLessThanOrEqualTo(Byte value) {
            addCriterion("mall_has_contact <=", value, "mallHasContact");
            return (Criteria) this;
        }

        public Criteria andMallHasContactIn(List<Byte> values) {
            addCriterion("mall_has_contact in", values, "mallHasContact");
            return (Criteria) this;
        }

        public Criteria andMallHasContactNotIn(List<Byte> values) {
            addCriterion("mall_has_contact not in", values, "mallHasContact");
            return (Criteria) this;
        }

        public Criteria andMallHasContactBetween(Byte value1, Byte value2) {
            addCriterion("mall_has_contact between", value1, value2, "mallHasContact");
            return (Criteria) this;
        }

        public Criteria andMallHasContactNotBetween(Byte value1, Byte value2) {
            addCriterion("mall_has_contact not between", value1, value2, "mallHasContact");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionIsNull() {
            addCriterion("mall_search_option is null");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionIsNotNull() {
            addCriterion("mall_search_option is not null");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionEqualTo(String value) {
            addCriterion("mall_search_option =", value, "mallSearchOption");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionNotEqualTo(String value) {
            addCriterion("mall_search_option <>", value, "mallSearchOption");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionGreaterThan(String value) {
            addCriterion("mall_search_option >", value, "mallSearchOption");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionGreaterThanOrEqualTo(String value) {
            addCriterion("mall_search_option >=", value, "mallSearchOption");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionLessThan(String value) {
            addCriterion("mall_search_option <", value, "mallSearchOption");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionLessThanOrEqualTo(String value) {
            addCriterion("mall_search_option <=", value, "mallSearchOption");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionLike(String value) {
            addCriterion("mall_search_option like", value, "mallSearchOption");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionNotLike(String value) {
            addCriterion("mall_search_option not like", value, "mallSearchOption");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionIn(List<String> values) {
            addCriterion("mall_search_option in", values, "mallSearchOption");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionNotIn(List<String> values) {
            addCriterion("mall_search_option not in", values, "mallSearchOption");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionBetween(String value1, String value2) {
            addCriterion("mall_search_option between", value1, value2, "mallSearchOption");
            return (Criteria) this;
        }

        public Criteria andMallSearchOptionNotBetween(String value1, String value2) {
            addCriterion("mall_search_option not between", value1, value2, "mallSearchOption");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsIsNull() {
            addCriterion("mall_search_keywords is null");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsIsNotNull() {
            addCriterion("mall_search_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsEqualTo(String value) {
            addCriterion("mall_search_keywords =", value, "mallSearchKeywords");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsNotEqualTo(String value) {
            addCriterion("mall_search_keywords <>", value, "mallSearchKeywords");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsGreaterThan(String value) {
            addCriterion("mall_search_keywords >", value, "mallSearchKeywords");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("mall_search_keywords >=", value, "mallSearchKeywords");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsLessThan(String value) {
            addCriterion("mall_search_keywords <", value, "mallSearchKeywords");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsLessThanOrEqualTo(String value) {
            addCriterion("mall_search_keywords <=", value, "mallSearchKeywords");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsLike(String value) {
            addCriterion("mall_search_keywords like", value, "mallSearchKeywords");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsNotLike(String value) {
            addCriterion("mall_search_keywords not like", value, "mallSearchKeywords");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsIn(List<String> values) {
            addCriterion("mall_search_keywords in", values, "mallSearchKeywords");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsNotIn(List<String> values) {
            addCriterion("mall_search_keywords not in", values, "mallSearchKeywords");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsBetween(String value1, String value2) {
            addCriterion("mall_search_keywords between", value1, value2, "mallSearchKeywords");
            return (Criteria) this;
        }

        public Criteria andMallSearchKeywordsNotBetween(String value1, String value2) {
            addCriterion("mall_search_keywords not between", value1, value2, "mallSearchKeywords");
            return (Criteria) this;
        }

        public Criteria andMallStatusIsNull() {
            addCriterion("mall_status is null");
            return (Criteria) this;
        }

        public Criteria andMallStatusIsNotNull() {
            addCriterion("mall_status is not null");
            return (Criteria) this;
        }

        public Criteria andMallStatusEqualTo(Byte value) {
            addCriterion("mall_status =", value, "mallStatus");
            return (Criteria) this;
        }

        public Criteria andMallStatusNotEqualTo(Byte value) {
            addCriterion("mall_status <>", value, "mallStatus");
            return (Criteria) this;
        }

        public Criteria andMallStatusGreaterThan(Byte value) {
            addCriterion("mall_status >", value, "mallStatus");
            return (Criteria) this;
        }

        public Criteria andMallStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("mall_status >=", value, "mallStatus");
            return (Criteria) this;
        }

        public Criteria andMallStatusLessThan(Byte value) {
            addCriterion("mall_status <", value, "mallStatus");
            return (Criteria) this;
        }

        public Criteria andMallStatusLessThanOrEqualTo(Byte value) {
            addCriterion("mall_status <=", value, "mallStatus");
            return (Criteria) this;
        }

        public Criteria andMallStatusIn(List<Byte> values) {
            addCriterion("mall_status in", values, "mallStatus");
            return (Criteria) this;
        }

        public Criteria andMallStatusNotIn(List<Byte> values) {
            addCriterion("mall_status not in", values, "mallStatus");
            return (Criteria) this;
        }

        public Criteria andMallStatusBetween(Byte value1, Byte value2) {
            addCriterion("mall_status between", value1, value2, "mallStatus");
            return (Criteria) this;
        }

        public Criteria andMallStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("mall_status not between", value1, value2, "mallStatus");
            return (Criteria) this;
        }

        public Criteria andMallCombineStatusIsNull() {
            addCriterion("mall_combine_status is null");
            return (Criteria) this;
        }

        public Criteria andMallCombineStatusIsNotNull() {
            addCriterion("mall_combine_status is not null");
            return (Criteria) this;
        }

        public Criteria andMallCombineStatusEqualTo(Byte value) {
            addCriterion("mall_combine_status =", value, "mallCombineStatus");
            return (Criteria) this;
        }

        public Criteria andMallCombineStatusNotEqualTo(Byte value) {
            addCriterion("mall_combine_status <>", value, "mallCombineStatus");
            return (Criteria) this;
        }

        public Criteria andMallCombineStatusGreaterThan(Byte value) {
            addCriterion("mall_combine_status >", value, "mallCombineStatus");
            return (Criteria) this;
        }

        public Criteria andMallCombineStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("mall_combine_status >=", value, "mallCombineStatus");
            return (Criteria) this;
        }

        public Criteria andMallCombineStatusLessThan(Byte value) {
            addCriterion("mall_combine_status <", value, "mallCombineStatus");
            return (Criteria) this;
        }

        public Criteria andMallCombineStatusLessThanOrEqualTo(Byte value) {
            addCriterion("mall_combine_status <=", value, "mallCombineStatus");
            return (Criteria) this;
        }

        public Criteria andMallCombineStatusIn(List<Byte> values) {
            addCriterion("mall_combine_status in", values, "mallCombineStatus");
            return (Criteria) this;
        }

        public Criteria andMallCombineStatusNotIn(List<Byte> values) {
            addCriterion("mall_combine_status not in", values, "mallCombineStatus");
            return (Criteria) this;
        }

        public Criteria andMallCombineStatusBetween(Byte value1, Byte value2) {
            addCriterion("mall_combine_status between", value1, value2, "mallCombineStatus");
            return (Criteria) this;
        }

        public Criteria andMallCombineStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("mall_combine_status not between", value1, value2, "mallCombineStatus");
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