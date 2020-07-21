package cn.jiyun.test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import cn.jiyun.pojo.Student;

public class OutTest {
	@Test
	public void out() throws Exception{
	
	 Student stu = new Student(1,"小奥","男","保护荣荣", new Date("2000/10/11"),1);
	 Student stu1 = new Student(2,"三哥","男","保护小舞", new Date("2000/10/11"),2);
	 Student stu2 = new Student(3,"小舞","男","保护三哥", new Date("2000/10/11"),1);
		List<Student> list = new ArrayList<Student>();
		list.add(stu);
		list.add(stu1);
		list.add(stu2);
   //实例化工作簿
   XSSFWorkbook wk = new XSSFWorkbook();
	//创建sheet页
   XSSFSheet sheet = wk.createSheet("学生信息");
	//创建行row
   XSSFRow row = sheet.createRow(0);
	//创建单元格赋值
   String[] str={"编号","姓名","性别","爱好","生日","班级"};
   for (int i = 0; i < str.length; i++) {
	   XSSFCell cell = row.createCell(i);
	   cell.setCellValue(str[i]);
}
   for (int i = 0; i < list.size(); i++) {
	   XSSFRow row1 = sheet.createRow(i+1);
	   row1.createCell(0).setCellValue(list.get(i).getSid());
	   row1.createCell(1).setCellValue(list.get(i).getSname());
	   row1.createCell(2).setCellValue(list.get(i).getSex());
	   row1.createCell(3).setCellValue(list.get(i).getHobby());
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	   row1.createCell(4).setCellValue(format.format(list.get(i).getBirthday()));
	  
	   if(1==list.get(i).getCid()){
		   row1.createCell(5).setCellValue("h1909a");
	   }else if(2==list.get(i).getCid()){
		   row1.createCell(5).setCellValue("h1909b");
	   }else{
		   row1.createCell(5).setCellValue("h1909c");
	   }
}
	//导出
   FileOutputStream file= new FileOutputStream("e:/学生信息表.xlsx");
   wk.write(file);
	}
	@Test
	public void in() throws Exception{
	FileInputStream in = new FileInputStream("e:/学生信息表.xlsx");
		//创建工作薄
		XSSFWorkbook workbook = new XSSFWorkbook(in);
		//读取sheet页
		XSSFSheet sheet = workbook.getSheetAt(0);
		//获取行
		int num = sheet.getLastRowNum();
		List<Student> list1 = new ArrayList<Student>();
		for (int i=1; i<=num; i++) {
			XSSFRow row = sheet.getRow(i);
			Student stu = new Student();
			stu.setSid((int)row.getCell(0).getNumericCellValue());
			stu.setSname(row.getCell(1).getStringCellValue());
			stu.setSex(row.getCell(2).getStringCellValue());
			stu.setHobby(row.getCell(3).getStringCellValue());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String bir = row.getCell(4).getStringCellValue();
			stu.setBirthday(format.parse(bir)); 
			if("h1909a".equals(row.getCell(5).getStringCellValue())){
				stu.setCid(1);
			}else if("h1909b".equals(row.getCell(5).getStringCellValue())){
				stu.setCid(2);
			}else{
				stu.setCid(3);
			}
			list1.add(stu);
		}
		for (Student student : list1) {
			System.out.println(student.toString());
		}
	}
	
	
}
