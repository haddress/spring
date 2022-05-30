package co.micol.prj.student.vo;


import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

// Getter, Setter 자동 생성
@Getter
@Setter
public class StudentVO {
	
	private String id;
	private String password;
	private String name;
	private String address;
	private String tel;
	private Date birthday;
	private int age;

}
