package com.rmbraga.builders;

import com.rmbraga.Carro;
import org.junit.jupiter.api.Test;

import static com.rmbraga.enums.Carroceria.CONVERSIVEL;
import static com.rmbraga.enums.Carroceria.SUV;
import static com.rmbraga.enums.Cor.BRANCO;
import static com.rmbraga.enums.Montadora.BMW;
import static com.rmbraga.enums.Montadora.VOLKSWAGEN;
import static org.junit.jupiter.api.Assertions.*;

class FluentBuilderCarroTest {

    @Test
    void fluentBuilderCarroSemMontadoraTest() {
        assertThrows(IllegalArgumentException.class, () -> new FluentBuilderCarro(null, SUV));
    }

    @Test
    void fluentBuilderCarroSemCarroceriaTest() {
        assertThrows(IllegalArgumentException.class, () -> new FluentBuilderCarro(BMW, null));
    }

    @Test
    void fluentBuilderCarroTest() {
        final int numLugares = 5;
        final int ano = 2008;

        Carro carro = new FluentBuilderCarro(VOLKSWAGEN, CONVERSIVEL)
                .setCor(BRANCO)
                .setAno(ano)
                .setNumeroDeLugares(numLugares)
                .buildCarro();

        assertNotNull(carro);
        assertNotNull(carro.toString());
        assertEquals(carro.getMontadora(), VOLKSWAGEN);
        assertEquals(carro.getCarroceria(), CONVERSIVEL);
        assertEquals(carro.getCor(), BRANCO);
        assertEquals(carro.getAno(), ano);
        assertEquals(carro.getNumeroDeLugares(), numLugares);
    }
}