package kosenko.controllers.util;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FuncClass {

    //Convert Optional<Object> to list of Objects
    public static <T> List<T> toList(Optional<T> option) {
        return option.
                map(Collections::singletonList).
                orElse(Collections.emptyList());
    }
}
