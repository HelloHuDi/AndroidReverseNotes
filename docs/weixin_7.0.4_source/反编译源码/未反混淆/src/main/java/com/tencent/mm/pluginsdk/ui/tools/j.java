package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class j {

    public interface a {
        void ccH();

        void onSuccess(int i);
    }

    public static void a(final a aVar) {
        AppMethodBeat.i(68489);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(68484);
                try {
                    j.b(aVar);
                    AppMethodBeat.o(68484);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.QQMailUnreadHelper", e, "", new Object[0]);
                    ab.e("MicroMsg.QQMailUnreadHelper", "getUnreadCountAsync exception");
                    AppMethodBeat.o(68484);
                }
            }
        }, "QQMailUnreadHelper");
        AppMethodBeat.o(68489);
    }

    public static void b(final a aVar) {
        AppMethodBeat.i(68490);
        ab.i("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount]");
        String str = (String) g.RP().Ry().get(-1535680990, (Object) "");
        long longValue = new p(bo.h((Integer) g.RP().Ry().get(9, null))).longValue();
        if (bo.isNullOrNil(str) || longValue == 0) {
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1));
            ab.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadEmailCountAndSet: authkey or uin is null]");
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(68485);
                    aVar.ccH();
                    AppMethodBeat.o(68485);
                }
            });
            AppMethodBeat.o(68490);
            return;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://qqmail.weixin.qq.com/cgi-bin/getunreadmailcount?f=xml&appname=qqmail_weixin&charset=utf-8&clientip=0").openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(i.sHCENCODEVIDEOTIMEOUT);
        httpURLConnection.setRequestProperty("Cookie", String.format("skey=%s;uin=o%d;", new Object[]{str, Long.valueOf(longValue)}));
        if (httpURLConnection.getResponseCode() >= 300) {
            httpURLConnection.disconnect();
            ab.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount http 300]");
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(68486);
                    aVar.ccH();
                    AppMethodBeat.o(68486);
                }
            });
            AppMethodBeat.o(68490);
            return;
        }
        int i;
        Map z = br.z(bo.convertStreamToString(httpURLConnection.getInputStream()), "Response");
        if (z == null || bo.getInt((String) z.get(".Response.error.code"), -1) != 0) {
            i = -1;
        } else {
            i = bo.getInt((String) z.get(".Response.result.UnreadCount"), -1);
        }
        if (i < 0) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(68487);
                    aVar.ccH();
                    AppMethodBeat.o(68487);
                }
            });
            AppMethodBeat.o(68490);
            return;
        }
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(i));
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(68488);
                aVar.onSuccess(i);
                AppMethodBeat.o(68488);
            }
        });
        AppMethodBeat.o(68490);
    }
}
