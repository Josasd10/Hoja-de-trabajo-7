import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {

    // 🔹 Prueba principal: insertar y buscar
    @Test
    public void testInsertAndSearch() {
        BinaryTree tree = new BinaryTree();

        tree.insert(new Association<>("dog", "perro"));
        tree.insert(new Association<>("cat", "gato"));
        tree.insert(new Association<>("house", "casa"));

        assertEquals("perro", tree.search("dog"));
        assertEquals("gato", tree.search("cat"));
        assertEquals("casa", tree.search("house"));
    }

    // 🔹 Prueba cuando la palabra NO existe
    @Test
    public void testSearchNotFound() {
        BinaryTree tree = new BinaryTree();

        tree.insert(new Association<>("dog", "perro"));

        assertNull(tree.search("cat"));
    }

    // 🔹 Prueba actualización de valor (duplicados)
    @Test
    public void testUpdateValue() {
        BinaryTree tree = new BinaryTree();

        tree.insert(new Association<>("dog", "perro"));
        tree.insert(new Association<>("dog", "canino"));

        assertEquals("canino", tree.search("dog"));
    }

    // 🔹 Prueba mayúsculas/minúsculas
    @Test
    public void testCaseInsensitive() {
        BinaryTree tree = new BinaryTree();

        tree.insert(new Association<>("dog", "perro"));

        assertEquals("perro", tree.search("DOG"));
    }
}