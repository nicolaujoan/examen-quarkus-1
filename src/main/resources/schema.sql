delete schema
drop table t_users if exists;
drop table t_items if exists;
drop table t_ordenes if exists;
create table t_users (
    user_nom varchar(255) not null, 
    user_prop integer, 
    primary key (user_nom));
create table t_items (
    item_nom varchar(255) not null, 
    item_prop integer, 
    item_tipo varchar(255), 
    primary key (item_nom));
create table t_ordenes (
    ord_id bigint generated by default as identity, 
    ord_user varchar(255), 
    ord_item varchar(255), 
    primary key (ord_id));
alter table t_ordenes 
    add constraint orden_item_fk 
    foreign key (ord_item) references t_items;
alter table t_ordenes 
    add constraint orden_user_fk 
    foreign key (ord_user) references t_users;
insert into 
    t_users (user_nom, user_prop) 
    values
        ('Doobey', 15),
        ('Hermione', 100);
insert into 
    t_items (item_nom, item_prop, item_tipo) 
    values 
        ('+5 Dexterity Vest', 20, 'NormalItem'),
        ('Elixir of the Mongoose', 7, 'NormalItem'),
        ('AgedBrie', 10, 'NormalItem');
insert into 
    t_ordenes (ord_id, ord_user, ord_item) 
    values 
        (1L,'Doobey','Elixir of the Mongoose'),
        (2L,'Hermione','+5 Dexterity Vest');