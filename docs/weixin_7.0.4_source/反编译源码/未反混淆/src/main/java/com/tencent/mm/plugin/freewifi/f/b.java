package com.tencent.mm.plugin.freewifi.f;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.e;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {
    private static volatile boolean mxG = true;
    static Pattern mxH = Pattern.compile("\"result\":(-?[0-9]+)");
    static Pattern mxI = Pattern.compile("\"stageName\":\"(.+?)\"");

    static {
        AppMethodBeat.i(20872);
        AppMethodBeat.o(20872);
    }

    public static void kT(final int i) {
        AppMethodBeat.i(20870);
        j.bza().byI().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20869);
                if (b.mxG) {
                    if (i == 0) {
                        long currentTimeMillis = System.currentTimeMillis() - a.mtZ.lb("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS");
                        ab.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "mobile netowrk report interval between last time is : ".concat(String.valueOf(currentTimeMillis)));
                        if (currentTimeMillis < 0 || currentTimeMillis > 86400000) {
                            a.mtZ.F("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS", System.currentTimeMillis());
                        } else {
                            ab.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "interval less than 24 hours. return.");
                            AppMethodBeat.o(20869);
                            return;
                        }
                    }
                    b.mxG = false;
                    f byY = j.byY();
                    m.a("FreeWifiLog", f.mxM, byY, "MicroMsg.FreeWifi.FreeWifiLogStorage");
                    Cursor rawQuery = byY.rawQuery("select id, protocolNumber, logContent, createTime from FreeWifiLog", new String[0]);
                    LinkedList linkedList = new LinkedList();
                    while (rawQuery != null && rawQuery.moveToNext()) {
                        acl acl = new acl();
                        acl.id = rawQuery.getString(0);
                        acl.mwG = rawQuery.getInt(1);
                        acl.wkh = rawQuery.getString(2);
                        acl.wki = rawQuery.getLong(3);
                        linkedList.add(acl);
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    String str = "ServerReportSimpleLog:" + b.U(linkedList);
                    m.MA(str);
                    ab.i("MicroMsg.FreeWifi.FreeWifiServerReporter", str);
                    if (linkedList.size() > 0) {
                        new e(linkedList).c(new com.tencent.mm.ai.f() {
                            public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                                AppMethodBeat.i(20868);
                                try {
                                    ab.i("MicroMsg.FreeWifi.FreeWifiServerReporter", "errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                                    if (m.eg(i, i2)) {
                                        LinkedList bzl = ((e) mVar).bzl();
                                        if (bzl != null && bzl.size() > 0) {
                                            f byY = j.byY();
                                            Iterator it = bzl.iterator();
                                            while (it.hasNext()) {
                                                acl acl = (acl) it.next();
                                                String str2 = acl.id;
                                                ab.i("MicroMsg.FreeWifi.FreeWifiServerReporter", "resp LinkedList<FreeWifiReport>. id=%s, errcode=%d", str2, Integer.valueOf(acl.cyE));
                                                if (!m.isEmpty(str2) && r0 == 0) {
                                                    ab.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "delete. id=%s", str2);
                                                    com.tencent.mm.plugin.freewifi.g.e eVar = new com.tencent.mm.plugin.freewifi.g.e();
                                                    eVar.field_id = str2;
                                                    ab.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "delete ret".concat(String.valueOf(byY.a((c) eVar, new String[0]))));
                                                }
                                            }
                                        }
                                    }
                                    b.mxG = true;
                                    AppMethodBeat.o(20868);
                                } catch (Exception e) {
                                    ab.e("MicroMsg.FreeWifi.FreeWifiServerReporter", m.h(e));
                                    b.mxG = true;
                                    AppMethodBeat.o(20868);
                                } catch (Throwable th) {
                                    b.mxG = true;
                                    AppMethodBeat.o(20868);
                                    throw th;
                                }
                            }
                        });
                        AppMethodBeat.o(20869);
                        return;
                    }
                    b.mxG = true;
                    AppMethodBeat.o(20869);
                    return;
                }
                AppMethodBeat.o(20869);
            }
        });
        AppMethodBeat.o(20870);
    }

    static String U(LinkedList<acl> linkedList) {
        AppMethodBeat.i(20871);
        String str;
        if (linkedList.size() == 0) {
            str = "";
            AppMethodBeat.o(20871);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            acl acl = (acl) it.next();
            stringBuilder.append("|id=").append(m.Mw(acl.id)).append("|");
            for (CharSequence charSequence : m.Mw(acl.wkh).split("\\},")) {
                Matcher matcher = mxI.matcher(charSequence);
                str = "";
                if (matcher.find()) {
                    str = matcher.group(1);
                }
                matcher = mxH.matcher(charSequence);
                String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                if (matcher.find()) {
                    str2 = matcher.group(1);
                }
                stringBuilder.append(k.Mu(str) + "=" + str2).append("|");
            }
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(20871);
        return str;
    }
}
