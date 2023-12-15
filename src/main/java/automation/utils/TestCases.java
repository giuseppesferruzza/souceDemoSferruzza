package automation.utils;

public enum TestCases {
    T1("Testare la Login"),
    T2("Ordinamento Home Page");

    private String testName;

    TestCases(String value){
        this.testName = value;
    }
}
