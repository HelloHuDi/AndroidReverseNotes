package android.support.design.internal;

import android.content.Context;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6239j;
import android.view.SubMenu;

/* renamed from: android.support.design.internal.b */
public final class C31831b extends C6236h {
    public C31831b(Context context) {
        super(context);
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C6239j c6239j = (C6239j) mo14111a(i, i2, i3, charSequence);
        C7586d c7586d = new C7586d(this.mContext, this, c6239j);
        c6239j.mo14170b(c7586d);
        return c7586d;
    }
}
