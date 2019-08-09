package yongs.temp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yongs.temp.service.MainService;
import yongs.temp.vo.Main;
import yongs.temp.vo.User;

@RestController
@RequestMapping("/main")
public class MainController {
	private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    MainService service;
    
    @GetMapping("")
    public Main getMain() throws Exception{
    	logger.debug("yongs-main|MainController|getMain()");
    	
    	Main main = new Main();
    	main.setUsers(service.getUsers());
    	main.setProducts(service.getProducts());
    	main.setEvnets(service.getEvents());
    	
    	return main;
    }
    
    @GetMapping("/users")
    public List<User> getUsers() throws Exception{
    	logger.debug("yongs-main|MainController|getUsers()");
    	
    	return service.getUsers();
    }
}