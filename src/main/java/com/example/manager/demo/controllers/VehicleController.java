package com.example.manager.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class VehicleController {
    @GetMapping("/vehicle")
    public String getVehicles(){
        return "vehicle";
    }
}
