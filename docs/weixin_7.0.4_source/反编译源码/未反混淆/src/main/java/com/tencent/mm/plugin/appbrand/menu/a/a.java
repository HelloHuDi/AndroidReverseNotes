package com.tencent.mm.plugin.appbrand.menu.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.ui.base.l;

public abstract class a<T extends u> {
    public final int inj;

    public abstract void a(Context context, T t, l lVar, String str);

    public abstract void a(Context context, T t, String str, n nVar);

    public a(int i) {
        this.inj = i;
    }
}
