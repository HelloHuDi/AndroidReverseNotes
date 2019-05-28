package com.tencent.p177mm.plugin.webview.modeltools;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i.C23124a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.protocal.protobuf.C30248yu;
import com.tencent.p177mm.protocal.protobuf.C30249yv;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.k */
public final class C40276k {

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.k$2 */
    static class C229042 implements C9557a {
        C229042() {
        }

        /* renamed from: a */
        public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
            AppMethodBeat.m2504i(7029);
            C4990ab.m7411d("MicroMsg.WebViewReportOnLeaveHelper", "doReport callback errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.m2505o(7029);
        }
    }

    /* renamed from: a */
    public static boolean m69057a(C44786d c44786d, final MMWebView mMWebView) {
        AppMethodBeat.m2504i(7030);
        if (c44786d == null) {
            C4990ab.m7420w("MicroMsg.WebViewReportOnLeaveHelper", "handler is null");
            AppMethodBeat.m2505o(7030);
            return false;
        }
        String url = mMWebView.getUrl();
        if (C5046bo.isNullOrNil(url)) {
            AppMethodBeat.m2505o(7030);
            return false;
        }
        try {
            if (new URL(url).getHost().equals("mp.weixin.qq.com")) {
                C298461 c298461 = new ValueCallback<String>() {

                    /* renamed from: com.tencent.mm.plugin.webview.modeltools.k$1$1 */
                    class C298481 implements Runnable {
                        C298481() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(7026);
                            try {
                                mMWebView.destroy();
                                AppMethodBeat.m2505o(7026);
                            } catch (Exception e) {
                                C4990ab.m7421w("MicroMsg.WebViewReportOnLeaveHelper", "reportOnLeave, ex = %s", e.getMessage());
                                AppMethodBeat.m2505o(7026);
                            }
                        }
                    }

                    public final /* synthetic */ void onReceiveValue(Object obj) {
                        AppMethodBeat.m2504i(7028);
                        final String str = (String) obj;
                        C5004al.m7441d(new C298481());
                        if (!C5046bo.isNullOrNil(str)) {
                            C7305d.xDG.mo10151b(new Runnable() {
                                public final void run() {
                                    String optString;
                                    AppMethodBeat.m2504i(7027);
                                    String str = null;
                                    try {
                                        optString = new JSONObject(str.substring(1, str.length() - 1).replace("\\\"", "\"")).optString("data");
                                    } catch (Exception e) {
                                        C4990ab.m7421w("MicroMsg.WebViewReportOnLeaveHelper", "reportOnLeave, ex = %s", e.getMessage());
                                        optString = str;
                                    }
                                    if (C5046bo.isNullOrNil(optString)) {
                                        C4990ab.m7416i("MicroMsg.WebViewReportOnLeaveHelper", "invalid reportData");
                                        AppMethodBeat.m2505o(7027);
                                        return;
                                    }
                                    C4990ab.m7417i("MicroMsg.WebViewReportOnLeaveHelper", "reportOnLeave reportData size=%d", Integer.valueOf(optString.length()));
                                    C1196a c1196a = new C1196a();
                                    c1196a.fsJ = new C30248yu();
                                    c1196a.fsK = new C30249yv();
                                    c1196a.uri = "/cgi-bin/mmbiz-bin/exitreport";
                                    c1196a.fsI = 1642;
                                    C7472b acD = c1196a.acD();
                                    ((C30248yu) acD.fsG.fsP).wet = optString;
                                    C42146b.m74301a(acD, new C229042());
                                    AppMethodBeat.m2505o(7027);
                                }
                            }, "WebViewReportOnLeaveThread");
                        }
                        AppMethodBeat.m2505o(7028);
                    }
                };
                if (c44786d.ready) {
                    c44786d.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("reportOnLeaveForMP", new HashMap(), c44786d.uFv, c44786d.uFw) + ")", c298461);
                } else {
                    c298461.onReceiveValue(null);
                }
                AppMethodBeat.m2505o(7030);
                return true;
            }
            AppMethodBeat.m2505o(7030);
            return false;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WebViewReportOnLeaveHelper", "create url fail : " + e.getLocalizedMessage());
            AppMethodBeat.m2505o(7030);
            return false;
        }
    }
}
