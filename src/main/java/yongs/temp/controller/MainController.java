package yongs.temp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yongs.temp.db.vo.Main;
import yongs.temp.service.MainService;

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
}