package co.micol.prj;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // 컨트롤러 = Servlet의 역할
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // value가 요청명. 요청이 /라고 들어오면 public String home 메소드를 수행시켜달라는 의미
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/Hello", method=RequestMethod.POST) // 호출명 = map.put("/list.do", new list()) 에서 list.do의 역할.
	// @RequestMapping은 Post와 Get 모두 사용가능( + @PostMapping, @GetMapping도 따로 사용가능)
	public String hello() { // 메소드명 = new list()의 역할
		return "hello"; // 돌려줄 페이지명 -> 이 세 가지를 일치시켜주어야함 (근데 왜 대소문자다르지...)
	}
	
	// @Controller와 @RequestMapping이 짝으로 같이 다님
}
