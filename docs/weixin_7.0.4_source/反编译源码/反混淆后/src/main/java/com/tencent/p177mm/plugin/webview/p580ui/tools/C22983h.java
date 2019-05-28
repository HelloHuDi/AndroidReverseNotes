package com.tencent.p177mm.plugin.webview.p580ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C22885j;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C40260k;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.qqvideo.proxy.api.IUtils;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.h */
public final class C22983h extends C35640a implements IUtils {
    public C22983h(WebViewUI webViewUI) {
        super(webViewUI);
    }

    public final void javaUtilLog(int i, String str, String str2) {
        AppMethodBeat.m2504i(7588);
        switch (i) {
            case 2:
                C4990ab.m7418v(str, str2);
                AppMethodBeat.m2505o(7588);
                return;
            case 3:
                C4990ab.m7410d(str, str2);
                AppMethodBeat.m2505o(7588);
                return;
            case 4:
                C4990ab.m7416i(str, str2);
                AppMethodBeat.m2505o(7588);
                return;
            case 5:
                C4990ab.m7420w(str, str2);
                break;
            case 6:
                C4990ab.m7412e(str, str2);
                AppMethodBeat.m2505o(7588);
                return;
        }
        AppMethodBeat.m2505o(7588);
    }

    public final void httpproxyReport(String... strArr) {
        AppMethodBeat.m2504i(7589);
        C40260k cYd = cZv().ulI.cYd();
        if (!(strArr == null || strArr.length == 0)) {
            if (cYd.unk == null) {
                cYd.unk = new ArrayList();
            } else {
                cYd.unk.clear();
            }
            for (Object add : strArr) {
                C4990ab.m7417i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", strArr[r0]);
                cYd.unk.add(add);
            }
        }
        C40260k cYd2 = cZv().ulI.cYd();
        C46434d c46434d = cZv().icy;
        if (cYd2.unk == null || cYd2.unk.size() == 0 || c46434d == null) {
            AppMethodBeat.m2505o(7589);
            return;
        }
        C29916g.m47391a(c46434d, 12033, cYd2.unk);
        cYd2.unk.clear();
        AppMethodBeat.m2505o(7589);
    }

    public final void idKeyReport(String str, String str2, String str3) {
        AppMethodBeat.m2504i(7590);
        C4990ab.m7417i("MicroMsg.WebViewUI.UtilsImpl", "idkey report, id = %s, key = %s, value = %s", str, str2, str3);
        if (!(C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3))) {
            C7060h.pYm.mo8378a((long) C5046bo.getInt(str, 0), (long) C5046bo.getInt(str2, 0), (long) C5046bo.getInt(str3, 0), false);
        }
        AppMethodBeat.m2505o(7590);
    }

    public final void kvReport(String... strArr) {
        AppMethodBeat.m2504i(7591);
        C22885j cYe = cZv().ulI.cYe();
        if (!(strArr == null || strArr.length == 0)) {
            if (cYe.unk == null) {
                cYe.unk = new ArrayList();
            } else {
                cYe.unk.clear();
            }
            for (Object add : strArr) {
                C4990ab.m7417i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", strArr[r0]);
                cYe.unk.add(add);
            }
        }
        C22885j cYe2 = cZv().ulI.cYe();
        C46434d c46434d = cZv().icy;
        if (cYe2.unk == null || cYe2.unk.size() == 0 || c46434d == null) {
            AppMethodBeat.m2505o(7591);
            return;
        }
        C29916g.m47391a(c46434d, 12666, cYe2.unk);
        cYe2.unk.clear();
        AppMethodBeat.m2505o(7591);
    }
}
