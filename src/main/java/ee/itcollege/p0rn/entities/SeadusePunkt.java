package ee.itcollege.p0rn.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
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

    public Seadus getSeaduse_ID() {
		return seaduse_ID;
	}

	@ManyToOne
    private ee.itcollege.p0rn.entities.SeadusePunkt ylemus_seaduse_punkt_ID;
}
