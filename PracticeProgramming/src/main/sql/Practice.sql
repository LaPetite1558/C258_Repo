-- create database BLAH;

-- use BLAH;

-- drop database BLAH;

-- create table blah (blahID int, blahVal varchar(20));

-- insert into blah values(1, "fxck");

-- select * from blah;

-- drop table blah;

-- show databases;

-- use mysql;

-- show tables;

-- create database c258;
select * from tb1;
-- use c258;

-- create tablespace tbsp1;

-- create table tb1 
-- ( col1 int,
--   col2 varchar(10)
-- )
-- tablespace tbsp1;

select * from tb1 where col2 like "%b%";

use hr;

show tables;

select * from countries;
-- insert into tb1 values (1, "blah");

-- insert into tb1 (col1, col2) values 
-- 	(2, "bleh"),
--     (3, "baah"),
--     (4, "ohno"),
--     (5, "notthe"),
--     (6, "bees!!"),
--     (7, "they're"),
--     (8, "inmyeyes"),
--     (9, "raaaghhrrl");

select * from employees where first_name like "Nancy";
show tables;

-- select employees.employee_id, employees.first_name, employees.last_name, employees.email, employees.phone_number,
-- 	   employees.hire_date, jobs.job_id, jobs.job_title, jobs.min_salary, jobs.max_salary, employees.salary, employees.commission_pct, employees.manager_id,
--        employees.department_id, departments.department_name, locations.street_address, locations.postal_code, locations.city,
--        locations.state_province, countries.country_name, regions.region_name
--        from employees
-- 	   join jobs on employees.job_id=jobs.job_id
--        join departments on employees.department_id=departments.department_id
--        join locations on departments.location_id=locations.location_id
--        join countries on locations.country_id=countries.country_id
--        join regions on countries.region_id=regions.region_id
--        where employees.first_name like "Nancy";
--        

-- select employees.first_name, employees.last_name, departments.department_id, departments.manager_id
-- from employees
-- inner join departments on employees.department_id
-- where employees.first_name like "Nancy";

select emp.first_name, emp.last_name, loc.street_address,
	   loc.postal_code, loc.city, loc.state_province, cntry.country_name, reg.region_name
       from employees as emp
       inner join departments on emp.department_id=departments.department_id
       inner join locations as loc on departments.location_id=loc.location_id
       inner join countries as cntry on loc.country_id=cntry.country_id
       inner join regions as reg on cntry.region_id=reg.region_id
       order by loc.country_id, emp.last_name, emp.first_name;
       
       
select first_name, last_name, loc.location_id, street_address, 
	   postal_code, city, state_province, cntry.country_id, 
       country_name
       from employees as emp
       join departments as dept on emp.department_id=dept.department_id
       join locations as loc on dept.location_id=loc.location_id
	   join countries as cntry on loc.country_id=cntry.country_id
       order by cntry.country_id, state_province, city, last_name, first_name;
       
select first_name, last_name, loc.*
from employees as emp
join departments as dept on emp.department_id=dept.department_id
join locations as loc on dept.location_id=loc.location_id
order by country_id, state_province, city, last_name, first_name;
       
select departments.department_id, departments.department_name, max(salary) from employees
inner join departments on employees.department_id=departments.department_id
group by departments.department_id
order by salary desc;

select * from employees
where first_name like "Bruce";

select * from employees
where hire_date < (select hire_date from employees where first_name like "Bruce");


select max(hire_date) from employees;

select * from employees
where year(hire_date) = 2000;

select * from employees
where hire_date between '2000-01-04' and '2000-04-21';

select emp.employee_id, emp.first_name, emp.last_name, emp.email, emp.phone_number,
	   emp.hire_date, jobs.job_id, jobs.job_title, jobs.min_salary, jobs.max_salary, 
       emp.salary, emp.commission_pct, emp.manager_id, emp.department_id, dept.department_name, 
       dept.location_id, loc.street_address, loc.postal_code, loc.city, loc.state_province,
       loc.country_id, cntr.country_name, cntr.region_id, reg.region_name
       from employees as emp
       inner join jobs on emp.job_id=jobs.job_id
       inner join departments as dept on emp.department_id=dept.department_id
       inner join locations as loc on dept.location_id=loc.location_id
       inner join countries as cntr on loc.country_id=cntr.country_id
       inner join regions as reg on cntr.region_id=reg.region_id
       where emp.first_name like "Nancy";

select * from employees
where first_name like "N%";       
       
select * from employees
where department_id=90;

select * from employees
where department_id=60
order by employee_id desc;

select employees.employee_id, employees.job_id, employees.email, job_history.start_date, job_history.end_date
from employees
join job_history on employees.job_id=job_history.job_id and employees.employee_id=job_history.employee_id;

select * from employees where employee_id = 102;

select * from employees having employee_id = 102;

select department_id, count(*)
from employees
group by department_id
having count(*) > 5;

select first_name, hire_date, date_format(hire_date, '%M') as month_date
from employees having month_date like "June";


-- 23 JUN 2022 Q1
select count(*), date_format(hire_date, '%Y') as year_date
from employees 
group by year_date;

-- select count(*), date_format(hire_date, '%M%Y') as month_year
-- from employees 
-- group by month_year
-- order by count(*) desc
-- limit 1;

-- select month_year, max(mcount) as max_count
-- from (
-- 	select count(*) as mcount, 
-- 		   date_format(hire_date, '%M%Y') as month_year
-- 	from employees 
--     group by month_year
--     ) 
-- as a;

-- 23 JUN 2022 Q2
select date_format(hire_date, '%M%Y') as month_year, count(*)
from employees
group by month_year
having count(*) = 
(select max(mcount)
from 
(select count(*) mcount, date_format(hire_date, '%M%Y') as month_year
from employees
group by month_year) as a);

select date_format(hire_date, '%M') as hire_month, count(*)
from employees
group by hire_month
having count(*) = 
(select max(mcount)
from 
(select count(*) mcount, date_format(hire_date, '%M') as hire_month
from employees
group by hire_month) as a);


-- 23 JUN 2022 Q3
select date_format(hire_date, '%M') as hire_month, count(*)
from employees
where department_id = 60
group by hire_month
having count(*) = 
(select max(mcount) 
from 
(select count(*) mcount, date_format(hire_date, '%M') as hire_month
from employees
where department_id = 60
group by hire_month) as a);

-- 23 JUN 2022 Q4
select e.*, department_name
from
(select employee_id, first_name, last_name, department_id,
		email, phone_number, hire_date, job_id, commission_pct,
        manager_id, max(salary) as max_salary
from employees as e
group by department_id
order by department_id, max_salary desc) as e
inner join departments as d on e.department_id=d.department_id;

select employee_id, first_name, last_name, department_id, max(salary) as max_salary
from employees as e
where department_id is not null
group by department_id
order by department_id, max_salary desc;

-- 23 JUN 2022 Q5
select * 
from employees
where salary = 
(select max(salary) 
from employees
where salary < 
(select max(salary) 
from employees));

-- 23 JUN 2022 Q6
select *
from
(select department_id, max(salary)
from employees
where salary not in 
(select max(salary)
from employees
group by department_id
order by salary desc)
group by department_id
union
select department_id, max(salary)
from employees
where salary in
(select max(salary)
from employees
group by department_id
order by salary desc)
group by department_id) a
where department_id is not null
group by department_id
order by department_id;




-- select * 
-- from 
-- (select employee_id, first_name, last_name, department_id,
-- 		email, phone_number, hire_date, job_id, commission_pct,
--         manager_id, max(salary) 
-- from employees
-- where salary < 
-- (select employee_id, first_name, last_name, department_id,
-- 		email, phone_number, hire_date, job_id, commission_pct,
--         manager_id, max(salary) 
-- from employees group by department_id)) a
-- group by department_id;






-- select employee_id, first_name, d.department_id, department_name, salary
-- from employees as e
-- inner join departments as d on e.department_id=d.department_id
-- group by d.department_id
-- having salary =  
-- (select employee_id, first_name, last_name, department_id, max(salary) as max_salary
-- from employees as e
-- group by department_id
-- order by department_id, max_salary desc)
-- order by salary desc;





-- select hire_month, count(mcount)
-- from 
-- (select count(*) mcount, date_format(hire_date, '%M') as hire_month 
-- from employees
-- where department_id = 60
-- group by hire_month) as a;

-- select max(mcount) as max_count, hire_month
-- from (
-- 	select count(*) as mcount, 
-- 		   date_format(hire_date, '%M') as hire_month
-- 	from employees 
--     group by hire_month
--     ) as a;