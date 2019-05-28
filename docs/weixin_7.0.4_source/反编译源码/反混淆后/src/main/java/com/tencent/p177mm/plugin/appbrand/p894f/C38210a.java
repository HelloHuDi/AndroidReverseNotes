package com.tencent.p177mm.plugin.appbrand.p894f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.f.a */
final class C38210a implements C4931a {
    C38210a() {
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(129955);
        if (C42340f.auT() == null) {
            C4990ab.m7420w("MicroMsg.AppBrandSearchStorageChangeListener", "onNotifyChange by SysConfigStorage, but sLayoutStorage is null.");
            AppMethodBeat.m2505o(129955);
            return;
        }
        LinkedList linkedList;
        switch (c4935m.hsh) {
            case 2:
            case 3:
                linkedList = new LinkedList();
                if (!"batch".equals(str)) {
                    linkedList.addAll(C42340f.auT().mo73338yx(c4935m.obj.toString()));
                } else if (c4935m.obj != null && (c4935m.obj instanceof List)) {
                    for (String yx : (List) c4935m.obj) {
                        linkedList.addAll(C42340f.auT().mo73338yx(yx));
                    }
                }
                if (!linkedList.isEmpty()) {
                    C42340f.auT().mo15641b("batch", 3, linkedList);
                    AppMethodBeat.m2505o(129955);
                    return;
                }
                break;
            case 5:
                linkedList = new LinkedList();
                if (!"batch".equals(str)) {
                    linkedList.addAll(C42340f.auT().mo73338yx(c4935m.obj.toString()));
                } else if (c4935m.obj != null && (c4935m.obj instanceof List)) {
                    for (String yx2 : (List) c4935m.obj) {
                        linkedList.addAll(C42340f.auT().mo73338yx(yx2));
                    }
                }
                if (!linkedList.isEmpty()) {
                    C42340f.auT().mo15641b("batch", 5, linkedList);
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(129955);
    }
}
