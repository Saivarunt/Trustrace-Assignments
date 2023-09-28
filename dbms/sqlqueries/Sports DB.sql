create database Sport;
use Sport;

create table team(
team_id varchar(10) primary key,
name text,
owner varchar(50)
);

create table Player(
player_id int primary key auto_increment,
name varchar(50),
dob date,
no_of_match_played int,
team_id varchar(10),
foreign key(team_id) references team(team_id)
);

create table seasons(
	s_id int,
    player_id int,
    team_id varchar(10),
    foreign key(team_id) references team(team_id),
    foreign key (player_id) references Player(player_id),
    primary key (s_id, player_id)
);

create table Matches (
match_id int primary key auto_increment,
place varchar(50),
season int,
date_of_match date,
goals int,
own_score int,
opp_score int,
home varchar(10),
away varchar(10),
foreign key(home) references team(team_id),
foreign key(away) references team(team_id),
foreign key(season) references seasons(s_id)
);

create table MatchPlayed (
minutes time,
assist int,
goals_scored int,
player_id int,
match_id int,
foreign key(player_id) references Player(player_id),
foreign key(match_id) references Matches(match_id)
);