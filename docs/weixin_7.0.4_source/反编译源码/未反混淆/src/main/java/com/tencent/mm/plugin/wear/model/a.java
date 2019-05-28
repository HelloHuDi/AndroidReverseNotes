package com.tencent.mm.plugin.wear.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.wear.model.e.c;
import com.tencent.mm.plugin.wear.model.e.f;
import com.tencent.mm.plugin.wear.model.e.g;
import com.tencent.mm.plugin.wear.model.e.h;
import com.tencent.mm.plugin.wear.model.e.k;
import com.tencent.mm.plugin.wear.model.e.l;
import com.tencent.mm.plugin.wear.model.e.m;
import com.tencent.mm.plugin.wear.model.e.n;
import com.tencent.mm.plugin.wear.model.e.o;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g.b;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public final class a implements at {
    public com.tencent.mm.plugin.wear.model.g.a tXA;
    private e tXB;
    q tXr;
    public r tXs;
    public d tXt;
    private e tXu;
    public g tXv;
    public b tXw;
    private WearMessageLogic tXx;
    private i tXy;
    public j tXz;

    public a() {
        AppMethodBeat.i(26267);
        ab.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", getClass().getClassLoader());
        AppMethodBeat.o(26267);
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public static a cUn() {
        AppMethodBeat.i(26268);
        aw.ZE();
        a aVar = (a) bw.oJ("plugin.wear");
        if (aVar == null) {
            aVar = new a();
            aw.ZE().a("plugin.wear", aVar);
        }
        AppMethodBeat.o(26268);
        return aVar;
    }

    public final void iy(int i) {
        AppMethodBeat.i(26269);
        ab.i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", Integer.valueOf(i));
        AppMethodBeat.o(26269);
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(26270);
        p.e.vaw = new c();
        ab.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", Boolean.valueOf(z));
        this.tXr = new q();
        this.tXs = new r();
        this.tXz = new j();
        this.tXu = new e();
        this.tXv = new g();
        this.tXw = new b();
        this.tXt = new d();
        this.tXx = new WearMessageLogic();
        this.tXy = new i();
        this.tXA = new com.tencent.mm.plugin.wear.model.g.a();
        this.tXB = new b();
        e.d.a(Integer.valueOf(63), this.tXB);
        this.tXr.a(this.tXt.tXJ);
        this.tXr.a(this.tXt.tXK);
        this.tXr.a(this.tXt.tXL);
        this.tXr.a(new h());
        this.tXr.a(new g());
        this.tXr.a(new com.tencent.mm.plugin.wear.model.e.d());
        this.tXr.a(new c());
        this.tXr.a(new com.tencent.mm.plugin.wear.model.e.e());
        this.tXr.a(new f());
        this.tXr.a(new k());
        this.tXr.a(new m());
        this.tXr.a(new o());
        this.tXr.a(new n());
        this.tXr.a(new l());
        this.tXz.a(new com.tencent.mm.plugin.wear.model.f.c() {
            public final String getName() {
                return "PhoneStartTask";
            }

            public final void send() {
                AppMethodBeat.i(26265);
                r.b(CdnLogic.kMediaTypeBackupFile, null, false);
                r.b(20008, null, false);
                AppMethodBeat.o(26265);
            }
        });
        j jVar = this.tXz;
        AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.wear.model.f.c() {
            public final void send() {
                AppMethodBeat.i(26266);
                if (a.this.tXt.cUt() != null) {
                    a.this.tXt.cUt().cUz();
                }
                r.b(20009, null, false);
                r.b(20017, null, false);
                AppMethodBeat.o(26266);
            }

            public final String getName() {
                return "SyncFileTask";
            }
        };
        if (jVar.ilv != null) {
            jVar.ilv.sendMessageDelayed(jVar.ilv.obtainMessage(0, anonymousClass2), 5000);
        }
        AppMethodBeat.o(26270);
    }

    public final void bA(boolean z) {
        AppMethodBeat.i(26271);
        ab.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", Boolean.valueOf(z));
        AppMethodBeat.o(26271);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(26272);
        e.d.b(Integer.valueOf(63), this.tXB);
        this.tXB = null;
        ab.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
        this.tXr.tYL.clear();
        this.tXr = null;
        this.tXs = null;
        e eVar = this.tXu;
        eVar.gyS.stopTimer();
        eVar.ryO.dead();
        eVar.tXP.dead();
        eVar.tXQ.dead();
        eVar.ilT.dead();
        eVar.tXR.dead();
        eVar.tXS.dead();
        eVar.tXT.dead();
        eVar.edy.dead();
        eVar.nZv.dead();
        aw.ZK();
        com.tencent.mm.model.c.XO().a(eVar.lPn);
        this.tXu = null;
        this.tXv = null;
        b bVar = this.tXw;
        com.tencent.mm.sdk.b.a.xxA.d(bVar.tXE);
        aw.ZK();
        com.tencent.mm.model.c.XM().b(bVar.mFC);
        bVar.tXF.stopTimer();
        this.tXw = null;
        d dVar = this.tXt;
        dVar.tXI.finish();
        dVar.tXM.reset();
        this.tXt = null;
        ah.getContext().unregisterReceiver(this.tXx);
        this.tXx = null;
        j jVar = this.tXz;
        if (jVar.handlerThread != null) {
            jVar.handlerThread.quit();
        }
        this.tXz = null;
        i iVar = this.tXy;
        iVar.eoY = null;
        iVar.cUu();
        ah.getContext().unregisterReceiver(iVar.tYm);
        this.tXy = null;
        AppMethodBeat.o(26272);
    }
}
