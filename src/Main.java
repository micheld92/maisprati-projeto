
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        List<Pessoa> listaPessoas = new ArrayList();
        int op;
        String op2;
        String temp_nome;
        String temp_telefone;
        String temp_data_nascimento;
        String temp_data_cadastro;
        String temp_data_ultima_alteracao;
        double nota_final;
        do{
            System.out.println("--------MENU--------");
            System.out.println("1: Inserir registro de Pessoa/Aluno");
            System.out.println("2: Alterar dados de Pessoa/Aluno");
            System.out.println("3: Excluir registro de Pessoa/Aluno");
            System.out.println("4: Listar Pessoa(s)/Aluno(s)");
            System.out.println("0: Encerrar");
            System.out.println("Digite o número referente à opção");
            op = sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    System.out.println("Digite o nome: ");
                    temp_nome = sc.nextLine();
                    System.out.println("Digite o telefone: ");
                    temp_telefone = sc.nextLine();
                    System.out.println("Digite a data de nascimento dd/mm/aaaa: ");
                    temp_data_nascimento = sc.nextLine();
                    System.out.println("Inserir nota final? s/n: ");
                    
                    //as atribuições a seguir sao apenas para testes
                    temp_data_cadastro = "12/10/2022";
                    temp_data_ultima_alteracao = "12/12/2022";
                    
                    op2 = sc.nextLine();  //pega apenas a primeira letra da resposta
                    if(op2.charAt(0) == 's' || op2.charAt(0) == 'S'){
                        System.out.println("Digite a nota: ");
                        nota_final = sc.nextDouble();
                        listaPessoas.add(new Aluno(temp_nome, temp_telefone, temp_data_nascimento, temp_data_cadastro, temp_data_ultima_alteracao, nota_final));
                    }
                    else
                        listaPessoas.add(new Pessoa(temp_nome, temp_telefone, temp_data_nascimento, temp_data_cadastro, temp_data_ultima_alteracao));
                    break;
                case 2:
                    System.out.println("Alterar");
                    break;
                case 3:
                    System.out.println("Excluir");
                    break;
                case 4:
                    System.out.println("\n------ LISTA DE REGISTROS ------");
                    listaPessoas.forEach(p -> {
                        System.out.println(p.toString());
                    });
                    System.out.println(listaPessoas.size());//REMOVER ESTA LINHA
                    System.out.println("------ FIM DA LISTA ------\n");
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
            }
        }while(op != 0);
        sc.close();
    }
}
