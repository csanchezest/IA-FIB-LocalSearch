import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int nCentros = input.nextInt();
        int nGas = input.nextInt();
        Estado estadoInicial = new Estado(nCentros, nGas, 1, 1, 2);

        input.close();
        



    }
}
