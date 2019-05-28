package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fj extends com.tencent.mm.sdk.b.b {
    public a czd;
    public b cze;

    public static final class a {
        public Context context;
        public String[] crW;
        public int cyy = 0;
        public String[] selectionArgs;
        public Uri uri;
    }

    public static final class b {
        public Cursor cyz;
    }

    public fj() {
        this((byte) 0);
    }

    private fj(byte b) {
        AppMethodBeat.i(15772);
        this.czd = new a();
        this.cze = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(15772);
    }
}
