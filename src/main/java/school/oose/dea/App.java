package school.oose.dea;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class App {

    private static final int HIGHEST_NUMBER_TO_TEST = 2000;

    public static void main(String[] args) {
        App app = new App();
        app.startTesting();
    }

    private void startTesting() {
        NumberUnderTest numberUnderTest = new NumberUnderTest();
        var testers = new ArrayList<PrimeTester>();
        testers.add(new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST));
        testers.add(new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST));
        testers.add(new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST));

        testers.forEach(tester -> new Thread(tester).start());
        IntStream.range(0, 5).forEach(tester -> createAndStartThread(numberUnderTest));

    }

    private void createAndStartThread(NumberUnderTest numberUnderTest)
    {
        new Thread(new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST)).start();
    }
}