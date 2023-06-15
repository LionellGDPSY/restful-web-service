package com.example.restfulwebservice.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    //Get
    //hello-world(endpoint)
    //RequestMapping(method=RequestMethod.GET, path="/hello-world")
    @GetMapping("/hello-world")
    public String helloWorld() {

        return "Hello World";

    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {

        //alt + Enter
        return new HelloWorldBean("Hello World");

    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {

        //alt + Enter
        return new HelloWorldBean("Hello World, " + name);

    }

    @GetMapping("/hello-world-bean/path-variable1/{name}")
    public HelloWorldBean helloWorldBean1(@PathVariable String name) {

        //alt + Enter
        return new HelloWorldBean(String.format("Hello World, %s", name));

    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale){

        return messageSource.getMessage("greeting.message", null, locale);
    }
}
