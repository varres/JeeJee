// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.p0rn.entities;

import java.lang.String;

privileged aspect Riik_Roo_ToString {
    
    public String Riik.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ANSI_kood: ").append(getANSI_kood()).append(", ");
        sb.append("ISO_kood: ").append(getISO_kood()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("IdName: ").append(getIdName()).append(", ");
        sb.append("Kommentaar: ").append(getKommentaar()).append(", ");
        sb.append("Riik_ID: ").append(getRiik_ID()).append(", ");
        sb.append("Suletud: ").append(getSuletud()).append(", ");
        sb.append("Sulgeja: ").append(getSulgeja()).append(", ");
        sb.append("TableName: ").append(getTableName()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
