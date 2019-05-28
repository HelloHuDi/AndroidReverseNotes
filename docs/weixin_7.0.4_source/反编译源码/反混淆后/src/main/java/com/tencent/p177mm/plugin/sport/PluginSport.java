package com.tencent.p177mm.plugin.sport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1669a;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p238a.p240b.C1654a;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.sport.model.C22166g;
import com.tencent.p177mm.plugin.sport.model.C22168h;
import com.tencent.p177mm.plugin.sport.model.C22168h.C13733a;
import com.tencent.p177mm.plugin.sport.model.C22172n;
import com.tencent.p177mm.plugin.sport.model.C43618b;
import com.tencent.p177mm.plugin.sport.model.C43622j;
import com.tencent.p177mm.plugin.sport.model.C43623k;
import com.tencent.p177mm.plugin.sport.model.C43624l;
import com.tencent.p177mm.plugin.sport.model.C46267a;
import com.tencent.p177mm.plugin.sport.model.C46268m;
import com.tencent.p177mm.plugin.sport.p1302a.C39858b;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.sport.PluginSport */
public class PluginSport extends C7597f implements C1655b, C1669a, C9562c, C22163a {
    public static HashMap<Integer, C1366d> eaA;
    private C43622j rOM;
    private C39858b rON;
    private C46267a rOO;
    private C43618b rOP;
    private C43624l rOQ;
    private C46268m rOR;
    private C13733a rOS = new C221601();
    private C22166g rOT;
    private BroadcastReceiver rOU = new C221613();

    /* renamed from: com.tencent.mm.plugin.sport.PluginSport$1 */
    class C221601 implements C13733a {
        C221601() {
        }

        /* renamed from: Pi */
        public final void mo25935Pi() {
            AppMethodBeat.m2504i(93605);
            C46267a deviceStepManager = PluginSport.this.getDeviceStepManager();
            if (deviceStepManager.rPa != null) {
                deviceStepManager.rPa.cwj();
            }
            AppMethodBeat.m2505o(93605);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sport.PluginSport$3 */
    class C221613 extends BroadcastReceiver {
        C221613() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(93606);
            if ("com.tencent.mm.plugin.sport.uploadstep".equals(intent.getAction()) && C22172n.m33799eU(C4996ah.getContext()) && C22172n.cvY()) {
                PluginSport.this.getDeviceStepManager().cwd();
            }
            AppMethodBeat.m2505o(93606);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sport.PluginSport$2 */
    static class C292582 implements C1366d {
        C292582() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46268m.rPO;
        }
    }

    public PluginSport() {
        AppMethodBeat.m2504i(93607);
        AppMethodBeat.m2505o(93607);
    }

    public void configure(C1681g c1681g) {
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(93608);
        if (this.rOM == null) {
            this.rOM = C43623k.cwx();
        }
        if (c1681g.mo5181SG()) {
            this.rON = new C46266b();
            C1720g.m3543a(C39858b.class, new C6625e(this.rON));
            AppMethodBeat.m2505o(93608);
            return;
        }
        if (c1681g.mo5183lQ(":push")) {
            getPushSportStepDetector();
        }
        AppMethodBeat.m2505o(93608);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(93609);
        this.rOO = new C46267a();
        this.rOP = new C43618b();
        this.rOR = new C46268m();
        this.rOQ = new C43624l();
        C22168h.m33793a(this.rOS);
        this.rOS.mo25935Pi();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.plugin.sport.uploadstep");
        C4996ah.getContext().registerReceiver(this.rOU, intentFilter);
        AppMethodBeat.m2505o(93609);
    }

    public C43622j getSportFileStorage() {
        AppMethodBeat.m2504i(93610);
        if (this.rOM == null) {
            this.rOM = C43623k.cwx();
        }
        C43622j c43622j = this.rOM;
        AppMethodBeat.m2505o(93610);
        return c43622j;
    }

    public C46267a getDeviceStepManager() {
        return this.rOO;
    }

    public C43618b getExtApiStepManager() {
        return this.rOP;
    }

    public C43624l getSportStepManager() {
        return this.rOQ;
    }

    public C46268m getSportStepStorage() {
        return this.rOR;
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(93611);
        C4996ah.getContext().unregisterReceiver(this.rOU);
        C22168h.m33793a(null);
        if (this.rOO != null) {
            C46267a c46267a = this.rOO;
            c46267a.rPa.cwk();
            c46267a.rPb.dead();
            if (c46267a.rPc != null) {
                C1720g.m3540Rg().mo14547c(c46267a.rPc);
            }
            this.rOO = null;
        }
        if (this.rOP != null) {
            C43618b c43618b = this.rOP;
            c43618b.rPh.dead();
            c43618b.rPb.dead();
            if (c43618b.rPc != null) {
                C1720g.m3540Rg().mo14547c(c43618b.rPc);
            }
            this.rOP = null;
        }
        AppMethodBeat.m2505o(93611);
    }

    public void parallelsDependency() {
        AppMethodBeat.m2504i(93612);
        C1654a.m3349a(this, C1671c.class).mo5129aJ(C1720g.m3530M(C6983p.class));
        AppMethodBeat.m2505o(93612);
    }

    static {
        AppMethodBeat.m2504i(93614);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("SPORTSTEP_TABLE".hashCode()), new C292582());
        AppMethodBeat.m2505o(93614);
    }

    public HashMap<Integer, C1366d> collectDatabaseFactory() {
        return eaA;
    }

    public C22166g getPushSportStepDetector() {
        AppMethodBeat.m2504i(93613);
        if (C4996ah.doE() && this.rOT == null) {
            this.rOT = new C22166g();
        }
        C22166g c22166g = this.rOT;
        AppMethodBeat.m2505o(93613);
        return c22166g;
    }
}
