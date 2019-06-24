create table if not exists Employee (
  id identity not null,
  firstname varchar(25) not null,
  lastname varchar(25) not null
);

create table if not exists Position (
  id identity not null,
  position varchar(100) not null,
  description varchar(255)
);

create table if not exists Departament (
  id identity not null,
  departament varchar(100) not null,
  description varchar(255)
);

create table if not exists Address (
  id identity not null,
  city varchar(50) not null,
  street varchar(255) not null,
  build varchar(10) not null
);

create table if not exists PhoneNumbers (
  id identity not null,
  external int not null,
  internal smallint not null,
  personal bigint
);

create table if not exists Abonent (
  id identity not null,
  employee bigint not null,
  position bigint not null,
  departament bigint not null,
  address bigint not null,
  phonenumber bigint not null,
  headofunit bigint not null,
  wasadded timestamp not null
);

alter table Abonent
    add foreign key (employee) references Employee(id);
alter table Abonent
    add foreign key (position) references Position(id);
alter table Abonent
    add foreign key (departament) references Departament(id);
alter table Abonent
    add foreign key (address) references Address(id);
alter table Abonent
    add foreign key (phonenumber) references Abonent(id);
alter table Abonent
    add foreign key (headofunit) references Employee(id);
