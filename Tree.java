// Time out
import java.util.HashMap;
import java.util.Scanner;

class Node {
    int data;
    Node parent;
    Node left;
    Node right;

    Node(int data, Node parent, Node left, Node right) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}

public class Tree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node root = new Node(1, null, null, null);
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        nodeMap.put(1, root);

        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            addNode(nodeMap, parent, child);
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(findParentNode(nodeMap, i));
        }
    }

    public static void addNode(HashMap<Integer, Node> nodeMap, int a, int b) {
        int parent = 0;
        if(nodeMap.containsKey(a)){
            parent = a;
        } else if (nodeMap.containsKey(b)) {
            parent = b;
        }else{
            System.out.println("No matching parent");
        }

        Node child = new Node(parent == a? b:a, nodeMap.get(parent), null, null);
        nodeMap.put(parent == a? b:a, child);

        if(nodeMap.get(parent).left == null){
            nodeMap.get(parent).left = child;
        }else if (nodeMap.get(parent).right == null) {
            nodeMap.get(parent).right = child;
        }

    }

        public static int findParentNode (HashMap < Integer, Node > nodeMap,int data){
            int result = 0;
            for (int key : nodeMap.keySet()) {
                    if (key == data && data != 1) {
                        result = nodeMap.get(key).parent.data;
                        break;
                    }
            }
            return result;
        }
}
