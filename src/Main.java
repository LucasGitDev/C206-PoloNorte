import Models.Crianca;
import Models.Fabrica;

public class Main {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();

        fabrica.listarBonzinhos();

        Crianca jao = new Crianca("João", 10, "Brasileiro", "Bola");
        try {
            fabrica.novaCrianca(jao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        fabrica.listarBonzinhos();

        try {
            fabrica.addBonzinho("Lucas");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        fabrica.listarBonzinhos();

        try {
            fabrica.addBonzinho("Iza");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        fabrica.listarBonzinhos();

    }
}