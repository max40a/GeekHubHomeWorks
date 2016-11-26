package task2.exercise2;

public class StringTester {

    private static final double TEST_ITERATIONS = 1e5;

    public static void main(String[] args) {

        System.out.println("Test iterations = " + TEST_ITERATIONS);

        try {
            System.gc();
            testStringBuilder(new StringBuilder());
            System.gc();
            testStringBuffer(new StringBuffer());
            System.gc();
            testString();
        } catch (java.io.IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void testStringBuilder(StringBuilder stringBuilder) throws java.io.IOException {
        long before = System.currentTimeMillis();
        for (int i = 0; i++ < TEST_ITERATIONS; ) {
            stringBuilder.append(i);
        }
        long after = System.currentTimeMillis();
        System.out.println(stringBuilder.getClass().getSimpleName() + ": " + (after - before) + "ms.");
    }

    private static void testStringBuffer(StringBuffer stringBuffer) throws java.io.IOException {
        long before = System.currentTimeMillis();
        for (int i = 0; i++ < TEST_ITERATIONS; ) {
            stringBuffer.append(i);
        }
        long after = System.currentTimeMillis();
        System.out.println(stringBuffer.getClass().getSimpleName() + ": " + (after - before) + "ms.");
    }

    private static void testString() {
        long before = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i++ < TEST_ITERATIONS; ) {
            s += i;
        }
        long after = System.currentTimeMillis();
        System.out.println(s.getClass().getSimpleName() + ": " + (after - before) + "ms.");
    }
}