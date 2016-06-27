package cn.fangcheng.mybatis.mapper;

import cn.fangcheng.mybatis.po.MallData;
import cn.fangcheng.mybatis.po.MallDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MallDataMapper {
    int countByExample(MallDataExample example);

    int deleteByExample(MallDataExample example);

    int deleteByPrimaryKey(Integer mallId);

    int insert(MallData record);

    int insertSelective(MallData record);

    List<MallData> selectByExampleWithRowbounds(MallDataExample example, RowBounds rowBounds);

    List<MallData> selectByExample(MallDataExample example);

    MallData selectByPrimaryKey(Integer mallId);

    int updateByExampleSelective(@Param("record") MallData record, @Param("example") MallDataExample example);

    int updateByExample(@Param("record") MallData record, @Param("example") MallDataExample example);

    int updateByPrimaryKeySelective(MallData record);

    int updateByPrimaryKey(MallData record);
}