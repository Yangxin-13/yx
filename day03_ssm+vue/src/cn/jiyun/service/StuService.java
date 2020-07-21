package cn.jiyun.service;

import java.util.List;

import cn.jiyun.pojo.Major;
import cn.jiyun.pojo.QueryVo;
import cn.jiyun.pojo.Student;

public interface StuService {

	List<QueryVo> show();

	List<Major> finmajor();

	int add(Student student);

	int update(Student student);

}
