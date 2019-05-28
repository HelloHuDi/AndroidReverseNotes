package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.aq.j;
import com.tencent.mm.plugin.webview.model.aq.k;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qqvideo.proxy.api.IUtils;
import java.util.ArrayList;

public final class h extends a implements IUtils {
    public h(WebViewUI webViewUI) {
        super(webViewUI);
    }

    public final void javaUtilLog(int i, String str, String str2) {
        AppMethodBeat.i(7588);
        switch (i) {
            case 2:
                ab.v(str, str2);
                AppMethodBeat.o(7588);
                return;
            case 3:
                ab.d(str, str2);
                AppMethodBeat.o(7588);
                return;
            case 4:
                ab.i(str, str2);
                AppMethodBeat.o(7588);
                return;
            case 5:
                ab.w(str, str2);
                break;
            case 6:
                ab.e(str, str2);
                AppMethodBeat.o(7588);
                return;
        }
        AppMethodBeat.o(7588);
    }

    public final void httpproxyReport(String... strArr) {
        AppMethodBeat.i(7589);
        k cYd = cZv().ulI.cYd();
        if (!(strArr == null || strArr.length == 0)) {
            if (cYd.unk == null) {
                cYd.unk = new ArrayList();
            } else {
                cYd.unk.clear();
            }
            for (Object add : strArr) {
                ab.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", strArr[r0]);
                cYd.unk.add(add);
            }
        }
        k cYd2 = cZv().ulI.cYd();
        d dVar = cZv().icy;
        if (cYd2.unk == null || cYd2.unk.size() == 0 || dVar == null) {
            AppMethodBeat.o(7589);
            return;
        }
        g.a(dVar, 12033, cYd2.unk);
        cYd2.unk.clear();
        AppMethodBeat.o(7589);
    }

    public final void idKeyReport(String str, String str2, String str3) {
        AppMethodBeat.i(7590);
        ab.i("MicroMsg.WebViewUI.UtilsImpl", "idkey report, id = %s, key = %s, value = %s", str, str2, str3);
        if (!(bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3))) {
            com.tencent.mm.plugin.report.service.h.pYm.a((long) bo.getInt(str, 0), (long) bo.getInt(str2, 0), (long) bo.getInt(str3, 0), false);
        }
        AppMethodBeat.o(7590);
    }

    public final void kvReport(String... strArr) {
        AppMethodBeat.i(7591);
        j cYe = cZv().ulI.cYe();
        if (!(strArr == null || strArr.length == 0)) {
            if (cYe.unk == null) {
                cYe.unk = new ArrayList();
            } else {
                cYe.unk.clear();
            }
            for (Object add : strArr) {
                ab.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", strArr[r0]);
                cYe.unk.add(add);
            }
        }
        j cYe2 = cZv().ulI.cYe();
        d dVar = cZv().icy;
        if (cYe2.unk == null || cYe2.unk.size() == 0 || dVar == null) {
            AppMethodBeat.o(7591);
            return;
        }
        g.a(dVar, 12666, cYe2.unk);
        cYe2.unk.clear();
        AppMethodBeat.o(7591);
    }
}
