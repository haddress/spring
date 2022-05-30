package co.micol.prj.student.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentVO {
	
	// lombok은 getter, setter을 알아서 다 만들어줌
	private String id;
	private String password;
	private String name;
	private String address;
	private String tel;
	private Date birthday;
	private int age;

}
