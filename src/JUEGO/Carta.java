package JUEGO;

import java.util.ArrayList;
import java.util.Collections;

class Carta {
	private String nombre;
    private String clase;
    private String carril;
    private String alcance;
    private String recurso;
    private String rareza; 

    public Carta(String nombre, String clase, String carril, String alcance, String recurso, String rareza) {
        this.nombre = nombre;
        this.clase = clase;
        this.carril = carril;
        this.alcance = alcance;
        this.recurso = recurso;
        this.rareza = rareza;
    }

    // Getters para nombre, clase, carril, alcance, recurso y rareza.
    public String getNombre() {
        return nombre;
    }

    public String getClase() {
        return clase;
    }
    
    public String getCarril() {
        return carril;
    }
    
    public String getAlcance() {
        return alcance;
    }
    
    public String getRecurso() {
        return recurso;
    }

    public String getRareza() {
        return rareza;
    }
}

class Baraja {
    private ArrayList<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
        // Crear cartas de ejemplo (puedes añadir muchas más).
        cartas.add(new Carta("Alistar", "Vanguardia", "Soporte", "Cuerpo a cuerpo", "Maná", "Común"));
        cartas.add(new Carta("Alistar", "Vanguardia", "Soporte", "Cuerpo a cuerpo", "Maná", "Rara"));
        cartas.add(new Carta("Amumu", "Vanguardia", "Jungla", "Cuerpo a cuerpo", "Maná", "Común"));
        cartas.add(new Carta("Amumu", "Vanguardia", "Jungla", "Cuerpo a cuerpo", "Maná", "Rara"));
        cartas.add(new Carta("Annie", "Mago de ráfaga", "Central", "Distancia", "Maná", "Común"));
        cartas.add(new Carta("Annie", "Mago de ráfaga", "Central", "Distancia", "Maná", "Rara"));
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public ArrayList<Carta> abrirSobre(int cantidad) {
        ArrayList<Carta> sobre = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            if (!cartas.isEmpty()) {
                sobre.add(cartas.remove(0));
            }
        }
        return sobre;
    }
}