package com.tencent.mm.plugin.appbrand.q;

import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public abstract class c<_Model extends com.tencent.mm.sdk.e.c & b> extends j<_Model> {
    public c(e eVar, a aVar, String str, String[] strArr) {
        super(eVar, aVar, str, strArr);
    }

    public final boolean a(_Model _model, boolean z) {
        super.a((com.tencent.mm.sdk.e.c) _model, z);
        return b(_model, new String[0]);
    }

    public final boolean a(_Model _model, boolean z, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            strArr = ((b) _model).getKeys();
        }
        return super.a((com.tencent.mm.sdk.e.c) _model, z, strArr);
    }

    public final boolean b(_Model _model, boolean z, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            strArr = ((b) _model).getKeys();
        }
        return super.b(_model, z, strArr);
    }

    public final boolean b(_Model _model, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            strArr = ((b) _model).getKeys();
        }
        return super.b((com.tencent.mm.sdk.e.c) _model, strArr);
    }
}
