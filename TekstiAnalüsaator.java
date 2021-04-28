import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TekstiAnalüsaator {

    private String sõned;
    private File fail;
    private String kodeering;


    public TekstiAnalüsaator(String sõned) {
        this.sõned = sõned;
    }

    public TekstiAnalüsaator(File fail, String kodeering) throws Exception {
        Path path = fail.toPath();
        this.fail = fail;
        this.kodeering = kodeering;
        String str = Files.readString(path, Charset.forName(kodeering));
        this.sõned = str;
    }

    public Map<String, Integer> sõnadeSagedus() {
        String[] massiiv = sõned.replaceAll("\\p{P}", "").toLowerCase().split("\\s+");
        Map<String, Integer> kujutus = new HashMap<>();
        if (sõned == ""){
            return kujutus;
        }
        for (String i : massiiv) {
            if (kujutus.containsKey(i)) {
                int count = kujutus.get(i);
                kujutus.put(i, count + 1);
            } else {
                kujutus.put(i, 1);
            }
        }
        return kujutus;
    }

    public Map<String, Map<String, Integer>> sõnadeJärgnevus() {
        String[] massiiv = sõned.replaceAll("\\p{P}", "").toLowerCase().split("\\s+");
        Map<String, Map<String, Integer>> kujutus = new HashMap<>();
        if (sõned == ""){
            return kujutus;
        }
        for (int i = 0; i < massiiv.length - 1; i++) {
            String sõne = massiiv[i];
            if (kujutus.containsKey(sõne)) {
                Map<String, Integer> järgnevus = kujutus.get(sõne);
                if (järgnevus.containsKey(massiiv[i + 1])) {
                    int count = järgnevus.get(massiiv[i + 1]);
                    järgnevus.put(massiiv[i + 1], count + 1);
                } else {
                    järgnevus.put(massiiv[i + 1], 1);
                }
            } else {
                Map<String, Integer> järgnevus = new HashMap<>();
                kujutus.put(sõne, järgnevus);
                järgnevus.put(massiiv[i + 1], 1);
            }
        }
        return kujutus;
    }
}