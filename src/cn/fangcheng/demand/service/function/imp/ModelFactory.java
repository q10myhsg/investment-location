package cn.fangcheng.demand.service.function.imp;

import java.util.Date;

import org.springframework.stereotype.Service;

import cn.fangcheng.demand.bean.CustomBrandScoresBean;
import cn.fangcheng.demand.bean.CustomMallScoresBean;
import cn.fangcheng.demand.bean.EsStoreXZBean;
import cn.fangcheng.demand.bean.EsStoreZSBean;
import cn.fangcheng.demand.bean.StaticBean;
import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.demand.bean.demand.RequestDemand;
import cn.fangcheng.demand.service.function.ModelService;
import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;
import cn.fangcheng.mybatis.po.PassportActivity;

@Service
public class ModelFactory implements ModelService {

	@Override
	public EsStoreXZBean computeFeature(EsStoreXZBean esStoreBean,
			RequestDemand demand, PassportActivity userFeature, Brand brandFeature,
			DemandXZ feature) throws Exception {
		// TODO Auto-generated method stub
		esStoreBean.infoScore = new CustomBrandScoresBean();
		// 设置时间
		// System.out.println(feature.getDemand_utime());
		esStoreBean.infoScore.demand_ctime_val = StaticBean.sdf.parse(
				feature.getDemand_ctime()).getTime();
		esStoreBean.infoScore.demand_ctime_day=esStoreBean.infoScore.demand_ctime_val/86400000;
		// 如果战士时间则为1 否则为0
		esStoreBean.infoScore.demand_show_mobile = feature
				.getDemand_show_mobile() == 1 ? 1 : 0;
		esStoreBean.infoScore.demand_level = Math
				.log(feature.getDemand_level() + 1);
		esStoreBean.infoScore.category_ids = feature.getCategory_ids();
		if(brandFeature==null){
			esStoreBean.infoScore.business_cycle_count=0;
		}else{
			esStoreBean.infoScore.business_cycle_count=brandFeature.getBusiness_circle()==null?0:brandFeature.getBusiness_circle().length;
		}
		// esStoreBean.infoScore.tag=feature.getTag();
		// //判断tag中的数据是否缺失
		// Tag tag=esStoreBean.infoScore.tag;
		// 需求面积
		// tag.getAreaDemand();
		// 租金
		// tag.getBudgetRent();
		// if(tag.getPreferredPropertyAll()!=null&&tag.getPreferredProperty().length==0){
		// tag.setPreferredProperty(new String[]{""});
		// }
		// if(tag.getShopType()!=null&& tag.getShopType().length==0){
		// tag.setShopType(new String[]{""});
		// }
		// if(tag.getShopSpecifications()!=null&&tag.getShopSpecifications().length==0){
		// tag.setShopSpecifications(new String[]{""});
		// }
		return esStoreBean;
	}

	@Override
	public EsStoreZSBean computeFeature(EsStoreZSBean esStoreBean, RequestDemand demand, PassportActivity userFeature, Mall mallFeature, DemandZS feature) throws Exception {
		// TODO Auto-generated method stub
		esStoreBean.infoScore = new CustomMallScoresBean();
		// 设置时间
		esStoreBean.infoScore.demand_ctime_val = StaticBean.sdf.parse(
				feature.getDemand_utime()).getTime();
		esStoreBean.infoScore.demand_ctime_day=esStoreBean.infoScore.demand_ctime_val/86400000;
		// 如果战士时间则为1 否则为0
		esStoreBean.infoScore.demand_show_mobile = feature
				.getDemand_show_mobile() == 1 ? 1 : 0;
		esStoreBean.infoScore.demand_level = Math
				.log(feature.getDemand_level() + 1);
		if (mallFeature != null) {
			if ( mallFeature.getMallFloorSize() < 3000) {
				esStoreBean.infoScore.mallFloorSize = 0.0295588;
			} else {
				esStoreBean.infoScore.mallFloorSize = Math.log(mallFeature
						.getMallFloorSize() / 100000 + 1);
			}

			if (mallFeature.getMallParking() < 200) {
				esStoreBean.infoScore.mallParking = 0.3364722;
			} else {
				esStoreBean.infoScore.mallParking = Math.log(mallFeature
						.getMallParking() / 500 + 1);
			}

			if (mallFeature.getSpiderChannelWebId() == 0) {
				esStoreBean.infoScore.spiderChannelScore = 0;
			} else {
				esStoreBean.infoScore.spiderChannelScore = 1;
			}
		}

		esStoreBean.infoScore.category_ids = feature.getCategory_ids();
		// esStoreBean.infoScore.tag=feature.getTag();
		// //判断tag中的数据是否缺失
		// Tag tag=esStoreBean.infoScore.tag;
		// 需求面积
		// tag.getAreaDemand();
		// 租金
		// tag.getBudgetRent();
		// if(tag.getPreferredProperty()!=null&&tag.getPreferredProperty().length==0){
		// tag.setPreferredProperty(new String[]{""});
		// }
		// if(tag.getShopType()!=null&& tag.getShopType().length==0){
		// tag.setShopType(new String[]{""});
		// }
		// if(tag.getShopSpecifications()!=null&&tag.getShopSpecifications().length==0){
		// tag.setShopSpecifications(new String[]{""});
		// }
		// if(tag.getShopArea().getUpper()==0L){
		// if(tag.getShopArea().getLower()==0L){
		// }else{
		// tag.getShopArea().setUpper(tag.getShopArea().getLower());
		// }
		// }

		return esStoreBean;
	}
}
