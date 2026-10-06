package service;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeFila {

   private Map<String, Integer> contagemPacientesNivel = new HashMap<>();

   public GerenciadorDeFila() {
       contagemPacientesNivel.put("1", 0);
       contagemPacientesNivel.put("2", 0);
       contagemPacientesNivel.put("3", 0);
       contagemPacientesNivel.put("4", 0);
       contagemPacientesNivel.put("5", 0);
   }

   public void registrarPaciente(String opcaoNivel) {
       if(contagemPacientesNivel.containsKey(opcaoNivel)){
           contagemPacientesNivel.put(opcaoNivel, contagemPacientesNivel.get(opcaoNivel) + 1);
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
        System.out.println("----------------------------------------");
    }

    public Map<String, Integer> getContagemPacientesNivel() {
        return contagemPacientesNivel;
    }
}
