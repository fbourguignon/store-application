create table if not exists tb_product
(
  id          uuid not null,
  description varchar(255),
  name        varchar(255),
  constraint tb_product_pkey
  primary key (id),
  constraint uklovy3681ry0dl5ox28r6679x6
  unique (name)
);