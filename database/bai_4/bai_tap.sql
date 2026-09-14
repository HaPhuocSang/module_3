use quanlysinhvien;
select * from subject order by credit desc limit 1;
select * from mark;
select s.*, m.Mark from subject s join mark m on s.SubId = m.SubId where m.Mark = (select MAX(Mark)from mark);
select st.StudentId, st.StudentName, coalesce(avg(m.Mark), 0) as AverageMark
from student st
left join mark m on m.StudentId = st.StudentId
group by st.StudentId, st.StudentName
order by avg(m.Mark) desc;
select * from mark;