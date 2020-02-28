package org.LaunchCode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    // responds to /hello?name=
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model){

        //variable name needs to match up with variable name referenced in template
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);

        return "hello";
    }

    // responds to /hello/name
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){

        //can use the same template for same view
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);

        return "hello";
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

    // using to test iteration template hello-list
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("E");
        names.add("MC2");
        names.add("Ram");
        names.add("Ted");

        // first argument is variable template will see
        // second is value that variable should have
        model.addAttribute("names", names);

        return "hello-list";
    }
}
