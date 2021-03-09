package com.ngnam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ngnam.dao_imp.SanPhamImp;
import com.ngnam.entity.SanPham;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<SanPham> layDanhSachSanPham(int spBatDau, int soLuong) {
		Session session = sessionFactory.getCurrentSession();

		List<SanPham> listSanPham = (List<SanPham>)session
						.createQuery("from SANPHAM")
						.setFirstResult(spBatDau)
						.setMaxResults(soLuong)
						.getResultList();
		return listSanPham;
	}

	@Transactional
	public SanPham laySanPhamTheoMa(int maSanPham) {
		Session session = sessionFactory.getCurrentSession();
		
		SanPham sanPham = (SanPham)session
					.createQuery("from SANPHAM where masanpham= :masp")
					.setParameter("masp", maSanPham)
					.uniqueResult();
		return sanPham;
	}

	@Transactional
	public List<SanPham> layDanhSachSanPhamTheoDanhMuc(int maDanhMuc) {
		Session session = sessionFactory.getCurrentSession();
		
		String query = "from SANPHAM sp where sp.danhMuc.maDanhMuc = :madm";
		List<SanPham> listSanPham = (List<SanPham>)session
				.createQuery(query)
				.setParameter("madm", maDanhMuc)
				.getResultList();
		
		return listSanPham;
	}
	
	@Transactional
	public int tongSoLuongSanPham() {
		Session session = sessionFactory.getCurrentSession();
		
		List<SanPham> listSanPham = (List<SanPham>)session
				.createQuery("from SANPHAM")
				.getResultList();
		return listSanPham.size();
	}
	
}
