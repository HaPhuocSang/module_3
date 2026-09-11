USE QuanLySinhVien;
select * from student where StudentName like "h%";
select * from class where month(StartDate) = 12;
select * from subject WHERE credit >= 3 AND credit <= 5;
update student set ClassId = 2 where StudentName = "Hung" limit 1;
SELECT s.StudentName, sub.SubName, m.Mark
FROM mark m
JOIN student s ON s.StudentId = m.StudentId
JOIN subject sub ON sub.SubId = m.SubId
ORDER BY m.Mark DESC, s.StudentName ASC;
