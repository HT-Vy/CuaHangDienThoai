package bo;

import java.util.ArrayList;

import bean.AdminBean;
import bean.AdminXacNhanBean;
import dao.AdminDao;

public class AdminBo {
	AdminDao ad = new AdminDao();
	public AdminBean KiemTraDangNhapAdmin(String un,String pa)throws Exception{
		return ad.KiemTraDangNhapAdmin(un, pa);
	}
	public AdminBean kiemTraDangKy(String tendn) throws Exception{
		return ad.kiemTraDangKy(tendn);
	}
	public int Them(String tendn, String pass, Boolean quyen) throws Exception{
		return ad.Them(tendn, pass, quyen);
	}
	public int XacNhan(long macthd)throws Exception{
		return ad.XacNhan(macthd);
	}
	
	public ArrayList<AdminXacNhanBean> getXacNhan() throws Exception {
		return ad.getXacNhan();
	}
	
	public int AdminSuaSL(long mact, long sl) throws Exception {
		return ad.AdminSuaSL(mact, sl);
	}
	
	public int AdminXoaDonHang(long mact) throws Exception {
		return ad.AdminXoaDonHang(mact);
	}
}
