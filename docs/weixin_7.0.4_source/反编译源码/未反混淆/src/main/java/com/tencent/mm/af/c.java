package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public class c extends f {
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

    public final f Xz() {
        AppMethodBeat.i(16187);
        c cVar = new c();
        AppMethodBeat.o(16187);
        return cVar;
    }

    public final void a(StringBuilder stringBuilder, b bVar, String str, d dVar, int i, int i2) {
    }

    public final void a(Map<String, String> map, b bVar) {
        AppMethodBeat.i(16188);
        if (bVar.type == 2001) {
            this.ffN = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.locallogoicon"));
            this.ffO = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.localbubbleicon"));
            this.ffP = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.effectresource"));
            ab.i("MicroMsg.AppContentC2cMsgPiece", "locallogoicon: %s, localbubbleicon: %s, effectResource: %s", this.ffN, this.ffO, this.ffP);
            this.ffQ = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.corpname"));
            this.ffR = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.senderc2cshowsourceurl"));
            this.ffS = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.senderc2cshowsourcemd5"));
            this.ffT = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourceurl"));
            this.ffU = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourcemd5"));
            this.ffV = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.recshowsourceurl"));
            this.ffW = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.recshowsourcemd5"));
            this.ffX = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.detailshowsourceurl"));
            this.ffY = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.detailshowsourcemd5"));
            this.cuu = bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.subtype"), 0);
        }
        AppMethodBeat.o(16188);
    }
}
