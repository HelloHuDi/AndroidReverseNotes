package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C32579jc;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C29782c;
import com.tencent.p177mm.plugin.webview.p1562a.C40211a;
import com.tencent.p177mm.pluginsdk.model.app.C14875aj;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.z */
public class C22854z extends C46419bd<C24905d> {
    public final String name() {
        return "launch3rdApp";
    }

    public final int biG() {
        return 2;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, final C22841a c22841a) {
        AppMethodBeat.m2504i(6325);
        C4990ab.m7416i("MicroMsg.JsApiLaunch3RdApp", "invokeInMM");
        JSONObject AI = C29782c.m47225AI(str);
        if (AI == null) {
            c22841a.mo26722d("invalid_data", null);
            AppMethodBeat.m2505o(6325);
            return;
        }
        int optInt = AI.optInt("type");
        String optString = AI.optString("appID");
        String optString2;
        if (optInt == 0) {
            optString2 = AI.optString(IssueStorage.COLUMN_EXT_INFO);
            C4990ab.m7417i("MicroMsg.JsApiLaunch3RdApp", "appid:[%s], extinfo:[%s]", optString, optString2);
            if (C5046bo.isNullOrNil(optString)) {
                C4990ab.m7412e("MicroMsg.JsApiLaunch3RdApp", "appid is null or nil");
                c22841a.mo26722d("fail", null);
                AppMethodBeat.m2505o(6325);
            } else if (C40211a.gkF.mo38874u(C4996ah.getContext(), optString)) {
                WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = optString2;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = Build.SDK_INT;
                wXMediaMessage.messageExt = optString2;
                C32579jc c32579jc = new C32579jc();
                c32579jc.cEj.cEl = wXMediaMessage;
                c32579jc.cEj.appId = optString;
                c32579jc.cEj.context = context;
                c32579jc.cEj.cEm = new C14875aj() {
                    /* renamed from: dR */
                    public final void mo6036dR(boolean z) {
                        AppMethodBeat.m2504i(6323);
                        c22841a.mo26722d(null, null);
                        AppMethodBeat.m2505o(6323);
                    }
                };
                C4879a.xxA.mo10055m(c32579jc);
                AppMethodBeat.m2505o(6325);
            } else {
                C4990ab.m7413e("MicroMsg.JsApiLaunch3RdApp", "app is not installed, appid:[%s]", optString);
                c22841a.mo26722d("fail", null);
                AppMethodBeat.m2505o(6325);
            }
        } else if (optInt == 1) {
            String optString3 = AI.optString("signature");
            optString = AI.optString(DownloadInfoColumns.PACKAGENAME);
            C4990ab.m7417i("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", optString3, optString, AI.optString("param"));
            if (C5046bo.isNullOrNil(optString3) || C5046bo.isNullOrNil(optString)) {
                C4990ab.m7412e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp invalid_args");
                c22841a.mo26722d("invalid_args", null);
                AppMethodBeat.m2505o(6325);
            } else if (C35799p.m58695u(context, optString)) {
                Signature[] bx = C35799p.m58691bx(context, optString);
                if (!(bx == null || bx[0] == null)) {
                    String x = C1178g.m2591x(bx[0].toByteArray());
                    if (x != null && x.equalsIgnoreCase(optString3)) {
                        optString3 = AI.optString("currentUrl");
                        optString2 = AI.optString("preVerifyAppId");
                        try {
                            Intent launchIntentForPackage = C4996ah.getContext().getPackageManager().getLaunchIntentForPackage(optString);
                            if (launchIntentForPackage != null) {
                                Bundle bundle = new Bundle();
                                C35799p.m58694j(bundle, r3);
                                launchIntentForPackage.putExtras(bundle);
                                launchIntentForPackage.addFlags(268435456);
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("current_page_url", optString3);
                                bundle2.putString("current_page_appid", optString2);
                                C46494g.m87725a(context, launchIntentForPackage, null, new C14875aj() {
                                    /* renamed from: dR */
                                    public final void mo6036dR(boolean z) {
                                        AppMethodBeat.m2504i(6324);
                                        c22841a.mo26722d(null, null);
                                        AppMethodBeat.m2505o(6324);
                                    }
                                }, bundle2);
                                AppMethodBeat.m2505o(6325);
                                return;
                            }
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp getLaunchIntentForPackage, %s", e.getMessage());
                        }
                        c22841a.mo26722d("fail", null);
                        AppMethodBeat.m2505o(6325);
                        return;
                    }
                }
                C4990ab.m7412e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp signature_mismatch");
                c22841a.mo26722d("signature_mismatch", null);
                AppMethodBeat.m2505o(6325);
            } else {
                C4990ab.m7412e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp not_install");
                c22841a.mo26722d("not_install", null);
                AppMethodBeat.m2505o(6325);
            }
        } else {
            c22841a.mo26722d("invalid_type", null);
            AppMethodBeat.m2505o(6325);
        }
    }
}
