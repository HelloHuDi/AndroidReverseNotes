package android.support.p057v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;

/* renamed from: android.support.v4.view.q */
public final class C0473q {
    /* renamed from: MZ */
    Object f566MZ;

    private C0473q(Object obj) {
        this.f566MZ = obj;
    }

    /* renamed from: U */
    public static C0473q m835U(Context context) {
        if (VERSION.SDK_INT >= 24) {
            return new C0473q(PointerIcon.getSystemIcon(context, 1002));
        }
        return new C0473q(null);
    }
}
