package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.ak;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public class aa extends bd<d> {
    public final String name() {
        return "launchApplication";
    }

    public final int biG() {
        return 2;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(6329);
        ab.i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
        JSONObject AI = c.AI(str);
        if (AI == null) {
            ab.e("MicroMsg.JsApiLaunchApplication", "data is null");
            aVar.d("fail", null);
            AppMethodBeat.o(6329);
            return;
        }
        final String optString = AI.optString("appID");
        final String optString2 = AI.optString("schemeUrl");
        final String optString3 = AI.optString("parameter");
        int optInt = AI.optInt("alertType");
        final String optString4 = AI.optString(IssueStorage.COLUMN_EXT_INFO);
        ab.i("MicroMsg.JsApiLaunchApplication", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", optString, optString2, optString4, optString3);
        if (bo.isNullOrNil(optString) && bo.isNullOrNil(optString2)) {
            ab.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
            aVar.d("fail", null);
            AppMethodBeat.o(6329);
            return;
        }
        String optString5 = AI.optString("preVerifyAppId");
        String optString6 = AI.optString("currentUrl");
        final Bundle bundle = new Bundle();
        try {
            bundle.putString("current_page_url", URLEncoder.encode(optString6, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }
        bundle.putString("current_page_appid", optString5);
        b.a aVar2 = new b.a();
        aVar2.fsJ = new avj();
        aVar2.fsK = new avk();
        aVar2.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        aVar2.fsI = 1125;
        b acD = aVar2.acD();
        avj avj = (avj) acD.fsG.fsP;
        avj.csB = optString5;
        avj.wzn = optString;
        avj.scene = 0;
        avj.url = optString6;
        avj.wzo = optString2;
        avj.kCo = optInt;
        avj.wzp = 0;
        ab.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", optString5, optString, Integer.valueOf(avj.scene), avj.url, avj.wzo, Integer.valueOf(avj.kCo));
        final bc.a aVar3 = aVar;
        final Context context2 = context;
        w.a(acD, new w.a() {
            public final int a(int i, int i2, String str, b bVar, m mVar) {
                AppMethodBeat.i(6328);
                final int i3 = i;
                final int i4 = i2;
                final String str2 = str;
                final b bVar2 = bVar;
                l.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(6327);
                        ab.d("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str2);
                        if (i3 == 0 && i4 == 0) {
                            avk avk = (avk) bVar2.fsH.fsP;
                            switch (avk.cyE) {
                                case 0:
                                    List H;
                                    Object b;
                                    boolean a;
                                    aj akVar = new ak(new ak.a() {
                                        public final void r(boolean z, boolean z2) {
                                            AppMethodBeat.i(6326);
                                            ab.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                                            if (z) {
                                                aVar3.d(null, null);
                                                AppMethodBeat.o(6326);
                                                return;
                                            }
                                            aVar3.d("fail", null);
                                            AppMethodBeat.o(6326);
                                        }
                                    });
                                    ab.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", Integer.valueOf(avk.wzs), Integer.valueOf(avk.cyE));
                                    if (!bo.isNullOrNil(optString2)) {
                                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
                                        intent.addFlags(268435456);
                                        H = bo.H(context2, intent);
                                        if (!(H == null || H.isEmpty())) {
                                            if (TextUtils.isEmpty(intent.getPackage()) && H.size() == 1) {
                                                b = g.b((ResolveInfo) H.get(0));
                                            } else {
                                                b = intent.getPackage();
                                            }
                                            if (!bo.nullAsNil(ah.getPackageName()).equals(b)) {
                                                akVar.dS(g.a(context2, intent, null, avk.wzs, akVar, bundle));
                                                AppMethodBeat.o(6327);
                                                return;
                                            }
                                        }
                                    }
                                    WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                                    wXAppExtendObject.extInfo = optString4;
                                    WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                                    wXMediaMessage.sdkVer = Build.SDK_INT;
                                    wXMediaMessage.messageExt = optString4;
                                    jc jcVar = new jc();
                                    jcVar.cEj.cEl = wXMediaMessage;
                                    jcVar.cEj.appId = optString;
                                    jcVar.cEj.showType = avk.wzs;
                                    jcVar.cEj.context = context2;
                                    jcVar.cEj.cvs = bundle;
                                    jcVar.cEj.cEm = akVar;
                                    com.tencent.mm.sdk.b.a.xxA.m(jcVar);
                                    boolean z = jcVar.cEk.cEn;
                                    if (!(z || bo.isNullOrNil(optString) || bo.isNullOrNil(optString3))) {
                                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(optString + "://" + optString3));
                                        ab.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", r0);
                                        intent2.addFlags(268435456);
                                        H = bo.H(context2, intent2);
                                        if (!(H == null || H.isEmpty())) {
                                            if (TextUtils.isEmpty(intent2.getPackage()) && H.size() == 1) {
                                                b = g.b((ResolveInfo) H.get(0));
                                            } else {
                                                b = intent2.getPackage();
                                            }
                                            if (!bo.nullAsNil(ah.getPackageName()).equals(b)) {
                                                akVar.ftW = false;
                                                akVar.hxt = false;
                                                akVar.hxu = false;
                                                akVar.cEn = false;
                                                a = g.a(context2, intent2, null, akVar, bundle);
                                                akVar.dS(a);
                                                AppMethodBeat.o(6327);
                                                return;
                                            }
                                        }
                                    }
                                    a = z;
                                    akVar.dS(a);
                                    AppMethodBeat.o(6327);
                                    return;
                                case 2:
                                    aVar3.d("check fail forbidden scene", null);
                                    AppMethodBeat.o(6327);
                                    return;
                                default:
                                    aVar3.d("check fail", null);
                                    AppMethodBeat.o(6327);
                                    return;
                            }
                        }
                        aVar3.d("check fail", null);
                        AppMethodBeat.o(6327);
                    }
                });
                AppMethodBeat.o(6328);
                return 0;
            }
        });
        AppMethodBeat.o(6329);
    }
}
