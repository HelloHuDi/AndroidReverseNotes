package com.tencent.mm.plugin.sns.k;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.ui.a.b.b;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Collections;

public final class a extends com.tencent.mm.vending.app.a implements f {
    String igi;
    protected volatile com.tencent.mm.plugin.sns.model.am.a rCU;
    public volatile b rEB;
    private com.tencent.mm.plugin.sns.b.h.a rNm;
    boolean rjn;
    String ryC;
    boolean ryD;
    int ryE;

    public final void a(com.tencent.mm.plugin.sns.b.h.a aVar) {
        AppMethodBeat.i(40532);
        this.rCU = af.cnv();
        com.tencent.mm.plugin.sns.k.c.a aVar2 = (com.tencent.mm.plugin.sns.k.c.a) x(com.tencent.mm.plugin.sns.k.c.a.class);
        this.rNm = aVar;
        this.rCU.a(1, aVar2.igi, this.rNm);
        AppMethodBeat.o(40532);
    }

    public final com.tencent.mm.plugin.sns.model.am.a cnv() {
        return this.rCU;
    }

    public final void onCreate() {
        AppMethodBeat.i(40533);
        super.onCreate();
        a(c.b.class, (com.tencent.mm.vending.app.a.a) new com.tencent.mm.vending.app.a.a<c.b>() {
            public final /* synthetic */ Object aoq() {
                AppMethodBeat.i(40530);
                ab.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", c.b.class);
                c.b cvD = a.cvD();
                AppMethodBeat.o(40530);
                return cvD;
            }
        });
        a(com.tencent.mm.plugin.sns.k.c.a.class, (com.tencent.mm.vending.app.a.a) new com.tencent.mm.vending.app.a.a<com.tencent.mm.plugin.sns.k.c.a>() {
            public final /* synthetic */ Object aoq() {
                com.tencent.mm.n.a aoO;
                AppMethodBeat.i(40531);
                ab.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", com.tencent.mm.plugin.sns.k.c.a.class);
                a aVar = a.this;
                com.tencent.mm.plugin.sns.k.c.a aVar2 = new com.tencent.mm.plugin.sns.k.c.a();
                aVar.ryE = aVar.zXe.getIntExtra("sns_source", 0);
                aVar.igi = aVar.zXe.getStringExtra("sns_userName");
                if (aVar.igi == null) {
                    aVar.igi = "";
                }
                g.RQ();
                aVar.ryD = ((j) g.K(j.class)).XM().aoJ(aVar.igi);
                aVar.ryC = r.Yz();
                aVar.rjn = aVar.ryC.equals(aVar.igi);
                bd cnt = af.cnt();
                String bc = bo.bc(aVar.zXe.getStringExtra("sns_signature"), "");
                String bc2 = bo.bc(aVar.zXe.getStringExtra("sns_nickName"), "");
                if (aVar.igi == null || aVar.igi.equals("")) {
                    aoO = cnt.aoO(aVar.ryC);
                } else {
                    aoO = cnt.aoO(aVar.igi);
                }
                if (aoO != null && ((int) aoO.ewQ) > 0) {
                    bc = aoO.signature;
                    bc2 = aoO.Oi();
                    ab.i("MicroMsg.SnsTimelineInteractor", "contact:user[%s] id[%d] nickname[%s]", aoO.field_username, Integer.valueOf((int) aoO.ewQ), bc2);
                }
                aVar2.igi = aVar.igi;
                aVar2.ryC = aVar.ryC;
                aVar2.ryD = aVar.ryD;
                aVar2.rjn = aVar.rjn;
                aVar2.ryE = aVar.ryE;
                aVar2.gHT = bc2;
                aVar2.mSignature = bc;
                AppMethodBeat.o(40531);
                return aVar2;
            }
        });
        ab.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onCreate %s", this);
        com.tencent.mm.plugin.sns.model.b cnA = af.cnA();
        synchronized (cnA.eHH) {
            try {
                cnA.qHH.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(40533);
            }
        }
        af.cnA();
    }

    public final void onDestroy() {
        AppMethodBeat.i(40534);
        ab.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onDestroy %s", this);
        g.RQ();
        if (!(!g.RN().QY() || this.rCU == null || this.rNm == null)) {
            this.rCU.a(this.rNm, 1);
        }
        super.onDestroy();
        AppMethodBeat.o(40534);
    }

    static c.b cvD() {
        Long l;
        AppMethodBeat.i(40535);
        c.b bVar = new c.b();
        Cursor cqF = af.cnK().cqF();
        int count = cqF.getCount();
        String str = "";
        if (count > 0) {
            cqF.moveToFirst();
            com.tencent.mm.plugin.sns.storage.j jVar = new com.tencent.mm.plugin.sns.storage.j();
            jVar.d(cqF);
            try {
                str = ((can) new can().parseFrom(jVar.field_curActionBuf)).wPm;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SnsTimelineInteractor", e, "", new Object[0]);
            }
        }
        cqF.close();
        String[] split = ((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, (Object) "")).split("&");
        ArrayList arrayList = new ArrayList();
        for (int i = 2; i < split.length; i++) {
            long j = bo.getLong(split[i], 0);
            if (j != 0) {
                arrayList.add(Long.valueOf(j));
            }
        }
        Collections.reverse(arrayList);
        if (arrayList.size() > 0) {
            l = (Long) arrayList.get(0);
        } else {
            l = null;
        }
        i.h(l);
        bVar.rNt = count;
        bVar.rNs = str;
        bVar.rNu = arrayList;
        AppMethodBeat.o(40535);
        return bVar;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(40536);
        ab.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onSceneEnd  errType %d %d %s %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar.toString());
        AppMethodBeat.o(40536);
    }

    public final void f(String str, boolean z, int i) {
        AppMethodBeat.i(40537);
        this.rCU.a(1, str, z, i);
        AppMethodBeat.o(40537);
    }

    public final void g(String str, boolean z, int i) {
        AppMethodBeat.i(40538);
        this.rCU.b(1, str, z, i);
        AppMethodBeat.o(40538);
    }
}
