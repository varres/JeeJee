package ee.itcollege.p0rn.entities;

import org.joda.time.DateTime;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.print.attribute.standard.DateTimeAtCreation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooEntity
public class Seadus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long seaduse_ID;
	
	public Long getId() {
		return seaduse_ID;
	}
	
    @NotNull
    @Size(max = 20)
    private String kood;

	@NotNull
    @Size(max = 20)
    private String nimetus;

    @NotNull
    @Size(max = 20)
    private String kehtiv_alates;

    @NotNull
    @Size(max = 20)
    private String kehtiv_kuni;

    @NotNull
    @Size(max = 20)
    private String kommentaar;

    @NotNull
    @Size(max = 32)
    @Column(updatable=false)
    private String avaja;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Column(updatable=false)
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
   
    public String getSulgeja() {
		return sulgeja;
	}

	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date suletud;
    
    public Date getSuletud() {
		return suletud;
	}

	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}
    /*
	public void setDefaultValues() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        avaja = "";
        muutja = "";
        sulgeja = "";
        try {
        	suletud = (Date)format.parse("2099/12/31");
        } catch (ParseException e) {
        	e.printStackTrace();
        }
        avatud = new Date();
        muudetud = new Date();
        seaduse_ID = (long) 0;
   } */
    
   @PrePersist
   protected void onCreate() {
       avaja = (String) SecurityContextHolder.getContext().getAuthentication().getName();
       avatud = new Date();
       muutja = (String) SecurityContextHolder.getContext().getAuthentication().getName();
       muudetud = new Date();
       // Dummy data
       sulgeja = "";
       try {
    	   SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    	   suletud = (Date)format.parse("2099/12/31");
       } catch (ParseException e) {
    	   e.printStackTrace();
       }
   }

   @PreUpdate
   protected void onUpdate() {  
     avaja = "värdjas";
     avatud = new Date();
	   
	 muutja = (String) SecurityContextHolder.getContext().getAuthentication().getName();
     muudetud = new Date();
     
     // Dummy data
     sulgeja = "";
     try {
  	   SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
  	   suletud = (Date)format.parse("2099/12/31");
     } catch (ParseException e) {
  	   e.printStackTrace();
     }
   }
}
