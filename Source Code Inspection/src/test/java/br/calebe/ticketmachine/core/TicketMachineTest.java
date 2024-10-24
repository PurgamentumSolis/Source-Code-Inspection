import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

public class TicketMachineTest {

    @Test
    public void testInserirValorValido() throws PapelMoedaInvalidaException {
        TicketMachine tm = new TicketMachine(50);
        tm.inserir(10);
        assertEquals(10, tm.getSaldo());
    }

    @Test
    public void testInserirValorInvalido() {
        TicketMachine tm = new TicketMachine(50);
        assertThrows(PapelMoedaInvalidaException.class, () -> {
            tm.inserir(3); // valor inválido
        });
    }

    @Test
    public void testImprimirComSaldoSuficiente() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
        TicketMachine tm = new TicketMachine(20);
        tm.inserir(20); // saldo suficiente para o valor do ticket
        String impressao = tm.imprimir();
        assertEquals("*****************\n*** R$ 20,00 ****\n*****************\n", impressao);
    }

    @Test
    public void testImprimirComSaldoInsuficiente() throws PapelMoedaInvalidaException {
        TicketMachine tm = new TicketMachine(50);
        tm.inserir(20); // saldo insuficiente para o valor do ticket
        assertThrows(SaldoInsuficienteException.class, () -> {
            tm.imprimir();
        });
    }

    @Test
    public void testTroco() throws PapelMoedaInvalidaException {
        TicketMachine tm = new TicketMachine(20);
        tm.inserir(50); // insere mais do que o valor do ticket
        Iterator<Integer> troco = tm.getTroco();

        assertTrue(troco.hasNext());
        assertEquals(50, troco.next()); // o troco deveria ser 50

        assertFalse(troco.hasNext()); // sem mais troco
        assertEquals(0, tm.getSaldo()); // saldo deve ser zerado
    }
}
