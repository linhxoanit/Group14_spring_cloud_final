package com.hellokoding.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hellokoding.springboot.connect.GetContent;

@Controller 
public class EditControler {
	@RequestMapping("/edit")
    public String welcome(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	
    	GetContent get = new GetContent();
    	String noidung = get.getNoiDung();
        model.addAttribute("text",noidung);
        return "edit";
    }
	@RequestMapping(value ="/upload")
    @ResponseBody 
    public String uploadck(Model model,@RequestParam("noidung") String noidung) {
		GetContent set = new GetContent();
    	set.CapNhat(noidung);
    	return "Saved";
        
    }
	
}
