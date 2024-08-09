package bean;

import java.util.Date;

public class LichSuMuaHangBean {
	private long MaKH;
	private String MaSP;
	private String TenSP;
	private String Gia;
	private String GiaGoc;
	private long SoLuongMua;
	private String ThanhTien;
	private String Anh;
	private Date NgayMua;
	private Boolean DaMua;
	private long MaChiTietHD;
	public LichSuMuaHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LichSuMuaHangBean(long maKH, String maSP, String tenSP, String gia, String giaGoc, long soLuongMua,
			String thanhTien, String anh, Date ngayMua, Boolean daMua, long maChiTietHD) {
		super();
		MaKH = maKH;
		MaSP = maSP;
		TenSP = tenSP;
		Gia = gia;
		GiaGoc = giaGoc;
		SoLuongMua = soLuongMua;
		ThanhTien = thanhTien;
		Anh = anh;
		NgayMua = ngayMua;
		DaMua = daMua;
		MaChiTietHD = maChiTietHD;
	}

	public long getMaKH() {
		return MaKH;
	}
	public void setMaKH(long maKH) {
		MaKH = maKH;
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
	public String getGiaGoc() {
		return GiaGoc;
	}
	public void setGiaGoc(String giaGoc) {
		GiaGoc = giaGoc;
	}
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public String getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(String thanhTien) {
		ThanhTien = thanhTien;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public Boolean getDaMua() {
		return DaMua;
	}
	public void setDaMua(Boolean daMua) {
		DaMua = daMua;
	}

	public long getMaChiTietHD() {
		return MaChiTietHD;
	}

	public void setMaChiTietHD(long maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	
	
	
	
	
}
