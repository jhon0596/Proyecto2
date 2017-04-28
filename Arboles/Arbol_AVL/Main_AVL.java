package Arbol_AVL;
public class Main_AVL {
	
	public static void main(String[] args) {
		
		ArbolAVL arbolitoAVL = new ArbolAVL();
		
		arbolitoAVL.insertar(10);
		arbolitoAVL.insertar(5);
		arbolitoAVL.insertar(13);
		arbolitoAVL.insertar(1);
		arbolitoAVL.insertar(6);
		arbolitoAVL.insertar(17);
		arbolitoAVL.insertar(17);
		arbolitoAVL.insertar(17);
		arbolitoAVL.insertar(17);
		
		
		System.out.print("\nDespliegue del AVL : \t");
		
		arbolitoAVL.preOrden(arbolitoAVL.obtenerRaiz());
		
		

	}

}
