package com.tencent.mm.plugin.sport.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bs;
import java.util.Calendar;
import org.json.JSONObject;

public final class b {
    public c<sd> rPb = new c<sd>() {
        {
            AppMethodBeat.i(93643);
            this.xxI = sd.class.getName().hashCode();
            AppMethodBeat.o(93643);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(93644);
            sd sdVar = (sd) bVar;
            switch (sdVar.cOe.action) {
                case 1:
                case 2:
                case 3:
                    if (n.cwF()) {
                        boolean kT;
                        long cwC = n.cwC();
                        long aa = k.aa(513, 0);
                        long aa2 = k.aa(512, 0);
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(aa);
                        instance.set(11, 0);
                        instance.set(12, 0);
                        instance.set(13, 0);
                        instance.set(14, 0);
                        if (cwC != instance.getTimeInMillis()) {
                            aa2 = 0;
                        }
                        if (sdVar.cOe.action == 1) {
                            kT = b.this.kT(aa2);
                            com.tencent.mm.sdk.b.b fpVar = new fp();
                            fpVar.czu.action = 1;
                            a.xxA.a(fpVar, Looper.getMainLooper());
                        } else if (n.Z(b.this.cwi(), aa2)) {
                            kT = b.this.kT(aa2);
                        } else {
                            kT = false;
                        }
                        ab.i("MicroMsg.Sport.ExtApiStepManager", "upload step %d %d %b", Integer.valueOf(sdVar.cOe.action), Long.valueOf(aa2), Boolean.valueOf(kT));
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(93644);
            return false;
        }
    };
    public f rPc;
    public c rPh = new c<fp>() {
        {
            AppMethodBeat.i(93641);
            this.xxI = fp.class.getName().hashCode();
            AppMethodBeat.o(93641);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(93642);
            boolean i = b.this.i((fp) bVar);
            AppMethodBeat.o(93642);
            return i;
        }
    };
    private long rPi;
    private long rPj;

    public b() {
        AppMethodBeat.i(93645);
        this.rPh.dnU();
        this.rPb.dnU();
        AppMethodBeat.o(93645);
    }

    /* Access modifiers changed, original: final */
    public final boolean i(com.tencent.mm.sdk.b.b bVar) {
        AppMethodBeat.i(93646);
        fp fpVar = (fp) bVar;
        switch (fpVar.czu.action) {
            case 2:
                int i;
                long j = fpVar.czu.czx;
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = fpVar.czu.baZ;
                com.tencent.mm.g.a.fp.b bVar2 = fpVar.czv;
                if (!n.cvY()) {
                    i = 3906;
                } else if (n.cwF()) {
                    long aa = k.aa(513, 0);
                    long aa2 = k.aa(512, 0);
                    ab.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", Long.valueOf(aa), Long.valueOf(aa2), Long.valueOf(currentTimeMillis), Long.valueOf(j));
                    if (currentTimeMillis - aa < 300000) {
                        ab.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
                        i = 3903;
                    } else {
                        JSONObject cwt = h.cwt();
                        if (!bo.L(currentTimeMillis, aa)) {
                            aa = bo.dpC();
                            aa2 = 0;
                        }
                        long j3 = currentTimeMillis - aa;
                        ab.v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", Long.valueOf((j3 / 300000) + ((long) (j3 % 300000 > 0 ? 1 : 0))), Long.valueOf(j3), Long.valueOf(currentTimeMillis), Long.valueOf(aa), Long.valueOf(((long) cwt.optInt("stepCounterMaxStep5m")) * ((j3 / 300000) + ((long) (j3 % 300000 > 0 ? 1 : 0)))));
                        aa2 = j - aa2;
                        if (aa2 < 0 || aa2 > r14) {
                            ab.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", Long.valueOf(aa2), Long.valueOf(r14));
                            i = 3904;
                        } else {
                            ab.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", n.fQ(currentTimeMillis), Long.valueOf(j));
                            k.ab(513, currentTimeMillis);
                            k.ab(512, j);
                            k.ab(514, j2);
                            i = 1;
                        }
                    }
                } else {
                    i = 3902;
                }
                bVar2.czA = i;
                if (fpVar.czv.czA == 1) {
                    if (this.rPi == 0) {
                        this.rPi = k.aa(515, 0);
                    }
                    boolean Y = n.Y(this.rPi, System.currentTimeMillis());
                    boolean Z = n.Z(cwi(), j);
                    if (Y && Z) {
                        kT(j);
                    }
                }
                fpVar.czv.czz = true;
                break;
            case 3:
                try {
                    JSONObject optJSONObject = h.cwt().optJSONObject("extStepApiConfig");
                    if (optJSONObject != null) {
                        fpVar.czv.czy = optJSONObject.toString();
                    }
                    if (bo.isNullOrNil(fpVar.czv.czy)) {
                        fpVar.czv.czA = 3905;
                    } else {
                        fpVar.czv.czA = 1;
                    }
                } catch (Exception e) {
                    fpVar.czv.czA = 3905;
                }
                fpVar.czv.czz = true;
                break;
        }
        AppMethodBeat.o(93646);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final boolean kT(long j) {
        AppMethodBeat.i(93647);
        if (this.rPc != null) {
            g.Rg().c(this.rPc);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        ab.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", n.fQ(currentTimeMillis), Long.valueOf(j));
        this.rPc = new f("", "gh_43f2581f6fd6", (int) (instance.getTimeInMillis() / 1000), (int) (currentTimeMillis / 1000), (int) j, bs.dut(), 2);
        g.Rg().a(this.rPc, 0);
        kU(currentTimeMillis);
        kV(j);
        AppMethodBeat.o(93647);
        return true;
    }

    private void kU(long j) {
        AppMethodBeat.i(93648);
        this.rPi = j;
        k.ab(515, j);
        AppMethodBeat.o(93648);
    }

    public final long cwi() {
        AppMethodBeat.i(93649);
        if (this.rPj == 0) {
            this.rPj = k.aa(com.tencent.mm.plugin.appbrand.jsapi.j.b.CTRL_INDEX, 0);
        }
        long j = this.rPj;
        AppMethodBeat.o(93649);
        return j;
    }

    private void kV(long j) {
        AppMethodBeat.i(93650);
        this.rPj = j;
        k.aa(com.tencent.mm.plugin.appbrand.jsapi.j.b.CTRL_INDEX, this.rPj);
        AppMethodBeat.o(93650);
    }
}
