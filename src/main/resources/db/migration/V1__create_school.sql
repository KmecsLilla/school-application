create table division (
                          id bigint generated by default as identity,
                          class_master varchar(255),
                          name varchar(255),
                          number_of_members integer,
                          startup_year integer,
                          school_id bigint, primary key (id)
)