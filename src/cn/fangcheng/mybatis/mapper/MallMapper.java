package cn.fangcheng.mybatis.mapper;

import cn.fangcheng.mybatis.po.Mall;
import cn.fangcheng.mybatis.po.MallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MallMapper {
    int countByExample(MallExample example);

    int deleteByExample(MallExample example);

    int deleteByPrimaryKey(Integer mallId);

    int insert(Mall record);

    int insertSelective(Mall record);

    List<Mall> selectByExampleWithRowbounds(MallExample example, RowBounds rowBounds);

    List<Mall> selectByExample(MallExample example);

    Mall selectByPrimaryKey(Integer mallId);

    int updateByExampleSelective(@Param("record") Mall record, @Param("example") MallExample example);

    int updateByExample(@Param("record") Mall record, @Param("example") MallExample example);

    int updateByPrimaryKeySelective(Mall record);

    int updateByPrimaryKey(Mall record);
}