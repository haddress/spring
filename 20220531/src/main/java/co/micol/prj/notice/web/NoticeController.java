package co.micol.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;
	
	@Autowired
	private String saveDir;
	
	// 게시글 목록
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		model.addAttribute("notices", noticeDao.noticeSelectList(1, "전체"));
		return "notice/noticeList";
	}
	
	// 게시글 등록폼
	@RequestMapping("/noticeInsertForm.do")
	public String noticeInsertForm() {
		return "notice/noticeInsertForm";
	}
	
	// 게시글 등록
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile file) { // MultipartFile file이 NoticeInsertForm.jsp의 <input name="">의 값과 같으면 파일이 인서트 됨
		String fileName = file.getOriginalFilename();
		
		if(fileName != null && !fileName.isEmpty() && fileName.length() != 0) { // null이 아닐때, 이름이 empty가 아닐때, 이름 길이가 0이 아닐때
			
			// UUID : 범용 고유 식별자
			// UUID 사용하여 파일명 변경
			String uid = UUID.randomUUID().toString();
			String saveFileName = uid + fileName.substring(fileName.indexOf("."));
			
			// UUID로 만든 파일명 넣기
			File target = new File(saveDir,saveFileName); // 여기에 공백이 있으면 디렉토리명과 파일이름 사이에 공백이 있는 채로 입력됨
			vo.setNoticeAttech(fileName); // 파일 이름 담기
			vo.setNoticeDir(saveFileName); // 실제 파일 저장명(물리적 이름)
			try {
				FileCopyUtils.copy(file.getBytes(), target); // 실제 파일을 저장
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		noticeDao.noticeInsert(vo);
		return "redirect:noticeList.do";
	}
	
	// 게시글 한 건 상세보기
	@PostMapping("/getContent.do")
	public String getContent(NoticeVO vo, Model model) {
	//getContent.do?noticeId=3 -> 3을 @RequestParam을 통해 변수에 담을 수 있음(get방식일때만 가능)
	//public String getContent(@RequestParam int noticeId) {
		noticeDao.noticeHitUpdate(vo.getNoticeId()); // noticeSelect가 되기 전에 조회수+1
		model.addAttribute("content", noticeDao.noticeSelect(vo));
		return "notice/noticeContent";
		
	}
	
	// 게시글에 등록된 파일 다운로드
	@RequestMapping("/downLoad.do")
	public void downLoad(@RequestParam("saveName") String saveName, @RequestParam("fileName") String fileName, HttpServletResponse resp) {
		// saveName -> UUID, fileName -> 실제 파일명
		try {
			// file을 배열로 전환
			byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(
					new File(saveDir + File.separator + saveName)); // file명으로 가져와서 배열로 지정, separator = /(슬래시)
			// 모든 타입의 데이터를 전송할 때 사용
			resp.setContentType("application/octet-stream");
			// 파일 길이만큼 사이즈 설정
			resp.setContentLength(fileByte.length);
			// 파일을 다운받기위해 설정
			resp.setHeader("Content-Disposition", "attachment; fileName=\"" 
			+ URLEncoder.encode(fileName, "UTF-8") + "\"");
			
			resp.getOutputStream().write(fileByte); // 파일 저장
			resp.getOutputStream().flush();
			resp.getOutputStream().close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 게시글 삭제
	@RequestMapping("/noticeDelete.do")
	public String noticeDelete(NoticeVO vo) {
		noticeDao.noticeDelete(vo);
		return "redirect:noticeList.do";
		
	}
	
	// 게시글 수정
	@RequestMapping("/noticeModifyform.do")
	public String noticeModify(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeDao.noticeSelect(vo));
		return "notice/noticeModifyform";
	}
	
	@RequestMapping("/noticeModify.do")
	public String noticeModify(NoticeVO vo, MultipartFile file) {
		String fileName = file.getOriginalFilename();
		
		if(fileName != null && !fileName.isEmpty() && fileName.length() != 0) { // null이 아닐때, 이름이 empty가 아닐때, 이름 길이가 0이 아닐때
			
			// UUID : 범용 고유 식별자
			// UUID 사용하여 파일명 변경
			String uid = UUID.randomUUID().toString();
			String saveFileName = uid + fileName.substring(fileName.indexOf("."));
			
			// UUID로 만든 파일명 넣기
			File target = new File(saveDir,saveFileName); // 여기에 공백이 있으면 디렉토리명과 파일이름 사이에 공백이 있는 채로 입력됨
			vo.setNoticeAttech(fileName); // 파일 이름 담기
			vo.setNoticeDir(saveFileName); // 실제 파일 저장명(물리적 이름)
			try {
				FileCopyUtils.copy(file.getBytes(), target); // 실제 파일을 저장
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		noticeDao.noticeUpdate(vo);
		return "redirect:noticeList.do";
	}
	
	@PostMapping("/ajaxSearchList.do")
	@ResponseBody
	public List<NoticeVO> ajaxSearchList(@RequestParam("state") int state, @RequestParam("key") String key) {
		return noticeDao.noticeSelectList(state, key);
	}
	
}
