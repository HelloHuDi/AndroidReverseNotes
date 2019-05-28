package com.tencent.p177mm.plugin.appbrand.jsapi.p309j;

import android.annotation.SuppressLint;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C41234e.C2297a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C41234e.C333311;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c.C10137a;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p1480b.C33829a;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C33836j;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C33836j.C33839a;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C33836j.C338441;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C45814a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.j.b */
public final class C38314b extends C33330d {
    public static final int CTRL_INDEX = 516;
    public static final String NAME = "joinVoIPChat";
    private static String TAG = "MicroMsg.OpenVoice.JsApiCloudVoiceJoinVoIPChat";
    private C41234e hTa = new C41234e();
    private C33332f hTb = new C33332f();
    private C19403g hTc = new C19403g();
    private long hTd = -1;
    private int hTe = 0;
    private String mAppId = "";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.j.b$1 */
    class C104391 implements C10137a {

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.j.b$1$1 */
        class C104401 implements C45814a<String> {
            C104401() {
            }

            /* renamed from: a */
            public final /* synthetic */ void mo6170a(int i, int i2, String str, Object obj) {
                AppMethodBeat.m2504i(131385);
                C4990ab.m7416i(C38314b.TAG, "hy: change to background and exit room");
                AppMethodBeat.m2505o(131385);
            }
        }

        C104391() {
        }

        /* renamed from: a */
        public final void mo6006a(String str, C45524b c45524b) {
            AppMethodBeat.m2504i(131386);
            if (c45524b == C45524b.BACKGROUND && C38314b.this.mAppId.equals(str)) {
                C4990ab.m7416i(C38314b.TAG, "hy: appbrand change to background");
                C33836j.kzW.mo54394a(new C104401(), C33839a.kBj);
            }
            AppMethodBeat.m2505o(131386);
        }
    }

    public C38314b() {
        AppMethodBeat.m2504i(131391);
        AppMethodBeat.m2505o(131391);
    }

    /* renamed from: b */
    public final void mo6169b(C38492q c38492q, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131392);
        if (jSONObject == null) {
            c38492q.mo6107M(i, mo73394j("fail:data is null or nil", null));
            AppMethodBeat.m2505o(131392);
            return;
        }
        this.mAppId = c38492q.getAppId();
        final C104391 c104391 = new C104391();
        c38492q.getRuntime().gNN.mo21486a(c104391);
        try {
            String string = jSONObject.getString("signature");
            String string2 = jSONObject.getString("nonceStr");
            String string3 = jSONObject.getString("groupId");
            int i2 = jSONObject.getInt("timeStamp");
            JSONObject jSONObject2 = jSONObject.getJSONObject("muteConfig");
            final boolean optBoolean = jSONObject2.optBoolean("muteMicrophone");
            final boolean optBoolean2 = jSONObject2.optBoolean("muteEarphone");
            String appId = c38492q.getAppId();
            C4990ab.m7416i(TAG, "hy: appId:" + appId + ",signature:" + string + ",nonceStr:" + string2 + ",groupId:" + string3 + ",muteMicroPhone:" + optBoolean + ",muteEarPhone:" + optBoolean2);
            this.hTe = 0;
            this.hTd = C5046bo.m7588yz();
            mo53837dU(false);
            C33836j c33836j = C33836j.kzW;
            final C38492q c38492q2 = c38492q;
            final int i3 = i;
            C270082 c270082 = new C45814a<ArrayList<C33829a>>() {
                @SuppressLint({"DefaultLocale"})
                /* renamed from: a */
                public final /* synthetic */ void mo6170a(int i, int i2, String str, Object obj) {
                    AppMethodBeat.m2504i(131387);
                    ArrayList arrayList = (ArrayList) obj;
                    long az = C5046bo.m7525az(C38314b.this.hTd);
                    C4990ab.m7417i(C38314b.TAG, "hy: join result result %d, %d, %s, %s, using %d ms", Integer.valueOf(i), Integer.valueOf(i2), str, arrayList, Long.valueOf(az));
                    C7060h.pYm.mo8381e(16092, C38314b.this.mAppId, Integer.valueOf(i2), Long.valueOf(az));
                    if (i == 0 && i2 == 0) {
                        C38314b.this.hTd = C5046bo.m7588yz();
                        C38314b.this.mo53837dU(!optBoolean);
                        C33836j.kzW.mo54395a(optBoolean2, null);
                        C33836j.kzW.mo54396b(optBoolean, null);
                        C7060h.pYm.mo15419k(935, 0, 1);
                        Map n = C38314b.m64850n(arrayList);
                        C38314b.m64844b(n, C38314b.m64847dc(i, i2));
                        c38492q2.mo6107M(i3, C38314b.this.mo73394j("ok", n));
                        AppMethodBeat.m2505o(131387);
                        return;
                    }
                    C7060h.pYm.mo15419k(935, 1, 1);
                    HashMap hashMap = new HashMap();
                    C38314b.m64844b(hashMap, C38314b.m64847dc(i, i2));
                    c38492q2.mo6107M(i3, C38314b.this.mo73394j(String.format("fail: %d, %d, %s, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(C33836j.kzW.kAs)}), hashMap));
                    AppMethodBeat.m2505o(131387);
                }
            };
            final C38492q c38492q3 = c38492q;
            C194023 c194023 = new C45814a<C33839a>() {
                /* renamed from: a */
                public final /* synthetic */ void mo6170a(int i, int i2, String str, Object obj) {
                    AppMethodBeat.m2504i(131388);
                    C33839a c33839a = (C33839a) obj;
                    long az = C5046bo.m7525az(C38314b.this.hTd);
                    C4990ab.m7417i(C38314b.TAG, "hy: on call interrupted! %d, %d, %s, %s, in room for %d ms", Integer.valueOf(i), Integer.valueOf(i2), str, c33839a, Long.valueOf(az));
                    c38492q3.getRuntime().gNN.mo21488b(c104391);
                    C7060h.pYm.mo8381e(16094, C38314b.this.mAppId, Integer.valueOf(c33839a.bTx), Long.valueOf(az), Integer.valueOf(C38314b.this.hTe));
                    if (c33839a == C33839a.kBf) {
                        C4990ab.m7416i(C38314b.TAG, "hy: manually exit, ignore");
                        AppMethodBeat.m2505o(131388);
                        return;
                    }
                    C2297a c2297a;
                    if (c33839a == C33839a.kBg) {
                        C7060h.pYm.mo15419k(935, 4, 1);
                    }
                    if (c33839a == C33839a.kBi) {
                        C7060h.pYm.mo15419k(935, 5, 1);
                    }
                    if (c33839a == C33839a.kBk) {
                        C7060h.pYm.mo15419k(935, 6, 1);
                    }
                    if (c33839a == C33839a.kBe) {
                        C7060h.pYm.mo15419k(935, 7, 1);
                    }
                    C41234e c41234e = (C41234e) C38314b.this.hTa.mo61031i(c38492q3);
                    C45124d.m82930i("MicroMsg.OpenVoice.OnVoIPChatInterruptedJsEvent", "hy: dispath reason: %s", c33839a);
                    HashMap hashMap = new HashMap(2);
                    switch (C333311.hTp[c33839a.ordinal()]) {
                        case 1:
                            c2297a = new C2297a("call interrupted due to native reason", -1000);
                            break;
                        case 2:
                            c2297a = new C2297a("user manually exit the call", -1000);
                            break;
                        case 3:
                            c2297a = new C2297a("device start failed", -1000);
                            break;
                        case 4:
                            c2297a = new C2297a("in comming call", -2);
                            break;
                        case 5:
                            c2297a = new C2297a("session update failed", -1000);
                            break;
                        case 6:
                            c2297a = new C2297a("current mini app entered background", -1);
                            break;
                        default:
                            c2297a = new C2297a("unknown reason", -1000);
                            break;
                    }
                    hashMap.put("errMsg", c2297a.hTq + ", room id: " + C33836j.kzW.kAs);
                    hashMap.put("errCode", Integer.valueOf(c2297a.errCode));
                    hashMap.put("reason", c2297a.hTq);
                    c41234e.mo34958t(hashMap).aCj();
                    AppMethodBeat.m2505o(131388);
                }
            };
            c38492q3 = c38492q;
            C383154 c383154 = new C45814a<ArrayList<C33829a>>() {
                /* renamed from: a */
                public final /* synthetic */ void mo6170a(int i, int i2, String str, Object obj) {
                    AppMethodBeat.m2504i(131389);
                    ArrayList arrayList = (ArrayList) obj;
                    C4990ab.m7417i(C38314b.TAG, "hy: on room member changed! %s", arrayList);
                    if (arrayList != null) {
                        C38314b.this.hTe = Math.max(C38314b.this.hTe, arrayList.size());
                        C4990ab.m7411d(C38314b.TAG, "hy: max room member changed to %d", Integer.valueOf(C38314b.this.hTe));
                    }
                    Map n = C38314b.m64850n(arrayList);
                    n.put("errCode", Integer.valueOf(0));
                    C33332f c33332f = (C33332f) C38314b.this.hTb.mo61031i(c38492q3);
                    C4990ab.m7416i("MicroMsg.OpenVoice.onVoIPChatMembersChangedJsEvent", "hy: dispatch member change");
                    c33332f.mo34958t(n).aCj();
                    AppMethodBeat.m2505o(131389);
                }
            };
            c38492q3 = c38492q;
            C383135 c383135 = new C45814a<ArrayList<C33829a>>() {
                /* renamed from: a */
                public final /* synthetic */ void mo6170a(int i, int i2, String str, Object obj) {
                    AppMethodBeat.m2504i(131390);
                    C4990ab.m7417i(C38314b.TAG, "hy: on talk member changed! %s", (ArrayList) obj);
                    Map n = C38314b.m64850n(r9);
                    n.put("errCode", Integer.valueOf(0));
                    C19403g c19403g = (C19403g) C38314b.this.hTc.mo61031i(c38492q3);
                    C4990ab.m7416i("MicroMsg.OpenVoice.onVoIPChatMembersChangedJsEvent", "hy: speaker changed.");
                    c19403g.mo34958t(n).aCj();
                    AppMethodBeat.m2505o(131390);
                }
            };
            C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger join room. %s, %s, %s, %d, %s", appId, string, string3, Integer.valueOf(i2), string2);
            c33836j.mo54393R(new C338441(appId, "wx766655dab8fe851b", string, string3, i2, string2, c270082, c194023, c383154, c383135));
            C4990ab.m7416i(TAG, "hy: JsApiCloudVoiceJoinVoIPChat callbackId:".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(131392);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            c38492q.mo6107M(i, mo73394j("fail: param error!", null));
            AppMethodBeat.m2505o(131392);
        }
    }

    /* renamed from: n */
    static /* synthetic */ Map m64850n(ArrayList arrayList) {
        AppMethodBeat.m2504i(131393);
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        if (!C5046bo.m7548ek(arrayList)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((C33829a) it.next()).openId);
            }
        }
        hashMap.put("openIdList", arrayList2);
        AppMethodBeat.m2505o(131393);
        return hashMap;
    }

    /* renamed from: dc */
    static /* synthetic */ int m64847dc(int i, int i2) {
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

    /* renamed from: b */
    static /* synthetic */ void m64844b(Map map, int i) {
        AppMethodBeat.m2504i(131394);
        map.put("errCode", Integer.valueOf(i));
        AppMethodBeat.m2505o(131394);
    }
}
