package co.micol.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.prj.comm.DataSource;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<MemberVO> memberSelectList() {
		List<MemberVO> members = new ArrayList<MemberVO>();
		MemberVO vo;
		String sql = "SELECT * FROM USER_INFO";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setAdr(rs.getString("adr"));
				vo.setEmail(rs.getString("email"));
				vo.setAuthor(rs.getString("author"));
				members.add(vo);
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return members;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		String sql = "SELECT * FROM USER_INFO WHERE ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPass("pass");
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setAdr(rs.getString("adr"));
				vo.setEmail(rs.getString("email"));
				vo.setAuthor(rs.getString("author"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		int n = 0;
		String sql = "INSERT INTO USER_INFO VALUES(?,?,?,?,?,?,'USER')";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPass());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getTel());
			psmt.setString(5, vo.getAdr());
			psmt.setString(6, vo.getEmail());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int memberUpdater(MemberVO vo) {  //회원정보 변경
		int n = 0;
		String sql = "UPDATE USER_INFO SET PASS = ?, NAME= ?, TEL = ?, ADR = ?, EMAIL =?,"
				+ " AUTHOR = ? WHERE ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPass());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getTel());
			psmt.setString(4, vo.getAdr());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getAuthor());
			psmt.setString(7, vo.getId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		int n = 0;
		String sel = "DELETE FROM USER_INFO WHERE ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sel);
			psmt.setString(1, vo.getId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		String sql = "SELECT * FROM USER_INFO WHERE ID = ? AND PASS = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPass());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setAuthor(rs.getString("author"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public boolean memberIdcheck(String id) {
		boolean b = false;
		String sql = "SELECT ID FROM USER_INFO WHERE ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				b = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return b;
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
