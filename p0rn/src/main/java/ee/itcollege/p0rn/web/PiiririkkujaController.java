package ee.itcollege.p0rn.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.itcollege.p0rn.entities.Piiririkkuja;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RooWebScaffold(path = "piiririkkujas", formBackingObject = Piiririkkuja.class)
@RequestMapping("/piiririkkujas")
@Controller
public class PiiririkkujaController {
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel) {


        uiModel.addAttribute("piiririkkuja", new Piiririkkuja());
        uiModel.addAttribute("genders", getGenders());

        addDateTimeFormatPatterns(uiModel);
        return "piiririkkujas/create";
    } 
    
    private List<String> getGenders() {
    	List<String> genders = new ArrayList<String>();
    	genders.add("M");
    	genders.add("N");
    	return genders;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Piiririkkuja piiririkkuja, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	piiririkkuja.setDefaultValues();
    	/*
    	if (bindingResult.hasErrors()) {
    		System.out.println(bindingResult.getAllErrors().toString());
            uiModel.addAttribute("piiririkkuja", piiririkkuja);
            uiModel.addAttribute("genders", getGenders());
            addDateTimeFormatPatterns(uiModel);
            return "piiririkkujas/create";
        }
        */
        uiModel.asMap().clear();
        piiririkkuja.persist();
        return "redirect:/piiririkkujas/" + encodeUrlPathSegment(piiririkkuja.getId().toString(), httpServletRequest);
    }
}

