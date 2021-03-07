package cc.fbsky.edujava.tree;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.TreeMap;

@Data
public class ReadBlackTree {

    public static void demoTreeMap() {

        TreeMap<Object,Object> objTree = new TreeMap<Object,Object>();

        objTree.put(new TreeNode("12313","sdfds"),new String[1]);
        objTree.put(new TreeNode("ads","sdfds"),new String[1]);
        objTree.put(new TreeNode("sdfasdf","sdfds"),new String[1]);
        objTree.put(new TreeNode("asfa","sdfds"),new String[1]);
        objTree.put(new TreeNode("12313","sdfds"),new String[1]);

        objTree.put(12313,new String[1]);


    }

    public static void addValue(ReadBlackTree tree) {
        // demoTreeMap();
        tree.add("11","11");
        tree.add("12","12");
        tree.add("13","13");
        tree.add("14","14");
        tree.add("15","15");
        tree.add("21","21");

    }

    public static void main(String[] args) {
        // demoTreeMap();
        ReadBlackTree tree = new ReadBlackTree();
        addValue(tree);

        System.out.println(JSON.toJSON(tree));
        System.out.println(tree.find("sdf"));
        System.out.println(tree.find("1123"));

    }

    //根
    private TreeNode root;

    public void add(String key,Object value){

        TreeNode tmpNode = new TreeNode(key,value);
        tmpNode.color = TreeNode.RED;

        //① 情况说明：被插入的节点是根节点。
        if(null == root){
            root = tmpNode;
            root.color = TreeNode.BLACK;//根节点黑色
            return;
        }

        //添加节点
        addNode(root,tmpNode);

        //平衡树
        addToBalanceTree(tmpNode);
    }



    private void addNode(TreeNode tmpRoot,TreeNode addNode){

        while (null != tmpRoot) {
            String addKey = addNode.getKey();

            int compValue = tmpRoot.key.compareTo(addKey);

            //新节点大
            if (compValue < 0) {
                if (null == tmpRoot.rightNode) {
                    tmpRoot.rightNode = addNode;

                    addNode.parentNode = tmpRoot;
                    addNode.posititon = TreeNode.RIGHT;

                    return;

                } else {
                    tmpRoot = tmpRoot.rightNode;
                }
            } else {
                if (null == tmpRoot.leftNode) {
                    tmpRoot.leftNode = addNode;

                    addNode.parentNode = tmpRoot;
                    addNode.posititon = TreeNode.LEFT;
                    return;

                } else {
                    tmpRoot = tmpRoot.leftNode;
                }
            }

        }
    }

    private void addToBalanceTree(TreeNode childNode){

        //当前节点为根节点
        if(null == childNode.parentNode){
            childNode.color = TreeNode.BLACK;
            return;
        }

        //父节点
        TreeNode parent = childNode.parentNode;
        //父节点黑色-不用平衡
        if(TreeNode.BLACK == (parent.color)){
            return;
        }

        //祖父节点
        //父节点红色--此时祖父肯定是黑色
        TreeNode grandParent = parent.parentNode;

        //叔叔节点
        TreeNode uncle = (TreeNode.RIGHT == (parent.posititon)?
                grandParent.leftNode
                :grandParent.rightNode);

        //叔叔红色
        if(null != uncle
                && TreeNode.RED == (uncle.color)){

            parent.color = TreeNode.BLACK;
            uncle.color = TreeNode.BLACK;

            //祖父节点涂红
            grandParent.color = TreeNode.RED;

            //祖父节点再平衡
            addToBalanceTree(grandParent);
            return;
        }


        //叔叔黑色

        /**父子方位相同
         *
         * 父子同在左侧
         * 子节点  红色  左侧
         *
         * 父节点  红色  左侧
         * 叔节点  黑色  右侧
         *
         * 祖父节点 黑色
         *
         * 此时已 祖父节点 右旋
         *
         * 祖父节点 红色
         * 父节点  红色
         */

        if(TreeNode.LEFT == (childNode.posititon)
            && TreeNode.LEFT == parent.posititon){

            //祖父节点-是根节点
            if(null == grandParent.parentNode){
                root = parent;
            }else{
                grandParent.parentNode.leftNode = parent;
            }

            //右旋
            parent.parentNode = grandParent.parentNode;
            parent.leftNode = grandParent;

            grandParent.parentNode = parent;
            grandParent.rightNode = null;


            //换色
            parent.color = TreeNode.BLACK;
            grandParent.color = TreeNode.RED;

            return;
        }

        /**父子方位相同
         *
         * 父子同在右侧
         * 子节点  红色  右侧
         *
         * 父节点  红色  右侧
         * 叔节点  黑色  左侧
         *
         * 祖父节点 黑色
         *
         * 此时以 祖父节点 左旋
         *
         * 祖父节点 红色
         * 父节点  红色
         */

        if(TreeNode.RIGHT == childNode.posititon
                && TreeNode.RIGHT == parent.posititon){

            //祖父节点-是根节点
            if(null == grandParent.parentNode){
                root = parent;
            }else{
                grandParent.parentNode.rightNode = parent;
            }

            //左旋
            parent.parentNode = grandParent.parentNode;
            parent.leftNode = grandParent;

            grandParent.parentNode = parent;
            grandParent.rightNode = null;

            //防止祖父节点为root
            if(null == parent.parentNode){
                root = parent;
            }

            //换色
            parent.color = TreeNode.BLACK;
            grandParent.color = TreeNode.RED;

            return;
        }


        /**父子方位不同
         *
         * 子节点  红色  右侧
         *
         * 父节点  红色  左侧
         * 叔节点  黑色  右侧
         *
         * 祖父节点 黑色
         *
         * 此时以 父节点 左旋
         */

        if(TreeNode.RIGHT == childNode.posititon
                && TreeNode.LEFT == parent.posititon){

            parent.parentNode.leftNode = childNode;

            //左旋
            childNode.parentNode = grandParent;
            parent.parentNode = childNode;

            childNode.leftNode = parent;
            parent.rightNode = null;

            //同侧
            addToBalanceTree(parent);

            return;
        }

        /**父子方位不同
         *
         * 子节点  红色  左侧
         *
         * 父节点  红色  右侧
         * 叔节点  黑色  左侧
         *
         * 祖父节点 黑色
         *
         * 此时以 父节点 右旋
         *
         * 再以
         */

        if(TreeNode.LEFT == childNode.posititon
                && TreeNode.RIGHT == parent.posititon){

            grandParent.rightNode = childNode;

            //右旋
            childNode.parentNode = grandParent;
            parent.parentNode = childNode;

            childNode.rightNode = parent;
            parent.leftNode = null;

            //同侧
            addToBalanceTree(parent);
            return;
        }

    }

    private void leftWhirling(TreeNode changeNode){

        TreeNode parent = changeNode.parentNode;
        TreeNode right = changeNode.rightNode;

        if(null != parent){
            parent.rightNode = right;
        }

        right.parentNode = parent;
        changeNode.parentNode = right;

    }

    public Object find(String key){

        if(null == root){
            return null;
        }

        TreeNode tmpRoot = root;

        while(null != tmpRoot){
            int compValue = tmpRoot.key.compareTo(key);
            if(compValue >0){
                if(null == tmpRoot.rightNode){
                    return  null;
                }else{
                    tmpRoot = tmpRoot.rightNode;
                    continue;
                }
            }

            if(compValue < 0){
                if(null == tmpRoot.leftNode){
                    return null;
                }else{
                    tmpRoot = tmpRoot.leftNode;
                    continue;
                }
            }
            return tmpRoot.value;
        }

        return  null;
    }


    @Data
    private static class TreeNode{

        static final String RED   = "red";
        static final String BLACK = "black";

        static final String LEFT = "left";
        static final String RIGHT = "right";

        @JSONField(ordinal = 1)
        String key;

        @JSONField(ordinal = 2)
        Object value;

        @JSONField(ordinal = 3)
        String color = RED;

        @JSONField(ordinal = 4)
        String posititon = null;

        @JSONField(ordinal = 5)
        TreeNode leftNode = null;

        @JSONField(ordinal = 6)
        TreeNode rightNode = null;

        @JSONField(serialize = false)
        TreeNode parentNode = null;

        public TreeNode() {}

        public TreeNode(String nodekey,Object nodeValue){
            this.key = nodekey;
            this.value = nodeValue;
        }

    }
}
