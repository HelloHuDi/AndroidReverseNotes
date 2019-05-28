package com.tencent.p177mm.p612ui.chatting.gallery;

import android.view.View;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.gallery.a */
public abstract class C23777a {
    protected C40775c yTG;

    public C23777a(C40775c c40775c) {
        this.yTG = c40775c;
    }

    public void detach() {
        this.yTG = null;
    }

    /* renamed from: a */
    public boolean mo27898a(C36180k c36180k, C7620bi c7620bi, int i) {
        return false;
    }

    /* renamed from: OJ */
    public final C36180k mo39605OJ(int i) {
        if (this.yTG == null) {
            return null;
        }
        View Fp = this.yTG.mo70155Fp(i);
        return Fp == null ? null : (C36180k) Fp.getTag();
    }

    /* renamed from: OK */
    public final void mo39606OK(int i) {
        if (this.yTG != null) {
            View Fp = this.yTG.mo70155Fp(i);
            if (Fp != null && Fp.getTag() != null) {
                mo27898a((C36180k) Fp.getTag(), this.yTG.mo64312Ou(i), i);
            }
        }
    }
}
