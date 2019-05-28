package com.tencent.p177mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.card.p352b.C27567b;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.protocal.protobuf.agf;
import com.tencent.p177mm.protocal.protobuf.agg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.card.model.y */
public final class C38751y extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C38751y() {
        AppMethodBeat.m2504i(87889);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new agf();
        c1196a.fsK = new agg();
        c1196a.uri = "/cgi-bin/micromsg-bin/getcardcount";
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(87889);
    }

    public final int getType() {
        return 663;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87890);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87890);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87891);
        C4990ab.m7416i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            agg agg = (agg) this.ehh.fsH.fsP;
            C4990ab.m7416i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + agg.wnc + " has_share_card:" + agg.wnd);
            if (agg.wnc > 0) {
                C38736l.beB();
                if (TextUtils.isEmpty((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, null))) {
                    C42852am.baV();
                    C27567b.m43779sO(1);
                }
            }
            if (agg.wnd > 0) {
                C38736l.beD();
                Long l = (Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_REQUENCE_LONG_SYNC, Long.valueOf(0));
                if (l != null && l.longValue() == 0) {
                    C42852am.bbd().bbr();
                }
            }
        }
        C1720g.m3536RP().mo5239Ry().set(282882, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87891);
    }
}
