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
import com.tencent.p177mm.protocal.protobuf.avu;
import com.tencent.p177mm.protocal.protobuf.avv;
import com.tencent.p177mm.protocal.protobuf.avw;
import com.tencent.p177mm.protocal.protobuf.avx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.c */
public class C22843c extends C46419bd<C24905d> {

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.c$2 */
    class C169272 implements C9557a {
        final /* synthetic */ int hmP;
        final /* synthetic */ C32183a mUf;

        C169272(C32183a c32183a, int i) {
            this.mUf = c32183a;
            this.hmP = i;
        }

        /* renamed from: a */
        public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
            AppMethodBeat.m2504i(6280);
            C4990ab.m7417i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 || i2 != 0) {
                this.mUf.mo52824a("fail", null);
                AppMethodBeat.m2505o(6280);
            } else if (this.hmP == 2) {
                C4990ab.m7410d("MicroMsg.JsApiAuthorize", "press reject button");
                this.mUf.mo52824a("fail", null);
                AppMethodBeat.m2505o(6280);
            } else {
                avv avv = (avv) c7472b.fsH.fsP;
                if (avv == null || avv.wzH == null) {
                    this.mUf.mo52824a("fail", null);
                    AppMethodBeat.m2505o(6280);
                    return;
                }
                int i3 = avv.wzH.cyE;
                String str2 = avv.wzH.cyF;
                C4990ab.m7417i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", Integer.valueOf(i3));
                if (i3 == 0) {
                    this.mUf.mo52824a("", null);
                    AppMethodBeat.m2505o(6280);
                    return;
                }
                C4990ab.m7413e("MicroMsg.JsApiAuthorize", "ERROR = %s", str2);
                this.mUf.mo52824a("fail", null);
                AppMethodBeat.m2505o(6280);
            }
        }
    }

    public final String name() {
        return "authorize";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(final C32183a c32183a) {
        AppMethodBeat.m2504i(6281);
        C4990ab.m7416i("MicroMsg.JsApiAuthorize", "invokeInOwn");
        JSONArray optJSONArray = c32183a.bPa.bOf.optJSONArray("scope");
        if (optJSONArray == null) {
            C4990ab.m7412e("MicroMsg.JsApiAuthorize", "scope is null!");
            c32183a.mo52824a("fail", null);
            AppMethodBeat.m2505o(6281);
            return;
        }
        final String appId = ((C24905d) c32183a.bOZ).uij.getAppId();
        if (C5046bo.isNullOrNil(appId)) {
            C4990ab.m7412e("MicroMsg.JsApiAuthorize", "appId is null!");
            c32183a.mo52824a("fail", null);
            AppMethodBeat.m2505o(6281);
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            linkedList.add(optJSONArray.optString(i));
        }
        C1196a c1196a = new C1196a();
        avw avw = new avw();
        c1196a.fsJ = avw;
        c1196a.fsK = new avx();
        c1196a.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        c1196a.fsI = 1157;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        avw.fKh = appId;
        avw.wzD = linkedList;
        avw.wzF = 0;
        C42146b.m74301a(c1196a.acD(), new C9557a() {
            /* renamed from: a */
            public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                AppMethodBeat.m2504i(6279);
                C4990ab.m7417i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    avx avx = (avx) c7472b.fsH.fsP;
                    if (avx == null || avx.wzH == null) {
                        c32183a.mo52824a("fail", null);
                        AppMethodBeat.m2505o(6279);
                        return;
                    }
                    int i3 = avx.wzH.cyE;
                    String str2 = avx.wzH.cyF;
                    C4990ab.m7417i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", Integer.valueOf(i3));
                    if (i3 == -12000) {
                        final LinkedList linkedList = avx.wlE;
                        str2 = avx.ncH;
                        final String str3 = avx.vDm;
                        C5004al.m7441d(new Runnable() {

                            /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.c$1$1$1 */
                            class C45481 implements C23160a {
                                C45481() {
                                }

                                /* renamed from: f */
                                public final void mo5953f(int i, Bundle bundle) {
                                    AppMethodBeat.m2504i(6277);
                                    C4990ab.m7417i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", Integer.valueOf(i));
                                    switch (i) {
                                        case 1:
                                        case 2:
                                            C22843c c22843c = C22843c.this;
                                            String str = appId;
                                            C32183a c32183a = c32183a;
                                            ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                            LinkedList linkedList = new LinkedList();
                                            Iterator it = arrayList.iterator();
                                            while (it.hasNext()) {
                                                linkedList.add((String) it.next());
                                            }
                                            C1196a c1196a = new C1196a();
                                            avu avu = new avu();
                                            c1196a.fsJ = avu;
                                            c1196a.fsK = new avv();
                                            c1196a.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                                            c1196a.fsI = 1158;
                                            c1196a.fsL = 0;
                                            c1196a.fsM = 0;
                                            avu.fKh = str;
                                            avu.wzD = linkedList;
                                            avu.wzF = 0;
                                            avu.wzE = i;
                                            C42146b.m74301a(c1196a.acD(), new C169272(c32183a, i));
                                            if (i == 2) {
                                                c32183a.mo52824a("auth_deny", null);
                                                AppMethodBeat.m2505o(6277);
                                                return;
                                            }
                                            break;
                                        default:
                                            C4990ab.m7410d("MicroMsg.JsApiAuthorize", "press back button!");
                                            c32183a.mo52824a("auth_cancel", null);
                                            break;
                                    }
                                    AppMethodBeat.m2505o(6277);
                                }
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(6278);
                                C40353n c40353n = new C40353n(((C24905d) c32183a.bOZ).mContext);
                                C45481 c45481 = new C45481();
                                if (linkedList == null || linkedList.size() <= 0) {
                                    C4990ab.m7412e("MicroMsg.JsApiAuthorize", "scopeInfoList is empty!");
                                    c32183a.mo52824a("fail", null);
                                    AppMethodBeat.m2505o(6278);
                                    return;
                                }
                                if (!c40353n.mo63719a(linkedList, str2, str3, c45481)) {
                                    c32183a.mo52824a("fail", null);
                                }
                                AppMethodBeat.m2505o(6278);
                            }
                        });
                        AppMethodBeat.m2505o(6279);
                        return;
                    } else if (i3 == 0) {
                        c32183a.mo52824a("", null);
                        AppMethodBeat.m2505o(6279);
                        return;
                    } else {
                        C4990ab.m7413e("MicroMsg.JsApiAuthorize", "ERROR = %s", str2);
                        c32183a.mo52824a("fail", null);
                        AppMethodBeat.m2505o(6279);
                        return;
                    }
                }
                c32183a.mo52824a("fail", null);
                AppMethodBeat.m2505o(6279);
            }
        });
        AppMethodBeat.m2505o(6281);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
