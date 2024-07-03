//total Complexity O(n log n)
public static int[] pairSum(int[] num, int sum){
    int remaining = 0; // to calculate difference between sum and num[i]
    int findNumIndex = -1; // store the index of other pair

    //sorting the array firt
    //O(n log n)
    mergeSort(num, 0, num.length - 1);


    for(int i = 0; i< num.length; i++){
        remaining = sum - num[i]; //calculating remaining

        //if both are same then the index will also be same
        if(remaining == num[i]){
            continue;
        }

        //finding the index of the pair using binary search
        //O(log n)
        findNumIndex = binarySearch(num, remaining);
        if(findNumIndex != -1){
            return new int[]{i, findNumIndex};
        }
    }
    return new int[]{};
}

public static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2; 

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] < target) {
            left = mid + 1;
        } 
        else {
            right = mid - 1;
        }
    }

    return -1;
}

public static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        
        merge(arr, left, mid, right);
    }
}

public static void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    for (int i = 0; i < n1; ++i) {
        leftArray[i] = arr[left + i];
    }
    for (int j = 0; j < n2; ++j) {
        rightArray[j] = arr[mid + 1 + j];
    }


    int i = 0, j = 0;

    int k = left;
    while (i < n1 && j < n2) {
        if (leftArray[i] <= rightArray[j]) {
            arr[k] = leftArray[i];
            i++;
        } else {
            arr[k] = rightArray[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = leftArray[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = rightArray[j];
        j++;
        k++;
    }
}