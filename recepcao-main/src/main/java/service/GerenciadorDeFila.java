package service;

import model.Paciente;

import java.io.File;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GerenciadorDeFila {

    private Map<String, Integer> contagemPacientesNivel = new HashMap<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private static final Path ARQUIVO = Path.of("pacientes.csv");

    public GerenciadorDeFila() {
        contagemPacientesNivel.put("1", 0);
        contagemPacientesNivel.put("2", 0);
        contagemPacientesNivel.put("3", 0);
        contagemPacientesNivel.put("4", 0);
        contagemPacientesNivel.put("5", 0);
        contagemPacientesNivel.put("6", 0);
        carregar();

    }

    public Paciente chamarProxPaciente() {
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
            salvar();
        }
        return proximo;
    }
    private void salvar() {
        List<String> linhas = new ArrayList<>();
        for (Paciente p : pacientes) {
            linhas.add(p.getNome() + " - " + p.getIdade() +" - "+  p.getNivel());
        }
        try {
            Files.write(ARQUIVO, linhas);

        }catch (IOException e) {
            System.out.println("Erro ao salvar arquivo"+ e.getMessage());
        }
    }

    private void carregar(){
        if (!Files.exists(ARQUIVO)) return ;
        try {
            for(String linha : Files.readAllLines(ARQUIVO)){
                String[] partes = linha.split("; ");
                if(partes.length == 3){
                    adicionar(partes[0], Integer.parseInt( partes[1]), partes[2]); ;
                }
            }
        }catch (IOException e){
            System.out.println("Erro ao carregar arquivo"+ e.getMessage());
        }
    }

    private void adicionar(String nome,int idade, String opcaoNivel) {
        if (contagemPacientesNivel.containsKey(opcaoNivel)) {
            pacientes.add(new Paciente(nome,idade, opcaoNivel));
            contagemPacientesNivel.put(opcaoNivel, contagemPacientesNivel.get(opcaoNivel) + 1);
        }
    }


    public void registrarPaciente(String nome,int idade, String opcaoNivel) {
        adicionar(nome,idade, opcaoNivel);
        salvar();
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
