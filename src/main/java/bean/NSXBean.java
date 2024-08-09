package bean;

public class NSXBean {
	private String MaNSX;
	private String TenNSX;
	public NSXBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NSXBean(String maNSX, String tenNSX) {
		super();
		MaNSX = maNSX;
		TenNSX = tenNSX;
	}
	public String getMaNSX() {
		return MaNSX;
	}
	public void setMaNSX(String maNSX) {
		MaNSX = maNSX;
	}
	public String getTenNSX() {
		return TenNSX;
	}
	public void setTenNSX(String tenNSX) {
		TenNSX = tenNSX;
	}
	@Override
	public String toString() {
		return TenNSX;
	}
	
	
}
