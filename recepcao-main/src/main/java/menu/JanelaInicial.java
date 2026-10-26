package menu;

import javax.swing.*;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

public class JanelaInicial extends JFrame {

    private final JTextField campoNome = new JTextField(12);
    private final JTextField campoIdade = new JTextField(4);
    private final JComboBox<Integer> comboNivel = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
    private final JTextArea areaLista = new JTextArea();

    // TEMPORÁRIO: depois troque pelo seu service
    private final List<String> pacientes = new ArrayList<>();

    public JanelaInicial() {
        super("Fila de espera");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);

        JButton botaoAdicionar = new JButton("Adicionar paciente");
        JButton botaoProximo = new JButton("Chamar próximo");
        areaLista.setEditable(false);

        JPanel topo = new JPanel();
        topo.add(new JLabel("Nome:"));
        topo.add(campoNome);
        topo.add(new JLabel("Idade:"));
        topo.add(campoIdade);
        topo.add(new JLabel("Nível:"));
        topo.add(comboNivel);
        topo.add(botaoAdicionar);

        JPanel rodape = new JPanel();
        rodape.add(botaoProximo);

        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(areaLista), BorderLayout.CENTER);
        add(rodape, BorderLayout.SOUTH);

        botaoAdicionar.addActionListener(e -> adicionar());
        botaoProximo.addActionListener(e -> chamarProximo());
    }

    private void adicionar() {
        try {
            String nome = campoNome.getText().trim();
            int idade = Integer.parseInt(campoIdade.getText().trim());
            int nivel = (Integer) comboNivel.getSelectedItem();

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Digite o nome.");
                return;
            }

            // TEMPORÁRIO: troque por service.adicionarPaciente(new Paciente(...))
            pacientes.add(nome + " - " + idade + " anos - nível " + nivel);

            atualizarLista();
            campoNome.setText("");
            campoIdade.setText("");
            campoNome.requestFocus();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Idade inválida.");
        }
    }

    private void chamarProximo() {
        if (pacientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fila vazia.");
            return;
        }
        // TEMPORÁRIO: troque por service.chamarProximo()
        String proximo = pacientes.remove(0);
        JOptionPane.showMessageDialog(this, "Próximo: " + proximo);
        atualizarLista();
    }

    private void atualizarLista() {
        areaLista.setText(String.join("\n", pacientes));
    }
}