package com.aji.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aji.entity.User;

import jakarta.transaction.Transactional;
@Transactional
public interface UserRepo extends CrudRepository<User, Integer> {

	public List<User> findByCountry(String country);

	public List<User> findByCountryAndName(String country, String name);

	@Query("from User")
	public List<User> getAllUsers();

	@Query(value = "select * from user_info", nativeQuery = true)
	public List<User> getAllUsersSql();

	@Modifying
	@Query("insert into User (id,name,country,gender) values(:id,:name,:country,:gender)")
	public void insertDataHql(@Param("id") Integer id, @Param("name") String name, @Param("country") String country,
			@Param("gender") String gender);
	@Modifying
	@Query("delete User where id=:id")
	public void deleteHql(@Param("id") Integer id);
	@Modifying
	@Query("update User set name=:name,country=:country where id=:id")
	public void updateHql(@Param("name") String name,@Param("country") String country,@Param("id") Integer id);
	@Modifying
	@Query("insert into User (id,name,country,gender) values(:id,:name,:country,:gender)")
	public void insertDataHql1(@Param("id") Integer id, @Param("name") String name, @Param("country") String country,
			@Param("gender") String gender);


}
