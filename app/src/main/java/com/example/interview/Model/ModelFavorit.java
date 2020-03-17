package com.example.interview.Model;

public class ModelFavorit {

    String idTeam, strTeam, strTeamShort, strStadium;

    public ModelFavorit() {
    }

    public ModelFavorit(String idTeam, String strTeam, String strTeamShort, String strStadium) {
        this.idTeam = idTeam;
        this.strTeam = strTeam;
        this.strTeamShort = strTeamShort;
        this.strStadium = strStadium;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeamShort() {
        return strTeamShort;
    }

    public void setStrTeamShort(String strTeamShort) {
        this.strTeamShort = strTeamShort;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }
}
