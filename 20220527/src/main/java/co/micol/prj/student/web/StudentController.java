package co.micol.prj.student.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.student.service.StudentService;
import co.micol.prj.student.vo.StudentVO;

@Controller
public class StudentController {

	@Autowired
	StudentService studentDao; // DAO 객체를 자동 주입
	
	// 전체 리스트
	@RequestMapping("/studentList.do") // RequestMapping과 같은 역할을 하는 것 -> @PostMapping("/~") (메소드가 post인것만. 요청명만 써주면 됨)
	public String studentList(Model model) { // model 객체는 결과를(key:value) 담아주는 곳. request 객체에서 담는 것과 유사
		// model 객체로 돌려주기 위해 객체 집어넣음, model객체는 계속 따라다닌다고 보면 됨
		model.addAttribute("students", studentDao.studentSelectList()); // students에 studentDao.studentSelectList()를 담아서 /studentList에 던져줌
		// model.addAttribue("jsp 페이지에서 사용 할 변수명", 사용 할 Service)
		return "student/studentList"; // 표현해 줄 jsp. studentList에 돌려줌(컨테이너에 싣는 건 spring framework가)
	}
	
	// 한 명의 데이터 조회
	@RequestMapping("/studentselect.do") 
	public String studentSelect(StudentVO vo, Model model) { // StudentVO가 가진 vo객체를 model에 담으면 됨
		model.addAttribute("student", studentDao.studentSelect(vo));
		return "studentSelect";
	}
}
