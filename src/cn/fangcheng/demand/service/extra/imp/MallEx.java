package cn.fangcheng.demand.service.extra.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fangcheng.demand.service.extra.MallExService;
import cn.fangcheng.demand.service.inner.MallInService;
import cn.fangcheng.mybatis.po.Mall;
@Service
public class MallEx implements MallExService{
	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory.getLogger(MallEx.class);
	@Autowired
	MallInService mis;
//	@Override
//	public Feature getFeatureByDocId(String docId) {
//		// TODO Auto-generated method stub
//		return mis.getFeatureByDocId(docId);
//	}

	@Override
	public Mall getFeatureByBid(int bid) throws Exception {
		// TODO Auto-generated method stub
		return (Mall)mis.getFeatureByBid(bid);
	}

}
