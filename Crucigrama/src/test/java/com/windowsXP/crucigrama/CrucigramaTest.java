package crucigrama;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CrucigramaTest {
    private Crucigrama crucigrama;
    private final String[] palabrasEjemplo = {"java", "python", "programacion", "testing"};

    @BeforeEach
    void setUp() {
        crucigrama = new Crucigrama(palabrasEjemplo, 15);
    }

    @Test
    void testTamañoMinimo() {
        Crucigrama pequeño = new Crucigrama(palabrasEjemplo, 5);
        assertEquals(10, pequeño.getTamaño(), "Debería usar tamaño mínimo 10");
    }

    @Test
    void testMatrizInicializada() {
        char[][] matriz = crucigrama.getMatriz();
        for (int i = 0; i < crucigrama.getTamaño(); i++) {
            for (int j = 0; j < crucigrama.getTamaño(); j++) {
                assertTrue(matriz[i][j] == ' ' || Character.isLetter(matriz[i][j]),
                        "La matriz solo debe contener espacios o letras");
            }
        }
    }

    @Test
    void testPalabrasOrdenadas() {
        String[] palabras = crucigrama.getPalabras();
        for (int i = 0; i < palabras.length - 1; i++) {
            assertTrue(palabras[i].length() >= palabras[i+1].length(),
                    "Las palabras deberían estar ordenadas por longitud descendente");
        }
    }

    @Test
    void testPrimeraPalabraColocada() {
        char[][] matriz = crucigrama.getMatriz();
        boolean encontrada = false;
        String primeraPalabra = crucigrama.getPalabras()[0];

        // Buscar horizontalmente
        for (int i = 0; i < crucigrama.getTamaño(); i++) {
            for (int j = 0; j <= crucigrama.getTamaño() - primeraPalabra.length(); j++) {
                if (matriz[i][j] == primeraPalabra.charAt(0)) {
                    encontrada = true;
                    for (int k = 0; k < primeraPalabra.length(); k++) {
                        assertEquals(primeraPalabra.charAt(k), matriz[i][j+k],
                                "La palabra debería estar colocada correctamente");
                    }
                }
            }
        }
        assertTrue(encontrada, "La primera palabra debería estar colocada en la matriz");
    }
}