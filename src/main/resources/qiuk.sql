drop table if exists lk_tag_blogs;

drop table if exists lk_user_blogs;

drop table if exists log_blogs;

drop table if exists log_user;

drop table if exists t_blogs;

drop table if exists t_tag;

drop table if exists t_user;

/*==============================================================*/
/* Table: lk_tag_blogs                                          */
/*==============================================================*/
create table lk_tag_blogs
(
   tag_id               char(32) not null comment '标签id',
   blogs_id             char(32) not null comment '博客id',
   primary key (tag_id, blogs_id)
);

alter table lk_tag_blogs comment '标签和博客关系表';

/*==============================================================*/
/* Table: lk_user_blogs                                         */
/*==============================================================*/
create table lk_user_blogs
(
   user_id              char(32) not null comment '用户id',
   blogs_id             char(32) not null comment '博客id',
   primary key (user_id, blogs_id)
);

alter table lk_user_blogs comment '用户和博客的关系';

/*==============================================================*/
/* Table: log_blogs                                             */
/*==============================================================*/
create table log_blogs
(
   id                   char(32) not null comment 'id',
   title                varchar(200) not null comment '标题',
   content              text not null comment '内容',
   create_time          datetime not null comment '创建时间',
   primary_id           char(32) not null comment '主表id',
   log_id               char(32) not null comment '操作人',
   log_type             int not null comment '操作类型（0添加，1修改，2删除）',
   primary key (id)
);

alter table log_blogs comment '博客表日志表';

/*==============================================================*/
/* Table: log_user                                              */
/*==============================================================*/
create table log_user
(
   id                   char(32) not null comment 'id',
   email                varchar(100) not null comment '用户邮箱',
   nick_name            varchar(30) not null comment '用户昵称',
   password             char(32) not null comment '用户密码',
   status               int not null comment '状态',
   create_time          datetime not null comment '创建时间',
   primary_id           char(32) not null comment '主表id',
   log_id               char(32) not null comment '操作人',
   log_type             int not null comment '操作类型（0添加，1修改，2删除）',
   primary key (id)
);

alter table log_user comment '用户表日志';

/*==============================================================*/
/* Table: t_blogs                                               */
/*==============================================================*/
create table t_blogs
(
   id                   char(32) not null comment 'id',
   title                varchar(200) not null comment '标题',
   content              text not null comment '内容',
   create_time          datetime not null comment '创建时间',
   primary key (id)
);

alter table t_blogs comment '博客表';

/*==============================================================*/
/* Table: t_tag                                                 */
/*==============================================================*/
create table t_tag
(
   id                   char(32) not null comment 'id',
   tag_name             varchar(50) not null comment '标签名',
   create_time          datetime not null comment '创建时间',
   primary key (id)
);

alter table t_tag comment '标签表';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   char(32) not null comment '用户id',
   email                varchar(100) not null comment '用户邮箱',
   nick_name            varchar(30) not null comment '用户昵称',
   password             char(32) not null comment '用户密码',
   status               int not null comment '状态',
   create_time          datetime not null comment '创建时间',
   primary key (id)
);

alter table t_user comment '用户的主要信息表';

alter table lk_tag_blogs add constraint FK_Reference_1 foreign key (tag_id)
      references t_tag (id) on delete restrict on update restrict;

alter table lk_tag_blogs add constraint FK_Reference_2 foreign key (blogs_id)
      references t_blogs (id) on delete restrict on update restrict;

alter table lk_user_blogs add constraint FK_Reference_3 foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table lk_user_blogs add constraint FK_Reference_4 foreign key (blogs_id)
      references t_blogs (id) on delete restrict on update restrict;
