package bean;

public class AdminBean {
	//Làm việc ở class ChiTietHD
	private String UserAdmin;
	private String PassAdmin;
	private Boolean Quyen;
	public AdminBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminBean(String userAdmin, String passAdmin, Boolean quyen) {
		super();
		UserAdmin = userAdmin;
		PassAdmin = passAdmin;
		Quyen = quyen;
	}
	public String getUserAdmin() {
		return UserAdmin;
	}
	public void setUserAdmin(String userAdmin) {
		UserAdmin = userAdmin;
	}
	public String getPassAdmin() {
		return PassAdmin;
	}
	public void setPassAdmin(String passAdmin) {
		PassAdmin = passAdmin;
	}
	public Boolean getQuyen() {
		return Quyen;
	}
	public void setQuyen(Boolean quyen) {
		Quyen = quyen;
	}
	
	
}
