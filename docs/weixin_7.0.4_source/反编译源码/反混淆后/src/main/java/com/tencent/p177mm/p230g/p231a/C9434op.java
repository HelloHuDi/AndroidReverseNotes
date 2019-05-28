package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.op */
public final class C9434op extends C4883b {
    public C9436a cKW;
    public C9435b cKX;

    /* renamed from: com.tencent.mm.g.a.op$b */
    public static final class C9435b {
        public boolean cKV;
        public Bundle extras;
    }

    /* renamed from: com.tencent.mm.g.a.op$a */
    public static final class C9436a {
        public int cKY;
        public Context context;
        public Bundle extras;
    }

    public C9434op() {
        this((byte) 0);
    }

    private C9434op(byte b) {
        AppMethodBeat.m2504i(77563);
        this.cKW = new C9436a();
        this.cKX = new C9435b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(77563);
    }
}
