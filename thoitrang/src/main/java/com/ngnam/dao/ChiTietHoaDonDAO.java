package com.ngnam.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.ngnam.dao_imp.ChiTietHoaDonImp;
import com.ngnam.entity.ChiTietHoaDon;
import com.ngnam.entity.ChiTietHoaDonId;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDAO implements ChiTietHoaDonImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		Session session = sessionFactory.getCurrentSession();
		ChiTietHoaDonId chiTietHoaDonId = (ChiTietHoaDonId) session.save(chiTietHoaDon);
		return chiTietHoaDonId != null;
	}

}
