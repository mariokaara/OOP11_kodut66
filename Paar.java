public class Paar<T,K> {

    private T esimene;
    private K teine;

    public Paar (T esimene, K teine) {
        this.esimene = esimene;
        this.teine = teine;
    }

    public T getEsimene() {
        return esimene;
    }

    public void setEsimene(T esimene) {
        this.esimene = esimene;
    }

    public K getTeine() {
        return teine;
    }

    public void setTeine(K teine) {
        this.teine = teine;
    }

    @Override
    public String toString() {
        return "Paar{" +
                "teine=" + teine +
                ", esimene='" + esimene + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Paar<String , Integer> p = new Paar<String, Integer>("Nimi", 2016);
        Paar<String , String> p1 = new Paar<String, String>("Nimi", "Nimi2");
    }
}
