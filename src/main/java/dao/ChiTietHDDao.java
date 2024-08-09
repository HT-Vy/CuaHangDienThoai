package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.AdminXacNhanBean;

public class ChiTietHDDao {
	HoaDonDao hddao = new HoaDonDao();

	public int Them(String Masp, long SoLuongMua, long MaHoaDon) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "insert into ChiTietHoaDon(MaSP, SoLuongMua, MaHoaDon, DaMua) values(?, ?, ?, 0)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, Masp);
		cmd.setLong(2, SoLuongMua);
		cmd.setLong(3, MaHoaDon);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public int XoaDonHang(long mact) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "delete ChiTietHoaDon where MaChiTietHD = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, mact);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
