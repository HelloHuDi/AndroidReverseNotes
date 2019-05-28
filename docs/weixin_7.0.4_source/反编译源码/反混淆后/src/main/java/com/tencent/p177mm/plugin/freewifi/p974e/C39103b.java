package com.tencent.p177mm.plugin.freewifi.p974e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiNetCheckUI;
import com.tencent.p177mm.plugin.freewifi.p974e.C39105d.C39106a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.freewifi.e.b */
public final class C39103b {
    private static String TAG = "MicroMsg.FreeWifi.Protocol31Entry";

    /* renamed from: com.tencent.mm.plugin.freewifi.e.b$a */
    static class C11957a {
        private static C39103b mwz = new C39103b();

        static {
            AppMethodBeat.m2504i(20800);
            AppMethodBeat.m2505o(20800);
        }
    }

    /* synthetic */ C39103b(byte b) {
        this();
    }

    private C39103b() {
    }

    public static C39103b bzr() {
        AppMethodBeat.m2504i(20801);
        C39103b bzs = C11957a.mwz;
        AppMethodBeat.m2505o(20801);
        return bzs;
    }

    /* renamed from: aa */
    public static void m66544aa(Intent intent) {
        boolean z = true;
        AppMethodBeat.m2504i(20802);
        if (intent == null) {
            AppMethodBeat.m2505o(20802);
            return;
        }
        String stringExtra = intent.getStringExtra("free_wifi_ap_key");
        if (!C34189m.isEmpty(stringExtra)) {
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
            C34189m.m56072d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
            intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", C34189m.m56063V(intent) + "_" + C34189m.m56065X(intent) + "_" + C34189m.m56066Y(intent) + "_" + System.currentTimeMillis());
            boolean v = C39106a.mwE.mo62007v(intent.getIntExtra("free_wifi_threeone_startup_type", 0), intent.getStringExtra("free_wifi_ap_key"), intent.getStringExtra("free_wifi_schema_ticket"));
            C11967a byo = C11966k.byo();
            byo.ssid = C34189m.m56059Mx(TAG);
            byo.bssid = C34189m.m56060My(TAG);
            byo.cuH = stringExtra;
            byo.kBq = intent.getStringExtra("free_wifi_schema_ticket");
            byo.mue = C34189m.m56065X(intent);
            byo.muf = C11968b.GetThreeOneLock.muQ;
            byo.mug = C11968b.GetThreeOneLock.name;
            byo.cIb = C34189m.m56066Y(intent);
            if (v) {
                intExtra = 0;
            } else {
                intExtra = -1;
            }
            byo.result = intExtra;
            C11966k byq = byo.byq();
            if (v) {
                z = false;
            }
            byq.mo23810b(intent, z).byp();
            C4990ab.m7416i(TAG, "getLock = ".concat(String.valueOf(v)));
            C34189m.m56056MA("type=" + intent.getIntExtra("free_wifi_threeone_startup_type", 0) + ";getLock=" + v);
            if (v) {
                C34189m.m56072d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                intent.setClass(C4996ah.getContext(), FreeWifiNetCheckUI.class);
                intent.addFlags(67108864);
                C25985d.m41467b(C4996ah.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
            }
        }
        AppMethodBeat.m2505o(20802);
    }
}
