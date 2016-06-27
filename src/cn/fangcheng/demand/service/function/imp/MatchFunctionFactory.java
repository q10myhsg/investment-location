package cn.fangcheng.demand.service.function.imp;

import org.springframework.stereotype.Service;

import cn.fangcheng.demand.service.function.FunctionFactoryService;
@Service
public class MatchFunctionFactory implements FunctionFactoryService{
	/**
	 * 默认的参量
	 */
	String defaultString="demandMatch.groovy";
	@Override
	public boolean setDefaultFunction(Object obj) throws Exception{
		return false;
	};
	@Override
	public void setDefaultString(String defaultString) throws Exception{
		this.defaultString=defaultString;
	}
	@Override
	public String getDefaultString() throws Exception{
		return this.defaultString;
	}
}
