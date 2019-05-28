package com.tencent.p177mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C45460w;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.plugin.mmsight.C21290c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.mmsight.model.m */
public final class C3486m implements C45460w {
    /* renamed from: tZ */
    public final void mo7943tZ(String str) {
        AppMethodBeat.m2504i(76542);
        final C26493s uf = C37961o.all().mo21063uf(str);
        if (uf == null) {
            AppMethodBeat.m2505o(76542);
            return;
        }
        C37961o.all();
        final String uh = C9720t.m17303uh(str);
        baa baa = uf.fXn;
        VideoTransPara afG = C42204d.afF().afG();
        if (baa != null) {
            C4990ab.m7417i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", Integer.valueOf(baa.wDQ), str, uh);
            if (baa.wDQ > 1) {
                C26494u.m42261um(str);
                AppMethodBeat.m2505o(76542);
                return;
            }
        }
        boolean a = C3483l.m5789a(uh, afG, baa, new C28508d() {
            public final boolean bOc() {
                AppMethodBeat.m2504i(76540);
                C4990ab.m7417i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", uh);
                uf.frO = C9720t.m17305uj(uh);
                uf.bJt = 32;
                C37961o.all().mo21060c(uf);
                AppMethodBeat.m2505o(76540);
                return true;
            }
        });
        if (baa != null) {
            boolean z;
            C4990ab.m7417i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", str, Boolean.valueOf(a));
            if (a) {
                z = false;
            } else {
                z = true;
            }
            baa.wDT = z;
            uf.fXn = baa;
            uf.bJt = 536870912;
            C37961o.all().mo21060c(uf);
        }
        if (a) {
            if (baa != null) {
                baa.wDQ++;
                uf.fXn = baa;
            }
            uf.bJt = 536870912;
            C37961o.all().mo21060c(uf);
            C21290c.m32668yK(uf.fXe);
            if (C3483l.m5790b(uh, afG, baa, new C28508d() {
                public final boolean bOc() {
                    AppMethodBeat.m2504i(76541);
                    C21290c.m32669yL(uf.fXe);
                    C4990ab.m7417i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", uh);
                    uf.frO = C9720t.m17305uj(uh);
                    uf.bJt = 32;
                    C37961o.all().mo21060c(uf);
                    AppMethodBeat.m2505o(76541);
                    return true;
                }
            }) < 0) {
                C4990ab.m7416i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
                C7060h.pYm.mo8378a(440, 45, 1, false);
                C26494u.m42261um(str);
                AppMethodBeat.m2505o(76542);
                return;
            } else if (baa != null) {
                baa.wDT = true;
                uf.fXn = baa;
                uf.bJt = 536870912;
                C37961o.all().mo21060c(uf);
            }
        }
        AppMethodBeat.m2505o(76542);
    }
}
