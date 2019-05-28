package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C10084c;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C19047e;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C26743d;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C33085b;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C38108a;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C42350f;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C42351g;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C42352h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.c.a */
public enum C19050a {
    ;
    
    public static final C19053a gWm = null;
    public static final C19053a gWn = null;
    public static final C19053a gWo = null;
    public static final C19053a gWp = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.c.a$2 */
    static class C100852 extends C19053a<Class<? extends C38108a>> {
        C100852() {
            AppMethodBeat.m2504i(129492);
            mo34276e(C26743d.class, 21);
            mo34276e(C10084c.class, 41);
            mo34276e(C19047e.class, 81);
            mo34276e(C42351g.class, 101);
            mo34276e(C42350f.class, 121);
            mo34276e(C42352h.class, 151);
            mo34276e(C33085b.class, 161);
            AppMethodBeat.m2505o(129492);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.c.a$3 */
    static class C100863 extends C19053a<Class<? extends C38108a>> {
        C100863() {
            AppMethodBeat.m2504i(129493);
            mo34276e(C26743d.class, 22);
            mo34276e(C10084c.class, 42);
            mo34276e(C19047e.class, 82);
            mo34276e(C42351g.class, 102);
            mo34276e(C42350f.class, 122);
            mo34276e(C42352h.class, 152);
            mo34276e(C33085b.class, ErrorCode.STARTDOWNLOAD_3);
            AppMethodBeat.m2505o(129493);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.c.a$1 */
    static class C190511 extends C19053a<Class<? extends C38108a>> {
        C190511() {
            AppMethodBeat.m2504i(129491);
            mo34276e(C26743d.class, 20);
            mo34276e(C10084c.class, 40);
            mo34276e(C19047e.class, 80);
            mo34276e(C42351g.class, 100);
            mo34276e(C42350f.class, 120);
            mo34276e(C42352h.class, 150);
            mo34276e(C33085b.class, 160);
            AppMethodBeat.m2505o(129491);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.c.a$4 */
    static class C190524 extends C19053a<Class<? extends C38108a>> {
        C190524() {
            AppMethodBeat.m2504i(129494);
            mo34276e(C26743d.class, 23);
            mo34276e(C10084c.class, 43);
            mo34276e(C19047e.class, 83);
            mo34276e(C42351g.class, 103);
            mo34276e(C42350f.class, 123);
            mo34276e(C42352h.class, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
            mo34276e(C33085b.class, ErrorCode.STARTDOWNLOAD_4);
            AppMethodBeat.m2505o(129494);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.c.a$a */
    public static class C19053a<_Key> extends SparseIntArray {
        /* renamed from: e */
        public final void mo34276e(_Key _key, int i) {
            AppMethodBeat.m2504i(129495);
            super.put(_key.hashCode(), i);
            AppMethodBeat.m2505o(129495);
        }

        /* renamed from: bn */
        private int m29624bn(_Key _key) {
            AppMethodBeat.m2504i(129496);
            if (_key == null) {
                AppMethodBeat.m2505o(129496);
                return -1;
            }
            int i = super.get(_key.hashCode(), -1);
            AppMethodBeat.m2505o(129496);
            return i;
        }

        public final int get(_Key _key) {
            AppMethodBeat.m2504i(129497);
            int bn = m29624bn(_key);
            AppMethodBeat.m2505o(129497);
            return bn;
        }
    }

    private C19050a(String str) {
    }

    static {
        gWm = new C190511();
        gWn = new C100852();
        gWo = new C100863();
        gWp = new C190524();
        AppMethodBeat.m2505o(129502);
    }

    /* renamed from: cO */
    public static void m29622cO(int i, int i2) {
        AppMethodBeat.m2504i(139124);
        C19050a.m29623z((long) i, (long) i2);
        AppMethodBeat.m2505o(139124);
    }

    /* renamed from: z */
    public static void m29623z(long j, long j2) {
        AppMethodBeat.m2504i(129501);
        if (j2 < 0) {
            C4990ab.m7413e("MicroMsg.AppBrand.PredownloadReporter", "idkeyStat with invalid ID(%d), key (%d)", Long.valueOf(j), Long.valueOf(j2));
            AppMethodBeat.m2505o(129501);
            return;
        }
        if (j > 0) {
            C7060h.pYm.mo15419k(j, j2, 1);
            C7060h.pYm.mo8381e(15272, Long.valueOf(j), Long.valueOf(j2));
        }
        if (843 != j) {
            C7060h.pYm.mo15419k(843, j2, 1);
            C7060h.pYm.mo8381e(15272, Integer.valueOf(843), Long.valueOf(j2));
        }
        AppMethodBeat.m2505o(129501);
    }
}
