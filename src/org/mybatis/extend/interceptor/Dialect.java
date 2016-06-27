package org.mybatis.extend.interceptor;

public abstract class Dialect {  	  
      
    public abstract boolean supportsLimit();  
    
    public abstract String getLimitString(String sql, boolean hasOffset);  
  
    public abstract String getLimitString(String sql, int offset, int limit);  
  
    public abstract boolean supportsLimitOffset();        
}  