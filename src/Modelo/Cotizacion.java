

package Modelo;

public class Cotizacion {
    private String nomCO;
    private String tipoCO;
    private int cantCo;
    private float preCO;
    private float proCotizado;
//Constructor de la clase
    public Cotizacion() {
        this.nomCO = "";
        this.tipoCO = "";
        this.cantCo = 0;
        this.preCO = 0;
        this.proCotizado=0;
    }

    public float getProCotizado() {
        return proCotizado;
    }

    //metodos get y sett
    public void setProCotizado(float proCotizado) {
        this.proCotizado = proCotizado;
    }

    public String getNomCO() {
        return nomCO;
    }

    public void setNomCO(String nomCO) {
        this.nomCO = nomCO;
    }

    public String getTipoCO() {
        return tipoCO;
    }

    public void setTipoCO(String tipoCO) {
        this.tipoCO = tipoCO;
    }

    public int getCantCo() {
        return cantCo;
    }

    public void setCantCo(int cantCo) {
        this.cantCo = cantCo;
    }

    public float getPreCO() {
        return preCO;
    }

    public void setPreCO(float preCO) {
        this.preCO = preCO;
    }
    
    
}
