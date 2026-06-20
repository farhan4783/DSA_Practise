class Solution:
    def maxBuilding(self, n: int, restrictions: list[list[int]]) -> int:
        A = sorted(restrictions + [[1, 0]] + [[n, n - 1]])
        
        for i in range(1, len(A)):
            dist = A[i][0] - A[i - 1][0]
            A[i][1] = min(A[i][1], A[i - 1][1] + dist)
            
        for i in reversed(range(len(A) - 1)):
            dist = A[i + 1][0] - A[i][0]
            A[i][1] = min(A[i][1], A[i + 1][1] + dist)
            
        ans = 0
        for i in range(1, len(A)):
            l, r = A[i - 1][0], A[i][0]
            hL, hR = A[i - 1][1], A[i][1]
            ans = max(ans, max(hL, hR) + (r - l - abs(hL - hR)) // 2)
            
        return ans
