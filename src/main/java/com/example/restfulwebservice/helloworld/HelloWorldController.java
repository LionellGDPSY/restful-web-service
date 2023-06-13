package com.example.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
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
        return new HelloWorldBean(String.format("Hello World, %s" , name));

    }
}
