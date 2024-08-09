package bean;

import java.util.Date;

public class GioHangBean {
	private String MaSP;
	private String TenSP;
	private Long SoLuongMua;
	private String Gia;
	private String Anh;
	private String GiaGoc;
	private Long ThanhTien;
	private Long SoLuong;
	public GioHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GioHangBean(String maSP, String tenSP, Long soLuongMua, String gia, String anh, String giaGoc, Long soLuong) {
		super();
		MaSP = maSP;
		TenSP = tenSP;
		SoLuongMua = soLuongMua;
		Gia = gia;
		Anh = anh;
		GiaGoc = giaGoc;
		String replacedStr = gia.replace(",","");
        long g = Long.parseLong(replacedStr);
		ThanhTien = soLuongMua*g;
		SoLuong = soLuong;
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
	
	
	public Long getSoLuongMua() {
		return SoLuongMua;
	}

	public void setSoLuongMua(Long soLuongMua) {
		SoLuongMua = soLuongMua;
	}

	public String getGia() {
		return Gia;
	}
	public void setGia(String gia) {
		Gia = gia;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public String getGiaGoc() {
		return GiaGoc;
	}
	public void setGiaGoc(String giaGoc) {
		GiaGoc = giaGoc;
	}
	public Long getThanhTien() {
		String replacedStr = Gia.replace(",","");
        long g = Long.parseLong(replacedStr);
		return SoLuongMua*g;
	}
	public void setThanhTien(Long thanhTien) {
		ThanhTien = thanhTien;
	}

	public Long getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(Long soLuong) {
		SoLuong = soLuong;
	}
	
	
}
