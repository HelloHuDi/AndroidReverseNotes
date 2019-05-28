package com.tencent.mm.plugin.webview.modeltools;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.protocal.protobuf.yu;
import com.tencent.mm.protocal.protobuf.yv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

public final class k {
    public static boolean a(d dVar, final MMWebView mMWebView) {
        AppMethodBeat.i(7030);
        if (dVar == null) {
            ab.w("MicroMsg.WebViewReportOnLeaveHelper", "handler is null");
            AppMethodBeat.o(7030);
            return false;
        }
        String url = mMWebView.getUrl();
        if (bo.isNullOrNil(url)) {
            AppMethodBeat.o(7030);
            return false;
        }
        try {
            if (new URL(url).getHost().equals("mp.weixin.qq.com")) {
                AnonymousClass1 anonymousClass1 = new ValueCallback<String>() {
                    public final /* synthetic */ void onReceiveValue(Object obj) {
                        AppMethodBeat.i(7028);
                        final String str = (String) obj;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(7026);
                                try {
                                    mMWebView.destroy();
                                    AppMethodBeat.o(7026);
                                } catch (Exception e) {
                                    ab.w("MicroMsg.WebViewReportOnLeaveHelper", "reportOnLeave, ex = %s", e.getMessage());
                                    AppMethodBeat.o(7026);
                                }
                            }
                        });
                        if (!bo.isNullOrNil(str)) {
                            com.tencent.mm.sdk.g.d.xDG.b(new Runnable() {
                                public final void run() {
                                    String optString;
                                    AppMethodBeat.i(7027);
                                    String str = null;
                                    try {
                                        optString = new JSONObject(str.substring(1, str.length() - 1).replace("\\\"", "\"")).optString("data");
                                    } catch (Exception e) {
                                        ab.w("MicroMsg.WebViewReportOnLeaveHelper", "reportOnLeave, ex = %s", e.getMessage());
                                        optString = str;
                                    }
                                    if (bo.isNullOrNil(optString)) {
                                        ab.i("MicroMsg.WebViewReportOnLeaveHelper", "invalid reportData");
                                        AppMethodBeat.o(7027);
                                        return;
                                    }
                                    ab.i("MicroMsg.WebViewReportOnLeaveHelper", "reportOnLeave reportData size=%d", Integer.valueOf(optString.length()));
                                    a aVar = new a();
                                    aVar.fsJ = new yu();
                                    aVar.fsK = new yv();
                                    aVar.uri = "/cgi-bin/mmbiz-bin/exitreport";
                                    aVar.fsI = 1642;
                                    b acD = aVar.acD();
                                    ((yu) acD.fsG.fsP).wet = optString;
                                    com.tencent.mm.ipcinvoker.wx_extension.b.a(acD, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                                        public final void a(int i, int i2, String str, b bVar) {
                                            AppMethodBeat.i(7029);
                                            ab.d("MicroMsg.WebViewReportOnLeaveHelper", "doReport callback errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                                            AppMethodBeat.o(7029);
                                        }
                                    });
                                    AppMethodBeat.o(7027);
                                }
                            }, "WebViewReportOnLeaveThread");
                        }
                        AppMethodBeat.o(7028);
                    }
                };
                if (dVar.ready) {
                    dVar.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("reportOnLeaveForMP", new HashMap(), dVar.uFv, dVar.uFw) + ")", anonymousClass1);
                } else {
                    anonymousClass1.onReceiveValue(null);
                }
                AppMethodBeat.o(7030);
                return true;
            }
            AppMethodBeat.o(7030);
            return false;
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewReportOnLeaveHelper", "create url fail : " + e.getLocalizedMessage());
            AppMethodBeat.o(7030);
            return false;
        }
    }
}
