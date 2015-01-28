public class Solution {
    public int majorityElement(int[] num) {
      int count = 0;
      int number = 0;
      for(int i = 0; i< num.length; i++){
          if(count == 0){
              count = 1;
              number = num[i];
          }else{
              if(number == num[i]){
                  count ++;
              }else{
                  count --;
              }
          }
      }
      return number;
    }
   
}