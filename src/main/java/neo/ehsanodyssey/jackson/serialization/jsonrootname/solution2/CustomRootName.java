package neo.ehsanodyssey.jackson.serialization.jsonrootname.solution2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface CustomRootName {
    String singular();
    String plural();
}
