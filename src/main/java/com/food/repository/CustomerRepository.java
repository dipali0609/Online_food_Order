package com.food.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.food.dao.Customer;

@EnableJpaRepositories
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    
	@Query(value="select * from customer  where customeremailid=?1", nativeQuery = true)
	List<Customer> loginCheck(String customeremailid);
     
	
	
//     @Query(value="select customeremailid, customerpassword from customer where customerid=?1",nativeQuery = true)
//	Customer retriveloginDetails(Customer customer, Integer customerid);
//
//	Customer findByEmail(String customeremailid);
//
//	Optional<Customer> findOneByEmailAndPassword(String customeremailid, String encodedPassword);

	

}
