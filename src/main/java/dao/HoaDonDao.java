package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HoaDonDao {
	public int Them(long makh) throws Exception{
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "insert into hoadon(makh,NgayMua, damua) values (?,?, 0)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		Date n1 = new Date();// Lấy Ngày trong máy ra
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		String tam = dd.format(n1); //Đổi ngày ra chuỗi theo dd
		Date n2 = dd.parse(tam);//Đổi chuỗi ra ngày util
		//Đổi ngày util sang ngày sql
		cmd.setDate(2, new java.sql.Date(n2.getTime()));
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public long maxHD() throws Exception{
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select max(maHoaDon) as maxhd from hoadon";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long max = 0;
		if(rs.next()) {
			max = rs.getLong("maxhd");
		}
		rs.close();
		kn.cn.close();
		return max;
	}
}
