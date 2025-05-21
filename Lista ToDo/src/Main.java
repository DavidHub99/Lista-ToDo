

import java.util.ArrayList;

public class Main {

    static ArrayList listasCriadas = new ArrayList();

    public static void main(String[] args) throws Exception {

        int opcao = 0;

        do {
            try {

                System.out.println("Lista ToDo");
                System.out.print("Escolha umas das opções: \n1 - Criar Lista \n2 - Deletar Lista \n3 - Editar lista \n4 - Mostrar lista \n9- Sair \n\nOpção:");
                opcao = Teclado.getUmInt();


            } catch (Exception erro) {
                System.out.println("Digite somente os números listados\n");
            }

            switch (opcao){

                case 1:
                    criarListaNova();
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    for (int i = 0; i < listasCriadas.size(); i++){
                        CriarListas conta = (CriarListas) listasCriadas.get(i);
                        System.out.println(conta.nomeDaLista);
                    }
                    break;
                default:
                    break;

            }

            if (opcao == 9) break;
        }while(true);
    }

    public static void criarListaNova() {

        System.out.print("Digite o nome da sua nova lista:");
        String nome = Teclado.getUmString();
        System.out.println("\nDigite a descrição da sua nova lista:");
        String descricao = Teclado.getUmString();

        CriarListas novaLista = new CriarListas(nome,descricao);
        listasCriadas.add(novaLista);
        System.out.println("Lista criada com sucesso");


    }
}