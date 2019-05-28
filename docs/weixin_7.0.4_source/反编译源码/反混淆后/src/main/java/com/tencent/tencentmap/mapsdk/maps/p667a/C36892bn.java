package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31029ce.C24362a;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bn */
public final class C36892bn implements C36485bk {
    /* renamed from: a */
    private static C36892bn f15478a = new C36892bn();

    static {
        AppMethodBeat.m2504i(98568);
        AppMethodBeat.m2505o(98568);
    }

    private C36892bn() {
    }

    /* renamed from: a */
    public static C36892bn m61408a() {
        return f15478a;
    }

    /* renamed from: a */
    public final C36486bl mo57707a(String str, byte[] bArr) {
        AppMethodBeat.m2504i(98565);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("url is empty");
            AppMethodBeat.m2505o(98565);
            throw illegalArgumentException;
        }
        C16211bp c16211bp = new C16211bp(str, bArr);
        AppMethodBeat.m2505o(98565);
        return c16211bp;
    }

    /* renamed from: a */
    public final C36487bm mo57708a(C36486bl c36486bl) {
        AppMethodBeat.m2504i(98566);
        RuntimeException runtimeException;
        if (c36486bl == null) {
            runtimeException = new RuntimeException("execute...IHttpRequest is null");
            AppMethodBeat.m2505o(98566);
            throw runtimeException;
        } else if (c36486bl instanceof C16211bp) {
            C5859bq a = m61409a(true, (C16211bp) c36486bl, null);
            AppMethodBeat.m2505o(98566);
            return a;
        } else {
            runtimeException = new RuntimeException("execute...IHttpRequest should be create by API:createRequest");
            AppMethodBeat.m2505o(98566);
            throw runtimeException;
        }
    }

    /* renamed from: a */
    private C5859bq m61409a(boolean z, C16211bp c16211bp, C5858bj c5858bj) {
        AppMethodBeat.m2504i(98567);
        c16211bp.f3156h = c5858bj;
        c16211bp.f3162n = System.currentTimeMillis();
        C24362a.m37665a("app_http_use_proxy", 0, 1, 1);
        C17081bs c17081bs = new C17081bs(c16211bp);
        c16211bp.f3157i = c17081bs;
        C5859bq c5859bq;
        if (z) {
            int i;
            if (c16211bp.f3159k <= 0) {
                c16211bp.mo29253a(c17081bs.mo29262a());
                i = 0;
            } else {
                C41037ch.m71366a().mo65126b().execute(new C36488bo(this, c17081bs, c16211bp));
                i = !c16211bp.mo29256a() ? 1 : 0;
            }
            C5862cv c = c16211bp.mo29260c();
            if (i != 0) {
                c16211bp.f3161m = true;
            }
            c5859bq = new C5859bq(c == null ? new C5862cv(-14, "force return timeout:" + c16211bp.f3159k, 0) : c);
            AppMethodBeat.m2505o(98567);
            return c5859bq;
        }
        c5859bq = new C5859bq(c17081bs.mo29262a());
        if (!c16211bp.f3158j) {
            c16211bp.f3156h.mo12389a(c16211bp, c5859bq);
        }
        AppMethodBeat.m2505o(98567);
        return null;
    }
}
