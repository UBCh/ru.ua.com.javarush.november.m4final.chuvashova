import com.javarush.dataSource.hibernate.session_provider.PropertiesSessionProvider;
import com.javarush.dataSource.hibernate.session_provider.SessionProvider;
import com.javarush.entities.entitiesRedis.CityCountry;
import com.javarush.entities.entitiesTables.City;
import com.javarush.liquibase.ValidatorLiquibase;
import com.javarush.services.RedisService;
import com.javarush.services.WorldService;
import org.hibernate.SessionFactory;

import java.util.List;

import static java.util.Objects.nonNull;

public class Controller {


     private static WorldService worldService=new WorldService(new PropertiesSessionProvider()) ;

    private static RedisService redisService=new RedisService();

    public static void main(String[] args){

//        new ValidatorLiquibase().changesDatabase(ValidatorLiquibase.VALIDATE_DB);
        prepareForRedisForTest();

        List<Integer> ids = List.of(3, 2545, 123, 4, 189, 89, 3458, 1189, 10, 102);

        long startRedis = System.currentTimeMillis();
       redisService.testRedisData(ids);
        long stopRedis = System.currentTimeMillis();

        long startMysql = System.currentTimeMillis();
       worldService.testMysqlData(ids);
        long stopMysql = System.currentTimeMillis();

        System.out.printf("%s:\t%d ms\n", "Redis", (stopRedis - startRedis));
        System.out.printf("%s:\t%d ms\n", "MySQL", (stopMysql - startMysql));
    }


    private static void prepareForRedisForTest(){
        worldService=new WorldService(new PropertiesSessionProvider()) ;
        redisService=new RedisService();
        List<City> allCities =worldService.fetchData();
        List<CityCountry> preparedData =redisService.transformData(allCities);
        redisService.pushToRedis(preparedData);
        worldService.sessionFactory.close();
    }



}
