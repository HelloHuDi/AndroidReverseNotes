package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends c<mo> {
    public h() {
        AppMethodBeat.i(35622);
        this.xxI = mo.class.getName().hashCode();
        AppMethodBeat.o(35622);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(35623);
        mo moVar = (mo) bVar;
        if (!(moVar instanceof mo)) {
            ab.f("MicroMsg.PostSnsTagMemberOptionListener", "mismatched event");
            AppMethodBeat.o(35623);
            return false;
        } else if (moVar.cIr.list == null) {
            ab.e("MicroMsg.PostSnsTagMemberOptionListener", "event.data.list is null!");
            AppMethodBeat.o(35623);
            return false;
        } else {
            m wVar = new w(moVar.cIr.czE, moVar.cIr.cIs, "", moVar.cIr.list.size(), moVar.cIr.list, moVar.cIr.scene);
            ab.i("MicroMsg.PostSnsTagMemberOptionListener", "opCode " + moVar.cIr.czE + " memberList " + moVar.cIr.list.size() + " scene " + moVar.cIr.scene);
            g.RO().eJo.a(wVar, 0);
            AppMethodBeat.o(35623);
            return true;
        }
    }
}
