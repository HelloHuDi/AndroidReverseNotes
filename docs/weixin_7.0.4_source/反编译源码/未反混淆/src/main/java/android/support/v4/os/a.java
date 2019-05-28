package android.support.v4.os;

import android.os.Build.VERSION;

public final class a {
    @Deprecated
    public static boolean isAtLeastOMR1() {
        return VERSION.SDK_INT >= 27;
    }
}
