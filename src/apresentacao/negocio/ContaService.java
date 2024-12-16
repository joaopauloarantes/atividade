package negocio;

import acesso_a_dado.ContaDAO;
import java.util.List;

public class ContaService {
    private ContaDAO contaDAO;

    public ContaService() {
        this.contaDAO = new ContaDAO();
    }

    public void adicionarConta(String titular, double saldo) {
        Conta conta = new Conta();
        conta.setTitular(titular);
        conta.setSaldo(saldo);
        contaDAO.salvar(conta);
    }

    public List<Conta> listarContas() {
        return contaDAO.listar();
    }
}
