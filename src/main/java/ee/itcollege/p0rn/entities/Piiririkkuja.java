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
public class Piiririkkuja extends Base {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long piiririkkuja_ID;

	public Long getId() {
		return piiririkkuja_ID;
	}

    @Size(max = 20)
    private String isikukood;

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

	@Override
	public String getTableName() {
		return "Piiririkkuja";
	}

	@Override
	public String getIdName() {
		return "piiririkkuja_ID";
	}
}
