package br.com.glendson.cm.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.glendson.cm.modelo.Tabuleiro;

public class PainelTabuleiro extends JPanel {

    public PainelTabuleiro(Tabuleiro tabuleiro) {
        setLayout(new GridLayout(
                tabuleiro.getLinhas(),
                tabuleiro.getColunas()));

        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));

        tabuleiro.registrarObservador(resultado -> {
            SwingUtilities.invokeLater(() -> {

                if (resultado.isGanhou()) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Parabéns! Você ganhou!",
                            "Ganhou",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Que pena! Você perdeu!",
                            "Perdeu",
                            JOptionPane.ERROR_MESSAGE);
                }

                tabuleiro.reiniciar();
            });

        });
    }
}
