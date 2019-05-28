package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.b.c;
import com.tencent.mm.openim.b.d;
import com.tencent.mm.openim.b.e;
import com.tencent.mm.openim.b.f;
import com.tencent.mm.openim.b.k;
import com.tencent.mm.openim.b.m;
import com.tencent.mm.openim.d.g;
import com.tencent.mm.openim.d.j;
import com.tencent.mm.roomsdk.a.c.b;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import java.util.List;

public final class a implements com.tencent.mm.roomsdk.a.a.a {
    public final com.tencent.mm.roomsdk.a.c.a b(String str, List<String> list) {
        AppMethodBeat.i(78949);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(false);
        pa.tRR = new c(com.tencent.mm.openim.room.a.b.a.an(list));
        AppMethodBeat.o(78949);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, String str2) {
        AppMethodBeat.i(78950);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(false);
        pa.tRR = new com.tencent.mm.openim.b.a(str, com.tencent.mm.openim.room.a.b.a.an(list), str2);
        AppMethodBeat.o(78950);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, int i) {
        AppMethodBeat.i(78951);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(false);
        pa.tRR = new d(str, com.tencent.mm.openim.room.a.b.a.an(list));
        AppMethodBeat.o(78951);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a c(String str, List<String> list) {
        AppMethodBeat.i(78952);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(false);
        pa.tRR = new k(str, com.tencent.mm.openim.room.a.b.a.an(list));
        AppMethodBeat.o(78952);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, String str2, bi biVar) {
        AppMethodBeat.i(78953);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(false);
        pa.tRR = new k(str, com.tencent.mm.openim.room.a.b.a.an(list));
        AppMethodBeat.o(78953);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a kd(String str) {
        AppMethodBeat.i(78954);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(false);
        pa.tRR = new e(str);
        AppMethodBeat.o(78954);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a D(String str, int i) {
        AppMethodBeat.i(78955);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(false);
        pa.tRR = new f(str, i);
        AppMethodBeat.o(78955);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a L(String str, String str2) {
        AppMethodBeat.i(78956);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(false);
        pa.tRR = new m(str2, str);
        AppMethodBeat.o(78956);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a ke(String str) {
        AppMethodBeat.i(78957);
        com.tencent.mm.roomsdk.a.c.c pb = com.tencent.mm.roomsdk.a.c.a.pb(false);
        pb.xvc = new j(str);
        AppMethodBeat.o(78957);
        return pb;
    }

    public final com.tencent.mm.roomsdk.a.c.a E(String str, int i) {
        int i2;
        AppMethodBeat.i(78958);
        com.tencent.mm.roomsdk.a.c.c pb = com.tencent.mm.roomsdk.a.c.a.pb(false);
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        pb.xvc = new com.tencent.mm.openim.d.c(str, i2);
        AppMethodBeat.o(78958);
        return pb;
    }

    public final com.tencent.mm.roomsdk.a.c.a M(String str, String str2) {
        AppMethodBeat.i(78959);
        com.tencent.mm.roomsdk.a.c.c pb = com.tencent.mm.roomsdk.a.c.a.pb(false);
        pb.xvc = new g(str, str2);
        AppMethodBeat.o(78959);
        return pb;
    }

    public final com.tencent.mm.roomsdk.a.c.a N(String str, String str2) {
        AppMethodBeat.i(78960);
        com.tencent.mm.roomsdk.a.c.c pb = com.tencent.mm.roomsdk.a.c.a.pb(false);
        pb.xvc = new com.tencent.mm.openim.d.b(str, str2);
        AppMethodBeat.o(78960);
        return pb;
    }

    public final com.tencent.mm.roomsdk.a.c.a j(String str, String str2, String str3) {
        AppMethodBeat.i(78961);
        com.tencent.mm.roomsdk.a.c.c pb = com.tencent.mm.roomsdk.a.c.a.pb(false);
        pb.xvc = new com.tencent.mm.openim.d.d(str, str3);
        AppMethodBeat.o(78961);
        return pb;
    }

    public final com.tencent.mm.roomsdk.a.c.a c(String str, String str2, boolean z) {
        int i;
        AppMethodBeat.i(78962);
        com.tencent.mm.roomsdk.a.c.c pb = com.tencent.mm.roomsdk.a.c.a.pb(false);
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        pb.xvc = new com.tencent.mm.openim.d.e(str, i);
        AppMethodBeat.o(78962);
        return pb;
    }

    public final void a(ad adVar, boolean z) {
        AppMethodBeat.i(78963);
        if (z) {
            adVar.NB();
            if (t.e(adVar)) {
                adVar.hu(43);
                adVar.iC(com.tencent.mm.platformtools.g.vp(adVar.Oi()));
                adVar.iD(com.tencent.mm.platformtools.g.vo(adVar.Oi()));
                adVar.iF(com.tencent.mm.platformtools.g.vo(adVar.Oj()));
                adVar.iG(adVar.Oj());
            }
            ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().b(adVar.field_username, adVar);
            ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.a.class)).vf(adVar.field_username);
            AppMethodBeat.o(78963);
            return;
        }
        ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.a.class)).vg(adVar.field_username);
        AppMethodBeat.o(78963);
    }

    public final com.tencent.mm.roomsdk.a.c.d Ju() {
        AppMethodBeat.i(78948);
        com.tencent.mm.roomsdk.a.c.d dVar = new com.tencent.mm.roomsdk.a.c.d();
        AppMethodBeat.o(78948);
        return dVar;
    }
}
