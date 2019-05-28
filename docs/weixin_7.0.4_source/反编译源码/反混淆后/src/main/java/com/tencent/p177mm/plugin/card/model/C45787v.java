package com.tencent.p177mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.card.p931d.C45779t;
import com.tencent.p177mm.protocal.protobuf.C23422od;
import com.tencent.p177mm.protocal.protobuf.C23423of;
import com.tencent.p177mm.protocal.protobuf.C35942oe;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.card.model.v */
public final class C45787v extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String kea;
    public ArrayList<C23422od> keb;

    public C45787v(String str, float f, float f2, String str2) {
        AppMethodBeat.m2504i(87879);
        this.kea = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C35942oe();
        c1196a.fsK = new C23423of();
        c1196a.uri = "/cgi-bin/micromsg-bin/cardshoplbs";
        this.ehh = c1196a.acD();
        C35942oe c35942oe = (C35942oe) this.ehh.fsG.fsP;
        c35942oe.kbU = str;
        c35942oe.cGm = f;
        c35942oe.cEB = f2;
        c35942oe.cMC = str2;
        C4990ab.m7411d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", str, Float.valueOf(f), Float.valueOf(f2), str2);
        AppMethodBeat.m2505o(87879);
    }

    public final int getType() {
        return 563;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87880);
        if (C5046bo.isNullOrNil(((C35942oe) this.ehh.fsG.fsP).kbU)) {
            C4990ab.m7412e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
            AppMethodBeat.m2505o(87880);
            return -1;
        }
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87880);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87881);
        C4990ab.m7417i("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            String str2 = ((C23423of) this.ehh.fsH.fsP).kdS;
            if (TextUtils.isEmpty(str2)) {
                C4990ab.m7412e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
            }
            this.keb = C45779t.m84650Hz(str2);
            if (this.keb != null) {
                C4990ab.m7411d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", Integer.valueOf(this.keb.size()));
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87881);
    }
}
