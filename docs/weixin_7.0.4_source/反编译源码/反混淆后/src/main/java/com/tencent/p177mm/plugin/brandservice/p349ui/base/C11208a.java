package com.tencent.p177mm.plugin.brandservice.p349ui.base;

import com.tencent.p177mm.p612ui.base.sortview.C46635a;
import com.tencent.p177mm.plugin.brandservice.p349ui.C42811c.C38691b;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.base.a */
public abstract class C11208a extends C46635a {
    protected C38691b jLg;
    protected List<String> jMJ;
    protected int jMK;
    protected int position;

    public C11208a(int i, Object obj) {
        super(i, obj);
    }

    public final void setReporter(C38691b c38691b) {
        this.jLg = c38691b;
    }

    public final C38691b aWm() {
        return this.jLg;
    }

    /* renamed from: sf */
    public final void mo22910sf(int i) {
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
