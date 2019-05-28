package com.tencent.xweb.extension.video;

import android.content.ContentResolver;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private int ANr = 255;
    private ContentResolver bpL;

    public a(Context context) {
        AppMethodBeat.i(84557);
        this.bpL = context.getContentResolver();
        AppMethodBeat.o(84557);
    }
}
