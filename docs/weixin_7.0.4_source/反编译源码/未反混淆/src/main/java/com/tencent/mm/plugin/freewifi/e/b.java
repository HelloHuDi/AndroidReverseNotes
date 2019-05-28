package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b {
    private static String TAG = "MicroMsg.FreeWifi.Protocol31Entry";

    static class a {
        private static b mwz = new b();

        static {
            AppMethodBeat.i(20800);
            AppMethodBeat.o(20800);
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
    }

    public static b bzr() {
        AppMethodBeat.i(20801);
        b bzs = a.mwz;
        AppMethodBeat.o(20801);
        return bzs;
    }

    public static void aa(Intent intent) {
        boolean z = true;
        AppMethodBeat.i(20802);
        if (intent == null) {
            AppMethodBeat.o(20802);
            return;
        }
        String stringExtra = intent.getStringExtra("free_wifi_ap_key");
        if (!m.isEmpty(stringExtra)) {
            int intExtra = intent.getIntExtra("free_wifi_threeone_startup_type", 0);
            if (2 == intExtra) {
                intExtra = 11;
            } else if (3 == intExtra) {
                intExtra = 12;
            } else if (4 == intExtra) {
                intExtra = 13;
            } else {
                intExtra = 1;
            }
            intent.putExtra("free_wifi_channel_id", intExtra);
            intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
            m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
            intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.V(intent) + "_" + m.X(intent) + "_" + m.Y(intent) + "_" + System.currentTimeMillis());
            boolean v = a.mwE.v(intent.getIntExtra("free_wifi_threeone_startup_type", 0), intent.getStringExtra("free_wifi_ap_key"), intent.getStringExtra("free_wifi_schema_ticket"));
            com.tencent.mm.plugin.freewifi.k.a byo = k.byo();
            byo.ssid = m.Mx(TAG);
            byo.bssid = m.My(TAG);
            byo.cuH = stringExtra;
            byo.kBq = intent.getStringExtra("free_wifi_schema_ticket");
            byo.mue = m.X(intent);
            byo.muf = com.tencent.mm.plugin.freewifi.k.b.GetThreeOneLock.muQ;
            byo.mug = com.tencent.mm.plugin.freewifi.k.b.GetThreeOneLock.name;
            byo.cIb = m.Y(intent);
            if (v) {
                intExtra = 0;
            } else {
                intExtra = -1;
            }
            byo.result = intExtra;
            k byq = byo.byq();
            if (v) {
                z = false;
            }
            byq.b(intent, z).byp();
            ab.i(TAG, "getLock = ".concat(String.valueOf(v)));
            m.MA("type=" + intent.getIntExtra("free_wifi_threeone_startup_type", 0) + ";getLock=" + v);
            if (v) {
                m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                intent.setClass(ah.getContext(), FreeWifiNetCheckUI.class);
                intent.addFlags(67108864);
                d.b(ah.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
            }
        }
        AppMethodBeat.o(20802);
    }
}
