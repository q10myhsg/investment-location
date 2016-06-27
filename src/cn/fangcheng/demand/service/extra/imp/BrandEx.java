package cn.fangcheng.demand.service.extra.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fangcheng.demand.service.extra.BrandExService;
import cn.fangcheng.demand.service.inner.BrandInService;
import cn.fangcheng.mybatis.po.Brand;
@Service
public class BrandEx implements BrandExService {
	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory.getLogger(BrandEx.class);
	@Autowired
	BrandInService bis;

//	@Override
//	public Feature getFeatureByDocId(String docId) {
//		// TODO Auto-generated method stub
//		return mis.getFeatureByDocId(docId);
//	}

	@Override
	public Brand getFeatureByBid(int bid)  throws Exception{
		// TODO Auto-generated method stub
		return (Brand)bis.getFeatureByBid(bid);
	}

}
