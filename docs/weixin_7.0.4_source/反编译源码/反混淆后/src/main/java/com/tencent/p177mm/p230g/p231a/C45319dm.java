package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.g.a.dm */
public final class C45319dm extends C4883b {
    public C9319a cwM;
    public C32534b cwN;

    /* renamed from: com.tencent.mm.g.a.dm$a */
    public static final class C9319a {
        public Context context;
        public String cwz;
    }

    /* renamed from: com.tencent.mm.g.a.dm$b */
    public static final class C32534b {
        public boolean cwB;
        public JSONArray cwO;
    }

    public C45319dm() {
        this((byte) 0);
    }

    private C45319dm(byte b) {
        AppMethodBeat.m2504i(70149);
        this.cwM = new C9319a();
        this.cwN = new C32534b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(70149);
    }
}
