package com.ngnam.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="SANPHAM")
public class SanPham {
	@Id
	@Column(name="masanpham")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maSanPham;
	
	@Column(name="tensanpham")
	private String tenSanPham;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="madanhmuc")
	private DanhMucSanPham danhMuc;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="CHITIETKHUYENMAI", 
		joinColumns = {
			@JoinColumn(name="masanpham", referencedColumnName="masanpham")
		}, 
		inverseJoinColumns = {
			@JoinColumn(name="makhuyenmai", referencedColumnName="makhuyenmai")
		}
	)
	Set<KhuyenMai> danhSachKhuyenMai;
	
	@Column(name="giatien")
	private String giaTien;
	
	@Column(name="mota")
	private String moTa;
	
	@Column(name="hinhsanpham")
	private String hinhSanPham;
	
	@Column(name="gioitinh")
	private String gioiTinh;
	
	// Thể hiện quan hệ liên kết 1 nhiều. 1 sản phẩm có thể chứa nhiều ChiTietSanPham
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="masanpham")
	Set<ChiTietSanPham> danhSachChiTietSanPham;
	
	// Thể hiện quan hệ liên kết 1-nhiều với ChiTietHoaDon
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="mahoadon")
	Set<ChiTietHoaDon> danhSachChiTietHoaDon;
	
	// Các hàm khởi tạo 
	public SanPham() { }

	// Các hàm getter và setter
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public DanhMucSanPham getDanhMuc() {
		return danhMuc;
	}
	public void setDanhMuc(DanhMucSanPham danhMuc) {
		this.danhMuc = danhMuc;
	}
	public String getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhSanPham() {
		return hinhSanPham;
	}
	public void setHinhSanPham(String hinhSanPham) {
		this.hinhSanPham = hinhSanPham;
	}
	public Set<ChiTietSanPham> getDanhSachChiTietSanPham() {
		return danhSachChiTietSanPham;
	}
	public void setDanhSachChiTietSanPham(Set<ChiTietSanPham> danhSachChiTietSanPham) {
		this.danhSachChiTietSanPham = danhSachChiTietSanPham;
	}
	public Set<KhuyenMai> getDanhSachKhuyenMai() {
		return danhSachKhuyenMai;
	}
	public void setDanhSachKhuyenMai(Set<KhuyenMai> danhSachKhuyenMai) {
		this.danhSachKhuyenMai = danhSachKhuyenMai;
	}
	public Set<ChiTietHoaDon> getDanhSachChiTietHoaDon() {
		return danhSachChiTietHoaDon;
	}
	public void setDanhSachChiTietHoaDon(Set<ChiTietHoaDon> danhSachChiTietHoaDon) {
		this.danhSachChiTietHoaDon = danhSachChiTietHoaDon;
	}
	public String getGioiTinh() {
		return this.gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
}
