package com.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Admin;
import com.entity.Category;
import com.entity.Company;
import com.entity.Example;
import com.entity.News;
import com.entity.Product;
import com.service.AdminService;
import com.service.CategoryService;
import com.service.CommonService;
import com.service.CompanyService;
import com.service.ExampleService;
import com.service.GbookService;
import com.service.NewsService;
import com.service.ProductService;
import com.util.PageUtil;
import com.util.SafeUtil;
import com.util.UploadUtil;

/**
 * 后台相关接口
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final int rows = 10;

	@Autowired
	private AdminService adminService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ExampleService exampleService;
	@Autowired
	private GbookService gbookService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private CommonService commonService;
	
	
	/**
	 * 管理员登录
	 * @return
	 */
	@RequestMapping("/login")
	public String login(Admin admin, HttpServletRequest request, HttpSession session) {
		if (adminService.checkUser(admin.getUsername(), admin.getPassword())) {
			session.setAttribute("username", admin.getUsername());
			return "redirect:index";
		}
		request.setAttribute("msg", "用户名或密码错误!");
		return "/admin/login.jsp";
	}

	/**
	 * 退出
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		return "/admin/login.jsp";
	}
	
	/**
	 * 后台首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		request.setAttribute("msg", "恭喜你! 登录成功了");
		return "/admin/index.jsp";
	}
	
	/**
	 * 基础设置
	 * @param request
	 * @return
	 */
	@RequestMapping("/commonEdit")
	public String commonEdit(HttpServletRequest request) {
		if("u".equals(request.getParameter("type"))) {
			request.setAttribute("msg", "修改成功!");
		}
		request.setAttribute("flag", 11);
		request.setAttribute("bannerList", commonService.getBannerList());
		request.setAttribute("textList", commonService.getTextList());
		request.setAttribute("qrcode", commonService.getQrcode());
		return "/admin/common_edit.jsp";
	}
	
	/**
	 * 基础设置
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/commonUpdate")
	public String commonUpdate(HttpServletRequest request, 
			MultipartFile[] banner, MultipartFile qrcode, String[] text) throws Exception {
		// 更新banner
		List<String> bannerList = commonService.getBannerList();
		boolean isHaveNew = false; // 记录是否上传了新图片
		for(int i=0; i<banner.length; i++) {
			if(Objects.nonNull(banner[i]) && !banner[i].isEmpty()) {
				bannerList.set(i, UploadUtil.upload(banner[i]));
				isHaveNew = true;
			}
		}
		if (isHaveNew) {
			commonService.updateBannerList(bannerList);
		}
		// 更新qrcode
		if(Objects.nonNull(qrcode) && !qrcode.isEmpty()) {
			commonService.updateQrcode(UploadUtil.upload(qrcode));
		}
		// 更新横幅
		commonService.updateTextList(Arrays.asList(text));
		return "redirect:commonEdit?type=u";
	}
	
	/**
	 * 公司编辑
	 * @param request
	 * @return
	 */
	@RequestMapping("/companyEdit")
	public String companyEdit(HttpServletRequest request) {
		if("u".equals(request.getParameter("type"))) {
			request.setAttribute("msg", "修改成功!");
		}
		request.setAttribute("flag", 1);
		request.setAttribute("company", companyService.get());
		return "/admin/company_edit.jsp";
	}
	
	/**
	 * 公司更新
	 * @param request
	 * @return
	 */
	@RequestMapping("/companyUpdate")
	public String companyUpdate(Company company, HttpServletRequest request) {
		companyService.update(company);
		return "redirect:companyEdit?type=u";
	}
	
	/**
	 * 类目列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/categoryList")
	public String categoryList(HttpServletRequest request) {
		request.setAttribute("flag", 2);
		request.setAttribute("categoryList", categoryService.getList());
		return "/admin/category_list.jsp";
	}
	
	/**
	 * 类目添加
	 * @param request
	 * @return
	 */
	@RequestMapping("/categoryAdd")
	public String categoryAdd(Category category, HttpServletRequest request) {
		categoryService.add(category);
		return "redirect:categoryList";
	}
	
	/**
	 * 类目编辑
	 * @param request
	 * @return
	 */
	@RequestMapping("/categoryEdit")
	public String categoryEdit(int id, HttpServletRequest request) {
		request.setAttribute("flag", 2);
		request.setAttribute("category", categoryService.get(id));
		return "/admin/category_edit.jsp";
	}
	
	/**
	 * 类目更新
	 * @param request
	 * @return
	 */
	@RequestMapping("/categoryUpdate")
	public String categoryUpdate(Category category, HttpServletRequest request) {
		categoryService.update(category);
		return "redirect:categoryList";
	}
	
	/**
	 * 类目删除
	 * @param request
	 * @return
	 */
	@RequestMapping("/categoryDelete")
	public String categoryDelete(int id, HttpServletRequest request) {
		categoryService.delete(id);
		return "redirect:categoryList";
	}

	/**
	 * 产品列表
	 * @return
	 */
	@RequestMapping("/productList")
	public String productList(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 3);
		request.setAttribute("page", page);
		request.setAttribute("productList",productService.getList(page, rows));
		request.setAttribute("pageHtml", PageUtil.getPageHtml(request, productService.getTotal(), page, rows));
		return "/admin/product_list.jsp";
	}
	
	/**
	 * 产品列表
	 * @return
	 */
	@RequestMapping("/productSearch")
	public String productSearch(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="0") int id, 
			@RequestParam(required=false, defaultValue="") String name) {
		request.setAttribute("flag", 3);
		if(id > 0) {
			request.setAttribute("productList",productService.getListById(id));
		}else if (!name.trim().isEmpty()) {
			request.setAttribute("productList",productService.getListByName(name));
		}else {
			request.setAttribute("productList",productService.getList(1, rows));
			request.setAttribute("pageHtml", PageUtil.getPageHtml(request, productService.getTotal(), 1, rows));
		}
		return "/admin/product_list.jsp";
	}

	/**
	 * 产品添加
	 * @return
	 */
	@RequestMapping("/productAdd")
	public String productAdd(HttpServletRequest request) {
		request.setAttribute("flag", 3);
		request.setAttribute("categoryList", categoryService.getList());
		return "/admin/product_add.jsp";
	}

	/**
	 * 产品添加
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/productSave")
	public String productSave(Product product, MultipartFile file, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception {
		product.setPhoto(UploadUtil.upload(file));
		productService.add(product);
		return "redirect:productList?page="+page;
	}
	
	/**
	 * 产品编辑
	 * @return
	 */
	@RequestMapping("/productEdit")
	public String productEdit(int id, HttpServletRequest request) {
		request.setAttribute("flag", 3);
		request.setAttribute("product", productService.get(id));
		request.setAttribute("categoryList", categoryService.getList());
		return "/admin/product_edit.jsp";
	}
	
	/**
	 * 产品更新
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/productUpdate")
	public String productUpdate(Product product, MultipartFile file, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception {
		if (Objects.nonNull(file) && !file.isEmpty()) {
			product.setPhoto(UploadUtil.upload(file));
		}
		productService.update(product);
		return "redirect:productList?page="+page;
	}
	
	/**
	 * 产品删除
	 * @return
	 */
	@RequestMapping("/productDelete")
	public String productDelete(int id,	@RequestParam(required=false, defaultValue="1") int page) {
		productService.delete(id);
		return "redirect:productList?page="+page;
	}
	
	/**
	 * 案例列表
	 * @return
	 */
	@RequestMapping("/exampleList")
	public String exampleList(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 4);
		request.setAttribute("page", page);
		request.setAttribute("exampleList",exampleService.getList(page, rows));
		request.setAttribute("pageHtml", PageUtil.getPageHtml(request, exampleService.getTotal(), page, rows));
		return "/admin/example_list.jsp";
	}
	
	/**
	 * 案例添加
	 * @return
	 */
	@RequestMapping("/exampleAdd")
	public String exampleAdd(HttpServletRequest request) {
		request.setAttribute("flag", 4);
		request.setAttribute("categoryList", categoryService.getList());
		return "/admin/example_add.jsp";
	}
	
	/**
	 * 案例添加
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/exampleSave")
	public String exampleSave(Example example, MultipartFile file, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception {
		example.setPhoto(UploadUtil.upload(file));
		exampleService.add(example);
		return "redirect:exampleList?page="+page;
	}
	
	/**
	 * 案例编辑
	 * @return
	 */
	@RequestMapping("/exampleEdit")
	public String exampleEdit(int id, HttpServletRequest request) {
		request.setAttribute("flag", 4);
		request.setAttribute("example", exampleService.get(id));
		request.setAttribute("categoryList", categoryService.getList());
		return "/admin/example_edit.jsp";
	}
	
	/**
	 * 案例更新
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/exampleUpdate")
	public String exampleUpdate(Example example, MultipartFile file, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception {
		if (Objects.nonNull(file) && !file.isEmpty()) {
			example.setPhoto(UploadUtil.upload(file));
		}
		exampleService.update(example);
		return "redirect:exampleList?page="+page;
	}
	
	/**
	 * 案例删除
	 * @return
	 */
	@RequestMapping("/exampleDelete")
	public String exampleDelete(int id,	@RequestParam(required=false, defaultValue="1") int page) {
		exampleService.delete(id);
		return "redirect:exampleList?page="+page;
	}
	
	
	/**
	 * 新闻列表
	 * @return
	 */
	@RequestMapping("/newsList")
	public String newsList(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 5);
		request.setAttribute("page", page);
		request.setAttribute("newsList", newsService.getList(page, rows));
		request.setAttribute("pageHtml", PageUtil.getPageHtml(request, newsService.getTotal(), page, rows));
		return "/admin/news_list.jsp";
	}
	
	/**
	 * 新闻添加
	 * @return
	 */
	@RequestMapping("/newsAdd")
	public String newsAdd(HttpServletRequest request) {
		request.setAttribute("flag", 5);
		return "/admin/news_add.jsp";
	}
	
	/**
	 * 新闻添加
	 * @return
	 */
	@RequestMapping("/newsSave")
	public String newsSave(News news, MultipartFile file, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception {
		news.setPhoto(UploadUtil.upload(file));
		newsService.add(news);
		return "redirect:newsList?page="+page;
	}
	
	/**
	 * 新闻编辑
	 * @return
	 */
	@RequestMapping("/newsEdit")
	public String newsEdit(int id, HttpServletRequest request) {
		request.setAttribute("flag", 5);
		request.setAttribute("news", newsService.get(id));
		return "/admin/news_edit.jsp";
	}
	
	/**
	 * 新闻更新
	 * @return
	 */
	@RequestMapping("/newsUpdate")
	public String newsUpdate(News news, MultipartFile file, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception {
		if (Objects.nonNull(file) && !file.isEmpty()) {
			news.setPhoto(UploadUtil.upload(file));
		}
		newsService.update(news);
		return "redirect:newsList?page="+page;
	}
	
	/**
	 * 新闻删除
	 * @return
	 */
	@RequestMapping("/newsDelete")
	public String newsDelete(int id, @RequestParam(required=false, defaultValue="1") int page) {
		newsService.delete(id);
		return "redirect:newsList?page="+page;
	}


	/**
	 * 留言列表
	 * @return
	 */
	@RequestMapping("/gbookList")
	public String gbookList(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 6);
		request.setAttribute("page", page);
		request.setAttribute("gbookList", gbookService.getList(page, rows));
		request.setAttribute("pageHtml", PageUtil.getPageHtml(request, gbookService.getTotal(), page, rows));
		return "/admin/gbook_list.jsp";
	}
	
	/**
	 * 留言删除
	 * @return
	 */
	@RequestMapping("/gbookDelete")
	public String gbookDelete(int id, @RequestParam(required=false, defaultValue="1") int page) {
		gbookService.delete(id);
		return "redirect:gbookList?page="+page;
	}
	
	
	/**
	 * 管理员列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/adminList")
	public String adminList(HttpServletRequest request) {
		request.setAttribute("flag", 7);
		request.setAttribute("adminList", adminService.getList());
		return "/admin/admin_list.jsp";
	}
	
	/**
	 * 管理员添加
	 * @param request
	 * @return
	 */
	@RequestMapping("/adminAdd")
	public String adminAdd(Admin admin, HttpServletRequest request) {
		adminService.add(admin);
		return "redirect:adminList";
	}
	
	/**
	 * 管理员编辑
	 * @return
	 */
	@RequestMapping("/adminEdit")
	public String adminEdit(int id, HttpServletRequest request, HttpSession session) {
		request.setAttribute("flag", 7);
		request.setAttribute("admin", adminService.get(id));
		return "/admin/admin_edit.jsp";
	}

	/**
	 * 管理员更新
	 * @return
	 */
	@RequestMapping("/adminUpdate")
	public String adminUpdate(Admin admin, HttpServletRequest request) {
		request.setAttribute("flag", 7);
		if (adminService.get(admin.getId()).getPassword().equals(SafeUtil.encode(admin.getPassword()))) {
			admin.setPassword(SafeUtil.encode(admin.getPasswordNew()));
			adminService.update(admin);
			request.setAttribute("admin", admin);
			request.setAttribute("msg", "修改成功!");
		}else {
			request.setAttribute("msg1", "原密码错误!");
		}
		return "/admin/admin_edit.jsp";
	}
	
	/**
	 * 管理员删除
	 * @param request
	 * @return
	 */
	@RequestMapping("/adminDelete")
	public String adminDelete(int id, HttpServletRequest request) {
		adminService.delete(id);
		return "redirect:adminList";
	}

}
