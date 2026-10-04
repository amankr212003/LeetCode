# Write your MySQL query statement below
select 
round(count(*)/(select count(distinct (player_id)) from activity),2) as fraction
from activity a
join (
    select player_id, min(event_date) as first_date
    from activity
    group by player_id
) f
on a.player_id=f.player_id
where datediff(a.event_date,f.first_date)=1;