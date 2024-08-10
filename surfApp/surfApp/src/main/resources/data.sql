USE surfapp;
INSERT INTO roles values (1, 'USER'), (2, 'ADMIN');

insert into surfapp.user_profile_type (id, profile_type) values (1, 'CAMP_CREATOR');
insert into surfapp.user_profile_type (id, profile_type) values (2, 'CAMP_COACH');
insert into surfapp.user_profile_type (id, profile_type) values (3, 'CAMP_PARTICIPANT');

insert into surfapp.comment_moods (id, mood) values (1, 'HAPPY');
insert into surfapp.comment_moods (id, mood) values (2, 'SAD');
insert into surfapp.comment_moods (id, mood) values (3, 'INSPIRED');
insert into surfapp.comment_moods (id, mood) values (4, 'MOTIVATED');

insert into surfapp.equipment_types (id, name) values (1, 'SURFBOARD');
insert into surfapp.equipment_types (id, name) values (2, 'SURFSUIT');
insert into surfapp.equipment_types (id, name) values (3, 'WAX');

insert into surfapp.camp_levels (id, name) values (1, 'DEBUTANTS');
insert into surfapp.camp_levels (id, name) values (2, 'ADVANCED');
insert into surfapp.camp_levels (id, name) values (3, 'INTERMEDIATE');
insert into surfapp.camp_levels (id, name) values (4, 'PROFESSIONAL');


INSERT INTO users (id, about, age, can_participate, email, enabled, first_name, height_cm, last_name, password, username, uuid, wight_kg, current_camp_id, profile_id, profile_picture_id)
VALUES (1, 'I love surf and pug dogs', 27, null, 'jery97@abv.bg', false, 'Gabriela', 175, 'Angelova', 'fcc2438b406f7a1cc8c460a5217082a36b039086210aef9d36ceea5ab780d87e2aa04ba36e57bf86d2924352faa81935', 'gabriellaangelova', '4cd0e19a-7041-46cf-a603-74bb7e79da89', 55, null, 1, null);

INSERT INTO users_roles(user_id, role_id)
VALUES (1,1), (1,2);