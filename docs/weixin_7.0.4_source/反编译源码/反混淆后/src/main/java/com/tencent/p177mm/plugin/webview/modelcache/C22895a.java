package com.tencent.p177mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p711c.C32699fk;
import com.tencent.p177mm.plugin.webview.modelcache.C46427e.C40269a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.a */
public final class C22895a {
    private static final SparseArray<C22895a> unE = new SparseArray();
    private static volatile C22897b unF = null;
    private static final byte[] unG = new byte[0];
    public final String appId;
    public final String path;
    public final C22897b unD = C22895a.cYi();

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.a$a */
    public static final class C22896a extends C32699fk {
        private static final C4924a fjX = C32699fk.m53366Hm();

        private C22896a() {
        }

        public /* synthetic */ C22896a(byte b) {
            this();
        }

        /* renamed from: Ag */
        public final C4924a mo4635Ag() {
            return fjX;
        }

        static {
            AppMethodBeat.m2504i(6816);
            AppMethodBeat.m2505o(6816);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.a$b */
    public static final class C22897b extends C7563j<C22896a> {
        public final boolean hrm;

        public C22897b(C4927e c4927e) {
            super(c4927e, C22896a.fjX, "WebViewCacheAppIdOccupation", null);
            AppMethodBeat.m2504i(6817);
            this.hrm = c4927e != null;
            AppMethodBeat.m2505o(6817);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: ay */
        public final void mo38484ay(String str, long j) {
            AppMethodBeat.m2504i(6818);
            if (this.hrm) {
                C22896a c22896a = new C22896a();
                c22896a.field_appId = str;
                if (mo10102b((C4925c) c22896a, new String[0])) {
                    c22896a.field_occupation += j;
                    mo10103c(c22896a, new String[0]);
                    AppMethodBeat.m2505o(6818);
                    return;
                }
                c22896a.field_occupation = j;
                mo10101b((C4925c) c22896a);
                AppMethodBeat.m2505o(6818);
                return;
            }
            AppMethodBeat.m2505o(6818);
        }
    }

    static {
        AppMethodBeat.m2504i(6824);
        AppMethodBeat.m2505o(6824);
    }

    public static C40269a cYh() {
        AppMethodBeat.m2504i(6819);
        int hashCode = "WEBVIEW_RESOURCE_CACHE_APPID_OCCUPATION_TABLE".hashCode();
        String[] strArr = new String[1];
        Class cls = C32699fk.class;
        strArr[0] = C7563j.m13217a(C32699fk.m53366Hm(), "WebViewCacheAppIdOccupation");
        C40269a c40269a = new C40269a(hashCode, strArr);
        AppMethodBeat.m2505o(6819);
        return c40269a;
    }

    public static C22895a aeH(String str) {
        AppMethodBeat.m2504i(6820);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(6820);
            return null;
        }
        int hashCode = str.hashCode();
        C22895a c22895a = (C22895a) unE.get(hashCode);
        if (c22895a == null) {
            c22895a = new C22895a(str);
            unE.put(hashCode, c22895a);
        } else {
            C5730e.m8643tf(c22895a.path);
        }
        AppMethodBeat.m2505o(6820);
        return c22895a;
    }

    static void clearCache() {
        AppMethodBeat.m2504i(6821);
        unE.clear();
        AppMethodBeat.m2505o(6821);
    }

    private static C22897b cYi() {
        AppMethodBeat.m2504i(6822);
        C22897b c22897b;
        if (C1720g.m3531RK()) {
            synchronized (unG) {
                try {
                    if (unF == null || !unF.hrm) {
                        C1720g.m3537RQ();
                        unF = new C22897b(C1720g.m3536RP().eJN);
                    }
                    c22897b = unF;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(6822);
                }
            }
            return c22897b;
        }
        c22897b = new C22897b(null);
        AppMethodBeat.m2505o(6822);
        return c22897b;
    }

    private C22895a(String str) {
        AppMethodBeat.m2504i(6823);
        this.appId = str;
        C5730e.m8643tf(C6457e.evd + "sfs");
        this.path = C6457e.evd + String.valueOf(str.hashCode());
        C5730e.m8643tf(this.path);
        AppMethodBeat.m2505o(6823);
    }
}
