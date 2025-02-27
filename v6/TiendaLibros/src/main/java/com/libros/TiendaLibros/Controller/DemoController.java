package com.libros.TiendaLibros.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @PostMapping(value= "demo")
    public String welcome(){
        return "Pagina demo";
    }

}
