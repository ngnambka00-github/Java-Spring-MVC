package com.ngnam.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="CHITIETSANPHAM")
public class ChiTietSanPham {
	@Id
	@Column(name="machitietsanpham")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maChiTietSanPham;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="masanpham")
	private SanPham sanPham;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="mamau")
	private MauSanPham mauSanPham;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="masize")
	private SizeSanPham sizeSanPham;
	
	@Column(name="soluong")
	private int soLuong;
	
	@Column(name="ngaynhap")
	private String ngayNhap;
	
	
	// Các hàm khởi tạo 
	public ChiTietSanPham() { }

	// Các hàm getter và setter 
	public int getMaChiTietSanPham() {
		return maChiTietSanPham;
	}
	public void setMaChiTietSanPham(int maChiTietSanPham) {
		this.maChiTietSanPham = maChiTietSanPham;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public MauSanPham getMauSanPham() {
		return mauSanPham;
	}
	public void setMauSanPham(MauSanPham mauSanPham) {
		this.mauSanPham = mauSanPham;
	}
	public SizeSanPham getSizeSanPham() {
		return sizeSanPham;
	}
	public void setSizeSanPham(SizeSanPham sizeSanPham) {
		this.sizeSanPham = sizeSanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	} 
}
