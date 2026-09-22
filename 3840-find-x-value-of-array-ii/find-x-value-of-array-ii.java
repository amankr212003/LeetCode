class Solution {

    class Node {
        int prod;       // product of entire segment % k
        long[] cnt;     // cnt[r] = number of prefixes with product % k == r

        Node() {
            prod = 1;
            cnt = new long[k];
        }
    }

    int k;
    Node[] tree;
    int n;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        this.n = nums.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // 1. Update nums[index]
            update(1, 0, n - 1, index, value);

            // 2. Query range [start, n-1]
            Node result = query(1, 0, n - 1, start, n - 1);

            // 3. Number of prefixes having remainder x
            ans[q] = (int) result.cnt[x];
        }

        return ans;
    }

    // ---------------- BUILD ----------------

    void build(int node, int l, int r, int[] nums) {

        if (l == r) {
            tree[node] = new Node();

            int rem = nums[l] % k;

            tree[node].prod = rem;

            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = (l + r) / 2;

        build(2 * node, l, mid, nums);
        build(2 * node + 1, mid + 1, r, nums);

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    // ---------------- UPDATE ----------------

    void update(int node, int l, int r, int index, int value) {

        if (l == r) {

            int rem = value % k;

            tree[node] = new Node();

            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(2 * node, l, mid, index, value);
        } else {
            update(2 * node + 1, mid + 1, r, index, value);
        }

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    // ---------------- QUERY ----------------

    Node query(int node, int l, int r, int ql, int qr) {

        // Completely outside range
        if (r < ql || l > qr) {
            return new Node();   // identity node
        }

        // Completely inside range
        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = (l + r) / 2;

        Node left = query(2 * node, l, mid, ql, qr);
        Node right = query(2 * node + 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }

    // ---------------- MERGE ----------------

    Node merge(Node left, Node right) {

        Node parent = new Node();

        // Product of entire segment
        parent.prod = (left.prod * right.prod) % k;

        // Prefixes completely inside LEFT
        for (int r = 0; r < k; r++) {
            parent.cnt[r] = left.cnt[r];
        }

        // Prefixes that enter RIGHT
        for (int r = 0; r < k; r++) {

            int newRemainder =
                    (left.prod * r) % k;

            parent.cnt[newRemainder] += right.cnt[r];
        }

        return parent;
    }
}