import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestGPSolutions {

    public static void main(String[] args) {
        List<String> lines = null;
        int amountBolts;
        int percentageLostBolts;
        int costBolts;
        int damageBolts;
        int amountNuts;
        int percentageLostNuts;
        int costNuts;
        int damageNuts;
        int amountOfRemainingBolts;
        int amountOfRemainingNuts;
        int damageFromUnpairedParts;
        String allDamage;
        try {
            lines = Files.readAllLines(Paths.get("INPUT.txt"), StandardCharsets.UTF_8);
            String arrayBolts[] = lines.get(0).split(" ");
            String arrayNuts[] = lines.get(1).split(" ");

            amountBolts = new Integer(arrayBolts[0]);
            percentageLostBolts = new Integer(arrayBolts[1]);
            costBolts = new Integer(arrayBolts[2]);

            amountNuts = new Integer(arrayNuts[0]);
            percentageLostNuts = new Integer(arrayNuts[1]);
            costNuts = new Integer(arrayNuts[2]);

            damageBolts = amountBolts / 100 * percentageLostBolts * costBolts;
            damageNuts = amountNuts / 100 * percentageLostNuts * costNuts;

            amountOfRemainingBolts = amountBolts - (amountBolts / 100) * percentageLostBolts;
            amountOfRemainingNuts = amountNuts - (amountNuts / 100) * percentageLostNuts;

            if (amountOfRemainingBolts > amountOfRemainingNuts) {
                damageFromUnpairedParts = (amountOfRemainingBolts - amountOfRemainingNuts) * costBolts;
            } else {
                damageFromUnpairedParts = (amountOfRemainingNuts - amountOfRemainingBolts) * costNuts;
            }

            allDamage = String.valueOf(damageBolts + damageNuts + damageFromUnpairedParts);
            FileWriter writer = new FileWriter("OUTPUT.txt", false);
            writer.write(allDamage);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

