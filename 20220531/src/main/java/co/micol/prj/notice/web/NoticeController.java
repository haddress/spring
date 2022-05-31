package co.micol.prj.notice.web;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;
	
	@Autowired
	private String saveDir;
	
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		model.addAttribute("notices", noticeDao.noticeSelectList(1, "전체"));
		return "notice/noticeList";
	}
	
	@RequestMapping("/noticeInsertForm.do")
	public String noticeInsertForm() {
		return "notice/noticeInsertForm";
	}
	
	@PostMapping("/noticeInsert.do")
	public String noticeInSert(NoticeVO vo, MultipartFile file) {
		String fileName = file.getOriginalFilename();
		if(fileName != null) {
			File target = new File(saveDir,fileName); // 여기에 공백이 있으면 디렉토리명과 파일이름 사이에 공백이 있는 채로 입력됨
			vo.setNoticeAttech(fileName); // 실제 파일 이름 담기
			vo.setNoticeDir(target.toString()); // 실제 저장 경로 담기
			try {
				FileCopyUtils.copy(file.getBytes(), target); // 실제 파일을 저장
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		noticeDao.noticeInsert(vo);
		return "redirect:noticeList.do";
	}
}
