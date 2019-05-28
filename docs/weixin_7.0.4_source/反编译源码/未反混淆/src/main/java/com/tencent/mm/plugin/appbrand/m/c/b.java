package com.tencent.mm.plugin.appbrand.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.m.a.c;
import com.tencent.mm.plugin.appbrand.m.a.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.LinkedList;

public final class b extends d {
    private m iqe = null;

    public final int aIT() {
        return 7;
    }

    public final String b(i iVar, c cVar) {
        AppMethodBeat.i(102193);
        q qVar = cVar.gMN;
        if (this.iqe == null) {
            com.tencent.mm.plugin.appbrand.i runtime = qVar.getRuntime();
            if (qVar.getRuntime().asE() instanceof s) {
                LinkedList linkedList = ((s) runtime.asE()).gYd;
                for (int i = 0; i < linkedList.size(); i++) {
                    p pVar = (p) linkedList.get(i);
                    if (pVar instanceof m) {
                        this.iqe = (m) pVar;
                        break;
                    }
                }
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("getFlattenFileSystem not LuggageFileSystemRegistry");
                AppMethodBeat.o(102193);
                throw illegalStateException;
            }
        }
        m mVar = this.iqe;
        Object obj = null;
        if (mVar != null) {
            obj = mVar.yl(iVar.optString("path"));
        } else {
            ab.e("MicroMsg.GetFullPathOfFlatFSSync", "getFlattenFileSystem null");
        }
        ab.d("MicroMsg.GetFullPathOfFlatFSSync", "path:%s fullPath:%s", iVar.optString("path"), obj);
        HashMap hashMap = new HashMap();
        hashMap.put("fullPath", obj);
        String B = cVar.B(hashMap);
        AppMethodBeat.o(102193);
        return B;
    }
}
