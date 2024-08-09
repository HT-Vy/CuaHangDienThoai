package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.LichSuMuaHangBean;

public class LichSuMuaHangDao {
	public ArrayList<LichSuMuaHangBean> getLichSu(long mkh)throws Exception{
		ArrayList<LichSuMuaHangBean> ls = new ArrayList<LichSuMuaHangBean>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from dbo.VLichSuMuaHang where MaKH = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setLong(1, mkh);
        //b4: thuc hien cau lenh
        ResultSet rs= cmd.executeQuery();
        while(rs.next()) {
        	long MaKH = rs.getLong("MaKH");
        	String MaSP = rs.getString("MaSP");
        	String TenSP = rs.getString("TenSP");
        	String Gia = rs.getString("Gia");
        	String GiaGoc = rs.getString("GiaGoc");
        	long SoLuongMua = rs.getLong("SoLuongMua");
        	String ThanhTien =rs.getString("ThanhTien");
        	String Anh = rs.getString("Anh");
        	Date NgayMua = rs.getDate("NgayMua");
        	Boolean DaMua = rs.getBoolean("DaMua");
        	long MaChiTietHD = rs.getLong("MaChiTietHD");
        	ls.add(new LichSuMuaHangBean(MaKH, MaSP, TenSP, Gia, GiaGoc, SoLuongMua, ThanhTien, Anh, NgayMua, DaMua,MaChiTietHD));
        	
        }
        rs.close();
        kn.cn.close();
        return ls;
	}
	public ArrayList<LichSuMuaHangBean> PhanTrangLSMuaHang (int sotrang, long mkh)throws Exception {
		ArrayList<LichSuMuaHangBean> ds = new ArrayList<LichSuMuaHangBean>();
		int sosach= sotrang*5-5;
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from dbo.func_PhanTrangLSMuaHang(?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, sosach);
		cmd.setLong(2, mkh);
        //b4: thuc hien cau lenh
        ResultSet rs= cmd.executeQuery();
        while(rs.next()) {
        	long MaKH = rs.getLong("MaKH");
        	String MaSP = rs.getString("MaSP");
        	String TenSP = rs.getString("TenSP");
        	String Gia = rs.getString("Gia");
        	String GiaGoc = rs.getString("GiaGoc");
        	long SoLuongMua = rs.getLong("SoLuongMua");
        	String ThanhTien =rs.getString("ThanhTien");
        	String Anh = rs.getString("Anh");
        	Date NgayMua = rs.getDate("NgayMua");
        	Boolean DaMua = rs.getBoolean("DaMua");
        	long MaChiTietHD = rs.getLong("MaChiTietHD");
        	ds.add(new LichSuMuaHangBean(MaKH, MaSP, TenSP, Gia, GiaGoc, SoLuongMua, ThanhTien, Anh, NgayMua, DaMua,MaChiTietHD));
        	
        }
        rs.close();
        kn.cn.close();
        return ds;
	}
}
