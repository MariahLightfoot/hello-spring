package org.LaunchCode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    // responds to /hello?name=
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){

        return "Hello, " + name + "!";
    }

    // responds to /hello/name
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){

        return "Hello, " + name + "!";
    }

    // responds to /form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    // posts to /response
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "response")
    @ResponseBody
    public static String createMessage(@RequestParam String name, String language){
        if(language.equals("English")){
            return "Hello, " + name + "!";
        } else if(language.equals("Spanish")){
            return "Hola, " + name + "!";
        } else if(language.equals("French")){
            return "Bonjour, " + name + "!";
        } else if(language.equals("Russian")){
            return "Здравствуйте, " + name + "!";
        } else {
            return "Hallo, " + name + "!";
        }
    }
}
