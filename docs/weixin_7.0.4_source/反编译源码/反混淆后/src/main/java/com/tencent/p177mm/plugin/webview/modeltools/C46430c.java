package com.tencent.p177mm.plugin.webview.modeltools;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.C24526c;
import com.tencent.xweb.C36590q;
import com.tencent.xweb.C44576b;
import com.tencent.xweb.WebView;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.c */
public final class C46430c {
    public static final String uoy = Integer.toString(100028);
    private static ArrayList<String> uoz;

    static {
        AppMethodBeat.m2504i(6925);
        AppMethodBeat.m2505o(6925);
    }

    /* renamed from: c */
    public static void m87451c(C46434d c46434d) {
        Bundle g;
        AppMethodBeat.m2504i(6919);
        try {
            g = c46434d.mo15575g(24, new Bundle(0));
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.WebView.CookiesCleanup", e, "", new Object[0]);
            g = null;
        }
        if (g == null) {
            C4990ab.m7416i("MicroMsg.WebView.CookiesCleanup", "bundle is null, skip cookies cleanup");
            AppMethodBeat.m2505o(6919);
            return;
        }
        ArrayList stringArrayList = g.getStringArrayList("cookies_cleanup_url_list");
        if (C5046bo.m7548ek(stringArrayList)) {
            C4990ab.m7416i("MicroMsg.WebView.CookiesCleanup", "url list is empty, skip cookies cleanup");
            AppMethodBeat.m2505o(6919);
            return;
        }
        C46430c.m87452eb(stringArrayList);
        C24526c.m38159jx(C4996ah.getContext());
        C24526c.sync();
        C4990ab.m7416i("MicroMsg.WebView.CookiesCleanup", "cleanup cookies end");
        AppMethodBeat.m2505o(6919);
    }

    /* renamed from: eb */
    private static void m87452eb(List<String> list) {
        AppMethodBeat.m2504i(6920);
        C44576b dTR = C44576b.dTR();
        for (String str : list) {
            List list2;
            C4990ab.m7417i("MicroMsg.WebView.CookiesCleanup", "cookies cleanup: url(%s)", str);
            String cookie = dTR.getCookie(str);
            if (C5046bo.isNullOrNil(cookie)) {
                list2 = null;
            } else {
                String[] split = cookie.split(";");
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    split[i] = split[i].trim();
                }
                list2 = new LinkedList();
                for (String str2 : split) {
                    if (!C5046bo.isNullOrNil(str2) && str2.contains("=")) {
                        list2.add(str2.split("=")[0]);
                    }
                }
                if (list2.isEmpty()) {
                    list2 = null;
                }
            }
            C46430c.m87449a(str, list2, dTR);
        }
        AppMethodBeat.m2505o(6920);
    }

    /* renamed from: a */
    private static void m87449a(String str, List<String> list, C44576b c44576b) {
        AppMethodBeat.m2504i(6921);
        if (!C5046bo.m7548ek(list)) {
            String str2;
            String[] split = Uri.parse(str).getHost().split("\\.");
            if (split.length <= 1) {
                str2 = "";
            } else {
                str2 = split[split.length - 2] + "." + split[split.length - 1];
            }
            C4990ab.m7411d("MicroMsg.WebView.CookiesCleanup", "host(%s)", r2);
            C4990ab.m7411d("MicroMsg.WebView.CookiesCleanup", "domain(%s)", str2);
            for (String str3 : list) {
                if (!C5046bo.isNullOrNil(str3)) {
                    c44576b.setCookie(str, str3 + "=");
                    c44576b.setCookie(str, str3 + "=;path=/");
                    if (!C5046bo.isNullOrNil(str2)) {
                        c44576b.setCookie(str2, str3 + "=;domain=." + str2 + ";path=/");
                    }
                }
            }
        }
        AppMethodBeat.m2505o(6921);
    }

    public static void cYw() {
        AppMethodBeat.m2504i(6922);
        String str = "MicroMsg.WebView.CookiesCleanup";
        String str2 = "clearWebViewData url list size %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(uoz != null ? uoz.size() : 0);
        C4990ab.m7417i(str, str2, objArr);
        if (C5046bo.m7548ek(uoz)) {
            AppMethodBeat.m2505o(6922);
            return;
        }
        if (!C5046bo.m7548ek(uoz)) {
            C46430c.m87452eb(uoz);
            C24526c.m38159jx(C4996ah.getContext());
            C24526c.sync();
            C4990ab.m7416i("MicroMsg.WebView.CookiesCleanup", "clearHostCookies end");
        }
        Iterator it = uoz.iterator();
        while (it.hasNext()) {
            String aeR = C46430c.aeR((String) it.next());
            C36590q dUk = C36590q.dUk();
            if (dUk.AMK == null) {
                Log.m81046e("WebStorage", "deleteOrigin failed webStg is null, cur core kind is " + WebView.getCurWebType());
            } else {
                dUk.AMK.deleteOrigin(aeR);
            }
        }
        uoz.clear();
        AppMethodBeat.m2505o(6922);
    }

    /* renamed from: bF */
    public static void m87450bF(String str, boolean z) {
        AppMethodBeat.m2504i(6923);
        if (z) {
            if (uoz == null) {
                uoz = new ArrayList();
            }
            if (uoz.contains(str)) {
                AppMethodBeat.m2505o(6923);
                return;
            }
            uoz.add(str);
            AppMethodBeat.m2505o(6923);
            return;
        }
        AppMethodBeat.m2505o(6923);
    }

    private static String aeR(String str) {
        AppMethodBeat.m2504i(6924);
        try {
            URI uri = new URI(str);
            String scheme = uri.getScheme();
            if (C5046bo.isNullOrNil(scheme)) {
                AppMethodBeat.m2505o(6924);
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
            AppMethodBeat.m2505o(6924);
            return stringBuilder2;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebView.CookiesCleanup", "getOrigin fail %s", e.getMessage());
            AppMethodBeat.m2505o(6924);
            return null;
        }
    }
}
