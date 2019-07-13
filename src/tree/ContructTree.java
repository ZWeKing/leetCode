package tree;


/**
 * 剑指Offer，重建二叉树
 * 给定二叉树前序遍历、后序遍历结果，重建该二叉树
 */
public class ContructTree {

    Node root = null;
    public Node contructTree(int[] arrayP,int[] arrayM) {
        return divide(0,arrayP.length-1,0,arrayM.length - 1,arrayP,arrayM);
    }

    public Node divide(int startP, int endP, int startM,int endM, int[] arrayP,int[] arrayM) {


        Node root = new Node(arrayP[startP]);

        if (startP == endP) {
            return root;
        }

        int currentIndexM = startM;
        while(currentIndexM <= endM) {
            if (arrayM[currentIndexM] == arrayP[startP]) {
                break;
            } else {
                currentIndexM++;
            }
        }

        int length = currentIndexM - startM;

        if (length > 0) {
            root.left = divide(startP+1,startP+length,startM,currentIndexM-1,arrayP,arrayM);
        }

        if ((startP+length+1) <= endP) {
            root.right = divide(startP+length+1,endP,currentIndexM+1,endM ,arrayP,arrayM);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arrayP = new int[]{1,2,4,7,3,5,6,8};
        int[] arrayM = new int[]{4,7,2,1,5,3,8,6};
        Node node = new ContructTree().contructTree(arrayP,arrayM);
        System.out.println(node);
    }

}

class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }
}