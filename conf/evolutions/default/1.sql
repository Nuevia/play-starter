# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table mapping (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  mod_ts                    timestamp,
  constraint pk_mapping primary key (id))
;

create sequence mapping_seq;




# --- !Downs

drop table if exists mapping cascade;

drop sequence if exists mapping_seq;

