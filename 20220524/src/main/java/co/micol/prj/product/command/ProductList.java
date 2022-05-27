package co.micol.prj.product.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.product.service.ProductService;
import co.micol.prj.product.serviceImpl.ProductServiceImpl;
import co.micol.prj.product.vo.ProductVO;

public class ProductList implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 제품 전체 목록
		ProductService dao = new ProductServiceImpl();
		List<ProductVO> products = new ArrayList<ProductVO>();
		products = dao.productSelectList();
		request.setAttribute("products", products);
		
		return "product/productList.tiles";
	}

}
