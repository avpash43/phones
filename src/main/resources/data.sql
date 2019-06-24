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

