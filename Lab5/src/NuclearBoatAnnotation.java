import java.lang.annotation.*;

/**
 * @author Kate Zabrodina
 * @version 1.1
 */

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.CONSTRUCTOR)
@Inherited
@Documented
public @interface NuclearBoatAnnotation
{
    String title();
    boolean started() default false;
    String text();
}