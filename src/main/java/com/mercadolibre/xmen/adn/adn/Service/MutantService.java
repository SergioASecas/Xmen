package com.mercadolibre.xmen.adn.adn.Service;

import com.mercadolibre.xmen.adn.adn.Model.Respuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MutantService {

    private char[][] adn;
    private char[] letras;

    public ResponseEntity<Respuesta> getInRespuesta(Respuesta respuesta) {
        if (isMutant(respuesta.getAdn())) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else if (!isMutant(respuesta.getAdn())) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    public MutantService() {
        adn = new char[0][0];
        letras = new char[0];
    }

    private char[][] llenadoMatrizMutante(String[] dna) {
        for (int i = 0; i < dna.length; i++) {
            String palabra = dna[i];
            letras = palabra.toCharArray();
        }
        adn = new char[dna.length][letras.length];
        return adn;
    }

    private boolean validacionSecuencia(int contador) {
        return contador >= 4;
    }

    private void recorriendoSecuencia(String[] dna) {
        for (int i = 0; i < dna.length; i++) {
            String palabra = dna[i];
            letras = palabra.toCharArray();
            for (int j = 0; j < letras.length; j++) {
                char letra = letras[j];
                adn[i][j] = letra;
            }
        }
    }

    private boolean secuenciaHorizontal(String[] dna, int contador) {
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < letras.length; j++) {
                int filas = i + 1;
                int columnas = j + 1;
                if (filas < dna.length && columnas < letras.length) {
                    if (adn[i][j] == adn[i][columnas]) {
                        contador++;
                    }
                }
            }
            contador=1;
        }
        return validacionSecuencia(contador);
    }

    private boolean secuenciaVertical(String[] dna, int contador) {
        for (int i = 0; i < dna.length; i++) {
            int valori = i;
            for (int j = 0; j < letras.length; j++) {
                int filas = i + 1;
                int columnas = j + 1;
                if (filas < dna.length && columnas < letras.length) {
                    if (adn[i][j] == adn[i + 1][j]) {
                        contador++;
                    }
                    i++;
                }
            }
            i = valori;
        }
        return validacionSecuencia(contador);
    }

    private boolean secuenciaDiagonal(String[] dna, int contador) {
        int i=0;
        int j=0;
        int filas = i;
        int columnas = j;
        int valori;
        for (i=-1; i < dna.length-1; i++) {
            valori =i;
            for (j=0; j < letras.length; j++) {   
                filas++;
                columnas++; 
                i++;         
                if (filas < dna.length && columnas < letras.length) {
                    if (adn[i][j] == adn[filas][columnas]) {
                        contador++;
                    }
                }
            }
            i=valori;
            filas=0;
            columnas=0;
        }
        return validacionSecuencia(contador);
    }

    private boolean isMutant(String[] dna) {
        llenadoMatrizMutante(dna);
        recorriendoSecuencia(dna);
        int contador = 1;
        if (secuenciaHorizontal(dna, contador) || secuenciaVertical(dna, contador)
                || secuenciaDiagonal(dna, contador)) {
            return true;
        } else {
            return false;
        }

    }

}
