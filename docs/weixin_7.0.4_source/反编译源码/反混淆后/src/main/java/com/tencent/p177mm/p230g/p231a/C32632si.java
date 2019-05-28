package com.tencent.p177mm.p230g.p231a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.si */
public final class C32632si extends C4883b {
    public C18391a cOC;
    public C18392b cOD;

    /* renamed from: com.tencent.mm.g.a.si$a */
    public static final class C18391a {
        public Intent cOE;
        public Activity czX;
        public int requestCode;
    }

    /* renamed from: com.tencent.mm.g.a.si$b */
    public static final class C18392b {
        public boolean cxT;
    }

    public C32632si() {
        this((byte) 0);
    }

    private C32632si(byte b) {
        AppMethodBeat.m2504i(61711);
        this.cOC = new C18391a();
        this.cOD = new C18392b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(61711);
    }
}
