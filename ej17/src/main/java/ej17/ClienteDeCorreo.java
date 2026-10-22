package ej17;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
    private Carpeta inbox;
    private List<Carpeta> carpetas;

    public ClienteDeCorreo(){
        inbox = new Carpeta("inbox");
        this.carpetas = new ArrayList<>();
        this.carpetas.add(inbox);
    }

    public void recibir(Email email){
        inbox.agregar(email);
    }

    public Email buscar(String texto){
        return this.carpetas.stream()
                .map(carpeta -> carpeta.buscar(texto))
                .filter(email -> email != null)
                .findFirst()
                .orElse(null);
    }

    public int espacioOcupado(){
        return this.carpetas.stream()
                .mapToInt(Carpeta::espacioOcupado)
                .sum();
    }
}
