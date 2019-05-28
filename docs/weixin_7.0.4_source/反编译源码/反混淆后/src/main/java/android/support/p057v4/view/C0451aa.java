package android.support.p057v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

/* renamed from: android.support.v4.view.aa */
public final class C0451aa {
    /* renamed from: NF */
    public final Object f550NF;

    private C0451aa(Object obj) {
        this.f550NF = obj;
    }

    public final int getSystemWindowInsetLeft() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f550NF).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public final int getSystemWindowInsetTop() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f550NF).getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getSystemWindowInsetRight() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f550NF).getSystemWindowInsetRight();
        }
        return 0;
    }

    public final int getSystemWindowInsetBottom() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f550NF).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public final boolean isConsumed() {
        if (VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f550NF).isConsumed();
        }
        return false;
    }

    /* renamed from: et */
    public final C0451aa mo1033et() {
        if (VERSION.SDK_INT >= 20) {
            return new C0451aa(((WindowInsets) this.f550NF).consumeSystemWindowInsets());
        }
        return null;
    }

    /* renamed from: f */
    public final C0451aa mo1034f(int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 20) {
            return new C0451aa(((WindowInsets) this.f550NF).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0451aa c0451aa = (C0451aa) obj;
        if (this.f550NF != null) {
            return this.f550NF.equals(c0451aa.f550NF);
        }
        if (c0451aa.f550NF != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f550NF == null ? 0 : this.f550NF.hashCode();
    }

    /* renamed from: G */
    static C0451aa m779G(Object obj) {
        return obj == null ? null : new C0451aa(obj);
    }

    /* renamed from: c */
    static Object m780c(C0451aa c0451aa) {
        return c0451aa == null ? null : c0451aa.f550NF;
    }
}
