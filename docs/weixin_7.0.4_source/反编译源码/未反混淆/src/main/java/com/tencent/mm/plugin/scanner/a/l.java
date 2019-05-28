package com.tencent.mm.plugin.scanner.a;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l {
    public static LinkedList<String> cU(List<a> list) {
        AppMethodBeat.i(80857);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            LinkedList linkedList2 = ((a) list.get(i)).fPL;
            for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                a aVar = (a) linkedList2.get(i2);
                if (a(aVar)) {
                    linkedList.add(aVar.key);
                }
            }
        }
        AppMethodBeat.o(80857);
        return linkedList;
    }

    public static Map<String, a> cV(List<String> list) {
        AppMethodBeat.i(80858);
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                String str = (String) list.get(i2);
                ab.d("MicroMsg.ProductUpdateLogic", "toUpdateXmlList info: i=" + i2 + ";" + bo.nullAsNil(str));
                a m = a.m(br.z(str, NativeProtocol.WEB_DIALOG_ACTION), ".action");
                if (!(m == null || m.showType == 2)) {
                    hashMap.put(m.key, m);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(80858);
                return hashMap;
            }
        }
    }

    public static boolean b(List<a> list, Map<String, a> map) {
        AppMethodBeat.i(80859);
        if (map == null || map.size() <= 0 || list == null) {
            AppMethodBeat.o(80859);
            return false;
        }
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                LinkedList linkedList = ((a) list.get(i)).fPL;
                int i2 = 0;
                boolean z2 = false;
                boolean z3 = z;
                while (i2 < linkedList.size()) {
                    a aVar = (a) linkedList.get(i2);
                    if (a(aVar)) {
                        a aVar2 = (a) map.get(aVar.key);
                        if (aVar2 != null) {
                            ab.i("MicroMsg.ProductUpdateLogic", "Updating action , info: key=" + aVar.key);
                            linkedList.remove(i2);
                            linkedList.add(i2, aVar2);
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
                ((a) list.get(i)).pZj = z2;
                z = z3;
            }
        }
        AppMethodBeat.o(80859);
        return z;
    }

    public static boolean a(a aVar) {
        AppMethodBeat.i(80860);
        if (bo.isNullOrNil(aVar.key)) {
            AppMethodBeat.o(80860);
            return false;
        }
        AppMethodBeat.o(80860);
        return true;
    }
}
