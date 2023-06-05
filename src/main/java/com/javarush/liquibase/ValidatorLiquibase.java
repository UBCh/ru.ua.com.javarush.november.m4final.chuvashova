package com.javarush.liquibase;


import com.javarush.dataSource.liquibase.ConnectionData;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.Scope;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class ValidatorLiquibase {

    public static final String CREATE_DB = "liquibase/dump-hibernate-final.sql";
    public static final String VALIDATE_DB = "liquibase/changelog.xml";

    public ValidatorLiquibase() {
    }


    @SneakyThrows
    public void changesDatabase(String path) {

	Map<String, Object> config = new HashMap<>();

	Connection connection = ConnectionData.getConnection();

	try (connection) {
	    Scope.child(config, () -> {

		Database database = DatabaseFactory
			.getInstance()
			.findCorrectDatabaseImplementation(new JdbcConnection(connection));

		Liquibase liquibase = new liquibase
			.Liquibase(path, new ClassLoaderResourceAccessor(), database);

		liquibase.update(new Contexts(), new LabelExpression());
	    });
	}

    }

}
