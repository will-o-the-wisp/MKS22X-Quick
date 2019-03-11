import java.util.*;
public class Quick{
  public static void main(String[] args){

  }

/*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
  public static String arrayToString(int [] ary){
    String ans="";
    for(int i=0;i<ary.length;i++){
      ans+=ary[i];
      ans+=" ";
    }
    return ans;
  }
  public static int quickselect(int[] data, int k){
    
  }
  public static int partition(int [] data, int start, int end){
    if(data.length==1){
      return 0;
    }
    //System.out.println(arrayToString(data));
    Random r = new Random();
    int ind = start+r.nextInt(end-start+1);
    int p = data[ind];
    //System.out.println(p);
    int i=start+1;
    int j=end;
    int temp = data[start];
    data[start]=p;
    data[ind]=temp;
    //System.out.println(arrayToString(data));
    while(i<j+1){
      //System.out.println(i+" "+j);
      //System.out.println(arrayToString(data));
      if(data[i]>p){
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
    //System.out.println(arrayToString(data));
    return i-1;
  }
}
