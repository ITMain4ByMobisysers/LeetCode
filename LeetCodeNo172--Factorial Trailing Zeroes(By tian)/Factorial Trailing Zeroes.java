public class Solution {
   
    public int trailingZeroes(int n) {
        /* 正解*/
        int count = 0; 
            int divider = 1 ;
            while(divider <= n/5 ){
                    divider *= 5;
                    count += n / divider;
                   
            }
            return count;
        }
        
        /*为什么从1到n/5 可以，但从5到n时间复杂度就超了
            int count = 0; 
            int divider = 5;
            while(divider <= n ){
                count += n / divider;
                divider *= 5;
            }
            return count;
        
    } */
    
}