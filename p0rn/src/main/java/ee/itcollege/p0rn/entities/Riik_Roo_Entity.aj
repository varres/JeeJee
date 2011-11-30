// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.p0rn.entities;

import ee.itcollege.p0rn.entities.Riik;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Riik_Roo_Entity {
    
    declare @type: Riik: @Entity;
    
    @PersistenceContext
    transient EntityManager Riik.entityManager;
    
    @Version
    @Column(name = "version")
    private Integer Riik.version;
    
    public Integer Riik.getVersion() {
        return this.version;
    }
    
    public void Riik.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Riik.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Riik.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Riik attached = Riik.findRiik(this.riik_ID);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Riik.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Riik.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Riik Riik.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Riik merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Riik.entityManager() {
        EntityManager em = new Riik().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Riik.countRiiks() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Riik o", Long.class).getSingleResult();
    }
    
    public static List<Riik> Riik.findAllRiiks() {
        return entityManager().createQuery("SELECT o FROM Riik o", Riik.class).getResultList();
    }
    
    public static Riik Riik.findRiik(Long riik_ID) {
        if (riik_ID == null) return null;
        return entityManager().find(Riik.class, riik_ID);
    }
    
    public static List<Riik> Riik.findRiikEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Riik o", Riik.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
