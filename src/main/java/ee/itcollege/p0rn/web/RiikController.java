package ee.itcollege.p0rn.web;


import ee.itcollege.p0rn.entities.Riik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "riiks", formBackingObject = Riik.class)
@RequestMapping("/riiks")
@Controller
public class RiikController {
	
    void addDateTimeFormatPatterns(Model uiModel) {
    	String datetimeformat = "yyyy/dd/MM";
        uiModel.addAttribute("riik_avatud_date_format", datetimeformat);
        uiModel.addAttribute("riik_muudetud_date_format", datetimeformat);
        uiModel.addAttribute("riik_suletud_date_format", datetimeformat);
    }
}
