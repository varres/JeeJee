package ee.itcollege.p0rn.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.p0rn.entities.Kodakondsus;
import ee.itcollege.p0rn.entities.Seadus;
import ee.itcollege.p0rn.entities.SeadusePunkt;

@RequestMapping("/ajalugu/**")
@Controller
public class AjaluguController {

    @RequestMapping
    public void get(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    void addDateTimeFormatPatterns(Model uiModel) {
    	String datetimeformat = "yyyy-dd-MM";
        uiModel.addAttribute("seadus_kehtiv_alates_date_format", datetimeformat);
        uiModel.addAttribute("seadus_kehtiv_kuni_date_format", datetimeformat);
    }

    @RequestMapping
    public String index(@RequestParam(value = "seaduse_ID", required = false) Long seaduse_ID, @RequestParam(value = "alates", required = false) String alates, @RequestParam(value = "kuni", required = false) String kuni, Model uiModel) {
    	Kodakondsus.importFUCK();
    	if (seaduse_ID == null) {
        	seaduse_ID = (long) 0;
        }
        if (alates == null) {
        	alates = "";
        }
        if (kuni == null) {
        	kuni = "";
        }
    	uiModel.addAttribute("seadusepunkts", SeadusePunkt.findAllSeadusePunkts(seaduse_ID, alates, kuni));
        uiModel.addAttribute("seaduses", Seadus.findAllSeaduses());
        uiModel.addAttribute("seadus", new Seadus());
        uiModel.addAttribute("alates", alates);
        uiModel.addAttribute("kuni", kuni);
        uiModel.addAttribute("seaduse_ID", seaduse_ID);
        addDateTimeFormatPatterns(uiModel);
        return "ajalugu/index";
    }
}
