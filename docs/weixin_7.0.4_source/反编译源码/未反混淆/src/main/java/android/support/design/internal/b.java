package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.view.SubMenu;

public final class b extends h {
    public b(Context context) {
        super(context);
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        j jVar = (j) a(i, i2, i3, charSequence);
        d dVar = new d(this.mContext, this, jVar);
        jVar.b(dVar);
        return dVar;
    }
}
