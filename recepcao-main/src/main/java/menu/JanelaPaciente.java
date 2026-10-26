package menu;

import javax.swing.*;
import java.awt.GridLayout;
import java.util.List;

public class JanelaPaciente extends JFrame {

    private final JTextField campoNome = new JTextField(15);
    private final JTextField campoIdade = new JTextField(4);
    private final JComboBox<Integer> comboNivel = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
    private final List<String> fila;

    public JanelaPaciente(List<String> fila) {
        super("Cadastro de paciente");
        this.fila = fila;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  // fecha só esta janela
        setSize(320, 220);
        setLocationRelativeTo(null);

        JButton botaoCadastrar = new JButton("Cadastrar");

        JPanel painel = new JPanel(new GridLayout(4, 2, 8, 8));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(new JLabel("Idade:"));
        painel.add(campoIdade);
        painel.add(new JLabel("Nível:"));
        painel.add(comboNivel);
        painel.add(new JLabel());
        painel.add(botaoCadastrar);
        add(painel);

        botaoCadastrar.addActionListener(e -> cadastrar());
    }

    private void cadastrar() {
        try {
            String nome = campoNome.getText().trim();
            int idade = Integer.parseInt(campoIdade.getText().trim());
            int nivel = (Integer) comboNivel.getSelectedItem();

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Digite o nome.");
                return;
            }

            // TEMPORÁRIO: troque por service.adicionarPaciente(new Paciente(...))
            fila.add(nome + " - " + idade + " anos - nível " + nivel);

            JOptionPane.showMessageDialog(this, "Paciente cadastrado!");
            campoNome.setText("");
            campoIdade.setText("");
            campoNome.requestFocus();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Idade inválida.");
        }
    }
}