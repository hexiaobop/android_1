/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/8/3 10:51:51                            */
/*==============================================================*/


drop table if exists ad;

drop table if exists goods;

drop table if exists list;

drop table if exists style;

drop table if exists user;

/*==============================================================*/
/* Table: ad                                                    */
/*==============================================================*/
create table ad
(
   ad_id                int not null auto_increment,
   username             varchar(50) not null,
   adpassword           varchar(255) not null,
   primary key (ad_id)
);

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
   goods_id             int not null auto_increment,
   style_id             int,
   number               int,
   name                 varchar(50),
   imageurl             varchar(100),
   detailurl            varchar(100),
   price                int,
   introduce            varchar(255),
   messagetotal         varchar(255),
   selltotal            int,
   primary key (goods_id)
);

/*==============================================================*/
/* Table: list                                                  */
/*==============================================================*/
create table list
(
   list_id              int not null auto_increment,
   happentime           timestamp,
   money                int,
   comment              varchar(255),
   user_name            varchar(50),
   address			varchar(255),
   phone                varchar(20),
   goods_id             varchar(255),
   primary key (list_id)
);

/*==============================================================*/
/* Table: style                                                 */
/*==============================================================*/
create table style
(
   style_id             int not null auto_increment,
   name                 varchar(50),
   primary key (style_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              int not null auto_increment, 
   username             varchar(50) not null,
   userpassword         varchar(50) not null,
   phone                varchar(50) not null,
   registertime         timestamp ,   
   sex                  varchar(5) not null,
   primary key (user_id)
);

alter table goods add constraint FK_Reference_2 foreign key (style_id)
      references style (style_id) on delete restrict on update restrict;

alter table list add constraint FK_Reference_3 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

