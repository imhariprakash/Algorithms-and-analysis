import java.util.Scanner;
 
class MergeSortFindInversions{
    public static Scanner sc = new Scanner(System.in);
    public static int inversions = 0;
    public static void main(String[] args){
        int[] array = {1,20,6,4,5};
        //int[] array = {1,2,3,4,-2,-1,7};

        mergeSort(array, 0, array.length - 1);
        System.out.println("Number of inversions: " + inversions);
    }

    public static void mergeSort(int[] array, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    public static void merge(int[] array, int start, int mid, int end){
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while(i <= mid && j <= end){
            if(array[i] <= array[j]){
                temp[k] = array[i];
                i++;
            }
            else{
                temp[k] = array[j];
                j++;
                inversions += mid - i + 1;
            }
            k++;
        }
        while(i <= mid){
            temp[k] = array[i];
            i++;
            k++;
        }
        while(j <= end){
            temp[k] = array[j];
            j++;
            k++;
        }
        for(int l = 0; l < temp.length; l++){
            array[start + l] = temp[l];
        }
    }
}