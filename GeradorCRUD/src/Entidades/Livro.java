package Entidades;

 /**
 * @author JoaoAN2 11/11/2021 - 17:52:33
 */

public class Livro{
 
    private int id;
    private String nome;
    private int anoDeLancamento;
    private String autor;
    private double preco;

    public Livro() {
    }

    public Livro(int id, String nome, int anoDeLancamento, String autor, double preco) {
        this.id = id;
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.autor = autor;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnodelancamento() {
        return anoDeLancamento;
    }

    public void setAnodelancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + anoDeLancamento + ";" + autor + ";" + preco;
    }
}
