package com.tencent.mm.plugin.freewifi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class a {
    public String bssid;
    public String mvt;
    public String mvu;
    public long mvv;
    public String mvw;
    public long mvx;
    public String ssid;
    public String type;
    public long uin;

    private a() {
    }

    public static a MB(String str) {
        AppMethodBeat.i(20682);
        ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", str);
        if (m.isEmpty(str)) {
            ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
            AppMethodBeat.o(20682);
            return null;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", str);
        Map z = br.z(str, "sysmsg");
        if (z == null || z.size() == 0) {
            ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
            AppMethodBeat.o(20682);
            return null;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + z.toString());
        if ("freewifi".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
            a aVar = new a();
            aVar.type = (String) z.get(".sysmsg.type");
            ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + aVar.type);
            if ("schemamsg".equals(aVar.type)) {
                boolean k = m.k(z, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
                ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=".concat(String.valueOf(k)));
                if (k) {
                    aVar.uin = bo.getLong((String) z.get(".sysmsg.uin"), 0);
                    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + aVar.uin);
                    aVar.ssid = (String) z.get(".sysmsg.schemamsg.ssid");
                    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + aVar.ssid);
                    if (m.isEmpty(aVar.ssid)) {
                        ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
                        AppMethodBeat.o(20682);
                        return null;
                    }
                    aVar.bssid = m.Mw((String) z.get(".sysmsg.schemamsg.bssid"));
                    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + aVar.bssid);
                    aVar.mvt = (String) z.get(".sysmsg.schemamsg.mobilemac");
                    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + aVar.mvt);
                    if (m.isEmpty(aVar.mvt)) {
                        ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
                        AppMethodBeat.o(20682);
                        return null;
                    }
                    aVar.mvu = (String) z.get(".sysmsg.schemamsg.mpappid");
                    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + aVar.mvu);
                    aVar.mvv = bo.getLong((String) z.get(".sysmsg.schemamsg.mpshopid"), 0);
                    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + aVar.mvv);
                    aVar.mvw = (String) z.get(".sysmsg.schemamsg.schemaurl");
                    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + aVar.mvw);
                    if (m.isEmpty(aVar.mvw)) {
                        ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
                        AppMethodBeat.o(20682);
                        return null;
                    }
                    aVar.mvx = bo.getLong((String) z.get(".sysmsg.schemamsg.expiredseconds"), 0);
                    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + aVar.mvx);
                    AppMethodBeat.o(20682);
                    return aVar;
                }
                ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
                AppMethodBeat.o(20682);
                return null;
            }
            ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
            AppMethodBeat.o(20682);
            return null;
        }
        ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
        AppMethodBeat.o(20682);
        return null;
    }
}
