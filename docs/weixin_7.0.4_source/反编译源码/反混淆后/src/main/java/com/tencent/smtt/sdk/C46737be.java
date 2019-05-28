package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p1451f.p1452a.p1453a.C32115a;
import com.tencent.p1451f.p1452a.p1453a.C37323b;

/* renamed from: com.tencent.smtt.sdk.be */
class C46737be {
    /* renamed from: e */
    private static C46737be f18009e = null;
    /* renamed from: a */
    C16149bh f18010a = null;
    /* renamed from: b */
    Context f18011b;
    /* renamed from: c */
    C37323b f18012c;
    /* renamed from: d */
    C32115a f18013d;

    private C46737be(Context context) {
        AppMethodBeat.m2504i(64624);
        this.f18011b = context.getApplicationContext();
        this.f18010a = new C16149bh(this.f18011b);
        AppMethodBeat.m2505o(64624);
    }

    /* renamed from: a */
    public static synchronized C46737be m88593a(Context context) {
        C46737be c46737be;
        synchronized (C46737be.class) {
            AppMethodBeat.m2504i(64623);
            if (f18009e == null) {
                f18009e = new C46737be(context);
            }
            c46737be = f18009e;
            AppMethodBeat.m2505o(64623);
        }
        return c46737be;
    }

    /* renamed from: a */
    public void mo75281a(int i, int i2, Intent intent) {
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo75282a(Activity activity, int i) {
        AppMethodBeat.m2504i(64626);
        this.f18010a.mo28965a(activity, i);
        AppMethodBeat.m2505o(64626);
    }

    /* renamed from: a */
    public boolean mo75283a() {
        AppMethodBeat.m2504i(64627);
        this.f18010a.mo28963a();
        boolean b = this.f18010a.mo28967b();
        AppMethodBeat.m2505o(64627);
        return b;
    }

    /* renamed from: a */
    public boolean mo75284a(String str, Bundle bundle, C37323b c37323b) {
        Object thisR;
        AppMethodBeat.m2504i(64625);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (c37323b != null) {
            this.f18010a.mo28963a();
            if (this.f18010a.mo28967b()) {
                this.f18012c = c37323b;
                this.f18013d = new C24269bf(this);
                bundle.putInt("callMode", 3);
            } else {
                AppMethodBeat.m2505o(64625);
                return false;
            }
        }
        bundle.putInt("callMode", 1);
        C16149bh c16149bh = this.f18010a;
        if (c37323b == null) {
            thisR = null;
        }
        c16149bh.mo28966a(bundle, thisR);
        AppMethodBeat.m2505o(64625);
        return true;
    }
}
