package bo;

import java.util.ArrayList;

import bean.NSXBean;
import dao.NSXDao;

public class NSXBo {
	NSXDao sx = new NSXDao();
	public ArrayList<NSXBean> getNSX() throws Exception{
		return sx.getNSX();
	}
	public NSXBean timNSX(String ma) throws Exception{
		return sx.timNSX(ma);
	}
	public ArrayList<NSXBean> getNSXTheoLoai(String mloai) throws Exception{
		return sx.getNSXTheoLoai(mloai);
	}
}
