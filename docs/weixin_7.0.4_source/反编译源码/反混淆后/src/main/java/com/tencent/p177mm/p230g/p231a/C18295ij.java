package com.tencent.p177mm.p230g.p231a;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.p1338b.p1339a.C46515b;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.ij */
public final class C18295ij extends C4883b {
    public C18294a cDv;

    /* renamed from: com.tencent.mm.g.a.ij$a */
    public static final class C18294a {
        public C46515b cDw;
        public OnClickListener cDx;
        public OnClickListener cDy;
        public int type = 0;
    }

    public C18295ij() {
        this((byte) 0);
    }

    private C18295ij(byte b) {
        AppMethodBeat.m2504i(105574);
        this.cDv = new C18294a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(105574);
    }
}
