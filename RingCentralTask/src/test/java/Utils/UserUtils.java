package Utils;

import APITest.Users;
import com.github.javafaker.Faker;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserUtils {


    public static Map<String,Object> getRandomCreatUSerRequestPayload(){


        Faker faker = new Faker() ;

        Map<String,Object> payLoadMap = new LinkedHashMap<>();
        payLoadMap.put("name" , faker.name().firstName() ) ;
       // payLoadMap.put("email" , faker.resolve("internet.safe_email")) ;
        payLoadMap.put("email" , faker.internet().safeEmailAddress()) ;

        return payLoadMap ;

    }

    public static Users getRandomUser_Payload(){

        Faker faker = new Faker() ;

       Users randomUser = new Users();
        randomUser.setName(faker.name().firstName());
        randomUser.setEmail(faker.internet().safeEmailAddress());

        return randomUser ;
    }

}
