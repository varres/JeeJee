// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.p0rn.web;

import ee.itcollege.p0rn.entities.Riik;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect RiikController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String RiikController.create(@Valid Riik riik, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("riik", riik);
            addDateTimeFormatPatterns(uiModel);
            return "riiks/create";
        }
        uiModel.asMap().clear();
        riik.persist();
        return "redirect:/riiks/" + encodeUrlPathSegment(riik.getRiik_ID().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String RiikController.createForm(Model uiModel) {
        uiModel.addAttribute("riik", new Riik());
        addDateTimeFormatPatterns(uiModel);
        return "riiks/create";
    }
    
    @RequestMapping(value = "/{riik_ID}", method = RequestMethod.GET)
    public String RiikController.show(@PathVariable("riik_ID") Long riik_ID, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("riik", Riik.findRiik(riik_ID));
        uiModel.addAttribute("itemId", riik_ID);
        return "riiks/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String RiikController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("riiks", Riik.findRiikEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Riik.countRiiks() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("riiks", Riik.findAllRiiks());
        }
        addDateTimeFormatPatterns(uiModel);
        return "riiks/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String RiikController.update(@Valid Riik riik, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("riik", riik);
            addDateTimeFormatPatterns(uiModel);
            return "riiks/update";
        }
        uiModel.asMap().clear();
        riik.merge();
        return "redirect:/riiks/" + encodeUrlPathSegment(riik.getRiik_ID().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{riik_ID}", params = "form", method = RequestMethod.GET)
    public String RiikController.updateForm(@PathVariable("riik_ID") Long riik_ID, Model uiModel) {
        uiModel.addAttribute("riik", Riik.findRiik(riik_ID));
        addDateTimeFormatPatterns(uiModel);
        return "riiks/update";
    }
    
    @RequestMapping(value = "/{riik_ID}", method = RequestMethod.DELETE)
    public String RiikController.delete(@PathVariable("riik_ID") Long riik_ID, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Riik.findRiik(riik_ID).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/riiks";
    }
    
    @ModelAttribute("riiks")
    public Collection<Riik> RiikController.populateRiiks() {
        return Riik.findAllRiiks();
    }
    
    void RiikController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("riik_suletud_date_format", "dd.MM.yyyy");
        uiModel.addAttribute("riik_avatud_date_format", "dd.MM.yyyy");
        uiModel.addAttribute("riik_muudetud_date_format", "dd.MM.yyyy");
    }
    
    String RiikController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
