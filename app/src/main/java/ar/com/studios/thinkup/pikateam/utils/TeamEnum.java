package ar.com.studios.thinkup.pikateam.utils;

import java.io.Serializable;

/**
 * Created by Facundo on 15/07/2016.
 */

public enum TeamEnum  implements Serializable{
    MYSTIC(1, "Mystic"),VALOR(2,"Valor"),INSTINCT(3,"Instinct"), NEUTRAL(4,"Neutral");

    private Integer id;
    private String desc;

    TeamEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static TeamEnum getById(Integer id){
        for (TeamEnum t:TeamEnum.values()) {
            if(t.getId().equals(id)){
                return t;
            }

        }
        return null;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
