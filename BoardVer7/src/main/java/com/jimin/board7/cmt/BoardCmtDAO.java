package com.jimin.board7.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jimin.board7.DBUtils;

public class BoardCmtDAO {
	public static int insBoardCmt(BoardCmtEntity param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_board_cmt "
				   + "(iboard, iuser,cmt)"
				   + "VALUES "
				   + "(?,?,?)";
		
		try{
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1,param.getIboard());
			ps.setInt(2,param.getIuser());
			ps.setString(3,param.getCmt());
			result = ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		return result;
		
		
	}
}
