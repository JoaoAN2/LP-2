package Entidades;

 /**
 * @author JoaoAN2 22/04/2022 - 22:33:51
 */

public class Papelaria{
 
    private int id;
    private String produto;
    private double preco;

    public Papelaria() {
    }

    public Papelaria(int id, String produto, double preco) {
        this.id = id;
        this.produto = produto;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return id + ";" + produto + ";" + preco;
    }
}
