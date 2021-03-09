package com.ngnam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngnam.dao.HoaDonDAO;
import com.ngnam.dao_imp.HoaDonImp;
import com.ngnam.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonImp{
	@Autowired
	HoaDonDAO hoaDonDAO;

	public boolean themHoaDon(HoaDon hoadon) {
		return hoaDonDAO.themHoaDon(hoadon);
	}
	
}
