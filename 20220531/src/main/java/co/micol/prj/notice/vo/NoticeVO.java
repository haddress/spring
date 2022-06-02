package co.micol.prj.notice.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/*
 * Program Name : 공지사항 VO
 * Written by : 홍길동
 * Date : 2022.05.31 최초작성
 * Version : 1.0
 */

@Setter
@Getter
public class NoticeVO {
	private int noticeId; // 순번
	private String noticeName; // 작성자
	private String noticeTitle; // 제목
	private String noticeContents; // 내용
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul") // 날짜 형식 지정하기
	private Date noticeDate; // 작성일
	private int noticeHit; // 조회수
	private String noticeAttech; // 첨부파일명
	private String noticeDir; // 첨부파일 저장폴더명(물리적 위치) -> UUID를 사용하게 되면서 저장폴더의 실제파일명으로 용도가 바뀜
	
}
