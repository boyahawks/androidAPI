package com.example.interview.Model;

public class ModelLiga {

    String idLeague, strLeague, strSport, strLeagueAlternate;

    public ModelLiga() {
    }

    public ModelLiga(String idLeague, String strLeague, String strSport, String strLeagueAlternate) {
            this.idLeague = idLeague;
            this.strLeague = strLeague;
            this.strSport = strSport;
            this.strLeagueAlternate = strLeagueAlternate;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrLeagueAlternate() {
        return strLeagueAlternate;
    }

    public void setStrLeagueAlternate(String strLeagueAlternate) {
        this.strLeagueAlternate = strLeagueAlternate;
    }
}
