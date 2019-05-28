package com.tencent.mm.platformtools;

import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class t {
    private static ConcurrentHashMap<Integer, a> ghk = new ConcurrentHashMap();

    public static final class a extends h {
        public final boolean frq;
        SparseBooleanArray ghl = new SparseBooleanArray();
        private final String path;

        public a(String str, boolean z) {
            AppMethodBeat.i(58720);
            ab.d("MicroMsg.GeneralDBHelper", "create db %s", str);
            this.frq = z;
            this.path = str;
            AppMethodBeat.o(58720);
        }

        public final void mJ(int i) {
            AppMethodBeat.i(58721);
            ab.d("MicroMsg.GeneralDBHelper", "try close db %d", Integer.valueOf(i));
            this.ghl.delete(i);
            if (this.ghl.size() <= 0) {
                ab.d("MicroMsg.GeneralDBHelper", "close db %d succ", Integer.valueOf(i));
                super.closeDB();
                t.ghk.remove(Integer.valueOf(this.path.hashCode()));
            }
            AppMethodBeat.o(58721);
        }

        @Deprecated
        public final void closeDB() {
            AppMethodBeat.i(58722);
            ab.e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", bo.dpG());
            if (this.ghl.size() <= 1) {
                super.closeDB();
            }
            AppMethodBeat.o(58722);
        }

        @Deprecated
        public final void jC(String str) {
            AppMethodBeat.i(58723);
            ab.e("MicroMsg.GeneralDBHelper", "forbid to use this method");
            if (this.ghl.size() <= 1) {
                super.jC(str);
            }
            AppMethodBeat.o(58723);
        }
    }

    static {
        AppMethodBeat.i(58725);
        AppMethodBeat.o(58725);
    }

    public static final a a(int i, String str, HashMap<Integer, d> hashMap, boolean z) {
        AppMethodBeat.i(58724);
        boolean z2 = (bo.isNullOrNil(str) || hashMap == null) ? false : true;
        Assert.assertTrue(z2);
        int hashCode = str.hashCode();
        a aVar = (a) ghk.get(Integer.valueOf(hashCode));
        if (aVar == null) {
            aVar = new a(str, z);
            b bVar;
            if (z) {
                g.RN();
                long QF = (long) com.tencent.mm.kernel.a.QF();
                q.LK();
                if (!aVar.b("", str, "", QF, hashMap, true)) {
                    bVar = new b((byte) 0);
                    AppMethodBeat.o(58724);
                    throw bVar;
                }
            } else if (!aVar.b(str, hashMap, false)) {
                bVar = new b((byte) 0);
                AppMethodBeat.o(58724);
                throw bVar;
            }
            ghk.put(Integer.valueOf(hashCode), aVar);
        } else {
            boolean z3;
            if (z == aVar.frq) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assert.assertTrue(z3);
            long iV = aVar.iV(-1);
            for (d Af : hashMap.values()) {
                for (Object obj : Af.Af()) {
                    ab.d("MicroMsg.GeneralDBHelper", "init sql:".concat(String.valueOf(obj)));
                    try {
                        aVar.hY(null, obj);
                    } catch (Exception e) {
                        Assert.assertTrue("CreateTable failed:[" + obj + "][" + e.getMessage() + "]", false);
                    }
                }
            }
            aVar.mB(iV);
        }
        ab.d("MicroMsg.GeneralDBHelper", "addRef %d", Integer.valueOf(i));
        aVar.ghl.put(i, true);
        AppMethodBeat.o(58724);
        return aVar;
    }
}
