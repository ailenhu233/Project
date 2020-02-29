public class sort {


    interface SortMethod<T>{
        /**
         *
         *define param(array)
         **/
        T[] sort(T[] array);
    }

    public static void main(String []args){
        SortMethod <Integer>sortMethod=new SortMethod<Integer>() {

            /***
             * 快速排序1
             *以end为pivot的一种排序
             ***/
            @Override
            public Integer[] sort(Integer[] array) {
                if (array==null)
                {
                    System.out.println("Array not be null");
                    return null;
                }

                partition_sort(array,0,array.length-1);

                return array;
            }

            public void partition_sort(Integer[] array , int start, int end){

                if (end<0||start>=end){
                    return;
                }
                int piovt=end;
                int index=start;

                for(int i=start;i<=end;i++)
                {
                    if (array[i]<array[piovt]){
                        int temp=array[i];
                        array[i]=array[index];
                        array[index]=temp;
                        index++;
                    }

                }
                int temp=array[piovt];
                array[piovt]=array[index];
                array[index]=temp;

                partition_sort(array,start,index-1);
                partition_sort(array,index+1,end);
            }

        };
        Integer []array={13,12,11,9,8,7};
        sortMethod.sort(array);
        for (int value:array){
            System.out.println(value);
        }
    }


}
