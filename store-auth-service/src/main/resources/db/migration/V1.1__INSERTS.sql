INSERT INTO public.tb_role (id, type) VALUES ('a7dc2bc3-7cb2-4d75-b3e8-bdd90d4225f7', 'ROLE_ADMIN');
INSERT INTO public.tb_role (id, type) VALUES ('cf1f8145-9fa2-4a57-9f8a-22b367ad110c', 'ROLE_CLIENT');

INSERT INTO public.tb_user (id, name, email, password) VALUES ('0dfd56c9-7758-4cc0-984f-5f1a906f728c', 'Jhon', 'jhon@gmail.com','$2a$10$oYjYwYZ41S3qlcDoPn7oFuIbKDah1CKgPm.uE.5KRiDg4E9QNewUO');
INSERT INTO public.tb_user (id, name, email, password) VALUES ('1e7992d7-ce01-4154-91f3-b0580d6ed40f', 'Peter', 'peter@gmail.com','$2a$10$oYjYwYZ41S3qlcDoPn7oFuIbKDah1CKgPm.uE.5KRiDg4E9QNewUO');

INSERT INTO public.tb_user_role (tb_user_id, tb_role_id) VALUES ('0dfd56c9-7758-4cc0-984f-5f1a906f728c', 'a7dc2bc3-7cb2-4d75-b3e8-bdd90d4225f7');
INSERT INTO public.tb_user_role (tb_user_id, tb_role_id) VALUES ('1e7992d7-ce01-4154-91f3-b0580d6ed40f', 'cf1f8145-9fa2-4a57-9f8a-22b367ad110c');
