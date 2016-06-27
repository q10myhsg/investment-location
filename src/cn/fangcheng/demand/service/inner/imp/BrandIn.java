package cn.fangcheng.demand.service.inner.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fangcheng.demand.bean.Feature;
import cn.fangcheng.demand.service.inner.BrandInService;
import cn.fangcheng.demand.service.other.StorageService;
import cn.fangcheng.mybatis.po.Brand;
@Service
public class BrandIn implements BrandInService{
	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory.getLogger(BrandIn.class);
	@Autowired
	StorageService ss;
	@Override
	public Feature getFeatureByDocId(String docId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Brand getFeatureByBid(int bid) throws Exception {
		// TODO Auto-generated method stub
		return ss.getBrandFeatureSourceByBid(bid);
//		String feature=ss.getFeatureSourceByBid(bid);
//		if(feature==null){
//			return null;
//		}
//		return (Feature)JsonUtil.getDtoFromJsonObjStr(feature,Feature.class);
	}



}
