package com.jimin.board5.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jimin.board5.DBUtils;

public class BoardDAO {

	public static int insBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "INSERT INTO t_board " + "(title, ctnt) " + "VALUES " + "(?, ?)";

		String sql2 = "SELECT iboard FROM t_board " + "ORDER BY iboard DESC " + "LIMIT 1";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());

			ps.executeUpdate();

			con.close();
			ps.close();
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			int iboard = 0;
			if (rs.next()) {
				iboard = rs.getInt("iboard");
			}
			return iboard;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}

	public static List<BoardVO> SelboardList() {
		List<BoardVO> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT A.iboard, A.title, A.regdt, A.iuser, B.unm " + "FROM t_board A " + "LEFT JOIN t_user B "
				+ "ON A.iuser = B.iuser " + "ORDER BY iboard DESC";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
				list.add(vo);

			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}

	public static BoardVO selBoard(BoardVO param) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT A.iboard, A.ctnt, A.title, A.regdt, A.iuser, B.unm " + "FROM t_board A "
				+ "LEFT JOIN t_user B " + "ON A.iuser = B.iuser " + "WHERE iboard = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			BoardVO vo = null;

			if (rs.next()) {
				vo = new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
			}
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}

	}
	
	
	public static void updBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE t_board "
				   + "SET title = ?, ctnt = ? "
				   + "WHERE iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	
	public static void delBoard(int param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_board "
				   + "WHERE iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
}
