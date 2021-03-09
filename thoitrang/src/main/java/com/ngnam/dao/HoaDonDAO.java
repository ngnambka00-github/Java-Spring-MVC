package com.ngnam.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.ngnam.dao_imp.HoaDonImp;
import com.ngnam.entity.HoaDon;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAO implements HoaDonImp{
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean themHoaDon(HoaDon hoadon) {
		Session session = sessionFactory.getCurrentSession();
		
		// Chỉ cần thêm bảng hóa đơn là các bảng chi tiết hóa đơn sẽ tự động được tạo thêm mới và lưu thêm 
		int id = (Integer) session.save(hoadon);
		return id > 0;
	}
	
	
}
