package com.tencent.p177mm.pluginsdk.p597ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.j */
public final class C46509j {

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.j$a */
    public interface C35896a {
        void ccH();

        void onSuccess(int i);
    }

    /* renamed from: a */
    public static void m87799a(final C35896a c35896a) {
        AppMethodBeat.m2504i(68489);
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(68484);
                try {
                    C46509j.m87800b(c35896a);
                    AppMethodBeat.m2505o(68484);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.QQMailUnreadHelper", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.QQMailUnreadHelper", "getUnreadCountAsync exception");
                    AppMethodBeat.m2505o(68484);
                }
            }
        }, "QQMailUnreadHelper");
        AppMethodBeat.m2505o(68489);
    }

    /* renamed from: b */
    public static void m87800b(final C35896a c35896a) {
        AppMethodBeat.m2504i(68490);
        C4990ab.m7416i("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount]");
        String str = (String) C1720g.m3536RP().mo5239Ry().get(-1535680990, (Object) "");
        long longValue = new C1183p(C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(9, null))).longValue();
        if (C5046bo.isNullOrNil(str) || longValue == 0) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1));
            C4990ab.m7420w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadEmailCountAndSet: authkey or uin is null]");
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(68485);
                    c35896a.ccH();
                    AppMethodBeat.m2505o(68485);
                }
            });
            AppMethodBeat.m2505o(68490);
            return;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://qqmail.weixin.qq.com/cgi-bin/getunreadmailcount?f=xml&appname=qqmail_weixin&charset=utf-8&clientip=0").openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
        httpURLConnection.setRequestProperty("Cookie", String.format("skey=%s;uin=o%d;", new Object[]{str, Long.valueOf(longValue)}));
        if (httpURLConnection.getResponseCode() >= 300) {
            httpURLConnection.disconnect();
            C4990ab.m7420w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount http 300]");
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(68486);
                    c35896a.ccH();
                    AppMethodBeat.m2505o(68486);
                }
            });
            AppMethodBeat.m2505o(68490);
            return;
        }
        int i;
        Map z = C5049br.m7595z(C5046bo.convertStreamToString(httpURLConnection.getInputStream()), "Response");
        if (z == null || C5046bo.getInt((String) z.get(".Response.error.code"), -1) != 0) {
            i = -1;
        } else {
            i = C5046bo.getInt((String) z.get(".Response.result.UnreadCount"), -1);
        }
        if (i < 0) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(68487);
                    c35896a.ccH();
                    AppMethodBeat.m2505o(68487);
                }
            });
            AppMethodBeat.m2505o(68490);
            return;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(i));
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(68488);
                c35896a.onSuccess(i);
                AppMethodBeat.m2505o(68488);
            }
        });
        AppMethodBeat.m2505o(68490);
    }
}
