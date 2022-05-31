package co.micol.prj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	// 두 개 이상의 매개변수를 받으므로 어노테이션 Param을 사용해야함 (사용하지 않으면 mybatis에서 인식을 못함)
	// 넘어오는 state, key 변수를 String 타입의 state, key 변수로 사용할 것이라는 뜻
	List<NoticeVO> noticeSelectList(@Param("state") int state, @Param("key") String key);
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	int noticeHitUpdate(int id); // 조회수 변경

}
