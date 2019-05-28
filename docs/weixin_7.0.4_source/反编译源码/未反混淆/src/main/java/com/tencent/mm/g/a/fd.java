package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fd extends com.tencent.mm.sdk.b.b {
    public a cyw;
    public b cyx;

    public static final class b {
        public Cursor cyz;
    }

    public static final class a {
        public Context context;
        public String[] crW;
        public int cyy = 0;
        public String[] selectionArgs;
        public Uri uri;
    }

    public fd() {
        this((byte) 0);
    }

    private fd(byte b) {
        AppMethodBeat.i(15769);
        this.cyw = new a();
        this.cyx = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(15769);
    }
}
