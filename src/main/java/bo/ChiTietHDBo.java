package bo;

import java.util.ArrayList;

import bean.AdminXacNhanBean;
import dao.ChiTietHDDao;

public class ChiTietHDBo {
	ChiTietHDDao ctdao = new ChiTietHDDao();
	public int Them(String Masp, long SoLuongMua, long MaHoaDon) throws Exception{
		return ctdao.Them(Masp, SoLuongMua, MaHoaDon);
	}
	public int XoaDonHang(long mact) throws Exception {
		return ctdao.XoaDonHang(mact);
	}
}
