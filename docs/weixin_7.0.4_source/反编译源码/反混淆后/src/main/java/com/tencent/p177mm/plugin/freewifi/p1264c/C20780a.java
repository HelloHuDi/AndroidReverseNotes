package com.tencent.p177mm.plugin.freewifi.p1264c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.freewifi.c.a */
public final class C20780a {
    public String bssid;
    public String mvt;
    public String mvu;
    public long mvv;
    public String mvw;
    public long mvx;
    public String ssid;
    public String type;
    public long uin;

    private C20780a() {
    }

    /* renamed from: MB */
    public static C20780a m32008MB(String str) {
        AppMethodBeat.m2504i(20682);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", str);
        if (C34189m.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
            AppMethodBeat.m2505o(20682);
            return null;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", str);
        Map z = C5049br.m7595z(str, "sysmsg");
        if (z == null || z.size() == 0) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
            AppMethodBeat.m2505o(20682);
            return null;
        }
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + z.toString());
        if ("freewifi".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
            C20780a c20780a = new C20780a();
            c20780a.type = (String) z.get(".sysmsg.type");
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + c20780a.type);
            if ("schemamsg".equals(c20780a.type)) {
                boolean k = C34189m.m56080k(z, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
                C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=".concat(String.valueOf(k)));
                if (k) {
                    c20780a.uin = C5046bo.getLong((String) z.get(".sysmsg.uin"), 0);
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + c20780a.uin);
                    c20780a.ssid = (String) z.get(".sysmsg.schemamsg.ssid");
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + c20780a.ssid);
                    if (C34189m.isEmpty(c20780a.ssid)) {
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
                        AppMethodBeat.m2505o(20682);
                        return null;
                    }
                    c20780a.bssid = C34189m.m56058Mw((String) z.get(".sysmsg.schemamsg.bssid"));
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + c20780a.bssid);
                    c20780a.mvt = (String) z.get(".sysmsg.schemamsg.mobilemac");
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + c20780a.mvt);
                    if (C34189m.isEmpty(c20780a.mvt)) {
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
                        AppMethodBeat.m2505o(20682);
                        return null;
                    }
                    c20780a.mvu = (String) z.get(".sysmsg.schemamsg.mpappid");
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + c20780a.mvu);
                    c20780a.mvv = C5046bo.getLong((String) z.get(".sysmsg.schemamsg.mpshopid"), 0);
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + c20780a.mvv);
                    c20780a.mvw = (String) z.get(".sysmsg.schemamsg.schemaurl");
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + c20780a.mvw);
                    if (C34189m.isEmpty(c20780a.mvw)) {
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
                        AppMethodBeat.m2505o(20682);
                        return null;
                    }
                    c20780a.mvx = C5046bo.getLong((String) z.get(".sysmsg.schemamsg.expiredseconds"), 0);
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + c20780a.mvx);
                    AppMethodBeat.m2505o(20682);
                    return c20780a;
                }
                C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
                AppMethodBeat.m2505o(20682);
                return null;
            }
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
            AppMethodBeat.m2505o(20682);
            return null;
        }
        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
        AppMethodBeat.m2505o(20682);
        return null;
    }
}
