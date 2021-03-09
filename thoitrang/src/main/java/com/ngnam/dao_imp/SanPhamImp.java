package com.ngnam.dao_imp;

import java.util.List;

import com.ngnam.entity.SanPham;

public interface SanPhamImp {
	public List<SanPham> layDanhSachSanPham(int spBatDau, int soLuong);
	public SanPham laySanPhamTheoMa(int maSanPham);
	public List<SanPham> layDanhSachSanPhamTheoDanhMuc(int maDanhMuc);
	public int tongSoLuongSanPham();
}
