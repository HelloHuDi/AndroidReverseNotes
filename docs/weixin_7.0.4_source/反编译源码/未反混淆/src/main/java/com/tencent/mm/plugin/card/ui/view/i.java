package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import com.tencent.mm.plugin.card.ui.n;

public abstract class i {
    n kqK;

    public abstract void initView();

    public final void a(n nVar) {
        this.kqK = nVar;
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
