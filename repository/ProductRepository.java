package repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	public boolean existsBySku(String sku) ;

	public List<Product> findByVendorName(String value); 
}


	
