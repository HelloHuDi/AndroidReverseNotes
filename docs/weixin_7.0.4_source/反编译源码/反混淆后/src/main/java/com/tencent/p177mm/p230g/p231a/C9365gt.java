package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.gt */
public final class C9365gt extends C4883b {
    public C9366a cBv;

    /* renamed from: com.tencent.mm.g.a.gt$a */
    public static final class C9366a {
        public int actionCode;
        public String appId;
        public Context context;
        public String extMsg;
        public String messageAction;
        public String messageExt;
        public int scene;
    }

    public C9365gt() {
        this((byte) 0);
    }

    private C9365gt(byte b) {
        AppMethodBeat.m2504i(70194);
        this.cBv = new C9366a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(70194);
    }
}
