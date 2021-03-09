package com.ngnam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngnam.dao.ChiTietHoaDonDAO;
import com.ngnam.dao_imp.ChiTietHoaDonImp;
import com.ngnam.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImp{
	
	@Autowired
	ChiTietHoaDonDAO chiTietHoaDonDAO;
	
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		return chiTietHoaDonDAO.themChiTietHoaDon(chiTietHoaDon);
	}

}
