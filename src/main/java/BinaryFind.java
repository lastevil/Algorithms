public class BinaryFind {
    public static int findLost(int arr[]) {
        return findLost(arr,0,arr.length);
    }


    public static int findLost(int arr[],int begin,int end) {
        if(begin==end){
            return 1;
        }
        int base = (begin+end)/2;
        if (((base+1)!=arr[base])&&(base==arr[base-1])){
            return base+1;
        }
        if (((base+1)!=arr[base])&&(base!=arr[base-1])){
            return findLost(arr,0,base-1);
        }
        if (((base+1)==arr[base])&&(base==arr[base-1])){
            return findLost(arr,base+1,arr.length);
        }
        return -1;
    }
}
