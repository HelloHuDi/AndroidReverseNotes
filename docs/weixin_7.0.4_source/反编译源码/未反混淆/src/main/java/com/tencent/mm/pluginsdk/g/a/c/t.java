package com.tencent.mm.pluginsdk.g.a.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.cd.h;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class t extends j<s> {
    private static final String[] fnj = new String[]{j.a(s.ccO, "ResDownloaderRecordTable")};
    private static final String vfD = (ac.eSj + g.x(String.format("mm%d", new Object[]{Integer.valueOf(android.support.v4.widget.j.INVALID_ID)}).getBytes()) + "/");
    @SuppressLint({"UseSparseArrays"})
    private static final HashMap<Integer, d> vfE;
    public final h fni;
    private final HashMap<String, Object> vfF = new HashMap();

    public final /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(79636);
        boolean j = j((s) cVar);
        AppMethodBeat.o(79636);
        return j;
    }

    static {
        AppMethodBeat.i(79637);
        HashMap hashMap = new HashMap();
        vfE = hashMap;
        hashMap.put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new d() {
            public final String[] Af() {
                AppMethodBeat.i(79629);
                String[] diB = t.fnj;
                AppMethodBeat.o(79629);
                return diB;
            }
        });
        Iterator it = r.diz().iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(79637);
    }

    private t(h hVar) {
        super(hVar, s.ccO, "ResDownloaderRecordTable", null);
        AppMethodBeat.i(79630);
        this.fni = hVar;
        Iterator it = r.diz().iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(79630);
    }

    static t diA() {
        AppMethodBeat.i(79631);
        try {
            new File(vfD).mkdirs();
            h hVar = new h();
            String str = vfD + "ResDown.db";
            String str2 = vfD + "EnResDown.db";
            q.LK();
            if (hVar.a(str, str2, -2147483648L, vfE)) {
                t tVar = new t(hVar);
                AppMethodBeat.o(79631);
                return tVar;
            }
            ab.f("MicroMsg.ResDownloaderStorage", "res downloader db init failed");
            AppMethodBeat.o(79631);
            return null;
        } catch (Exception e) {
            ab.e("MicroMsg.ResDownloaderStorage", "new storage failed, exception = %s", e);
            AppMethodBeat.o(79631);
            return null;
        }
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(79632);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ResDownloaderStorage", "delete with null or nil urlKey, return false");
            AppMethodBeat.o(79632);
            return false;
        }
        c sVar = new s();
        sVar.field_urlKey_hashcode = str.hashCode();
        boolean a = super.a(sVar, "urlKey_hashcode");
        AppMethodBeat.o(79632);
        return a;
    }

    public final boolean i(s sVar) {
        AppMethodBeat.i(79633);
        if (bo.isNullOrNil(sVar.field_urlKey)) {
            AppMethodBeat.o(79633);
            return false;
        }
        sVar.field_urlKey_hashcode = sVar.field_urlKey.hashCode();
        boolean c = super.c(sVar, "urlKey_hashcode");
        AppMethodBeat.o(79633);
        return c;
    }

    public final boolean j(s sVar) {
        AppMethodBeat.i(79634);
        if (bo.isNullOrNil(sVar.field_urlKey)) {
            AppMethodBeat.o(79634);
            return false;
        }
        sVar.field_urlKey_hashcode = sVar.field_urlKey.hashCode();
        boolean b = super.b((c) sVar);
        AppMethodBeat.o(79634);
        return b;
    }

    public final s ajg(String str) {
        AppMethodBeat.i(79635);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ResDownloaderStorage", "query with null or nil urlKey, return null");
            AppMethodBeat.o(79635);
            return null;
        }
        c sVar = new s();
        sVar.field_urlKey_hashcode = str.hashCode();
        if (super.b(sVar, "urlKey_hashcode")) {
            AppMethodBeat.o(79635);
            return sVar;
        }
        AppMethodBeat.o(79635);
        return null;
    }
}
