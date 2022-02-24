DROP TABLE IF EXISTS TBL_ENCUESTA;

CREATE TABLE TBL_VEHICLE(
    id bigint primary key auto_increment,
    county_fips long NOT NULL,
    county_name varchar(250) NOT NULL,
    state_name varchar(250) NOT NULL,
    date date NOT NULL,
    county_vmt long not null,
    baseline_jan_vmt long not null,
    percent_change_from_jan decimal not null,
    mean7_county_vmt decimal not null,
    mean7_percent_change_from_jan decimal not null,
    date_at_low date not null,
    mean7_county_vmt_at_low decimal not null,
    percent_change_from_low decimal not null
);