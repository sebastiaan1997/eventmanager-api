create table public.event
(
    id bigint not null
        constraint event_pkey
            primary key,
    description varchar(255),
    end_date timestamp,
    slug varchar(255),
    start_date timestamp,
    status integer,
    title varchar(255),
    url varchar(255)
);

create sequence public.event_seq;
