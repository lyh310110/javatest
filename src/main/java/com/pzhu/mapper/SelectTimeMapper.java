package com.pzhu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pzhu.bean.SelectTime;


@Mapper
public interface SelectTimeMapper {
	@Results({
		@Result(property="sid",column="sid"),
		@Result(property="starttime",column="starttime"),
		@Result(property="endtime",column="endtime")
	})

	@Select("select * from select_time")
	//查询 select_time 表的第一条记录，并映射为 SelectTime 对象
	SelectTime getSelectTime();

	//更新 select_time 表中 sid 为 1 的记录的开始时间和结束时间
	@Update("UPDATE `select_time` SET `starttime`=#{starttime}, `endtime`=#{endtime} WHERE (`sid`='1')")
	boolean setSelectTime(@Param("starttime")java.sql.Date starttime,@Param("endtime")java.sql.Date endtime);
}
