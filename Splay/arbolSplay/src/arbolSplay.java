/**
 * Created by Gabriel on 4/26/2017.
 */
public class arbolSplay {
    private nodoSplay raizSplay;
    private int contador = 0;

    arbolSplay(){//constructor
        this.raizSplay = null;
    }
    public boolean estaVacio(){//retorna si el arbol esta vacio no no
        return raizSplay == null;
    }
    public void limpiarArbol(){//hace que el arbol este vacio
        this.raizSplay = null;
    }
    public void insertar(int ele){//inserta un elemento
        nodoSplay actual = raizSplay;
        nodoSplay siguiente = null;
        while(actual !=null){
            siguiente = actual;
            if(ele<siguiente.getElemento()){
                actual = actual.getDer();
            }
            else {
                actual = actual.getIzq();
            }
        }
        actual = new nodoSplay();
        actual.setElemento(ele);
        actual.setPadre(siguiente);
        if(siguiente==null){
            raizSplay = actual;
        }
        else if(ele<siguiente.getElemento()){
            siguiente.setDer(actual);
        }
        else {
            siguiente.setIzq(actual);
        }
        accionSplay(actual);
        contador++;
    }
    public void hijoIzqaPadre(nodoSplay nodo1,nodoSplay nodo2){//vuelve el hijo izq el padre (rotacion)
        if ((nodo1 == null) || (nodo2 == null) || (nodo2.getIzq() != nodo1) || (nodo1.getPadre() != nodo2)){
            throw new RuntimeException("WRONG");
        }

        if (nodo2.getPadre() != null){
            if (nodo2 == nodo2.getPadre().getIzq()){
                nodo2.getPadre().setIzq(nodo1);
            }
            else{
                nodo2.getPadre().setDer(nodo1);
            }
        }
        if (nodo1.getDer() != null){
            nodo1.getDer().setPadre(nodo2);

    }
        nodo1.setPadre(nodo2.getPadre());
        nodo2.setPadre(nodo1);
        nodo2.setIzq(nodo1.getDer());
        nodo1.setDer(nodo2);
    }
    public void hijoDeraPadre(nodoSplay nodo1,nodoSplay nodo2){
        if ((nodo1 == null) || (nodo2 == null) || (nodo2.getDer() != nodo1) || (nodo1.getPadre() != nodo2)){
            throw new RuntimeException("WRONG");
        }

        if (nodo2.getPadre() != null){
            if (nodo2 == nodo2.getPadre().getIzq()){
                nodo2.getPadre().setIzq(nodo1);
            }
            else{
                nodo2.getPadre().setDer(nodo1);
            }
        }
        if (nodo1.getIzq() != null){
            nodo1.getIzq().setPadre(nodo2);
        }
        nodo1.setPadre(nodo2.getPadre());
        nodo2.setPadre(nodo1);
        nodo2.setDer(nodo1.getIzq());
        nodo1.setIzq(nodo2);
    }
    public void accionSplay(nodoSplay nodo){// accion para que el accesado mas reciente quede arriba del arbol
        while(nodo.getPadre()!=null){
            nodoSplay padre = nodo.getPadre();//el padre del nodo en que se va a ejecutar la accion
            nodoSplay abuelo = padre.getPadre();//el abuelo del nodo en el que se ejecutara la accion
            if(abuelo == null){//si no tiene abuelo, osea su padre es raiz
                if(nodo==padre.getIzq()){
                    hijoIzqaPadre(nodo,padre);
                }
                else{
                    hijoDeraPadre(nodo,padre);
                }
            }
            else{
                if(nodo==padre.getIzq()){
                    if(padre == abuelo.getIzq()){
                        hijoIzqaPadre(padre,abuelo);//doble rotacion
                        hijoIzqaPadre(nodo,padre);//doble rotacion
                    }
                    else {
                        hijoIzqaPadre(nodo,nodo.getPadre());
                        hijoDeraPadre(nodo,nodo.getPadre());
                    }
                }
                else{
                    if(padre == abuelo.getIzq()){
                        hijoDeraPadre(nodo,nodo.getPadre());
                        hijoIzqaPadre(nodo,nodo.getPadre());
                    }
                    else{
                        hijoDeraPadre(padre,abuelo);
                        hijoDeraPadre(nodo,padre);
                    }
                }
            }
        }
        raizSplay = nodo;
    }
    public void eliminar(int elem){
        nodoSplay nodo = encontrarNodo(elem);
        eliminar(nodo);
    }
    private void eliminar(nodoSplay nodo){
        if(nodo == null){
            return;
        }
        accionSplay(nodo);
        if((nodo.getIzq()!=null)&&(nodo.getDer()!=null)){//hijos en ambos lados
            nodoSplay menor = nodo.getIzq();
            while(menor.getDer()!=null){
                menor = menor.getDer();
            }
            menor.setDer(nodo.getDer());
            nodo.getDer().setPadre(menor);
            nodo.getIzq().setPadre(null);
            raizSplay = nodo.getIzq();
        }
        else if(nodo.getDer()!=null){//hijos solo en la derecha
            nodo.getDer().setPadre(null);
            raizSplay = nodo.getDer();
        }
        else if(nodo.getIzq()!=null){//hijos solo en la izq
            nodo.getIzq().setPadre(null);
            raizSplay = nodo.getIzq();
        }
        else{
            raizSplay = null;//arbol solo tenia raiz
        }
        nodo.setPadre(null);
        nodo.setDer(null);
        nodo.setIzq(null);
        nodo = null;
        contador--;
    }
    public int getcontador(){
        return contador;
    }
    public boolean encontrar(int elemento){
        return encontrarNodo(elemento) != null;
    }
    private nodoSplay encontrarNodo(int elemento){
        nodoSplay actual = raizSplay;
        while(actual !=null){
            if(elemento<actual.getElemento()){
                actual = actual.getDer();
            }
            else if(elemento>actual.getElemento()){
                actual = actual.getIzq();
            }
            else {
                return actual;
            }
        }
        return null;
    }
    public void inOrden(){
        inOrden(raizSplay);
    }
    private void inOrden(nodoSplay raiz){
        if(raiz !=null){
            inOrden(raiz.getIzq());
            System.out.print(raiz.getElemento()+" ");
            inOrden(raiz.getDer());
        }
    }

}
