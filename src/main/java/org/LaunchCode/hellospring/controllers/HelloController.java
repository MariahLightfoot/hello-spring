package org.LaunchCode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles requests at path /hello
    // Commented out because it was interfering. Too many requests going to path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }
//
//     Handles requests of the form /hello?name=LaunchCode
//     Commented out due to interference in paths
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='response' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option>English</option>" +
                "<option>Spanish</option>" +
                "<option>French</option>" +
                "<option>Russian</option>" +
                "<option>German</option>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "response")
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
