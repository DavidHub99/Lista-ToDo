

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
                continue;
            }

            switch (opcao){

                case 1:
                    criarListaNova();
                    break;
                case 2:
                    removerLista();
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    mostrarLista();
                    break;
                default:
                    break;

            }

            if (opcao == 9) break;
        }while(true);
    }

    public static void criarListaNova() {

        System.out.print("\nDigite o nome da sua nova lista:");
        String nome = Teclado.getUmString();
        System.out.print("Digite a descrição da sua nova lista:");
        String descricao = Teclado.getUmString();

        CriarListas novaLista = new CriarListas(nome,descricao);
        listasCriadas.add(novaLista);
        System.out.println("\nLista criada com sucesso \n");
    }

    public static boolean mostrarLista(){
        if (listasCriadas.size() == 0){
            System.out.println("\nVocê ainda não possui nenhuma lista criada\n");
            return true;
        }
        else {
            System.out.println();
            for (int i = 0; i < listasCriadas.size(); i++) {
                CriarListas conta = (CriarListas) listasCriadas.get(i);
                System.out.println(i + 1 + " - " + conta.nomeDaLista);
            }
            System.out.println();
        }
        return false;
    }

    public static void removerLista() throws Exception {

        while(true) {
            if (mostrarLista()) return;

            try {
                System.out.print("Digite o número da lista que deseja remover:");
                int indexRemover = Teclado.getUmInt();
                listasCriadas.remove(1 - indexRemover);
                System.out.println("Lista " + indexRemover + " removida com sucesso\n");
                break;

            } catch (Exception erro) {
                System.out.println("Digite somente os números listados\n");
            }
        }
    }
}