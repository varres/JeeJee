// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.p0rn.entities;

import java.lang.String;

privileged aspect Seadus_Roo_ToString {
    
    public String Seadus.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("IdName: ").append(getIdName()).append(", ");
        sb.append("Kehtiv_alates: ").append(getKehtiv_alates()).append(", ");
        sb.append("Kehtiv_kuni: ").append(getKehtiv_kuni()).append(", ");
        sb.append("Kommentaar: ").append(getKommentaar()).append(", ");
        sb.append("Kood: ").append(getKood()).append(", ");
        sb.append("Nimetus: ").append(getNimetus()).append(", ");
        sb.append("Seaduse_ID: ").append(getSeaduse_ID()).append(", ");
        sb.append("Suletud: ").append(getSuletud()).append(", ");
        sb.append("Sulgeja: ").append(getSulgeja()).append(", ");
        sb.append("TableName: ").append(getTableName()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
