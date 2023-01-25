package mockDataGenerator;

import com.github.javafaker.Faker;

public class MockDataGenerator{

    static Faker  faker=new Faker();

    public static String mockFullNameGenerator(){
        return faker.name().fullName();
    }

    public static String mockEmailGenerator(){
        return faker.internet().emailAddress();
    }

    public static String mockCurrentAddressGenerator(){
        return faker.address().fullAddress();
    }

    public static String mockPermanentAddressGenerator(){
        return faker.address().fullAddress();
    }

    public static String mockFirstNameGenerator(){
        return faker.name().firstName();
    }

    public static String mockLastNameGenerator(){
        return faker.name().lastName();
    }

    public static int mockAgeGenerator(){
        return faker.number().numberBetween(1,100);
    }

    public static int mockSalaryGenerator(){
        return faker.number().numberBetween(100000,100000000);
    }

    public static String mockDepartmentGenerator(){
        return faker.company().profession();
    }
}


