package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import bean.AdminBean;
import bean.NSXBean;
import bean.SanPhamBean;

public class SanPhamDao {
	public ArrayList<SanPhamBean> getSanPham() throws Exception {
		ArrayList<SanPhamBean> ds = new ArrayList<SanPhamBean>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		// b2: tao cau lenh sql
		String sql = "select * from func_GetSanPham()";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		// b5: duyet rs de dua vao mang ds
		while (rs.next()) {
			String MaSP = rs.getString("MaSP");
			String TenSP = rs.getString("TenSP");
			String Gia = rs.getString("Gia");
			Long SoLuong = rs.getLong("SoLuong");
			String Anh = rs.getString("Anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String MaLoai = rs.getString("MaLoai");
			String MaNSX = rs.getString("MaNSX");
			String GiaGoc = rs.getString("GiaGoc");
			ds.add(new SanPhamBean(MaSP, TenSP, Gia, SoLuong, Anh, NgayNhap, MaLoai, MaNSX, GiaGoc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

	public void CapNhatSoLuong(String msp, long sl) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketNoi();

		// b2: tao cau lenh sql
		String sql = "update SanPham set SoLuong = SoLuong - ? where MaSP = ?";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, sl);
		cmd.setString(2, msp);
		// b4: thuc hien cau lenh
		cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
	}

	public void CapNhatSanPham(String msp, long sl, long gia) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketNoi();

		// b2: tao cau lenh sql
		String sql = "update SanPham set SoLuong = ?, Gia = ?  where MaSP = ?";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, sl);
		cmd.setLong(2, gia);
		cmd.setString(3, msp);
		// b4: thuc hien cau lenh
		cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
	}

	public int XoaSanPham(String msp) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "delete SanPham where MaSP =?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, msp);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public ArrayList<SanPhamBean> getSanPhamSLKhong() throws Exception {
		ArrayList<SanPhamBean> ds = new ArrayList<SanPhamBean>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		// b2: tao cau lenh sql
		String sql = "select * from func_GetSanPham() where SoLuong = 0";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		// b5: duyet rs de dua vao mang ds
		while (rs.next()) {
			String MaSP = rs.getString("MaSP");
			String TenSP = rs.getString("TenSP");
			String Gia = rs.getString("Gia");
			Long SoLuong = rs.getLong("SoLuong");
			String Anh = rs.getString("Anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String MaLoai = rs.getString("MaLoai");
			String MaNSX = rs.getString("MaNSX");
			String GiaGoc = rs.getString("GiaGoc");
			ds.add(new SanPhamBean(MaSP, TenSP, Gia, SoLuong, Anh, NgayNhap, MaLoai, MaNSX, GiaGoc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

	public ArrayList<SanPhamBean> getSanPhamNoiBat() throws Exception {
		ArrayList<SanPhamBean> ds = new ArrayList<SanPhamBean>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();

		// b2: tao cau lenh sql
		String sql = "select * from dbo.func_GetSanPhamNoiBat()";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		// b5: duyet rs de dua vao mang ds
		while (rs.next()) {
			String MaSP = rs.getString("MaSP");
			String TenSP = rs.getString("TenSP");
			String Gia = rs.getString("Gia");
			Long SoLuong = rs.getLong("SoLuong");
			String Anh = rs.getString("Anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String MaLoai = rs.getString("MaLoai");
			String MaNSX = rs.getString("MaNSX");
			String GiaGoc = rs.getString("GiaGoc");
			ds.add(new SanPhamBean(MaSP, TenSP, Gia, SoLuong, Anh, NgayNhap, MaLoai, MaNSX, GiaGoc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

	public ArrayList<SanPhamBean> getSanPhamTheoLoai(String mloai) throws Exception {
		ArrayList<SanPhamBean> ds = new ArrayList<SanPhamBean>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();

		// b2: tao cau lenh sql
		String sql = "select * from dbo.func_GetSanPhamTheoLoai(?)";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, mloai);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		// b5: duyet rs de dua vao mang ds
		while (rs.next()) {
			String MaSP = rs.getString("MaSP");
			String TenSP = rs.getString("TenSP");
			String Gia = rs.getString("Gia");
			Long SoLuong = rs.getLong("SoLuong");
			String Anh = rs.getString("Anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String MaLoai = rs.getString("MaLoai");
			String MaNSX = rs.getString("MaNSX");
			String GiaGoc = rs.getString("GiaGoc");
			ds.add(new SanPhamBean(MaSP, TenSP, Gia, SoLuong, Anh, NgayNhap, MaLoai, MaNSX, GiaGoc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

	public ArrayList<SanPhamBean> getSanPhamTheoNSX(String mnsx) throws Exception {
		ArrayList<SanPhamBean> ds = new ArrayList<SanPhamBean>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();

		// b2: tao cau lenh sql
		String sql = "select * from dbo.func_GetSanPhamTheoNSX(?)";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, mnsx);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		// b5: duyet rs de dua vao mang ds
		while (rs.next()) {
			String MaSP = rs.getString("MaSP");
			String TenSP = rs.getString("TenSP");
			String Gia = rs.getString("Gia");
			Long SoLuong = rs.getLong("SoLuong");
			String Anh = rs.getString("Anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String MaLoai = rs.getString("MaLoai");
			String MaNSX = rs.getString("MaNSX");
			String GiaGoc = rs.getString("GiaGoc");
			ds.add(new SanPhamBean(MaSP, TenSP, Gia, SoLuong, Anh, NgayNhap, MaLoai, MaNSX, GiaGoc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

	public ArrayList<SanPhamBean> getSanPhamTimKiem(String key) throws Exception {
		ArrayList<SanPhamBean> ds = new ArrayList<SanPhamBean>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		// b2: tao cau lenh sql
		String sql = "select * from dbo.func_GetSanPhamTimKiem(?)";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, key);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		// b5: duyet rs de dua vao mang ds
		while (rs.next()) {
			String MaSP = rs.getString("MaSP");
			String TenSP = rs.getString("TenSP");
			String Gia = rs.getString("Gia");
			Long SoLuong = rs.getLong("SoLuong");
			String Anh = rs.getString("Anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String MaLoai = rs.getString("MaLoai");
			String MaNSX = rs.getString("MaNSX");
			String GiaGoc = rs.getString("GiaGoc");
			ds.add(new SanPhamBean(MaSP, TenSP, Gia, SoLuong, Anh, NgayNhap, MaLoai, MaNSX, GiaGoc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

	public ArrayList<SanPhamBean> PhanTrang(int sotrang) throws Exception {
		ArrayList<SanPhamBean> ds = new ArrayList<SanPhamBean>();
		int sosach = sotrang * 15 - 15;
		// b1: goi ket noi csdl
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		// b2: tao cau lenh sql
		String sql = "select * from dbo.func_PhanTrang(?)";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, sosach);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		// b5: duyet rs de dua vao mang ds
		while (rs.next()) {
			String MaSP = rs.getString("MaSP");
			String TenSP = rs.getString("TenSP");
			String Gia = rs.getString("Gia");
			Long SoLuong = rs.getLong("SoLuong");
			String Anh = rs.getString("Anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String MaLoai = rs.getString("MaLoai");
			String MaNSX = rs.getString("MaNSX");
			String GiaGoc = rs.getString("GiaGoc");
			ds.add(new SanPhamBean(MaSP, TenSP, Gia, SoLuong, Anh, NgayNhap, MaLoai, MaNSX, GiaGoc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

	// Phân trang khi tìm kiếm theo loại
	public ArrayList<SanPhamBean> PhanTrangTheoLoai(int sotrang, String mloai) throws Exception {
		ArrayList<SanPhamBean> ds = new ArrayList<SanPhamBean>();
		int sosach = sotrang * 15 - 15;
		// b1: goi ket noi csdl
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		// b2: tao cau lenh sql
		String sql = "select * from dbo.func_PhanTrangTheoLoai(?,?)";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, sosach);
		cmd.setString(2, mloai);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		// b5: duyet rs de dua vao mang ds
		while (rs.next()) {
			String MaSP = rs.getString("MaSP");
			String TenSP = rs.getString("TenSP");
			String Gia = rs.getString("Gia");
			Long SoLuong = rs.getLong("SoLuong");
			String Anh = rs.getString("Anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String MaLoai = rs.getString("MaLoai");
			String MaNSX = rs.getString("MaNSX");
			String GiaGoc = rs.getString("GiaGoc");
			ds.add(new SanPhamBean(MaSP, TenSP, Gia, SoLuong, Anh, NgayNhap, MaLoai, MaNSX, GiaGoc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

	public ArrayList<SanPhamBean> PhanTrangTheoKey(int sotrang, String key) throws Exception {
		ArrayList<SanPhamBean> ds = new ArrayList<SanPhamBean>();
		int sosach = sotrang * 15 - 15;
		// b1: goi ket noi csdl
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		// b2: tao cau lenh sql
		String sql = "select * from dbo.func_PhanTrangTheoKey(?, ?)";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, sosach);
		cmd.setString(2, key);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		// b5: duyet rs de dua vao mang ds
		while (rs.next()) {
			String MaSP = rs.getString("MaSP");
			String TenSP = rs.getString("TenSP");
			String Gia = rs.getString("Gia");
			Long SoLuong = rs.getLong("SoLuong");
			String Anh = rs.getString("Anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String MaLoai = rs.getString("MaLoai");
			String MaNSX = rs.getString("MaNSX");
			String GiaGoc = rs.getString("GiaGoc");
			ds.add(new SanPhamBean(MaSP, TenSP, Gia, SoLuong, Anh, NgayNhap, MaLoai, MaNSX, GiaGoc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

	public ArrayList<SanPhamBean> PhanTrangTheoNSX(int sotrang, String mnsx) throws Exception {
		ArrayList<SanPhamBean> ds = new ArrayList<SanPhamBean>();
		int sosach = sotrang * 15 - 15;
		// b1: goi ket noi csdl
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		// b2: tao cau lenh sql
		String sql = "select * from dbo.func_PhanTrangTheoNSX(?, ?)";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, sosach);
		cmd.setString(2, mnsx);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		// b5: duyet rs de dua vao mang ds
		while (rs.next()) {
			String MaSP = rs.getString("MaSP");
			String TenSP = rs.getString("TenSP");
			String Gia = rs.getString("Gia");
			Long SoLuong = rs.getLong("SoLuong");
			String Anh = rs.getString("Anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String MaLoai = rs.getString("MaLoai");
			String MaNSX = rs.getString("MaNSX");
			String GiaGoc = rs.getString("GiaGoc");
			ds.add(new SanPhamBean(MaSP, TenSP, Gia, SoLuong, Anh, NgayNhap, MaLoai, MaNSX, GiaGoc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

	public SanPhamBean kiemTraSanPhamBean(String masp) throws Exception {
		SanPhamBean sp = null;
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from SanPham where MaSP=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, masp);
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			String MaSP = rs.getString("MaSP");
			String TenSP = rs.getString("TenSP");
			String Gia = rs.getString("Gia");
			Long SoLuong = rs.getLong("SoLuong");
			String Anh = rs.getString("Anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String MaLoai = rs.getString("MaLoai");
			String MaNSX = rs.getString("MaNSX");
			String GiaGoc = rs.getString("GiaGoc");
			sp = new SanPhamBean(MaSP, TenSP, Gia, SoLuong, Anh, NgayNhap, MaLoai, MaNSX, GiaGoc);
		}
		return sp;
	}

	public int ThemSanPham(String masp, String ten, long gia, long soluong, String anh, String maloai, String mansx,
			long giagoc) throws Exception {
		// B1: Ket noi vao csdl
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		// B2: tao cau lenh sql
		String sql = "insert into SanPham(MaSP,TenSP,Gia,SoLuong,Anh,NgayNhap,MaLoai,MaNSX,GiaGoc) values(?,?,?,?,?,?,?,?,?)";
		// b3: Tao cau lenh PreparedStatement
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyen tham so
		cmd.setString(1, masp);
		cmd.setString(2, ten);
		cmd.setLong(3, gia);
		cmd.setLong(4, soluong);
		cmd.setString(5, anh);
		Date n1 = new Date();// Lấy Ngày trong máy ra
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		String tam = dd.format(n1); // Đổi ngày ra chuỗi theo dd
		Date n2 = dd.parse(tam);// Đổi chuỗi ra ngày util
		// Đổi ngày util sang ngày sql
		cmd.setDate(6, new java.sql.Date(n2.getTime()));
		cmd.setString(7, maloai);
		cmd.setString(8, mansx);
		cmd.setLong(9, giagoc);
		int kq = cmd.executeUpdate();// b5: Thuc hien cau lenh
		kn.cn.close();
		return kq;
	}
}
