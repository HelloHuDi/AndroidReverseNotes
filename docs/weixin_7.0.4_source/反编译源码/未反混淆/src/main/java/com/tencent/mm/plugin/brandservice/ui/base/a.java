package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.c.b;
import java.util.List;

public abstract class a extends com.tencent.mm.ui.base.sortview.a {
    protected b jLg;
    protected List<String> jMJ;
    protected int jMK;
    protected int position;

    public a(int i, Object obj) {
        super(i, obj);
    }

    public final void setReporter(b bVar) {
        this.jLg = bVar;
    }

    public final b aWm() {
        return this.jLg;
    }

    public final void sf(int i) {
        this.jMK = i;
    }

    public final int aWn() {
        return this.jMK;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final int getPosition() {
        return this.position;
    }
}
