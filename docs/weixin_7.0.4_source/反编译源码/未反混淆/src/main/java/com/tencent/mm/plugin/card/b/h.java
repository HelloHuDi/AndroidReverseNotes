package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.af.j.b;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class h {
    public int fhF;
    public String fhG;
    public String fhH;
    public String fhI;
    public String fhJ;
    public String fhK;
    public String fhL;
    public String fhM;
    public int ver;

    public static h b(b bVar) {
        AppMethodBeat.i(114431);
        Map map = bVar.fjf;
        h hVar = new h();
        hVar.fhG = bo.bc((String) map.get(".msg.appmsg.giftcard_info.order_id"), "");
        hVar.fhF = p.cB((String) map.get(".msg.appmsg.giftcard_info.biz_uin"));
        hVar.fhH = bo.bc((String) map.get(".msg.appmsg.giftcard_info.app_name"), "");
        hVar.fhI = bo.bc((String) map.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        hVar.fhJ = bo.bc((String) map.get(".msg.appmsg.giftcard_info.send_digest"), "");
        hVar.fhK = bo.bc((String) map.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        hVar.fhL = bo.bc((String) map.get(".msg.appmsg.giftcard_info.title_color"), "");
        hVar.fhM = bo.bc((String) map.get(".msg.appmsg.giftcard_info.des_color"), "");
        hVar.ver = p.cB((String) map.get(".msg.appmsg.giftcard_info.ver"));
        AppMethodBeat.o(114431);
        return hVar;
    }
}
