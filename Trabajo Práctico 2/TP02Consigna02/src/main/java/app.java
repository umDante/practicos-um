import clasesgenericas.Arreglogenerico;
import entidades.Celular;


public class app {
    public static void main(String[] args) {
    /*
    Cuando contrullo el Obj de la clase generico, es allí donde defino el obj que pasaré
     */

        Celular[] cel = new Celular[5];
        cel[0] = new Celular("marca1","16GB",200);
        cel[1]= new Celular("marca2","4GB",100);
        cel[2]= new Celular("marca3","8GB",150);
        cel[3]= new Celular("marca4","32GB",300);
        cel[4]= new Celular("marca5","32GB",300);

        //Arreglogenerico y sus métodos se adapta a Objeto pasado "Celular"
        Arreglogenerico<Celular> arreglogenerico1 = new Arreglogenerico<Celular>();
        
        arreglogenerico1.agregar(cel[0]);

        System.out.println(arreglogenerico1.getArregloGenerico().getMarca());

    }

}
