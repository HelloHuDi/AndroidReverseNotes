package com.tencent.p177mm.plugin.appbrand.p911q;

import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.appbrand.q.c */
public abstract class C19678c<_Model extends C4925c & C19677b> extends C7563j<_Model> {
    public C19678c(C4927e c4927e, C4924a c4924a, String str, String[] strArr) {
        super(c4927e, c4924a, str, strArr);
    }

    /* renamed from: a */
    public final boolean mo16759a(_Model _model, boolean z) {
        super.mo16759a((C4925c) _model, z);
        return mo10102b(_model, new String[0]);
    }

    /* renamed from: a */
    public final boolean mo10100a(_Model _model, boolean z, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            strArr = ((C19677b) _model).getKeys();
        }
        return super.mo10100a((C4925c) _model, z, strArr);
    }

    /* renamed from: b */
    public final boolean mo16762b(_Model _model, boolean z, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            strArr = ((C19677b) _model).getKeys();
        }
        return super.mo16762b(_model, z, strArr);
    }

    /* renamed from: b */
    public final boolean mo10102b(_Model _model, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            strArr = ((C19677b) _model).getKeys();
        }
        return super.mo10102b((C4925c) _model, strArr);
    }
}
