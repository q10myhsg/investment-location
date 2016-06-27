package cn.fangcheng.demand.service.extra;

import cn.fangcheng.mybatis.po.Brand;

public interface BrandExService {

	public Brand getFeatureByBid(int bid) throws Exception;

}
