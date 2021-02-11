package com.ngnam.entity;

public class GiamDoc extends NhanVien{
	private String chucVu;
	
	public GiamDoc() { }
	
	public GiamDoc(String chucVu) {
		this.chucVu = chucVu;
	}
	
	public GiamDoc(String chucVu, String tenGD, String diaChi, int tuoi) {
		super(tenGD, diaChi, tuoi);
		this.chucVu = chucVu;
	}
	public String getChucVu() {
		return this.chucVu;
	}
	
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	@Override
	public String toString() {
		return "GiamDoc [chucVu=" + chucVu + ", tenNhanVien=" + tenNhanVien + ", diaChi=" + diaChi + ", tuoi=" + tuoi
				+ ", doc=" + doc + "]";
	}
	
	
}
