create table if not exists cooking.recipes
(
    id int auto_increment
        primary key,
    recipe varchar(40) not null,
    Ingredients blob not null,
    constraint recipes_recipe_uindex
        unique (recipe)
);