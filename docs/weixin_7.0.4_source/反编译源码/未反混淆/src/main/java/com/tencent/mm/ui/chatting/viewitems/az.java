package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.viewitems.al.a;
import com.tencent.mm.ui.chatting.viewitems.ar.f;
import com.tencent.mm.ui.chatting.viewitems.ar.g;
import com.tencent.mm.ui.chatting.viewitems.d.d;
import com.tencent.mm.ui.chatting.viewitems.d.e;
import com.tencent.mm.ui.chatting.viewitems.t.j;
import java.util.ArrayList;
import java.util.List;

public final class az {
    private static final List<c> ziB;

    public static c bM(bi biVar) {
        c cVar;
        AppMethodBeat.i(33448);
        for (c cVar2 : ziB) {
            if (cVar2.aH(biVar.getType(), biVar.field_isSend == 1)) {
                try {
                    cVar2 = (c) cVar2.getClass().newInstance();
                    AppMethodBeat.o(33448);
                    return cVar2;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Chatting.ItemFactory", e, "", new Object[0]);
                }
            }
        }
        cVar2 = new a();
        AppMethodBeat.o(33448);
        return cVar2;
    }

    public static int dHt() {
        AppMethodBeat.i(33449);
        int size = ziB.size() + 2;
        AppMethodBeat.o(33449);
        return size;
    }

    public static int bN(bi biVar) {
        AppMethodBeat.i(33450);
        if (biVar.getType() == 49) {
            int d = l.d(b.me(biVar.field_content));
            ab.d("MicroMsg.Chatting.ItemFactory", "maybe honeypay need change type: %s", Integer.valueOf(d));
            if (d != 49) {
                biVar.setType(d);
                aw.ZK();
                c.XO().a(biVar.field_msgId, biVar);
            }
        }
        for (int i = 0; i < ziB.size(); i++) {
            if (((c) ziB.get(i)).aH(biVar.getType(), biVar.field_isSend == 1)) {
                AppMethodBeat.o(33450);
                return i;
            }
        }
        AppMethodBeat.o(33450);
        return 0;
    }

    static {
        AppMethodBeat.i(33451);
        ArrayList arrayList = new ArrayList();
        ziB = arrayList;
        arrayList.add(new al.b());
        ziB.add(new a());
        ziB.add(new e());
        ziB.add(new d());
        ziB.add(new l.c());
        ziB.add(new l.b());
        ziB.add(new p.c());
        ziB.add(new p.b());
        ziB.add(new k.d());
        ziB.add(new k.c());
        ziB.add(new ai());
        ziB.add(new ad.b());
        ziB.add(new y.b());
        ziB.add(new y.a());
        ziB.add(new an.a());
        ziB.add(new an.b());
        ziB.add(new af.a());
        ziB.add(new u.c());
        ziB.add(new u.b());
        ziB.add(new z.a());
        ziB.add(new am.b());
        ziB.add(new am.a());
        ziB.add(new ae.b());
        ziB.add(new ae.a());
        ziB.add(new f());
        ziB.add(new ar.c());
        ziB.add(new g());
        ziB.add(new j());
        ziB.add(new ar.d());
        ziB.add(new ar.e());
        ziB.add(new aq());
        ziB.add(new ao());
        ziB.add(new ap());
        ziB.add(new ah.a());
        ziB.add(new ah.b());
        ziB.add(new as.c());
        ziB.add(new as.b());
        ziB.add(new w());
        ziB.add(new n.b());
        ziB.add(new n.c());
        ziB.add(new aa());
        ziB.add(new ab());
        ziB.add(new ac());
        ziB.add(new o.c());
        ziB.add(new o.b());
        ziB.add(new e.c());
        ziB.add(new e.b());
        ziB.add(new i.c());
        ziB.add(new i.b());
        ziB.add(new g.c());
        ziB.add(new g.b());
        ziB.add(new h.c());
        ziB.add(new h.b());
        ziB.add(new r.b());
        ziB.add(new r.a());
        ziB.add(new s.b());
        ziB.add(new s.a());
        ziB.add(new q.b());
        ziB.add(new q.a());
        ziB.add(new m.c());
        ziB.add(new m.b());
        ziB.add(new ad.a());
        ziB.add(new f.c());
        ziB.add(new f.b());
        ziB.add(new j.c());
        ziB.add(new al.b() {
            public final boolean aH(int i, boolean z) {
                AppMethodBeat.i(33446);
                ab.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", Integer.valueOf(i), Boolean.valueOf(z));
                AppMethodBeat.o(33446);
                return z;
            }
        });
        ziB.add(new a() {
            public final boolean aH(int i, boolean z) {
                AppMethodBeat.i(33447);
                ab.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", Integer.valueOf(i), Boolean.valueOf(z));
                if (z) {
                    AppMethodBeat.o(33447);
                    return false;
                }
                AppMethodBeat.o(33447);
                return true;
            }
        });
        AppMethodBeat.o(33451);
    }
}
