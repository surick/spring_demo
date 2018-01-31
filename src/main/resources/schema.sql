CREATE table contacts(
  id IDENTITY ,
  firstname varchar(30) not null,
  lastname varchar(50) not null,
  phoneNumber varchar(13),
  emailAddress varchar(30)
);