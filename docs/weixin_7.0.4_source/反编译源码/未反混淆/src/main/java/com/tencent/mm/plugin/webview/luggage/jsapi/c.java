package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.protocal.protobuf.avu;
import com.tencent.mm.protocal.protobuf.avv;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;

public class c extends bd<d> {

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.c$2 */
    class AnonymousClass2 implements a {
        final /* synthetic */ int hmP;
        final /* synthetic */ com.tencent.luggage.d.a.a mUf;

        AnonymousClass2(com.tencent.luggage.d.a.a aVar, int i) {
            this.mUf = aVar;
            this.hmP = i;
        }

        public final void a(int i, int i2, String str, b bVar) {
            AppMethodBeat.i(6280);
            ab.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 || i2 != 0) {
                this.mUf.a("fail", null);
                AppMethodBeat.o(6280);
            } else if (this.hmP == 2) {
                ab.d("MicroMsg.JsApiAuthorize", "press reject button");
                this.mUf.a("fail", null);
                AppMethodBeat.o(6280);
            } else {
                avv avv = (avv) bVar.fsH.fsP;
                if (avv == null || avv.wzH == null) {
                    this.mUf.a("fail", null);
                    AppMethodBeat.o(6280);
                    return;
                }
                int i3 = avv.wzH.cyE;
                String str2 = avv.wzH.cyF;
                ab.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", Integer.valueOf(i3));
                if (i3 == 0) {
                    this.mUf.a("", null);
                    AppMethodBeat.o(6280);
                    return;
                }
                ab.e("MicroMsg.JsApiAuthorize", "ERROR = %s", str2);
                this.mUf.a("fail", null);
                AppMethodBeat.o(6280);
            }
        }
    }

    public final String name() {
        return "authorize";
    }

    public final int biG() {
        return 0;
    }

    public final void b(final com.tencent.luggage.d.a.a aVar) {
        AppMethodBeat.i(6281);
        ab.i("MicroMsg.JsApiAuthorize", "invokeInOwn");
        JSONArray optJSONArray = aVar.bPa.bOf.optJSONArray("scope");
        if (optJSONArray == null) {
            ab.e("MicroMsg.JsApiAuthorize", "scope is null!");
            aVar.a("fail", null);
            AppMethodBeat.o(6281);
            return;
        }
        final String appId = ((d) aVar.bOZ).uij.getAppId();
        if (bo.isNullOrNil(appId)) {
            ab.e("MicroMsg.JsApiAuthorize", "appId is null!");
            aVar.a("fail", null);
            AppMethodBeat.o(6281);
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            linkedList.add(optJSONArray.optString(i));
        }
        b.a aVar2 = new b.a();
        avw avw = new avw();
        aVar2.fsJ = avw;
        aVar2.fsK = new avx();
        aVar2.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        aVar2.fsI = 1157;
        aVar2.fsL = 0;
        aVar2.fsM = 0;
        avw.fKh = appId;
        avw.wzD = linkedList;
        avw.wzF = 0;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar2.acD(), new a() {
            public final void a(int i, int i2, String str, b bVar) {
                AppMethodBeat.i(6279);
                ab.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    avx avx = (avx) bVar.fsH.fsP;
                    if (avx == null || avx.wzH == null) {
                        aVar.a("fail", null);
                        AppMethodBeat.o(6279);
                        return;
                    }
                    int i3 = avx.wzH.cyE;
                    String str2 = avx.wzH.cyF;
                    ab.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", Integer.valueOf(i3));
                    if (i3 == -12000) {
                        final LinkedList linkedList = avx.wlE;
                        str2 = avx.ncH;
                        final String str3 = avx.vDm;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(6278);
                                n nVar = new n(((d) aVar.bOZ).mContext);
                                AnonymousClass1 anonymousClass1 = new n.a() {
                                    public final void f(int i, Bundle bundle) {
                                        AppMethodBeat.i(6277);
                                        ab.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", Integer.valueOf(i));
                                        switch (i) {
                                            case 1:
                                            case 2:
                                                c cVar = c.this;
                                                String str = appId;
                                                com.tencent.luggage.d.a.a aVar = aVar;
                                                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                                LinkedList linkedList = new LinkedList();
                                                Iterator it = arrayList.iterator();
                                                while (it.hasNext()) {
                                                    linkedList.add((String) it.next());
                                                }
                                                b.a aVar2 = new b.a();
                                                avu avu = new avu();
                                                aVar2.fsJ = avu;
                                                aVar2.fsK = new avv();
                                                aVar2.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                                                aVar2.fsI = 1158;
                                                aVar2.fsL = 0;
                                                aVar2.fsM = 0;
                                                avu.fKh = str;
                                                avu.wzD = linkedList;
                                                avu.wzF = 0;
                                                avu.wzE = i;
                                                com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar2.acD(), new AnonymousClass2(aVar, i));
                                                if (i == 2) {
                                                    aVar.a("auth_deny", null);
                                                    AppMethodBeat.o(6277);
                                                    return;
                                                }
                                                break;
                                            default:
                                                ab.d("MicroMsg.JsApiAuthorize", "press back button!");
                                                aVar.a("auth_cancel", null);
                                                break;
                                        }
                                        AppMethodBeat.o(6277);
                                    }
                                };
                                if (linkedList == null || linkedList.size() <= 0) {
                                    ab.e("MicroMsg.JsApiAuthorize", "scopeInfoList is empty!");
                                    aVar.a("fail", null);
                                    AppMethodBeat.o(6278);
                                    return;
                                }
                                if (!nVar.a(linkedList, str2, str3, anonymousClass1)) {
                                    aVar.a("fail", null);
                                }
                                AppMethodBeat.o(6278);
                            }
                        });
                        AppMethodBeat.o(6279);
                        return;
                    } else if (i3 == 0) {
                        aVar.a("", null);
                        AppMethodBeat.o(6279);
                        return;
                    } else {
                        ab.e("MicroMsg.JsApiAuthorize", "ERROR = %s", str2);
                        aVar.a("fail", null);
                        AppMethodBeat.o(6279);
                        return;
                    }
                }
                aVar.a("fail", null);
                AppMethodBeat.o(6279);
            }
        });
        AppMethodBeat.o(6281);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
