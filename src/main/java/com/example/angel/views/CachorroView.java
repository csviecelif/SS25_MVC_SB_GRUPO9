package com.pucpralunos.abrigo.views;

import java.util.List;
import java.util.Scanner;

import com.pucpralunos.abrigo.controllers.CachorroController;
import com.pucpralunos.abrigo.models.Cachorro;

public class CachorroView {
    private CachorroController controller = new CachorroController();
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        while (true) {
            System.err.println("\n\nMenu");
            System.err.println("\n1. Add cachorro");
            System.err.println("\n2. Listar cachorro");
            System.err.println("\n3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir qubera de linha

            switch (opcao) {
                case 1:
                    adicionarCachorro();
                    break;
                case 2:
                    List<Cachorro> cs = controller.listarCachorros();
                    for (Cachorro c : cs) {
                        System.out.println(c.getNome());
                    }
                    break;
                case 3:
                    System.out.println("SAindo");

                    return;
                default:
                    break;
            }
        }
    }

    private void adicionarCachorro() {
        System.out.println("Digite o nome do caozinho");
        String nome = scanner.nextLine();
        System.out.println("Digite a raca");     
        String raca = scanner.nextLine();
        controller.CadastrarCachorro(nome, raca);
    }
}
