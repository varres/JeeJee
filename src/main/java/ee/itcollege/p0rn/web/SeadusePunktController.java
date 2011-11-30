package ee.itcollege.p0rn.web;

import javax.servlet.http.HttpServletRequest;

import ee.itcollege.p0rn.entities.SeadusePunkt;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "seadusepunkts", formBackingObject = SeadusePunkt.class)
@RequestMapping("/seadusepunkts")
@Controller
public class SeadusePunktController {
    @RequestMapping(method = RequestMethod.POST)
    public String create(SeadusePunkt seadusepunkt, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
//        seadus.setSulgeja("");
//        seadus.setSuletud(new Date());
        

    	/* if (bindingResult.hasErrors()) {
            uiModel.addAttribute("seadus", seadus);
            addDateTimeFormatPatterns(uiModel);
            return "seaduses/update";
        }*/
        uiModel.asMap().clear();
        seadusepunkt.merge();
        try {
        	return "redirect:/seaduses/" + encodeUrlPathSegment(seadusepunkt.getSeaduse_ID().getId().toString(), httpServletRequest) + "?form";
        } catch (Exception ex) {
        	return "redirect:/seadusepunkts/";
        }
    }
}
