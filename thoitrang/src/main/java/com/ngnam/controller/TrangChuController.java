package com.ngnam.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ngnam.entity.GiamDoc;
import com.ngnam.entity.NhanVien;
import com.ngnam.entity.SinhVien;

@Controller
public class TrangChuController {
	
	// @ResponseBody -> Cho phép trả về chuỗi 
	@RequestMapping("/")
	public String viewTrangChu() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		NhanVien nv1 = (NhanVien)context.getBean("NhanVien");
		GiamDoc gd = nv1.getDoc();
		System.out.println(gd);
		
//		CustomLoader customLoader = new CustomLoader();
//		customLoader.setResourceLoader(context);
		CustomLoader customLoader = (CustomLoader)context.getBean("CustomLoader");
		String path = "https://jsonplaceholder.typicode.com/todos/1";
//		Resource resource = context.getResource(path);
		Resource resource = customLoader.getResource(path);
		try {
			InputStream inputStream = resource.getInputStream();
			InputStreamReader reader = new InputStreamReader(inputStream);
			BufferedReader bufferReader = new BufferedReader(reader);
			
			String line = "";
			StringBuilder data = new StringBuilder();
			while ((line = bufferReader.readLine()) != null) {
				data.append(line + "\n");
			}
			
			bufferReader.close();
			reader.close();
			inputStream.close();
			
			System.out.println(data.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		((ClassPathXmlApplicationContext)context).close();
		return "trangchu";
	}
	
	@RequestMapping("/demo")
	public String viewLogin() {
		return "trangchu";
	}
	
	// ví dụ cho trường hợp trả vể kiểu ModelAndView
	@RequestMapping("/ControllerAndView") 
	public ModelAndView viewDemoCAV() {
		ModelAndView viewTrangChu = new ModelAndView();
		viewTrangChu.setViewName("home");
		
		String username = "ngnambka00";
		String password = "dgsMUE35";
		
		viewTrangChu.addObject("user", username);
		viewTrangChu.addObject("pass", password);
		return viewTrangChu;
	}
	
	//Demo ví dụ truyền và nhận List và Object với view
	// ListObject
	@RequestMapping(path="/ListObject", method=RequestMethod.GET) 
	public String viewListObject(ModelMap modelMap) {
		SinhVien sv = new SinhVien();
		sv.setTenSinhVien("Nguyễn Văn Nam");
		sv.setMSSV(1234);
		sv.setDiemTT(3.04);
		
		SinhVien sv2 = new SinhVien();
		sv2.setTenSinhVien("Trần Thị Hà");
		sv2.setMSSV(3233);
		sv2.setDiemTT(4.545);
		
		List<SinhVien> listSinhVien = new ArrayList<SinhVien>();
		listSinhVien.add(sv);
		listSinhVien.add(sv2);
		modelMap.addAttribute("sinhVien", sv);
		modelMap.addAttribute("listSV", listSinhVien);
		return "listObject";
	}
	
	
	@RequestMapping(path="/home", method=RequestMethod.GET)
	public String viewHome() {
		return "viewHome";
	}
	

	@RequestMapping(path="/chitiet", method=RequestMethod.GET)
	public String viewChiTiet(@RequestParam(name="id", required=false) int id,
				@RequestParam(name="tensp", required=true) String tenSP, ModelMap modelMap) {
		modelMap.addAttribute("id", id);
		modelMap.addAttribute("tensp", tenSP);
		return "ChiTiet";
	}
	
	@RequestMapping(path="/pathvariable/{id}/{tensp}/{ngaysanxuat}", method=RequestMethod.GET) 
	public ModelAndView viewPathVariable(@PathVariable("id") int id,
			@PathVariable("tensp") String tenSanPham, 
			@PathVariable("ngaysanxuat") String ngaySanXuat) {
		ModelAndView modelAndView  = new ModelAndView();
		modelAndView.setViewName("ChiTiet");
		
		modelAndView.addObject("id", id);
		modelAndView.addObject("tensp", tenSanPham);
		modelAndView.addObject("ngaysx", ngaySanXuat);
		return modelAndView;
	}
}



