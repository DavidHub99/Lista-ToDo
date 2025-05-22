public class CriarItem {
    private String tarefa;
    private boolean status;


    CriarItem(String tarefa, boolean status){
        this.tarefa = tarefa;
        this.status = status;
    }

    public static void opcoesDeManipulacao(String nomeLista, int numeroLista){
        System.out.println("\nLista "+nomeLista+"("+numeroLista+")");
        System.out.println("1 - Adicionar item a lista");
        System.out.println("2 - Apagar item da lista");
        System.out.println("3 - Riscar item da lista");
        System.out.println("4 - Limpar lista");
        System.out.println("5 - Mostrar toda a lista");
        System.out.print("\n9 - Voltar");
        System.out.println("\n\n Opção:");
    }

}
