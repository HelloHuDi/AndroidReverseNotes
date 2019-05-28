package com.tencent.p177mm.plugin.card.p355ui.view;

import android.view.View;
import com.tencent.p177mm.plugin.card.p355ui.C33791n;

/* renamed from: com.tencent.mm.plugin.card.ui.view.i */
public abstract class C45800i {
    C33791n kqK;

    public abstract void initView();

    /* renamed from: a */
    public final void mo73598a(C33791n c33791n) {
        this.kqK = c33791n;
        initView();
    }

    public void destroy() {
        this.kqK = null;
    }

    public void update() {
    }

    public void bes() {
    }

    /* Access modifiers changed, original: protected|final */
    public final View findViewById(int i) {
        return this.kqK.findViewById(i);
    }

    /* Access modifiers changed, original: protected|final */
    public final String getString(int i) {
        return this.kqK.getString(i);
    }
}
