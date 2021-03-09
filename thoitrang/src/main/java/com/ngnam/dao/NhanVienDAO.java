package com.ngnam.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.ngnam.dao_imp.NhanVienImp;
import com.ngnam.entity.EnumDangNhap;
import com.ngnam.entity.NhanVien;


@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhanVienDAO implements NhanVienImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public EnumDangNhap kiemTraDangNhap(String tenDangNhap, String matKhau) {
		Session session = sessionFactory.getCurrentSession();
		
		String strQuery = "from NHANVIEN where tendangnhap= :user";
		
		NhanVien nhanVien = (NhanVien)session
					.createQuery(strQuery)
					.setParameter("user", tenDangNhap)
					.uniqueResult();
		if (nhanVien != null) {
			if (nhanVien.getMatKhau().equals(matKhau)) { 
				return EnumDangNhap.THANH_CONG;
			} else { 
				return EnumDangNhap.SAI_MAT_KHAU;
			}
		}
		
		return EnumDangNhap.USER_KO_TON_TAI;
	}

	@Transactional
	public boolean themNhanVien(NhanVien nhanVien) {
		Session session = sessionFactory.getCurrentSession();
		int maNhanVien = (Integer)session.save(nhanVien);
		return maNhanVien > 0;
	}
	
}

