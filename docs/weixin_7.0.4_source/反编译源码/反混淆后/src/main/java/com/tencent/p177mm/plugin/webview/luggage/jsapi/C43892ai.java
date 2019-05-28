package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.C46422q;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C43963g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43970c.C22988d;
import com.tencent.p177mm.protocal.C15045c;
import com.tencent.p177mm.protocal.C15045c.C15081g;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.avo;
import com.tencent.p177mm.protocal.protobuf.avp;
import com.tencent.p177mm.protocal.protobuf.cmu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ai */
public class C43892ai extends C46419bd<C24905d> {

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ai$a */
    static class C35599a implements C9557a {
        private String appId;
        private C32183a ujY;

        C35599a(C32183a c32183a, String str) {
            this.ujY = c32183a;
            this.appId = str;
        }

        /* renamed from: a */
        public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
            AppMethodBeat.m2504i(6344);
            if (this.ujY == null) {
                AppMethodBeat.m2505o(6344);
            } else if (i == 0 && i2 == 0) {
                avp avp = (avp) c7472b.fsH.fsP;
                if (avp == null || avp.wzj == null || avp.wzj.cyE != 0) {
                    m58429AR(str);
                    AppMethodBeat.m2505o(6344);
                    return;
                }
                C46422q c46422q = ((C24905d) this.ujY.bOZ).uij;
                String str2 = this.appId;
                if (!(C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(c46422q.uiI.getUrl()))) {
                    c46422q.ujw.put(C46422q.aef(c46422q.uiI.getUrl()), str2);
                }
                C22988d c22988d = new C22988d();
                c22988d.appId = this.appId;
                c22988d.uFm = avp.wzA;
                c46422q = ((C24905d) this.ujY.bOZ).uij;
                if (!C5046bo.isNullOrNil(c46422q.uiI.getUrl())) {
                    c46422q.ujx.put(C46422q.aef(c46422q.uiI.getUrl()), c22988d);
                }
                LinkedList linkedList = avp.wzz;
                JsapiPermissionWrapper aei = ((C24905d) this.ujY.bOZ).cWM().aei(((C24905d) this.ujY.bOZ).getUrl());
                if (aei == null) {
                    m58429AR("");
                    AppMethodBeat.m2505o(6344);
                    return;
                }
                if (!C5046bo.m7548ek(linkedList)) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        cmu cmu = (cmu) it.next();
                        C15081g akD = C15045c.akD(cmu.wzd);
                        if (!(akD == null || aei.mo69828Lx(akD.dmb()) == cmu.state)) {
                            aei.mo69829a(akD.dmb(), (byte) cmu.state);
                        }
                    }
                }
                ((C24905d) this.ujY.bOZ).cWP().afX(avp.wzB);
                m58429AR("");
                AppMethodBeat.m2505o(6344);
            } else {
                C4990ab.m7413e("MicroMsg.JsApiPreVerify", "errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                m58429AR(str);
                AppMethodBeat.m2505o(6344);
            }
        }

        /* renamed from: AR */
        private void m58429AR(String str) {
            AppMethodBeat.m2504i(6345);
            if (C5046bo.isNullOrNil(str)) {
                this.ujY.mo52824a("", null);
            } else {
                this.ujY.mo52824a(str, null);
            }
            C43963g.m78904aG(((C24905d) this.ujY.bOZ).cWL(), System.currentTimeMillis());
            release();
            AppMethodBeat.m2505o(6345);
        }

        private void release() {
            this.ujY = null;
            this.appId = null;
        }
    }

    public final String name() {
        return "preVerifyJSAPI";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6346);
        C4990ab.m7416i("MicroMsg.JsApiPreVerify", "invokeInOwn");
        C43963g.m78903aF(((C24905d) c32183a.bOZ).cWL(), System.currentTimeMillis());
        JSONObject jSONObject = c32183a.bPa.bOf;
        String optString = jSONObject.optString("verifyAppId");
        String optString2 = jSONObject.optString("verifySignature");
        String optString3 = jSONObject.optString("verifyNonceStr");
        String optString4 = jSONObject.optString("verifyTimestamp");
        String optString5 = jSONObject.optString("verifySignType");
        JSONArray optJSONArray = jSONObject.optJSONArray("verifyJsApiList");
        C4990ab.m7417i("MicroMsg.JsApiPreVerify", "appid : %s, %s, %s, %s, %s", optString, optString2, optString3, optString4, optString5);
        String url = ((C24905d) c32183a.bOZ).getUrl();
        LinkedList linkedList = new LinkedList();
        try {
            C4990ab.m7417i("MicroMsg.JsApiPreVerify", "jsItem length %s", Integer.valueOf(optJSONArray.length()));
            if (optJSONArray.length() == 0) {
                c32183a.mo52824a("checkJsApi:param is empty", null);
                AppMethodBeat.m2505o(6346);
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                String string = optJSONArray.getString(i);
                if (!C5046bo.isNullOrNil(string)) {
                    linkedList.add(string);
                }
            }
            if (C5046bo.isNullOrNil(optString) || linkedList.size() <= 0 || C5046bo.isNullOrNil(url)) {
                C4990ab.m7413e("MicroMsg.JsApiPreVerify", "handlePreVerify wrong args, %s", optString);
                c32183a.mo52824a("pre_verify_jsapi:fail_invalid_args", null);
                AppMethodBeat.m2505o(6346);
                return;
            }
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new avo();
            c1196a.fsK = new avp();
            c1196a.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
            c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            C7472b acD = c1196a.acD();
            avo avo = (avo) acD.fsG.fsP;
            avo.url = url;
            avo.csB = optString;
            avo.wzx = linkedList;
            avo.cvO = optString4;
            avo.wzf = optString3;
            avo.signature = optString2;
            avo.wzg = optString5;
            C42146b.m74301a(acD, new C35599a(c32183a, optString));
            AppMethodBeat.m2505o(6346);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.JsApiPreVerify", "exception occur " + e.getMessage());
            c32183a.mo52824a("", null);
            AppMethodBeat.m2505o(6346);
        }
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
