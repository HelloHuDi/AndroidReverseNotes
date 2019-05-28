package com.tencent.p177mm.plugin.scanner.p740a;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.scanner.p740a.C43482a.C34833a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.scanner.a.l */
public final class C28889l {
    /* renamed from: cU */
    public static LinkedList<String> m45905cU(List<C43482a> list) {
        AppMethodBeat.m2504i(80857);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            LinkedList linkedList2 = ((C43482a) list.get(i)).fPL;
            for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                C34833a c34833a = (C34833a) linkedList2.get(i2);
                if (C28889l.m45903a(c34833a)) {
                    linkedList.add(c34833a.key);
                }
            }
        }
        AppMethodBeat.m2505o(80857);
        return linkedList;
    }

    /* renamed from: cV */
    public static Map<String, C34833a> m45906cV(List<String> list) {
        AppMethodBeat.m2504i(80858);
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                String str = (String) list.get(i2);
                C4990ab.m7410d("MicroMsg.ProductUpdateLogic", "toUpdateXmlList info: i=" + i2 + ";" + C5046bo.nullAsNil(str));
                C34833a m = C43482a.m77680m(C5049br.m7595z(str, NativeProtocol.WEB_DIALOG_ACTION), ".action");
                if (!(m == null || m.showType == 2)) {
                    hashMap.put(m.key, m);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(80858);
                return hashMap;
            }
        }
    }

    /* renamed from: b */
    public static boolean m45904b(List<C43482a> list, Map<String, C34833a> map) {
        AppMethodBeat.m2504i(80859);
        if (map == null || map.size() <= 0 || list == null) {
            AppMethodBeat.m2505o(80859);
            return false;
        }
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                LinkedList linkedList = ((C43482a) list.get(i)).fPL;
                int i2 = 0;
                boolean z2 = false;
                boolean z3 = z;
                while (i2 < linkedList.size()) {
                    C34833a c34833a = (C34833a) linkedList.get(i2);
                    if (C28889l.m45903a(c34833a)) {
                        C34833a c34833a2 = (C34833a) map.get(c34833a.key);
                        if (c34833a2 != null) {
                            C4990ab.m7416i("MicroMsg.ProductUpdateLogic", "Updating action , info: key=" + c34833a.key);
                            linkedList.remove(i2);
                            linkedList.add(i2, c34833a2);
                            z2 = true;
                            z3 = true;
                        }
                        z = z2;
                    } else {
                        z = true;
                    }
                    i2++;
                    z2 = z;
                }
                ((C43482a) list.get(i)).pZj = z2;
                z = z3;
            }
        }
        AppMethodBeat.m2505o(80859);
        return z;
    }

    /* renamed from: a */
    public static boolean m45903a(C34833a c34833a) {
        AppMethodBeat.m2504i(80860);
        if (C5046bo.isNullOrNil(c34833a.key)) {
            AppMethodBeat.m2505o(80860);
            return false;
        }
        AppMethodBeat.m2505o(80860);
        return true;
    }
}
