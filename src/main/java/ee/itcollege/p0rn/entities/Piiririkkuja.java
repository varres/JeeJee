package ee.itcollege.p0rn.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;

@RooJavaBean
@RooToString
@RooEntity
public class Piiririkkuja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long piiririkkuja_ID;

	public Long getId() {
		return piiririkkuja_ID;
	}
	
    @NotNull
    @Size(max = 32)
    @Column(updatable = false)
    private String avaja;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Column(updatable = false)
    private Date avatud;

    @NotNull
    @Size(max = 32)
    private String muutja;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date muudetud;

    @Size(max = 32)
    private String sulgeja;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date suletud;

    @Size(max = 20)
    private String isikukood;

    private String kommentaar;

    @Size(max = 25)
    private String eesnimi;

    @Size(max = 35)
    private String perek_nimi;

    @Size(max = 1)
    private String sugu;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date synniaeg;

    @Column(updatable = false)
    private int objekt_ID;

    public void setDefaultValues() {
    	objekt_ID = 0;
    }

    @PrePersist
    protected void onCreate() {
        avaja = (String) SecurityContextHolder.getContext().getAuthentication().getName();
        avatud = new Date();
        muutja = (String) SecurityContextHolder.getContext().getAuthentication().getName();
        muudetud = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    	 sulgeja = "";
    	 try {
 			suletud = (Date)format.parse("2099/12/31");
 		 } catch (ParseException e) {
 			e.printStackTrace();
 		 }
    }

    @PreUpdate
    protected void onUpdate() {
    	 muutja = (String) SecurityContextHolder.getContext().getAuthentication().getName();
         muudetud = new Date();
         SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
     	 sulgeja = "";
     	 avaja = "";
     	 avatud = new Date();
     	 try {
  			suletud = (Date)format.parse("2099/12/31");
  		 } catch (ParseException e) {
  			e.printStackTrace();
  		 }
    }
}
