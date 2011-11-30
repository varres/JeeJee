package ee.itcollege.p0rn.web;


import java.util.ArrayList;


import ee.itcollege.p0rn.entities.Kodakondsus;
import ee.itcollege.p0rn.entities.Piiririkkuja;


import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
