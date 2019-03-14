import java.util.*;
public class Quick{
  public static void main(String[] args){
    Random r = new Random();
    int[] a = new int[(int)(1e6)];
    for(int i=0;i<a.length;i++){
      a[i]=r.nextInt();
    }
    if(args.length>0){
      quicksort(a);
    }
    else{
      Arrays.sort(a);
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
   if(lo>=hi){
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
