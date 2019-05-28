package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.aj */
public final class C45309aj extends C4883b {
    public C18214a cth;
    public C18215b cti;

    /* renamed from: com.tencent.mm.g.a.aj$a */
    public static final class C18214a {
        public int action = 0;
        public Context context;
        public String ctj;
        public long ctk = 0;
        public boolean ctl = false;
        public Runnable ctm;
        public int fromScene = 0;
        public int offset = 0;
        public String title;
    }

    /* renamed from: com.tencent.mm.g.a.aj$b */
    public static final class C18215b {
        public boolean ctn = false;
    }

    public C45309aj() {
        this((byte) 0);
    }

    private C45309aj(byte b) {
        AppMethodBeat.m2504i(114183);
        this.cth = new C18214a();
        this.cti = new C18215b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(114183);
    }
}
