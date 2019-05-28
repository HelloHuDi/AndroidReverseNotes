package com.tencent.p177mm.plugin.freewifi.p418ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p418ui.C45962c.C28105a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.d */
public final class C39125d {

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.d$1 */
    static class C391261 implements C28105a {
        C391261() {
        }

        /* renamed from: Q */
        public final void mo46025Q(float f, float f2) {
            AppMethodBeat.m2504i(21005);
            try {
                String valueOf = String.valueOf(f);
                String valueOf2 = String.valueOf(f2);
                if (C11976j.byW().mo17045ML(C45957d.byO()) != null) {
                    C7060h.pYm.mo8381e(12073, r2.field_ssid, r2.field_mac, r2.field_url, r2.field_url, valueOf2, valueOf);
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location. ssid=%s, mac=%s, mp_url=%s, qrcode=%s, longtitued=%s, latitude=%s", r2.field_ssid, r2.field_mac, r2.field_url, r2.field_url, valueOf, valueOf2);
                }
                AppMethodBeat.m2505o(21005);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location exception. " + e.getMessage() + C34189m.m56078h(e));
                AppMethodBeat.m2505o(21005);
            }
        }
    }

    /* renamed from: IF */
    public static void m66564IF() {
        AppMethodBeat.m2504i(21006);
        try {
            C45962c.bzM().mo73827a(new C391261());
            AppMethodBeat.m2505o(21006);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location error. " + e.getMessage());
            AppMethodBeat.m2505o(21006);
        }
    }
}
