package MyDSA.Basics;

public class unionFind {

    public static int find(int[] parent,int x){
        if(parent[x] == x) return x;
        return find(parent,parent[x]);
    }
    public static void union(int[] parent,int x,int y){
        int x_rep = find(parent, x);
        int y_rep = find(parent, y);
        if(x_rep == y_rep) return;
        parent[y_rep] = x_rep;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] parent = new int[n];
        int rank[] = new int[n];
        for(int i = 0; i<n;i++){
            parent[i] = i;
        }
        union(parent,1,2);
        union(parent,2,3);
        System.out.println(find(parent,3));
        System.out.println(find(parent,4));
    }
}
