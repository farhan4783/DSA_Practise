class Solution {
    public boolean isPerfect(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

//recursive approach

class Solution {
    public boolean isPerfect(int[] arr) {
        return check(arr, 0, arr.length - 1);
    }

    private boolean check(int[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (arr[left] != arr[right]) {
            return false;
        }

        return check(arr, left + 1, right - 1);
    }
}

