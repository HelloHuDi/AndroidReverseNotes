package com.tencent.p177mm.plugin.sport.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C6546sd;
import com.tencent.p177mm.p230g.p231a.C9345fp;
import com.tencent.p177mm.p230g.p231a.C9345fp.C9346b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C38314b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7574bs;
import java.util.Calendar;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sport.model.b */
public final class C43618b {
    public C4884c<C6546sd> rPb = new C436172();
    public C35161f rPc;
    public C4884c rPh = new C221641();
    private long rPi;
    private long rPj;

    /* renamed from: com.tencent.mm.plugin.sport.model.b$1 */
    class C221641 extends C4884c<C9345fp> {
        C221641() {
            AppMethodBeat.m2504i(93641);
            this.xxI = C9345fp.class.getName().hashCode();
            AppMethodBeat.m2505o(93641);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(93642);
            boolean i = C43618b.this.mo69238i((C9345fp) c4883b);
            AppMethodBeat.m2505o(93642);
            return i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sport.model.b$2 */
    class C436172 extends C4884c<C6546sd> {
        C436172() {
            AppMethodBeat.m2504i(93643);
            this.xxI = C6546sd.class.getName().hashCode();
            AppMethodBeat.m2505o(93643);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(93644);
            C6546sd c6546sd = (C6546sd) c4883b;
            switch (c6546sd.cOe.action) {
                case 1:
                case 2:
                case 3:
                    if (C22172n.cwF()) {
                        boolean kT;
                        long cwC = C22172n.cwC();
                        long aa = C43623k.m78065aa(513, 0);
                        long aa2 = C43623k.m78065aa(512, 0);
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(aa);
                        instance.set(11, 0);
                        instance.set(12, 0);
                        instance.set(13, 0);
                        instance.set(14, 0);
                        if (cwC != instance.getTimeInMillis()) {
                            aa2 = 0;
                        }
                        if (c6546sd.cOe.action == 1) {
                            kT = C43618b.this.mo69239kT(aa2);
                            C4883b c9345fp = new C9345fp();
                            c9345fp.czu.action = 1;
                            C4879a.xxA.mo10048a(c9345fp, Looper.getMainLooper());
                        } else if (C22172n.m33796Z(C43618b.this.cwi(), aa2)) {
                            kT = C43618b.this.mo69239kT(aa2);
                        } else {
                            kT = false;
                        }
                        C4990ab.m7417i("MicroMsg.Sport.ExtApiStepManager", "upload step %d %d %b", Integer.valueOf(c6546sd.cOe.action), Long.valueOf(aa2), Boolean.valueOf(kT));
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(93644);
            return false;
        }
    }

    public C43618b() {
        AppMethodBeat.m2504i(93645);
        this.rPh.dnU();
        this.rPb.dnU();
        AppMethodBeat.m2505o(93645);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: i */
    public final boolean mo69238i(C4883b c4883b) {
        AppMethodBeat.m2504i(93646);
        C9345fp c9345fp = (C9345fp) c4883b;
        switch (c9345fp.czu.action) {
            case 2:
                int i;
                long j = c9345fp.czu.czx;
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = c9345fp.czu.baZ;
                C9346b c9346b = c9345fp.czv;
                if (!C22172n.cvY()) {
                    i = 3906;
                } else if (C22172n.cwF()) {
                    long aa = C43623k.m78065aa(513, 0);
                    long aa2 = C43623k.m78065aa(512, 0);
                    C4990ab.m7419v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", Long.valueOf(aa), Long.valueOf(aa2), Long.valueOf(currentTimeMillis), Long.valueOf(j));
                    if (currentTimeMillis - aa < 300000) {
                        C4990ab.m7420w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
                        i = 3903;
                    } else {
                        JSONObject cwt = C22168h.cwt();
                        if (!C5046bo.m7505L(currentTimeMillis, aa)) {
                            aa = C5046bo.dpC();
                            aa2 = 0;
                        }
                        long j3 = currentTimeMillis - aa;
                        C4990ab.m7419v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", Long.valueOf((j3 / 300000) + ((long) (j3 % 300000 > 0 ? 1 : 0))), Long.valueOf(j3), Long.valueOf(currentTimeMillis), Long.valueOf(aa), Long.valueOf(((long) cwt.optInt("stepCounterMaxStep5m")) * ((j3 / 300000) + ((long) (j3 % 300000 > 0 ? 1 : 0)))));
                        aa2 = j - aa2;
                        if (aa2 < 0 || aa2 > r14) {
                            C4990ab.m7421w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", Long.valueOf(aa2), Long.valueOf(r14));
                            i = 3904;
                        } else {
                            C4990ab.m7417i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", C22172n.m33800fQ(currentTimeMillis), Long.valueOf(j));
                            C43623k.m78066ab(513, currentTimeMillis);
                            C43623k.m78066ab(512, j);
                            C43623k.m78066ab(514, j2);
                            i = 1;
                        }
                    }
                } else {
                    i = 3902;
                }
                c9346b.czA = i;
                if (c9345fp.czv.czA == 1) {
                    if (this.rPi == 0) {
                        this.rPi = C43623k.m78065aa(515, 0);
                    }
                    boolean Y = C22172n.m33795Y(this.rPi, System.currentTimeMillis());
                    boolean Z = C22172n.m33796Z(cwi(), j);
                    if (Y && Z) {
                        mo69239kT(j);
                    }
                }
                c9345fp.czv.czz = true;
                break;
            case 3:
                try {
                    JSONObject optJSONObject = C22168h.cwt().optJSONObject("extStepApiConfig");
                    if (optJSONObject != null) {
                        c9345fp.czv.czy = optJSONObject.toString();
                    }
                    if (C5046bo.isNullOrNil(c9345fp.czv.czy)) {
                        c9345fp.czv.czA = 3905;
                    } else {
                        c9345fp.czv.czA = 1;
                    }
                } catch (Exception e) {
                    c9345fp.czv.czA = 3905;
                }
                c9345fp.czv.czz = true;
                break;
        }
        AppMethodBeat.m2505o(93646);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: kT */
    public final boolean mo69239kT(long j) {
        AppMethodBeat.m2504i(93647);
        if (this.rPc != null) {
            C1720g.m3540Rg().mo14547c(this.rPc);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        C4990ab.m7417i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", C22172n.m33800fQ(currentTimeMillis), Long.valueOf(j));
        this.rPc = new C35161f("", "gh_43f2581f6fd6", (int) (instance.getTimeInMillis() / 1000), (int) (currentTimeMillis / 1000), (int) j, C7574bs.dut(), 2);
        C1720g.m3540Rg().mo14541a(this.rPc, 0);
        m78057kU(currentTimeMillis);
        m78058kV(j);
        AppMethodBeat.m2505o(93647);
        return true;
    }

    /* renamed from: kU */
    private void m78057kU(long j) {
        AppMethodBeat.m2504i(93648);
        this.rPi = j;
        C43623k.m78066ab(515, j);
        AppMethodBeat.m2505o(93648);
    }

    public final long cwi() {
        AppMethodBeat.m2504i(93649);
        if (this.rPj == 0) {
            this.rPj = C43623k.m78065aa(C38314b.CTRL_INDEX, 0);
        }
        long j = this.rPj;
        AppMethodBeat.m2505o(93649);
        return j;
    }

    /* renamed from: kV */
    private void m78058kV(long j) {
        AppMethodBeat.m2504i(93650);
        this.rPj = j;
        C43623k.m78065aa(C38314b.CTRL_INDEX, this.rPj);
        AppMethodBeat.m2505o(93650);
    }
}
