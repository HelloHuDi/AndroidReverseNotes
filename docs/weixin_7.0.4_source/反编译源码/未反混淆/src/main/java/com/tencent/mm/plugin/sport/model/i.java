package com.tencent.mm.plugin.sport.model;

import android.database.MatrixCursor;
import android.os.Bundle;

public final class i extends MatrixCursor {
    private Bundle mqu;

    public i(String[] strArr, Bundle bundle) {
        super(strArr);
        this.mqu = bundle;
    }

    public final Bundle getExtras() {
        return this.mqu;
    }
}
