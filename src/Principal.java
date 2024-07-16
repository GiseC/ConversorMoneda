
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        Scanner respuesta = new Scanner(System.in);        
        ConvertirDinero consulta = new ConvertirDinero();
        boolean band = true;
        
        //menu
        while(band){
            System.out.println("***************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda");
            System.out.println("");
            System.out.println("1) Dolar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dolar");
            System.out.println("3) Dolar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dolar");
            System.out.println("5) Dolar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dolar");
            System.out.println("7) Salir");
            System.out.println("Elija una opcion valida");
            System.out.println("***************************************");
                         
            try{
                var rta = Integer.valueOf(respuesta.nextLine());
                if (rta == 7){
                    band = false;
                } else if (rta > 0 && rta < 7) {
                    System.out.println("Ingrese el monto a convertir");
                    var monto = Double.valueOf(respuesta.nextLine());
                    Dinero cambio = consulta.convertir(rta, monto);
                    System.out.println("El resultado de la conversion es: " + cambio.conversion_result());
                } else {
                    System.out.println("Ingrese una opcion valida!!!");
                }
                //eneradorArchivo generador = new GeneradorArchivo();
                //generador.guardarJson(pelicula);
            } catch (NumberFormatException ex){
                System.out.println("opcion no valida"+ex.getMessage());
            } catch (RuntimeException ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Fin del programa");
    }
    
}
