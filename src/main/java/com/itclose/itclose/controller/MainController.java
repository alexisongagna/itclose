package com.itclose.itclose.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@Api( description="API pour les opérations CRUD sur les employés")
public class MainController {

  @ResponseBody
  @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/api/Entreprises'>Liste des entreprises</a></li>";
        html += " <li><a href='/api/CentresHospitaliers'>Liste des centres hospitaliers</a></li>";
        html += " <li><a href='/api/Hotels'>Liste des hotels</a></li>";
        html += " <li><a href='/api/Restaurants'>Liste des restaurants</a></li>";
        html += "</ul>";
        return html;
    }
}
