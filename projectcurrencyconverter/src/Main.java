import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String menu = "Bienvenidos al conversor de monedas\n"+
                      "1) Dólar ===> Peso Colombiano \n" +
                      "2) Peso Colombiano ===> Dólar \n" +
                      "3) Euro ===> Peso Colombiano \n" +
                      "4) Peso Colombiano ===> Euro \n" +
                      "5) Euro ===> Peso Colombiano \n" +
                      "6) Peso Colombiano ===> Euro \n" +
                      "7) Salir \n";

        Conversion option_conversion = new Conversion();
        double rate = 0.0;
        var option = -1;
        var value = 0.0;
        while (true){
            try{
                System.out.println("*********************************\n"+menu);
                System.out.println("*********************************");
                System.out.println("Selecciones la opción de su preferencia");
                option = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Por favor ingresa una opción válida");
                scanner.next();
            }

            if(option < 0 | option > 7){
                System.out.println("Por favor ingresa una opción válida");
            } else if (option == 7){
                System.out.println("Ha sido un placer servirte");
                break;
            }else {
                String coins = option_conversion.conversion(option);
                rate = new SearchCoin().searchRate(coins);
                System.out.println("Ingrese el monto que desea convertir \n" +
                                   "[Asegurate que sea un valor válido]");
                do{
                    try{
                        value = scanner.nextDouble();
                    }catch (InputMismatchException e){
                        System.out.println("Ingrese un valor válido");
                    }
                }while (value <= 0.0);
                System.out.println("El monto convertido equivale a: $" + (value *=rate));
            }
        }
    }
}
