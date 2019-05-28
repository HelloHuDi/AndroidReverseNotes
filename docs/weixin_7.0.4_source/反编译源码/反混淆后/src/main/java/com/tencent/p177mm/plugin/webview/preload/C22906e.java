package com.tencent.p177mm.plugin.webview.preload;

import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C6681h;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5510e.C5506m;
import com.tencent.p177mm.plugin.webview.p1562a.C40211a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i;
import com.tencent.p177mm.plugin.webview.preload.C43927d.C4560a;
import com.tencent.p177mm.plugin.webview.stub.C40281e;
import com.tencent.p177mm.protocal.protobuf.atp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.preload.e */
public final class C22906e {
    private static List<String> upZ;
    private static List<String> uqa = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.webview.preload.e$a */
    public interface C22908a {
        /* renamed from: a */
        void mo38486a(C29945i c29945i, String str, Map<String, Object> map);
    }

    /* renamed from: aH */
    static /* synthetic */ void m34758aH(Map map) {
        AppMethodBeat.m2504i(7055);
        C22906e.m34761d(map);
        AppMethodBeat.m2505o(7055);
    }

    static {
        AppMethodBeat.m2504i(7056);
        ArrayList arrayList = new ArrayList();
        upZ = arrayList;
        arrayList.add(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        upZ.add("updatePageAuth");
        upZ.add("notifyPageInfo");
        AppMethodBeat.m2505o(7056);
    }

    public static boolean afb(String str) {
        AppMethodBeat.m2504i(7049);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.TmplWebViewJsAPi", "[needProcess]function is null, err");
            AppMethodBeat.m2505o(7049);
            return false;
        }
        boolean contains = upZ.contains(str);
        AppMethodBeat.m2505o(7049);
        return contains;
    }

    /* renamed from: a */
    public static boolean m34757a(C29945i c29945i, C40281e c40281e, C22908a c22908a) {
        AppMethodBeat.m2504i(7050);
        boolean a;
        if (c29945i.uIJ.equals(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID)) {
            a = C22906e.m34756a(c29945i, c22908a);
            AppMethodBeat.m2505o(7050);
            return a;
        } else if (c29945i.uIJ.equals("updatePageAuth")) {
            a = C22906e.m34759b(c29945i, c40281e, c22908a);
            AppMethodBeat.m2505o(7050);
            return a;
        } else if (c29945i.uIJ.equals("notifyPageInfo")) {
            a = C22906e.m34760c(c29945i, c40281e, c22908a);
            AppMethodBeat.m2505o(7050);
            return a;
        } else {
            c22908a.mo38486a(c29945i, c29945i.uIJ + ":fail", null);
            AppMethodBeat.m2505o(7050);
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m34756a(C29945i c29945i, C22908a c22908a) {
        AppMethodBeat.m2504i(7051);
        C43924a.m78793kT(70);
        String bc = C5046bo.m7532bc((String) c29945i.puc.get("key_request_full_url_query"), "");
        if (!C5046bo.isNullOrNil(bc)) {
            bc = String.format("&wx_header=1&pass_ticket=%s", new Object[]{bc});
        }
        final String str = c29945i.puc.get("url") + bc;
        final String bc2 = C5046bo.m7532bc((String) c29945i.puc.get(C8741b.METHOD), "GET");
        String bc3 = C5046bo.m7532bc((String) c29945i.puc.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER), "");
        final String str2 = (String) c29945i.puc.get("data");
        C4990ab.m7417i("MicroMsg.TmplWebViewJsAPi", "[doRequest]url:%s", str);
        bc = C5046bo.m7532bc((String) c29945i.puc.get("key_request_header"), "");
        final HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(bc);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                bc = (String) keys.next();
                hashMap.put(bc, jSONObject.optString(bc));
            }
            jSONObject = new JSONObject(bc3);
            keys = jSONObject.keys();
            while (keys.hasNext()) {
                bc = (String) keys.next();
                hashMap.put(bc, jSONObject.optString(bc));
            }
        } catch (JSONException e) {
            C4990ab.m7409c("MicroMsg.TmplWebViewJsAPi", "", e);
        }
        C4990ab.m7411d("MicroMsg.TmplWebViewJsAPi", "[doRequest]url:%s, method:%s, header:%s, data:%s", str, bc2, bc3, str2);
        final C22908a c22908a2 = c22908a;
        final C29945i c29945i2 = c29945i;
        C40211a.m68966R(new Runnable() {
            public final void run() {
                C4560a a;
                AppMethodBeat.m2504i(7047);
                if (bc2.toUpperCase().equals("POST")) {
                    a = C43927d.m78796a(str, hashMap, str2);
                } else {
                    a = C43927d.m78798w(str, hashMap);
                }
                if (a != null) {
                    int size;
                    String str = "MicroMsg.TmplWebViewJsAPi";
                    String str2 = "[doRequest]resonse stats:%d, header.size:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(a.statusCode);
                    if (a.ipC != null) {
                        size = a.ipC.size();
                    } else {
                        size = 0;
                    }
                    objArr[1] = Integer.valueOf(size);
                    C4990ab.m7417i(str, str2, objArr);
                    C4990ab.m7419v("MicroMsg.TmplWebViewJsAPi", "[doRequest]resonse header:%s data:%s", a.ipC, a.data);
                    C43924a.m78793kT(71);
                    HashMap hashMap = new HashMap();
                    hashMap.put("statusCode", Integer.valueOf(a.statusCode));
                    hashMap.put("data", a.data);
                    if (a.ipC != null && a.ipC.size() > 0) {
                        C22906e.m34758aH(a.ipC);
                        hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, new JSONObject(a.ipC).toString());
                    }
                    C4990ab.m7416i("MicroMsg.TmplWebViewJsAPi", "[doRequest]values success");
                    C4990ab.m7411d("MicroMsg.TmplWebViewJsAPi", "[doRequest]values:%s", hashMap);
                    c22908a2.mo38486a(c29945i2, c29945i2.uIJ + ":ok", hashMap);
                    AppMethodBeat.m2505o(7047);
                    return;
                }
                C43924a.m78793kT(72);
                C4990ab.m7416i("MicroMsg.TmplWebViewJsAPi", "[doRequest]resonse is null, return");
                c22908a2.mo38486a(c29945i2, c29945i2.uIJ + ":fail", null);
                AppMethodBeat.m2505o(7047);
            }
        });
        AppMethodBeat.m2505o(7051);
        return true;
    }

    /* renamed from: d */
    private static void m34761d(Map map) {
        AppMethodBeat.m2504i(7052);
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                C22906e.m34761d((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
        AppMethodBeat.m2505o(7052);
    }

    /* renamed from: b */
    private static boolean m34759b(C29945i c29945i, C40281e c40281e, C22908a c22908a) {
        AppMethodBeat.m2504i(7053);
        C43924a.m78793kT(80);
        if (c40281e == null) {
            C4990ab.m7412e("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth] callbacker is null, err");
            C43924a.m78793kT(82);
            c22908a.mo38486a(c29945i, "updatePageAuth:fail", null);
            AppMethodBeat.m2505o(7053);
            return false;
        }
        try {
            Bundle g = c40281e.mo6226g(90003, null);
            if (g != null) {
                String string = g.getString("geta8key_data_req_url");
                if (uqa.contains(string)) {
                    C4990ab.m7412e("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth] updatePageAuth fail, url:%s already run");
                    c22908a.mo38486a(c29945i, "updatePageAuth:fail updating", null);
                    C43924a.m78793kT(82);
                    AppMethodBeat.m2505o(7053);
                    return false;
                }
                uqa.add(string);
                C1207m c6681h = new C6681h(string, g.getString("geta8key_data_username"), g.getInt("geta8key_data_scene"), g.getInt("geta8key_data_reason"), g.getInt("geta8key_data_flag"), g.getString("geta8key_data_net_type"), g.getInt("geta8key_session_id", 0), g.getString("geta8key_data_appid"), g.getString("key_function_id"), g.getInt("key_wallet_region", 0), g.getByteArray("k_a8key_cookie"));
                final String str = string;
                final C1207m c1207m = c6681h;
                final C22908a c22908a2 = c22908a;
                final C29945i c29945i2 = c29945i;
                final C40281e c40281e2 = c40281e;
                C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_MEISHI, new C1202f() {
                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(7048);
                        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_MEISHI, (C1202f) this);
                        C22906e.uqa.remove(str);
                        C4990ab.m7417i("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth]errType:%d, errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        String aiT = c1207m.aiT();
                        if (C5046bo.isNullOrNil(aiT)) {
                            C4990ab.m7412e("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth] fail fullurl is null");
                            C43924a.m78793kT(82);
                            c22908a2.mo38486a(c29945i2, c29945i2.uIJ + ":fail", null);
                            AppMethodBeat.m2505o(7048);
                        } else if (i == 0 && i2 == 0) {
                            try {
                                Bundle bundle = new Bundle();
                                bundle.putString("geta8key_result_req_url", c1207m.aiU());
                                bundle.putString("geta8key_result_full_url", aiT);
                                List<atp> aja = c1207m.aja();
                                if (!C5046bo.m7548ek(aja)) {
                                    atp atp;
                                    Object obj;
                                    for (atp atp2 : aja) {
                                        if (atp2 != null && !C5046bo.isNullOrNil(atp2.vMU)) {
                                            if (C5046bo.isNullOrNil(atp2.pXM)) {
                                                C4990ab.m7412e("MicroMsg.TmplWebViewJsAPi", "http header has null value");
                                                obj = 1;
                                                break;
                                            }
                                        }
                                        C4990ab.m7412e("MicroMsg.TmplWebViewJsAPi", "http header has null value");
                                        obj = 1;
                                        break;
                                    }
                                    obj = null;
                                    if (obj == null) {
                                        String[] strArr = new String[aja.size()];
                                        String[] strArr2 = new String[aja.size()];
                                        for (int i3 = 0; i3 < aja.size(); i3++) {
                                            atp2 = (atp) aja.get(i3);
                                            C4990ab.m7417i("MicroMsg.TmplWebViewJsAPi", "http header index = %d, key = %s, value = %s", Integer.valueOf(i3), atp2.vMU, atp2.pXM);
                                            strArr[i3] = r7;
                                            strArr2[i3] = r0;
                                        }
                                        bundle.putStringArray("geta8key_result_http_header_key_list", strArr);
                                        bundle.putStringArray("geta8key_result_http_header_value_list", strArr2);
                                    }
                                }
                                c40281e2.mo6226g(90004, bundle);
                            } catch (RemoteException e) {
                                C4990ab.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", e, "", new Object[0]);
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("fullUrl", aiT);
                            C4990ab.m7417i("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth]values:%s", hashMap);
                            C43924a.m78793kT(81);
                            c22908a2.mo38486a(c29945i2, c29945i2.uIJ + ":ok", hashMap);
                            AppMethodBeat.m2505o(7048);
                        } else {
                            C43924a.m78793kT(82);
                            c22908a2.mo38486a(c29945i2, c29945i2.uIJ + ":fail", null);
                            AppMethodBeat.m2505o(7048);
                        }
                    }
                });
                C1720g.m3540Rg().mo14541a(c6681h, 0);
                AppMethodBeat.m2505o(7053);
                return true;
            }
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", e, "", new Object[0]);
        }
        C43924a.m78793kT(82);
        c22908a.mo38486a(c29945i, "updatePageAuth:fail", null);
        AppMethodBeat.m2505o(7053);
        return false;
    }

    /* renamed from: c */
    private static boolean m34760c(C29945i c29945i, C40281e c40281e, C22908a c22908a) {
        AppMethodBeat.m2504i(7054);
        if (c40281e == null) {
            C4990ab.m7412e("MicroMsg.TmplWebViewJsAPi", "[notifyPageInfo] callbacker is null, err");
            c22908a.mo38486a(c29945i, "notifyPageInfo:fail", null);
            C43924a.m78793kT(91);
            AppMethodBeat.m2505o(7054);
        } else {
            try {
                Bundle bundle = new Bundle();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("performance", (String) c29945i.puc.get("performance"));
                jSONObject.put("injectPageDataResult", (String) c29945i.puc.get("injectPageDataResult"));
                bundle.putString(C5506m.ygh, jSONObject.toString());
                c40281e.mo6226g(90005, bundle);
                c22908a.mo38486a(c29945i, "notifyPageInfo:ok", null);
                C43924a.m78793kT(90);
                AppMethodBeat.m2505o(7054);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", e, "", new Object[0]);
                c22908a.mo38486a(c29945i, "notifyPageInfo:fail", null);
                C43924a.m78793kT(91);
                AppMethodBeat.m2505o(7054);
                return false;
            } catch (RemoteException e2) {
                C4990ab.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", e2, "", new Object[0]);
                c22908a.mo38486a(c29945i, "notifyPageInfo:fail", null);
                C43924a.m78793kT(91);
                AppMethodBeat.m2505o(7054);
                return false;
            }
        }
        return false;
    }
}
