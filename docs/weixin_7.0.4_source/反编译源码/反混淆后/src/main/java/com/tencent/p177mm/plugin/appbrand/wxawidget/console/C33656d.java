package com.tencent.p177mm.plugin.appbrand.wxawidget.console;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C26330d;
import com.tencent.p177mm.ipcinvoker.C26330d.C26331b;
import com.tencent.p177mm.ipcinvoker.C26330d.C26333a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.p854d.C32714e;
import com.tencent.p177mm.plugin.appbrand.wxawidget.C38625a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.d */
public final class C33656d {
    private static final Map<String, List<C38625a>> eGg = new ConcurrentHashMap();
    private static List<C38625a> jpI = new LinkedList();
    private static final C32714e jpJ = new C336571();

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.d$1 */
    static class C336571 implements C32714e {
        C336571() {
        }

        /* renamed from: ao */
        public final /* synthetic */ void mo5960ao(Object obj) {
            AppMethodBeat.m2504i(11134);
            Bundle bundle = (Bundle) obj;
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("logList");
            if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                C4990ab.m7416i("MicroMsg.ConsoleLogger", "logList is null or nil.");
                AppMethodBeat.m2505o(11134);
                return;
            }
            C33656d.m54964d(bundle.getString("id"), parcelableArrayList);
            AppMethodBeat.m2505o(11134);
        }
    }

    static {
        AppMethodBeat.m2504i(11138);
        AppMethodBeat.m2505o(11138);
    }

    /* renamed from: a */
    public static boolean m54962a(C38625a c38625a) {
        AppMethodBeat.m2504i(11135);
        if (jpI.contains(c38625a)) {
            AppMethodBeat.m2505o(11135);
            return false;
        }
        if (eGg.isEmpty() && jpI.isEmpty()) {
            C36745c c36745c = C36745c.jpH;
            C32714e c32714e = jpJ;
            C26330d c26330d = c36745c.eGv;
            String str = c36745c.ctq;
            if (!(str == null || str.length() == 0 || c32714e == null)) {
                Bundle bundle = new Bundle();
                bundle.putString("Token", C26330d.m41900ap(c32714e));
                bundle.putString("Event", str);
                C9549f.m17012a(c26330d.eFV, bundle, C26333a.class, c32714e);
            }
        }
        boolean add = jpI.add(c38625a);
        AppMethodBeat.m2505o(11135);
        return add;
    }

    /* renamed from: b */
    public static boolean m54963b(C38625a c38625a) {
        AppMethodBeat.m2504i(11136);
        boolean remove = jpI.remove(c38625a);
        if (eGg.isEmpty() && jpI.isEmpty()) {
            C36745c c36745c = C36745c.jpH;
            C32714e c32714e = jpJ;
            C26330d c26330d = c36745c.eGv;
            String str = c36745c.ctq;
            if (!(str == null || str.length() == 0 || c32714e == null)) {
                Bundle bundle = new Bundle();
                bundle.putString("Token", C26330d.m41900ap(c32714e));
                bundle.putString("Event", str);
                C9549f.m17012a(c26330d.eFV, bundle, C26331b.class, null);
            }
        }
        AppMethodBeat.m2505o(11136);
        return remove;
    }

    /* renamed from: d */
    static /* synthetic */ void m54964d(String str, ArrayList arrayList) {
        AppMethodBeat.m2504i(11137);
        if (C5046bo.isNullOrNil(str) || arrayList == null || arrayList.isEmpty()) {
            AppMethodBeat.m2505o(11137);
            return;
        }
        for (C38625a aS : new LinkedList(jpI)) {
            aS.mo61472aS(arrayList);
        }
        List list = (List) eGg.get(str);
        if (list != null) {
            for (C38625a aS2 : new LinkedList(list)) {
                aS2.mo61472aS(arrayList);
            }
        }
        AppMethodBeat.m2505o(11137);
    }
}
