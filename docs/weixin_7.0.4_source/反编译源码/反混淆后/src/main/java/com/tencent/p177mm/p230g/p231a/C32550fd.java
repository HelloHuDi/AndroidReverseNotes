package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.fd */
public final class C32550fd extends C4883b {
    public C32551a cyw;
    public C32549b cyx;

    /* renamed from: com.tencent.mm.g.a.fd$b */
    public static final class C32549b {
        public Cursor cyz;
    }

    /* renamed from: com.tencent.mm.g.a.fd$a */
    public static final class C32551a {
        public Context context;
        public String[] crW;
        public int cyy = 0;
        public String[] selectionArgs;
        public Uri uri;
    }

    public C32550fd() {
        this((byte) 0);
    }

    private C32550fd(byte b) {
        AppMethodBeat.m2504i(15769);
        this.cyw = new C32551a();
        this.cyx = new C32549b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(15769);
    }
}
