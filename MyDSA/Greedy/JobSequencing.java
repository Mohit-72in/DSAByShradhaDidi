package MyDSA.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JobSequencing {

    static class Jobs{
        int deadline;
        int profit;
        int id;
        public Jobs(int i,int d,int p){
            id = i;
            deadline = d;
            profit = p;

        }
    }

    public static void main(String[] args) {
        int[][] jobs = {{4,20},{1,10},{1,40},{1,30}};
        ArrayList<Jobs> jobArr = new ArrayList<>();
        for(int i = 0;i< jobs.length;i++){
            jobArr.add(new Jobs(i,jobs[i][0],jobs[i][1]));
        }

        Collections.sort(jobArr,(a,b)->b.profit-a.profit);
        ArrayList<Integer> jobNum = new ArrayList<>();
        int time = 0;
        for(int i=0;i<jobArr.size();i++){
            if(jobArr.get(i).deadline>time){
                time++;
                jobNum.add(jobArr.get(i).id+1);
            }
        }
        System.out.println("Max Jobs : "+jobNum.size());
        for(int x : jobNum){
            System.out.print(x+" ");
        }
    }
}
