
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Pessoa> listaPessoas = new ArrayList();
        listaPessoas.add(new Pessoa("Roberto Firmino", "11111111", "02/10/1991", "10/04/2022", "10/04/2022"));
        listaPessoas.add(new Pessoa("Harry Kane", "2222222", "28/07/1993", "06/04/2022", "10/04/2022"));
        listaPessoas.add(new Pessoa("Lionel Messi", "3333333", "23/02/1985", "24/07/2022", "01/02/2022"));
        listaPessoas.add(new Aluno("Pedro Ernesto", "4444444", "17/06/1965", "10/04/2022", "10/04/2022", 8.0));
        listaPessoas.add(new Aluno("Margarett Hamilton", "4444444", "17/08/1936", "09/04/2022", "09/04/2022", 10.0));
        
        int op;
        String op2;
        String temp_nome;
        String temp_telefone;
        LocalDate data_atual = LocalDate.now(); 
        String temp_data_nascimento;
        String temp_data_cadastro;
        String temp_data_ultima_alteracao;
        double nota_final;

        do{
            System.out.println("--------------- MENU ---------------");
            System.out.println("1: Inserir registro de Pessoa/Aluno");
            System.out.println("2: Alterar dados de Pessoa/Aluno");
            System.out.println("3: Excluir registro de Pessoa/Aluno");
            System.out.println("4: Listar Pessoa(s)/Aluno(s)");
            System.out.println("0: Encerrar");
            System.out.println("Digite o número referente à opção: ");
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
                    temp_data_cadastro = data_atual.format(formatter);
                    temp_data_ultima_alteracao = temp_data_cadastro;
                    
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
                    System.out.println("Digite o nome da pessoa: ");
                    temp_nome = sc.nextLine();
                    
                    boolean encontrou = false;
                    Iterator<Pessoa> pTemp = listaPessoas.iterator();
                    while(pTemp.hasNext()){
                        Pessoa pAux = pTemp.next();
                        if(pAux.getNome().equals(temp_nome)){
                            System.out.println("Nome: " + pAux.getNome());
                            System.out.println("Telefone: " + pAux.getTelefone());
                            System.out.println("Data de nascimento: " + pAux.getData_nascimento());
                            System.out.println("Qual campo deseja alterar?");
                            System.out.println("1: nome");
                            System.out.println("2: telefone");
                            System.out.println("3: data de nascimento");
                            op = sc.nextInt();
                            sc.nextLine();
                            switch(op){
                                case 1:
                                    System.out.println("Digite o nome: ");
                                    temp_nome = sc.nextLine();
                                    pAux.setNome(temp_nome);
                                    break;
                                case 2:
                                    System.out.println("Digite o telefone: ");
                                    temp_telefone = sc.nextLine();
                                    pAux.setTelefone(temp_telefone);
                                    break;
                                case 3:
                                    System.out.println("Digite a data de nascimento dd/mm/aaaa: ");
                                    temp_data_nascimento = sc.nextLine();
                                    pAux.setData_nascimento(temp_data_nascimento);
                                    break;
                            }
                            temp_data_ultima_alteracao = data_atual.format(formatter);
                            pAux.setData_ultima_alteracao(temp_data_ultima_alteracao);
                            encontrou = true;
                        }
                        
                    }
                    if(!encontrou)
                            System.out.println("Registro não encontrado!");
                    else{
                        System.out.println("Gravando alterações...");
                        try{Thread.sleep(1000);}catch(Exception erro){}
                        System.out.println("Registro alterado!");
                    }
                    break;
                case 3:
                    System.out.println("Excluir");
                    encontrou = false;
                    System.out.println("Digite o nome da pessoa: ");
                    temp_nome = sc.nextLine();
                    System.out.println("");
                    pTemp = listaPessoas.iterator();
                    while(pTemp.hasNext()){
                        Pessoa pAux = pTemp.next();
                        if(pAux.getNome().equals(temp_nome)){
                            pTemp.remove();
                            encontrou = true;
                        }
                    }
                    if(!encontrou)
                        System.out.println("Registro não encontrado!");
                    else
                        System.out.println("Registro removido!");
                    break;
                case 4:
                    System.out.println("\n----- FORAM ENCONTRADOS " + listaPessoas.size() + " REGISTROS -----");
                    if(listaPessoas.isEmpty())
                        System.out.println("Nenhum registro cadastrado!");
                    else{
                        listaPessoas.forEach(p -> {
                            System.out.println(p.toString());
                            System.out.println("------------------------------------");
                        });
                        
                    }
                    System.out.println("---------- FINAL DA LISTA ----------\n");
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
            }
        }while(op != 0);
        sc.close();
    }
}
