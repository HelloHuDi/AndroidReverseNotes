package android.support.v4.f;

import android.os.Build.VERSION;
import java.util.Objects;

public final class i {
    public static boolean equals(Object obj, Object obj2) {
        if (VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
