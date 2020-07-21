package cn.jiyun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jiyun.mapper.StuMapper;
import cn.jiyun.pojo.Major;
import cn.jiyun.pojo.QueryVo;
import cn.jiyun.pojo.Student;
@Service
@Transactional
public class StuServiceim implements StuService {
@Autowired
private StuMapper p;
	@Override
	public List<QueryVo> show() {
		// TODO Auto-generated method stub
		return p.show();
	}
	@Override
	public List<Major> finmajor() {
		// TODO Auto-generated method stub
		return p.finmajor();
	}
	@Override
	public int add(Student student) {
		// TODO Auto-generated method stub
		return p.add(student);
	}
	@Override
	public int update(Student student) {
		
		return p.update(student);
	}

}
