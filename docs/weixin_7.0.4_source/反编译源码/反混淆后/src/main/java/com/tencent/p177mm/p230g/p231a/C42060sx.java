package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.sx */
public final class C42060sx extends C4883b {
    public C18401a cPa;
    public C26243b cPb;

    /* renamed from: com.tencent.mm.g.a.sx$a */
    public static final class C18401a {
        public String cPc;
        public Context context;
        public int opType = 0;
    }

    /* renamed from: com.tencent.mm.g.a.sx$b */
    public static final class C26243b {
        public String cIH;
        public boolean cvi = false;
        public String thumbPath;
    }

    public C42060sx() {
        this((byte) 0);
    }

    private C42060sx(byte b) {
        AppMethodBeat.m2504i(70213);
        this.cPa = new C18401a();
        this.cPb = new C26243b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(70213);
    }
}
