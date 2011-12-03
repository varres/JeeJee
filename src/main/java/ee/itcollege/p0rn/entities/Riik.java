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
public class Riik extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long riik_ID;

    @NotNull
    @Size(max = 20)
    private String ISO_kood;

    @NotNull
    @Size(max = 20)
    private String ANSI_kood;

	@Override
	public String getTableName() {
		return "Riik";
	}

	@Override
	public String getIdName() {
		return "riik_ID";
	}

	@Override
	public Long getId() {
		return riik_ID;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ISO_kood: ").append(getISO_kood());
        return sb.toString();
    }
}
