package com.tencent.p177mm.platformtools;

import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.platformtools.t */
public final class C1952t {
    private static ConcurrentHashMap<Integer, C1953a> ghk = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.platformtools.t$a */
    public static final class C1953a extends C7480h {
        public final boolean frq;
        SparseBooleanArray ghl = new SparseBooleanArray();
        private final String path;

        public C1953a(String str, boolean z) {
            AppMethodBeat.m2504i(58720);
            C4990ab.m7411d("MicroMsg.GeneralDBHelper", "create db %s", str);
            this.frq = z;
            this.path = str;
            AppMethodBeat.m2505o(58720);
        }

        /* renamed from: mJ */
        public final void mo5709mJ(int i) {
            AppMethodBeat.m2504i(58721);
            C4990ab.m7411d("MicroMsg.GeneralDBHelper", "try close db %d", Integer.valueOf(i));
            this.ghl.delete(i);
            if (this.ghl.size() <= 0) {
                C4990ab.m7411d("MicroMsg.GeneralDBHelper", "close db %d succ", Integer.valueOf(i));
                super.closeDB();
                C1952t.ghk.remove(Integer.valueOf(this.path.hashCode()));
            }
            AppMethodBeat.m2505o(58721);
        }

        @Deprecated
        public final void closeDB() {
            AppMethodBeat.m2504i(58722);
            C4990ab.m7413e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", C5046bo.dpG());
            if (this.ghl.size() <= 1) {
                super.closeDB();
            }
            AppMethodBeat.m2505o(58722);
        }

        @Deprecated
        /* renamed from: jC */
        public final void mo5708jC(String str) {
            AppMethodBeat.m2504i(58723);
            C4990ab.m7412e("MicroMsg.GeneralDBHelper", "forbid to use this method");
            if (this.ghl.size() <= 1) {
                super.mo5708jC(str);
            }
            AppMethodBeat.m2505o(58723);
        }
    }

    static {
        AppMethodBeat.m2504i(58725);
        AppMethodBeat.m2505o(58725);
    }

    /* renamed from: a */
    public static final C1953a m4171a(int i, String str, HashMap<Integer, C1366d> hashMap, boolean z) {
        AppMethodBeat.m2504i(58724);
        boolean z2 = (C5046bo.isNullOrNil(str) || hashMap == null) ? false : true;
        Assert.assertTrue(z2);
        int hashCode = str.hashCode();
        C1953a c1953a = (C1953a) ghk.get(Integer.valueOf(hashCode));
        if (c1953a == null) {
            c1953a = new C1953a(str, z);
            C1819b c1819b;
            if (z) {
                C1720g.m3534RN();
                long QF = (long) C1668a.m3383QF();
                C1427q.m3026LK();
                if (!c1953a.mo16660b("", str, "", QF, hashMap, true)) {
                    c1819b = new C1819b((byte) 0);
                    AppMethodBeat.m2505o(58724);
                    throw c1819b;
                }
            } else if (!c1953a.mo16661b(str, hashMap, false)) {
                c1819b = new C1819b((byte) 0);
                AppMethodBeat.m2505o(58724);
                throw c1819b;
            }
            ghk.put(Integer.valueOf(hashCode), c1953a);
        } else {
            boolean z3;
            if (z == c1953a.frq) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assert.assertTrue(z3);
            long iV = c1953a.mo15639iV(-1);
            for (C1366d Af : hashMap.values()) {
                for (Object obj : Af.mo4750Af()) {
                    C4990ab.m7410d("MicroMsg.GeneralDBHelper", "init sql:".concat(String.valueOf(obj)));
                    try {
                        c1953a.mo10108hY(null, obj);
                    } catch (Exception e) {
                        Assert.assertTrue("CreateTable failed:[" + obj + "][" + e.getMessage() + "]", false);
                    }
                }
            }
            c1953a.mo15640mB(iV);
        }
        C4990ab.m7411d("MicroMsg.GeneralDBHelper", "addRef %d", Integer.valueOf(i));
        c1953a.ghl.put(i, true);
        AppMethodBeat.m2505o(58724);
        return c1953a;
    }
}
