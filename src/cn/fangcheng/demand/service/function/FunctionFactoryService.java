package cn.fangcheng.demand.service.function;


/**
 * 使用 一些计算函数 以及 调用脚本的Service
 * @author Administrator
 *
 */
public interface FunctionFactoryService{
	
    boolean setDefaultFunction(Object obj) throws Exception;
	
	void setDefaultString(String defaultString) throws Exception;
	
	String getDefaultString() throws Exception;
}
