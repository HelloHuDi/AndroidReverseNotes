package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.util.Date;

public final class x extends c<uo> implements f {
    private uo tCr;
    private String tCs;

    public x() {
        AppMethodBeat.i(46900);
        this.tCs = null;
        this.xxI = uo.class.getName().hashCode();
        AppMethodBeat.o(46900);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(46903);
        this.tCr = (uo) bVar;
        this.tCs = this.tCr.cQJ.cQL;
        long longValue = ((Long) g.RP().Ry().get(a.USERINFO_WALLET_BULLETIN_GET_TIME_LONG, Long.valueOf(0))).longValue();
        long time = new Date().getTime();
        long longValue2 = ((Long) g.RP().Ry().get(a.USERINFO_WALLET_BULLETIN_UPDATE_INTERVAL_LONG, Long.valueOf(600000))).longValue();
        if (longValue2 <= 0) {
            longValue2 = 600000;
        }
        if (time - longValue > longValue2 || bo.isNullOrNil(this.tCs)) {
            ab.i("MicroMsg.WalletGetBulletinEventListener", "data is out of date,do NetSceneGetBannerInfo for update");
            m dVar = new d();
            g.RQ();
            p pVar = g.RO().eJo;
            pVar.a(385, (f) this);
            pVar.a(dVar, 0);
        } else if (bo.isNullOrNil(this.tCs)) {
            ab.e("MicroMsg.WalletGetBulletinEventListener", "mScene is null");
            this.tCr.callback.run();
            this.tCr = null;
        } else {
            ab.i("MicroMsg.WalletGetBulletinEventListener", "get bulletin data from db");
            cPR();
        }
        AppMethodBeat.o(46903);
        return true;
    }

    private void cPR() {
        AppMethodBeat.i(46901);
        com.tencent.mm.plugin.wallet_core.d.d cPM = r.cPM();
        u uVar = new u();
        uVar.field_bulletin_scene = this.tCs;
        if (cPM.b((com.tencent.mm.sdk.e.c) uVar, new String[0])) {
            this.tCr.cQK.cQM = uVar.field_bulletin_scene;
            this.tCr.cQK.content = uVar.field_bulletin_content;
            this.tCr.cQK.url = uVar.field_bulletin_url;
        } else {
            ab.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
        }
        this.tCr.callback.run();
        this.tCr = null;
        AppMethodBeat.o(46901);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46902);
        ab.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + i + ";errCode=" + i2);
        g.RQ();
        g.RO().eJo.b(385, (f) this);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_WALLET_BULLETIN_GET_TIME_LONG, Long.valueOf(new Date().getTime()));
        cPR();
        AppMethodBeat.o(46902);
    }
}
