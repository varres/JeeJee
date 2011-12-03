// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.p0rn.web;

import ee.itcollege.p0rn.entities.Piiririkkuja;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect PiiririkkujaController_Roo_Controller {
    
    @RequestMapping(value = "/{piiririkkuja_ID}", method = RequestMethod.GET)
    public String PiiririkkujaController.show(@PathVariable("piiririkkuja_ID") Long piiririkkuja_ID, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("piiririkkuja", Piiririkkuja.findPiiririkkuja(piiririkkuja_ID));
        uiModel.addAttribute("itemId", piiririkkuja_ID);
        return "piiririkkujas/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String PiiririkkujaController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("piiririkkujas", Piiririkkuja.findPiiririkkujaEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Piiririkkuja.countPiiririkkujas() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("piiririkkujas", Piiririkkuja.findAllPiiririkkujas());
        }
        addDateTimeFormatPatterns(uiModel);
        return "piiririkkujas/list";
    }
    
    @RequestMapping(value = "/{piiririkkuja_ID}", method = RequestMethod.DELETE)
    public String PiiririkkujaController.delete(@PathVariable("piiririkkuja_ID") Long piiririkkuja_ID, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Piiririkkuja.findPiiririkkuja(piiririkkuja_ID).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/piiririkkujas";
    }
    
    @ModelAttribute("piiririkkujas")
    public Collection<Piiririkkuja> PiiririkkujaController.populatePiiririkkujas() {
        return Piiririkkuja.findAllPiiririkkujas();
    }
    
    String PiiririkkujaController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
