	

package com.tmall.controller;
import com.tmall.pojo.User;
import com.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
public class UserController {
	@Autowired
    UserService userService;

    @GetMapping("/users")
    public Page<User> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
    	start = start<0?0:start;
    	Page<User> page = userService.list(start,size);
        return page;
    }
	    

        
}



