package ee.itcollege.p0rn.web;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.itcollege.p0rn.entities.Riik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "riiks", formBackingObject = Riik.class)
@RequestMapping("/riiks")
@Controller
public class RiikController {

}
