

import java.util.ArrayList;

public class Main {

    static ArrayList listasCriadas = new ArrayList();

    public static void main(String[] args) throws Exception {

        int opcao = 0;

        do {
            try {

                System.out.println("Lista ToDo");
                System.out.print("Escolha umas das opções: \n1 - Criar Lista \n2 - Deletar Lista \n3 - Editar lista \n4 - Mostrar listas \n9- Sair \n\nOpção:");
                opcao = Teclado.getUmInt();


            } catch (Exception erro) {
                System.out.println("Digite somente os números listados\n");
                continue;
            }

            switch (opcao){

                case 1: criarListaNova(); break;
                case 2: removerLista(); break;
                case 3: editarLista(); break;
                case 4: mostrarLista(); break;
                default: break;

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

    public static void editarLista() throws Exception{

        int listaParaEditar;
        while (true) {
            if (mostrarLista()) return;

            try {
                System.out.print("Digite em qual lista deseja manipular:");
                listaParaEditar = Teclado.getUmInt();
            } catch (Exception erro) {
                System.out.println("Digite somente os números listados");
                continue;
            }
            if (listaParaEditar > listasCriadas.size() || listaParaEditar < 0 || listaParaEditar == 0){
                System.out.println("Digite somente os números listados");
                continue;
            }else{
                break;
            }


        }
        CriarListas lista = ((CriarListas) listasCriadas.get(listaParaEditar - 1));
        while (true) {
            int opcao = 0;
            try{
                opcoesDeManipulacao(lista.nomeDaLista, listaParaEditar);
                opcao = Teclado.getUmInt();
            }catch (Exception erro){
                System.out.println("Digite somente os números listados");
                continue;
            }

            switch (opcao) {
                case 1: adicionarItemLista(lista); break;
                case 2: apagarItemLista(lista); break;
                case 3: alterarStatus(lista); break;
                case 4: limparLista(lista); break;
                case 5: mostrarTodaLista(lista); break;
                case 9: return;
                default: break;
            }
        }
    }

    public static void opcoesDeManipulacao(String nomeLista, int numeroLista){
        System.out.println("\nLista "+nomeLista+"("+numeroLista+")");
        System.out.println("1 - Adicionar item a lista");
        System.out.println("2 - Apagar item da lista");
        System.out.println("3 - Riscar item da lista");
        System.out.println("4 - Limpar lista");
        System.out.println("5 - Mostrar toda a lista");
        System.out.println("\n9 - Voltar");
        System.out.print("\n\nOpção:");
        // Destalhes da Lista
    }

    public static void adicionarItemLista(CriarListas lista){

        System.out.print("Digite o dado que deseja adicionar na lista:");
        String tarefa = Teclado.getUmString();

        CriarItem item = new CriarItem(tarefa, false);
        lista.setAdicionarItemLista(item);
    }

    public static void apagarItemLista(CriarListas lista) throws Exception {

        int valorIndexParaRetirar = encontrarIndex(lista, "\nDigite o valor do item que deseja retirar:");
        if (valorIndexParaRetirar == -1) return;

        lista.setApagarItemLista(valorIndexParaRetirar);

    }

    public static boolean mostrarTodaLista(CriarListas lista){
        if (lista.listas.size() == 0){
            System.out.println("Lista vazia");
            return true;
        }
        else{
            lista.getMostrarLista(lista);
            return false;
        }
    }

    public static void alterarStatus(CriarListas lista){

        int valorIndexParaRiscar = encontrarIndex(lista, "\nDigite o valor do item que deseja riscar:");
        if( valorIndexParaRiscar == -1) return;

        lista.alterarStatus(valorIndexParaRiscar);
    }

    public static void limparLista(CriarListas lista){
        lista.setLiparLista();
        System.out.println("Lista "+ lista.nomeDaLista+" limpa com sucesso");
    }

    public static int encontrarIndex(CriarListas lista, String texto){

        int valorIndex = -1;
        while(true){
            try{
                if(mostrarTodaLista(lista)) return -1;
                System.out.print(texto);
                valorIndex = Teclado.getUmInt();
            }catch (Exception erro){
                System.out.println("Digite somente os números listados");
                continue;
            }
            if(valorIndex < 0 || valorIndex + 1 > lista.listas.size()){
                System.out.println("Digite somente os números listados");
                continue;
            }
            else return valorIndex;
        }
    }

}
