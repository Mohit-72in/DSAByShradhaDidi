package MyDSA.Strings;

import java.util.ArrayList;

public class SortArrOfString {
    public static void mergeSort(String[] strings,int si,int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei-si)/2;
        mergeSort(strings,si,mid);
        mergeSort(strings,mid+1,ei);
        merge(strings,si,mid,ei);
    }
    public static void merge(String[] strings,int si,int mid,int ei){
        ArrayList<String> sb = new ArrayList<>();
        int i = si,j= mid+1;
        while(i<=mid && j<=ei){
            if(strings[i].compareTo(strings[j]) < 0){
                sb.add(strings[i]);
                i++;
            }else{
                sb.add(strings[j]);
                j++;
            }
        }
        while (i<=mid){
            sb.add(strings[i++]);
        }
        while (j<=ei) {
            sb.add(strings[j++]);
        }
        for(int k = 0,l = si;k<sb.size();l++,k++){
            strings[l] = sb.get(k);
        }
    }
    public static void printarr(String[] strings){
        for(String string : strings){
            System.out.println(string+"\t");
        }
    }

    public static void main(String[] args) {
        String[] strings = {"moon","cat","rat","mohit","dinki","tanya"};
        mergeSort(strings,0, strings.length-1);
        printarr(strings);

    }
}
