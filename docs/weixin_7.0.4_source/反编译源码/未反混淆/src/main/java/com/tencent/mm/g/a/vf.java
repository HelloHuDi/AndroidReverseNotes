package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vf extends com.tencent.mm.sdk.b.b {
    public a cSc;
    public b cSd;

    public static final class a {
        public String callingPackage;
        public Context context;
        public int cyy = 0;
        public Uri uri;
    }

    public static final class b {
        public Cursor cyz;
    }

    public vf() {
        this((byte) 0);
    }

    private vf(byte b) {
        AppMethodBeat.i(15814);
        this.cSc = new a();
        this.cSd = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(15814);
    }
}
