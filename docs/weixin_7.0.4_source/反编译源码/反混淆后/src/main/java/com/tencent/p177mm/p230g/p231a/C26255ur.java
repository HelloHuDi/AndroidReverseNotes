package com.tencent.p177mm.p230g.p231a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.ur */
public final class C26255ur extends C4883b {
    public C9488a cRv;
    public C26256b cRw;

    /* renamed from: com.tencent.mm.g.a.ur$a */
    public static final class C9488a {
        public Activity activity;
        public int cRx;
    }

    /* renamed from: com.tencent.mm.g.a.ur$b */
    public static final class C26256b {
        public Object data = Integer.valueOf(0);

        public C26256b() {
            AppMethodBeat.m2504i(61712);
            AppMethodBeat.m2505o(61712);
        }
    }

    public C26255ur() {
        this((byte) 0);
    }

    private C26255ur(byte b) {
        AppMethodBeat.m2504i(61713);
        this.cRv = new C9488a();
        this.cRw = new C26256b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(61713);
    }
}
