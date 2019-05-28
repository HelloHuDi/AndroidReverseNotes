package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public final class aa {
    public final Object NF;

    private aa(Object obj) {
        this.NF = obj;
    }

    public final int getSystemWindowInsetLeft() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.NF).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public final int getSystemWindowInsetTop() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.NF).getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getSystemWindowInsetRight() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.NF).getSystemWindowInsetRight();
        }
        return 0;
    }

    public final int getSystemWindowInsetBottom() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.NF).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public final boolean isConsumed() {
        if (VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.NF).isConsumed();
        }
        return false;
    }

    public final aa et() {
        if (VERSION.SDK_INT >= 20) {
            return new aa(((WindowInsets) this.NF).consumeSystemWindowInsets());
        }
        return null;
    }

    public final aa f(int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 20) {
            return new aa(((WindowInsets) this.NF).replaceSystemWindowInsets(i, i2, i3, i4));
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
        aa aaVar = (aa) obj;
        if (this.NF != null) {
            return this.NF.equals(aaVar.NF);
        }
        if (aaVar.NF != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.NF == null ? 0 : this.NF.hashCode();
    }

    static aa G(Object obj) {
        return obj == null ? null : new aa(obj);
    }

    static Object c(aa aaVar) {
        return aaVar == null ? null : aaVar.NF;
    }
}
