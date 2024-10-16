package gtdani4Proyect.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloWorldestController {

    @GetMapping("/hello")
    public String helloWorld() {
        System.out.println("Hello World escrito en consola");
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String helloPerson(@PathVariable String name) {
        if (isPalindrome(name)) {
            return "Hello " + name + "Tu nombre es un palíndromo";
        } else {
            return "Hello " + name + " Tu nombre es un palíndromo";
        }
    }



    private boolean isPalindrome(String name) {
        name = name.toLowerCase();  
        int length = name.length();

        for (int i = 0; i < length / 2; i++) {
            if (name.charAt(i) != name.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
