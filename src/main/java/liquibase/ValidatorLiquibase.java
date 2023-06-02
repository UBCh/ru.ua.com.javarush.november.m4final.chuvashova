package liquibase;


import dataSource.ConnectionData;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.SneakyThrows;


import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class ValidatorLiquibase {

    public ValidatorLiquibase() {
    }

    @SneakyThrows
    public void changesDatabase () {

	Map<String, Object> config = new HashMap<>();

	Connection connection = ConnectionData.getConnection();

	try (connection){
	    Scope.child(config, () -> {

		Database database = DatabaseFactory
			.getInstance()
			.findCorrectDatabaseImplementation(new JdbcConnection(connection));

		Liquibase liquibase = new liquibase
			.Liquibase("liquibase/changelog.xml", new ClassLoaderResourceAccessor(), database);

		liquibase.update(new Contexts(), new LabelExpression());
	    });
	}


    }


}
