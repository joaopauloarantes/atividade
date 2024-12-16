package acesso_a_dado;

import negocio.Conta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    public void salvar(Conta conta) {
        String sql = "INSERT INTO contas (titular, saldo) VALUES (?, ?)";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, conta.getTitular());
            stmt.setDouble(2, conta.getSaldo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Conta> listar() {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM contas";

        try (Connection conn = ConexaoDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                contas.add(new Conta(
                    rs.getInt("id"),
                    rs.getString("titular"),
                    rs.getDouble("saldo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contas;
    }
}
