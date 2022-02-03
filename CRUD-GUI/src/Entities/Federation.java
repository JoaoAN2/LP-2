package Entities;

/**
 *
 * @author JoaoAN2
 */
public class Federation {

    private String sigla_federation;
    private String name_federation;
    
    public Federation(){
    }

    public Federation(String sigla_federation, String name_federation) {
        this.sigla_federation = sigla_federation;
        this.name_federation = name_federation;
    }

    public String getSigla_federation() {
        return sigla_federation;
    }

    public void setSigla_federation(String sigla_federation) {
        this.sigla_federation = sigla_federation;
    }

    public String getName_federation() {
        return name_federation;
    }

    public void setName_federation(String name_federation) {
        this.name_federation = name_federation;
    }

    @Override
    public String toString() {
        return sigla_federation + ";" + name_federation;
    }
}
