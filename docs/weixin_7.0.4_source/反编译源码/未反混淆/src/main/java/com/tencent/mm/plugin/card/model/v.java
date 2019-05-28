package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.t;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.protocal.protobuf.of;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class v extends m implements k {
    private final b ehh;
    private f ehi;
    public String kea;
    public ArrayList<od> keb;

    public v(String str, float f, float f2, String str2) {
        AppMethodBeat.i(87879);
        this.kea = str;
        a aVar = new a();
        aVar.fsJ = new oe();
        aVar.fsK = new of();
        aVar.uri = "/cgi-bin/micromsg-bin/cardshoplbs";
        this.ehh = aVar.acD();
        oe oeVar = (oe) this.ehh.fsG.fsP;
        oeVar.kbU = str;
        oeVar.cGm = f;
        oeVar.cEB = f2;
        oeVar.cMC = str2;
        ab.d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", str, Float.valueOf(f), Float.valueOf(f2), str2);
        AppMethodBeat.o(87879);
    }

    public final int getType() {
        return 563;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87880);
        if (bo.isNullOrNil(((oe) this.ehh.fsG.fsP).kbU)) {
            ab.e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
            AppMethodBeat.o(87880);
            return -1;
        }
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87880);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87881);
        ab.i("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            String str2 = ((of) this.ehh.fsH.fsP).kdS;
            if (TextUtils.isEmpty(str2)) {
                ab.e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
            }
            this.keb = t.Hz(str2);
            if (this.keb != null) {
                ab.d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", Integer.valueOf(this.keb.size()));
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87881);
    }
}
