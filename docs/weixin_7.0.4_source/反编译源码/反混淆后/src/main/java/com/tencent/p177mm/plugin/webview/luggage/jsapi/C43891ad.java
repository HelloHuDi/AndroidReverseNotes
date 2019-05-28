package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C40353n;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C40353n.C23160a;
import com.tencent.p177mm.protocal.protobuf.avy;
import com.tencent.p177mm.protocal.protobuf.avz;
import com.tencent.p177mm.protocal.protobuf.awa;
import com.tencent.p177mm.protocal.protobuf.awb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ad */
public class C43891ad extends C46419bd<C24905d> {
    public final String name() {
        return "login";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(final C32183a c32183a) {
        AppMethodBeat.m2504i(6336);
        C4990ab.m7416i("MicroMsg.JsApiLogin", "invoke");
        LinkedList linkedList = new LinkedList();
        String str = "";
        String str2 = "";
        final String appId = ((C24905d) c32183a.bOZ).uij.getAppId();
        if (C5046bo.isNullOrNil(appId)) {
            C4990ab.m7412e("MicroMsg.JsApiLogin", "appId is null!");
            c32183a.mo52824a("fail", null);
            AppMethodBeat.m2505o(6336);
            return;
        }
        C1196a c1196a = new C1196a();
        awa awa = new awa();
        c1196a.fsJ = awa;
        c1196a.fsK = new awb();
        c1196a.uri = "/cgi-bin/mmbiz-bin/js-login";
        c1196a.fsI = 1029;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        awa.fKh = appId;
        awa.wzD = linkedList;
        awa.wzM = 0;
        awa.Url = str2;
        awa.wzN = str;
        awa.wzF = 0;
        C42146b.m74301a(c1196a.acD(), new C9557a() {
            /* renamed from: a */
            public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                AppMethodBeat.m2504i(6334);
                C4990ab.m7417i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    awb awb = (awb) c7472b.fsH.fsP;
                    if (awb == null || awb.wzH == null) {
                        c32183a.mo52824a("fail", null);
                        AppMethodBeat.m2505o(6334);
                        return;
                    }
                    int i3 = awb.wzH.cyE;
                    String str2 = awb.wzH.cyF;
                    final String str3 = awb.wzN;
                    C4990ab.m7417i("MicroMsg.JsApiLogin", "NetSceneJSLogin jsErrcode %d", Integer.valueOf(i3));
                    if (i3 == -12000) {
                        final LinkedList linkedList = awb.wlE;
                        final String str4 = awb.ncH;
                        final String str5 = awb.vDm;
                        C4990ab.m7411d("MicroMsg.JsApiLogin", "appName %s, appIconUrl %s", str4, str5);
                        C5004al.m7441d(new Runnable() {

                            /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ad$1$1$1 */
                            class C144881 implements C23160a {
                                C144881() {
                                }

                                /* renamed from: f */
                                public final void mo5953f(int i, Bundle bundle) {
                                    AppMethodBeat.m2504i(6332);
                                    C4990ab.m7417i("MicroMsg.JsApiLogin", "onRevMsg resultCode %d", Integer.valueOf(i));
                                    switch (i) {
                                        case 1:
                                        case 2:
                                            C43891ad.m78719a(C43891ad.this, appId, bundle, str3, i, c32183a);
                                            if (i == 2) {
                                                C4990ab.m7412e("MicroMsg.JsApiLogin", "fail auth deny!");
                                                c32183a.mo52824a("auth_deny", null);
                                                AppMethodBeat.m2505o(6332);
                                                return;
                                            }
                                            break;
                                        default:
                                            C4990ab.m7416i("MicroMsg.JsApiLogin", "press back button!");
                                            c32183a.mo52824a("auth_cancel", null);
                                            break;
                                    }
                                    AppMethodBeat.m2505o(6332);
                                }
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(6333);
                                C40353n c40353n = new C40353n(((C24905d) c32183a.bOZ).mContext);
                                C144881 c144881 = new C144881();
                                if (linkedList == null || linkedList.size() <= 0) {
                                    C4990ab.m7412e("MicroMsg.JsApiLogin", "scopeInfoList is empty!");
                                    c32183a.mo52824a("fail", null);
                                    AppMethodBeat.m2505o(6333);
                                    return;
                                }
                                if (!c40353n.mo63719a(linkedList, str4, str5, c144881)) {
                                    c32183a.mo52824a("fail", null);
                                }
                                AppMethodBeat.m2505o(6333);
                            }
                        });
                        AppMethodBeat.m2505o(6334);
                        return;
                    } else if (i3 == 0) {
                        new HashMap().put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, awb.wzO);
                        C4990ab.m7411d("MicroMsg.JsApiLogin", "resp data code [%s]", r0);
                        c32183a.mo52824a("", null);
                        AppMethodBeat.m2505o(6334);
                        return;
                    } else {
                        C4990ab.m7413e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", str2);
                        c32183a.mo52824a("fail", null);
                        AppMethodBeat.m2505o(6334);
                        return;
                    }
                }
                c32183a.mo52824a("fail", null);
                AppMethodBeat.m2505o(6334);
            }
        });
        AppMethodBeat.m2505o(6336);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }

    /* renamed from: a */
    static /* synthetic */ void m78719a(C43891ad c43891ad, String str, Bundle bundle, String str2, final int i, final C32183a c32183a) {
        AppMethodBeat.m2504i(6337);
        ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
        LinkedList linkedList = new LinkedList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            linkedList.add((String) it.next());
        }
        C1196a c1196a = new C1196a();
        avy avy = new avy();
        c1196a.fsJ = avy;
        c1196a.fsK = new avz();
        c1196a.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
        c1196a.fsI = FaceManager.FACE_WITH_EYES_CLOSED;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        avy.fKh = str;
        avy.wzD = linkedList;
        avy.wzM = 0;
        avy.wzN = str2;
        avy.wzF = 0;
        avy.wzE = i;
        C42146b.m74301a(c1196a.acD(), new C9557a() {
            /* renamed from: a */
            public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                AppMethodBeat.m2504i(6335);
                C4990ab.m7417i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i != 0 || i2 != 0) {
                    c32183a.mo52824a("fail", null);
                    AppMethodBeat.m2505o(6335);
                } else if (i == 2) {
                    C4990ab.m7410d("MicroMsg.JsApiLogin", "press reject button");
                    c32183a.mo52824a("fail", null);
                    AppMethodBeat.m2505o(6335);
                } else {
                    avz avz = (avz) c7472b.fsH.fsP;
                    if (avz == null || avz.wzH == null) {
                        c32183a.mo52824a("fail", null);
                        AppMethodBeat.m2505o(6335);
                        return;
                    }
                    int i3 = avz.wzH.cyE;
                    String str2 = avz.wzH.cyF;
                    C4990ab.m7417i("MicroMsg.JsApiLogin", "jsErrcode = %d", Integer.valueOf(i3));
                    if (i3 == 0) {
                        new HashMap().put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, avz.wzO);
                        c32183a.mo52824a("", null);
                        C4990ab.m7411d("MicroMsg.JsApiLogin", "resp data code [%s]", r0);
                        AppMethodBeat.m2505o(6335);
                        return;
                    }
                    c32183a.mo52824a("fail", null);
                    C4990ab.m7413e("MicroMsg.JsApiLogin", "errMsg = %s", str2);
                    AppMethodBeat.m2505o(6335);
                }
            }
        });
        AppMethodBeat.m2505o(6337);
    }
}
