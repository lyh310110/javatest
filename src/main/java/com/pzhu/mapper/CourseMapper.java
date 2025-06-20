package com.pzhu.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pzhu.bean.Course;
@Mapper
public interface CourseMapper {
		@Results({
			@Result(property="cid",column="cid"),
			@Result(property="cname",column="cname"),
			@Result(property="score",column="score"),
			@Result(property="cdesc",column="cdesc"),
			@Result(property="cstatus",column="cstatus"),
			@Result(property="climitCount",column="climitCount"),
			@Result(property="cmaxCount",column="cmaxCount"),
			@Result(property="clessionCount",column="clessionCount"),
			@Result(property="csortname",column="csortname"),
			@Result(property="ctype",column="ctype"),
			@Result(property="result",column="result")
		})
		
		//新增课程时查看该课程是否已经存在
		Course getCname(String cname);
		
		//课程表新增课程
		boolean insertNewLesson(@Param("cname")String cname,@Param("score")BigDecimal score,@Param("cdesc")String cdesc,
				@Param("climitCount")int climitCount,@Param("cmaxCount")int cmaxCount,@Param("clessionCount")int clessionCount,
				@Param("csortname")String csortname,@Param("ctype")String ctype);
		
		//课程表和教师复合表新增课程
		boolean insertNewLessonAndTech(@Param("cname")String cname,@Param("cdesc")String cdesc,@Param("uid")int uid);
		
		Course getOnlyCourse();
				
		//查询当前老师的全部课程		
		List<Course> getMyCourse(int uid);
		
		//查询当前老师的已通过课程
		List<Course> getMyPassCourse(int uid);
		
		//查询当前老师审核中的课程
		List<Course> getMyProcessCourse(int uid);
		
		//查询当前老师未通过的课程
		List<Course> getMyNoPassCourse(int uid);
		
		//查看选修序列可选课程名，已通过的课程
		List<Course> getPassedCourseName();
		
		//adm 设置课程为通过
		boolean setCourseStatusPassed(int cid);
		
		//填写审批意见
		boolean setResult(@Param("result")String result,@Param("cid")int cid);
		
		//增加班级中的已选择课程二次验证
		Course getCourseByName(String cname);
		
		//课程审核不通过
		boolean setCstatus(int cid);
}
