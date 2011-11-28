package ee.itcollege.p0rn.web;

import ee.itcollege.p0rn.entities.Riik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "riiks", formBackingObject = Riik.class)
@RequestMapping("/riiks")
@Controller
public class RiikController {
}
