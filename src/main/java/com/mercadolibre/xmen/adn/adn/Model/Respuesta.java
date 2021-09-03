package com.mercadolibre.xmen.adn.adn.Model;

import java.util.Arrays;

public class Respuesta {

    private String[] adn;

    public String[] getAdn() {
        return adn;
    }

    public void setAdn(String[] adn) {
        this.adn = adn;
    }

    @Override
    public String toString() {
        return "Respuesta [adn=" + Arrays.toString(adn) + "]";
    }    
    
}
