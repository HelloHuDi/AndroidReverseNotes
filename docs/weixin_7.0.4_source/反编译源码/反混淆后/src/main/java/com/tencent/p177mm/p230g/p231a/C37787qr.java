package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.qr */
public final class C37787qr extends C4883b {
    public C37788a cMP;

    /* renamed from: com.tencent.mm.g.a.qr$a */
    public static final class C37788a {
        public String cMQ;
        public OnDismissListener cMR;
        public Bundle cMS;
        public Context context;
    }

    public C37787qr() {
        this((byte) 0);
    }

    private C37787qr(byte b) {
        AppMethodBeat.m2504i(5607);
        this.cMP = new C37788a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(5607);
    }
}
