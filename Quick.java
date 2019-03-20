import java.util.*;
public class Quick{
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
private static void insertionsort(int[] data, int lo, int hi){
  int index=lo+1;
  for(int i=index;i<hi+1;i++){
    if(data[i-1]>data[i]){
      int temp=data[i];
      int j=i-1;
      while(j>=lo&&temp<data[j]){
          data[j+1]=data[j];
          j--;
      }
      data[j+1]=temp;
    }
  }
}
/*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
 public static void quicksort(int[] data){
   quicksortH(data,0,data.length-1);
 }
 public static void quicksortH(int [] data, int lo, int hi){
   if(hi-lo+1<50){
     insertionsort(data,lo,hi);
     return;
   }
   int piv = partition(data,lo,hi);
   quicksortH(data,lo,piv-1);
   quicksortH(data,piv+1,hi);
 }
  public static String arrayToString(int [] ary){
    String ans="";
    for(int i=0;i<ary.length;i++){
      ans+=ary[i];
      ans+=" ";
    }
    return ans;
  }
  public static int quickselect(int[] data, int k){
      int i = 0;
      int j = data.length-1;
      while(i<j+1){
        int f = partition(data,i,j);
        if(f==k){
          return k;
        }
        else if(f<k){
          i=f+1;
        }
        else{
          j=f-1;
        }
      }
      return -1;
  }
  public static int partition(int [] data, int start, int end){
    if(data.length==1){
      return 0;
    }
    int ind = start;
    int s=data[start];
    int m=data[(start+end)/2];
    int e=data[end];
    int max = Math.max(s,Math.max(m,e));
    int min = Math.min(s,Math.min(m,e));
    Random r = new Random();
    int[] choices = {s,m,e};
    if(choices[0]==s+m+e-max-min){
        ind = start;
    }
    else if(choices[1]==s+m+e-max-min){
      ind = (start+end)/2;
    }
    else{
      ind = end;
    }
    int p = data[ind];
    int i=start+1;
    int j=end;
    int temp = data[start];
    data[start]=p;
    data[ind]=temp;
    while(i<j+1){
      if(data[i]>p||(data[i]==p&&r.nextInt(2)==1)){
        temp = data[i];
        data[i]=data[j];
        data[j]=temp;
        j--;
        if(data[i]>p);
        i--;
      }
      i++;
    }
    temp = data[start];
    data[start]=data[i-1];
    data[i-1]=temp;
    return i-1;
  }
}
