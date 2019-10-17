package com.flip.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flip.entity.Product;
import com.flip.service.ProductService;



@Controller
@RequestMapping("/products")
public class ProductRestController{
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public String getProducts(Model theModel){
		
		List<Product> theProducts = productService.getProducts();
		theModel.addAttribute("products",theProducts);
		return "product-list";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("productId") int theId, Model theModel) {
		Product theProduct = productService.getProduct(theId);
		System.out.println(theProduct.getQuantity());
		if(theProduct.getQuantity()>0) {
			synchronized (this) {
				productService.deleteProduct(theId);
			}
		}
		return "redirect:/products/list";
	}
}