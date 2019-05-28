package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C32579jc;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C29782c;
import com.tencent.p177mm.pluginsdk.model.app.C14875aj;
import com.tencent.p177mm.pluginsdk.model.app.C17008ak;
import com.tencent.p177mm.pluginsdk.model.app.C17008ak.C17009a;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.protobuf.avj;
import com.tencent.p177mm.protocal.protobuf.avk;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.aa */
public class C46931aa extends C46419bd<C24905d> {
    public final String name() {
        return "launchApplication";
    }

    public final int biG() {
        return 2;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(6329);
        C4990ab.m7416i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
        JSONObject AI = C29782c.m47225AI(str);
        if (AI == null) {
            C4990ab.m7412e("MicroMsg.JsApiLaunchApplication", "data is null");
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6329);
            return;
        }
        final String optString = AI.optString("appID");
        final String optString2 = AI.optString("schemeUrl");
        final String optString3 = AI.optString("parameter");
        int optInt = AI.optInt("alertType");
        final String optString4 = AI.optString(IssueStorage.COLUMN_EXT_INFO);
        C4990ab.m7417i("MicroMsg.JsApiLaunchApplication", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", optString, optString2, optString4, optString3);
        if (C5046bo.isNullOrNil(optString) && C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7412e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6329);
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
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new avj();
        c1196a.fsK = new avk();
        c1196a.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        c1196a.fsI = 1125;
        C7472b acD = c1196a.acD();
        avj avj = (avj) acD.fsG.fsP;
        avj.csB = optString5;
        avj.wzn = optString;
        avj.scene = 0;
        avj.url = optString6;
        avj.wzo = optString2;
        avj.kCo = optInt;
        avj.wzp = 0;
        C4990ab.m7417i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", optString5, optString, Integer.valueOf(avj.scene), avj.url, avj.wzo, Integer.valueOf(avj.kCo));
        final C22841a c22841a2 = c22841a;
        final Context context2 = context;
        C1226w.m2654a(acD, new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(6328);
                final int i3 = i;
                final int i4 = i2;
                final String str2 = str;
                final C7472b c7472b2 = c7472b;
                C18514l.post(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.aa$1$1$1 */
                    class C45451 implements C17009a {
                        C45451() {
                        }

                        /* renamed from: r */
                        public final void mo9615r(boolean z, boolean z2) {
                            AppMethodBeat.m2504i(6326);
                            C4990ab.m7417i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                            if (z) {
                                c22841a2.mo26722d(null, null);
                                AppMethodBeat.m2505o(6326);
                                return;
                            }
                            c22841a2.mo26722d("fail", null);
                            AppMethodBeat.m2505o(6326);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(6327);
                        C4990ab.m7411d("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str2);
                        if (i3 == 0 && i4 == 0) {
                            avk avk = (avk) c7472b2.fsH.fsP;
                            switch (avk.cyE) {
                                case 0:
                                    List H;
                                    Object b;
                                    boolean a;
                                    C14875aj c17008ak = new C17008ak(new C45451());
                                    C4990ab.m7417i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", Integer.valueOf(avk.wzs), Integer.valueOf(avk.cyE));
                                    if (!C5046bo.isNullOrNil(optString2)) {
                                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
                                        intent.addFlags(268435456);
                                        H = C5046bo.m7502H(context2, intent);
                                        if (!(H == null || H.isEmpty())) {
                                            if (TextUtils.isEmpty(intent.getPackage()) && H.size() == 1) {
                                                b = C46494g.m87734b((ResolveInfo) H.get(0));
                                            } else {
                                                b = intent.getPackage();
                                            }
                                            if (!C5046bo.nullAsNil(C4996ah.getPackageName()).equals(b)) {
                                                c17008ak.mo31082dS(C46494g.m87723a(context2, intent, null, avk.wzs, c17008ak, bundle));
                                                AppMethodBeat.m2505o(6327);
                                                return;
                                            }
                                        }
                                    }
                                    WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                                    wXAppExtendObject.extInfo = optString4;
                                    WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                                    wXMediaMessage.sdkVer = Build.SDK_INT;
                                    wXMediaMessage.messageExt = optString4;
                                    C32579jc c32579jc = new C32579jc();
                                    c32579jc.cEj.cEl = wXMediaMessage;
                                    c32579jc.cEj.appId = optString;
                                    c32579jc.cEj.showType = avk.wzs;
                                    c32579jc.cEj.context = context2;
                                    c32579jc.cEj.cvs = bundle;
                                    c32579jc.cEj.cEm = c17008ak;
                                    C4879a.xxA.mo10055m(c32579jc);
                                    boolean z = c32579jc.cEk.cEn;
                                    if (!(z || C5046bo.isNullOrNil(optString) || C5046bo.isNullOrNil(optString3))) {
                                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(optString + "://" + optString3));
                                        C4990ab.m7417i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", r0);
                                        intent2.addFlags(268435456);
                                        H = C5046bo.m7502H(context2, intent2);
                                        if (!(H == null || H.isEmpty())) {
                                            if (TextUtils.isEmpty(intent2.getPackage()) && H.size() == 1) {
                                                b = C46494g.m87734b((ResolveInfo) H.get(0));
                                            } else {
                                                b = intent2.getPackage();
                                            }
                                            if (!C5046bo.nullAsNil(C4996ah.getPackageName()).equals(b)) {
                                                c17008ak.ftW = false;
                                                c17008ak.hxt = false;
                                                c17008ak.hxu = false;
                                                c17008ak.cEn = false;
                                                a = C46494g.m87725a(context2, intent2, null, c17008ak, bundle);
                                                c17008ak.mo31082dS(a);
                                                AppMethodBeat.m2505o(6327);
                                                return;
                                            }
                                        }
                                    }
                                    a = z;
                                    c17008ak.mo31082dS(a);
                                    AppMethodBeat.m2505o(6327);
                                    return;
                                case 2:
                                    c22841a2.mo26722d("check fail forbidden scene", null);
                                    AppMethodBeat.m2505o(6327);
                                    return;
                                default:
                                    c22841a2.mo26722d("check fail", null);
                                    AppMethodBeat.m2505o(6327);
                                    return;
                            }
                        }
                        c22841a2.mo26722d("check fail", null);
                        AppMethodBeat.m2505o(6327);
                    }
                });
                AppMethodBeat.m2505o(6328);
                return 0;
            }
        });
        AppMethodBeat.m2505o(6329);
    }
}
