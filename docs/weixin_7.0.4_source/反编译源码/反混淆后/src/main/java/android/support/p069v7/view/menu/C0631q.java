package android.support.p069v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.p057v4.p060b.p061a.C0368a;
import android.support.p057v4.p060b.p061a.C0369b;
import android.view.Menu;
import android.view.MenuItem;

/* renamed from: android.support.v7.view.menu.q */
public final class C0631q {
    /* renamed from: a */
    public static Menu m1359a(Context context, C0368a c0368a) {
        return new C7457r(context, c0368a);
    }

    /* renamed from: a */
    public static MenuItem m1360a(Context context, C0369b c0369b) {
        if (VERSION.SDK_INT >= 16) {
            return new C7592l(context, c0369b);
        }
        return new C7455k(context, c0369b);
    }
}
