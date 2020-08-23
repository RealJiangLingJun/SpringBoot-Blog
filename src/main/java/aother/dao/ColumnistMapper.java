package aother.dao;

import aother.pojo.Columnist;
import aother.pojo.ColumnistExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ColumnistMapper {
    int countByExample(ColumnistExample example);

    int deleteByExample(ColumnistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Columnist record);

    int insertSelective(Columnist record);

    List<Columnist> selectByExample(ColumnistExample example);

    Columnist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Columnist record, @Param("example") ColumnistExample example);

    int updateByExample(@Param("record") Columnist record, @Param("example") ColumnistExample example);

    int updateByPrimaryKeySelective(Columnist record);

    int updateByPrimaryKey(Columnist record);
}