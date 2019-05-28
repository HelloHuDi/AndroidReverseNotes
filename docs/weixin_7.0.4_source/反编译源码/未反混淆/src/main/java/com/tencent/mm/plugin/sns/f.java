package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.id;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends c<id> {
    private n qBY;
    private String qCb;
    private TimeLineObject qCc;

    public f() {
        AppMethodBeat.i(35610);
        this.xxI = id.class.getName().hashCode();
        AppMethodBeat.o(35610);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(35611);
        id idVar = (id) bVar;
        if (idVar instanceof id) {
            this.qCb = idVar.cDc.cwT;
            this.qBY = af.cnF().YT(this.qCb);
            this.qCc = this.qBY.cqu();
            if (this.qCc != null) {
                idVar.cDd.cDe = this.qCc;
                AppMethodBeat.o(35611);
                return true;
            }
        }
        ab.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        AppMethodBeat.o(35611);
        return false;
    }
}
