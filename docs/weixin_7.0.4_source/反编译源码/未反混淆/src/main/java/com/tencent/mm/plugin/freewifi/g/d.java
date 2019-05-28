package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;

public final class d extends j<c> {
    public static final String[] fnj = new String[]{j.a(c.ccO, "FreeWifiInfo"), "CREATE INDEX IF NOT EXISTS freewifi_md5_ssid  on FreeWifiInfo  (  ssidmd5 )"};

    static {
        AppMethodBeat.i(20884);
        AppMethodBeat.o(20884);
    }

    public d(e eVar) {
        super(eVar, c.ccO, "FreeWifiInfo", null);
    }

    public final c MK(String str) {
        AppMethodBeat.i(20880);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            AppMethodBeat.o(20880);
            return null;
        }
        ab.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", "select * from FreeWifiInfo where ssidmd5 = '" + ag.ck(str) + "' and wifiType = 1");
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery == null) {
            ab.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            AppMethodBeat.o(20880);
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.d(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(20880);
            return cVar;
        } else {
            rawQuery.close();
            AppMethodBeat.o(20880);
            return null;
        }
    }

    public final c ML(String str) {
        AppMethodBeat.i(20881);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            AppMethodBeat.o(20881);
            return null;
        }
        ab.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", "select * from FreeWifiInfo where ssidmd5 = '" + ag.ck(str) + "'");
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery == null) {
            ab.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            AppMethodBeat.o(20881);
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.d(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(20881);
            return cVar;
        } else {
            rawQuery.close();
            AppMethodBeat.o(20881);
            return null;
        }
    }

    public final c bzx() {
        AppMethodBeat.i(20882);
        ab.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getLastConnectSuccessWifiInfo, sql : %s", "select * from FreeWifiInfo where connectState = 2");
        Cursor rawQuery = rawQuery("select * from FreeWifiInfo where connectState = 2", new String[0]);
        if (rawQuery == null) {
            ab.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "no connected sucess wifi info");
            AppMethodBeat.o(20882);
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.d(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(20882);
            return cVar;
        } else {
            rawQuery.close();
            AppMethodBeat.o(20882);
            return null;
        }
    }

    public final void MM(String str) {
        AppMethodBeat.i(20883);
        ab.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "updateOtherAp : %s", "update FreeWifiInfo set connectState = -1 where ssidmd5 !='" + ag.ck(str) + "'");
        boolean hY = hY("FreeWifiInfo", r0);
        ab.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "update other ap  ret = %b", Boolean.valueOf(hY));
        AppMethodBeat.o(20883);
    }
}
