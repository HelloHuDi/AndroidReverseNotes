package android.support.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

final class an {
    private static final aq AS;

    static {
        if (VERSION.SDK_INT >= 18) {
            AS = new ap();
        } else {
            AS = new ao();
        }
    }

    static am c(ViewGroup viewGroup) {
        return AS.c(viewGroup);
    }

    static void c(ViewGroup viewGroup, boolean z) {
        AS.c(viewGroup, z);
    }
}
