package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.b.a.b;
import android.support.v4.f.a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

abstract class c<T> extends d<T> {
    Map<b, MenuItem> aap;
    Map<android.support.v4.b.a.c, SubMenu> aaq;
    final Context mContext;

    c(Context context, T t) {
        super(t);
        this.mContext = context;
    }

    /* Access modifiers changed, original: final */
    public final MenuItem e(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.aap == null) {
            this.aap = new a();
        }
        MenuItem menuItem2 = (MenuItem) this.aap.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = q.a(this.mContext, bVar);
        this.aap.put(bVar, menuItem2);
        return menuItem2;
    }

    /* Access modifiers changed, original: final */
    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof android.support.v4.b.a.c)) {
            return subMenu;
        }
        android.support.v4.b.a.c cVar = (android.support.v4.b.a.c) subMenu;
        if (this.aaq == null) {
            this.aaq = new a();
        }
        SubMenu subMenu2 = (SubMenu) this.aaq.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        v vVar = new v(this.mContext, cVar);
        this.aaq.put(cVar, vVar);
        return vVar;
    }
}
