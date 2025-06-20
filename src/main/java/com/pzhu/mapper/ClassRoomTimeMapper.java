package com.pzhu.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pzhu.bean.ClassRoomTime;
@Mapper
public interface ClassRoomTimeMapper {
		@Results({
			@Result(property="crtid",column="crtid"),
			@Result(property="roomid",column="roomid"),
			@Result(property="ctlocal",column="ctlocal"),
			@Result(property="timeid",column="timeid"),
			@Result(property="crtstatus",column="crtstatus"),
			@Result(property="cttime",column="cttime")
		})
		//查询crtid={}的信息
		ClassRoomTime getInfoByCrtid(int crtid);
		
		//更新crtid={} 的状态为可选
		boolean setStatus(int crtid);
		
		//更新crtid={} 的状态为已排课
		boolean setAlreadyStatus(int crtid);
				
		//更新crtid={} 的状态为不可选
		boolean setUnStatus(int crtid);
		
		//获得教室节次时间信息
		List<ClassRoomTime> getAllClassRoomTime();
		
		//查询教室
		List<ClassRoomTime> getAllClassRoom();
		
		//查询指定roomid的教室
		ClassRoomTime getRoomByRoomId(int roomid);
		
		//删除教室
		boolean deleteClassRoom(int roomid);
		
		//删除排课表教室和时间
		boolean deleteClassRoomTime(int roomid);
		
		//添加教室
		boolean insertClassRoom(@Param("roomid")int roomid,@Param("ctlocal")String ctlocal);
		
		//添加排课教室和时间
		boolean insertClassRoomTime(int roomid);
		
		//班级关闭 第4步  获得wid所对应的crtid,并判断该crtid是否有排课信息，更新状态
		ClassRoomTime getCrtidByWid(int wid);
}
