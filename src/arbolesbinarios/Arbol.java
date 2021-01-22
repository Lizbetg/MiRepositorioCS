/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

/**
 *
 * @author Edgar Cupul
 */
public class Arbol {

    Nodo raiz;

    public Arbol() {
        raiz = null;
    }
    
    public void recorrerInOrder(Nodo n){
        if (n!=null){
            recorrerInOrder(n.izquierda);
            System.out.println("Indice " + n.llave + " Contenido " + n.contenido);
            recorrerInOrder(n.derecha);
        }
    }
    
    public void recorrerPreOrder(Nodo n){
        if(n!=null){
            System.out.println("Indice " + n.llave + " Contenido " + n.contenido);
            recorrerPreOrder(n.izquierda);
            recorrerPreOrder(n.derecha);
        }
    }
    
    public void recorrerPostOrder(Nodo n){
        if(n!=null){
            recorrerPostOrder(n.izquierda);
            recorrerPostOrder(n.derecha);
            System.out.println("Indice " + n.llave + " Contenido " + n.contenido);
        }
    }

    public void insertar(int i, int fruta) {
        Nodo n = new Nodo(i);
        n.contenido = fruta;

        if (raiz == null) {
            raiz = n;
        } else {
            Nodo aux = raiz;
            while (aux != null) {
                n.padre = aux;
                if (n.llave >= aux.llave) {
                    aux = aux.derecha;
                } else {
                    aux = aux.izquierda;
                }
            }

            if (n.llave < n.padre.llave) {
                n.padre.izquierda = n;
            } else {
                n.padre.derecha = n;
            }
        }
    }
    
    /**
     * Proporcionando un valor entero, el indice, lo busará y lo devolverá
     * 
     * @param a
     * @return Nodo aux 
     */
    public Nodo buscar(int a){
        Nodo aux = raiz;
        while(aux.llave!=a){
            if(a<aux.llave){
                aux = aux.izquierda;
            }else{
                aux = aux.derecha;
            }
            
            if(aux == null){
                System.out.println("\n#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
                System.out.println("No se encontró el elemento solicitado");
                System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#\n");
                return null;
            }
        }
        System.out.println("\n#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("El elemento encontrado es: " + aux.llave + " con contenido: " + aux.contenido);
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#\n");
        return aux;
    }
    
    public boolean eliminar(int a){
        Nodo aux = raiz;
        Nodo padre = raiz;
        boolean esHijoIzq = true;
        while(aux.llave != a){
            padre = aux;
            if(a<aux.llave){
                esHijoIzq = true;
                aux = aux.izquierda;
            }else{
                esHijoIzq = false;
                aux = aux.derecha;
            }
            if(aux == null){
                System.out.println("\n#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
                System.out.println("No se ha encontrado el indice solicitado.");
                System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#\n");
                return false;
            }
        }//Fin del while
        
        if(aux.izquierda == null && aux.derecha == null){
            if(aux == raiz){
                raiz=null;
            }else{
                if(esHijoIzq){
                    padre.izquierda = null;
                }else{
                    padre.derecha = null;
                }
            }
        }else if(aux.derecha == null){
            if(aux == raiz){
                raiz=aux.izquierda;
            }else{
                if(esHijoIzq){
                    padre.izquierda = aux.izquierda;
                }else{
                    padre.derecha = aux.izquierda;
                }
            }
        }else if(aux.izquierda == null){
            if(aux == raiz){
                raiz=aux.derecha;
            }else{
                if(esHijoIzq){
                    padre.izquierda = aux.derecha;
                }else{
                    padre.derecha = aux.izquierda;
                }
            }
        }else{
            Nodo reemplazo = obtenerNodoReemplazo(aux);
            if(aux == raiz){
                raiz = reemplazo;
            }else if(esHijoIzq){
                padre.izquierda = reemplazo;
            }else{
                padre.derecha = reemplazo;
            }
            reemplazo.izquierda = aux.izquierda;
        }System.out.println("\n#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("¡El indice ha sido eliminado!");
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#\n");
        return true;
    }
    
    /**
     * Auxiliar para el metodo que elimina nodos
     * @param a
     * @return Nodo reemplazo
     */
    public Nodo obtenerNodoReemplazo(Nodo reem){
        Nodo reemplazarPadre=reem;
        Nodo reemplazo = reem;
        Nodo auxiliar = reem.derecha;
        
        while(auxiliar != null){
            reemplazarPadre=reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.izquierda;
        }
        
        if(reemplazo != reem.derecha){
            reemplazarPadre.izquierda = reemplazo.derecha;
            reemplazo.derecha = reem.derecha;
        }
        System.out.println("\n#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("El nodo reemplazo es" + reemplazo);
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#\n");
        return reemplazo;
    }//Fin del metodo

    
    
    public class Nodo {

        public Nodo padre;
        public Nodo derecha;
        public Nodo izquierda;
        public int llave;
        public int contenido;

        public Nodo(int indice) {
            llave = indice;
            derecha = null;
            izquierda = null;
            padre = null;
            contenido = 0;
        }
    }

}
