package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.c;
import com.tencent.mm.chatroom.c.e;
import com.tencent.mm.chatroom.c.g;
import com.tencent.mm.chatroom.c.h;
import com.tencent.mm.chatroom.c.i;
import com.tencent.mm.chatroom.c.k;
import com.tencent.mm.chatroom.c.m;
import com.tencent.mm.chatroom.c.n;
import com.tencent.mm.chatroom.c.o;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bbr;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.bbu;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.roomsdk.a.c.b;
import com.tencent.mm.roomsdk.a.c.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import java.util.List;

public final class a implements com.tencent.mm.roomsdk.a.a.a {
    public String TAG = "MicroMsg.DefaultChatRoom";

    public final com.tencent.mm.roomsdk.a.c.a b(String str, List<String> list) {
        AppMethodBeat.i(103859);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(true);
        pa.tRR = new g(str, list);
        AppMethodBeat.o(103859);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, String str2) {
        AppMethodBeat.i(103860);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(true);
        pa.tRR = new e(str, list, str2);
        AppMethodBeat.o(103860);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, int i) {
        AppMethodBeat.i(103861);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(true);
        pa.tRR = new h(str, list, i);
        AppMethodBeat.o(103861);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a c(String str, List<String> list) {
        AppMethodBeat.i(103862);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(true);
        pa.tRR = new m(str, list);
        AppMethodBeat.o(103862);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, String str2, bi biVar) {
        AppMethodBeat.i(103863);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(true);
        pa.tRR = new m(str, list, str2, biVar);
        AppMethodBeat.o(103863);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a kd(String str) {
        AppMethodBeat.i(103864);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(true);
        pa.tRR = new i(str);
        AppMethodBeat.o(103864);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a D(String str, int i) {
        AppMethodBeat.i(103865);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(true);
        pa.tRR = new k(str, i);
        AppMethodBeat.o(103865);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a L(String str, String str2) {
        AppMethodBeat.i(103866);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(true);
        pa.tRR = new n(str, str2);
        AppMethodBeat.o(103866);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a ke(String str) {
        AppMethodBeat.i(103867);
        ((j) com.tencent.mm.kernel.g.K(j.class)).XL().c(new c(str));
        com.tencent.mm.roomsdk.a.c.c pb = com.tencent.mm.roomsdk.a.c.a.pb(true);
        pb.xvc = new com.tencent.mm.chatroom.e.c((String) com.tencent.mm.kernel.g.RP().Ry().get(2, null), str);
        AppMethodBeat.o(103867);
        return pb;
    }

    public final com.tencent.mm.roomsdk.a.c.a E(String str, int i) {
        AppMethodBeat.i(103868);
        com.tencent.mm.roomsdk.a.c.c pb = com.tencent.mm.roomsdk.a.c.a.pb(true);
        pb.xvc = new com.tencent.mm.chatroom.e.b(str, i);
        AppMethodBeat.o(103868);
        return pb;
    }

    public final com.tencent.mm.roomsdk.a.c.a M(String str, String str2) {
        AppMethodBeat.i(103869);
        com.tencent.mm.roomsdk.a.c.c pb = com.tencent.mm.roomsdk.a.c.a.pb(true);
        bbu bbu = new bbu();
        bbu.vEi = new bts().alV(bo.nullAsNil(str));
        bbu.wGe = new bts().alV(bo.nullAsNil(str2));
        pb.xvc = new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(27, bbu);
        AppMethodBeat.o(103869);
        return pb;
    }

    public final com.tencent.mm.roomsdk.a.c.a N(String str, String str2) {
        AppMethodBeat.i(103870);
        b pa = com.tencent.mm.roomsdk.a.c.a.pa(true);
        pa.tRR = new o(str, str2);
        AppMethodBeat.o(103870);
        return pa;
    }

    public final com.tencent.mm.roomsdk.a.c.a j(String str, String str2, String str3) {
        AppMethodBeat.i(103871);
        com.tencent.mm.roomsdk.a.c.c pb = com.tencent.mm.roomsdk.a.c.a.pb(true);
        bbr bbr = new bbr();
        bbr.vEf = str;
        bbr.jBB = str2;
        bbr.vXl = bo.nullAsNil(str3);
        pb.xvc = new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(48, bbr);
        AppMethodBeat.o(103871);
        return pb;
    }

    public final com.tencent.mm.roomsdk.a.c.a c(String str, String str2, boolean z) {
        int i = 1;
        AppMethodBeat.i(103872);
        com.tencent.mm.roomsdk.a.c.c pb = com.tencent.mm.roomsdk.a.c.a.pb(true);
        bbs bbs = new bbs();
        bbs.vEf = str;
        bbs.jBB = str2;
        bbs.wGd = 1;
        if (!z) {
            i = 2;
        }
        bbs.pXD = i;
        pb.xvc = new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(49, bbs);
        AppMethodBeat.o(103872);
        return pb;
    }

    public final void a(ad adVar, boolean z) {
        AppMethodBeat.i(103873);
        if (z) {
            t.r(adVar);
            AppMethodBeat.o(103873);
            return;
        }
        t.u(adVar);
        AppMethodBeat.o(103873);
    }

    public final d Ju() {
        AppMethodBeat.i(103858);
        d dVar = new d();
        AppMethodBeat.o(103858);
        return dVar;
    }
}
