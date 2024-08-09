package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.AdminBean;
import bean.AdminXacNhanBean;
import bean.KhachHangBean;

public class AdminDao {
	MD5 md5 = new MD5();
	public AdminBean KiemTraDangNhapAdmin(String un,String pa)throws Exception{
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from dbo.Admin where UserAdmin = ? and PassAdmin = ?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
        cmd.setString(1, un);
        cmd.setString(2,md5.ecrypt(pa));
        ResultSet rs= cmd.executeQuery();
        AdminBean dn = null;
        if(rs.next()) {
        	Boolean Quyen = rs.getBoolean("Quyen");
        	dn = new AdminBean(un, pa, Quyen);
        }
        rs.close();
        return dn;
	}
	public AdminBean kiemTraDangKy(String tendn) throws Exception{
		AdminBean ad = null;
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from Admin where UserAdmin=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1,tendn);
	    ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			String UserAdmin=rs.getString("UserAdmin");
			String PassAdmin=md5.ecrypt(rs.getString("PassAdmin"));
			Boolean Quyen=rs.getBoolean("Quyen");
			ad = new AdminBean(UserAdmin, PassAdmin, Quyen);
		}
		return ad;
	}

	public int Them(String tendn, String pass, Boolean quyen) throws Exception{
		//B1: Ket noi vao csdl
	 	KetNoi kn= new KetNoi();
	 	kn.ketNoi();
	     //B2: tao cau lenh sql
	     String sql="insert into Admin(UserAdmin,PassAdmin,Quyen) values(?,?,?)";
	     //b3: Tao cau lenh PreparedStatement
	     PreparedStatement cmd= kn.cn.prepareStatement(sql);
	     //b4: Truyen tham so
	     cmd.setString(1, tendn);
	     cmd.setString(2, md5.ecrypt(pass));
	     cmd.setBoolean(3, quyen);
	     int kq=cmd.executeUpdate();//b5: Thuc hien cau lenh
	     kn.cn.close();
	     return kq;
	}
	public int XacNhan(long macthd) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "update ChiTietHoaDon set DaMua = 1 where MaChiTietHD = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, macthd);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public ArrayList<AdminXacNhanBean> getXacNhan() throws Exception {
		ArrayList<AdminXacNhanBean> ds = new ArrayList<AdminXacNhanBean>();
		// b1: goi ket noi csdl
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		// b2: tao cau lenh sql
		String sql = "select * from VAdminXacNhan Where DaMua = 0";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		// b5: duyet rs de dua vao mang ds
		while (rs.next()) {
			long MaChiTietHD = rs.getLong("MaChiTietHD");
			String HoTen = rs.getString("HoTen");
			String TenSP = rs.getString("TenSP");
			Long Gia = rs.getLong("Gia");
			Long SoLuongMua = rs.getLong("SoLuongMua");
			Long thanhtien = rs.getLong("ThanhTien");
			Boolean damua = rs.getBoolean("DaMua");
			ds.add(new AdminXacNhanBean(MaChiTietHD, HoTen, TenSP, Gia, SoLuongMua, thanhtien, damua));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

	public int AdminSuaSL(long mact, long sl) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "update ChiTietHoaDon set SoLuongMua = ? where MaChiTietHD = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, sl);
		cmd.setLong(2, mact);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int AdminXoaDonHang(long mact) throws Exception {
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
