package com.tencent.mm.plugin.sport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.sport.model.g;
import com.tencent.mm.plugin.sport.model.h;
import com.tencent.mm.plugin.sport.model.j;
import com.tencent.mm.plugin.sport.model.k;
import com.tencent.mm.plugin.sport.model.l;
import com.tencent.mm.plugin.sport.model.m;
import com.tencent.mm.plugin.sport.model.n;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public class PluginSport extends f implements b, a, c, a {
    public static HashMap<Integer, d> eaA;
    private j rOM;
    private com.tencent.mm.plugin.sport.a.b rON;
    private com.tencent.mm.plugin.sport.model.a rOO;
    private com.tencent.mm.plugin.sport.model.b rOP;
    private l rOQ;
    private m rOR;
    private h.a rOS = new h.a() {
        public final void Pi() {
            AppMethodBeat.i(93605);
            com.tencent.mm.plugin.sport.model.a deviceStepManager = PluginSport.this.getDeviceStepManager();
            if (deviceStepManager.rPa != null) {
                deviceStepManager.rPa.cwj();
            }
            AppMethodBeat.o(93605);
        }
    };
    private g rOT;
    private BroadcastReceiver rOU = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(93606);
            if ("com.tencent.mm.plugin.sport.uploadstep".equals(intent.getAction()) && n.eU(ah.getContext()) && n.cvY()) {
                PluginSport.this.getDeviceStepManager().cwd();
            }
            AppMethodBeat.o(93606);
        }
    };

    public PluginSport() {
        AppMethodBeat.i(93607);
        AppMethodBeat.o(93607);
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(93608);
        if (this.rOM == null) {
            this.rOM = k.cwx();
        }
        if (gVar.SG()) {
            this.rON = new b();
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sport.a.b.class, new e(this.rON));
            AppMethodBeat.o(93608);
            return;
        }
        if (gVar.lQ(":push")) {
            getPushSportStepDetector();
        }
        AppMethodBeat.o(93608);
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(93609);
        this.rOO = new com.tencent.mm.plugin.sport.model.a();
        this.rOP = new com.tencent.mm.plugin.sport.model.b();
        this.rOR = new m();
        this.rOQ = new l();
        h.a(this.rOS);
        this.rOS.Pi();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.plugin.sport.uploadstep");
        ah.getContext().registerReceiver(this.rOU, intentFilter);
        AppMethodBeat.o(93609);
    }

    public j getSportFileStorage() {
        AppMethodBeat.i(93610);
        if (this.rOM == null) {
            this.rOM = k.cwx();
        }
        j jVar = this.rOM;
        AppMethodBeat.o(93610);
        return jVar;
    }

    public com.tencent.mm.plugin.sport.model.a getDeviceStepManager() {
        return this.rOO;
    }

    public com.tencent.mm.plugin.sport.model.b getExtApiStepManager() {
        return this.rOP;
    }

    public l getSportStepManager() {
        return this.rOQ;
    }

    public m getSportStepStorage() {
        return this.rOR;
    }

    public void onAccountRelease() {
        AppMethodBeat.i(93611);
        ah.getContext().unregisterReceiver(this.rOU);
        h.a(null);
        if (this.rOO != null) {
            com.tencent.mm.plugin.sport.model.a aVar = this.rOO;
            aVar.rPa.cwk();
            aVar.rPb.dead();
            if (aVar.rPc != null) {
                com.tencent.mm.kernel.g.Rg().c(aVar.rPc);
            }
            this.rOO = null;
        }
        if (this.rOP != null) {
            com.tencent.mm.plugin.sport.model.b bVar = this.rOP;
            bVar.rPh.dead();
            bVar.rPb.dead();
            if (bVar.rPc != null) {
                com.tencent.mm.kernel.g.Rg().c(bVar.rPc);
            }
            this.rOP = null;
        }
        AppMethodBeat.o(93611);
    }

    public void parallelsDependency() {
        AppMethodBeat.i(93612);
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aJ(com.tencent.mm.kernel.g.M(p.class));
        AppMethodBeat.o(93612);
    }

    static {
        AppMethodBeat.i(93614);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("SPORTSTEP_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return m.rPO;
            }
        });
        AppMethodBeat.o(93614);
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        return eaA;
    }

    public g getPushSportStepDetector() {
        AppMethodBeat.i(93613);
        if (ah.doE() && this.rOT == null) {
            this.rOT = new g();
        }
        g gVar = this.rOT;
        AppMethodBeat.o(93613);
        return gVar;
    }
}
