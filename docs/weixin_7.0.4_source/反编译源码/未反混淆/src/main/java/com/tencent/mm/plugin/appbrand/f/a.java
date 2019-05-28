package com.tencent.mm.plugin.appbrand.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

final class a implements com.tencent.mm.sdk.e.k.a {
    a() {
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(129955);
        if (f.auT() == null) {
            ab.w("MicroMsg.AppBrandSearchStorageChangeListener", "onNotifyChange by SysConfigStorage, but sLayoutStorage is null.");
            AppMethodBeat.o(129955);
            return;
        }
        LinkedList linkedList;
        switch (mVar.hsh) {
            case 2:
            case 3:
                linkedList = new LinkedList();
                if (!"batch".equals(str)) {
                    linkedList.addAll(f.auT().yx(mVar.obj.toString()));
                } else if (mVar.obj != null && (mVar.obj instanceof List)) {
                    for (String yx : (List) mVar.obj) {
                        linkedList.addAll(f.auT().yx(yx));
                    }
                }
                if (!linkedList.isEmpty()) {
                    f.auT().b("batch", 3, linkedList);
                    AppMethodBeat.o(129955);
                    return;
                }
                break;
            case 5:
                linkedList = new LinkedList();
                if (!"batch".equals(str)) {
                    linkedList.addAll(f.auT().yx(mVar.obj.toString()));
                } else if (mVar.obj != null && (mVar.obj instanceof List)) {
                    for (String yx2 : (List) mVar.obj) {
                        linkedList.addAll(f.auT().yx(yx2));
                    }
                }
                if (!linkedList.isEmpty()) {
                    f.auT().b("batch", 5, linkedList);
                    break;
                }
                break;
        }
        AppMethodBeat.o(129955);
    }
}
