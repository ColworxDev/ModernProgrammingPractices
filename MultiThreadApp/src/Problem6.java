import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

public class Problem6 {

    public static void main(String[] args) {

        Class<BadCode> badCodeClass = BadCode.class;
        if (badCodeClass.isAnnotationPresent(BugReport.class)) {
            BugReport annotation = (BugReport)badCodeClass.getAnnotation(BugReport.class);
            System.out.printf("%nAssigned To : %s ", annotation.assignedTo());
            System.out.printf("%nSeverity : %d ", annotation.severity());
        }

    }


    @BugReport(assignedTo="Corazza", severity=1)
    static class BadCode {
        public int add(int x, int y) {
            return x - y;

        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
     static @interface BugReport {
        String assignedTo() default "[none]";
        int severity() default 0;
    }

}
