package dsatopics.searching;

public class LinearSearchExample {

    static int arrEven[]={11,4,5,16,9,2,14,7};
    static int arrOdd[]={2,4,5,7,9,11,14};
    public static void main(String[] args) {
        System.out.println("\n **********  Linear Search ***********");
        System.out.println("\n Array Items size : "+arrEven.length);
        System.out.println("\n Searched Items available at position : "+linearSearchItem(arrEven,8,5));
    }

    /**
     * find the element position in sorted array using Linear search
     * @param arr
     * @param n
     * @param key
     * @return
     */
    static int linearSearchItem(int [] arr, int n, int key){
        int index = -1;
        for (int i = 0; i <n ; i++) {
            if (key==arr[i]){
                index=i;
                return index;
            }
        }
        return index;
    }

    /**
     * Search item using Linear search with optimal solution
     * @param arr
     * @param n
     * @param key
     * @return
     */
    static int linearSearchOptimal(int [] arr, int n, int key){
        int index=-1;
        int start=0;
        while (start<n){
            if (arr[start]==key){
                index=start;
                return index;
            }else {
                start++;
            }
        }
        return index;
    }
}
