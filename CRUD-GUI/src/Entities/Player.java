package Entities;

import Tools.DateTools;
import java.text.DecimalFormat;
import java.util.Date;
/**
 *
 * @author JoaoAN2
 */
public class Player {

    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    DateTools dateTools = new DateTools();
    
    private int id;
    private String name;
    private String sigla_federation;
    private Date birthday;
    private int points;

    public Player() {
    }

    public Player(int id, String name, String sigla_federation, Date birthday, int points) {
        this.id = id;
        this.name = name;
        this.sigla_federation = sigla_federation;
        this.birthday = birthday;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFederation() {
        return sigla_federation;
    }

    public void setFederation(String sigla_federation) {
        this.sigla_federation = sigla_federation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return id + ";" + name + ";" + sigla_federation + ";" + dateTools.conversionDateToString(birthday) + ";" + points;
    }

    public String dados() {
        return "ID FIDE: " + id + "\nNome: " + name + "\nFederação: " + sigla_federation + "\nData de Nascimento: " + dateTools.conversionDateToString(birthday) 
                + "\nPontos FIDE: " + points + "\n";
    }
}
