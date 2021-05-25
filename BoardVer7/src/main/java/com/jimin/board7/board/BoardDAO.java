package com.jimin.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jimin.board7.DBUtils;

public class BoardDAO {
	public static List<BoardDomain> selBoardList(BoardDTO param){
		List<BoardDomain> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT "
				   + "A.iboard, A.title, A.iuser, A.regdt "
				   + ", B.unm AS writerNm "
				   + "FROM t_board A "
				   + "INNER JOIN t_user B "
				   + "ON A.iuser = B.iuser ";
				   
		switch(param.getSearchType()) {
		case 1: //제목+내용
			sql += String.format("WHERE A.title LIKE '%%%s%%' OR A.ctnt LIKE '%%%s%%' "
					, param.getSearchText(),param.getSearchText());
			break;
		case 2: //제목 
			sql += String.format("WHERE A.title LIKE '%%%s%%' "
				, param.getSearchText());
		
			break;
		case 3: //내용
			sql += String.format("WHERE A.ctnt LIKE '%%%s%%' "
				,param.getSearchText());
			break;
		case 4: //글쓴이
			sql += String.format("WHERE B.unm LIKE '%%%s%%' "
					, param.getSearchText());
			break;
		}
	
		sql += "ORDER BY iboard DESC "
			 + "LIMIT ?, ?" ;
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getStartIdx());
			ps.setInt(2, param.getRecordCnt());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDomain vo = new BoardDomain ();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setWriterNm(rs.getString("writerNm"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	
	
	public static BoardDomain selBoard(BoardDTO param) {
		BoardDomain result = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT "
				   + "A.iboard, A.title, A. ctnt, A.iuser, A.regdt "
				   + ", B.unm AS writerNm "
				   + "FROM t_board A "
				   + "INNER JOIN t_user B "
				   + "ON A.iuser = B.iuser "
				   + "WHERE A.iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = new BoardDomain();
				result.setIboard(rs.getInt("iboard"));
				result.setTitle(rs.getString("title"));
				result.setCtnt(rs.getString("ctnt"));
				result.setIuser(rs.getInt("iuser"));
				result.setRegdt(rs.getString("regdt"));
				result.setWriterNm(rs.getString("writerNm"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
	
	
	public static int selPagingCnt(BoardDTO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT CEIL(COUNT(iboard)/?) ")
		.append("FROM t_board A ")
		.append("INNER JOIN t_user B ")
		.append("ON A.iuser = B.iuser ");
		
		if(param.getSearchType() > 0) {
			sb.append("WHERE ");
		}
		
		switch(param.getSearchType()) {
		case 1: //제목+내용
			sb.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' OR A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
			
		case 2: //제목 
			sb.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' ");			
			break;
		case 3: //내용
			sb.append("A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 4: //글쓴이
			sb.append("B.unm LIKE '%")
			.append(param.getSearchText())
			.append("%' ");	
			break;
		}
		
		String sql = "SELECT CEIL(COUNT(iboard)/?) "
				+ "FROM t_board";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sb.toString());
			ps.setInt(1, param.getRecordCnt());
			rs = ps.executeQuery();
	
			if(rs.next()) {
				result = rs.getInt(1); // 1 : 첫번째 컬럼
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
}
