import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Pidu {

    private String failinimi;
    private String külaline;
    private Map<String, String> kujutus = new HashMap<>();
    private String kutsuja;


    public Pidu() {
    }

    public Pidu (String failinimi, String külaline) throws Exception{
        this.failinimi = failinimi;
        this.külaline = külaline;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(failinimi)))) {
            String rida = br.readLine();
            while (rida != null) {
                String[] osad = rida.split(" ");
                kujutus.put(osad[1], osad[0]);
                rida = br.readLine();
            }
        }
        String kutsuja = kujutus.get(külaline);
        while (kujutus.containsKey(kutsuja)) {
            kutsuja = kujutus.get(kutsuja);
        }
        this.kutsuja = kutsuja;
        }

    public String getKutsuja() {
        return kutsuja;
    }


    public static void main(String[] args) throws Exception {
        Pidu pidu = new Pidu(args[0], args[1]);
        System.out.println(pidu.getKutsuja());
    }
}

