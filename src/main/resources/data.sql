delete from Abonent;
delete from Employee;
delete from Position;
delete from Departament;
delete from PhoneNumbers;
delete from Abonent;

insert into Employee (firstname, lastname)
                values ('Frodo', 'Beggins');
insert into Position (position, description)
                values ('Hobbit', 'little man');
insert into Departament (departament, description)
                values ('Magic thing', 'Some magic thing');
insert into Address (city, street, build)
                values ('Shire', 'hobbiton', '1');
insert into PhoneNumbers (external, internal, personal)
                values (2222222, 100, 89040000000);
insert into Abonent (employee, position, departament, address, phonenumber, headofunit, wasadded)
                values ('1', '1', '1', '1', '1', '1', '2019-06-24 13:00:00');

create view ABONENT_VIEW as (
select
    ab.id as id,
    emp.firstname as firstname,
    emp.lastname as lastname,
    pos.position as position,
    dep.departament as departament,
    ad.city as city,
    ad.street as street,
    ad.build as build,
    phn.external as external_number,
    phn.internal as internal_number,
    phn.personal as personal_number,
    hou.lastname as headofunit_lasname,
    hou.firstname as headofunit_firstname,
    ab.wasadded as wasadded
from abonent as ab
    left join address as ad
        on ad.id=ab.address
    left join departament as dep
        on dep.id=ab.departament
    left join employee as emp
        on emp.id=ab.employee
    left join phonenumbers as phn
        on phn.id=ab.phonenumber
    left join employee as hou
        on hou.id=ab.headofunit
    left join position as pos
        on pos.id=ab.position
)