package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.g.a.dn */
public final class C37704dn extends C4883b {
    public C18243a cwP;
    public C18244b cwQ;

    /* renamed from: com.tencent.mm.g.a.dn$a */
    public static final class C18243a {
        public Context context;
        public String cwz;
    }

    /* renamed from: com.tencent.mm.g.a.dn$b */
    public static final class C18244b {
        public boolean cwB;
        public JSONArray cwO;
    }

    public C37704dn() {
        this((byte) 0);
    }

    private C37704dn(byte b) {
        AppMethodBeat.m2504i(70150);
        this.cwP = new C18243a();
        this.cwQ = new C18244b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(70150);
    }
}
