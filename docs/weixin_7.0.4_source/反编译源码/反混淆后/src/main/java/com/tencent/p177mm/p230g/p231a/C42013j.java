package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.j */
public final class C42013j extends C4883b {
    public C42014a csb;
    public C37742b csc;

    /* renamed from: com.tencent.mm.g.a.j$b */
    public static final class C37742b {
        public Bundle csg;
    }

    /* renamed from: com.tencent.mm.g.a.j$a */
    public static final class C42014a {
        public int actionCode;
        public Context context;
        public String csd;
        public boolean cse;
        public boolean csf;
    }

    public C42013j() {
        this((byte) 0);
    }

    private C42013j(byte b) {
        AppMethodBeat.m2504i(77529);
        this.csb = new C42014a();
        this.csc = new C37742b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(77529);
    }
}
