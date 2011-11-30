package ee.itcollege.p0rn.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
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
        return entityManager().createQuery("SELECT o FROM Kodakondsus o WHERE piiririkkuja_ID = " + id, Kodakondsus.class).getResultList();
    }
}
