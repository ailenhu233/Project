import java.util.Random;

public class sort {


    interface SortMethod<T>{
        /**
         *
         *define param(array)
         **/
        T[] sort(T[] array);
    }


    public static SortMethod <Integer>quicklySortMethod1=new SortMethod<Integer>() {

        /***
         * 快速排序 固定基准
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



    public static SortMethod <Integer>quicklyMethod2=new SortMethod<Integer>() {

        /***
         * 快速排序--随机基准
         *以
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
            Random rand=new Random(1);

            int piovt= start+rand.nextInt(end-start);
            int temp=array[piovt];
            array[piovt]=array[end];
            array[end]=temp;
            piovt=end;
            int index=start;

            for(int i=start;i<=end;i++)
            {
                if (array[i]<array[piovt]){

                    temp=array[i];
                    array[i]=array[index];
                    array[index]=temp;
                    index++;
                }

            }
            temp=array[piovt];
            array[piovt]=array[index];
            array[index]=temp;

            partition_sort(array,start,index-1);
            partition_sort(array,index+1,end);
        }

    };



    public static SortMethod<Integer>heapSort=new SortMethod<Integer>() {
        @Override
        public Integer[] sort(Integer[] array) {
            buildHeap(array);
            for (int len=array.length-1;len>0;len--){
                int temp=array[len];
                array[len]=array[0];
                array[0]=temp;
                adjustHeap(array,0,len);

            }
            return array;
        }

       public void buildHeap(Integer[] array){
            for(int k=(array.length+1)/2-1;k>=0;k--){
                adjustHeap(array,k,array.length-1);
            }

       }

       public void adjustHeap(Integer []array,int i,int len){
            int left=i*2+1;
            int right=i*2+2;
            int lagest=i;
            if (left<len){
                lagest=array[i]<array[left]?left:i;
            }
           if (right<len){
               lagest=array[lagest]<array[right]?right:lagest;
           }
           if(lagest!=i){
               int temp=array[lagest];
               array[lagest]=array[i];
               array[i]=temp;
               adjustHeap(array,lagest,len);
           }
       }
    } ;

    public static void main(String []args){
        Integer []array={9,5,101,9,8,7};
        heapSort.sort(array);
        for (int value:array){
            System.out.println(value);
        }
    }

}
