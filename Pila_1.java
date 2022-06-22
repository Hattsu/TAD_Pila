/*
* Programa: Lista Simplemente Enlazada - Datos enteros
* Fecha: 3 de agosto del 2021
* Autor: Byron Calderón
*/
class CNodo {
	int dato;
	CNodo siguiente;
        
	public CNodo()	{
            siguiente = null;
	}
}

class CLista {
    CNodo cabeza;
    public CLista()	{
            cabeza = null;
    }

    public void InsertarDato(int dat) {
        CNodo NuevoNodo;
        CNodo antes, luego;
        NuevoNodo = new CNodo();
        NuevoNodo.dato=dat;
        int ban=0;
        if (cabeza == null){ //lista esta vacia
            NuevoNodo.siguiente=null;
            cabeza = NuevoNodo;
        }
        else {  if (dat<cabeza.dato) {//dato va antes de cabeza
                    NuevoNodo.siguiente=cabeza;
                    cabeza = NuevoNodo;
                }
                else {  antes=cabeza;
                        luego=cabeza;
                        while (ban==0){
                            if (dat>=luego.dato) {
                                antes=luego;
                                luego=luego.siguiente;
                            }
                            if (luego==null){
                                ban=1;
                            }
                            else {
                                    if (dat<luego.dato){
                                        ban=1;
                                    }
                            }
                        }
                        antes.siguiente=NuevoNodo;
                        NuevoNodo.siguiente=luego;
                }
        }
    }

    public void EliminarDato(int dat) {
        CNodo antes,luego;
        int ban=0;
        if (Vacia()) {
            System.out.print("Lista vacía ");
        }
        else {  if (dat<cabeza.dato) {
                    System.out.print("dato no existe en la lista ");
                }
                else {
                        if (dat==cabeza.dato) {
                            cabeza=cabeza.siguiente;
                        }
                        else {  antes=cabeza;
                                luego=cabeza;
                                while (ban==0) {
                                    if (dat>luego.dato) {
                                        antes=luego;
                                        luego=luego.siguiente;
                                    }
                                    else ban=1;
                                    if (luego==null) {
                                        ban=1;
                                    }
                                    else {
                                            if (luego.dato==dat) 
                                                ban=1;
                                    }
                                }
                                if (luego==null) {
                                    System.out.print("Dato no existe en la Lista ");
                                }
                                else {
                                        if (dat==luego.dato) {
                                            antes.siguiente=luego.siguiente;
                                        }
                                        else 
                                            System.out.print("Dato no existe en la Lista ");
                                }
                        }
                }
        }
    }

    public boolean Vacia() {
        if (cabeza==null){
            return (true);
        }
        else
            return(false);
    }

    public void VisualizarDatos() {
        CNodo Temporal;
        Temporal=cabeza;
        if (!Vacia()) {
            while (Temporal!=null) {
                System.out.print(" " + Temporal.dato +" ");
                Temporal = Temporal.siguiente;
            }
            System.out.println("");
        }
        else
            System.out.print("Lista vacía");
    }
}

public class ListaSEnlazada {
    public static void main(String args[]) {
        CLista objLista= new CLista();
        System.out.println("Lista Original:");
        objLista.InsertarDato(9);
        objLista.InsertarDato(20);
        objLista.InsertarDato(1);
        //objLista.InsertarDato(7);
        objLista.VisualizarDatos();
        System.out.println("\nLista Sin el 1 : ");
        objLista.EliminarDato(1);
        objLista.VisualizarDatos();
    }
}
