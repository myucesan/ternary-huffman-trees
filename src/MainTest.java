import java.util.*;

import org.junit.jupiter.api.*;


public class MainTest {

    @Test
    @Timeout(100)
    public void exampleDecoding() {
        Node root = new Node((char) 0, 1);
        Node eNode = new Node('e', 0.6, root);
        Node xNode = new Node('x', 0.1, root);
        Node yNode = new Node('y', 0.3, root);
        root.setLeftChild(eNode);
        root.setRightChild(xNode);
        root.setMiddleChild(yNode);
        Assertions.assertEquals("xyexy", Main.decode("21021", root));
    }

    /** Tree looks like this: root combined k combined e 0 x f 0 g */
    @Test
    @Timeout(1)
    public void exampleEncoding2() {
        Node root = new Node((char) 0, 1);
        Node leftRoot = new Node((char) 0, 0.4, root);
        root.setLeftChild(leftRoot);
        Node eNode = new Node('e', 0.2, leftRoot);
        leftRoot.setLeftChild(eNode);
        Node xNode = new Node('x', 0.2, leftRoot);
        leftRoot.setRightChild(xNode);
        Node nullNode = new Node((char) 0, 0, leftRoot);
        leftRoot.setMiddleChild(nullNode);
        Node middleRoot = new Node('k', 0.2, root);
        root.setMiddleChild(middleRoot);
        Node rightRoot = new Node((char) 0, 0.4, root);
        root.setRightChild(rightRoot);
        Node fNode = new Node('f', 0.2, rightRoot);
        rightRoot.setLeftChild(fNode);
        Node gNode = new Node('g', 0.2, rightRoot);
        rightRoot.setRightChild(gNode);
        nullNode = new Node((char) 0, 0, rightRoot);
        rightRoot.setMiddleChild(nullNode);
        Assertions.assertEquals("exkkfg", Main.decode("0002112022", root));
    }

    @Test
    @Timeout(1)
    public void exampleBuildTree() {
        int n = 3;
        char[] chars = {0, 'a', 'b', 'c'};
        double[] freq = {0, 0.5, 0.3, 0.2};
        Node tree = Main.buildHuffman(n, chars, freq);
        Assertions.assertNotNull(tree);
        Assertions.assertNotNull(tree.leftChild);
        Assertions.assertNotNull(tree.rightChild);
        Assertions.assertNotNull(tree.middleChild);
        Set<Character> symbolsUsed = new HashSet<>();
        symbolsUsed.add(tree.leftChild.symbol);
        symbolsUsed.add(tree.rightChild.symbol);
        symbolsUsed.add(tree.middleChild.symbol);
        Assertions.assertEquals(3, symbolsUsed.size());
        Assertions.assertTrue(symbolsUsed.contains('a'));
        Assertions.assertTrue(symbolsUsed.contains('b'));
        Assertions.assertTrue(symbolsUsed.contains('c'));
    }
}
