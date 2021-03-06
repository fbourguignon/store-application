create table if not exists tb_role
(
  id          uuid not null,
  name varchar(60),
  constraint tb_role_pkey
  primary key (id),
  constraint uk_igh0hgnpu0k4vj2cyyiivfene
  unique (name)
);

create table if not exists tb_user
(
  id          uuid not null,
  name      varchar(255),
  email      varchar(255),
  password  varchar(255),
  constraint tb_user_pkey
  primary key (id),
  constraint uk185jnnqywclk3gnvbsnnyq6g7
  unique (email)
);

create table if not exists tb_user_role
(
  tb_user_id uuid not null,
  tb_role_id uuid not null,
  constraint tb_user_role_pkey
  primary key (tb_user_id, tb_role_id),
  constraint fkbb47wlqy20p9ibpd15dhlgi83
  foreign key (tb_user_id) references tb_user,
  constraint fkmew46kle22413jg5fwgsrqf8m
  foreign key (tb_role_id) references tb_role
);

