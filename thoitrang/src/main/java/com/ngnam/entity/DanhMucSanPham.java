package com.ngnam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="DANHMUCSANPHAM")
public class DanhMucSanPham {
	@Id
	@Column(name="madanhmuc")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maDanhMuc;
	
	@Column(name="tendanhmuc")
	private String tenDanhMuc;
	
	@Column(name="hinhdanhmuc")
	private String hinhDanhMuc;
	
	// Các hàm khởi tạo
	public DanhMucSanPham() { }

	// Các hàm getter và setter
	public int getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public String getHinhDanhMuc() {
		return hinhDanhMuc;
	}
	public void setHinhDanhMuc(String hinhDanhMuc) {
		this.hinhDanhMuc = hinhDanhMuc;
	} 
}