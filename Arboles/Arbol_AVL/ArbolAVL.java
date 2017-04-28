package Arbol_AVL;
import java.lang.Math;


public class ArbolAVL {
	private NodoArbolAVL raiz;
	
	public ArbolAVL(){
		raiz=null;
	}
	public NodoArbolAVL obtenerRaiz(){
		return raiz;
	}
	// Buscar nodo
	public NodoArbolAVL buscar(int d, NodoArbolAVL r){
		if (raiz == null){
			return null;
			
		}else if (r.dato == d){
			return r;
			
		}else if (r.dato <d){
			return buscar(d,r.hijoDerecho);
		}else {
			return buscar(d,r.hijoIzquierdo);
		}
		
	}
	// Valor de factor de equilibrio
	public int obtenerFE(NodoArbolAVL x){
		if (x==null){
			return -1;
		}else {
			return x.fe;
		}
	}
	// Rotacion Simple IZQ
	public NodoArbolAVL rotacionIzquierda(NodoArbolAVL c){
		NodoArbolAVL auxiliar = c.hijoIzquierdo;
		c.hijoIzquierdo = auxiliar.hijoDerecho;
		auxiliar.hijoDerecho=c;
		c.fe= Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
		auxiliar.fe= Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
		return auxiliar;
	}
	// Rotacion Simple DER
		public NodoArbolAVL rotacionDerecha(NodoArbolAVL c){
			NodoArbolAVL auxiliar = c.hijoDerecho;
			c.hijoDerecho = auxiliar.hijoIzquierdo;
			auxiliar.hijoIzquierdo=c;
			c.fe= Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
			auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
			return auxiliar;
	}// Rotacion doble izq
		public NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL c){
			NodoArbolAVL temporal;
			c.hijoIzquierdo=rotacionDerecha ( c.hijoIzquierdo);
			temporal = rotacionIzquierda(c);
			return temporal;
	}// Rotacion doble der
	public NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL c){
		NodoArbolAVL temporal;
		c.hijoDerecho=rotacionDerecha ( c.hijoDerecho);
		temporal = rotacionDerecha(c);
		return temporal;
	}
	// Metodo insert AVL ( Balanceada )
	public NodoArbolAVL insertarAVL(NodoArbolAVL nuevo, NodoArbolAVL subAr){
		NodoArbolAVL nuevoPadre = subAr;
		if (nuevo.dato < subAr.dato){ // caso 1
			if (subAr.hijoIzquierdo == null){
				subAr.hijoIzquierdo=nuevo;
			}else{
				subAr.hijoIzquierdo = insertarAVL(nuevo,subAr.hijoIzquierdo);
				if (( obtenerFE(subAr.hijoIzquierdo)- obtenerFE(subAr.hijoDerecho)==2 )){
					if (nuevo.dato< subAr.hijoIzquierdo.dato){
						nuevoPadre = rotacionIzquierda ( subAr);
					}else{
						nuevoPadre = rotacionDobleIzquierda ( subAr);
					}
				}
			}
			
		}else if(nuevo.dato> subAr.dato){ // caso 2
			if (subAr.hijoDerecho == null){
				subAr.hijoDerecho=nuevo;
			}else{
				subAr.hijoDerecho = insertarAVL(nuevo,subAr.hijoDerecho);
				if (( obtenerFE(subAr.hijoDerecho)- obtenerFE(subAr.hijoIzquierdo)==2 )){
					if (nuevo.dato > subAr.hijoDerecho.dato){
						nuevoPadre = rotacionDerecha(subAr);
					}else{
						nuevoPadre = rotacionDobleDerecha (subAr);
					}
				}
			}
		}else{
			System.out.println("NODO DUPLICADO");
		}
		// Actualizar Altura ___ factor de equlibrio
		if (( subAr.hijoIzquierdo == null) && ( subAr.hijoDerecho!= null)){
			subAr.fe = subAr.hijoDerecho.fe+1;
		}else if ( ( subAr.hijoDerecho == null && subAr.hijoIzquierdo!=null)){
			subAr.fe=subAr.hijoIzquierdo.fe+1;
		}else{
			subAr.fe = Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoDerecho))+1;
		}
		return nuevoPadre;
	}
	// insertar
	public void insertar (int d){
		NodoArbolAVL nuevo= new NodoArbolAVL(d);
		if (raiz== null){
			raiz = nuevo;
		}else{
			raiz = insertarAVL(nuevo,raiz);
		}
	}
	// recorridos
	public void inOrden(NodoArbolAVL r){
		if (r!=null){
			inOrden(r.hijoIzquierdo);
			System.out.print(r.dato + ", ");
			inOrden( r.hijoDerecho );
			}
	}
		public void preOrden(NodoArbolAVL r){
			if ( r!=null){				
				System.out.print(r.dato + ", ");
				preOrden(r.hijoIzquierdo);				
				preOrden(r.hijoDerecho);
			}	
	}
		public void postOrden(NodoArbolAVL r){
			if ( r!=null){	
				postOrden(r.hijoIzquierdo);				
				postOrden(r.hijoDerecho);
				System.out.print(r.dato + ", ");
			}
	
}
}

















