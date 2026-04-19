package khayah.rest_with_spring_boot_and_java.controllers;

import khayah.rest_with_spring_boot_and_java.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %S!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    //http://localhost:8080/greeting?name=jay
    // sem o ?name=jay ele retorna word que é o valor default
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Word") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
}
