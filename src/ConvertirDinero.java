
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertirDinero {
    public Dinero convertir (int opcion, double monto){
        String entrada = "";
        String salida = "";
        switch (opcion){
            case 1:
                entrada = "USD";
                salida = "ARS";
                break;
            case 2:
                entrada = "ARS";
                salida = "USD";
                break;
            case 3:
                entrada = "USD";
                salida = "BRL";
                break;
            case 4:
                entrada = "BRL";
                salida = "USD";
                break;
            case 5:
                entrada = "USD";
                salida = "COP";
                break;
            case 6:
                entrada = "COP";
                salida = "USD";
                break;
            default:
                break;
        }

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/62b00408c94d03b9453ae3a8/pair/" + entrada + "/" + salida +"/" + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
         .uri(direccion)
         .build();
       
        try { 
            HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Dinero.class);
                   
        } catch (Exception ex) {
            throw new RuntimeException("opcion no encontrada");
        }
    }
}
