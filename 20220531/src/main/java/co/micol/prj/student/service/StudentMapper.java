package co.micol.prj.student.service;

import java.util.List;

import co.micol.prj.student.vo.StudentVO;

public interface StudentMapper { // Mybatis에서 사용하는 인터페이스
	List<StudentVO> studentSelectList(); // 전체 회원
	StudentVO studentSelect(StudentVO vo); // 한 명 조회
	int studentInsert(StudentVO vo); // 회원추가
	int studentUpdate(StudentVO vo); // 회원정보 수정
	int studentDelete(StudentVO vo); // 회원삭제
	
	boolean idCheck(String id); // 아이디 중복 체크
	// 변수 이름은 student-map.xml의 EL표현식 이름과 동일하게 정의해주어야함
}
