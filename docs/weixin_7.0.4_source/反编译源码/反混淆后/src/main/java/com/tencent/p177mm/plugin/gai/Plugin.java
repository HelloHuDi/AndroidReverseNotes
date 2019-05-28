package com.tencent.p177mm.plugin.gai;

import com.google.android.gms.common.GoogleApiAvailability;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.gai.p1361a.C24772a;
import com.tencent.p177mm.plugin.gai.p1484b.C34236a;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.gai.Plugin */
public class Plugin implements C40415c {

    /* renamed from: com.tencent.mm.plugin.gai.Plugin$1 */
    class C120761 {
        C120761() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.gai.Plugin$2 */
    class C281572 implements Runnable {
        C281572() {
        }

        public final void run() {
        }
    }

    public Plugin() {
        AppMethodBeat.m2504i(21211);
        C4990ab.m7417i("MicroMsg.Plugin.gai", "gai Plugin! %b", Boolean.valueOf(C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_google_aid", C1448h.m3078Mu()).getBoolean("already_report_googleaid", false)));
        if (!C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_google_aid", C1448h.m3078Mu()).getBoolean("already_report_googleaid", false)) {
            int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(C4996ah.getContext());
            if (isGooglePlayServicesAvailable == 1 || isGooglePlayServicesAvailable == 9) {
                C4990ab.m7420w("MicroMsg.Plugin.gai", "gp service invalid, just ignore");
                C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_google_aid", C1448h.m3078Mu()).edit().putBoolean("already_report_googleaid", true).commit();
            } else {
                C4996ah.getContext();
                C120761 c120761 = new C120761();
                C7305d.post(new C281572(), "Advertisement-MAT-thread");
                AppMethodBeat.m2505o(21211);
                return;
            }
        }
        AppMethodBeat.m2505o(21211);
    }

    public C23256o createApplication() {
        AppMethodBeat.m2504i(21212);
        C24772a c24772a = new C24772a();
        AppMethodBeat.m2505o(21212);
        return c24772a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(21213);
        C34236a c34236a = new C34236a();
        AppMethodBeat.m2505o(21213);
        return c34236a;
    }
}
