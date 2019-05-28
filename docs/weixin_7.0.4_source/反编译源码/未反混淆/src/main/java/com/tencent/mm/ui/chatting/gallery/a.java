package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.bi;

public abstract class a {
    protected c yTG;

    public a(c cVar) {
        this.yTG = cVar;
    }

    public void detach() {
        this.yTG = null;
    }

    public boolean a(k kVar, bi biVar, int i) {
        return false;
    }

    public final k OJ(int i) {
        if (this.yTG == null) {
            return null;
        }
        View Fp = this.yTG.Fp(i);
        return Fp == null ? null : (k) Fp.getTag();
    }

    public final void OK(int i) {
        if (this.yTG != null) {
            View Fp = this.yTG.Fp(i);
            if (Fp != null && Fp.getTag() != null) {
                a((k) Fp.getTag(), this.yTG.Ou(i), i);
            }
        }
    }
}
