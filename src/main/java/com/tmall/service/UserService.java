

package com.tmall.service;


import com.tmall.dao.PropertyDAO;
import com.tmall.dao.UserDAO;
import com.tmall.pojo.User;
import com.tmall.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
@CacheConfig(cacheNames="users")
public class UserService {
	
	@Autowired
	UserDAO userDAO;

	
	public boolean isExist(String name) {
		//UserService userService = SpringContextUtil.getBean(UserService.class);
		User user = getByName(name);
		return null!=user;
	}

	//@Cacheable(key="'users-one-name-'+ #p0")
	public User getByName(String name) {
		return userDAO.findByName(name);
	}
	
	

	//@Cacheable(key="'users-one-name-'+ #p0 +'-password-'+ #p1")
	public User get(String name, String password) {
		return userDAO.getByNameAndPassword(name,password);
	}

	//@Cacheable(key="'users-page-'+#p0+ '-' + #p1")
	public Page<User> list(int start, int size) {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = PageRequest.of(start, size, sort);
		return userDAO.findAll(pageable);
	}

	//@CacheEvict(allEntries=true)
	public void add(User user) {
		userDAO.save(user);
	}	

}


