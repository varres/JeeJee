package ee.itcollege.p0rn.web;

import ee.itcollege.p0rn.entities.Seadus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "seaduses", formBackingObject = Seadus.class)
@RequestMapping("/seaduses")
@Controller
public class SeadusController {
}
