# [182. 查找重复的电子邮箱](https://leetcode-cn.com/problems/duplicate-emails/)

- 1. 使用 group by 对 email 字段进行归类，并计算数量
    ```sql
     select Email,count(*) c from Person group by Email;
    ```
- 2. 将1中的查询结果作为临时表进行二次查询，查询email字段中大于1的值
    ```sql
    select Email from (select Email,count(*) c from Person group by Email) as t where c > 1;
    ```