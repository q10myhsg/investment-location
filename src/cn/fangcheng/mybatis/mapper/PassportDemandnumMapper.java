package cn.fangcheng.mybatis.mapper;

import cn.fangcheng.mybatis.po.PassportDemandnum;

public interface PassportDemandnumMapper {

    int insertInto(PassportDemandnum record);
    
    void deleteByctime(String exec_date);
}