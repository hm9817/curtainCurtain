package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Category;
import com.entity.Gbook;
import com.entity.News;
import com.entity.Product;
import com.service.CategoryService;
import com.service.CommonService;
import com.service.CompanyService;
import com.service.ExampleService;
import com.service.GbookService;
import com.service.NewsService;
import com.service.ProductService;
import com.util.PageUtil;

/**
 * 前台相关接口
 */
@Controller
@RequestMapping("/index")
public class IndexController{

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
	 * 首页
	 * @return
	 */
	@GetMapping("/index")
	public String index(HttpServletRequest request){
		// 基础信息
		request.setAttribute("bannerList", commonService.getBannerList());
		request.setAttribute("textList", commonService.getTextList());
		request.setAttribute("qrcode", commonService.getQrcode());
		// 公司信息
		request.setAttribute("company", companyService.get());
		// 类目信息
		List<Category> categoryList = categoryService.getList();
		request.setAttribute("categoryList", categoryList);
		// 按类目顺序封装产品信息列表
		List<List<Product>> productList = new ArrayList<>(categoryList.size());
		for(Category category : categoryList) {
			productList.add(productService.getListByCategory(category.getId(), 1, 16)); // 最多取16个
		}
		request.setAttribute("productList", productList);
		// 案例列表
		request.setAttribute("exampleList", exampleService.getList(1, 6)); // 取前6个
		// 新闻列表
		request.setAttribute("newsList1", newsService.getListByType(News.TYPE_COMPANY, 1, 4));
		request.setAttribute("newsList2", newsService.getListByType(News.TYPE_INDUSTRY, 1, 4));
		return "/index/index.jsp";
	}
	
	/**
	 * 公司简介
	 * @return
	 */
	@GetMapping("/about")
	public String about(HttpServletRequest request) {
		request.setAttribute("company", companyService.get());
		request.setAttribute("bannerList", commonService.getBannerList());
		request.setAttribute("categoryList", categoryService.getList());
		return "/index/about.jsp";
	}
	
	/**
	 * 新闻资讯
	 * @return
	 */
	@GetMapping("/news")
	public String news(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="0")int id,
			@RequestParam(required=false, defaultValue="0")byte type,
			@RequestParam(required=false, defaultValue="1")int page){
		int size = 4; // 每页数量
		request.setAttribute("company", companyService.get());
		request.setAttribute("bannerList", commonService.getBannerList());
		request.setAttribute("categoryList", categoryService.getList());
		if(id > 0) {
			request.setAttribute("news", newsService.get(id));
			return "/index/news2.jsp";
		}else {
			if(type > 0) {
				request.setAttribute("newsList", newsService.getListByType(type, page, size));
				request.setAttribute("pageHtml", PageUtil.getPageHtml(request, newsService.getTotalByType(type), page, size));
			}else {
				request.setAttribute("newsList", newsService.getList(page, size));
				request.setAttribute("pageHtml", PageUtil.getPageHtml(request, newsService.getTotal(), page, size));
			}
			return "/index/news.jsp";
		}
	}
	
	/**
	 * 产品展示
	 * @return
	 */
	@GetMapping("/product")
	public String product(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="0")int id,
			@RequestParam(required=false, defaultValue="0")int categoryId,
			@RequestParam(required=false, defaultValue="1")int page){
		int size = 6; // 每页数量
		request.setAttribute("company", companyService.get());
		request.setAttribute("bannerList", commonService.getBannerList());
		request.setAttribute("categoryList", categoryService.getList());
		if(id > 0) {
			request.setAttribute("product", productService.get(id));
			return "/index/product2.jsp";
		}else {
			if(categoryId > 0) {
				request.setAttribute("productList", productService.getListByCategory(categoryId, page, size));
				request.setAttribute("pageHtml", PageUtil.getPageHtml(request, productService.getTotalByCategory(categoryId), page, size));
			}else {
				request.setAttribute("productList", productService.getList(page, size));
				request.setAttribute("pageHtml", PageUtil.getPageHtml(request, productService.getTotal(), page, size));
			}
			return "/index/product.jsp";
		}
	}
	
	/**
	 * 精品案例
	 * @return
	 */
	@GetMapping("/example")
	public String example(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="0")int id,
			@RequestParam(required=false, defaultValue="0")int categoryId,
			@RequestParam(required=false, defaultValue="1")int page) {
		int size = 6; // 每页数量
		request.setAttribute("company", companyService.get());
		request.setAttribute("bannerList", commonService.getBannerList());
		request.setAttribute("categoryList", categoryService.getList());
		if(id > 0) {
			request.setAttribute("example", exampleService.get(id));
			return "/index/example2.jsp";
		}else {
			if(categoryId > 0) {
				request.setAttribute("exampleList", exampleService.getListByCategory(categoryId, page, size));
				request.setAttribute("pageHtml", PageUtil.getPageHtml(request, exampleService.getTotalByCategory(categoryId), page, size));
			}else {
				request.setAttribute("exampleList", exampleService.getList(page, size));
				request.setAttribute("pageHtml", PageUtil.getPageHtml(request, exampleService.getTotal(), page, size));
			}
			return "/index/example.jsp";
		}
	}
	
	/**
	 * 联系我们
	 * @return
	 */
	@GetMapping("/contact")
	public String contact(HttpServletRequest request) {
		request.setAttribute("company", companyService.get());
		request.setAttribute("bannerList", commonService.getBannerList());
		request.setAttribute("categoryList", categoryService.getList());
		return "/index/contact.jsp";
	}
	
	/**
	 * 留言
	 * @param gbook
	 * @return
	 */
	@PostMapping("/message")
	public @ResponseBody String message(Gbook gbook) {
		return gbookService.add(gbook) ? "ok" : null;
	}

}