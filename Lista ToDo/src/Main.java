//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        int opcao = 0;
        ArrayList listasCriadas = new ArrayList();

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
                    CriarListaNova();
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                default:
                    break;

            }

            if (opcao == 9) break;
        }while(true);



    public static void CriarListaNova() {
        System.out.println("Teste");
        }


    }
}