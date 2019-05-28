package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.fj */
public final class C9339fj extends C4883b {
    public C9340a czd;
    public C9341b cze;

    /* renamed from: com.tencent.mm.g.a.fj$a */
    public static final class C9340a {
        public Context context;
        public String[] crW;
        public int cyy = 0;
        public String[] selectionArgs;
        public Uri uri;
    }

    /* renamed from: com.tencent.mm.g.a.fj$b */
    public static final class C9341b {
        public Cursor cyz;
    }

    public C9339fj() {
        this((byte) 0);
    }

    private C9339fj(byte b) {
        AppMethodBeat.m2504i(15772);
        this.czd = new C9340a();
        this.cze = new C9341b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(15772);
    }
}
