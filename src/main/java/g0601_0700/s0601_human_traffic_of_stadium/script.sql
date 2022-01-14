# Write your MySQL query statement below
# #Hard #Database
select id, visit_date, people
from 
(select 

id, visit_date, people, 
 lead(people, 1) over ( order by id) as 1_next, 
 lead(people, 2) over ( order by id) as 2_next,
 lag(people, 1) over ( order by id) as 1_prev,
 lag(people, 2) over ( order by id) as 2_prev

from Stadium
) a

where (people >= 100) and

(
    (1_next >= 100 and 2_next >=100) or
    (1_prev >= 100 and 2_prev >=100) or
    (1_prev >= 100 and 1_next >=100)
)
