package menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JanelaMenu extends JFrame {

    // TEMPORÁRIO: fila compartilhada entre as janelas (depois vira o service)
    private final List<String> fila = new ArrayList<>();

    public JanelaMenu() {
        super("Fila de espera - Entrar como");
        setDefaultCloseOperation(EXIT_ON_CLOSE);   // fechar o menu encerra o programa
        setSize(820, 500);
        setLocationRelativeTo(null);

        JButton botaoPaciente = new JButton("Paciente");
        botaoPaciente.setFont(new Font("Arial", Font.BOLD, 30));

        JButton botaoAdm = new JButton("Administrador");
        botaoAdm.setFont(new Font("Arial", Font.BOLD, 30));


        JPanel painel = new JPanel(new GridLayout(4, 1, 10, 10));
        JLabel titulo = new JLabel("Como deseja entrar?", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 35));
        painel.add(titulo);
        painel.add(botaoPaciente);
        painel.add(botaoAdm);
        add(painel);
        JButton botaoDesligar = new JButton("Desligar sistema");
        painel.add(botaoDesligar);
        botaoDesligar.setFont(new Font("Arial", Font.BOLD, 30));


        botaoDesligar.addActionListener(e -> System.exit(0));

        botaoPaciente.addActionListener(e -> new JanelaPaciente(fila).setVisible(true));
        botaoAdm.addActionListener(e -> new JanelaAdm(fila).setVisible(true));
    }
}