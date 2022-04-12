
import java.util.Date;


public class Pessoa {
    protected String nome;
    protected String telefone;
    protected String data_nascimento;
    protected String data_cadastro;
    protected String data_ultima_alteracao;

    public Pessoa(String nome, String telefone, String data_nascimento, String data_cadastro, String data_ultima_alteracao) {
        this.nome = nome;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
        this.data_cadastro = data_cadastro;
        this.data_ultima_alteracao = data_ultima_alteracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getData_ultima_alteracao() {
        return data_ultima_alteracao;
    }

    public void setData_ultima_alteracao(String data_ultima_alteracao) {
        this.data_ultima_alteracao = data_ultima_alteracao;
    }

    @Override
    public String toString() {
        return "Registrado como Pessoa" + 
                "\nNome: " + this.getNome() + 
                "\nTelefone: " + this.getTelefone() + 
                "\nData de nascimento: " + this.getData_nascimento() + 
                "\nData de cadastro: " + this.getData_cadastro() + 
                "\nData da última alteracao: " + this.getData_ultima_alteracao();
    }

}
