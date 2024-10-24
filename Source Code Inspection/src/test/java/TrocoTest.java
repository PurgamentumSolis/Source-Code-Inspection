package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.core.Troco;
import br.calebe.ticketmachine.core.PapelMoeda;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;


import java.util.concurrent.TimeUnit;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class TrocoTest {


    @Test
    public void testeTrocoParaNota100() {
        Troco troco = new Troco(100);
        PapelMoeda[] papeisMoeda = troco.papeisMoeda;

        assertEquals(0, papeisMoeda[0].getQuantidade());
        assertEquals(0, papeisMoeda[1].getQuantidade());
        assertEquals(0, papeisMoeda[2].getQuantidade());
        assertEquals(0, papeisMoeda[3].getQuantidade());
        assertEquals(0, papeisMoeda[4].getQuantidade());
        assertEquals(1, papeisMoeda[5].getQuantidade());
    }
    @Test
    public void testeTrocoParaNota50() {
        Troco troco = new Troco(50);
        PapelMoeda[] papeisMoeda = troco.papeisMoeda;

        assertEquals(0, papeisMoeda[0].getQuantidade());
        assertEquals(0, papeisMoeda[1].getQuantidade());
        assertEquals(0, papeisMoeda[2].getQuantidade());
        assertEquals(0, papeisMoeda[3].getQuantidade());
        assertEquals(1, papeisMoeda[4].getQuantidade());
        assertEquals(0, papeisMoeda[5].getQuantidade());
    }
    @Test
    public void testeTrocoParaNota20() {
        Troco troco = new Troco(20);
        PapelMoeda[] papeisMoeda = troco.papeisMoeda;

        assertEquals(0, papeisMoeda[0].getQuantidade());
        assertEquals(0, papeisMoeda[1].getQuantidade());
        assertEquals(0, papeisMoeda[2].getQuantidade());
        assertEquals(1, papeisMoeda[3].getQuantidade());
        assertEquals(0, papeisMoeda[4].getQuantidade());
        assertEquals(0, papeisMoeda[5].getQuantidade());
    }

    /*@Test*/
    public void testeTrocoParaNota10() {
        Troco troco = new Troco(10);
        PapelMoeda[] papeisMoeda = troco.papeisMoeda;
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
            assertEquals(0, papeisMoeda[0].getQuantidade());
            assertEquals(0, papeisMoeda[1].getQuantidade());
            assertEquals(1, papeisMoeda[2].getQuantidade());
            assertEquals(0, papeisMoeda[3].getQuantidade());
            assertEquals(0, papeisMoeda[4].getQuantidade());
            assertEquals(0, papeisMoeda[5].getQuantidade());
        });
        
    }
    /*@Test*/
    /*@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)*/
    void testeTrocoParaNota5() {
        Troco troco = new Troco(5);
        PapelMoeda[] papeisMoeda = troco.papeisMoeda;

        assertEquals(0, papeisMoeda[0].getQuantidade());
        assertEquals(1, papeisMoeda[1].getQuantidade());
        assertEquals(0, papeisMoeda[2].getQuantidade());
        assertEquals(0, papeisMoeda[3].getQuantidade());
        assertEquals(0, papeisMoeda[4].getQuantidade());
        assertEquals(0, papeisMoeda[5].getQuantidade());
    }
    /*@Test*/
    public void testeTrocoParaNota2() {
        Troco troco = new Troco(2);
        PapelMoeda[] papeisMoeda = troco.papeisMoeda;

        assertEquals(1, papeisMoeda[0].getQuantidade());
        assertEquals(0, papeisMoeda[1].getQuantidade());
        assertEquals(0, papeisMoeda[2].getQuantidade());
        assertEquals(0, papeisMoeda[3].getQuantidade());
        assertEquals(0, papeisMoeda[4].getQuantidade());
        assertEquals(0, papeisMoeda[5].getQuantidade());
    }
    /*@Test*/
    public void testeTrocoParaNota12() {
        Troco troco = new Troco(12);
        PapelMoeda[] papeisMoeda = troco.papeisMoeda;

        assertEquals(1, papeisMoeda[0].getQuantidade());
        assertEquals(1, papeisMoeda[1].getQuantidade());
        assertEquals(1, papeisMoeda[2].getQuantidade());
        assertEquals(1, papeisMoeda[3].getQuantidade());
        assertEquals(1, papeisMoeda[4].getQuantidade());
        assertEquals(1, papeisMoeda[5].getQuantidade());
    }
    @Test
    public void testeTrocoQuandoNaoTemTroco() {
        Troco troco = new Troco(0);
        PapelMoeda[] papeisMoeda = troco.papeisMoeda;

        assertEquals(0, papeisMoeda[0].getQuantidade());
        assertEquals(0, papeisMoeda[1].getQuantidade());
        assertEquals(0, papeisMoeda[2].getQuantidade());
        assertEquals(0, papeisMoeda[3].getQuantidade());
        assertEquals(0, papeisMoeda[4].getQuantidade());
        assertEquals(0, papeisMoeda[5].getQuantidade());
    }

    @Test
    public void testeRetiraNotaCorreta () {
        Troco troco = new Troco(100);
        Iterator<PapelMoeda> iterator = troco.getIterator();
        PapelMoeda papel = iterator.next();
        assertNotNull(iterator.hasNext());
        assertEquals(100, papel.getValor());
    }
    @Test
    public void testeSeNaoTiverNota () {
        Troco troco = new Troco(0);
        Iterator<PapelMoeda> iterator = troco.getIterator();
        PapelMoeda papel = iterator.next();
        assertNull(iterator.hasNext());

    }
}
