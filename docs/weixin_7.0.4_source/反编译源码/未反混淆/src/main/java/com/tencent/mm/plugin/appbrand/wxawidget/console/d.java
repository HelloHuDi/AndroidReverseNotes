package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d.b;
import com.tencent.mm.ipcinvoker.d.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.wxawidget.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    private static final Map<String, List<a>> eGg = new ConcurrentHashMap();
    private static List<a> jpI = new LinkedList();
    private static final e jpJ = new e() {
        public final /* synthetic */ void ao(Object obj) {
            AppMethodBeat.i(11134);
            Bundle bundle = (Bundle) obj;
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("logList");
            if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                ab.i("MicroMsg.ConsoleLogger", "logList is null or nil.");
                AppMethodBeat.o(11134);
                return;
            }
            d.d(bundle.getString("id"), parcelableArrayList);
            AppMethodBeat.o(11134);
        }
    };

    static {
        AppMethodBeat.i(11138);
        AppMethodBeat.o(11138);
    }

    public static boolean a(a aVar) {
        AppMethodBeat.i(11135);
        if (jpI.contains(aVar)) {
            AppMethodBeat.o(11135);
            return false;
        }
        if (eGg.isEmpty() && jpI.isEmpty()) {
            c cVar = c.jpH;
            e eVar = jpJ;
            com.tencent.mm.ipcinvoker.d dVar = cVar.eGv;
            String str = cVar.ctq;
            if (!(str == null || str.length() == 0 || eVar == null)) {
                Bundle bundle = new Bundle();
                bundle.putString("Token", com.tencent.mm.ipcinvoker.d.ap(eVar));
                bundle.putString("Event", str);
                f.a(dVar.eFV, bundle, com.tencent.mm.ipcinvoker.d.a.class, eVar);
            }
        }
        boolean add = jpI.add(aVar);
        AppMethodBeat.o(11135);
        return add;
    }

    public static boolean b(a aVar) {
        AppMethodBeat.i(11136);
        boolean remove = jpI.remove(aVar);
        if (eGg.isEmpty() && jpI.isEmpty()) {
            c cVar = c.jpH;
            e eVar = jpJ;
            com.tencent.mm.ipcinvoker.d dVar = cVar.eGv;
            String str = cVar.ctq;
            if (!(str == null || str.length() == 0 || eVar == null)) {
                Bundle bundle = new Bundle();
                bundle.putString("Token", com.tencent.mm.ipcinvoker.d.ap(eVar));
                bundle.putString("Event", str);
                f.a(dVar.eFV, bundle, b.class, null);
            }
        }
        AppMethodBeat.o(11136);
        return remove;
    }

    static /* synthetic */ void d(String str, ArrayList arrayList) {
        AppMethodBeat.i(11137);
        if (bo.isNullOrNil(str) || arrayList == null || arrayList.isEmpty()) {
            AppMethodBeat.o(11137);
            return;
        }
        for (a aS : new LinkedList(jpI)) {
            aS.aS(arrayList);
        }
        List list = (List) eGg.get(str);
        if (list != null) {
            for (a aS2 : new LinkedList(list)) {
                aS2.aS(arrayList);
            }
        }
        AppMethodBeat.o(11137);
    }
}
