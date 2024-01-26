class Solution {
    
    static int [] count;
    
    static void split (int [][] arr){
        int num = arr[0][0];
        boolean doSplit = false;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                 if(num != arr[i][j]){
                     doSplit = true;
                     break;
                 }
            }
        }
        if(doSplit){
            int size = arr.length;
            int [][] newArr1 = new int[size/2][size/2];
            int [][] newArr2 = new int[size/2][size/2];
            int [][] newArr3 = new int[size/2][size/2];
            int [][] newArr4 = new int[size/2][size/2];
            
            for(int i = 0; i < size/2; i++){
                for(int j = 0; j < size/2; j++){
                    newArr1[i][j] = arr[i][j];
                    newArr2[i][j] = arr[i][j+size/2];
                    newArr3[i][j] = arr[i+size/2][j];
                    newArr4[i][j] = arr[i+size/2][j+size/2];
                }
            }
            split(newArr1);
            split(newArr2);
            split(newArr3);
            split(newArr4);
                
        }
        else{
            count[num]++; 
            return;
        }
        
    }
    
    
    
    public int[] solution(int[][] arr) {
   

        count = new int[2];
        split(arr);
        return count;
    }
}