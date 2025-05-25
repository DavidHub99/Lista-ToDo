import java.util.ArrayList;

public class CriarListas {
    String nomeDaLista;
    String descricaoDaLista;
    ArrayList listas = new ArrayList();



    CriarListas(String nome,String descricao){
        this.nomeDaLista = nome;
        this.descricaoDaLista = descricao;
    }

    public void setAdicionarItemLista(CriarItem item){
        listas.add(item);
        System.out.println("Item adiciona com sucesso");
    }

    public void setApagarItemLista(int indexRetirar){
        CriarItem item = (CriarItem) listas.get(indexRetirar );
        listas.remove(indexRetirar);
        System.out.println("Item '"+item.tarefa+"' retirado com sucesso");
    }

    public void getMostrarLista(CriarListas lista){

            System.out.println("\nLista "+this.nomeDaLista);
        for( int i = 0; i < listas.size(); i++){
            CriarItem item = (CriarItem) listas.get(i);
            System.out.println("Item "+ i +" - "+item.tarefa+"  Status:"+(item.status? "Feito" : "Pendente"));
        }
    }

    public void alterarStatus(int index){
        CriarItem item = (CriarItem) listas.get(index);
        item.setAlterarStatus();
        System.out.println("Item riscado da lista com sucesso");
    }

    public void setLiparLista(){
        listas.clear();
    }

}
