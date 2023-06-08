CREATE TABLE cityH2DB (
                             id LONG,
                             name VARCHAR(20),
                             country_id INT,
                             district VARCHAR(50),
                             population LONG
);
CREATE TABLE countryH2DB (
                             id INT,
                             name VARCHAR(20),
                             region VARCHAR(54),
                             population LONG,
                             capital LONG,
                             language INT
);
CREATE TABLE country_languageH2DB (
                                      id INT,
                                      name VARCHAR(15)
);






