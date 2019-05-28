package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

public class z extends bd<d> {
    public final String name() {
        return "launch3rdApp";
    }

    public final int biG() {
        return 2;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, final bc.a aVar) {
        AppMethodBeat.i(6325);
        ab.i("MicroMsg.JsApiLaunch3RdApp", "invokeInMM");
        JSONObject AI = c.AI(str);
        if (AI == null) {
            aVar.d("invalid_data", null);
            AppMethodBeat.o(6325);
            return;
        }
        int optInt = AI.optInt("type");
        String optString = AI.optString("appID");
        String optString2;
        if (optInt == 0) {
            optString2 = AI.optString(IssueStorage.COLUMN_EXT_INFO);
            ab.i("MicroMsg.JsApiLaunch3RdApp", "appid:[%s], extinfo:[%s]", optString, optString2);
            if (bo.isNullOrNil(optString)) {
                ab.e("MicroMsg.JsApiLaunch3RdApp", "appid is null or nil");
                aVar.d("fail", null);
                AppMethodBeat.o(6325);
            } else if (com.tencent.mm.plugin.webview.a.a.gkF.u(ah.getContext(), optString)) {
                WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = optString2;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = Build.SDK_INT;
                wXMediaMessage.messageExt = optString2;
                jc jcVar = new jc();
                jcVar.cEj.cEl = wXMediaMessage;
                jcVar.cEj.appId = optString;
                jcVar.cEj.context = context;
                jcVar.cEj.cEm = new aj() {
                    public final void dR(boolean z) {
                        AppMethodBeat.i(6323);
                        aVar.d(null, null);
                        AppMethodBeat.o(6323);
                    }
                };
                com.tencent.mm.sdk.b.a.xxA.m(jcVar);
                AppMethodBeat.o(6325);
            } else {
                ab.e("MicroMsg.JsApiLaunch3RdApp", "app is not installed, appid:[%s]", optString);
                aVar.d("fail", null);
                AppMethodBeat.o(6325);
            }
        } else if (optInt == 1) {
            String optString3 = AI.optString("signature");
            optString = AI.optString(DownloadInfoColumns.PACKAGENAME);
            ab.i("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", optString3, optString, AI.optString("param"));
            if (bo.isNullOrNil(optString3) || bo.isNullOrNil(optString)) {
                ab.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp invalid_args");
                aVar.d("invalid_args", null);
                AppMethodBeat.o(6325);
            } else if (p.u(context, optString)) {
                Signature[] bx = p.bx(context, optString);
                if (!(bx == null || bx[0] == null)) {
                    String x = g.x(bx[0].toByteArray());
                    if (x != null && x.equalsIgnoreCase(optString3)) {
                        optString3 = AI.optString("currentUrl");
                        optString2 = AI.optString("preVerifyAppId");
                        try {
                            Intent launchIntentForPackage = ah.getContext().getPackageManager().getLaunchIntentForPackage(optString);
                            if (launchIntentForPackage != null) {
                                Bundle bundle = new Bundle();
                                p.j(bundle, r3);
                                launchIntentForPackage.putExtras(bundle);
                                launchIntentForPackage.addFlags(268435456);
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("current_page_url", optString3);
                                bundle2.putString("current_page_appid", optString2);
                                com.tencent.mm.pluginsdk.model.app.g.a(context, launchIntentForPackage, null, new aj() {
                                    public final void dR(boolean z) {
                                        AppMethodBeat.i(6324);
                                        aVar.d(null, null);
                                        AppMethodBeat.o(6324);
                                    }
                                }, bundle2);
                                AppMethodBeat.o(6325);
                                return;
                            }
                        } catch (Exception e) {
                            ab.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp getLaunchIntentForPackage, %s", e.getMessage());
                        }
                        aVar.d("fail", null);
                        AppMethodBeat.o(6325);
                        return;
                    }
                }
                ab.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp signature_mismatch");
                aVar.d("signature_mismatch", null);
                AppMethodBeat.o(6325);
            } else {
                ab.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp not_install");
                aVar.d("not_install", null);
                AppMethodBeat.o(6325);
            }
        } else {
            aVar.d("invalid_type", null);
            AppMethodBeat.o(6325);
        }
    }
}
