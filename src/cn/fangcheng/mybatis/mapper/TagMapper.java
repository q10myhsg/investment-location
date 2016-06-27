package cn.fangcheng.mybatis.mapper;

import cn.fangcheng.mybatis.po.Taginfo;
import cn.fangcheng.mybatis.po.TaginfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TagMapper {
    int countByExample(TaginfoExample example);

    int deleteByExample(TaginfoExample example);

    int deleteByPrimaryKey(Integer tagId);

    int insert(Taginfo record);

    int insertSelective(Taginfo record);

    List<Taginfo> selectByExampleWithRowbounds(TaginfoExample example, RowBounds rowBounds);

    List<Taginfo> selectByExample(TaginfoExample example);
    
    List<Taginfo> selectByGroupId(Integer groupId);

    Taginfo selectByPrimaryKey(Integer tagId);

    int updateByExampleSelective(@Param("record") Taginfo record, @Param("example") TaginfoExample example);

    int updateByExample(@Param("record") Taginfo record, @Param("example") TaginfoExample example);

    int updateByPrimaryKeySelective(Taginfo record);

    int updateByPrimaryKey(Taginfo record);
}