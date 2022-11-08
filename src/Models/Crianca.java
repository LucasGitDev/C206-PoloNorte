package Models;

public class Crianca {
    private String nome;
    private int idade;
    private String nacionalidade;
    private String presenteDesejado;

    public Crianca(String nome, int idade, String nacionalidade, String presenteDesejado) {
        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
        this.presenteDesejado = presenteDesejado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPresenteDesejado() {
        return presenteDesejado;
    }

    public void setPresenteDesejado(String presenteDesejado) {
        this.presenteDesejado = presenteDesejado;
    }
}
