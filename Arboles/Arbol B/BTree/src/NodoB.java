/**
 * Created by Gabriel on 4/30/2017.
 */
public class NodoB
{
    static int orden;  //orden del arbol
    int cantidad; //cantidad de llaves en un nodo
    int llaves[];  //array de llaves
    NodoB hijos[]; //array de hijos
    boolean hoja; //boolean que dice si es hoja o no
    NodoB padre;  //nodo padre

    public NodoB(){

    }

    public NodoB(int orden, NodoB parent)
    {
        this.orden = orden;

        this.padre = parent;

        llaves = new int[2*orden - 1];

        hijos = new NodoB[2*orden];

        hoja = true;

        cantidad = 0;
    }

    public int getllave(int index)
    {
        return llaves[index];
    }
    public NodoB gethijo(int index)
    {
        return hijos[index];
    }
    public void setllave(int index,int llave)
    {
         llaves[index]= llave;
    }
    public void sethijo(int index,NodoB nodo)
    {
         hijos[index]= nodo;
    }
    public void setPadre(NodoB padre) {
        this.padre = padre;
    }

    public boolean isHoja() {
        return hoja;
    }

    public int getCantidad() {
        return cantidad;
    }

    public static int getOrden() {
        return orden;
    }

    public NodoB getPadre() {
        return padre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setHoja(boolean hoja) {
        this.hoja = hoja;
    }

    public static void setOrden(int orden) {
        NodoB.orden = orden;
    }
}
