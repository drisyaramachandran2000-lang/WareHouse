package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;


import model.Product;
import repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
//	to post product
//	created 200
//	bad request 400

	public Object postProduct(@RequestBody Product product) {
		
		if (productRepository.existsBySku(product.getSku())){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		try {
			Product newProduct = new Product(product.getId(), product.getName(), product.getDescription(),
					product.getVendorName(), product.getPrice(), product.getStock(), product.getCurrency(),
					product.getImageUrl(), product.getSku());
			
			productRepository.save(newProduct);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		}

//	to get all products details
//	created 200
//	bad request 400
	public Object getProduct() {
		List<Product> myProducts = productRepository.findAll();
		if(myProducts.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}else {
//			return ResponseEntity.status(HttpStatus.OK).body(myProducts);
			return ResponseEntity.ok(myProducts);
		}
	}
	
//	to get the product with path variable
//	created 200
//	bad request 400

	public ResponseEntity<Object> getSimilarVendor(String value) {
		List<Product> myProduct = productRepository.findByVendorName(value);
		
		if(myProduct.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}else {
			return ResponseEntity.ok(myProduct);
		}
		
	}

	public ResponseEntity<Object> updateProduct(int id, Product product) {
		Optional<Product> uProduct = productRepository.findById(id);
		if(uProduct.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		try {
			Product existingProduct = uProduct.get();
			existingProduct.setStock(product.getStock());
			existingProduct.setPrice(product.getPrice());
			Product updatedProduct = productRepository.save(existingProduct);
			return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}

	public ResponseEntity<Object> deleteProduct(int id) {
	
		if(!productRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}
		try {
			productRepository.deleteById(id);;
			return ResponseEntity.status(HttpStatus.OK).build();
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	

	
		
		
	}
