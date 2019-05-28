package com.tencent.p177mm.plugin.expt.hellhound;

import android.app.Activity;
import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p230g.p232b.p233a.C26295w;
import com.tencent.p177mm.plugin.expt.hellhound.core.C3007a;
import com.tencent.p177mm.plugin.expt.hellhound.core.stack.C27896f;
import com.tencent.p177mm.plugin.expt.hellhound.p958a.p959a.C34073b;
import com.tencent.p177mm.plugin.expt.hellhound.p958a.p959a.C34074c;
import com.tencent.p177mm.plugin.expt.hellhound.p958a.p960c.C27893d;
import com.tencent.p177mm.plugin.expt.p394a.C20593b;
import com.tencent.p177mm.plugin.expt.p394a.C20593b.C11746b;
import com.tencent.p177mm.plugin.expt.p394a.C20593b.C3003a;
import com.tencent.p177mm.plugin.expt.p394a.C43014c.C38982a;
import com.tencent.p177mm.plugin.expt.p395c.C27890e;
import com.tencent.p177mm.protocal.protobuf.C44101be;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.b */
public final class C11756b implements C20593b {

    /* renamed from: com.tencent.mm.plugin.expt.hellhound.b$1 */
    static class C68741 implements C3003a {
        C68741() {
        }

        /* renamed from: KM */
        public final void mo7211KM(String str) {
            AppMethodBeat.m2504i(73326);
            C4990ab.m7410d("HellhoundService", "habbyge-mali, callback, startActivity: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(73326);
        }

        /* renamed from: ea */
        public final void mo7212ea(String str, String str2) {
            AppMethodBeat.m2504i(73327);
            C34073b.m55845s(103, str, str2);
            AppMethodBeat.m2505o(73327);
        }

        /* renamed from: eb */
        public final void mo7213eb(String str, String str2) {
            AppMethodBeat.m2504i(73328);
            C34073b.m55845s(103, str, str2);
            AppMethodBeat.m2505o(73328);
        }

        /* renamed from: B */
        public final void mo7207B(Activity activity) {
            AppMethodBeat.m2504i(73329);
            String canonicalName = activity.getClass().getCanonicalName();
            C34073b.m55845s(100, canonicalName, String.valueOf(activity.hashCode()));
            C27893d.m44344a(0, canonicalName, activity);
            AppMethodBeat.m2505o(73329);
        }

        /* renamed from: C */
        public final void mo7208C(Activity activity) {
            AppMethodBeat.m2504i(73330);
            if (activity == null) {
                AppMethodBeat.m2505o(73330);
                return;
            }
            String canonicalName = activity.getClass().getCanonicalName();
            C34073b.m55845s(101, canonicalName, String.valueOf(activity.hashCode()));
            C27893d.m44344a(1, canonicalName, activity);
            AppMethodBeat.m2505o(73330);
        }

        /* renamed from: D */
        public final void mo7209D(Activity activity) {
            AppMethodBeat.m2504i(73331);
            if (activity == null) {
                AppMethodBeat.m2505o(73331);
                return;
            }
            C34073b.m55845s(102, activity.getClass().getCanonicalName(), String.valueOf(activity.hashCode()));
            AppMethodBeat.m2505o(73331);
        }

        /* renamed from: E */
        public final void mo7210E(Activity activity) {
            AppMethodBeat.m2504i(73332);
            if (activity == null) {
                AppMethodBeat.m2505o(73332);
                return;
            }
            C27893d.m44344a(2, activity.getClass().getCanonicalName(), activity);
            AppMethodBeat.m2505o(73332);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.hellhound.b$2 */
    static class C117572 implements C11746b {
        C117572() {
        }

        /* renamed from: ec */
        public final void mo23507ec(String str, String str2) {
            AppMethodBeat.m2504i(73333);
            C34074c.m55846a(str, Integer.valueOf(str2).intValue(), C38982a.MMActivity_Back2Front);
            AppMethodBeat.m2505o(73333);
        }

        /* renamed from: ed */
        public final void mo23508ed(String str, String str2) {
            AppMethodBeat.m2504i(73334);
            C34074c.m55846a(str, Integer.valueOf(str2).intValue(), C38982a.MMActivity_Front2Back);
            AppMethodBeat.m2505o(73334);
        }

        /* renamed from: a */
        public final void mo23506a(String str, String str2, int i, long j, int i2) {
            AppMethodBeat.m2504i(73335);
            C4990ab.m7416i("HellhoundService", "habbyge-mali, frontToBackMMProcessEnd: " + str + "/" + i);
            int intValue = Integer.valueOf(str2).intValue();
            C38982a c38982a = C38982a.MMActivity_Front2Back;
            C26295w c26295w = new C26295w();
            c26295w.cWc = i;
            C26295w eT = c26295w.mo44065eS(((C6624h) C1720g.m3533RM().mo5224Rn()).eHT).mo44066eT(str);
            eT.cYc = (long) i2;
            eT.cWS = (long) c38982a.value;
            eT = eT.mo44064aQ(j);
            eT.cWU = (long) intValue;
            C27890e.brf().mo45791a(eT);
            C4990ab.m7417i("HellFrontBackReport", "habbyge-mali, [进程尾部补偿8] frontback-pure-report [%s]", eT.mo4983Fk());
            AppMethodBeat.m2505o(73335);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.hellhound.b$3 */
    static class C117583 implements C27896f {
        C117583() {
        }

        /* renamed from: a */
        public final void mo23525a(C44101be c44101be) {
            AppMethodBeat.m2504i(73336);
            if (c44101be != null) {
                C27893d.m44344a(3, c44101be.vDg.activityName, null);
            }
            AppMethodBeat.m2505o(73336);
        }

        /* renamed from: b */
        public final void mo23526b(C44101be c44101be) {
            AppMethodBeat.m2504i(73337);
            if (c44101be != null) {
                C27893d.m44344a(3, c44101be.vDg.activityName, null);
            }
            AppMethodBeat.m2505o(73337);
        }
    }

    /* renamed from: d */
    public static void m19564d(C1681g c1681g) {
        AppMethodBeat.m2504i(73338);
        if (c1681g == null) {
            AppMethodBeat.m2505o(73338);
        } else if (C11755a.bqj()) {
            C4990ab.m7416i("HellhoundService", "habbyge-mali, IHellhoundService Start !!!");
            C1720g.m3542a(C20593b.class, new C11756b());
            C20593b c20593b = (C20593b) C1720g.m3528K(C20593b.class);
            c20593b.mo23522a(new C68741());
            c20593b.mo23523a(new C117572());
            C3007a.bqm();
            C3007a.m5295a(new C117583());
            c20593b.mo23524f(c1681g.f1233cc);
            C34073b.m55845s(104, "", "");
            AppMethodBeat.m2505o(73338);
        } else {
            C4990ab.m7420w("HellhoundService", "habbyge-mali, IHellhoundService Close !!!");
            AppMethodBeat.m2505o(73338);
        }
    }

    /* renamed from: a */
    public final void mo23522a(C3003a c3003a) {
        AppMethodBeat.m2504i(73339);
        C3007a bqm = C3007a.bqm();
        if (C3007a.bqn()) {
            bqm.lMk.mo23547a(c3003a);
        }
        AppMethodBeat.m2505o(73339);
    }

    /* renamed from: a */
    public final void mo23523a(C11746b c11746b) {
        AppMethodBeat.m2504i(73340);
        C34073b.bqF().lMP = c11746b;
        AppMethodBeat.m2505o(73340);
    }

    /* renamed from: f */
    public final void mo23524f(Application application) {
        AppMethodBeat.m2504i(73341);
        C3007a bqm = C3007a.bqm();
        C4990ab.m7416i("Hellhound", "habbyge-Hellhound.startMonitor()");
        if (C3007a.bqn()) {
            bqm.lMk.mo23550g(application);
        }
        AppMethodBeat.m2505o(73341);
    }
}
