package com.ngnam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngnam.dao.SanPhamDAO;
import com.ngnam.dao_imp.SanPhamImp;
import com.ngnam.entity.SanPham;

@Service
public class SanPhamService implements SanPhamImp{

	@Autowired
	SanPhamDAO sanPhamDAO;
	
	public List<SanPham> layDanhSachSanPham(int spBatDau, int soLuong) {
		return sanPhamDAO.layDanhSachSanPham(spBatDau, soLuong);
	}

	public SanPham laySanPhamTheoMa(int maSanPham) {
		return sanPhamDAO.laySanPhamTheoMa(maSanPham);
	}

	public List<SanPham> layDanhSachSanPhamTheoDanhMuc(int maDanhMuc) {
		return sanPhamDAO.layDanhSachSanPhamTheoDanhMuc(maDanhMuc);
	}

	public int tongSoLuongSanPham() {
		return sanPhamDAO.tongSoLuongSanPham();
	}
}
