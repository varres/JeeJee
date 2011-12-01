package ee.itcollege.p0rn.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import ee.itcollege.p0rn.entities.Piiririkkuja;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
public class Kodakondsus {
    @PersistenceContext
    transient EntityManager entityManager;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long kodakondsus_ID;
	
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

    private String kommentaar;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date alates;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date kuni;

    @ManyToOne
    private Riik riik_ID;

    @Size(max = 20)
    private String isikukood;

    @ManyToOne
    private Piiririkkuja piiririkkuja_ID;
    
    public static final EntityManager entityManager() {
        EntityManager em = new Kodakondsus().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static List<Kodakondsus> findAllByPiiririkkuja(long id) {
        return entityManager().createQuery("SELECT o FROM Kodakondsus o WHERE suletud > CURDATE() AND piiririkkuja_ID = " + id, Kodakondsus.class).getResultList();
    }
    
    @Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        sulgeja = (String) SecurityContextHolder.getContext().getAuthentication().getName();
        this.entityManager.createQuery("UPDATE Kodakondsus o SET suletud = CURDATE() WHERE kodakondsus_ID = " + this.kodakondsus_ID + " AND sulgeja = '" + sulgeja + "'").executeUpdate();
    }
    
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
        // Dummy data
        sulgeja = "";
        try {
     	   SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
     	   suletud = (Date)format.parse("2099/12/31");
        } catch (ParseException e) {
     	   e.printStackTrace();
        }
    }
    
    public static void importFUCK() {
    	if (Riik.countRiiks() < 1) {
	    	Riik a = new Riik();
	    	a.setISO_kood("EE");
	    	a.setANSI_kood("EST");
	    	a.setKommentaar("");
	    	a.persist();
	    	Riik b = new Riik();
	    	b.setISO_kood("EN");
	    	b.setANSI_kood("ENG");
	    	b.setKommentaar("");
	    	b.persist();
	    	Riik c = new Riik();
	    	c.setISO_kood("DE");
	    	c.setANSI_kood("DEU");
	    	c.setKommentaar("");
	    	c.persist();
	    	
	    	Piiririkkuja d = new Piiririkkuja();
	    	d.setEesnimi("Jaan");
	    	d.setPerek_nimi("Kuusk");
	    	d.setIsikukood("4000");
	    	d.setKommentaar("");
	    	d.setSynniaeg(new Date());
	    	d.persist();
	    	
	    	Kodakondsus e = new Kodakondsus();
	    	e.setIsikukood("1001");
	    	e.setAlates(new Date());
	    	e.setKuni(new Date());
	    	e.setKommentaar("");
	    	e.setPiiririkkuja_ID(d);
	    	e.setRiik_ID(a);
	    	e.persist();
	    	
	    	Kodakondsus f = new Kodakondsus();
	    	f.setIsikukood("1001");
	    	f.setAlates(new Date());
	    	f.setKuni(new Date());
	    	f.setKommentaar("");
	    	f.setPiiririkkuja_ID(d);
	    	f.setRiik_ID(b);
	    	f.persist();
	    	
	    	Kodakondsus g = new Kodakondsus();
	    	g.setIsikukood("1001");
	    	g.setAlates(new Date());
	    	g.setKuni(new Date());
	    	g.setKommentaar("");
	    	g.setPiiririkkuja_ID(d);
	    	g.setRiik_ID(c);
	    	g.persist();
    	}
    }
}
