package bean;

import java.util.Date;

public class SanPhamBean {
	private String MaSP;
	private String TenSP;
	private String Gia;
	private Long SoLuong;
	private String Anh;
	private Date NgayNhap;
	private String MaLoai;
	private String MaNSX;
	private String GiaGoc;
	public SanPhamBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SanPhamBean(String maSP, String tenSP, String gia, Long soLuong, String anh, Date ngayNhap, String maLoai,
			String maNSX, String giaGoc) {
		super();
		MaSP = maSP;
		TenSP = tenSP;
		Gia = gia;
		SoLuong = soLuong;
		Anh = anh;
		NgayNhap = ngayNhap;
		MaLoai = maLoai;
		MaNSX = maNSX;
		GiaGoc = giaGoc;
	}

	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public String getGia() {
		return Gia;
	}
	public void setGia(String gia) {
		Gia = gia;
	}
	public Long getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(Long soLuong) {
		SoLuong = soLuong;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public Date getNgayNhap() {
		return NgayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getMaNSX() {
		return MaNSX;
	}
	public void setMaNSX(String maNSX) {
		MaNSX = maNSX;
	}

	public String getGiaGoc() {
		return GiaGoc;
	}

	public void setGiaGoc(String giaGoc) {
		GiaGoc = giaGoc;
	}
	
	
	
}
