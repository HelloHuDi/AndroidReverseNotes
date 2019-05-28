package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.support.p069v7.p075h.C0595c.C0597a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.s */
public abstract class C27340s<T> extends C0597a {
    protected final List<T> iPo;
    protected final List<T> iPp;

    public C27340s(List<T> list, List<T> list2) {
        this.iPo = list;
        this.iPp = list2;
    }

    /* renamed from: fV */
    public final int mo1477fV() {
        return this.iPo == null ? 0 : this.iPo.size();
    }

    /* renamed from: fW */
    public final int mo1478fW() {
        return this.iPp == null ? 0 : this.iPp.size();
    }
}
