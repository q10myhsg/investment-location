package cn.fangcheng.demand.service.extra;

import cn.fangcheng.mybatis.po.Mall;

public interface MallExService {

	public Mall getFeatureByBid(int userId) throws Exception;

}
