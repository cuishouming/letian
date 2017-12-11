package org.tensoft.gaoxiao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/adx")
public class IndexController {

	@RequestMapping(value = "/{f}/{v}/{id}",method = RequestMethod.GET)
    public String doHome(HttpServletRequest request, @PathVariable String f, @PathVariable String v, @PathVariable String id, Model model) {
        model.addAttribute("id", id);
        return f + "/" + v;
    }
	
	@RequestMapping(value = "/{f}/{v}" ,method = RequestMethod.GET)
    public String dHome(HttpServletRequest request, @PathVariable String f, @PathVariable String v) {
        return f + "/" + v;
    }
}
