package com.tencent.p177mm.plugin.card.p352b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.card.b.h */
public final class C38729h {
    public int fhF;
    public String fhG;
    public String fhH;
    public String fhI;
    public String fhJ;
    public String fhK;
    public String fhL;
    public String fhM;
    public int ver;

    /* renamed from: b */
    public static C38729h m65694b(C8910b c8910b) {
        AppMethodBeat.m2504i(114431);
        Map map = c8910b.fjf;
        C38729h c38729h = new C38729h();
        c38729h.fhG = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.order_id"), "");
        c38729h.fhF = C1183p.m2611cB((String) map.get(".msg.appmsg.giftcard_info.biz_uin"));
        c38729h.fhH = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.app_name"), "");
        c38729h.fhI = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        c38729h.fhJ = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.send_digest"), "");
        c38729h.fhK = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        c38729h.fhL = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.title_color"), "");
        c38729h.fhM = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.des_color"), "");
        c38729h.ver = C1183p.m2611cB((String) map.get(".msg.appmsg.giftcard_info.ver"));
        AppMethodBeat.m2505o(114431);
        return c38729h;
    }
}
