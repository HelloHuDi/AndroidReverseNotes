package com.tencent.p177mm.plugin.downloader_app.detail.p378a;

import com.tencent.luggage.p146d.C37393a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C24926ah;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C40245w;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C43904o;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.downloader_app.detail.a.d */
public final class C38863d {
    private static LinkedList<Class<? extends C37393a>> kOz;

    public static synchronized LinkedList<Class<? extends C37393a>> biH() {
        LinkedList linkedList;
        synchronized (C38863d.class) {
            AppMethodBeat.m2504i(136072);
            kOz = new LinkedList();
            C38863d.m65927ao(C11521a.class);
            C38863d.m65927ao(C45839e.class);
            C38863d.m65927ao(C27719g.class);
            C38863d.m65927ao(C24926ah.class);
            C38863d.m65927ao(C40245w.class);
            C38863d.m65927ao(C43904o.class);
            C38863d.m65927ao(C33937c.class);
            C38863d.m65927ao(C11525b.class);
            C38863d.m65927ao(C38864f.class);
            linkedList = kOz;
            AppMethodBeat.m2505o(136072);
        }
        return linkedList;
    }

    /* renamed from: ao */
    private static void m65927ao(Class<? extends C37393a> cls) {
        AppMethodBeat.m2504i(136073);
        kOz.add(cls);
        AppMethodBeat.m2505o(136073);
    }
}
