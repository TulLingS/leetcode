import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

}


public class Leetcode20200522 {

    /**
     * 建立二叉树
     *
     * @param preorder 树的前序遍历结果
     * @param inorder  树的中序遍历结果
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen < inLen) {
            throw new IllegalStateException("");
        }
        // 存储遍历的值以及其位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        // 递归建立
        return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1, map);

    }

    /**
     * @param preorder 前序遍历
     * @param preLeft  前序遍历的左指针
     * @param preRight 前序遍历的右指针
     * @param inorder  中序遍历
     * @param inLeft   中序遍历的左指针
     * @param inRight  中序遍历的右指针
     * @param map      存储数据
     * @return
     */
    public TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 拿出根节点
        int p = preorder[preLeft];
        // 中找到分割点
        int pIndex = map.get(p);
        TreeNode root = new TreeNode(p);
        root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft,
                inorder, inLeft, pIndex - 1, map);
        root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight,
                inorder, pIndex + 1, inRight, map);
        return root;
    }


    public static void main(String[] args) {
        int[] a1 = new int[]{3, 9, 20, 15, 7};
        int[] a2 = new int[]{9, 3, 15, 20, 7};

        Leetcode20200522 solution = new Leetcode20200522();
        solution.buildTree(a1, a2);
    }
}
