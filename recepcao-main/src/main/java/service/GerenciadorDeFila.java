package service;

import model.Paciente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciadorDeFila {

    private Map<String, Integer> contagemPacientesNivel = new HashMap<>();
    private List<Paciente> pacientes = new ArrayList<>();


    public GerenciadorDeFila() {
        contagemPacientesNivel.put("1", 0);
        contagemPacientesNivel.put("2", 0);
        contagemPacientesNivel.put("3", 0);
        contagemPacientesNivel.put("4", 0);
        contagemPacientesNivel.put("5", 0);
        contagemPacientesNivel.put("6", 0);

    }

    public Paciente chamarProxPaciente(String nome) {
        Paciente proximo = null;
        for (Paciente p : pacientes) {
            if (proximo == null
                    || Integer.parseInt(p.getNivel()) > Integer.parseInt(proximo.getNivel())) {
                proximo = p;
            }
        }
        if (proximo != null) {
            pacientes.remove(proximo);
            String nivel = proximo.getNivel();
            contagemPacientesNivel.put(nivel, contagemPacientesNivel.get(nivel) - 1);
        }
        return proximo;
    }



    public void registrarPaciente(String nome, String opcaoNivel) {
        if (contagemPacientesNivel.containsKey(opcaoNivel)) {
            pacientes.add(new Paciente(nome, opcaoNivel));
            contagemPacientesNivel.put(opcaoNivel, contagemPacientesNivel.get(opcaoNivel) + 1);
        }
    }
    public void exibirTodosPacientes() {
       System.out.println("-- Todas os(as) Pacientes --");
       for (Paciente paciente : pacientes) {
           System.out.println(paciente);
       }
    }
    public int getQuantidadePacientesNivel(String opcaoNivel) {
       return contagemPacientesNivel.getOrDefault(opcaoNivel, 0);
   }

    public void exibirRelatorioGeral() {
        System.out.println("\n--- RELATÓRIO DE PACIENTES POR NÍVEL ---");
        System.out.println("1. Não urgente:   " + contagemPacientesNivel.get("1"));
        System.out.println("2. Pouco urgente: " + contagemPacientesNivel.get("2"));
        System.out.println("3. Urgente:       " + contagemPacientesNivel.get("3"));
        System.out.println("4. Muito urgente: " + contagemPacientesNivel.get("4"));
        System.out.println("5. Emergência:    " + contagemPacientesNivel.get("5"));
        System.out.println("6. Total de pacientes:    " + contagemPacientesNivel.get("6"));
        System.out.println("----------------------------------------");
    }


    public Map<String, Integer> getContagemPacientesNivel() {
        return contagemPacientesNivel;
    }
}
