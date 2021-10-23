drop database expensetrackerdb;
drop user expensetracker;

create user expensetracker with password 'password';
create database expensetracker with template = template0 owner = expensetracker;

\connect expensetrackerdb;
alter default privileges grant all on tables to expensetracker;
alter default privileges grant all on sequences to expensetracker;

-- creating database with fields
create table et_users(
    user_id integer primary key not null;
    first_name varchar(20) not null;
    last_name varchar(20) not null;
    email varchar(30) not null;
    password text not null;
);
-- a user can have multiple catefories so user_id will be a foreign key in here
create table et_categories(
    category_id integer primary key not null;
    user_id integer not null;
    title varchar(20) not null;
    description varchar(50) not null;
);

alter table et_categories add constraints cat_users_fk
foreign key(user_id) references et_users(user_id);

create table et_transactions(
    transaction_id integer primary key not null;
    category_id integer not null;
    user_id integer  not null;
    amount numeric(10,2) not null;
    note varchar(50) not null;
    transaction_date bigint not null
);

alter table et_transactions add constraints trans_cat_fk
foreign key(category_id) references et_categories(category_id);

alter table et_transactions add constraints trans_users_fk
foreign key(user_id) references et_users(user_id);

-- creating sequences for all the tables
create sequence et_users_seq increment start 1;
create sequence et_categories_seq increment start 1;
create sequence et_transactions_seq increment          start 1000;
