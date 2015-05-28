package clases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Registro {

    private static Registro instancia;
    
    private Registro() {    
        listado = new ArrayList();
    }
    
    public static Registro getInstancia() {
        if(instancia == null)
            instancia = new Registro();
        return instancia;
    }
    
    public void agregarVenta(String producto, int cantidad) {
        listado.add( new Ventas(producto, cantidad) );
    }
    
    @Override
    public String toString() {
        String s = "\n\nHISTORIAL DE VENTAS REALIZADAS."
                  +"\n--------- -- ------ ---------->\n";
        for(Ventas v : listado)
            s += v.toString();
        return s;        
    }
    
    private ArrayList<Ventas> listado;
    
    public class Ventas {
        private String nombreProducto;
        private int cantidad;
        GregorianCalendar GC;

        public Ventas(String nombreProducto, int cantidad) {
            this.nombreProducto = nombreProducto;
            this.cantidad = cantidad;
            GC = new GregorianCalendar();
        }
        
        @Override
        public String toString() {
            int d = GC.get(Calendar.DAY_OF_MONTH);
            int m = GC.get(Calendar.MONTH);
            int a = GC.get(Calendar.YEAR);
            String fecha = (d<10?"0":"")+d+"/"+(m<10?"0":"")+m+"/"+a;
            int hh = GC.get(Calendar.HOUR);
            int mm = GC.get(Calendar.MINUTE);
            int ss = GC.get(Calendar.SECOND);
            String hora = (hh<10?"0":"")+hh+":"+(mm<10?"0":"")+mm+":"+(ss<10?"0":"")+ss;
            return "\nNombre del producto: "+nombreProducto
                  +"\nCantidad adquirida: "+cantidad
                  +"\nFecha de la compra: "+fecha
                  +"\nHora de la compra: "+hora+"\n";            
        }
    }
}
