ALTER TABLE user_account
    ADD UNIQUE (tax_number);

ALTER TABLE user_account
    ADD UNIQUE (username);

ALTER TABLE user_account
    ADD UNIQUE (email);

