package co.micol.prj.product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;

public class ProductInsertForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 제품 등록 폼
		return "product/productInsertForm.tiles";
	}

}
