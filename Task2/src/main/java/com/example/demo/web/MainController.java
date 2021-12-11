package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.MyUserDetail;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao prodDao;
	
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private UserRepository userRepo;
	
	private User user;
	
	@RequestMapping(value = {"/", "/home"})
	public ModelAndView listProduct(ModelAndView model) throws Exception{
		List<Product> listProducts = prodDao.productList();
		model.addObject("listProd", listProducts);
		if(MyUserDetail.getUser() != null) {
			this.user = MyUserDetail.getUser();
			model.addObject("fullname", this.user.getFirstname());
			model.addObject("assets", this.user.getAssets());
		} else {
			user = new User();
			model.addObject("fullname", this.user.getFirstname());
			model.addObject("assets", this.user.getAssets());
		}
		model.setViewName("index");
		
		return model;
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/buynow")
	public String BuyNow(@RequestParam("pro") int pro) {
		Product prod = productRepo.findById(pro).get();
		if(prod.getPrice()>user.getAssets()) {
			return "redirect:/home?insufficientfunds";
		}
		if(prod.getStocks()<=0) {
			return "redirect:/home?notavailable";
		}
		prod.setStocks(prod.getStocks()-1);
		productRepo.save(prod);
		
		user.setAssets(user.getAssets()-prod.getPrice());
		userRepo.save(user);
		
		return "redirect:/home?buyed";

	}
	
}
