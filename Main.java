import java.io.*;

public class Main {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        // 🔹 1. Leer diccionario.txt
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) continue;

                line = line.replace("(", "").replace(")", "");

                String[] parts = line.split(",");

                if (parts.length == 2) {
                    String english = parts[0].trim().toLowerCase();
                    String spanish = parts[1].trim().toLowerCase();

                    tree.insert(new Association<>(english, spanish));
                }
            }

        } catch (IOException e) {
            System.out.println("Error leyendo diccionario.txt");
        }

        // 🔹 2. Mostrar diccionario ordenado
        System.out.println("Diccionario ordenado:");
        tree.inorder();

        // 🔹 3. Traducir texto.txt
        System.out.println("\nTraducción:");

        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");

                for (String word : words) {
                    String clean = word.toLowerCase().replaceAll("[^a-z]", "");

                    String translation = tree.search(clean);

                    if (translation == null)
                        System.out.print("*" + word + "* ");
                    else
                        System.out.print(translation + " ");
                }
            }

        } catch (IOException e) {
            System.out.println("Error leyendo texto.txt");
        }
    }
}