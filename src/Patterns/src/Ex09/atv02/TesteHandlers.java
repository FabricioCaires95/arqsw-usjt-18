package Ex09.atv02;


import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class TesteHandlers {

	public static void main(String[] args) {

		HandlerChain handler1 = new Handler(1);
		HandlerChain handler2 = new Handler(2);
		HandlerChain handler3 = new Handler(3);
		HandlerChain handler4 = new Handler(4);
		HandlerChain handler5 = new Handler(5);
		HandlerChain handler6 = new Handler(6);
		HandlerChain handler7 = new Handler(7);
		HandlerChain handler8 = new Handler(8);
		HandlerChain handler9 = new Handler(9);
		HandlerChain handler10 = new Handler(10);
		HandlerChain handler11 = new Handler(11);
		HandlerChain handler12 = new Handler(12);
		HandlerChain handler13 = new Handler(13);
		HandlerChain handler14 = new Handler(14);
		HandlerChain handler15 = new Handler(15);

		handler1.setNextChain(handler2);
		handler2.setNextChain(handler3);
		handler3.setNextChain(handler4);
		handler4.setNextChain(handler5);
		handler5.setNextChain(handler6);
		handler6.setNextChain(handler7);
		handler7.setNextChain(handler8);
		handler8.setNextChain(handler9);
		handler9.setNextChain(handler10);
		handler10.setNextChain(handler11);
		handler11.setNextChain(handler12);
		handler12.setNextChain(handler13);
		handler13.setNextChain(handler14);
		handler14.setNextChain(handler15);
		
		// 5 requisi��es
		for (int i = 0; i < 5; i++) {
			handler1.handleRequest(ThreadLocalRandom.current().nextInt(0, 10000 + 1));
		}
		
		// Espera 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Outras 16 requisi�oes (todos ir�o ficar ocupados e a �ltima ser� cancelada
		for (int i = 0; i < 16; i++) {
			handler1.handleRequest(ThreadLocalRandom.current().nextInt(0, 10000 + 1));
		}
		
		/*Requisi��o '339' atendida no handler 1.
		Requisi��o '453' atendida no handler 2.
		Requisi��o '6088' atendida no handler 3.
		Requisi��o '9823' atendida no handler 4.
		Requisi��o '3054' atendida no handler 5.

		Requisi��o '7542' atendida no handler 1.
		Requisi��o '8371' atendida no handler 2.
		Requisi��o '4984' atendida no handler 3.
		Requisi��o '5491' atendida no handler 4.
		Requisi��o '1279' atendida no handler 5.
		Requisi��o '7439' atendida no handler 6.
		Requisi��o '1766' atendida no handler 7.
		Requisi��o '1386' atendida no handler 8.
		Requisi��o '398' atendida no handler 9.
		Requisi��o '4311' atendida no handler 10.
		Requisi��o '7660' atendida no handler 11.
		Requisi��o '5415' atendida no handler 12.
		Requisi��o '1318' atendida no handler 13.
		Requisi��o '6680' atendida no handler 14.
		Requisi��o '7876' atendida no handler 15.
		Tempo limite esgotado: requisi��o cancelada.*/

	}

}
