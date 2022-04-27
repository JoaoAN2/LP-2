package Entidades;

 /**
 * @author JoaoAN2 27/04/2022 - 14:56:38
 */

public class CatReferee{
 
    private String siglaCatReferee;
    private String nameCatReferee;

    public CatReferee() {
    }

    public CatReferee(String siglaCatReferee, String nameCatReferee) {
        this.siglaCatReferee = siglaCatReferee;
        this.nameCatReferee = nameCatReferee;
    }

    public String getSiglaCatReferee() {
        return siglaCatReferee;
    }

    public void setSiglaCatReferee(String siglaCatReferee) {
        this.siglaCatReferee = siglaCatReferee;
    }

    public String getNameCatReferee() {
        return nameCatReferee;
    }

    public void setNameCatReferee(String nameCatReferee) {
        this.nameCatReferee = nameCatReferee;
    }

    @Override
    public String toString() {
        return siglaCatReferee + ";" + nameCatReferee;
    }
}
