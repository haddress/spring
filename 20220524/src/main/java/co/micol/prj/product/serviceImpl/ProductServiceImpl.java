package co.micol.prj.product.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.prj.comm.DataSource;
import co.micol.prj.product.service.ProductService;
import co.micol.prj.product.vo.ProductVO;

public class ProductServiceImpl implements ProductService{
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<ProductVO> productSelectList() {
		// 상품 전체 목록
		List<ProductVO> products = new ArrayList<ProductVO>();
		ProductVO vo;
		String sql = "SELECT * FROM PRODUCT_INFO ORDER BY PCODE ASC";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new ProductVO();
				vo.setPcode(rs.getString("pcode"));
				vo.setPname(rs.getString("pname"));
				vo.setPbrand(rs.getString("pbrand"));
				vo.setPamount(rs.getInt("pamount"));
				vo.setPrice(rs.getInt("price"));
				vo.setPimg(rs.getString("pimg"));
				products.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return products;
	}

	@Override
	public ProductVO productSelect(ProductVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int productInsert(ProductVO vo) {  //제품 등록
		int n = 0;
		String sql = "INSERT INTO PRODUCT_INFO VALUES(?,?,?,?,?,?)";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPcode());
			psmt.setString(2, vo.getPname());
			psmt.setString(3, vo.getPbrand());
			psmt.setInt(4, vo.getPamount());
			psmt.setInt(5, vo.getPrice());
			psmt.setString(6, vo.getPimg());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int productDelete(ProductVO vo) {
		int n = 0;
		return n;
	}

	@Override
	public int productUpdate(ProductVO vo) {
		int n = 0;
		return n;
	}

	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
}
