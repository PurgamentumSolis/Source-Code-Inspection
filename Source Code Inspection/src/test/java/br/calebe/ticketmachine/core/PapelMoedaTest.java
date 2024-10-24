package br.calebe.ticketmachine.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PapelMoedaTest {

    @Test
    public void CriacaoPapelMoedaValoresValidosTeste() {
        PapelMoeda papelMoeda = new PapelMoeda(2, 1);
        assertEquals(2, papelMoeda.getValor(), "O valor deveria ser 2");
        assertEquals(1, papelMoeda.getQuantidade(), "A quantidade deveria ser 1");
    }

    @Test
    public void CriacaoPapelMoedaValoresInvalidosTeste() {
        PapelMoeda papelMoeda = new PapelMoeda(3, 1);
        assertEquals(3, papelMoeda.getValor(), "O valor deveria ser 3");
        assertEquals(1, papelMoeda.getQuantidade(), "A quantidade deveria ser 1");
    }

    @Test
    public void CriacaoPapelMoedaValoresNegativosTeste() {
        PapelMoeda papelMoeda = new PapelMoeda(-5, 1);
        assertTrue(papelMoeda.getValor() < 0, "O valor recebido e negativo");
    }

    @Test
    public void CriacaoPapelMoedaQuantidadeNegativosTeste() {
        PapelMoeda papelMoeda = new PapelMoeda(50, -1);
        assertTrue(papelMoeda.getQuantidade() < 0, "O valor recebido e negativo");
    }

}
