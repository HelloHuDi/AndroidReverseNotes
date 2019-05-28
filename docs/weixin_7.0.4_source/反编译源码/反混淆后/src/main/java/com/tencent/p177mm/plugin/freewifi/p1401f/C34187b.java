package com.tencent.p177mm.plugin.freewifi.p1401f;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.freewifi.C11963i.C11964a;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.p416d.C45950e;
import com.tencent.p177mm.plugin.freewifi.p417g.C34188e;
import com.tencent.p177mm.plugin.freewifi.p417g.C39110f;
import com.tencent.p177mm.protocal.protobuf.acl;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.freewifi.f.b */
public final class C34187b {
    private static volatile boolean mxG = true;
    static Pattern mxH = Pattern.compile("\"result\":(-?[0-9]+)");
    static Pattern mxI = Pattern.compile("\"stageName\":\"(.+?)\"");

    static {
        AppMethodBeat.m2504i(20872);
        AppMethodBeat.m2505o(20872);
    }

    /* renamed from: kT */
    public static void m56054kT(final int i) {
        AppMethodBeat.m2504i(20870);
        C11976j.bza().byI().post(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.freewifi.f.b$1$1 */
            class C280811 implements C1202f {
                C280811() {
                }

                public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(20868);
                    try {
                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiServerReporter", "errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (C34189m.m56074eg(i, i2)) {
                            LinkedList bzl = ((C45950e) c1207m).bzl();
                            if (bzl != null && bzl.size() > 0) {
                                C39110f byY = C11976j.byY();
                                Iterator it = bzl.iterator();
                                while (it.hasNext()) {
                                    acl acl = (acl) it.next();
                                    String str2 = acl.f17913id;
                                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiServerReporter", "resp LinkedList<FreeWifiReport>. id=%s, errcode=%d", str2, Integer.valueOf(acl.cyE));
                                    if (!C34189m.isEmpty(str2) && r0 == 0) {
                                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiLogStorage", "delete. id=%s", str2);
                                        C34188e c34188e = new C34188e();
                                        c34188e.field_id = str2;
                                        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiLogStorage", "delete ret".concat(String.valueOf(byY.mo16760a((C4925c) c34188e, new String[0]))));
                                    }
                                }
                            }
                        }
                        C34187b.mxG = true;
                        AppMethodBeat.m2505o(20868);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiServerReporter", C34189m.m56078h(e));
                        C34187b.mxG = true;
                        AppMethodBeat.m2505o(20868);
                    } catch (Throwable th) {
                        C34187b.mxG = true;
                        AppMethodBeat.m2505o(20868);
                        throw th;
                    }
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(20869);
                if (C34187b.mxG) {
                    if (i == 0) {
                        long currentTimeMillis = System.currentTimeMillis() - C11964a.mtZ.mo23808lb("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS");
                        C4990ab.m7418v("MicroMsg.FreeWifi.FreeWifiServerReporter", "mobile netowrk report interval between last time is : ".concat(String.valueOf(currentTimeMillis)));
                        if (currentTimeMillis < 0 || currentTimeMillis > 86400000) {
                            C11964a.mtZ.mo23805F("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS", System.currentTimeMillis());
                        } else {
                            C4990ab.m7418v("MicroMsg.FreeWifi.FreeWifiServerReporter", "interval less than 24 hours. return.");
                            AppMethodBeat.m2505o(20869);
                            return;
                        }
                    }
                    C34187b.mxG = false;
                    C39110f byY = C11976j.byY();
                    C34189m.m56069a("FreeWifiLog", C39110f.mxM, byY, "MicroMsg.FreeWifi.FreeWifiLogStorage");
                    Cursor rawQuery = byY.rawQuery("select id, protocolNumber, logContent, createTime from FreeWifiLog", new String[0]);
                    LinkedList linkedList = new LinkedList();
                    while (rawQuery != null && rawQuery.moveToNext()) {
                        acl acl = new acl();
                        acl.f17913id = rawQuery.getString(0);
                        acl.mwG = rawQuery.getInt(1);
                        acl.wkh = rawQuery.getString(2);
                        acl.wki = rawQuery.getLong(3);
                        linkedList.add(acl);
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    String str = "ServerReportSimpleLog:" + C34187b.m56053U(linkedList);
                    C34189m.m56056MA(str);
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiServerReporter", str);
                    if (linkedList.size() > 0) {
                        new C45950e(linkedList).mo68619c(new C280811());
                        AppMethodBeat.m2505o(20869);
                        return;
                    }
                    C34187b.mxG = true;
                    AppMethodBeat.m2505o(20869);
                    return;
                }
                AppMethodBeat.m2505o(20869);
            }
        });
        AppMethodBeat.m2505o(20870);
    }

    /* renamed from: U */
    static String m56053U(LinkedList<acl> linkedList) {
        AppMethodBeat.m2504i(20871);
        String str;
        if (linkedList.size() == 0) {
            str = "";
            AppMethodBeat.m2505o(20871);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            acl acl = (acl) it.next();
            stringBuilder.append("|id=").append(C34189m.m56058Mw(acl.f17913id)).append("|");
            for (CharSequence charSequence : C34189m.m56058Mw(acl.wkh).split("\\},")) {
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
                stringBuilder.append(C11966k.m19854Mu(str) + "=" + str2).append("|");
            }
        }
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(20871);
        return str;
    }
}
