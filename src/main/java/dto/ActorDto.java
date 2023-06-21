package dto;

import java.util.Date;

public class ActorDto {
    private String name;
    private Date birth_date;
    private String nation;
    private String gender;

    public ActorDto(String name, Date birth_date, String nation, String gender) {
        this.name = name;
        this.birth_date = birth_date;
        this.nation = nation;
        this.gender = gender;
    }

    public ActorDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
