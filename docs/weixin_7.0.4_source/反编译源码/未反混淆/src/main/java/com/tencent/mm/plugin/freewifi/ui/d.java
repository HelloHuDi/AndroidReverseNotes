package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class d {
    public static void IF() {
        AppMethodBeat.i(21006);
        try {
            c.bzM().a(new a() {
                public final void Q(float f, float f2) {
                    AppMethodBeat.i(21005);
                    try {
                        String valueOf = String.valueOf(f);
                        String valueOf2 = String.valueOf(f2);
                        if (j.byW().ML(com.tencent.mm.plugin.freewifi.model.d.byO()) != null) {
                            h.pYm.e(12073, r2.field_ssid, r2.field_mac, r2.field_url, r2.field_url, valueOf2, valueOf);
                            ab.i("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location. ssid=%s, mac=%s, mp_url=%s, qrcode=%s, longtitued=%s, latitude=%s", r2.field_ssid, r2.field_mac, r2.field_url, r2.field_url, valueOf, valueOf2);
                        }
                        AppMethodBeat.o(21005);
                    } catch (Exception e) {
                        ab.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location exception. " + e.getMessage() + m.h(e));
                        AppMethodBeat.o(21005);
                    }
                }
            });
            AppMethodBeat.o(21006);
        } catch (Exception e) {
            ab.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location error. " + e.getMessage());
            AppMethodBeat.o(21006);
        }
    }
}
