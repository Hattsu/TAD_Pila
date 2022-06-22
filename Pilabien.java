import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * Programa de implementación del TAD Pila
 * Autor: Byron Calderón
 */
public class Pilabien {
   public static final int MAX_LENGTH = 5;
   public static String Pila[] = new String[MAX_LENGTH];
   public static int cima = -1;
   public static String Pilaaux[] = new String[MAX_LENGTH];
   public static int cimaaux = -1;
    
    public static void main(String[] args)throws IOException{
        // TODO code application logic here
        Menu();
    }
    
    public static void Menu()throws IOException{
       String salida="====Menú Manejo Pila====\n"+"1- Insertar elemento\n"+"2- Eliminar elemento\n";
       salida=salida+"3- Buscar elemento\n"+"4- Imprimir pila\n"+"5- Contar repetición\n";
       salida=salida+"6- Salir\n";
       String entra=JOptionPane.showInputDialog(null, salida);
       int op = Integer.parseInt(entra);
       Opciones(op);
    }

    public static void Opciones(int op)throws IOException{
        String salio;
        switch(op){
			case 1: Insertar();
                                Menu();
			        break;
			case 2: salio=Desapilar();
                                if (!vacia()){
                                   JOptionPane.showMessageDialog(null, "El dato que salio es "+salio); 
                                }
                                Menu();
			        break;
			case 3: Buscar();
                                Menu();
			        break;
			case 4: Imprimir();
                                Menu();
			        break;
                         case 5: contar();
                                Menu();
			        break;
			case 6: System.exit(0);
			        break;
			default:Menu();
			        break;
                        
	   }
    }

    public static void Insertar()throws IOException{
       String entra = JOptionPane.showInputDialog("Digite un dato para la pila");
       Apilar(entra);
    }

    public static void Apilar(String dato)throws IOException{
      if ((Pila.length-1)==cima){
        JOptionPane.showMessageDialog(null,"Capacidad de la pila al limite");
        Imprimir();
      }else{
            cima++;
            JOptionPane.showMessageDialog(null,"Cima en la posición "+cima);
            Pila[cima]=dato;
      }
    }

    public static void Apilaraux(String dato)throws IOException{
      if ((Pilaaux.length-1)==cimaaux){
        JOptionPane.showMessageDialog(null,"Capacidad de la pila auxiliar al limite");
      }else{
         cimaaux++;
         Pilaaux[cimaaux]=dato;
       }
    }

    public static boolean vaciaaux(){
        return (cimaaux==-1);
    }

    public static boolean vacia(){
        if (cima==-1){
            return (true);
        }
        else {
            return(false);
            
        }
    }
    public static void Limpiar()throws IOException{
      String quedata;
      if (cima!=-1)
      { do {
            quedata=Desapilar();
        }while(cima!=-1);
      }
    }
    public static void Imprimir()throws IOException{
      String quedata,salida=" ";
      if (cima!=-1)
      { do {
            quedata=Desapilar();
            
            salida=salida+quedata+"\n"; //System.out.println mostrando
            Apilaraux(quedata);            
        }while(cima!=-1);
        do {
            quedata=Desapilaraux();
            Apilar(quedata);
        }while(cimaaux!=-1);
        JOptionPane.showMessageDialog(null, salida);
      }
      else {
          JOptionPane.showMessageDialog(null, "La pila esta vacía");
      }
    }

    public static String Desapilar()throws IOException{
      String quedato;
      if(vacia()){
          JOptionPane.showMessageDialog(null,"No se puede eliminar, pila vacía !!!" );
          return("");
      }else{
              quedato=Pila[cima];
	      Pila[cima] = null;
	      --cima;
              return(quedato);
            }
    }

    public static String Desapilaraux()throws IOException{
      String quedato;
      if(cimaaux== -1){
            JOptionPane.showMessageDialog(null,"No se puede eliminar, pila vacía !!!" );
            return("");
      }else{
              quedato=Pilaaux[cimaaux];
	      Pilaaux[cimaaux] = null;
	      --cimaaux;
              return(quedato);
           }
    }

    public static void Buscar()throws IOException{
        if (vacia()){
            JOptionPane.showMessageDialog(null, "La pila esta vacìa");
        }
        else{
            String cad = JOptionPane.showInputDialog("Digite la cadena a buscar: ");
            String quedata;
            int bandera=0; //no se encuentra
            do {
                    quedata=Desapilar();
                    if(cad.equals(quedata)){
                        bandera=1; //si esta
                    }
                    Apilaraux(quedata);            
            }while(cima!=-1);
            do {
                    quedata=Desapilaraux();
                    Apilar(quedata);
            }while(cimaaux!=-1);
            if (bandera==1) {
                    JOptionPane.showMessageDialog(null,"Elemento encontrado");
            }else{
                    JOptionPane.showMessageDialog(null,"Elemento no encontrado :(");
            }
        }
    }
    public static void contar() throws IOException {
        String quedata;
        int contador = 0;
        if (vacia()){ //chequear si la pila esta vacía
            JOptionPane.showMessageDialog(null, "La pila esta vacìa"); //mostrar que la pila esta vacía
        }
        else {  //la pila tiene datos
            do {
                //saca un elemento de la pila    y lo recibe en quedata
                quedata=Desapilar();
                //contar que ya saque un elemento
                contador = contador+1;
                //guardo el dato que saque en mi pila auxiliar
                Apilaraux(quedata);            
            }while(!vacia());  //repito si la pila tiene datos
            do {
                quedata=Desapilaraux();
                Apilar(quedata);
            }while(!vaciaaux());
            JOptionPane.showMessageDialog(null,"Elementos en la pila: "+ contador);
          
        }
    }           
}
