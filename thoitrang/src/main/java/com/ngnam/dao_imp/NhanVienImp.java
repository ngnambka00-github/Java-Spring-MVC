package com.ngnam.dao_imp;

import com.ngnam.entity.EnumDangNhap;
import com.ngnam.entity.NhanVien;

public interface NhanVienImp {
	public EnumDangNhap kiemTraDangNhap(String tenDangNhap, String matKhau);
	public boolean themNhanVien(NhanVien nhanVien);
}
