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
            return "riiks/create";
        }
        uiModel.asMap().clear();
        riik.persist();
        return "redirect:/riiks/" + encodeUrlPathSegment(riik.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String RiikController.createForm(Model uiModel) {
        uiModel.addAttribute("riik", new Riik());
        return "riiks/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String RiikController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("riik", Riik.findRiik(id));
        uiModel.addAttribute("itemId", id);
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
        return "riiks/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String RiikController.update(@Valid Riik riik, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("riik", riik);
            return "riiks/update";
        }
        uiModel.asMap().clear();
        riik.merge();
        return "redirect:/riiks/" + encodeUrlPathSegment(riik.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String RiikController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("riik", Riik.findRiik(id));
        return "riiks/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String RiikController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Riik.findRiik(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/riiks";
    }
    
    @ModelAttribute("riiks")
    public Collection<Riik> RiikController.populateRiiks() {
        return Riik.findAllRiiks();
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
