package com.tencent.mm.plugin.gai;

import com.google.android.gms.common.GoogleApiAvailability;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.gai.a.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class Plugin implements c {
    public Plugin() {
        AppMethodBeat.i(21211);
        ab.i("MicroMsg.Plugin.gai", "gai Plugin! %b", Boolean.valueOf(ah.getContext().getSharedPreferences(ah.doA() + "_google_aid", h.Mu()).getBoolean("already_report_googleaid", false)));
        if (!ah.getContext().getSharedPreferences(ah.doA() + "_google_aid", h.Mu()).getBoolean("already_report_googleaid", false)) {
            int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ah.getContext());
            if (isGooglePlayServicesAvailable == 1 || isGooglePlayServicesAvailable == 9) {
                ab.w("MicroMsg.Plugin.gai", "gp service invalid, just ignore");
                ah.getContext().getSharedPreferences(ah.doA() + "_google_aid", h.Mu()).edit().putBoolean("already_report_googleaid", true).commit();
            } else {
                ah.getContext();
                AnonymousClass1 anonymousClass1 = new Object() {
                };
                d.post(new Runnable() {
                    public final void run() {
                    }
                }, "Advertisement-MAT-thread");
                AppMethodBeat.o(21211);
                return;
            }
        }
        AppMethodBeat.o(21211);
    }

    public o createApplication() {
        AppMethodBeat.i(21212);
        a aVar = new a();
        AppMethodBeat.o(21212);
        return aVar;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        AppMethodBeat.i(21213);
        com.tencent.mm.plugin.gai.b.a aVar = new com.tencent.mm.plugin.gai.b.a();
        AppMethodBeat.o(21213);
        return aVar;
    }
}
