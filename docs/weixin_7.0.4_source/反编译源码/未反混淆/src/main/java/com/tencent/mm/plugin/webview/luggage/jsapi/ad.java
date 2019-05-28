package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ad extends bd<d> {
    public final String name() {
        return "login";
    }

    public final int biG() {
        return 0;
    }

    public final void b(final a aVar) {
        AppMethodBeat.i(6336);
        ab.i("MicroMsg.JsApiLogin", "invoke");
        LinkedList linkedList = new LinkedList();
        String str = "";
        String str2 = "";
        final String appId = ((d) aVar.bOZ).uij.getAppId();
        if (bo.isNullOrNil(appId)) {
            ab.e("MicroMsg.JsApiLogin", "appId is null!");
            aVar.a("fail", null);
            AppMethodBeat.o(6336);
            return;
        }
        b.a aVar2 = new b.a();
        awa awa = new awa();
        aVar2.fsJ = awa;
        aVar2.fsK = new awb();
        aVar2.uri = "/cgi-bin/mmbiz-bin/js-login";
        aVar2.fsI = 1029;
        aVar2.fsL = 0;
        aVar2.fsM = 0;
        awa.fKh = appId;
        awa.wzD = linkedList;
        awa.wzM = 0;
        awa.Url = str2;
        awa.wzN = str;
        awa.wzF = 0;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar2.acD(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, b bVar) {
                AppMethodBeat.i(6334);
                ab.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    awb awb = (awb) bVar.fsH.fsP;
                    if (awb == null || awb.wzH == null) {
                        aVar.a("fail", null);
                        AppMethodBeat.o(6334);
                        return;
                    }
                    int i3 = awb.wzH.cyE;
                    String str2 = awb.wzH.cyF;
                    final String str3 = awb.wzN;
                    ab.i("MicroMsg.JsApiLogin", "NetSceneJSLogin jsErrcode %d", Integer.valueOf(i3));
                    if (i3 == -12000) {
                        final LinkedList linkedList = awb.wlE;
                        final String str4 = awb.ncH;
                        final String str5 = awb.vDm;
                        ab.d("MicroMsg.JsApiLogin", "appName %s, appIconUrl %s", str4, str5);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(6333);
                                n nVar = new n(((d) aVar.bOZ).mContext);
                                AnonymousClass1 anonymousClass1 = new n.a() {
                                    public final void f(int i, Bundle bundle) {
                                        AppMethodBeat.i(6332);
                                        ab.i("MicroMsg.JsApiLogin", "onRevMsg resultCode %d", Integer.valueOf(i));
                                        switch (i) {
                                            case 1:
                                            case 2:
                                                ad.a(ad.this, appId, bundle, str3, i, aVar);
                                                if (i == 2) {
                                                    ab.e("MicroMsg.JsApiLogin", "fail auth deny!");
                                                    aVar.a("auth_deny", null);
                                                    AppMethodBeat.o(6332);
                                                    return;
                                                }
                                                break;
                                            default:
                                                ab.i("MicroMsg.JsApiLogin", "press back button!");
                                                aVar.a("auth_cancel", null);
                                                break;
                                        }
                                        AppMethodBeat.o(6332);
                                    }
                                };
                                if (linkedList == null || linkedList.size() <= 0) {
                                    ab.e("MicroMsg.JsApiLogin", "scopeInfoList is empty!");
                                    aVar.a("fail", null);
                                    AppMethodBeat.o(6333);
                                    return;
                                }
                                if (!nVar.a(linkedList, str4, str5, anonymousClass1)) {
                                    aVar.a("fail", null);
                                }
                                AppMethodBeat.o(6333);
                            }
                        });
                        AppMethodBeat.o(6334);
                        return;
                    } else if (i3 == 0) {
                        new HashMap().put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, awb.wzO);
                        ab.d("MicroMsg.JsApiLogin", "resp data code [%s]", r0);
                        aVar.a("", null);
                        AppMethodBeat.o(6334);
                        return;
                    } else {
                        ab.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", str2);
                        aVar.a("fail", null);
                        AppMethodBeat.o(6334);
                        return;
                    }
                }
                aVar.a("fail", null);
                AppMethodBeat.o(6334);
            }
        });
        AppMethodBeat.o(6336);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }

    static /* synthetic */ void a(ad adVar, String str, Bundle bundle, String str2, final int i, final a aVar) {
        AppMethodBeat.i(6337);
        ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
        LinkedList linkedList = new LinkedList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            linkedList.add((String) it.next());
        }
        b.a aVar2 = new b.a();
        avy avy = new avy();
        aVar2.fsJ = avy;
        aVar2.fsK = new avz();
        aVar2.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
        aVar2.fsI = FaceManager.FACE_WITH_EYES_CLOSED;
        aVar2.fsL = 0;
        aVar2.fsM = 0;
        avy.fKh = str;
        avy.wzD = linkedList;
        avy.wzM = 0;
        avy.wzN = str2;
        avy.wzF = 0;
        avy.wzE = i;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar2.acD(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, b bVar) {
                AppMethodBeat.i(6335);
                ab.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i != 0 || i2 != 0) {
                    aVar.a("fail", null);
                    AppMethodBeat.o(6335);
                } else if (i == 2) {
                    ab.d("MicroMsg.JsApiLogin", "press reject button");
                    aVar.a("fail", null);
                    AppMethodBeat.o(6335);
                } else {
                    avz avz = (avz) bVar.fsH.fsP;
                    if (avz == null || avz.wzH == null) {
                        aVar.a("fail", null);
                        AppMethodBeat.o(6335);
                        return;
                    }
                    int i3 = avz.wzH.cyE;
                    String str2 = avz.wzH.cyF;
                    ab.i("MicroMsg.JsApiLogin", "jsErrcode = %d", Integer.valueOf(i3));
                    if (i3 == 0) {
                        new HashMap().put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, avz.wzO);
                        aVar.a("", null);
                        ab.d("MicroMsg.JsApiLogin", "resp data code [%s]", r0);
                        AppMethodBeat.o(6335);
                        return;
                    }
                    aVar.a("fail", null);
                    ab.e("MicroMsg.JsApiLogin", "errMsg = %s", str2);
                    AppMethodBeat.o(6335);
                }
            }
        });
        AppMethodBeat.o(6337);
    }
}
