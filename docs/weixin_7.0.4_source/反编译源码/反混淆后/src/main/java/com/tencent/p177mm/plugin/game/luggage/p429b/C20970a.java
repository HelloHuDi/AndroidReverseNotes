package com.tencent.p177mm.plugin.game.luggage.p429b;

import com.tencent.luggage.p146d.C37393a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.a */
public final class C20970a {
    private static LinkedList<Class<? extends C37393a>> kOz;

    public static synchronized LinkedList<Class<? extends C37393a>> biH() {
        LinkedList linkedList;
        synchronized (C20970a.class) {
            AppMethodBeat.m2504i(135864);
            kOz = new LinkedList();
            C20970a.m32222ao(C34286d.class);
            C20970a.m32222ao(C39206f.class);
            C20970a.m32222ao(C28210g.class);
            C20970a.m32222ao(C12131h.class);
            C20970a.m32222ao(C34288i.class);
            C20970a.m32222ao(C43178l.class);
            C20970a.m32222ao(C43181m.class);
            C20970a.m32222ao(C43182n.class);
            C20970a.m32222ao(C20974q.class);
            C20970a.m32222ao(C20971o.class);
            C20970a.m32222ao(C20972p.class);
            C20970a.m32222ao(C24774j.class);
            C20970a.m32222ao(C39205c.class);
            C20970a.m32222ao(C46002b.class);
            C20970a.m32222ao(C46003k.class);
            C20970a.m32222ao(C34287e.class);
            linkedList = kOz;
            AppMethodBeat.m2505o(135864);
        }
        return linkedList;
    }

    /* renamed from: ao */
    private static void m32222ao(Class<? extends C37393a> cls) {
        AppMethodBeat.m2504i(135865);
        kOz.add(cls);
        AppMethodBeat.m2505o(135865);
    }
}
