package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.vf */
public final class C18424vf extends C4883b {
    public C18425a cSc;
    public C18426b cSd;

    /* renamed from: com.tencent.mm.g.a.vf$a */
    public static final class C18425a {
        public String callingPackage;
        public Context context;
        public int cyy = 0;
        public Uri uri;
    }

    /* renamed from: com.tencent.mm.g.a.vf$b */
    public static final class C18426b {
        public Cursor cyz;
    }

    public C18424vf() {
        this((byte) 0);
    }

    private C18424vf(byte b) {
        AppMethodBeat.m2504i(15814);
        this.cSc = new C18425a();
        this.cSd = new C18426b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(15814);
    }
}
