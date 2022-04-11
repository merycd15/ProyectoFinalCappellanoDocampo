package Data;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "userForTest")
    public static Object[][] getUser() {
        return new Object[][]
                {
                        {"Maria Cappellano", "Argentina","Buenos Aires","4444555566667777","12","2025"},
                };
    }
}