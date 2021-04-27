# [28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/)

- 使用kms算法实现

- Amazing kms 不如直接 indexOf。。。

```java
class Solution {
    public int strStr(String haystack, String needle) {
       return haystack.indexOf(needle);
    }
}
```