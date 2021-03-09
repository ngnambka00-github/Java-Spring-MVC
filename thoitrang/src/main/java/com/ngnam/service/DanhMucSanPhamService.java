package com.ngnam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngnam.dao.DanhMucSanPhamDAO;
import com.ngnam.dao_imp.DanhMucSanPhamImp;
import com.ngnam.entity.DanhMucSanPham;

@Service
public class DanhMucSanPhamService implements DanhMucSanPhamImp{
	
	@Autowired
	DanhMucSanPhamDAO danhMucSanPhamDAO;
	
	public List<DanhMucSanPham> layDanhSachDanhMucSanPham() {
		return danhMucSanPhamDAO.layDanhSachDanhMucSanPham();
	}

}
