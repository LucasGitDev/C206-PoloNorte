package Models;

import Controllers.FileController;
import Exceptions.KidNotFound;

import java.util.ArrayList;
import java.util.List;

public class Fabrica {
    private ArrayList<Crianca> criancas;
    private ArrayList<Elfo> elfos;
    private ArrayList<Crianca> listaBonzinhos;

    private static final String CRIANCAS_PATH = "src/media/criancas.txt";
    private static final String BONZINHOS_PATH = "src/media/bonzinhos.txt";

    public Fabrica() {
        this.criancas = new ArrayList<>();
        this.elfos = new ArrayList<>();
        this.listaBonzinhos = new ArrayList<>();

        this.loadCriancasFromFile();
        this.loadBonzinhosFromFile();
    }

    private void loadCriancasFromFile() {
        // load criancas from file txt
        List<String> criancasFromFile = FileController.readAllLines(CRIANCAS_PATH);
        Crianca crianca;
        for (String criancaString : criancasFromFile) {
            String[] data = criancaString.split(";");
            crianca = new Crianca(data[0], Integer.parseInt(data[1]), data[2], data[3]);
            this.criancas.add(crianca);
        }
    }

    private void loadBonzinhosFromFile() {
        // load criancas from file txt
        List<String> criancasFromFile = FileController.readAllLines(BONZINHOS_PATH);
        Crianca crianca;
        for (String criancaString : criancasFromFile) {
            String[] data = criancaString.split(";");
            crianca = new Crianca(data[0], Integer.parseInt(data[1]), data[2], data[3]);
            this.listaBonzinhos.add(crianca);
        }
    }

    public void novoElfo(Elfo elfo) {
        this.elfos.add(elfo);
    }

    public void novaCrianca(Crianca crianca) {

        // check if kid is already in the list
        for (Crianca kid : this.criancas) {
            if (kid.getNome().equals(crianca.getNome())) {
                throw new RuntimeException("Criança já existe na lista");
            }
        }

        this.criancas.add(crianca);
        List<String> criancasToFile = new ArrayList<>();
        for (Crianca crianca1 : this.criancas) {
            criancasToFile.add(crianca1.getNome() + ";" + crianca1.getIdade() + ";" + crianca1.getNacionalidade() + ";" + crianca1.getPresenteDesejado());
        }
        FileController.writeAllLines(CRIANCAS_PATH, criancasToFile);
    }

    public void addBonzinho(String nomeCrianca) throws Exception {
        // check if kid exists in listaBonzinhos
        for (Crianca crianca : this.listaBonzinhos) {
            if (crianca.getNome().equals(nomeCrianca)) {
                throw new Exception("Criança já está na lista de bons meninos!");
            }
        }
        for (Crianca crianca : this.criancas) {
            if (crianca.getNome().equals(nomeCrianca)) {
                this.listaBonzinhos.add(crianca);
                List<String> bonzinhosToFile = new ArrayList<>();
                for (Crianca crianca1 : this.listaBonzinhos) {
                    bonzinhosToFile.add(crianca1.getNome() + ";" + crianca1.getIdade() + ";" + crianca1.getNacionalidade() + ";" + crianca1.getPresenteDesejado());
                }
                FileController.writeAllLines(BONZINHOS_PATH, bonzinhosToFile);
                return;
            }
        }

        throw new KidNotFound();

    }

    public void listarBonzinhos() {
        System.out.println("##################################");

        for (Crianca crianca : listaBonzinhos) {
            System.out.println(crianca.getNome());
        }

        System.out.println("##################################");
    }
}
