
package arbolesbinarios;

import java.util.Scanner;

/**
 *
 * @author Edgar Cupul, Lizbeth Monforte
 */
public class ArbolesBinarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        
        //Valores
        int index, valor;
        
        boolean doit = true;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("###################################");
        System.out.println("#                                 #\n"  
                         + "#   Programa por: Edgar Cupul     #\n" 
                         + "#          Lizbeth Monforte       #"             
                         + "                                  \n" 
                         + "#                                 #");
        System.out.println("###################################\n\n");
        
        while(doit){
            System.out.println("------------------------------------");
            System.out.println("Menú de acciones para el arbol:\n");
            System.out.println("1.- Insertar un elemento en el arbol");
            System.out.println("2.- Recorrer el arbol inOrder");
            System.out.println("3.- Recorrer el arbol preOrder");
            System.out.println("4.- Recorrer el arbol postOrder");
            System.out.println("5.- Buscar un elemento en el arbol");
            System.out.println("6.- Eliminar un elemento en el arbol");
            System.out.println("7.- Salir");
            System.out.println("------------------------------------");
            int opt = sc.nextInt();
            
            switch(opt){
                case 1: System.out.println("Proporcione un indice: ");
                        index = sc.nextInt();
                        System.out.println("Proporcione al valor: ");
                        valor = sc.nextInt();
                        
                        arbol.insertar(index, valor);
                        System.out.println("¡Realizado!\n------\n");
                        break;
                
                case 2: arbol.recorrerInOrder(arbol.raiz);
                        break;
                
                case 3: arbol.recorrerPreOrder(arbol.raiz);
                        break;
                
                case 4: arbol.recorrerPostOrder(arbol.raiz);
                        break;
                
                case 5: System.out.println("Proporcione el indice a buscar: ");
                        int busqueda = sc.nextInt();
                        arbol.buscar(busqueda); 
                        break;
                
                case 6: System.out.println("Proporcione el indice a eliminar");
                        int elim = sc.nextInt();
                        arbol.eliminar(elim);
                        break;
                
                case 7: doit = false; break;
            }
            
        }
    /*    
        arbol.insertar(4, 90);
        arbol.insertar(8, 56);
        arbol.insertar(1, 45);
        arbol.insertar(9, 78);
        arbol.insertar(7, 34);
        arbol.insertar(2, 21);
        
        arbol.recorrerInOrder(arbol.raiz);
        System.out.println("-------------------");
        arbol.recorrerPostOrder(arbol.raiz);
        System.out.println("-------------------");
        arbol.recorrerPreOrder(arbol.raiz);
    */
    }
}
