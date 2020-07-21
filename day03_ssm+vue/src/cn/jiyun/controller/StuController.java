package cn.jiyun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiyun.pojo.Major;
import cn.jiyun.pojo.QueryVo;
import cn.jiyun.pojo.Student;
import cn.jiyun.service.StuService;

@Controller
public class StuController {
@Autowired
private StuService s;
@RequestMapping("findAll")
public @ResponseBody List<QueryVo> show(){
	List<QueryVo>list=s.show();
	return list;
	
}
@RequestMapping("Toshow")
public String Toshow(){
	return "show";
	
}
@RequestMapping("Toadd")
public String Toadd(){
	return "add";
	
}
@RequestMapping("finmajor")
public @ResponseBody List<Major>finmajor(){
	List<Major>mlist=s.finmajor();
	return mlist;
	
}
@RequestMapping("add")
public @ResponseBody int  add(@RequestBody Student student){
   int i=s.add(student);
	return i;
}
@RequestMapping("update")
public @ResponseBody int  update(@RequestBody Student student){
   int i=s.update(student);
	return i;
}
}
