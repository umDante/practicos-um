import entidades.Fecha;

public class app {

        public static void main(String[] args) {

                 Fecha fecha1 = new Fecha();
                 fecha1.inputFecha();

                 Fecha fecha2 = new Fecha();
                 fecha2.inputFecha();

                Fecha.compararFecha(fecha1,fecha2);

                 fecha1.outputFecha();
                 fecha2.outputFecha();

                 //Reutilozo el objeto con valores. 
                 fecha1.desplaZar();
        }

}
