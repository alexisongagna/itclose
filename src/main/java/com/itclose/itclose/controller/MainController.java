package com.itclose.itclose.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
  @ResponseBody
  @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/api/refdata/documents'>Get all documents</a></li>";
        html += " <li><a href='/api/refdata/filter/*:*'>Get all documents by filters</a></li>";
        html += "</ul>";
        return html;
    }
}
