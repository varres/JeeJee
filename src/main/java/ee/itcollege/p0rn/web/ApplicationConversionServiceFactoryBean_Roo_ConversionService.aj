// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.p0rn.web;

import ee.itcollege.p0rn.entities.Kodakondsus;
import ee.itcollege.p0rn.entities.Piiririkkuja;
import ee.itcollege.p0rn.entities.Riik;
import ee.itcollege.p0rn.entities.Seadus;
import ee.itcollege.p0rn.entities.SeadusePunkt;
import java.lang.String;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(new KodakondsusConverter());
        registry.addConverter(new PiiririkkujaConverter());
        registry.addConverter(new RiikConverter());
        registry.addConverter(new SeadusConverter());
        registry.addConverter(new SeadusePunktConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
    static class ee.itcollege.p0rn.web.ApplicationConversionServiceFactoryBean.KodakondsusConverter implements Converter<Kodakondsus, String> {
        public String convert(Kodakondsus kodakondsus) {
            return new StringBuilder().append(kodakondsus.getAvaja()).append(" ").append(kodakondsus.getAvatud()).append(" ").append(kodakondsus.getMuutja()).append(" ").append(kodakondsus.getMuudetud()).toString();
        }
        
    }
    
    static class ee.itcollege.p0rn.web.ApplicationConversionServiceFactoryBean.PiiririkkujaConverter implements Converter<Piiririkkuja, String> {
        public String convert(Piiririkkuja piiririkkuja) {
            return new StringBuilder().append(piiririkkuja.getAvaja()).append(" ").append(piiririkkuja.getAvatud()).append(" ").append(piiririkkuja.getMuutja()).append(" ").append(piiririkkuja.getMuudetud()).toString();
        }
        
    }
    
    static class ee.itcollege.p0rn.web.ApplicationConversionServiceFactoryBean.RiikConverter implements Converter<Riik, String> {
        public String convert(Riik riik) {
            return new StringBuilder().append(riik.getISO_kood()).append(" ").append(riik.getANSI_kood()).append(" ").append(riik.getKommentaar()).append(" ").append(riik.getAvaja()).toString();
        }
        
    }
    
    static class ee.itcollege.p0rn.web.ApplicationConversionServiceFactoryBean.SeadusConverter implements Converter<Seadus, String> {
        public String convert(Seadus seadus) {
            return new StringBuilder().append(seadus.getSulgeja()).append(" ").append(seadus.getSuletud()).append(" ").append(seadus.getKood()).append(" ").append(seadus.getNimetus()).toString();
        }
        
    }
    
    static class ee.itcollege.p0rn.web.ApplicationConversionServiceFactoryBean.SeadusePunktConverter implements Converter<SeadusePunkt, String> {
        public String convert(SeadusePunkt seadusePunkt) {
            return new StringBuilder().append(seadusePunkt.getSeaduse_punkt_ID()).append(" ").append(seadusePunkt.getParagrahv()).append(" ").append(seadusePunkt.getPais()).append(" ").append(seadusePunkt.getTekst()).toString();
        }
        
    }
    
}