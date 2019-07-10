/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Taffarel <taffarel_deus@hotmail.com>
 */
public class Alunos {

    public static ResultSet getDadosAlunos(int alunoId) throws SQLException, Exception {

        PreparedStatement stmt = Conexao.abrir().prepareStatement("SELECT alu_id, alu_nome, alu_data_nasicmento,"
                + " turma_nome,alu_senha FROM alunos as t1 JOIN turmas as t2 on t1.alu_turma = t2.turma_id WHERE t1.alu_id = ? LIMIT 1;");

        stmt.setInt(1, alunoId);

        ResultSet rs = stmt.executeQuery();

        return rs;
    }

    /**
     *
     * @param alunoId
     * @param novaSenha
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static int alterarSenha(int alunoId, String novaSenha) throws SQLException, Exception {

        PreparedStatement stmt = Conexao.abrir().prepareStatement("UPDATE alunos SET `alu_senha` = ? WHERE `alu_id` = ?;",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        stmt.setInt(2, alunoId);

        stmt.setString(1, novaSenha);

        return stmt.executeUpdate();
    }


}
