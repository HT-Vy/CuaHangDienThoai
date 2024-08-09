package bean;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AdminXacNhanBean {
	private long MaChiTietHD;
	private String HoTen;
	private String TenSP;
	private Long Gia;
	private Long SoLuongMua;
	private Long ThanhTien;
	private Boolean DaMua;
	public AdminXacNhanBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminXacNhanBean(long maChiTietHD, String hoTen, String tenSP, Long gia, Long soLuongMua, Long thanhTien,
			Boolean daMua) {
		super();
		MaChiTietHD = maChiTietHD;
		HoTen = hoTen;
		TenSP = tenSP;
		Gia = gia;
		SoLuongMua = soLuongMua;
		ThanhTien = thanhTien;
		DaMua = daMua;
	}
	public long getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(long maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public String getGia() {
		 DecimalFormat df = new DecimalFormat("#,###");
		 String g = df.format(Gia);
		return g;
	}
	public void setGia(Long gia) {
		Gia = gia;
	}
	public Long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(Long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public String getThanhTien() {
		DecimalFormat df = new DecimalFormat("#,###");
		 String tt = df.format(ThanhTien);
		return tt;
	}
	public void setThanhTien(Long thanhTien) {
		ThanhTien = thanhTien;
	}
	public Boolean getDaMua() {
		return DaMua;
	}
	public void setDaMua(Boolean daMua) {
		DaMua = daMua;
	}
	
	
}
