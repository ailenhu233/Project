public class search {

    interface  ISearch<T>{
         T search(T[] array,T value);
    }

    public static void main(String []args){
        ISearch <Integer> BinarySearch=new ISearch<Integer>() {

            /***
             * 二分查找法，查到返回下标，查询不到，返回-1
             * **/
            @Override
            public Integer search(Integer[] array,Integer value) {
                if(array==null){
                    System.out.println("array not null");
                    return null;
                }
                return subSearch(array,value,0,array.length-1);
            }

            public int subSearch(Integer[]array,Integer value, int start,int end){
                if(start>end)
                   return -1;
                if(start==end){
                   return array[start]==value?start:-1;
                }
                int middle=(start+end)/2;
                if(array[middle]==value){
                    return middle;
                }else if(array[middle]<value){
                    return subSearch(array,value,start,middle-1);
                }else{
                    return subSearch(array,value,middle+1,end);
                }
            }
        };

        Integer []array={13,12,11,9,8,7};
        System.out.println(BinarySearch.search(array,11));

    }



}
