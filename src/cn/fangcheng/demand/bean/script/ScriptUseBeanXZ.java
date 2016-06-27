package cn.fangcheng.demand.bean.script;

import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;

public class ScriptUseBeanXZ{
		DemandXZ demandXZ=null;
		UserFeature userFeature=null;
		Brand brand=null;
		int from=0;
		int size=10;
		public ScriptUseBeanXZ(DemandXZ demandZS,UserFeature userFeature,Brand brand,int from,int size){
			this.demandXZ=demandZS;
			this.userFeature=userFeature;
			this.brand=brand;
			this.from=from;
			this.size=size;
		}

		public DemandXZ getDemandXZ() {
			return demandXZ;
		}

		public void setDemandXZ(DemandXZ demandXZ) {
			this.demandXZ = demandXZ;
		}

		public UserFeature getUserFeature() {
			return userFeature;
		}

		public void setUserFeature(UserFeature userFeature) {
			this.userFeature = userFeature;
		}

		public Brand getBrand() {
			return brand;
		}

		public void setBrand(Brand brand) {
			this.brand = brand;
		}

		public int getFrom() {
			return from;
		}

		public void setFrom(int from) {
			this.from = from;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}
		
		
	}