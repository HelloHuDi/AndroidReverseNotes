package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelappbrand.x;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.az.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d implements g {
    public final void a(String str, int i, String str2, String str3) {
        AppMethodBeat.i(10757);
        ((com.tencent.mm.plugin.appbrand.a.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.a.d.class)).xF().a(str, 10102, i, str2, str3);
        AppMethodBeat.o(10757);
    }

    public final boolean a(String str, int i, String str2, final h hVar) {
        AppMethodBeat.i(10758);
        boolean b = az.b(str, 10102, i, str2, new a() {
            private long totalLen;

            public final /* bridge */ /* synthetic */ void bl(Object obj) {
                this.totalLen = ((WxaPkgLoadProgress) obj).gUQ;
            }

            public final /* synthetic */ void a(String str, b.a.a aVar, Object obj) {
                AppMethodBeat.i(10756);
                if (hVar != null) {
                    hVar.a(b.a.a.OK.equals(aVar), this.totalLen);
                }
                AppMethodBeat.o(10756);
            }
        });
        AppMethodBeat.o(10758);
        return b;
    }

    public final boolean S(String str, int i) {
        AppMethodBeat.i(10759);
        Pair v = as.v(str, 10102, i);
        if (v == null || v.first != as.a.gUI) {
            AppMethodBeat.o(10759);
            return false;
        }
        AppMethodBeat.o(10759);
        return true;
    }

    public final List<x> abA() {
        List list = null;
        AppMethodBeat.i(10760);
        ax xF = ((com.tencent.mm.plugin.appbrand.a.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.a.d.class)).xF();
        if (xF == null) {
            List list2 = Collections.EMPTY_LIST;
            AppMethodBeat.o(10760);
            return list2;
        }
        StringBuilder stringBuilder = new StringBuilder("debugType");
        stringBuilder.append(" = 10102");
        Cursor a = xF.gVj.a("AppBrandWxaPkgManifestRecord", null, stringBuilder.toString(), null, null, null, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    at atVar = new at();
                    atVar.d(a);
                    list.add(atVar);
                } while (a.moveToNext());
                a.close();
            } else {
                a.close();
            }
        }
        if (list == null || list.isEmpty()) {
            List<x> emptyList = Collections.emptyList();
            AppMethodBeat.o(10760);
            return emptyList;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (at atVar2 : list) {
            x xVar = new x();
            xVar.csB = atVar2.field_appId;
            xVar.version = atVar2.field_version;
            xVar.cvZ = atVar2.field_versionMd5;
            arrayList.add(xVar);
        }
        AppMethodBeat.o(10760);
        return arrayList;
    }
}
