USE kid_invest_db;

# USERS SEEDER
insert into `kid_invest_db`.`users` (`id`, `username`, `password`, `email`, `balance`, `viewed_portfolio`,
                                     `viewed_stand`, `viewed_stocks`, `viewed_store`, `viewed_transactions`, `completed_stock_quiz`, `completed_business_quiz`, `character_id`)
values (1, 'dhurry0', 'JkH7rSdicfB', 'dhalvorsen0@discuz.net', 18638.23, true, true, true, true, true, true, true, 1);
insert into `kid_invest_db`.`users` (`id`, `username`, `password`, `email`, `balance`, `viewed_portfolio`,
                                     `viewed_stand`, `viewed_stocks`, `viewed_store`, `viewed_transactions`, `completed_stock_quiz`, `completed_business_quiz`, `character_id`)
values (2, 'kmarran1', '2gcW9jG4U2TY', 'dbagge1@delicious.com', 10559.32, false, false, false, false, false, true, true, 1);
insert into `kid_invest_db`.`users` (`id`, `username`, `password`, `email`, `balance`, `viewed_portfolio`,
                                     `viewed_stand`, `viewed_stocks`, `viewed_store`, `viewed_transactions`, `completed_stock_quiz`, `completed_business_quiz`, `character_id`)
values (3, 'rottee2', 'oxKJf96', 'agresser2@paypal.com', 19292.8, false, false, false, false, false, false, true, 1);
insert into `kid_invest_db`.`users` (`id`, `username`, `password`, `email`, `balance`, `viewed_portfolio`,
                                     `viewed_stand`, `viewed_stocks`, `viewed_store`, `viewed_transactions`, `completed_stock_quiz`, `completed_business_quiz`, `character_id`)
values (4, 'hstark3', 'wGvHrA9oJfH', 'ksheppard3@eventbrite.com', 12349.08, false, false, false, false, false, false, false, 1);

# BUSINESSES SEEDER
INSERT INTO `kid_invest_db`.`business` (`id`, `name`, `popularity`, `user_id`)
VALUES (1, 'dhurry''s stand', 25, 1);
INSERT INTO `kid_invest_db`.`business` (`id`, `name`, `popularity`, `user_id`)
VALUES (2, 'kmarran''s stand', 55, 2);
INSERT INTO `kid_invest_db`.`business` (`id`, `name`, `popularity`, `user_id`)
VALUES (3, 'rottee''s stand', 10, 3);
INSERT INTO `kid_invest_db`.`business` (`id`, `name`, `popularity`, `user_id`)
VALUES (4, 'hstark''s stand', 0, 4);

# ADD-ONS SEEDER
INSERT INTO `kid_invest_db`.`addons` (`id`, `name`, `popularity_bonus`, `price`)
VALUES (1, 'Big Tree', 40, 4500.00);
INSERT INTO `kid_invest_db`.`addons` (`id`, `name`, `popularity_bonus`, `price`)
VALUES (2, 'Radio', 10, 150.00);
INSERT INTO `kid_invest_db`.`addons` (`id`, `name`, `popularity_bonus`, `price`)
VALUES (3, 'Sign', 20, 300.00);
INSERT INTO `kid_invest_db`.`addons` (`id`, `name`, `popularity_bonus`, `price`)
VALUES (4, 'Trash Cans', 10, 150.00);
INSERT INTO `kid_invest_db`.`addons` (`id`, `name`, `popularity_bonus`, `price`)
VALUES (5, 'Plants', 20, 300.00);
INSERT INTO `kid_invest_db`.`addons` (`id`, `name`, `popularity_bonus`, `price`)
VALUES (6, 'Lights', 30, 1850.00);
INSERT INTO `kid_invest_db`.`addons` (`id`, `name`, `popularity_bonus`, `price`)
VALUES (7, 'Fridge', 30, 2300.00);
INSERT INTO `kid_invest_db`.`addons` (`id`, `name`, `popularity_bonus`, `price`)
VALUES (8, 'Chairs', 20, 1500.00);
INSERT INTO `kid_invest_db`.`addons` (`id`, `name`, `popularity_bonus`, `price`)
VALUES (9, 'Big Table', 20, 1000.00);
INSERT INTO `kid_invest_db`.`addons` (`id`, `name`, `popularity_bonus`, `price`)
VALUES (10, 'Fountain', 50, 7000.00);

# BUSINESS HAS ADDONS SEEDER
INSERT INTO `kid_invest_db`.`business_has_addons` (`business_id`, `addon_id`)
VALUES (1, 1);
INSERT INTO `kid_invest_db`.`business_has_addons` (`business_id`, `addon_id`)
VALUES (2, 3);
INSERT INTO `kid_invest_db`.`business_has_addons` (`business_id`, `addon_id`)
VALUES (2, 1);
INSERT INTO `kid_invest_db`.`business_has_addons` (`business_id`, `addon_id`)
VALUES (3, 4);

# # STOCK SEEDER
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (1, ''PNM Resources, Inc. (Holding Co.)'', 83.03, 82.03, 79.03, 92.03, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (2, ''The Community Financial Corporation'', 41.47, 40.47, 37.47, 50.47, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (3, ''Rocket Fuel Inc.'', 53.71, 52.71, 49.71, 62.71, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (4, ''Gener8 Maritime, Inc.'', 47.63, 46.63, 43.63, 56.63, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (5, ''West Pharmaceutical Services, Inc.'', 18.18, 17.18, 14.18, 27.18, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (6, ''Monolithic Power Systems, Inc.'', 81.09, 80.09, 77.09, 90.09, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (7, ''Sibanye Gold Limited'', 43.96, 42.96, 39.96, 52.96, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (8, ''Silvercrest Asset Management Group Inc.'', 67.83, 66.83, 63.83, 76.83, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (9, ''Cresud S.A.C.I.F. y A.'', 97.87, 96.87, 93.87, 106.87, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (10, ''OFG Bancorp'', 18.09, 17.09, 14.09, 27.09, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (11, ''Bankwell Financial Group, Inc.'', 37.44, 36.44, 33.44, 46.44, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (12, ''Nuveen Georgia Quality Municipal Income Fund '', 44.62, 43.62, 40.62, 53.62, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (13, ''Lantronix, Inc.'', 39.66, 38.66, 35.66, 48.66, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (14, ''Waste Management, Inc.'', 82.65, 81.65, 78.65, 91.65, ''2020-03-27 00:00:00'');
# insert into `kid_invest_db`.`stocks` (`id`, `name`, `market_price`, `open_price`, `low_price`, `high_price`, `time`) values (15, ''Dynex Capital, Inc.'', 44.69, 43.69, 40.69, 53.69, ''2020-03-27 00:00:00'');

# PRACTICE STOCK
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (1, 'Frank''s Fresh Foods', 'FFS', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (2, 'Dayna''s Daily Bookstore', 'DDS', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (3, 'Computers R'' Us', 'CRU', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (4, 'Xavier''s Exotic Pets', 'XEP', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (5, 'Adele''s Apple Farm', 'AAF', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (6, 'George''s Gaming Corner', 'GGC', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (7, 'Tony''s Taco Restaurant', 'TTR', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (8, 'Phillip''s Pharmacy', 'PHP', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (9, 'Hung''s Hat Shop', 'HHS', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (10, 'Dolly''s Diamonds', 'DOLLY', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (11, 'Froggy Fuel Center', 'FROG', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (12, 'Sonny''s Sporting Tickets', 'SST', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (13, 'Crazy Carl''s Car Shop', 'CCC', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (14, 'Bob''s Bubble Gum', 'BBG', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (15, 'Little Princess Phone Store', 'LPPS', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (16, 'Bruce''s Backyard Security', 'BSEC', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (17, 'Sally''s Stylish Outfits', 'SSO', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (18, 'Charlie''s Community Bank', 'CCB', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (19, 'Victor''s Vitamin Store', 'VVS', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stocks` (`id`, `name`, `ticker`, `market_price`, `open_price`, `low_price`, `high_price`, `year_low_price`, `year_high_price`, `percentage_change`, `time`) values (20, 'Big Bear Storage', 'BEAR', 0, 0, 0, 0, 0, 0, 0, '2020-03-27 00:00:00');


# USER HAS STOCK SEEDER
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (1, 1, 4, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (1, 11, 12, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (1, 4, 4, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (2, 5, 3, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (2, 7, 24, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (2, 14, 25, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (2, 3, 14, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (2, 2, 24, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (3, 15, 8, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (3, 12, 25, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (3, 1, 4, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (3, 11, 13, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (4, 9, 24, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (4, 4, 24, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (4, 8, 21, 0);
insert into `kid_invest_db`.`user_has_stocks` (`user_id`, `stock_id`, `shares`, `avg_purchase_price`)
values (4, 10, 5, 0);


# STOCK TRANSACTION SEEDER
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (1, 1, 1, 4, 83.03, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (2, 1, 11, 12, 37.44, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (3, 1, 4, 4, 47.63, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (4, 2, 5, 3, 18.18, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (5, 2, 7, 24, 43.96, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (6, 2, 14, 25, 82.65, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (7, 2, 3, 14, 53.71, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (8, 2, 2, 24, 41.47, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (9, 3, 15, 8, 44.69, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (10, 3, 12, 25, 44.62, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (11, 3, 1, 4, 83.03, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (12, 3, 11, 13, 37.44, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (13, 4, 9, 24, 97.87, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (14, 4, 4, 24, 47.63, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (15, 4, 8, 21, 67.83, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`stock_transactions` (`id`, `user_id`, `stock_id`, `shares_bought_sold`, `price`, `time`)
values (16, 4, 10, 5, 18.09, '2020-03-27 00:00:00');

# LEMONADES SEEDER
INSERT INTO `kid_invest_db`.`lemonades` (`id`, `name`, `price`)
VALUES (1, 'lemonade', 4);
INSERT INTO `kid_invest_db`.`lemonades` (`id`, `name`, `price`)
VALUES (2, 'strawberry lemonade', 4.5);
INSERT INTO `kid_invest_db`.`lemonades` (`id`, `name`, `price`)
VALUES (3, 'peach lemonade', 5.5);
INSERT INTO `kid_invest_db`.`lemonades` (`id`, `name`, `price`)
VALUES (4, 'blueberry lemonade', 5.5);
INSERT INTO `kid_invest_db`.`lemonades` (`id`, `name`, `price`)
VALUES (5, 'raspberry lemonade', 6.5);

# INGREDIENTS SEEDER
INSERT INTO `kid_invest_db`.`ingredients` (`id`, `name`, `cost`)
VALUES (1, 'lemon', .25);
INSERT INTO `kid_invest_db`.`ingredients` (`id`, `name`, `cost`)
VALUES (2, 'ice', .10);
INSERT INTO `kid_invest_db`.`ingredients` (`id`, `name`, `cost`)
VALUES (3, 'sugar', .10);
INSERT INTO `kid_invest_db`.`ingredients` (`id`, `name`, `cost`)
VALUES (4, 'honey', .15);
INSERT INTO `kid_invest_db`.`ingredients` (`id`, `name`, `cost`)
VALUES (5, 'sweetener', .15);
INSERT INTO `kid_invest_db`.`ingredients` (`id`, `name`, `cost`)
VALUES (6, 'strawberry', .10);
INSERT INTO `kid_invest_db`.`ingredients` (`id`, `name`, `cost`)
VALUES (7, 'peach', .35);
INSERT INTO `kid_invest_db`.`ingredients` (`id`, `name`, `cost`)
VALUES (8, 'blueberry', .05);
INSERT INTO `kid_invest_db`.`ingredients` (`id`, `name`, `cost`)
VALUES (9, 'raspberry', .05);


# LEMONADES HAS INGREDIENTS SEEDER
# LEMONADE - 2 lemon, 2 ice, 2 sugars
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (1, 1, 1, 2);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (2, 1, 2, 2);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (3, 1, 3, 2);

# STRAWBERRY LEMONADE - 1 lemon, 2 ice, 2 sugar, 3 strawberries
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (4, 2, 1, 1);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (5, 2, 2, 2);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (6, 2, 3, 2);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (7, 2, 6, 3);

# PEACH LEMONADE - 1 lemon, 2 ice, 2 honey, 1 peach
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (8, 3, 1, 1);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (9, 3, 2, 2);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (10, 3, 4, 2);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (11, 3, 7, 1);

# BLUEBERRY LEMONADE - 1 lemon, 2 ice, 1 honey, 1 sweetner, 8 blueberries
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (12, 4, 1, 1);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (13, 4, 2, 2);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (14, 4, 4, 1);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (15, 4, 5, 1);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (16, 4, 8, 8);

# RASPBERRY LEMONADE - 1 lemon, 2 ice, 1 sugar, 1 sweetner, 8 raspberries
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (17, 5, 1, 1);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (18, 5, 2, 2);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (19, 5, 3, 1);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (20, 5, 5, 1);
INSERT INTO `kid_invest_db`.`lemonades_has_ingredients` (`id`, `lemonade_id`, `ingredient_id`, `count`)
VALUES (21, 5, 9, 8);

# BUSINESS HAS INGREDIENT SEEDER
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (1, 1, 1, 58, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (2, 1, 2, 49, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (3, 1, 3, 35, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (4, 1, 4, 38, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (5, 1, 5, 70, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (6, 1, 6, 23, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (7, 1, 7, 26, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (8, 1, 8, 25, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (9, 1, 9, 70, '2020-03-27 00:00:00');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (10, 2, 1, 12, '2019-10-13 18:15:20');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (11, 2, 2, 19, '2019-12-16 19:51:20');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (12, 2, 3, 55, '2019-05-10 05:16:54');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (13, 2, 4, 20, '2019-06-22 01:31:10');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (14, 2, 5, 52, '2020-03-22 22:21:00');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (15, 2, 6, 11, '2019-10-12 10:53:12');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (16, 2, 7, 51, '2020-01-23 03:41:57');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (17, 2, 8, 31, '2019-11-27 01:20:25');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (18, 2, 9, 65, '2020-02-15 10:35:17');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (19, 3, 1, 70, '2019-12-28 08:13:38');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (20, 3, 2, 68, '2019-08-26 09:23:51');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (21, 3, 3, 45, '2020-03-02 05:08:22');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (22, 3, 4, 48, '2019-10-01 22:55:52');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (23, 3, 5, 26, '2019-12-10 22:36:54');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (24, 3, 6, 13, '2019-11-17 01:33:26');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (25, 3, 7, 46, '2019-04-01 17:02:51');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (26, 3, 8, 43, '2019-05-19 03:26:13');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (27, 3, 9, 34, '2020-03-05 17:23:51');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (28, 4, 1, 35, '2020-03-06 04:34:06');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (29, 4, 2, 73, '2020-02-15 08:43:01');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (30, 4, 3, 44, '2020-01-31 17:03:46');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (31, 4, 4, 28, '2019-11-07 21:04:30');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (32, 4, 5, 35, '2019-05-03 04:08:13');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (33, 4, 6, 62, '2020-02-19 22:49:27');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (34, 4, 7, 66, '2019-09-27 16:56:05');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (35, 4, 8, 57, '2019-08-12 15:54:45');
insert into `kid_invest_db`.`business_transactions` (`id`, `business_id`, `ingredient_id`, `purchase_count`, `time`)
values (36, 4, 9, 46, '2019-11-13 01:39:30');

# INVENTORY SEEDER
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (1, 48, 1, 1);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (2, 81, 2, 1);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (3, 114, 3, 1);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (4, 70, 4, 1);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (5, 91, 5, 1);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (6, 103, 6, 1);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (7, 62, 7, 1);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (8, 89, 8, 1);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (9, 78, 9, 1);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (10, 58, 1, 2);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (11, 122, 2, 2);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (12, 61, 3, 2);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (13, 47, 4, 2);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (14, 46, 5, 2);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (15, 70, 6, 2);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (16, 70, 7, 2);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (17, 48, 8, 2);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (18, 124, 9, 2);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (19, 108, 1, 3);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (20, 90, 2, 3);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (21, 46, 3, 3);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (22, 93, 4, 3);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (23, 104, 5, 3);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (24, 68, 6, 3);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (25, 75, 7, 3);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (26, 96, 8, 3);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (27, 84, 9, 3);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (28, 105, 1, 4);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (29, 73, 2, 4);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (30, 106, 3, 4);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (31, 72, 4, 4);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (32, 67, 5, 4);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (33, 95, 6, 4);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (34, 123, 7, 4);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (35, 117, 8, 4);
insert into `kid_invest_db`.`inventory` (`id`, `total`, `ingredient_id`, `business_id`)
values (36, 60, 9, 4);


# SALES SEEDER
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (1, '2020-03-05', 572.72, 1);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (2, '2020-01-26', 410.2, 1);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (3, '2019-04-15', 778.61, 1);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (4, '2020-02-17', 753.5, 1);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (5, '2019-12-29', 525.01, 2);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (6, '2019-12-28', 495.74, 2);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (7, '2020-02-11', 462.33, 2);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (8, '2019-12-01', 902.39, 2);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (9, '2019-12-12', 724.52, 3);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (10, '2020-02-25', 614.26, 3);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (11, '2019-07-29', 486.77, 3);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (12, '2020-02-20', 908.45, 3);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (13, '2019-11-21', 400.81, 4);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (14, '2019-05-06', 784.78, 4);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (15, '2019-09-19', 847.39, 4);
insert into `kid_invest_db`.`sales` (`id`, `sale_date`, `profit`, `business_id`)
values (16, '2020-02-27', 956.4, 4);