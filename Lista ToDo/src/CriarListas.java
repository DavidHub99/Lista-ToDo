import java.util.ArrayList;

public class CriarListas {
    String nomeDaLista;
    String descricaoDaLista;
    ArrayList listas = new ArrayList();



    CriarListas(String nome,String descricao){
        this.nomeDaLista = nome;
        this.descricaoDaLista = descricao;
    }

    public void adicionarItemLista(CriarItem item){
        listas.add(item);
        System.out.println("Item adiciona com sucesso");
    }

    public void mostrarLista(CriarListas lista){

            System.out.println("\nLista "+this.nomeDaLista);
        for( int i = 0; i < listas.size(); i++){
            CriarItem item = (CriarItem) listas.get(i);
            System.out.println("Item "+ i +" - "+item.tarefa+"  Status:"+(item.status? "Feito" : "Pendente"));
        }
    }
}
