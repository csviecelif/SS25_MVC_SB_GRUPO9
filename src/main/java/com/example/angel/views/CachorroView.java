package com.example.angel.views;

import java.util.List;
import java.util.Scanner;

import com.example.angel.controllers.CachorroController;
import com.example.angel.models.Cachorro;

public class CachorroView {
    private CachorroController controller = new CachorroController();

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1 - Cadastrar cachorro");
            System.out.println("2 - Listar cachorros");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Raça: ");
                    String raca = scanner.nextLine();
                    controller.cadastrarCachorro(nome, raca);
                    break;
                case 2:
                    List<Cachorro> lista = controller.listarCachorros();
                    for (Cachorro c : lista) {
                        System.out.println("Nome: " + c.getNome() + ", Raça: " + c.getRaca());
                    }
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
