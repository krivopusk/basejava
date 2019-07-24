create table if not exists resume
(
  uuid      char(36) not null
    constraint resume_pkey primary key,
  full_name text     not null
);

create table if not exists contact
(
  id          serial,
  resume_uuid char(36) not null references resume (uuid) on delete cascade,
  type        text     not null,
  value       text     not null
);

create unique index contact_uuid_type_index
  on contact (resume_uuid, type);

