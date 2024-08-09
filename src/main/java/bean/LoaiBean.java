package bean;

public class LoaiBean {
	private String MaLoai;
	private String TenLoai;
	private String AnhLoai;
	public LoaiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoaiBean(String maLoai, String tenLoai, String anhLoai) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoai;
		AnhLoai = anhLoai;
	}

	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getTenLoai() {
		return TenLoai;
	}
	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}

	public String getAnhLoai() {
		return AnhLoai;
	}

	public void setAnhLoai(String anhLoai) {
		AnhLoai = anhLoai;
	}
	
	
}
