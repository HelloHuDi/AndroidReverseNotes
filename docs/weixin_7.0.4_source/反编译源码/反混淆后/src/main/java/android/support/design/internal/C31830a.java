package android.support.design.internal;

import android.content.Context;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6239j;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.design.internal.a */
public final class C31830a extends C6236h {
    public C31830a(Context context) {
        super(context);
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }

    /* renamed from: a */
    public final MenuItem mo14111a(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 > 5) {
            throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
        }
        mo14146gx();
        MenuItem a = super.mo14111a(i, i2, i3, charSequence);
        if (a instanceof C6239j) {
            ((C6239j) a).mo14165V(true);
        }
        mo14147gy();
        return a;
    }
}
