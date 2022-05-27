package co.micol.prj.product.service;

import java.util.List;

import co.micol.prj.product.vo.ProductVO;

public interface ProductService {
	List<ProductVO> productSelectList();
	ProductVO productSelect(ProductVO vo);
	int productInsert(ProductVO vo);
	int productDelete(ProductVO vo);
	int productUpdate(ProductVO vo);
}
