package co.micol.prj.product.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.prj.comm.Command;
import co.micol.prj.product.service.ProductService;
import co.micol.prj.product.serviceImpl.ProductServiceImpl;
import co.micol.prj.product.vo.ProductVO;

public class ProductInsert implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 제품 등록
		ProductService dao = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		String uploadPath = request.getSession().getServletContext().getRealPath("img");
		try {
			MultipartRequest mult = new MultipartRequest(request, uploadPath,1024*1024,"utf-8",new DefaultFileRenamePolicy());
			String fileName = mult.getFilesystemName("file");
			System.out.println(fileName);
			String orginalFile = mult.getOriginalFileName("file");
			vo.setPcode(mult.getParameter("pcode"));
			vo.setPname(mult.getParameter("pname"));
			vo.setPbrand(mult.getParameter("pbrand"));
			vo.setPamount(Integer.parseInt(mult.getParameter("pamount")));
			vo.setPrice(Integer.parseInt(mult.getParameter("price")));
			vo.setPimg("img/"+orginalFile);  //파일명 및 경로
			int n = dao.productInsert(vo);
			if(n != 0) {
				request.setAttribute("message", "정상 입력");
			}else {
				request.setAttribute("message", "입력 실패!!!!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "product/productInsert.tiles";
	}

}
