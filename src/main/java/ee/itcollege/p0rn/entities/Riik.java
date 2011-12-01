package ee.itcollege.p0rn.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooEntity
public class Riik {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long riik_ID;

    @NotNull
    @Size(max = 20)
    private String ISO_kood;

    @NotNull
    @Size(max = 20)
    private String ANSI_kood;

    @NotNull
    private String kommentaar;

    @NotNull
    @Size(max = 32)
    private String avaja;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date avatud;

    @NotNull
    @Size(max = 32)
    private String muutja;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date muudetud;

    @NotNull
    @Size(max = 32)
    private String sulgeja;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date suletud;
    
    @PrePersist
    protected void onCreate() {
    	if (SecurityContextHolder.getContext().getAuthentication() != null) {
    		avaja = (String) SecurityContextHolder.getContext().getAuthentication().getName();
    		muutja = (String) SecurityContextHolder.getContext().getAuthentication().getName();
    	} else {
    		avaja = "unknown";
    		muutja = "unknown";
    	}
        avatud = new Date();
        muudetud = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    	 sulgeja = "";
    	 try {
 			suletud = (Date)format.parse("2099/12/31");
 		 } catch (ParseException e) {
 			e.printStackTrace();
 		 }
    }
}
