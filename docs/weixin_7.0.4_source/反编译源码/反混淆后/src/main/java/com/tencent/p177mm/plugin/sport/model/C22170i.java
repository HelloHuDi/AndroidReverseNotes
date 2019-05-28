package com.tencent.p177mm.plugin.sport.model;

import android.database.MatrixCursor;
import android.os.Bundle;

/* renamed from: com.tencent.mm.plugin.sport.model.i */
public final class C22170i extends MatrixCursor {
    private Bundle mqu;

    public C22170i(String[] strArr, Bundle bundle) {
        super(strArr);
        this.mqu = bundle;
    }

    public final Bundle getExtras() {
        return this.mqu;
    }
}
