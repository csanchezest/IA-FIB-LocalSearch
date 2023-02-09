import IA.Gasolina.Distribucion;
import IA.Gasolina.Gasolinera;
import aima.util.Pair;

public class EstadoInicialA extends Estado{
    
    private int getDistanceC2G(int i_camion, int i_gasolinera) {
        return distCentro2Gas[i_camion][i_gasolinera];
    }

    private Boolean canTravelCentroGasolinera(int i_camion, int i_gasolinera) {
        int distancia = getDistanceC2G(i_camion, i_gasolinera);
        if (2*distancia + truckInfoKm[i_camion] > maxKilometros && truckInfoViajes[i_camion] < maxViajes) {  
            return true;
        }
        return false;
    }

    private Boolean worthTravel() {
        //code here
        return false;
    }

    private void travel(int i_camion, int i_gas, int distancia) {
        updateTruckTrack(i_camion, i_gas);;
        truckInfoKm[i_camion] += distancia;
        truckInfoViajes[i_camion] += 1;

        //modify costes y beneficios generales y particulares
    }

    private void updateTruckTrack(int i_camion, int i_gasolinera) {
        Pair actPos = new Pair(centrosDistribucion.get(i_camion).getCoordX(), centrosDistribucion.get(i_camion).getCoordY());
        Pair newPos = new Pair(gasolineras.get(i_gasolinera).getCoordX(), gasolineras.get(i_gasolinera).getCoordY());
        truckTrack.get(i_camion).add(newPos);
        truckTrack.get(i_camion).add(actPos);
        

    }

    private void updatePeticiones(int i_gas) {
        //code here
    }


    private void generateTruckTrack() {
        for (int i_camion = 0; i_camion < centrosDistribucion.size(); ++i_camion) {
            for (int i_gas = 0; i_gas < gasolineras.size(); ++i_gas) {
                Gasolinera gas = gasolineras.get(i_gas);
                if (gas.getPeticiones().size() != 0) { //Tiene peticiones pendientes
                    if (canTravelCentroGasolinera(i_camion, i_gas) && worthTravel()) {
                        travel(i_camion, i_gas, 2*getDistanceC2G(i_camion, i_gas));
                        updatePeticiones(i_gas);                  
                    }
                }
            }
        }
    }

    public EstadoInicialA(int nCentros, int nGas, int mult, int seedCentros, int seedGasolineras) {
        super(nCentros, nGas, mult, seedCentros, seedGasolineras);
        this.generateTruckTrack();
        
    }
    
}
