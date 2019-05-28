package com.tencent.p177mm.plugin.freewifi.p417g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.freewifi.g.d */
public final class C7605d extends C7563j<C3137c> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C3137c.ccO, "FreeWifiInfo"), "CREATE INDEX IF NOT EXISTS freewifi_md5_ssid  on FreeWifiInfo  (  ssidmd5 )"};

    static {
        AppMethodBeat.m2504i(20884);
        AppMethodBeat.m2505o(20884);
    }

    public C7605d(C4927e c4927e) {
        super(c4927e, C3137c.ccO, "FreeWifiInfo", null);
    }

    /* renamed from: MK */
    public final C3137c mo17044MK(String str) {
        AppMethodBeat.m2504i(20880);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            AppMethodBeat.m2505o(20880);
            return null;
        }
        C4990ab.m7411d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", "select * from FreeWifiInfo where ssidmd5 = '" + C4995ag.m7428ck(str) + "' and wifiType = 1");
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery == null) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            AppMethodBeat.m2505o(20880);
            return null;
        } else if (rawQuery.moveToFirst()) {
            C3137c c3137c = new C3137c();
            c3137c.mo8995d(rawQuery);
            rawQuery.close();
            AppMethodBeat.m2505o(20880);
            return c3137c;
        } else {
            rawQuery.close();
            AppMethodBeat.m2505o(20880);
            return null;
        }
    }

    /* renamed from: ML */
    public final C3137c mo17045ML(String str) {
        AppMethodBeat.m2504i(20881);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            AppMethodBeat.m2505o(20881);
            return null;
        }
        C4990ab.m7411d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", "select * from FreeWifiInfo where ssidmd5 = '" + C4995ag.m7428ck(str) + "'");
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery == null) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            AppMethodBeat.m2505o(20881);
            return null;
        } else if (rawQuery.moveToFirst()) {
            C3137c c3137c = new C3137c();
            c3137c.mo8995d(rawQuery);
            rawQuery.close();
            AppMethodBeat.m2505o(20881);
            return c3137c;
        } else {
            rawQuery.close();
            AppMethodBeat.m2505o(20881);
            return null;
        }
    }

    public final C3137c bzx() {
        AppMethodBeat.m2504i(20882);
        C4990ab.m7411d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getLastConnectSuccessWifiInfo, sql : %s", "select * from FreeWifiInfo where connectState = 2");
        Cursor rawQuery = rawQuery("select * from FreeWifiInfo where connectState = 2", new String[0]);
        if (rawQuery == null) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "no connected sucess wifi info");
            AppMethodBeat.m2505o(20882);
            return null;
        } else if (rawQuery.moveToFirst()) {
            C3137c c3137c = new C3137c();
            c3137c.mo8995d(rawQuery);
            rawQuery.close();
            AppMethodBeat.m2505o(20882);
            return c3137c;
        } else {
            rawQuery.close();
            AppMethodBeat.m2505o(20882);
            return null;
        }
    }

    /* renamed from: MM */
    public final void mo17046MM(String str) {
        AppMethodBeat.m2504i(20883);
        C4990ab.m7411d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "updateOtherAp : %s", "update FreeWifiInfo set connectState = -1 where ssidmd5 !='" + C4995ag.m7428ck(str) + "'");
        boolean hY = mo16768hY("FreeWifiInfo", r0);
        C4990ab.m7411d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "update other ap  ret = %b", Boolean.valueOf(hY));
        AppMethodBeat.m2505o(20883);
    }
}
