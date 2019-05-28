package com.tencent.mm.plugin.game.luggage;

import android.net.Uri;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key.a;
import com.tencent.mm.plugin.webview.ui.tools.game.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.xweb.b;
import java.util.Map;
import org.json.JSONObject;

public final class c {

    /* renamed from: com.tencent.mm.plugin.game.luggage.c$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ k mTO;
        final /* synthetic */ String mTQ;

        AnonymousClass2(k kVar, String str) {
            this.mTO = kVar;
            this.mTQ = str;
        }

        public final void run() {
            AppMethodBeat.i(135827);
            this.mTO.a(new com.tencent.luggage.d.c() {
                public final String name() {
                    return "onGetA8KeyUrl";
                }

                public final JSONObject wQ() {
                    AppMethodBeat.i(135826);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", AnonymousClass2.this.mTQ);
                        jSONObject.put("set_cookie", 1);
                    } catch (Exception e) {
                        ab.e("MicroMsg.LuggageGetA8KeyUtil", "onGetA8Key, e:" + e.getMessage());
                    }
                    AppMethodBeat.o(135826);
                    return jSONObject;
                }
            });
            AppMethodBeat.o(135827);
        }
    }

    public static void a(final k kVar, String str, boolean z) {
        AppMethodBeat.i(135828);
        final GameWebPerformanceInfo kU = GameWebPerformanceInfo.kU(str);
        ab.i("MicroMsg.LuggageGetA8KeyUtil", "getA8Key begin, time: %d", Long.valueOf(System.currentTimeMillis()));
        kU.eCh = System.currentTimeMillis();
        LuggageGetA8Key luggageGetA8Key = new LuggageGetA8Key();
        luggageGetA8Key.a(str, new a() {
            public final void NN(String str) {
                AppMethodBeat.i(135824);
                kU.eCh = System.currentTimeMillis();
                g.aD(str, System.currentTimeMillis());
                AppMethodBeat.o(135824);
            }

            public final void e(String str, final String str2, final Map<String, String> map) {
                AppMethodBeat.i(135825);
                ab.i("MicroMsg.LuggageGetA8KeyUtil", "getA8Key end, time: %d", Long.valueOf(System.currentTimeMillis()));
                kU.eCi = System.currentTimeMillis();
                g.aE(str, System.currentTimeMillis());
                l.q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(135823);
                        String str;
                        String anB;
                        String queryParameter;
                        if (map != null) {
                            str = "." + bo.anB(str2);
                            anB = bo.anB(str2);
                            com.tencent.xweb.c.jx(ah.getContext());
                            b dTR = b.dTR();
                            for (String queryParameter2 : map.keySet()) {
                                dTR.setCookie(anB, queryParameter2 + "=" + ((String) map.get(queryParameter2)));
                            }
                            if (!bo.isNullOrNil(str2)) {
                                queryParameter2 = Uri.parse(str2).getQueryParameter("pass_ticket");
                                if (!bo.isNullOrNil(queryParameter2)) {
                                    dTR.setCookie(anB, "pass_ticket=".concat(String.valueOf(queryParameter2)));
                                    dTR.setCookie(str, "pass_ticket=".concat(String.valueOf(queryParameter2)));
                                }
                            }
                            dTR.setCookie(anB, "httponly");
                            dTR.setCookie(str, "httponly");
                            com.tencent.xweb.c.dTT();
                            com.tencent.xweb.c.sync();
                            ab.i("MicroMsg.LuggageGetA8KeyUtil", "cookies:%s", dTR.getCookie(anB));
                        } else {
                            queryParameter2 = str2;
                            str = "." + bo.anB(queryParameter2);
                            anB = bo.anB(queryParameter2);
                            Uri parse = Uri.parse(queryParameter2);
                            String queryParameter3 = parse.getQueryParameter(OpenSDKTool4Assistant.EXTRA_UIN);
                            String queryParameter4 = parse.getQueryParameter("key");
                            queryParameter2 = parse.getQueryParameter("pass_ticket");
                            com.tencent.xweb.c.jx(ah.getContext());
                            b dTR2 = b.dTR();
                            if (!bo.isNullOrNil(queryParameter3)) {
                                dTR2.setCookie(str, "uin=".concat(String.valueOf(queryParameter3)));
                                dTR2.setCookie(anB, "uin=".concat(String.valueOf(queryParameter3)));
                            }
                            if (!bo.isNullOrNil(queryParameter4)) {
                                dTR2.setCookie(str, "key=".concat(String.valueOf(queryParameter4)));
                                dTR2.setCookie(anB, "key=".concat(String.valueOf(queryParameter4)));
                            }
                            if (!bo.isNullOrNil(queryParameter2)) {
                                dTR2.setCookie(str, "pass_ticket=".concat(String.valueOf(queryParameter2)));
                                dTR2.setCookie(anB, "pass_ticket=".concat(String.valueOf(queryParameter2)));
                            }
                            dTR2.setCookie(anB, "httponly");
                            dTR2.setCookie(str, "httponly");
                            com.tencent.xweb.c.dTT();
                            com.tencent.xweb.c.sync();
                            ab.i("MicroMsg.LuggageGetA8KeyUtil", "getUinKeyFromFullUrl, cookies:%s", dTR2.getCookie(anB));
                        }
                        l.q(new AnonymousClass2(kVar, str2));
                        AppMethodBeat.o(135823);
                    }
                });
                AppMethodBeat.o(135825);
            }

            public final void a(int i, String str, int i2, int i3, String str2) {
            }
        });
        if (z) {
            com.tencent.mm.plugin.webview.luggage.permission.b.a(kVar.hashCode(), luggageGetA8Key);
        }
        AppMethodBeat.o(135828);
    }
}
