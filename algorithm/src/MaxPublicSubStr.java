public class MaxPublicSubStr {

    public static void main(String[]args ){
        String str1="abcdefgh";
        String str2="asearfg";
        int [][]array=getSubStringLength(str1.toCharArray(),str2.toCharArray());
        int i=str1.length();int j=str2.length();
        String s = "";
        while(i>=1&&j>=1) {

           if (array[i][j] > array[i - 1][j] && array[i][j] > array[i][j - 1]) {
               s = str1.toCharArray()[i - 1] + s;
               i--;
               j--;
           }else if(array[i][j] > array[i - 1][j]&&array[i][j] == array[i][j - 1]){
               j--;
           }else{
               i--;
           }
       }
       System.out.print(s);

    }


    public static int [][] getSubStringLength(char[]str1,char[]str2){

        int [][]array=new int[str1.length+1][str2.length+1];
        for(int []sub:array){
            sub=new int[str2.length+1];
        }
        for (int i=0;i<str1.length;i++) {

            for (int j = 0; j < str2.length; j++) {
                      if(str1[i]==str2[j]){
                          array[i+1][j+1]=array[i][j]+1;
                      }else{
                          array[i+1][j+1]=array[i][j+1]>array[i+1][j]?array[i][j+1]:array[i+1][j];
                      }

            }
        }

        return array;
    }








}
