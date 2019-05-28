package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.ik */
public final class C18296ik extends C4883b {
    public C18297b cDA;
    public C9381a cDz;

    /* renamed from: com.tencent.mm.g.a.ik$a */
    public static final class C9381a {
        public int cDB = 0;
        public Context context;
        public int scene = 0;
    }

    /* renamed from: com.tencent.mm.g.a.ik$b */
    public static final class C18297b {
        public String targetActivity;
    }

    public C18296ik() {
        this((byte) 0);
    }

    private C18296ik(byte b) {
        AppMethodBeat.m2504i(114427);
        this.cDz = new C9381a();
        this.cDA = new C18297b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(114427);
    }
}
