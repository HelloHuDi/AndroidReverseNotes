package com.tencent.p177mm.plugin.game.luggage;

import android.net.Uri;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.luggage.p146d.C32186k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.plugin.webview.luggage.permission.C40250b;
import com.tencent.p177mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.p177mm.plugin.webview.luggage.permission.LuggageGetA8Key.C22870a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C43963g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.xweb.C24526c;
import com.tencent.xweb.C44576b;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.c */
public final class C12134c {

    /* renamed from: com.tencent.mm.plugin.game.luggage.c$2 */
    static class C121352 implements Runnable {
        final /* synthetic */ C32186k mTO;
        final /* synthetic */ String mTQ;

        /* renamed from: com.tencent.mm.plugin.game.luggage.c$2$1 */
        class C121361 extends C17817c {
            C121361() {
            }

            public final String name() {
                return "onGetA8KeyUrl";
            }

            /* renamed from: wQ */
            public final JSONObject mo7075wQ() {
                AppMethodBeat.m2504i(135826);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", C121352.this.mTQ);
                    jSONObject.put("set_cookie", 1);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.LuggageGetA8KeyUtil", "onGetA8Key, e:" + e.getMessage());
                }
                AppMethodBeat.m2505o(135826);
                return jSONObject;
            }
        }

        C121352(C32186k c32186k, String str) {
            this.mTO = c32186k;
            this.mTQ = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(135827);
            this.mTO.mo52826a(new C121361());
            AppMethodBeat.m2505o(135827);
        }
    }

    /* renamed from: a */
    public static void m20060a(final C32186k c32186k, String str, boolean z) {
        AppMethodBeat.m2504i(135828);
        final GameWebPerformanceInfo kU = GameWebPerformanceInfo.m63878kU(str);
        C4990ab.m7417i("MicroMsg.LuggageGetA8KeyUtil", "getA8Key begin, time: %d", Long.valueOf(System.currentTimeMillis()));
        kU.eCh = System.currentTimeMillis();
        LuggageGetA8Key luggageGetA8Key = new LuggageGetA8Key();
        luggageGetA8Key.mo74634a(str, new C22870a() {
            /* renamed from: NN */
            public final void mo23958NN(String str) {
                AppMethodBeat.m2504i(135824);
                kU.eCh = System.currentTimeMillis();
                C43963g.m78901aD(str, System.currentTimeMillis());
                AppMethodBeat.m2505o(135824);
            }

            /* renamed from: e */
            public final void mo23960e(String str, final String str2, final Map<String, String> map) {
                AppMethodBeat.m2504i(135825);
                C4990ab.m7417i("MicroMsg.LuggageGetA8KeyUtil", "getA8Key end, time: %d", Long.valueOf(System.currentTimeMillis()));
                kU.eCi = System.currentTimeMillis();
                C43963g.m78902aE(str, System.currentTimeMillis());
                C18514l.m28819q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(135823);
                        String str;
                        String anB;
                        String queryParameter;
                        if (map != null) {
                            str = "." + C5046bo.anB(str2);
                            anB = C5046bo.anB(str2);
                            C24526c.m38159jx(C4996ah.getContext());
                            C44576b dTR = C44576b.dTR();
                            for (String queryParameter2 : map.keySet()) {
                                dTR.setCookie(anB, queryParameter2 + "=" + ((String) map.get(queryParameter2)));
                            }
                            if (!C5046bo.isNullOrNil(str2)) {
                                queryParameter2 = Uri.parse(str2).getQueryParameter("pass_ticket");
                                if (!C5046bo.isNullOrNil(queryParameter2)) {
                                    dTR.setCookie(anB, "pass_ticket=".concat(String.valueOf(queryParameter2)));
                                    dTR.setCookie(str, "pass_ticket=".concat(String.valueOf(queryParameter2)));
                                }
                            }
                            dTR.setCookie(anB, "httponly");
                            dTR.setCookie(str, "httponly");
                            C24526c.dTT();
                            C24526c.sync();
                            C4990ab.m7417i("MicroMsg.LuggageGetA8KeyUtil", "cookies:%s", dTR.getCookie(anB));
                        } else {
                            queryParameter2 = str2;
                            str = "." + C5046bo.anB(queryParameter2);
                            anB = C5046bo.anB(queryParameter2);
                            Uri parse = Uri.parse(queryParameter2);
                            String queryParameter3 = parse.getQueryParameter(OpenSDKTool4Assistant.EXTRA_UIN);
                            String queryParameter4 = parse.getQueryParameter("key");
                            queryParameter2 = parse.getQueryParameter("pass_ticket");
                            C24526c.m38159jx(C4996ah.getContext());
                            C44576b dTR2 = C44576b.dTR();
                            if (!C5046bo.isNullOrNil(queryParameter3)) {
                                dTR2.setCookie(str, "uin=".concat(String.valueOf(queryParameter3)));
                                dTR2.setCookie(anB, "uin=".concat(String.valueOf(queryParameter3)));
                            }
                            if (!C5046bo.isNullOrNil(queryParameter4)) {
                                dTR2.setCookie(str, "key=".concat(String.valueOf(queryParameter4)));
                                dTR2.setCookie(anB, "key=".concat(String.valueOf(queryParameter4)));
                            }
                            if (!C5046bo.isNullOrNil(queryParameter2)) {
                                dTR2.setCookie(str, "pass_ticket=".concat(String.valueOf(queryParameter2)));
                                dTR2.setCookie(anB, "pass_ticket=".concat(String.valueOf(queryParameter2)));
                            }
                            dTR2.setCookie(anB, "httponly");
                            dTR2.setCookie(str, "httponly");
                            C24526c.dTT();
                            C24526c.sync();
                            C4990ab.m7417i("MicroMsg.LuggageGetA8KeyUtil", "getUinKeyFromFullUrl, cookies:%s", dTR2.getCookie(anB));
                        }
                        C18514l.m28819q(new C121352(c32186k, str2));
                        AppMethodBeat.m2505o(135823);
                    }
                });
                AppMethodBeat.m2505o(135825);
            }

            /* renamed from: a */
            public final void mo23959a(int i, String str, int i2, int i3, String str2) {
            }
        });
        if (z) {
            C40250b.m69031a(c32186k.hashCode(), luggageGetA8Key);
        }
        AppMethodBeat.m2505o(135828);
    }
}
