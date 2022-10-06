
package Modelo;



public class Productos {
    
    private String Nom;
    private float Pre;
    private int cant;
    private String Tipo;
    private int caducidad;
    //constructor de la clase
    public Productos(){
        this.Nom="";
        this.Pre=0;
        this.cant=0;
        this.Tipo="";
        this.caducidad=0;
   }
    //metodos set y get

    public int getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(int caducidad) {
        this.caducidad = caducidad;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public Float getPre() {
        return Pre;
    }

    public void setPre(float Pre) {
        this.Pre = Pre;
    }

   

   

  
       
}
