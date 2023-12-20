
import java.util.*;

/**
 * WARNING: The spec tests are not necessarily equal to your grade! You can use them help you test
 * for the correctness of your algorithm, but the final grade is determined by a manual inspection
 * of your implementation.
 */
class Main {

    /**
     * You should implement this method.
     *
     * @param encrypted the encrypted message to decipher (a string of '0's, '1's, and '2's)
     * @param root the root of the Ternary Huffman tree
     * @return the unencrypted message
     */
    public static String decode(String encrypted, Node root) {
        Node start = root;
        StringBuilder sb = new StringBuilder();
       for (char c : encrypted.toCharArray()) {
           switch (c){
               case '0':
                   if (root.getLeftChild() != null) root = root.getLeftChild();
                   if (root.getSymbol() != (char) 0) {
                       sb.append(root.getSymbol());
                       root = start;
                   }
                   break;
               case '1':
                   if (root.getMiddleChild() != null) root = root.getMiddleChild();
                   if (root.getSymbol() != (char) 0) {
                       sb.append(root.getSymbol());
                       root = start;
                   }
                   break;
               case '2':
                   if (root.getRightChild() != null) root = root.getRightChild();
                   if (root.getSymbol() != (char) 0) {
                       sb.append(root.getSymbol());
                       root = start;
                   }
                   break;
           }

       }

        return sb.toString();
    }

    /**
     * You should implement this method. Remember to look at the even/oddness of the number
     * characters!
     *
     * @param n the number of characters that need to be encoded.
     * @param characters The characters c_1 through c_n. Note you should use only characters[1] up
     *     to and including characters[n]!
     * @param frequencies The frequencies f_1 through f_n. Note you should use only frequencies[1]
     *     up to and including frequencies[n]!
     * @return The rootnode of an optimal Ternary Huffman tree that represents the encoding of the
     *     characters given.
     */
    public static Node buildHuffman(int n, char[] characters, double[] frequencies) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Double.compare(o1.frequency, o2.frequency);
            }
        });

        for (int i = 1; i <= n; i++) {
             pq.add(new Node(characters[i], frequencies[i]));
        }

        if (n % 2 == 0) pq.add(new Node((char) 0, 0));
        while (true) {
            Node n1 = pq.poll();
            if (pq.isEmpty()) {
                return n1;
            } else {
                Node n2 = pq.poll();
                Node n3 = pq.poll();
                Node parent = new Node(' ', n1.getFrequency() + n2.getFrequency() + n3.getFrequency(), n1, n2, n3);
                n1.setParent(parent);
                n2.setParent(parent);
                n3.setParent(parent);
                pq.offer(parent);
            }
        }


    }
}

/**
 * NOTE: You should ensure that if a Node is a part of a tree, then all nodes in the tree have their
 * `parent`, `leftChild`, `middleChild`, and `rightChild` set appropriately! You may add methods to
 * this class, provided you do not change the names of existing methods or fields!
 */
class Node {

    char symbol;

    double frequency;

    Node parent;

    Node leftChild;

    Node rightChild;

    Node middleChild;

    public Node(char symbol, double frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    public Node(char symbol, double frequency, Node parent) {
        this(symbol, frequency);
        this.parent = parent;
    }

    public Node(char symbol, double frequency, Node leftChild, Node middleChild, Node rightChild) {
        this(symbol, frequency);
        this.leftChild = leftChild;
        this.middleChild = middleChild;
        this.rightChild = rightChild;
    }

    public char getSymbol() {
        return symbol;
    }

    public double getFrequency() {
        return frequency;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getMiddleChild() {
        return middleChild;
    }

    public void setMiddleChild(Node middleChild) {
        this.middleChild = middleChild;
    }
}
