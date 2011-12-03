package ee.itcollege.p0rn.web;

import javax.servlet.http.HttpServletRequest;

import ee.itcollege.p0rn.entities.Kodakondsus;
import ee.itcollege.p0rn.entities.Piiririkkuja;
import ee.itcollege.p0rn.entities.Seadus;
import ee.itcollege.p0rn.entities.SeadusePunkt;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RooWebScaffold(path = "seadusepunkts", formBackingObject = SeadusePunkt.class)
@RequestMapping("/seadusepunkts")
@Controller
public class SeadusePunktController {
    @RequestMapping(method = RequestMethod.POST)
    public String create(SeadusePunkt seadusepunkt, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
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
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(SeadusePunkt seadusepunkt, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	/* if (bindingResult.hasErrors()) {
            uiModel.addAttribute("seadus", seadus);
            addDateTimeFormatPatterns(uiModel);
            return "seaduses/update";
        }*/
        uiModel.asMap().clear();
        seadusepunkt.merge();
        return "redirect:/seadusepunkts/" + encodeUrlPathSegment(seadusepunkt.getId().toString(), httpServletRequest);
    }
    
	@RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(@RequestParam(required = false) Long seaduse_ID, Model uiModel) {
		SeadusePunkt model = new SeadusePunkt();
		model.setSeaduse_ID(Seadus.findSeadus(seaduse_ID));
		
        uiModel.addAttribute("seadusePunkt", model);
        addDateTimeFormatPatterns(uiModel);
        return "seadusepunkts/create";
    }
	
	@RequestMapping(value = "/{seadusepunkt_ID}", params = "delete", method = RequestMethod.GET)
    public String delete(@PathVariable("seadusepunkt_ID") Long seadusepunkt_ID, Model uiModel) {
        SeadusePunkt model = SeadusePunkt.findSeadusePunkt(seadusepunkt_ID);
        if (model!=null) {
        	model.remove();
        	uiModel.asMap().clear();
        	return "redirect:/seaduses/" + model.getSeaduse_ID().getId().toString() + "?form";
        } else {
        	uiModel.asMap().clear();
        	return "redirect:/seaduses";
        }
    }
	
    void addDateTimeFormatPatterns(Model uiModel) {
    	String datetimeformat = "yyyy/dd/MM";
        uiModel.addAttribute("seadusePunkt_avatud_date_format", datetimeformat);
        uiModel.addAttribute("seadusePunkt_muudetud_date_format", datetimeformat);
        uiModel.addAttribute("seadusePunkt_suletud_date_format", datetimeformat);
    }
}
