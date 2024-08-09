package bo;

import java.util.ArrayList;

import bean.LoaiBean;
import dao.LoaiDao;

public class LoaiBo {
	LoaiDao ldao = new LoaiDao();
	ArrayList<LoaiBean> dsl;
	public ArrayList<LoaiBean> getLoai() throws Exception{
		dsl=ldao.getLoai();
		return dsl;
	}
	
	public LoaiBean timLoai(String ml)throws Exception{
		return ldao.timLoai(ml);
	}

}
