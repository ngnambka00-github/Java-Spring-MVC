package com.ngnam.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.ngnam.dao_imp.DanhMucSanPhamImp;
import com.ngnam.entity.DanhMucSanPham;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DanhMucSanPhamDAO implements DanhMucSanPhamImp{
	
	@Autowired 
	SessionFactory sessionFactory;

	@Transactional
	public List<DanhMucSanPham> layDanhSachDanhMucSanPham() {
		Session session = sessionFactory.getCurrentSession();
		
		String query = "from DANHMUCSANPHAM";
		List<DanhMucSanPham> listDanhMucSanPham = 
				(List<DanhMucSanPham>)session 
				.createQuery(query)
				.getResultList();
		return listDanhMucSanPham;
	}
}
