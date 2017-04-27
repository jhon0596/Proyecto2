import java.util.Scanner;

/**
 * Created by Gabriel on 4/26/2017.
 */
public class pruebasSplay {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        arbolSplay spt = new arbolSplay();
        char ch;
        do
        {
            System.out.println("1. insertar ");
            System.out.println("2. remover ");
            System.out.println("3. encontrar");
            System.out.println("4. cantidad nodos");
            System.out.println("5. revisar si esta vacio");
            System.out.println("6. limpiar arbol");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Elemento a insertar");
                    spt.insertar( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Elemento a remover");
                    spt.eliminar( scan.nextInt() );
                    break;
                case 3 :
                    System.out.println("Elemento a buscar");
                    System.out.println("Resultado : "+ spt.encontrar( scan.nextInt() ));
                    break;
                case 4 :
                    System.out.println("Nodos = "+ spt.getcontador());
                    break;
                case 5 :
                    System.out.println("Resultado = "+ spt.estaVacio());
                    break;
                case 6 :
                    System.out.println("\nArbol Limpio");
                    spt.limpiarArbol();
                    break;
                default :
                    System.out.println("Comando no aceptado \n ");
                    break;
            }
            System.out.print("\nInOrden : ");
            spt.inOrden();

            System.out.println("\nContinuar? (Presione y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}
