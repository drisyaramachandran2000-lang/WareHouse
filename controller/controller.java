package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import model.Product;
import service.ProductService;

@Controller
public class controller {
	
	@Autowired
	private ProductService productService;
	
	// add
	@PostMapping("/product/add")
	private Object postProduct(@RequestBody Product product) {
		return productService.postProduct(product);
	}
	
	@GetMapping("/product/get")
	private Object getProduct() {
		return productService.getProduct();
	}
	
	@GetMapping("/product/get/id")
	public ResponseEntity<Object> getSimilarVendor(@RequestParam String value) {
		return productService.getSimilarVendor(value);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody Product product){
		return productService.updateProduct(id,product);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable int id){
		return productService.deleteProduct(id);
	}

	
}
