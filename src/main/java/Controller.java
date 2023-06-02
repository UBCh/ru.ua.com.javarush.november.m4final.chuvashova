import liquibase.ValidatorLiquibase;

public class Controller {

    public static void main(String[] args){

        new ValidatorLiquibase().changesDatabase();


    }
}
