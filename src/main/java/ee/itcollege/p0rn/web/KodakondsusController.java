package ee.itcollege.p0rn.web;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import ee.itcollege.p0rn.entities.Kodakondsus;
import ee.itcollege.p0rn.entities.Piiririkkuja;
import ee.itcollege.p0rn.entities.Riik;


import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RooWebScaffold(path = "kodakondsuses", formBackingObject = Kodakondsus.class)
@RequestMapping("/kodakondsuses")
@Controller
public class KodakondsusController {
	@RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(@RequestParam(required = false) Long piiririkkuja_ID, Model uiModel) {
		Kodakondsus model = new Kodakondsus();
		model.setPiiririkkuja_ID(Piiririkkuja.findPiiririkkuja(piiririkkuja_ID));
        uiModel.addAttribute("kodakondsus", model);
        addDateTimeFormatPatterns(uiModel);
        return "kodakondsuses/create";
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Kodakondsus kodakondsus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
       if (bindingResult.hasErrors()) {
            uiModel.addAttribute("kodakondsus", kodakondsus);
            addDateTimeFormatPatterns(uiModel);
            return "kodakondsuses/create";
        }
        uiModel.asMap().clear();
        kodakondsus.persist();
        return "redirect:/piiririkkujas/" + kodakondsus.getPiiririkkuja_ID().getPiiririkkuja_ID() + "?form";
    }
	
	@RequestMapping(value = "/{kodakondsus_ID}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("kodakondsus_ID") Long kodakondsus_ID, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
		Kodakondsus.findKodakondsus(kodakondsus_ID).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/kodakondsuses";
	}
	
	@RequestMapping(value = "/{kodakondsus_ID}", params = "delete", method = RequestMethod.GET)
    public String delete(@PathVariable("kodakondsus_ID") Long kodakondsus_ID, Model uiModel) {
        Kodakondsus model = Kodakondsus.findKodakondsus(kodakondsus_ID);
        if (model!=null) {
        	model.remove();
        	uiModel.asMap().clear();
        	return "redirect:/piiririkkujas/" + model.getPiiririkkuja_ID().getPiiririkkuja_ID() + "?form";
        } else {
        	uiModel.asMap().clear();
        	return "redirect:/piiririkkujas";
        }
    }
	
    void addDateTimeFormatPatterns(Model uiModel) {
    	String datetimeformat = "yyyy-dd-MM";
        uiModel.addAttribute("kodakondsus_avatud_date_format", datetimeformat);
        uiModel.addAttribute("kodakondsus_muudetud_date_format", datetimeformat);
        uiModel.addAttribute("kodakondsus_suletud_date_format", datetimeformat);
        uiModel.addAttribute("kodakondsus_alates_date_format", datetimeformat);
        uiModel.addAttribute("kodakondsus_kuni_date_format", datetimeformat);
    }
}
