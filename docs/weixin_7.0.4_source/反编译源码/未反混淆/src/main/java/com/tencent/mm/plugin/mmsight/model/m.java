package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.plugin.mmsight.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.sdk.platformtools.ab;

public final class m implements w {
    public final void tZ(String str) {
        AppMethodBeat.i(76542);
        final s uf = o.all().uf(str);
        if (uf == null) {
            AppMethodBeat.o(76542);
            return;
        }
        o.all();
        final String uh = t.uh(str);
        baa baa = uf.fXn;
        VideoTransPara afG = d.afF().afG();
        if (baa != null) {
            ab.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", Integer.valueOf(baa.wDQ), str, uh);
            if (baa.wDQ > 1) {
                u.um(str);
                AppMethodBeat.o(76542);
                return;
            }
        }
        boolean a = l.a(uh, afG, baa, new d() {
            public final boolean bOc() {
                AppMethodBeat.i(76540);
                ab.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", uh);
                uf.frO = t.uj(uh);
                uf.bJt = 32;
                o.all().c(uf);
                AppMethodBeat.o(76540);
                return true;
            }
        });
        if (baa != null) {
            boolean z;
            ab.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", str, Boolean.valueOf(a));
            if (a) {
                z = false;
            } else {
                z = true;
            }
            baa.wDT = z;
            uf.fXn = baa;
            uf.bJt = 536870912;
            o.all().c(uf);
        }
        if (a) {
            if (baa != null) {
                baa.wDQ++;
                uf.fXn = baa;
            }
            uf.bJt = 536870912;
            o.all().c(uf);
            c.yK(uf.fXe);
            if (l.b(uh, afG, baa, new d() {
                public final boolean bOc() {
                    AppMethodBeat.i(76541);
                    c.yL(uf.fXe);
                    ab.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", uh);
                    uf.frO = t.uj(uh);
                    uf.bJt = 32;
                    o.all().c(uf);
                    AppMethodBeat.o(76541);
                    return true;
                }
            }) < 0) {
                ab.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
                h.pYm.a(440, 45, 1, false);
                u.um(str);
                AppMethodBeat.o(76542);
                return;
            } else if (baa != null) {
                baa.wDT = true;
                uf.fXn = baa;
                uf.bJt = 536870912;
                o.all().c(uf);
            }
        }
        AppMethodBeat.o(76542);
    }
}
