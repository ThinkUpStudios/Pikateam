package ar.com.studios.thinkup.pikateam.utils;

/**
 * Created by Facundo on 15/07/2016.
 */

public class Response {


    public Response(Integer id, String response, TeamEnum team) {
        this.response = response;
        this.team = team;
    }

    private Integer id;
    private String response;
    private TeamEnum team;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public TeamEnum getTeam() {
        return team;
    }

    public void setTeam(TeamEnum team) {
        this.team = team;
    }
}


