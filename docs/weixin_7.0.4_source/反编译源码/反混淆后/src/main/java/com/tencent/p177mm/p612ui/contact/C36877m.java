package com.tencent.p177mm.p612ui.contact;

/* renamed from: com.tencent.mm.ui.contact.m */
public abstract class C36877m extends C36252n {
    public C36878a zmU;

    /* renamed from: com.tencent.mm.ui.contact.m$a */
    public interface C36878a {
        /* renamed from: w */
        void mo28008w(String str, int i, boolean z);
    }

    /* renamed from: a */
    public abstract void mo24874a(String str, int[] iArr, boolean z);

    public abstract void clearData();

    public C36877m(C36251l c36251l, boolean z, int i) {
        super(c36251l, z, i);
    }

    /* renamed from: a */
    public void mo49041a(C36878a c36878a) {
        this.zmU = c36878a;
    }
}
