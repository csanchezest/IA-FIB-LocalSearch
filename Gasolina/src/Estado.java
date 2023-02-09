import java.util.ArrayList;
import java.util.Vector;


import IA.Gasolina.CentrosDistribucion;
import IA.Gasolina.Distribucion;
import IA.Gasolina.Gasolinera;
import IA.Gasolina.Gasolineras;
import aima.util.Pair;

public class Estado {

    //COMENTARIO 1: Para alguno de los experimentos, habrá que cambiar el valor de las restricciones (Experimento 6, creo), por lo tanto no pueden ser final
    //PROPUESTA: crear una clase aparte para las constantes y generarles métodos setX() para cambiar los valores
    protected static final Integer maxKilometros = 640;
    protected static final Integer maxViajes = 5;
    protected static final Integer precioDeposito = 1000;
    protected static final Integer costeKm = 2;

    
    //coordenadas de los centros de distribucion, tambien de los diferentes camiones que hay en el mapa. 
    protected static CentrosDistribucion centrosDistribucion;
    protected static Gasolineras gasolineras;

    //COMENTARIO 2: el tipo INTEGER es la objetivizacion del tipo de datos int, es decir, es una manera más costosa en cuanto a memoria de referirse a ints
    //PROPUESTA: cambiar Integer por int
    
    //coste mem = O(c*g)
    protected static Integer[][] distCentro2Gas;
    //pos[i][j] -> distancia del centro i a la gasolinera j
    //pos[0..c-1][0--g-1]

    protected static Integer[][] distGas2Gas;

    //COMENTARIO 3: tener en consideracion si verdaderamente necesitamos expresar las matrices/vectores como Vector, o hacerlas con [] 
    //(tener en consideracion que Vector tiene un coste superior en cuanto a memoria)
    //Vector tiene interes para añadir o quitar elementos de manera mas sencilla a nivel de codificacion, [] nos permite acceder (y modificar) a cada paso de manera mas eficiente
    //Propuesta: tomar una decision una vez veamos cuales operadores son mas necesarios y como encajan con la representacion de los datos
    
    //Para el camion i, tenemos el vector de coordenadas de la ruta que hace.
    //El coste memoria = O(c*g)
    protected Vector<Vector<Pair>> truckTrack;


    //En cada posicion nos indica los kilometros recorridos por cada camion
    protected Integer[] truckInfoKm;

    //En cada posicion nos indica los viajes recorridos por cada camion. 
    protected Integer[] truckInfoViajes;

    //estas ganancias se calculan a partir de el beneficio total de rellenar los depositos.
    protected Integer gananciasTotales;

    //estos son los gastos totales que se generan a partir del coste de ruta de todos los camiones. 
    protected Integer gastosTotales; 
    //DUDAS
    //Por si queremos hilar mas fino a la hora de generacion de hijos y heuristicas. 
    protected Integer[] gananciaParticulares;

    protected Integer[] gastosParticulares;

    protected void initializeFields(int nCamiones) {
        gananciasTotales = 0;
        gastosTotales = 0;
        gananciaParticulares = new Integer[nCamiones];
        gastosParticulares = new Integer[nCamiones];
        truckInfoKm = new Integer[nCamiones];
        truckInfoViajes = new Integer[nCamiones];
        truckTrack = new Vector<Vector<Pair>>(nCamiones);


        for (int i = 0; i < nCamiones; ++i) {
            truckInfoKm[i] = 0;
            truckInfoViajes[i] = 0;
            gananciaParticulares[i] = 0;
            gastosParticulares[i] = 0;
        }
    }

    protected Integer getDist(int coordX, int coordY, int coordX1, int coordY1) {
        return (Math.abs(coordX1-coordX) + Math.abs(coordY1 - coordY));
    }

    protected void generateDistCentros2Gas(int nCentros, int nGas) {
        //code here
        distCentro2Gas = new Integer[nCentros][nGas];      
        for (int i = 0; i < centrosDistribucion.size(); ++i) {
            Distribucion camion = centrosDistribucion.get(i);
            for (int j = 0; j < gasolineras.size(); ++j) {
                Gasolinera gas = gasolineras.get(j);
                distCentro2Gas[i][j] = getDist(camion.getCoordX(), camion.getCoordY(), gas.getCoordX(), gas.getCoordY());
            }
        }

    }

    protected void generateDistGas2Gas(int nGas) {
        //code here
        distGas2Gas = new Integer[nGas][nGas];      
        for (int i = 0; i < gasolineras.size(); ++i) {
            Gasolinera gas1 = gasolineras.get(i);
            for (int j = 0; j < gasolineras.size(); ++j) {
                Gasolinera gas2 = gasolineras.get(j);
                distGas2Gas[i][j] = getDist(gas1.getCoordX(), gas1.getCoordY(), gas2.getCoordX(), gas2.getCoordY());
            }
        }
    }
    
    public Estado(int nCentros, int nGas, int mult, int seedCentros, int seedGasolineras) {

        Pair a = new Pair(1, 1);
        System.out.println((Integer)a.getFirst() + 1);

        centrosDistribucion = new CentrosDistribucion(nCentros, mult, seedCentros);
        gasolineras = new Gasolineras(nGas, seedGasolineras);
        generateDistCentros2Gas(nCentros, nGas);
        generateDistGas2Gas(nGas);
        initializeFields(nCentros*mult);
    }



  


    //COMENTARIOS A PARTE (para no olvidarme): 
    //Dependiendo de los operadores de los que hagamos uso, la solucion vacia (los camiones no responden a ninguna solicitud) seria valida (podriamos tener una 3a manera de generar un estado solucion inicial)
    //Para el experimento (de la semana del 18), da igual lo malos que sean los resultados obtenidos, es suficiente para obtener el punto
    //No se puede tocar ninguna clase de las que nos han dado
    //No hace falta relacionar explicitamente las posiciones de los vectors/matrices con las gasolineras/centros de distribucion/camiones
    
    
    




    
}
