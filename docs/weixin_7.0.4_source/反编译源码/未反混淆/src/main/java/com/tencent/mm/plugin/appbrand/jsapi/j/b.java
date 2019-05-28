package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.annotation.SuppressLint;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends d {
    public static final int CTRL_INDEX = 516;
    public static final String NAME = "joinVoIPChat";
    private static String TAG = "MicroMsg.OpenVoice.JsApiCloudVoiceJoinVoIPChat";
    private e hTa = new e();
    private f hTb = new f();
    private g hTc = new g();
    private long hTd = -1;
    private int hTe = 0;
    private String mAppId = "";

    public b() {
        AppMethodBeat.i(131391);
        AppMethodBeat.o(131391);
    }

    public final void b(q qVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131392);
        if (jSONObject == null) {
            qVar.M(i, j("fail:data is null or nil", null));
            AppMethodBeat.o(131392);
            return;
        }
        this.mAppId = qVar.getAppId();
        final AnonymousClass1 anonymousClass1 = new a() {
            public final void a(String str, com.tencent.mm.plugin.appbrand.b.b bVar) {
                AppMethodBeat.i(131386);
                if (bVar == com.tencent.mm.plugin.appbrand.b.b.BACKGROUND && b.this.mAppId.equals(str)) {
                    ab.i(b.TAG, "hy: appbrand change to background");
                    j.kzW.a(new com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a<String>() {
                        public final /* synthetic */ void a(int i, int i2, String str, Object obj) {
                            AppMethodBeat.i(131385);
                            ab.i(b.TAG, "hy: change to background and exit room");
                            AppMethodBeat.o(131385);
                        }
                    }, j.a.kBj);
                }
                AppMethodBeat.o(131386);
            }
        };
        qVar.getRuntime().gNN.a(anonymousClass1);
        try {
            String string = jSONObject.getString("signature");
            String string2 = jSONObject.getString("nonceStr");
            String string3 = jSONObject.getString("groupId");
            int i2 = jSONObject.getInt("timeStamp");
            JSONObject jSONObject2 = jSONObject.getJSONObject("muteConfig");
            final boolean optBoolean = jSONObject2.optBoolean("muteMicrophone");
            final boolean optBoolean2 = jSONObject2.optBoolean("muteEarphone");
            String appId = qVar.getAppId();
            ab.i(TAG, "hy: appId:" + appId + ",signature:" + string + ",nonceStr:" + string2 + ",groupId:" + string3 + ",muteMicroPhone:" + optBoolean + ",muteEarPhone:" + optBoolean2);
            this.hTe = 0;
            this.hTd = bo.yz();
            dU(false);
            j jVar = j.kzW;
            final q qVar2 = qVar;
            final int i3 = i;
            AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a>>() {
                @SuppressLint({"DefaultLocale"})
                public final /* synthetic */ void a(int i, int i2, String str, Object obj) {
                    AppMethodBeat.i(131387);
                    ArrayList arrayList = (ArrayList) obj;
                    long az = bo.az(b.this.hTd);
                    ab.i(b.TAG, "hy: join result result %d, %d, %s, %s, using %d ms", Integer.valueOf(i), Integer.valueOf(i2), str, arrayList, Long.valueOf(az));
                    h.pYm.e(16092, b.this.mAppId, Integer.valueOf(i2), Long.valueOf(az));
                    if (i == 0 && i2 == 0) {
                        b.this.hTd = bo.yz();
                        b.this.dU(!optBoolean);
                        j.kzW.a(optBoolean2, null);
                        j.kzW.b(optBoolean, null);
                        h.pYm.k(935, 0, 1);
                        Map n = b.n(arrayList);
                        b.b(n, b.dc(i, i2));
                        qVar2.M(i3, b.this.j("ok", n));
                        AppMethodBeat.o(131387);
                        return;
                    }
                    h.pYm.k(935, 1, 1);
                    HashMap hashMap = new HashMap();
                    b.b(hashMap, b.dc(i, i2));
                    qVar2.M(i3, b.this.j(String.format("fail: %d, %d, %s, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(j.kzW.kAs)}), hashMap));
                    AppMethodBeat.o(131387);
                }
            };
            final q qVar3 = qVar;
            AnonymousClass3 anonymousClass3 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a<j.a>() {
                public final /* synthetic */ void a(int i, int i2, String str, Object obj) {
                    AppMethodBeat.i(131388);
                    j.a aVar = (j.a) obj;
                    long az = bo.az(b.this.hTd);
                    ab.i(b.TAG, "hy: on call interrupted! %d, %d, %s, %s, in room for %d ms", Integer.valueOf(i), Integer.valueOf(i2), str, aVar, Long.valueOf(az));
                    qVar3.getRuntime().gNN.b(anonymousClass1);
                    h.pYm.e(16094, b.this.mAppId, Integer.valueOf(aVar.bTx), Long.valueOf(az), Integer.valueOf(b.this.hTe));
                    if (aVar == j.a.kBf) {
                        ab.i(b.TAG, "hy: manually exit, ignore");
                        AppMethodBeat.o(131388);
                        return;
                    }
                    a aVar2;
                    if (aVar == j.a.kBg) {
                        h.pYm.k(935, 4, 1);
                    }
                    if (aVar == j.a.kBi) {
                        h.pYm.k(935, 5, 1);
                    }
                    if (aVar == j.a.kBk) {
                        h.pYm.k(935, 6, 1);
                    }
                    if (aVar == j.a.kBe) {
                        h.pYm.k(935, 7, 1);
                    }
                    e eVar = (e) b.this.hTa.i(qVar3);
                    d.i("MicroMsg.OpenVoice.OnVoIPChatInterruptedJsEvent", "hy: dispath reason: %s", aVar);
                    HashMap hashMap = new HashMap(2);
                    switch (com.tencent.mm.plugin.appbrand.jsapi.j.e.AnonymousClass1.hTp[aVar.ordinal()]) {
                        case 1:
                            aVar2 = new a("call interrupted due to native reason", -1000);
                            break;
                        case 2:
                            aVar2 = new a("user manually exit the call", -1000);
                            break;
                        case 3:
                            aVar2 = new a("device start failed", -1000);
                            break;
                        case 4:
                            aVar2 = new a("in comming call", -2);
                            break;
                        case 5:
                            aVar2 = new a("session update failed", -1000);
                            break;
                        case 6:
                            aVar2 = new a("current mini app entered background", -1);
                            break;
                        default:
                            aVar2 = new a("unknown reason", -1000);
                            break;
                    }
                    hashMap.put("errMsg", aVar2.hTq + ", room id: " + j.kzW.kAs);
                    hashMap.put("errCode", Integer.valueOf(aVar2.errCode));
                    hashMap.put("reason", aVar2.hTq);
                    eVar.t(hashMap).aCj();
                    AppMethodBeat.o(131388);
                }
            };
            qVar3 = qVar;
            AnonymousClass4 anonymousClass4 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a>>() {
                public final /* synthetic */ void a(int i, int i2, String str, Object obj) {
                    AppMethodBeat.i(131389);
                    ArrayList arrayList = (ArrayList) obj;
                    ab.i(b.TAG, "hy: on room member changed! %s", arrayList);
                    if (arrayList != null) {
                        b.this.hTe = Math.max(b.this.hTe, arrayList.size());
                        ab.d(b.TAG, "hy: max room member changed to %d", Integer.valueOf(b.this.hTe));
                    }
                    Map n = b.n(arrayList);
                    n.put("errCode", Integer.valueOf(0));
                    f fVar = (f) b.this.hTb.i(qVar3);
                    ab.i("MicroMsg.OpenVoice.onVoIPChatMembersChangedJsEvent", "hy: dispatch member change");
                    fVar.t(n).aCj();
                    AppMethodBeat.o(131389);
                }
            };
            qVar3 = qVar;
            AnonymousClass5 anonymousClass5 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a>>() {
                public final /* synthetic */ void a(int i, int i2, String str, Object obj) {
                    AppMethodBeat.i(131390);
                    ab.i(b.TAG, "hy: on talk member changed! %s", (ArrayList) obj);
                    Map n = b.n(r9);
                    n.put("errCode", Integer.valueOf(0));
                    g gVar = (g) b.this.hTc.i(qVar3);
                    ab.i("MicroMsg.OpenVoice.onVoIPChatMembersChangedJsEvent", "hy: speaker changed.");
                    gVar.t(n).aCj();
                    AppMethodBeat.o(131390);
                }
            };
            ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger join room. %s, %s, %s, %d, %s", appId, string, string3, Integer.valueOf(i2), string2);
            jVar.R(new com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.AnonymousClass1(appId, "wx766655dab8fe851b", string, string3, i2, string2, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5));
            ab.i(TAG, "hy: JsApiCloudVoiceJoinVoIPChat callbackId:".concat(String.valueOf(i)));
            AppMethodBeat.o(131392);
        } catch (JSONException e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            qVar.M(i, j("fail: param error!", null));
            AppMethodBeat.o(131392);
        }
    }

    static /* synthetic */ Map n(ArrayList arrayList) {
        AppMethodBeat.i(131393);
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        if (!bo.ek(arrayList)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a) it.next()).openId);
            }
        }
        hashMap.put("openIdList", arrayList2);
        AppMethodBeat.o(131393);
        return hashMap;
    }

    static /* synthetic */ int dc(int i, int i2) {
        if (i == -10086 || i == -10087) {
            switch (i2) {
                case -9:
                    return -3;
                case -7:
                    return -2;
                case -1:
                    return -1;
                case 0:
                    return 0;
            }
        }
        return -1000;
    }

    static /* synthetic */ void b(Map map, int i) {
        AppMethodBeat.i(131394);
        map.put("errCode", Integer.valueOf(i));
        AppMethodBeat.o(131394);
    }
}
