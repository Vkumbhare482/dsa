class Solution {

    public void printKdistancenodesdown(TreeNode root, int k, List<Integer> ans) {
        if (root == null || k < 0) {
            return;
        }

        if (k == 0) {
            ans.add(root.val);
            return;
        }

        printKdistancenodesdown(root.left, k - 1, ans);
        printKdistancenodesdown(root.right, k - 1, ans);
    }

    public int findDistance(TreeNode root, TreeNode target, int k, List<Integer> ans) {

        if (root == null) {
            return -1;
        }

        if (root == target) {
            printKdistancenodesdown(root, k, ans);
            return 0;
        }

        int dl = findDistance(root.left, target, k, ans);

        if (dl != -1) {

            if (dl + 1 == k) {
                ans.add(root.val);
            } else {
                printKdistancenodesdown(root.right, k - dl - 2, ans);
            }

            return dl + 1;
        }

        int dr = findDistance(root.right, target, k, ans);

        if (dr != -1) {

            if (dr + 1 == k) {
                ans.add(root.val);
            } else {
                printKdistancenodesdown(root.left, k - dr - 2, ans);
            }

            return dr + 1;
        }

        return -1;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ans = new ArrayList<>();

        findDistance(root, target, k, ans);

        return ans;
    }
}