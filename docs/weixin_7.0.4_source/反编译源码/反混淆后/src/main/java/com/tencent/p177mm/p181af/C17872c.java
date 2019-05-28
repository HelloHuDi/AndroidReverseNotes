package com.tencent.p177mm.p181af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;

/* renamed from: com.tencent.mm.af.c */
public class C17872c extends C37435f {
    public int cuu;
    public String ffN;
    public String ffO;
    public String ffP;
    public String ffQ;
    public String ffR;
    public String ffS;
    public String ffT;
    public String ffU;
    public String ffV;
    public String ffW;
    public String ffX;
    public String ffY;

    /* renamed from: Xz */
    public final C37435f mo20330Xz() {
        AppMethodBeat.m2504i(16187);
        C17872c c17872c = new C17872c();
        AppMethodBeat.m2505o(16187);
        return c17872c;
    }

    /* renamed from: a */
    public final void mo20331a(StringBuilder stringBuilder, C8910b c8910b, String str, C9545d c9545d, int i, int i2) {
    }

    /* renamed from: a */
    public final void mo20332a(Map<String, String> map, C8910b c8910b) {
        AppMethodBeat.m2504i(16188);
        if (c8910b.type == 2001) {
            this.ffN = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.locallogoicon"));
            this.ffO = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.localbubbleicon"));
            this.ffP = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.effectresource"));
            C4990ab.m7417i("MicroMsg.AppContentC2cMsgPiece", "locallogoicon: %s, localbubbleicon: %s, effectResource: %s", this.ffN, this.ffO, this.ffP);
            this.ffQ = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.corpname"));
            this.ffR = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.senderc2cshowsourceurl"));
            this.ffS = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.senderc2cshowsourcemd5"));
            this.ffT = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourceurl"));
            this.ffU = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourcemd5"));
            this.ffV = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.recshowsourceurl"));
            this.ffW = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.recshowsourcemd5"));
            this.ffX = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.detailshowsourceurl"));
            this.ffY = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.detailshowsourcemd5"));
            this.cuu = C5046bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.subtype"), 0);
        }
        AppMethodBeat.m2505o(16188);
    }
}
