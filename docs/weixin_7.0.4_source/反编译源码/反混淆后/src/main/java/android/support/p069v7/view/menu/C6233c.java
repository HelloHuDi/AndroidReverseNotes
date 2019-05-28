package android.support.p069v7.view.menu;

import android.content.Context;
import android.support.p057v4.p060b.p061a.C0369b;
import android.support.p057v4.p060b.p061a.C6194c;
import android.support.p057v4.p065f.C6197a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

/* renamed from: android.support.v7.view.menu.c */
abstract class C6233c<T> extends C0616d<T> {
    Map<C0369b, MenuItem> aap;
    Map<C6194c, SubMenu> aaq;
    final Context mContext;

    C6233c(Context context, T t) {
        super(t);
        this.mContext = context;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final MenuItem mo14106e(MenuItem menuItem) {
        if (!(menuItem instanceof C0369b)) {
            return menuItem;
        }
        C0369b c0369b = (C0369b) menuItem;
        if (this.aap == null) {
            this.aap = new C6197a();
        }
        MenuItem menuItem2 = (MenuItem) this.aap.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = C0631q.m1360a(this.mContext, c0369b);
        this.aap.put(c0369b, menuItem2);
        return menuItem2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final SubMenu mo14105a(SubMenu subMenu) {
        if (!(subMenu instanceof C6194c)) {
            return subMenu;
        }
        C6194c c6194c = (C6194c) subMenu;
        if (this.aaq == null) {
            this.aaq = new C6197a();
        }
        SubMenu subMenu2 = (SubMenu) this.aaq.get(c6194c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        C7593v c7593v = new C7593v(this.mContext, c6194c);
        this.aaq.put(c6194c, c7593v);
        return c7593v;
    }
}
