package cn.fangcheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fangcheng.mybatis.mapper.ProcedureMapper;
import cn.fangcheng.service.ProcedureInterface;

@Service
public class ProcedureMapperImpl implements ProcedureInterface{
	
	@Autowired
	ProcedureMapper pm;

	@Override
	public void runProcedure(String time1) {
		pm.runProcedure(time1);
	}
	
}
