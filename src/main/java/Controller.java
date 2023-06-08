import com.javarush.dataSource.hibernate.session_provider.PropertiesSessionProvider;
import com.javarush.dataSource.hibernate.session_provider.PropertiesSessionProviderH2DB;
import com.javarush.entities.entitiesRedis.CityCountry;
import com.javarush.entities.entitiesTables.City;
import com.javarush.liquibase.ValidatorLiquibase;
import com.javarush.services.CheckBD;
import com.javarush.services.H2DBService;
import com.javarush.services.RedisService;
import com.javarush.services.WorldService;

import java.io.IOException;
import java.util.List;

public class Controller {


    private static WorldService worldService = new WorldService(new PropertiesSessionProvider());
    private static H2DBService h2DBService = new H2DBService(new PropertiesSessionProviderH2DB());

    private static RedisService redisService = new RedisService();

    public static void main(String[] args) throws IOException {
	createBDWorld();
	prepareForRedisForTest();
     	List<Integer> ids = List.of(3, 2545, 123, 4, 189, 89, 3458, 1189, 10, 102);


	long startH2DB = System.currentTimeMillis();
	h2DBService.testMysqlData(ids);
	long stopH2DB = System.currentTimeMillis();

	long startRedis = System.currentTimeMillis();
	redisService.testRedisData(ids);
	long stopRedis = System.currentTimeMillis();

	long startMysql = System.currentTimeMillis();
	worldService.testMysqlData(ids);
	long stopMysql = System.currentTimeMillis();

	System.out.printf("%s:\t%d ms\n", "Redis", (stopRedis - startRedis));
	System.out.printf("%s:\t%d ms\n", "MySQL", (stopMysql - startMysql));
	System.out.printf("%s:\t%d ms\n", "MySQL", (stopH2DB - startH2DB));
    }


    private static void prepareForRedisForTest() {
	worldService = new WorldService(new PropertiesSessionProvider());
	redisService = new RedisService();
	List<City> allCities = worldService.fetchData();
	List<CityCountry> preparedData = redisService.transformData(allCities);
	redisService.pushToRedis(preparedData);
	worldService.sessionFactory.close();
    }

    private static void createBDWorld() {
	CheckBD checkBD = new CheckBD();
	if (!checkBD.checkBDExistence()) {
	    new ValidatorLiquibase().changesDatabase(ValidatorLiquibase.VALIDATE_DB);
	}
    }

}
