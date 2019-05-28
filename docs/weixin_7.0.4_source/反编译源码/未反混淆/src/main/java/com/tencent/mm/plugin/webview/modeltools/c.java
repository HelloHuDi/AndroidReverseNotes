package com.tencent.mm.plugin.webview.modeltools;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;
import com.tencent.xweb.q;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.Log;

public final class c {
    public static final String uoy = Integer.toString(100028);
    private static ArrayList<String> uoz;

    static {
        AppMethodBeat.i(6925);
        AppMethodBeat.o(6925);
    }

    public static void c(d dVar) {
        Bundle g;
        AppMethodBeat.i(6919);
        try {
            g = dVar.g(24, new Bundle(0));
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.WebView.CookiesCleanup", e, "", new Object[0]);
            g = null;
        }
        if (g == null) {
            ab.i("MicroMsg.WebView.CookiesCleanup", "bundle is null, skip cookies cleanup");
            AppMethodBeat.o(6919);
            return;
        }
        ArrayList stringArrayList = g.getStringArrayList("cookies_cleanup_url_list");
        if (bo.ek(stringArrayList)) {
            ab.i("MicroMsg.WebView.CookiesCleanup", "url list is empty, skip cookies cleanup");
            AppMethodBeat.o(6919);
            return;
        }
        eb(stringArrayList);
        com.tencent.xweb.c.jx(ah.getContext());
        com.tencent.xweb.c.sync();
        ab.i("MicroMsg.WebView.CookiesCleanup", "cleanup cookies end");
        AppMethodBeat.o(6919);
    }

    private static void eb(List<String> list) {
        AppMethodBeat.i(6920);
        b dTR = b.dTR();
        for (String str : list) {
            List list2;
            ab.i("MicroMsg.WebView.CookiesCleanup", "cookies cleanup: url(%s)", str);
            String cookie = dTR.getCookie(str);
            if (bo.isNullOrNil(cookie)) {
                list2 = null;
            } else {
                String[] split = cookie.split(";");
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    split[i] = split[i].trim();
                }
                list2 = new LinkedList();
                for (String str2 : split) {
                    if (!bo.isNullOrNil(str2) && str2.contains("=")) {
                        list2.add(str2.split("=")[0]);
                    }
                }
                if (list2.isEmpty()) {
                    list2 = null;
                }
            }
            a(str, list2, dTR);
        }
        AppMethodBeat.o(6920);
    }

    private static void a(String str, List<String> list, b bVar) {
        AppMethodBeat.i(6921);
        if (!bo.ek(list)) {
            String str2;
            String[] split = Uri.parse(str).getHost().split("\\.");
            if (split.length <= 1) {
                str2 = "";
            } else {
                str2 = split[split.length - 2] + "." + split[split.length - 1];
            }
            ab.d("MicroMsg.WebView.CookiesCleanup", "host(%s)", r2);
            ab.d("MicroMsg.WebView.CookiesCleanup", "domain(%s)", str2);
            for (String str3 : list) {
                if (!bo.isNullOrNil(str3)) {
                    bVar.setCookie(str, str3 + "=");
                    bVar.setCookie(str, str3 + "=;path=/");
                    if (!bo.isNullOrNil(str2)) {
                        bVar.setCookie(str2, str3 + "=;domain=." + str2 + ";path=/");
                    }
                }
            }
        }
        AppMethodBeat.o(6921);
    }

    public static void cYw() {
        AppMethodBeat.i(6922);
        String str = "MicroMsg.WebView.CookiesCleanup";
        String str2 = "clearWebViewData url list size %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(uoz != null ? uoz.size() : 0);
        ab.i(str, str2, objArr);
        if (bo.ek(uoz)) {
            AppMethodBeat.o(6922);
            return;
        }
        if (!bo.ek(uoz)) {
            eb(uoz);
            com.tencent.xweb.c.jx(ah.getContext());
            com.tencent.xweb.c.sync();
            ab.i("MicroMsg.WebView.CookiesCleanup", "clearHostCookies end");
        }
        Iterator it = uoz.iterator();
        while (it.hasNext()) {
            String aeR = aeR((String) it.next());
            q dUk = q.dUk();
            if (dUk.AMK == null) {
                Log.e("WebStorage", "deleteOrigin failed webStg is null, cur core kind is " + WebView.getCurWebType());
            } else {
                dUk.AMK.deleteOrigin(aeR);
            }
        }
        uoz.clear();
        AppMethodBeat.o(6922);
    }

    public static void bF(String str, boolean z) {
        AppMethodBeat.i(6923);
        if (z) {
            if (uoz == null) {
                uoz = new ArrayList();
            }
            if (uoz.contains(str)) {
                AppMethodBeat.o(6923);
                return;
            }
            uoz.add(str);
            AppMethodBeat.o(6923);
            return;
        }
        AppMethodBeat.o(6923);
    }

    private static String aeR(String str) {
        AppMethodBeat.i(6924);
        try {
            URI uri = new URI(str);
            String scheme = uri.getScheme();
            if (bo.isNullOrNil(scheme)) {
                AppMethodBeat.o(6924);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder(scheme);
            stringBuilder.append("://");
            stringBuilder.append(uri.getHost());
            int port = uri.getPort();
            port = (port == -1 || ((scheme.equalsIgnoreCase("http") && port == 80) || (scheme.equalsIgnoreCase("https") && port == JsApiPauseDownloadTask.CTRL_INDEX))) ? 1 : 0;
            if (port == 0) {
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(uri.getPort());
            }
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(6924);
            return stringBuilder2;
        } catch (Exception e) {
            ab.e("MicroMsg.WebView.CookiesCleanup", "getOrigin fail %s", e.getMessage());
            AppMethodBeat.o(6924);
            return null;
        }
    }
}
