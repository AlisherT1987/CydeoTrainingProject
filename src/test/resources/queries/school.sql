select first_name as "Firstname",last_name as "Lastname",email_address as "Email",join_date as "Joining Date",subject as "Subject",phone as "Mobile number",gender as "Gender",birth_date as "Birth Date",major as "Major",batch as "Batch",company_name as "Company Name",title as "Title",start_date as "Start date",city as "City",street as "Street",zip_code as "ZipCode",state as "State",permanent_address "Permanent Address"  from students s join companies c on s.student_id = c.student_id join address a on c.company_id = a.company_id join contacts c2 on s.student_id = c2.student_id
where first_name='Anna';
select student_id from students
where first_name='Anna';
select * from students left outer join companies c on students.student_id = c.student_id
where first_name='Anna';

