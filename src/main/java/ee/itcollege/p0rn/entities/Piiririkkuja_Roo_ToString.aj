// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.p0rn.entities;

import java.lang.String;

privileged aspect Piiririkkuja_Roo_ToString {
    
    public String Piiririkkuja.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Avaja: ").append(getAvaja()).append(", ");
        sb.append("Avatud: ").append(getAvatud()).append(", ");
        sb.append("Eesnimi: ").append(getEesnimi()).append(", ");
        sb.append("FormLabel: ").append(getFormLabel()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("IdName: ").append(getIdName()).append(", ");
        sb.append("Isikukood: ").append(getIsikukood()).append(", ");
        sb.append("Kommentaar: ").append(getKommentaar()).append(", ");
        sb.append("Muudetud: ").append(getMuudetud()).append(", ");
        sb.append("Muutja: ").append(getMuutja()).append(", ");
        sb.append("Objekt_ID: ").append(getObjekt_ID()).append(", ");
        sb.append("Perek_nimi: ").append(getPerek_nimi()).append(", ");
        sb.append("Piiririkkuja_ID: ").append(getPiiririkkuja_ID()).append(", ");
        sb.append("Sugu: ").append(getSugu()).append(", ");
        sb.append("Suletud: ").append(getSuletud()).append(", ");
        sb.append("Sulgeja: ").append(getSulgeja()).append(", ");
        sb.append("Synniaeg: ").append(getSynniaeg()).append(", ");
        sb.append("TableName: ").append(getTableName());
        return sb.toString();
    }
    
}
