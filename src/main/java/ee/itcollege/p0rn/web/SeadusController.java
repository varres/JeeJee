package ee.itcollege.p0rn.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import ee.itcollege.p0rn.entities.Kodakondsus;
import ee.itcollege.p0rn.entities.Piiririkkuja;
import ee.itcollege.p0rn.entities.Seadus;
import ee.itcollege.p0rn.entities.SeadusePunkt;

import javax.validation.Valid;

import ee.itcollege.p0rn.entities.Seadus;

import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RooWebScaffold(path = "seaduses", formBackingObject = Seadus.class)
@RequestMapping("/seaduses")
@Controller
public class SeadusController {
	
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Seadus seadus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	/* if (bindingResult.hasErrors()) {
    		System.out.println(bindingResult.getAllErrors().toString());
            uiModel.addAttribute("seadus", seadus);
            addDateTimeFormatPatterns(uiModel);
            return "seaduses/create";
        }
        */
        uiModel.asMap().clear();
        seadus.persist();
        return "redirect:/seaduses/" + encodeUrlPathSegment(seadus.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(Seadus seadus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	/* if (bindingResult.hasErrors()) {
            uiModel.addAttribute("seadus", seadus);
            addDateTimeFormatPatterns(uiModel);
            return "seaduses/update";
        }*/
        uiModel.asMap().clear();
        seadus.merge();
        return "redirect:/seaduses/" + encodeUrlPathSegment(seadus.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{seaduse_ID}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("seaduse_ID") Long seaduse_ID, Model uiModel) {
        uiModel.addAttribute("seadusepunkts", SeadusePunkt.findAllSeadusePunkts(seaduse_ID, "", ""));
        uiModel.addAttribute("seadus", Seadus.findSeadus(seaduse_ID));
        uiModel.addAttribute("seadusePunkt", new SeadusePunkt());

        addDateTimeFormatPatterns(uiModel);
        return "seaduses/update";
    }
}
