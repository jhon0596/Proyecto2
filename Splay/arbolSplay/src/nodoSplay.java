/**
 * Created by Gabriel on 4/26/2017.
 */
public class nodoSplay {
    private nodoSplay izq, der, padre;
    private int elemento;

    nodoSplay(){
        this.elemento = 0;
        this.der = null;
        this.izq = null;
        this.padre = null;
    }
    nodoSplay(int elemento){
        this.elemento = elemento;
        this.der = null;
        this.izq = null;
        this.padre = null;
    }
    nodoSplay(int elemento,nodoSplay izq,nodoSplay der,nodoSplay padre){
        this.elemento = elemento;
        this.der = der;
        this.izq = izq;
        this.padre = padre;
    }

    public void setDer(nodoSplay der) {
        this.der = der;
    }

    public int getElemento() {
        return elemento;
    }

    public nodoSplay getDer() {
        return der;
    }

    public nodoSplay getIzq() {
        return izq;
    }

    public nodoSplay getPadre() {
        return padre;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public void setIzq(nodoSplay izq) {
        this.izq = izq;
    }

    public void setPadre(nodoSplay padre) {
        this.padre = padre;
    }
}
