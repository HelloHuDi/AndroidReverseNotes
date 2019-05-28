package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ai extends bd<d> {

    static class a implements com.tencent.mm.ipcinvoker.wx_extension.b.a {
        private String appId;
        private com.tencent.luggage.d.a.a ujY;

        a(com.tencent.luggage.d.a.a aVar, String str) {
            this.ujY = aVar;
            this.appId = str;
        }

        public final void a(int i, int i2, String str, b bVar) {
            AppMethodBeat.i(6344);
            if (this.ujY == null) {
                AppMethodBeat.o(6344);
            } else if (i == 0 && i2 == 0) {
                avp avp = (avp) bVar.fsH.fsP;
                if (avp == null || avp.wzj == null || avp.wzj.cyE != 0) {
                    AR(str);
                    AppMethodBeat.o(6344);
                    return;
                }
                q qVar = ((d) this.ujY.bOZ).uij;
                String str2 = this.appId;
                if (!(bo.isNullOrNil(str2) || bo.isNullOrNil(qVar.uiI.getUrl()))) {
                    qVar.ujw.put(q.aef(qVar.uiI.getUrl()), str2);
                }
                c.d dVar = new c.d();
                dVar.appId = this.appId;
                dVar.uFm = avp.wzA;
                qVar = ((d) this.ujY.bOZ).uij;
                if (!bo.isNullOrNil(qVar.uiI.getUrl())) {
                    qVar.ujx.put(q.aef(qVar.uiI.getUrl()), dVar);
                }
                LinkedList linkedList = avp.wzz;
                JsapiPermissionWrapper aei = ((d) this.ujY.bOZ).cWM().aei(((d) this.ujY.bOZ).getUrl());
                if (aei == null) {
                    AR("");
                    AppMethodBeat.o(6344);
                    return;
                }
                if (!bo.ek(linkedList)) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        cmu cmu = (cmu) it.next();
                        g akD = com.tencent.mm.protocal.c.akD(cmu.wzd);
                        if (!(akD == null || aei.Lx(akD.dmb()) == cmu.state)) {
                            aei.a(akD.dmb(), (byte) cmu.state);
                        }
                    }
                }
                ((d) this.ujY.bOZ).cWP().afX(avp.wzB);
                AR("");
                AppMethodBeat.o(6344);
            } else {
                ab.e("MicroMsg.JsApiPreVerify", "errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                AR(str);
                AppMethodBeat.o(6344);
            }
        }

        private void AR(String str) {
            AppMethodBeat.i(6345);
            if (bo.isNullOrNil(str)) {
                this.ujY.a("", null);
            } else {
                this.ujY.a(str, null);
            }
            com.tencent.mm.plugin.webview.ui.tools.game.g.aG(((d) this.ujY.bOZ).cWL(), System.currentTimeMillis());
            release();
            AppMethodBeat.o(6345);
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

    public final void b(com.tencent.luggage.d.a.a aVar) {
        AppMethodBeat.i(6346);
        ab.i("MicroMsg.JsApiPreVerify", "invokeInOwn");
        com.tencent.mm.plugin.webview.ui.tools.game.g.aF(((d) aVar.bOZ).cWL(), System.currentTimeMillis());
        JSONObject jSONObject = aVar.bPa.bOf;
        String optString = jSONObject.optString("verifyAppId");
        String optString2 = jSONObject.optString("verifySignature");
        String optString3 = jSONObject.optString("verifyNonceStr");
        String optString4 = jSONObject.optString("verifyTimestamp");
        String optString5 = jSONObject.optString("verifySignType");
        JSONArray optJSONArray = jSONObject.optJSONArray("verifyJsApiList");
        ab.i("MicroMsg.JsApiPreVerify", "appid : %s, %s, %s, %s, %s", optString, optString2, optString3, optString4, optString5);
        String url = ((d) aVar.bOZ).getUrl();
        LinkedList linkedList = new LinkedList();
        try {
            ab.i("MicroMsg.JsApiPreVerify", "jsItem length %s", Integer.valueOf(optJSONArray.length()));
            if (optJSONArray.length() == 0) {
                aVar.a("checkJsApi:param is empty", null);
                AppMethodBeat.o(6346);
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                String string = optJSONArray.getString(i);
                if (!bo.isNullOrNil(string)) {
                    linkedList.add(string);
                }
            }
            if (bo.isNullOrNil(optString) || linkedList.size() <= 0 || bo.isNullOrNil(url)) {
                ab.e("MicroMsg.JsApiPreVerify", "handlePreVerify wrong args, %s", optString);
                aVar.a("pre_verify_jsapi:fail_invalid_args", null);
                AppMethodBeat.o(6346);
                return;
            }
            com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
            aVar2.fsJ = new avo();
            aVar2.fsK = new avp();
            aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
            aVar2.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI;
            aVar2.fsL = 0;
            aVar2.fsM = 0;
            b acD = aVar2.acD();
            avo avo = (avo) acD.fsG.fsP;
            avo.url = url;
            avo.csB = optString;
            avo.wzx = linkedList;
            avo.cvO = optString4;
            avo.wzf = optString3;
            avo.signature = optString2;
            avo.wzg = optString5;
            com.tencent.mm.ipcinvoker.wx_extension.b.a(acD, new a(aVar, optString));
            AppMethodBeat.o(6346);
        } catch (Exception e) {
            ab.w("MicroMsg.JsApiPreVerify", "exception occur " + e.getMessage());
            aVar.a("", null);
            AppMethodBeat.o(6346);
        }
    }

    public final void a(Context context, String str, com.tencent.mm.plugin.webview.luggage.jsapi.bc.a aVar) {
    }
}
