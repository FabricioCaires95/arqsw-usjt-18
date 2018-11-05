package Ex09.atv02;

public class Handler implements HandlerChain {
	
	HandlerChain nextChain;
	long tempoUltimaReq;
	int num;
	boolean ocupado;
	
	public Handler(int num) {
		this.num = num;
		this.tempoUltimaReq = 0;
		this.ocupado = false;
	}

	@Override
	public void setNextChain(HandlerChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void handleRequest(int requisicao) {
		
		if (this.tempoUltimaReq == 0) {
			this.tempoUltimaReq = System.currentTimeMillis();
		}
		
		if (System.currentTimeMillis() - this.tempoUltimaReq > 200 && this.ocupado) this.ocupado = false;				
		
		if (!this.ocupado) {
			System.out.println("Requisi��o '" + requisicao + "' atendida no handler " + this.num + ".");
			this.tempoUltimaReq = System.currentTimeMillis();
			this.ocupado = true;
		} else {
			if(nextChain != null) {
				nextChain.handleRequest(requisicao);
			} else {
				System.out.println("Tempo limite esgotado: requisi��o cancelada.");
			}
		}
	}

}
