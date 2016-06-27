package cn.fangcheng.demand.bean.demand;

import cn.fangcheng.demand.bean.Feature;

public interface DemandFeatureFactory {
	
	/**
	 * 将源feature转换成es中的feature
	 * @param feature
	 * @return
	 */
	Feature convert(Feature feature);
}
