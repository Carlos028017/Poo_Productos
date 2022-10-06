
package Controlador;


import Modelo.Cotizacion;
import Modelo.Stock;
import Modelo.Productos;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Controlador implements ActionListener{
    private Stock Stock;
    private Vista vi;
    private int pos;
    
    DecimalFormat f1 = new DecimalFormat("$###,###,###,###.##");
    
 
    public Controlador(Stock NoPer, Vista vi) {
        this.Stock = NoPer;
        this.vi = vi;
        
        
        
        
        vi.btnGuardar.addActionListener(this);
        vi.btnMostrar.addActionListener(this);
        vi.btnSalir.addActionListener(this);
        vi.btnCotizar.addActionListener(this);
        vi.btnArchivo.addActionListener(this);
        vi.btncargar.addActionListener(this);
        vi.btneliminar.addActionListener(this);
        
        //vi.cmbDiasACaducar.addActionListener(this);
        vi.cmbTipo.addActionListener(this);
        vi.cmbCaducar.addActionListener(this);
       
    }
    //formato para las salidas numericas en porcentaje y moneda
   
    DecimalFormat f2 = new DecimalFormat("$###,###,###,###.##");
    
    public void Iniciar() {
        vi.setTitle("Generar una cotización");
        vi.setLocationRelativeTo(null);
    }
    public void muestraContenido(String archivo) throws FileNotFoundException, IOException { 
        String otra="";
	String cadena;
	FileReader f = new FileReader(archivo); 
	BufferedReader b = new BufferedReader(f); 
        String msj = "Cotizacion"+"\n";
        msj +=" Prod\n";
	while((cadena = b.readLine())!=null) { 
            otra += cadena+"\n";
		
	} 
        vi.txtarchivo.setText(otra); 
	b.close(); 
    }
    
    public void GuardarProducto(){
        Productos prod=new Productos();
         Stock.setPreciopro(Float.parseFloat(vi.txtPrecio.getText()));
        
        prod.setNom(vi.txtNombrePro.getText());
        prod.setPre(Float.parseFloat(vi.txtPrecio.getText()));
        prod.setTipo((String) vi.cmbTipo.getSelectedItem());
        
       
        if(Stock.getTamaño()>this.pos){
            Stock.setPro(prod, pos);
            Stock.costopro();
            JOptionPane.showMessageDialog(null, "se ingresaron los datos correctamente");
            pos++;
        }else 
            JOptionPane.showMessageDialog(null, "la gestion seencuentra llena");
    }
    
    
    public void cotizar(){
         Stock.setCaducidad(vi.cmbCaducar.getSelectedIndex()+1);
         Stock.setSolu(vi.jCoProductos.getSelectedIndex()+1);
         Cotizacion co = new Cotizacion();
         co.setNomCO((String) vi.jCoProductos.getSelectedItem());
         co.setCantCo(Integer.parseInt(vi.txtCantidad.getText()));
         co.setTipoCO((String) vi.cmbCaducar.getSelectedItem());
          int des=(int) Stock.descuento(Stock.getCaducidad());
        float canpro= Float.parseFloat (vi.txtCantidad.getText());
        float solo =Stock.solucion(Stock.getSolu());
        float precioges=(solo/des);
         co.setProCotizado(precioges);
         co.setPreCO(solo);
      
        
        if(Stock.getTamaño()>this.pos){
            Stock.setCoti(co, pos);
            vi.txtCotizacion.setText(Stock.cotizar());
            JOptionPane.showMessageDialog(null, "se ingresaron los datos correctamente");
            
            pos++;
        }else 
            JOptionPane.showMessageDialog(null, "la gestion seencuentra llena");
        
    }
    public void Mostrar(){
        vi.txtArreglo.setText(Stock.show());
    }
    
    public void GuardarArchivo() throws IOException{
        System.out.println(Stock.create_file("datos producto.txt"));
        Stock.append_to_file(Stock.show());
    }
    
    public  void borrarLinea() throws IOException {
      
        File inputFile = new File("datos producto.txt");
        File tempFile = new File("datos productotemp.txt");
        BufferedReader leer = new BufferedReader(new FileReader(inputFile));
        BufferedWriter escribir = new BufferedWriter(new FileWriter(tempFile));
        int lineaeliminar;
        lineaeliminar = Integer.parseInt(vi.txtnumlin.getText());
        String listaactual;
        int contar = 0; 
        while ((listaactual = leer.readLine()) != null) {
            contar++;
            if (contar == lineaeliminar) {
                continue;
            }
            escribir.write(listaactual + System.getProperty("line.separator"));
        }
        escribir.close();
        leer.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
    
    
   public void comboboxmostrar(){
       String datos=(vi.txtNombrePro.getText());
       vi.jCoProductos.addItem(datos);
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vi.btnGuardar){
            GuardarProducto();
            comboboxmostrar();
        }else if(e.getSource()==vi.btnSalir){
            System.exit(0);
        }else if(e.getSource()==vi.btnMostrar){
            Mostrar();
        }else if(e.getSource()==vi.btnCotizar){
            cotizar();
        }else if(e.getSource()==vi.btnArchivo){
            try {
                GuardarArchivo();
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource()==vi.btncargar){
         try {
                muestraContenido("datos producto.txt");
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(e.getSource()==vi.btneliminar){
            try { 
                borrarLinea();
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
            
           
                
            
        }
            
      
    }
    
