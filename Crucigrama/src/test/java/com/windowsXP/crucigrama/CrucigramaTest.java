package com.windowsXP.crucigrama;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CrucigramaTest {
    private Crucigrama crucigrama;

    @BeforeEach
    public void setUp() {
        String[] palabras = {"luz", "sol", "nube", "brisa"};
        crucigrama = new Crucigrama(palabras, 10);
    }

    // HU1: Inserción de palabras y ordenamiento
    @Test
    public void testPalabrasOrdenadasPorLongitud() {
        String[] palabras = {"sol", "montaña", "sol", "luz", "nube"};
        Crucigrama c = new Crucigrama(palabras, 10);
        assertEquals("montaña", c.palabras[0]); // longitud mayor
    }

    // HU2: Generación automática
    @Test
    public void testGeneraMatrizConPrimeraPalabra() {
        String[] palabras = {"montaña", "sol", "luz", "nube"};
        Crucigrama c = new Crucigrama(palabras, 10);
        char[][] matriz = c.matriz;
        boolean contiene = false;
        for (char ch : matriz[5]) {
            if (ch == 'M') {
                contiene = true;
                break;
            }
        }
        assertTrue(contiene);
    }

    // HU3: Validación de mínimo de palabras
    @Test
    public void testMenosDeCuatroPalabrasMuestraError() {
        String[] palabras = {"sol", "luz", "mar"};
        Crucigrama c = new Crucigrama(palabras, 10);
        // No hay assert directo porque el método solo imprime.
        // Debería rediseñarse para poder comprobar vía boolean.
    }

    // HU4: Tamaño de la matriz mínimo 10
    @Test
    public void testMatrizTamanioMinimo10x10() {
        Crucigrama c = new Crucigrama(new String[]{"sol", "luz", "nube", "aire"}, 5);
        assertEquals(10, c.getTamaño());
    }

    // HU6: Evita palabras duplicadas (opcional si implementas esta lógica)
    @Test
    public void testNoPermitePalabrasDuplicadas() {
        String[] palabras = {"sol", "sol", "luz", "nube"};
        Crucigrama c = new Crucigrama(palabras, 10);
        // Esta funcionalidad no está implementada aún.
        // Si la implementas con Set, deberías testear que solo hay 3 únicas.
    }

    // HU10: Crucigramas diferentes con las mismas palabras
    @Test
    public void testVariasGeneracionesDiferentes() {
        String[] palabras = {"luz", "nube", "aire", "sol"};
        Crucigrama c1 = new Crucigrama(palabras.clone(), 10);
        char[][] m1 = c1.matriz;

        Crucigrama c2 = new Crucigrama(palabras.clone(), 10);
        char[][] m2 = c2.matriz;

        boolean iguales = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (m1[i][j] != m2[i][j]) {
                    iguales = false;
                    break;
                }
            }
        }

        assertFalse(iguales); // Esperamos que la generación sea distinta
    }
}