package com.tencent.p177mm.pluginsdk.p592g.p593a.p596c;

import android.annotation.SuppressLint;
import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.tencent.mm.pluginsdk.g.a.c.t */
public final class C44050t extends C7563j<C44049s> {
    private static final String[] fnj = new String[]{C7563j.m13217a(C44049s.ccO, "ResDownloaderRecordTable")};
    private static final String vfD = (C5128ac.eSj + C1178g.m2591x(String.format("mm%d", new Object[]{Integer.valueOf(C8415j.INVALID_ID)}).getBytes()) + "/");
    @SuppressLint({"UseSparseArrays"})
    private static final HashMap<Integer, C1366d> vfE;
    public final C7480h fni;
    private final HashMap<String, Object> vfF = new HashMap();

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.t$1 */
    static class C357931 implements C1366d {
        C357931() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(79629);
            String[] diB = C44050t.fnj;
            AppMethodBeat.m2505o(79629);
            return diB;
        }
    }

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(79636);
        boolean j = mo69739j((C44049s) c4925c);
        AppMethodBeat.m2505o(79636);
        return j;
    }

    static {
        AppMethodBeat.m2504i(79637);
        HashMap hashMap = new HashMap();
        vfE = hashMap;
        hashMap.put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new C357931());
        Iterator it = C46489r.diz().iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(79637);
    }

    private C44050t(C7480h c7480h) {
        super(c7480h, C44049s.ccO, "ResDownloaderRecordTable", null);
        AppMethodBeat.m2504i(79630);
        this.fni = c7480h;
        Iterator it = C46489r.diz().iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(79630);
    }

    static C44050t diA() {
        AppMethodBeat.m2504i(79631);
        try {
            new File(vfD).mkdirs();
            C7480h c7480h = new C7480h();
            String str = vfD + "ResDown.db";
            String str2 = vfD + "EnResDown.db";
            C1427q.m3026LK();
            if (c7480h.mo16657a(str, str2, -2147483648L, vfE)) {
                C44050t c44050t = new C44050t(c7480h);
                AppMethodBeat.m2505o(79631);
                return c44050t;
            }
            C4990ab.m7414f("MicroMsg.ResDownloaderStorage", "res downloader db init failed");
            AppMethodBeat.m2505o(79631);
            return null;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ResDownloaderStorage", "new storage failed, exception = %s", e);
            AppMethodBeat.m2505o(79631);
            return null;
        }
    }

    /* renamed from: pI */
    public final boolean mo69740pI(String str) {
        AppMethodBeat.m2504i(79632);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ResDownloaderStorage", "delete with null or nil urlKey, return false");
            AppMethodBeat.m2505o(79632);
            return false;
        }
        C4925c c44049s = new C44049s();
        c44049s.field_urlKey_hashcode = str.hashCode();
        boolean a = super.mo16760a(c44049s, "urlKey_hashcode");
        AppMethodBeat.m2505o(79632);
        return a;
    }

    /* renamed from: i */
    public final boolean mo69738i(C44049s c44049s) {
        AppMethodBeat.m2504i(79633);
        if (C5046bo.isNullOrNil(c44049s.field_urlKey)) {
            AppMethodBeat.m2505o(79633);
            return false;
        }
        c44049s.field_urlKey_hashcode = c44049s.field_urlKey.hashCode();
        boolean c = super.mo10103c(c44049s, "urlKey_hashcode");
        AppMethodBeat.m2505o(79633);
        return c;
    }

    /* renamed from: j */
    public final boolean mo69739j(C44049s c44049s) {
        AppMethodBeat.m2504i(79634);
        if (C5046bo.isNullOrNil(c44049s.field_urlKey)) {
            AppMethodBeat.m2505o(79634);
            return false;
        }
        c44049s.field_urlKey_hashcode = c44049s.field_urlKey.hashCode();
        boolean b = super.mo10101b((C4925c) c44049s);
        AppMethodBeat.m2505o(79634);
        return b;
    }

    public final C44049s ajg(String str) {
        AppMethodBeat.m2504i(79635);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ResDownloaderStorage", "query with null or nil urlKey, return null");
            AppMethodBeat.m2505o(79635);
            return null;
        }
        C4925c c44049s = new C44049s();
        c44049s.field_urlKey_hashcode = str.hashCode();
        if (super.mo10102b(c44049s, "urlKey_hashcode")) {
            AppMethodBeat.m2505o(79635);
            return c44049s;
        }
        AppMethodBeat.m2505o(79635);
        return null;
    }
}
