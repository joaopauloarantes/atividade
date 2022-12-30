 
public class ContaNormal extends Conta {
        
  public void creditar (double valor) {
    saldo = saldo + valor;
  }
  
  public void debitar (double valor) {  // Conta Normal não possui limite, logo em uma operação de débito apenas o saldo está disponível.
    if ((saldo-valor) >= 0) {
    	saldo = saldo - valor;
    }
	
  }
  @Override
  public int compareTo(Conta o) {
    // TODO Auto-generated method stub
    return numero.compareTo(o.getNumero());
  }
}

