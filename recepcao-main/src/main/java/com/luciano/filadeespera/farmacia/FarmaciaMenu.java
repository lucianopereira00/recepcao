package com.luciano.filadeespera.farmacia;

import com.luciano.filadeespera.model.Pedido;
import com.luciano.filadeespera.model.PedidoRepository;
import com.luciano.filadeespera.model.Remedio;
import com.luciano.filadeespera.model.RemedioRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FarmaciaMenu {

    private Scanner scanner = new Scanner(System.in);
    private List<String> listaRemedios = new ArrayList<>();
    private List<String> pedidos = new ArrayList<>();
    private final RemedioRepository repository;
    private final PedidoRepository pedidoRepository;

    public FarmaciaMenu(RemedioRepository repository,  PedidoRepository pedidoRepository) {
        this.repository = repository;
        this.pedidoRepository = pedidoRepository;
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
        List<Remedio> remedios = repository.findAll();
        if (remedios.isEmpty()) {
            System.out.println("Nenhum remedio encontrado!");
        }
        for (Remedio r : remedios) {
            System.out.println("- "+r);
        }
    }

    private void realizarPedido() {
        System.out.print("Digite o nome do remedio: ");
        String nome = scanner.nextLine();
        Optional<Remedio> remedio = repository.findByNomeRemedioIgnoreCase(nome);
        if (remedio.isPresent()) {
            pedidoRepository.save(new Pedido(remedio.get()));
            System.out.println("Pedido realizado com sucesso!");
        } else {
            System.out.println("Nenhum remedio encontrado!");
        }
    }

    private void adicionar() {
        String opcao;
        do {
            System.out.print("Digite o nome do remedio: ");
            String nome = scanner.nextLine();
            if (repository.existsByNomeRemedio(nome)) {
                System.out.println("Este remedio ja existe!");
            } else {
                repository.save(new Remedio(nome));
                System.out.println("Remédio adicionado com sucesso!");
            }
            System.out.println("Deseja adicionar um remedio para um pedido? [S/N]");
            opcao = scanner.nextLine();

        } while (opcao.equalsIgnoreCase("S"));
            if (opcao.equalsIgnoreCase("n")) {
                System.out.print("Retornando ao menu inical da farmacia...");
            }
    }

    private void remover() {
        String opcao;
        do {
            System.out.print("Digite o nome do remedio: ");
            String nome = scanner.nextLine();
            if (listaRemedios.remove(nome)) {
                System.out.println("Remedio removido com sucesso!");
            } else {
                System.out.println("Nenhum remedio encontrado!");
            }
            System.out.println("Deseja remover um remedio? [S/N]");
            opcao = scanner.nextLine();

        }while (opcao.equalsIgnoreCase("S"));
        if (opcao.equalsIgnoreCase("n")) {
            System.out.print("Retornando ao menu inical da farmacia...");
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
