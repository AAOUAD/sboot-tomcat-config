package taa.poc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@RequestMapping(path = {"${context.api}", "${context.latest}", "/"})
public class Controller {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @GetMapping(path = "/public/hello")
    public ResponseEntity publicHello() throws InterruptedException {
        Thread.sleep(10_00);
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8082/find", HttpMethod.GET, null, String.class);
        return ResponseEntity.ok("public hello " + exchange.getBody() + " \n") ;
    }

    @GetMapping(path = "/trap/hello")
    public ResponseEntity trapHello(){
        return ResponseEntity.ok("trap hello \n") ;
    }

    @GetMapping(path = "/sync/hello")
    public ResponseEntity synchroHello(){
        return ResponseEntity.ok("Synchronization hello \n") ;
    }
}
