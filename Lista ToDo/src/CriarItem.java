public class CriarItem {
     String tarefa;
     boolean status;


    CriarItem(String tarefa, boolean status){
        this.tarefa = tarefa;
        this.status = status;
    }

    public void setAlterarStatus(){
        this.status = true;
    }

}
