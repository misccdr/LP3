import java.util.Comparator;
import java.util.PriorityQueue;

class HuffmanNode {
    int val;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode>{
    public int compare(HuffmanNode x, HuffmanNode y){
        return x.val - y.val;
    }
}

class Huffman{
    private static void printCode(HuffmanNode root, String string1){
        if(root.left == null && root.right == null && Character.isLetter(root.c)){
            System.out.println(root.c + " | "+string1);
            return;
        }
        printCode(root.left, string1 + "0");
        printCode(root.right, string1 + "1");
    }

    public static void main(String[] args) {
        int n = 5;
        char[] arr ={'a', 'b', 'c', 'd' , 'e'};
        int[] freq = {4,   7,   3,   2,    4 };

        PriorityQueue<HuffmanNode> Qu = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        //IMPORTANT

        for(int i=0; i<n; i++){
            HuffmanNode node = new HuffmanNode();
            node.c = arr[i];
            node.val = freq[i];
            node.left = null;
            node.right = null;
            Qu.add(node);
        }

        HuffmanNode root = null;

        while (Qu.size() > 1) {
            HuffmanNode node1 = Qu.peek();
            Qu.poll();

            HuffmanNode node2 = Qu.peek();
            Qu.poll();

            HuffmanNode f1 = new HuffmanNode();
            f1.val = node1.val + node2.val;
            f1.c = '-';

            f1.left = node1;
            f1.right = node2;

            root = f1;
            Qu.add(f1);
        }

        //IMPORTANT

        System.out.println("Char  |  Huffman code");
        System.out.println("---------------------");
        printCode(root, "");
    }
}


