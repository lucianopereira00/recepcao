package farmacia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class farmaciaMenu {

    private Scanner scanner = new Scanner(System.in);
    private List<String> listaRemedios = new ArrayList<>();
    private List<String> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        new farmaciaMenu().menuFarmacia();
    }

    public void menuFarmacia() {
        int opcao;
        do {
            System.out.println("\nMenu Farmacia");
            System.out.println("1. Listar Remédios");
            System.out.println("2. Realizar pedidos");
            System.out.println("3. Adicionar remédio");
            System.out.println("4. Remover remédio");
            System.out.println("5. Buscar remédio");
            System.out.println("6. Ordenar remédios");
            System.out.println("0. Sair");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> listar();
                case 2 -> realizarPedido();
                case 3 -> adicionar();
                case 4 -> remover();
                case 5 -> buscar();
                case 6 -> ordenar();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    private void listar() {
        if (listaRemedios.isEmpty()) {
            System.out.println("Nenhum remedio encontrado!");
        }
        for (String remedio : listaRemedios) {
            System.out.println("- "+remedio);
        }
    }

    private void realizarPedido() {
        System.out.print("Digite o nome do remedio: ");
        String nome = scanner.nextLine();
        if (listaRemedios.contains(nome)) {
            pedidos.add(nome);
            System.out.println("Pedido realizado com sucesso!");
        } else {
            System.out.println("Nenhum remedio encontrado!");
        }
    }

    private void adicionar() {
        System.out.print("Digite o nome do remedio: ");
        String nome = scanner.nextLine();
        if (listaRemedios.contains(nome)) {
            System.out.println("Este remedio ja existe!");
        } else {
            listaRemedios.add(nome);
            System.out.println("Remedio adicionado com sucesso!");
        }
    }

    private void remover() {
        System.out.print("Digite o nome do remedio: ");
        String nome = scanner.nextLine();
        if (listaRemedios.remove(nome)) {
            System.out.println("Remedio removido com sucesso!");
        } else {
            System.out.println("Nenhum remedio encontrado!");
        }
    }


    private void buscar() {
        System.out.print("Digite o nome do remedio: ");
        String nome = scanner.nextLine();
        if (listaRemedios.contains(nome)) {
            System.out.println("Remedio buscado com sucesso!");
        } else {
            System.out.println("Nenhum remedio encontrado!");
        }
    }
    private void ordenar() {
        Collections.sort(listaRemedios);
        listar();
    }
}
