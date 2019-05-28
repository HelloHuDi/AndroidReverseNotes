package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.h.c.a;
import java.util.List;

public abstract class s<T> extends a {
    protected final List<T> iPo;
    protected final List<T> iPp;

    public s(List<T> list, List<T> list2) {
        this.iPo = list;
        this.iPp = list2;
    }

    public final int fV() {
        return this.iPo == null ? 0 : this.iPo.size();
    }

    public final int fW() {
        return this.iPp == null ? 0 : this.iPp.size();
    }
}
