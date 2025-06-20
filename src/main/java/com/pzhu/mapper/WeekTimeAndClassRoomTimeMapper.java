package com.pzhu.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.pzhu.bean.WeekTimeAndClassRoomTime;
@Mapper
public interface WeekTimeAndClassRoomTimeMapper {
		@Results({
			@Result(property="wid",column="wid"),
			@Result(property="startweek",column="startweek"),
			@Result(property="endweek",column="endweek"),
			@Result(property="crtid",column="crtid"),
			@Result(property="roomid",column="roomid"),
			@Result(property="ctlocal",column="ctlocal"),
			@Result(property="timeid",column="timeid"),
			@Result(property="crtstatus",column="crtstatus"),
			@Result(property="cttime",column="cttime")
		})

		List<WeekTimeAndClassRoomTime> getTimeAndClassRoomTimes(@Param("start")int start,@Param("end")int end,@Param("uid")int uid);
		
		//获得根据教室节次信息获得crtid  
		int getCrtid(@Param("ctlocal")String ctlocal,@Param("cttime")String cttime);
		
		//插入排课信息
		boolean insertWeekTime(@Param("start")int start,@Param("end")int end,@Param("crtid")int crtid);
		
		//获取wid
		int getWid(@Param("start")int start,@Param("end")int end,@Param("crtid")int crtid);
}
