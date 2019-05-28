package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;

public final class q {
    Object MZ;

    private q(Object obj) {
        this.MZ = obj;
    }

    public static q U(Context context) {
        if (VERSION.SDK_INT >= 24) {
            return new q(PointerIcon.getSystemIcon(context, 1002));
        }
        return new q(null);
    }
}
