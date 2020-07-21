<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/vue.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/axios-0.18.0.js"></script>
<style type="text/css">
 .show{
 display:black
 }
 .hidden{
 display:none
 }

</style>
</head>
<body>
<a href="${pageContext.request.contextPath }/Toadd.action">添加</a>
<div id="did">
<table id="app" border="1">
   <tr>
   <td>
   <input type="checkbox">   
   </td>
   <td>编号</td>
   <td>姓名</td>
   <td>性别</td>
   <td>年龄</td>
   <td>生日</td>
   <td>头像</td>
   <td>专业</td>
   <td>操作</td>
   </tr>
   <tr v-for="(stu,index) in stus">
   <td>
   <input type="checkbox" v-model="ids" :value="stu.sid" >
   </td>
   <td v-text="stu.sid"></td>
   <td v-text="stu.sname"></td>
   <td v-text="stu.sex"></td>
   <td v-text="stu.age"></td>
   <td v-text="format(stu.birthday)"></td>
   <td></td>
   <td v-text="stu.mname"></td>
   <td>
   <input type="button" @click="toUpdate(index)"value="修改">
   </td>
   </tr>
<form id="form">
<input type="hidden" v-model="student.sid">
姓名：<input  v-model="student.sname"><br>
性别：<input type="radio" value="男" v-model="student.sex" >男
<input type="radio" value="女" v-model="student.sex">女<br>
年龄：<input v-model="student.age"  ><br>
生日：<input type="date" v-model="student.birthday"><br>
头像：<input type="file" ><br>
专业：<select v-model="student.mid" >
 <option v-for="major in mlist" :value="major.mid" v-text="major.mname"></option>
</select><br>
<input type="button" @click="update" value="提交">
</form> 
</table>
</div>
<script type="text/javascript">
  var table= new Vue({
	  el:"#did",
	  data:{
		  stus:[],
          ids:[],
          mlist:[],
        student:{}
	  },
	  created(){
		  axios.post("${pageContext.request.contextPath }/findAll.action?pageNum=1").then(function(res){
			  table.stus=res.data;
			  
		  }),
		  axios.post("${pageContext.request.contextPath }/finmajor.action").then(function(res) {
				table.mlist=res.data;
			})
		
		  },
	  methods:{
		  
		  format(birth){
				 var year=new Date(birth).getFullYear();
				 var month=new Date(birth).getMonth()+1;
				 var date=new Date(birth).getDate();
				 return year+"-"+month+"-"+date;
	  },
	  toUpdate(i){
		  this.student=this.stus[i];
		  this.student.birthday=this.format(this.student.birthday);
	      
	  },
	  update(){
			axios.post("${pageContext.request.contextPath }/update.action",table.student).then(function(res) {
				if(res.data>0){
			location.href="${pageContext.request.contextPath }/Toshow.action";
				}
			})	
			}
	  }
  })



</script>
</body>
</html>