package cc.fbsky.edujava.tree;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Comparator;
import java.util.TreeMap;

@Data
public class ReadBlackTree {

    public static void demoTreeMap() {

        TreeMap<Object,Object> objTree = new TreeMap<Object,Object>();

        objTree.put(new TreeNode("12313"),new String[1]);
        objTree.put(new TreeNode("ads"),new String[1]);
        objTree.put(new TreeNode("sdfasdf"),new String[1]);
        objTree.put(new TreeNode("asfa"),new String[1]);
        objTree.put(new TreeNode("12313"),new String[1]);
        objTree.put(12313,new String[1]);


    }

    public static void main(String[] args) {
        // demoTreeMap();
        ReadBlackTree tree = new ReadBlackTree();
        tree.add("999");
        tree.add("888");
        tree.add("111");
        tree.add("99889");
        tree.add("ABC");
        tree.add("DEF");
        System.out.println(JSON.toJSON(tree));
    }

    //根
    private TreeNode root;

    public void add(String value){

        if(null == root){
            root = new TreeNode(value);
            return;
        }

        TreeNode tmpRoot = root;

        while(null != tmpRoot){
            int compValue = tmpRoot.getValue().compareTo(value);
            if(compValue >0){
                if(null == tmpRoot.right){
                    tmpRoot.right = new TreeNode(value);
                    return;
                }else{
                    tmpRoot = tmpRoot.right;
                    continue;
                }
            }

            if(compValue < 0){
                if(null == tmpRoot.left){
                    tmpRoot.left = new TreeNode(value);
                    return;

                }else{
                    tmpRoot = tmpRoot.left;
                    continue;
                }
            }
            return;
        }
        //红黑树自旋

    }

    @Data
    private static class TreeNode{
        String value;
        TreeNode left;
        TreeNode right;

        public TreeNode() {

        }

        public TreeNode(String value){
            this.value = value;
        }

    }
}
