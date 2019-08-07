package yongs.temp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import yongs.temp.vo.Event;
import yongs.temp.vo.Product;
import yongs.temp.vo.User;

@Service
public class MainService {
    private static final Logger logger = LoggerFactory.getLogger(MainService.class);
    
    /* Target URL */
	private static String USER_URL = "http://yongs-user/users";
	private static String PRODUCT_URL = "http://yongs-product/products";
	private static String EVENT_URL = "http://yongs-event/events";
	
    @Autowired
	private RestTemplate restTemplate;
   
    public List<User> getUsers() throws Exception{
    	logger.debug("yongs-main|MainService|getUsers()");
    	ResponseEntity<List<User>> response =  restTemplate.exchange(
    			USER_URL,
        		HttpMethod.GET,
        		null,
        		new ParameterizedTypeReference<List<User>>() {});
        
        return response.getBody(); 	
    }
 
    public List<Product> getProducts() throws Exception{
    	logger.debug("yongs-main|MainService|getProducts()");
    	ResponseEntity<List<Product>> response =  restTemplate.exchange(
    			PRODUCT_URL,
        		HttpMethod.GET,
        		null,
        		new ParameterizedTypeReference<List<Product>>() {});
        
        return response.getBody(); 	
    }
    
    @HystrixCommand(commandKey = "events", fallbackMethod = "getEventsFallback")
    public List<Event> getEvents() throws Exception{
    	logger.debug("yongs-main|MainService|getEvents()");
    	ResponseEntity<List<Event>> response =  restTemplate.exchange(
    			EVENT_URL,
        		HttpMethod.GET,
        		null,
        		new ParameterizedTypeReference<List<Event>>() {});
        
        return response.getBody(); 	
    }

    private List<Event> getEventsFallback() {
    	logger.debug("yongs-main|MainService|getEventsFallback()");
    	List<Event> result = new ArrayList<Event>();
    	
    	/* Event 서비스 장애시 보여줄 임시 데이터 생성 */
    	Event event1 = new Event();
    	event1.setNo("10001");
    	event1.setName("Summer Special");
    	
    	Event event2 = new Event();
    	event2.setNo("10002");
    	event2.setName("Home Special");
    	
    	Event event3 = new Event();
    	event3.setNo("10003");
    	event3.setName("Food Special");
    	
    	result.add(event1);
    	result.add(event2);
    	result.add(event3);
    	
    	return result;
    }
}