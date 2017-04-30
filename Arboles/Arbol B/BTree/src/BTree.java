/**
 * Created by Gabriel on 4/30/2017.
 */
public class BTree
{


    static int orden; // orden del arbol
    NodoB raiz;  //raiz del arbol

    public BTree(int orden)
    {
        this.orden = orden;

        raiz = new  NodoB(orden, null);

    }

    public  NodoB buscar( NodoB raiz, int llave)
    {
        int i = 0;//indice de busqueda

        while(i < raiz.getCantidad() && llave > raiz.getllave(i))
        {
            i++;
        }

        if(i <= raiz.getCantidad() && llave == raiz.getllave(i))
        {


            return raiz;
        }

        if(raiz.isHoja())
        {

            return null ;

        }
        else
        {

            return buscar(raiz.gethijo(i),llave);

        }
    }
    public void dividir( NodoB x, int i,  NodoB y)//funcion que divide el arbol una vez que ya supero su cantidad de llaves
    {
        NodoB z = new  NodoB(orden,null);

        z.setHoja(y.isHoja());

        z.setCantidad(orden-1);

        for(int j = 0; j < orden - 1; j++)
        {
            z.setllave(j,y.getllave(j+orden));

        }
        if(!y.isHoja())
        {
            for(int k = 0; k < orden; k++)
            {
                z.sethijo(k,y.gethijo(k+orden));
            }
        }

        y.setCantidad(orden - 1);

        for(int j = x.getCantidad() ; j> i ; j--)
        {
            x.sethijo(j+1,x.gethijo(j));

        }
        x.sethijo(i+1,z);

        for(int j = x.getCantidad(); j> i; j--)
        {
            x.setllave(j+1,x.getllave(j));
        }
        x.setllave(i,y.getllave(orden-1));

        y.setllave(orden-1,0);

        for(int j = 0; j < orden - 1; j++)
        {
            y.setllave(j+orden,0);
        }
        x.setCantidad(x.getCantidad()+1);
    }

    public void InsercionNollena( NodoB x, int llave)//insercion que se usa cuando el nodo aun puede recivir llaves
    {
        int i = x.getCantidad();

        if(x.isHoja())
        {
            while(i >= 1 && llave < x.getllave(i-1))
            {
                x.setllave(i,x.getllave(i-1));

                i--;
            }

            x.setllave(i,llave);
            x.setCantidad(x.getCantidad()+1);

        }


        else
        {
            int j = 0;
            while(j < x.getCantidad()  && llave > x.getllave(j))
            {
                j++;
            }

            //	i++;

            if(x.gethijo(j).getCantidad() == orden*2 - 1)
            {
                dividir(x,j,x.gethijo(j));

                if(llave > x.getllave(j))
                {
                    j++;
                }
            }

            InsercionNollena(x.gethijo(j),llave);
        }
    }

    public void insertar(BTree t, int llave)
    {
        NodoB r = t.raiz;
        if(r.getCantidad() == 2*orden - 1)
        {
            NodoB s = new  NodoB(orden,null);
            t.raiz = s;
            s.setHoja(false);
            s.setCantidad(0);
            s.sethijo(0,r);
            dividir(s,0,r);
            InsercionNollena(s, llave);
        }
        else
            InsercionNollena(r,llave);
    }

    public void imprimir( NodoB n)
    {
        for(int i = 0; i < n.getCantidad(); i++)
        {
            System.out.print(n.getllave(i)+" " );
        }

        if(!n.isHoja())
        {

            for(int j = 0; j <= n.getCantidad()  ; j++)
            {
                if(n.gethijo(j) != null)
                {
                    System.out.println();
                    imprimir(n.gethijo(j));
                }
            }
        }
    }

    public void ImprimirnodoEspecifico( BTree T,int x)
    {
        NodoB temp= new  NodoB (orden,null);

        temp= buscar(T.raiz,x);

        if (temp==null)
        {

            System.out.println("Llave no existente");
        }

        else
        {

            imprimir(temp);
        }


    }
    public void deleteKey(BTree t, int key)
    {

        NodoB temp = new  NodoB(orden,null);

        temp = buscar(t.raiz,key);

        if(temp.isHoja() && temp.getCantidad() > orden - 1)
        {
            int i = 0;

            while( key > temp.getllave(i))
            {
                i++;
            }
            for(int j = i; j < 2*orden - 2; j++)
            {
                temp.setllave(j,temp.getllave(j+1));
            }
            temp.setCantidad(temp.getCantidad()-1);

        }
        else
        {
            System.out.println("error");
        }
    }
}
