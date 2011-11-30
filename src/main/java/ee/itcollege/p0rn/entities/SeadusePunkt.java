package ee.itcollege.p0rn.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import ee.itcollege.p0rn.entities.Seadus;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
public class SeadusePunkt {

    private int seaduse_punkt_ID;

    @NotNull
    @Size(max = 20)
    private String paragrahv;

    @NotNull
    @Size(max = 20)
    private String pais;

    @NotNull
    @Size(max = 20)
    private String tekst;

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

    @ManyToOne
    private Seadus seaduse_ID;

    @ManyToOne
    private ee.itcollege.p0rn.entities.SeadusePunkt ylemus_seaduse_punkt_ID;
    
    @PersistenceContext
    transient EntityManager entityManager;
    
    public static final EntityManager entityManager() {
        EntityManager em = new SeadusePunkt().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static List<SeadusePunkt> findAllSeadusePunkts(long seaduse_ID, String alates, String kuni) {
    	String g = "WHERE 1=1";
    	if (seaduse_ID > 0) {
    		g = g + " AND seaduse_ID = " + seaduse_ID;
    	}
    	if (alates.length() > 0) {
    		g = g + " AND kehtiv_alates >= '" + alates + "')";
    	}
    	if (kuni.length() > 0) {
    		g = g + " AND kehtiv_kuni >= '" + kuni + "'";
    	}
        return entityManager().createQuery("SELECT o FROM SeadusePunkt o " + g, SeadusePunkt.class).getResultList();
    }
}
