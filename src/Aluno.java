
public class Aluno extends Pessoa{
    private double nota_final;

    public Aluno(String nome, String telefone, String data_nascimento, String data_cadastro, String data_ultima_alteracao, double nota_final) {
        super(nome, telefone, data_nascimento, data_cadastro, data_ultima_alteracao);
        this.nota_final = nota_final;
    }

    public double getNota_final() {
        return nota_final;
    }

    public void setNota_final(double nota_final) {
        this.nota_final = nota_final;
    }

    @Override
    public String toString() {
        return "Registrado como Aluno" +
               "\nNome: " + this.getNome() +
               "\nTelefone: " + this.getTelefone() +
               "\nData de nascimento: " + this.getData_nascimento() +
               "\nData de cadastro: " + this.getData_cadastro() +
               "\nData da última alteração: " + this.getData_ultima_alteracao() +
               "\nNota final do curso: " + this.getNota_final();
    }
    
    
}
