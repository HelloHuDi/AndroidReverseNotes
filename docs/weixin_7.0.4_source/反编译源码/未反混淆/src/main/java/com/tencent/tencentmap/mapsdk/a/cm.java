package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cm {
    private bl a = null;

    cm(bl blVar) {
        this.a = blVar;
    }

    public final bl a() {
        return this.a;
    }

    public final Bitmap a(Context context) {
        AppMethodBeat.i(100947);
        if (this.a == null) {
            AppMethodBeat.o(100947);
            return null;
        }
        Bitmap a = this.a.a(context);
        AppMethodBeat.o(100947);
        return a;
    }
}
