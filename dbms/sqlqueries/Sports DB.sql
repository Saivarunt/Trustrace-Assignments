-- create database Sport;
-- use Sport;

-- create table Player(
-- player_id int primary key auto_increment,
-- name varchar(50),
-- dob date,
-- no_of_match_played int
-- );

-- create table Matches (
-- match_id int primary key auto_increment,
-- place varchar(50),
-- stadium varchar(50),
-- date_of_match date
-- );

-- create table MatchPlayed (
-- team_score int,
-- player_score int,
-- player_id int,
-- match_id int,
-- foreign key(player_id) references Player(player_id),
-- foreign key(match_id) references Matches(match_id)
-- );