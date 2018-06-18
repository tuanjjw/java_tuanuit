/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


public class Sort {
    private int NumberofArr; 
    private int[][] Steptable;
    private int Step;
    public Sort(int numberofArr) {

       NumberofArr=numberofArr;
       Steptable = new int[3][100];
       Step=0;
    }
    
    public void Swap(int n, int m){
        int temp = n;
        n = m;
        m = temp;
    }
    
    public int[][] SelectionSort(int[]arr){
        Step=0;
        for (int i = 0; i < NumberofArr - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < NumberofArr; j++)
            {
                Steptable[0][Step]=index;
                Steptable[1][Step]=j;
                Steptable[2][Step]=0;
                if (arr[j] < arr[index])
                    index = j;
                Step++;
            }
            if(index!=i)
            {
                int temp=arr[index];
                arr[index]=arr[i];
                arr[i]=temp;
                Steptable[0][Step]=i;
                Steptable[1][Step]=index;
                Steptable[2][Step]=1;
                Step++;
            } 
            
            
        }
        return Steptable;
    }
     public  int[][] InsertionSort(int[]arr)
     {
        Step=0;
        for (int i = 1; i < NumberofArr; i++) {
            for(int j = i ; j > 0 ; j--){
                
                Steptable[0][Step]=j;
                Steptable[1][Step]=j-1;
                if(arr[j] < arr[j-1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    Steptable[2][Step]=1;
                } else Steptable[2][Step]=0;
                Step++;

            }
        }
        return Steptable;
    }
    public int[][] BubbleSort(int[] arr){
        int k;
        Step=0;
        for (int j = NumberofArr; j >= 0; j--) {
            for (int i = 0; i < j - 1; i++) {
                k = i + 1;
                Steptable[0][Step]=i;
                Steptable[1][Step]=k;
                if (arr[i] > arr[k]) {
                    int temp=arr[i];
                    arr[i]=arr[k];
                    arr[k]=temp;
                    Steptable[2][Step]=1;
                }else Steptable[2][Step]=0;
                Step++;
            }
        }
        return Steptable;
    }
    public  int[][] QuickSort(int[] arr,int left, int right)
    {
        int i = left, j = right;
        int pivot = arr[(left + right) / 2];
        int mid=(left+right)/2;
        while (i <= j) {
            do
            {
                
                Steptable[0][Step]=i;
                Steptable[1][Step]=mid;
                Steptable[2][Step]=0;
                Step++;                
                if(arr[i] >= pivot)
                    break;
                if(arr[i] < pivot)
                    i++;
            }while (true);
            do
            {
                Steptable[0][Step]=j;
                Steptable[1][Step]=mid;
                Steptable[2][Step]=0;
                Step++;
                if(arr[j] <= pivot)
                    break;
                if(arr[j] > pivot)
                    j--;
            }while (true);
            if (i < j) 
            {
                if(i==mid)
                    mid=j;
                else
                    if(j==mid)
                        mid=i;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                Steptable[0][Step]=i;
                Steptable[1][Step]=j;
                Steptable[2][Step]=1;
                Step++;
                i++;
                j--;
            } else if (i==j)
            {
                i++;
                j--;
            }
        }
        if (left < i - 1)
            QuickSort(arr,left, i - 1);
        if (i < right)
            QuickSort(arr,i, right);
        return Steptable;
    }
    public  int[][] ShakerSort(int[]arr) {
        Step=0;
        for (int i = 0; i < NumberofArr/2; i++) {
            boolean swapped = false;
            for (int j = i; j < NumberofArr - i - 1; j++) {
                Steptable[0][Step]=j;
                Steptable[1][Step]=j+1;               
                if (arr[j] > arr[j+1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;                 
                    swapped = true;
                    Steptable[2][Step]=1;
                }else Steptable[2][Step]=0;
                Step++;
                
            }
            for (int j = NumberofArr - 2 - i; j > i; j--) {
                Steptable[0][Step]=j;
                Steptable[1][Step]=j-1; 
                if (arr[j] < arr[j-1]) {
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swapped = true;
                    Steptable[2][Step]=1;
                }else Steptable[2][Step]=0;
                Step++;
            }
            if(!swapped) break;
        }
        return Steptable;
    }
//    public  int[][] MergeSort(int[] Arr) {
//        int size = Arr.length;
//        if (size < 2)
//            return Steptable;
//        int mid = size / 2;
//        int leftSize = mid;
//        int rightSize = size - mid;
//        int[] left = new int[leftSize];
//        int[] right = new int[rightSize];
//        for (int i = 0; i < mid; i++) {
//            left[i] = Arr[i];
//
//        }
//        for (int i = mid; i < size; i++) {
//            right[i - mid] = Arr[i];
//        }
//        MergeSort(left);
//        MergeSort(right);
//        //merge(left, right, arr);
//        
//        
//        //int leftSize = left.length;
//        //int rightSize = right.length;
//        int i = 0, j = 0, k = 0;
//        while (i < leftSize && j < rightSize) {
//            if (left[i] <= right[j]) {
//                Arr[k] = left[i];
//                i++;
//                k++;
//            } else {
//                Arr[k] = right[j];
//                k++;
//                j++;
//            }
//        }
//        while (i < leftSize) {
//            arr[k] = left[i];
//            k++;
//            i++;
//        }
//        while (j < leftSize) {
//            arr[k] = right[j];
//            k++;
//            j++;
//        }
//        return Steptable;
//    }
//    public  int[][] HeapSort(int[] arr)
//    {
//        int n = NumberofArr;
// 
//        // Build heap (rearrange array)
//        for (int i = n / 2 - 1; i >= 0; i--)
//            heapify(arr, n, i);
// 
//        // One by one extract an element from heap
//        for (int i=n-1; i>=0; i--)
//        {
//            // Move current root to end
//            Swap(arr[0], arr[i]);
// 
//            // call max heapify on the reduced heap
//            heapify(arr, i, 0);
//        }
//        return arr;
//    }
//    public  void heapify(int arr[], int n, int i)
//    {
//        int largest = i;  // Initialize largest as root
//        int l = 2*i + 1;  // left = 2*i + 1
//        int r = 2*i + 2;  // right = 2*i + 2
// 
//        // If left child is larger than root
//        if (l < n && arr[l] > arr[largest])
//            largest = l;
// 
//        // If right child is larger than largest so far
//        if (r < n && arr[r] > arr[largest])
//            largest = r;
// 
//        // If largest is not root
//        if (largest != i)
//        {
//            Swap(arr[i], arr[largest]);
// 
//            // Recursively heapify the affected sub-tree
//            heapify(arr, n, largest);
//        }
//    }
    public int getStep()
    {
        return Step;
    }
}
