
package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


public class Stock {
    private Cotizacion coti[];
    private float preciopro;
    private int tipodepro;
    private Productos pro[];
    private int caducidad;
    private float solu;
    public float totCotizado;
    private File file;
    private FileWriter write_file;
    private String name_file;
    ArrayList costodeprod = new ArrayList(1000);
   
 
   //constructor de la clase
    public Stock(int tam) {
        this.pro = new Productos [tam];
        this.tipodepro = 0;
        this.caducidad=0;
        this.solu= 0;
        this.preciopro= 0;
        this.coti = new Cotizacion [tam];
        this.name_file = "";
        this.file = null;
        this.write_file = null;
        
    }
    
 
//metodos get y set
 
    public String getName_file() {
        return name_file;
    }

    public void setName_file(String name_file) {
        this.name_file = name_file;
    }

    
    public Cotizacion getCoti(int pos) {
        return coti[pos];
    }

    public void setCoti(Cotizacion coti,int pos) {
         this.coti [pos]= coti;
    }

    public float getPreciopro() {
        return preciopro;
    }

    public Productos getPro(int pos) {
        return pro[pos];
    }

    public void setPro(Productos pro,int pos) {
        this.pro [pos]= pro;
    }
    public void setPreciopro(float preciopro) {
        this.preciopro = preciopro;
    }
 
    public float getSolu() {
        return solu;
    }

    public void setSolu(float solu) {
        this.solu = solu;
    }
    
    
    public int getCaducidad() {
        return caducidad;
    }

    //metodos set y get
    public void setCaducidad(int caducidad) {    
        this.caducidad = caducidad;
    }

    public int getTipodepro() {
        return tipodepro;
    }

    public void setTipodepro(int tipodepro) {
        this.tipodepro = tipodepro;
    }


    //metodos adicionales 
    
     public String show(){
        String msj = "inforacion del producto"+"\n";
        msj +=" Producto\t Precio\t Tipo\n";
        for(int a =0;a < getTamaño();a++){
            if(getPro(a)!=null){
            
            msj +=getPro(a).getNom()+"\t";
            msj +=getPro(a).getPre()+"\t";
            msj +=getPro(a).getTipo()+"\n";
   
        }
        }return msj;
        
    }
     
     public String cotizar(){
         Cotizacion co = new Cotizacion();
        String msj = "Cotizacion"+"\n";
        msj +=" Producto\t Precio\t Tipo\t\t cantidad\t total precio del producto\t total precio cotizado\n";
        for(int a =0;a < getTamaño();a++){
            if(getCoti(a)!=null){
            msj +=getCoti(a).getNomCO()+"\t";
            msj +=getCoti(a).getPreCO()+"\t";
            msj +=getCoti(a).getTipoCO()+"\t";
            msj +=getCoti(a).getCantCo()+"\t\t";
            msj +=getCoti(a).getProCotizado()+"\t";
            msj +=getCoti(a).getProCotizado()*getCoti(a).getCantCo()+"\n";
            
        }
        }return msj;
        
    }
     
     public float Cantidad(){
         float res=getPro(0).getCant()*getPro(0).getPre();
         return res;
     }
     
     public int getTamaño(){
        return this.pro.length;
    }
     
     
     public float descuento (float caducidad){
        float por;
        if(caducidad==1)
            por=1;
        else if(caducidad==2)
            por=4;
        else if(caducidad==3)
            por=3;
        else if(caducidad==4)
            por=2;
        else 
            por=1;
        return (int) por;
    
    }
     
     
  public float costopro(){
          float msj=0;
          for(int a =0;a < getTamaño();a++){
               if(getPro(a)!=null){
              costodeprod.add(preciopro);
          } 
          
          }
        return msj;
     }
            
     public float  solucion(float solu){
        float por = 0;
         if(solu==1)
             por =(float) costodeprod.get(0);
         else if(solu==2)
              por =(float) costodeprod.get(1);
         else if(solu==3)
            por =(float) costodeprod.get(4);
         else if(solu==4)
             por =(float) costodeprod.get(6);
         else if(solu==5)
              por =(float) costodeprod.get(8);
         else if(solu==6)
            por =(float) costodeprod.get(9);
         else if(solu==7)
             por =(float) costodeprod.get(8);
         else if(solu==8)
              por =(float) costodeprod.get(9);
         else if(solu==9)
            por =(float) costodeprod.get(8);
         else if(solu==10)
             por =(float) costodeprod.get(9);
         return  por;
     }
             
             
             
     public float multiplicarDividir(float val1, float val2, int val3){
        float res =(val1 * val2)/val3;
        return res;
        
    }
     
     public String create_file(String name_file){
        setName_file(name_file);
        String message = "";
        this.file = new File(getName_file());
        if(!this.file.exists()){
            try {
                this.file.createNewFile();
                message = "Archivo creado";
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        }else{
            message="El archivo ya existe";
        }
        return message;
    }
    
    public void append_to_file(String lineToAppend) throws IOException{
        byte[] byteArr = lineToAppend.getBytes();
         Files.write(Paths.get(getName_file()), byteArr, StandardOpenOption.APPEND);
    }
    
    public void FielDelet(String name_file) {
        String message ="";
    }

   
}
