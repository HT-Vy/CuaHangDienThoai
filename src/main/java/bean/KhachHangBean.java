package bean;

public class KhachHangBean {
	private Long MaKH;
	private String HoTen;
	private String DiaChi;
	private String SDT;
	private String Username;
	private String Password;
	public KhachHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHangBean(Long maKH, String hoTen, String diaChi, String sDT, String username, String password) {
		super();
		MaKH = maKH;
		HoTen = hoTen;
		DiaChi = diaChi;
		SDT = sDT;
		Username = username;
		Password = password;
	}
	public Long getMaKH() {
		return MaKH;
	}
	public void setMaKH(Long maKH) {
		MaKH = maKH;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
}
