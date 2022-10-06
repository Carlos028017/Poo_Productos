

package Modelo;

import Controlador.Controlador;
import Vista.Vista;


public class Principal {
    public static void main(String[]args){
        Vista vi=new Vista() ;
        Stock NoPer =new Stock(100);
        Controlador co=new Controlador(NoPer,vi);
        co.Iniciar();
        vi.setVisible(true);
        
    }
    
}
