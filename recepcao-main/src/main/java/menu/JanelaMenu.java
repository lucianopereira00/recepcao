package menu;

import javax.swing.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class JanelaMenu extends JFrame {

    // TEMPORÁRIO: fila compartilhada entre as janelas (depois vira o service)
    private final List<String> fila = new ArrayList<>();

    public JanelaMenu() {
        super("Fila de espera - Entrar como");
        setDefaultCloseOperation(EXIT_ON_CLOSE);   // fechar o menu encerra o programa
        setSize(320, 200);
        setLocationRelativeTo(null);

        JButton botaoPaciente = new JButton("Paciente");
        JButton botaoAdm = new JButton("Administrador");

        JPanel painel = new JPanel(new GridLayout(3, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        painel.add(new JLabel("Como deseja entrar?", SwingConstants.CENTER));
        painel.add(botaoPaciente);
        painel.add(botaoAdm);
        add(painel);

        botaoPaciente.addActionListener(e -> new JanelaPaciente(fila).setVisible(true));
        botaoAdm.addActionListener(e -> new JanelaAdm(fila).setVisible(true));
    }
}