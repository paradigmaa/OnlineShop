CREATE TABLE Item(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    item_name VARCHAR NOT NULL,
    quantity BIGINT NOT NULL,
    price DECIMAL NOT NULL,
    date_created TIMESTAMP,
    last_update TIMESTAMP
);

drop table Item;