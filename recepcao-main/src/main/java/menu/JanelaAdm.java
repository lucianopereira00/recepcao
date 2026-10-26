package menu;

import javax.swing.*;
import java.awt.BorderLayout;
import java.util.List;

public class JanelaAdm extends JFrame {

    private final JTextArea areaLista = new JTextArea();
    private final List<String> fila;

    public JanelaAdm(List<String> fila) {
        super("Administração da fila");
        this.fila = fila;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);

        areaLista.setEditable(false);

        JButton botaoProximo = new JButton("Chamar próximo");
        JButton botaoAtualizar = new JButton("Atualizar lista");

        JPanel rodape = new JPanel();
        rodape.add(botaoProximo);
        rodape.add(botaoAtualizar);

        add(new JScrollPane(areaLista), BorderLayout.CENTER);
        add(rodape, BorderLayout.SOUTH);

        botaoProximo.addActionListener(e -> chamarProximo());
        botaoAtualizar.addActionListener(e -> atualizarLista());

        atualizarLista();
    }

    private void chamarProximo() {
        if (fila.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fila vazia.");
            return;
        }
        // TEMPORÁRIO: troque por service.chamarProximo()
        String proximo = fila.remove(0);
        JOptionPane.showMessageDialog(this, "Próximo: " + proximo);
        atualizarLista();
    }

    private void atualizarLista() {
        areaLista.setText(String.join("\n", fila));
    }
}