package ee.itcollege.p0rn.entities;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;
import javax.persistence.PersistenceContext;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

@MappedSuperclass
@RooToString
@RooEntity(mappedSuperclass = true)
public abstract class Base {
	
	public Base() {
		setCreated();
	}
	
    @NotNull
    @Size(min=0)
    private String kommentaar;
    
    public String getKommentaar() {
    	return kommentaar;
    }

    public void setKommentaar(String kommentaar) {
    	this.kommentaar = kommentaar;
    }

	@NotNull
    @Column(updatable=false)
    private String avaja;

    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(updatable=false)
    private Date avatud;
    
    @NotNull
    private String muutja;
  

    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date muudetud;


    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(updatable=false)
    private String sulgeja;
   
    @NotNull
    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date suletud;
    
    public String getSulgeja() {
		return sulgeja;
	}

	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

    
    public Date getSuletud() {
        return this.suletud;
    }
    
    public void setSuletud(Date suletud) {
        this.suletud = suletud;
    }
    
    public Date getAvatud() {
        return this.avatud;
    }
    
    public void setAvatud(Date avatud) {
        this.suletud = avatud;
    }
    
    public Date getMuudetud() {
        return this.muudetud;
    }
    
    public void setMuudetud(Date muudetud) {
        this.muudetud = muudetud;
    }
    
    public String getMuutja() {
        return this.muutja;
    }
    
    public void setMuutja(String muudetud) {
        this.muutja = muudetud;
    }
    
    public String getAvaja() {
        return this.avaja;
    }
    
    public void setAvaja(String avaja) {
        this.avaja = avaja;
    }

	@PrePersist
	public void setCreated() {
		Calendar tempDate = Calendar.getInstance();
		tempDate.clear();
		tempDate.set(Calendar.YEAR, 9999);
		tempDate.set(Calendar.MONTH, Calendar.DECEMBER);
		tempDate.set(Calendar.DAY_OF_MONTH, 31);
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
	   		avaja = (String) SecurityContextHolder.getContext().getAuthentication().getName();
	   		muutja = (String) SecurityContextHolder.getContext().getAuthentication().getName();
	   		sulgeja = "";
		} else {
		   	avaja = "unknown";
		   	muutja = "unknown";
		   	sulgeja = "unknown";
		}
	    avatud = new Date();
	    muudetud = new Date();
	    this.suletud = tempDate.getTime();
	}
	
	@PostPersist
	protected void afterCreate() {
		
	}

   @PreUpdate
   protected void onUpdate() {  
	   avaja = "värdjas";
	   avatud = new Date();
	   
	   muutja = (String) SecurityContextHolder.getContext().getAuthentication().getName();
	   muudetud = new Date();
   }
   
   
   abstract String getTableName();
   abstract String getIdName();
   abstract Long getId();
   
   @Transactional
   public void remove() {
       if (this.entityManager == null) this.entityManager = entityManager();
       setSulgeja((String) SecurityContextHolder.getContext().getAuthentication().getName());
       this.entityManager.createQuery("UPDATE "+getTableName()+" SET suletud = CURDATE(), sulgeja = '" + getSulgeja() + "' WHERE "+getIdName()+" = " + this.getId()).executeUpdate();
   }
   
   @PersistenceContext
   transient EntityManager entityManager;
   
   public static EntityManager entityManager() {
       EntityManager em = new SeadusePunkt().entityManager;
       if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
       return em;
   }
}