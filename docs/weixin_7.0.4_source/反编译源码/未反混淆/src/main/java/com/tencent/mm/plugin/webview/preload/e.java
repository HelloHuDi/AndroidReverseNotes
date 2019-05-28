package com.tencent.mm.plugin.webview.preload;

import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    private static List<String> upZ;
    private static List<String> uqa = new ArrayList();

    public interface a {
        void a(i iVar, String str, Map<String, Object> map);
    }

    static /* synthetic */ void aH(Map map) {
        AppMethodBeat.i(7055);
        d(map);
        AppMethodBeat.o(7055);
    }

    static {
        AppMethodBeat.i(7056);
        ArrayList arrayList = new ArrayList();
        upZ = arrayList;
        arrayList.add(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        upZ.add("updatePageAuth");
        upZ.add("notifyPageInfo");
        AppMethodBeat.o(7056);
    }

    public static boolean afb(String str) {
        AppMethodBeat.i(7049);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.TmplWebViewJsAPi", "[needProcess]function is null, err");
            AppMethodBeat.o(7049);
            return false;
        }
        boolean contains = upZ.contains(str);
        AppMethodBeat.o(7049);
        return contains;
    }

    public static boolean a(i iVar, com.tencent.mm.plugin.webview.stub.e eVar, a aVar) {
        AppMethodBeat.i(7050);
        boolean a;
        if (iVar.uIJ.equals(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID)) {
            a = a(iVar, aVar);
            AppMethodBeat.o(7050);
            return a;
        } else if (iVar.uIJ.equals("updatePageAuth")) {
            a = b(iVar, eVar, aVar);
            AppMethodBeat.o(7050);
            return a;
        } else if (iVar.uIJ.equals("notifyPageInfo")) {
            a = c(iVar, eVar, aVar);
            AppMethodBeat.o(7050);
            return a;
        } else {
            aVar.a(iVar, iVar.uIJ + ":fail", null);
            AppMethodBeat.o(7050);
            return true;
        }
    }

    private static boolean a(i iVar, a aVar) {
        AppMethodBeat.i(7051);
        a.kT(70);
        String bc = bo.bc((String) iVar.puc.get("key_request_full_url_query"), "");
        if (!bo.isNullOrNil(bc)) {
            bc = String.format("&wx_header=1&pass_ticket=%s", new Object[]{bc});
        }
        final String str = iVar.puc.get("url") + bc;
        final String bc2 = bo.bc((String) iVar.puc.get(b.METHOD), "GET");
        String bc3 = bo.bc((String) iVar.puc.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER), "");
        final String str2 = (String) iVar.puc.get("data");
        ab.i("MicroMsg.TmplWebViewJsAPi", "[doRequest]url:%s", str);
        bc = bo.bc((String) iVar.puc.get("key_request_header"), "");
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
            ab.c("MicroMsg.TmplWebViewJsAPi", "", e);
        }
        ab.d("MicroMsg.TmplWebViewJsAPi", "[doRequest]url:%s, method:%s, header:%s, data:%s", str, bc2, bc3, str2);
        final a aVar2 = aVar;
        final i iVar2 = iVar;
        com.tencent.mm.plugin.webview.a.a.R(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.webview.preload.d.a a;
                AppMethodBeat.i(7047);
                if (bc2.toUpperCase().equals("POST")) {
                    a = d.a(str, hashMap, str2);
                } else {
                    a = d.w(str, hashMap);
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
                    ab.i(str, str2, objArr);
                    ab.v("MicroMsg.TmplWebViewJsAPi", "[doRequest]resonse header:%s data:%s", a.ipC, a.data);
                    a.kT(71);
                    HashMap hashMap = new HashMap();
                    hashMap.put("statusCode", Integer.valueOf(a.statusCode));
                    hashMap.put("data", a.data);
                    if (a.ipC != null && a.ipC.size() > 0) {
                        e.aH(a.ipC);
                        hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, new JSONObject(a.ipC).toString());
                    }
                    ab.i("MicroMsg.TmplWebViewJsAPi", "[doRequest]values success");
                    ab.d("MicroMsg.TmplWebViewJsAPi", "[doRequest]values:%s", hashMap);
                    aVar2.a(iVar2, iVar2.uIJ + ":ok", hashMap);
                    AppMethodBeat.o(7047);
                    return;
                }
                a.kT(72);
                ab.i("MicroMsg.TmplWebViewJsAPi", "[doRequest]resonse is null, return");
                aVar2.a(iVar2, iVar2.uIJ + ":fail", null);
                AppMethodBeat.o(7047);
            }
        });
        AppMethodBeat.o(7051);
        return true;
    }

    private static void d(Map map) {
        AppMethodBeat.i(7052);
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                d((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
        AppMethodBeat.o(7052);
    }

    private static boolean b(i iVar, com.tencent.mm.plugin.webview.stub.e eVar, a aVar) {
        AppMethodBeat.i(7053);
        a.kT(80);
        if (eVar == null) {
            ab.e("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth] callbacker is null, err");
            a.kT(82);
            aVar.a(iVar, "updatePageAuth:fail", null);
            AppMethodBeat.o(7053);
            return false;
        }
        try {
            Bundle g = eVar.g(90003, null);
            if (g != null) {
                String string = g.getString("geta8key_data_req_url");
                if (uqa.contains(string)) {
                    ab.e("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth] updatePageAuth fail, url:%s already run");
                    aVar.a(iVar, "updatePageAuth:fail updating", null);
                    a.kT(82);
                    AppMethodBeat.o(7053);
                    return false;
                }
                uqa.add(string);
                m hVar = new h(string, g.getString("geta8key_data_username"), g.getInt("geta8key_data_scene"), g.getInt("geta8key_data_reason"), g.getInt("geta8key_data_flag"), g.getString("geta8key_data_net_type"), g.getInt("geta8key_session_id", 0), g.getString("geta8key_data_appid"), g.getString("key_function_id"), g.getInt("key_wallet_region", 0), g.getByteArray("k_a8key_cookie"));
                final String str = string;
                final m mVar = hVar;
                final a aVar2 = aVar;
                final i iVar2 = iVar;
                final com.tencent.mm.plugin.webview.stub.e eVar2 = eVar;
                g.Rg().a((int) d.MIC_PTU_MEISHI, new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(7048);
                        g.Rg().b((int) d.MIC_PTU_MEISHI, (f) this);
                        e.uqa.remove(str);
                        ab.i("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth]errType:%d, errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        String aiT = mVar.aiT();
                        if (bo.isNullOrNil(aiT)) {
                            ab.e("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth] fail fullurl is null");
                            a.kT(82);
                            aVar2.a(iVar2, iVar2.uIJ + ":fail", null);
                            AppMethodBeat.o(7048);
                        } else if (i == 0 && i2 == 0) {
                            try {
                                Bundle bundle = new Bundle();
                                bundle.putString("geta8key_result_req_url", mVar.aiU());
                                bundle.putString("geta8key_result_full_url", aiT);
                                List<atp> aja = mVar.aja();
                                if (!bo.ek(aja)) {
                                    atp atp;
                                    Object obj;
                                    for (atp atp2 : aja) {
                                        if (atp2 != null && !bo.isNullOrNil(atp2.vMU)) {
                                            if (bo.isNullOrNil(atp2.pXM)) {
                                                ab.e("MicroMsg.TmplWebViewJsAPi", "http header has null value");
                                                obj = 1;
                                                break;
                                            }
                                        }
                                        ab.e("MicroMsg.TmplWebViewJsAPi", "http header has null value");
                                        obj = 1;
                                        break;
                                    }
                                    obj = null;
                                    if (obj == null) {
                                        String[] strArr = new String[aja.size()];
                                        String[] strArr2 = new String[aja.size()];
                                        for (int i3 = 0; i3 < aja.size(); i3++) {
                                            atp2 = (atp) aja.get(i3);
                                            ab.i("MicroMsg.TmplWebViewJsAPi", "http header index = %d, key = %s, value = %s", Integer.valueOf(i3), atp2.vMU, atp2.pXM);
                                            strArr[i3] = r7;
                                            strArr2[i3] = r0;
                                        }
                                        bundle.putStringArray("geta8key_result_http_header_key_list", strArr);
                                        bundle.putStringArray("geta8key_result_http_header_value_list", strArr2);
                                    }
                                }
                                eVar2.g(90004, bundle);
                            } catch (RemoteException e) {
                                ab.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", e, "", new Object[0]);
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("fullUrl", aiT);
                            ab.i("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth]values:%s", hashMap);
                            a.kT(81);
                            aVar2.a(iVar2, iVar2.uIJ + ":ok", hashMap);
                            AppMethodBeat.o(7048);
                        } else {
                            a.kT(82);
                            aVar2.a(iVar2, iVar2.uIJ + ":fail", null);
                            AppMethodBeat.o(7048);
                        }
                    }
                });
                g.Rg().a(hVar, 0);
                AppMethodBeat.o(7053);
                return true;
            }
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", e, "", new Object[0]);
        }
        a.kT(82);
        aVar.a(iVar, "updatePageAuth:fail", null);
        AppMethodBeat.o(7053);
        return false;
    }

    private static boolean c(i iVar, com.tencent.mm.plugin.webview.stub.e eVar, a aVar) {
        AppMethodBeat.i(7054);
        if (eVar == null) {
            ab.e("MicroMsg.TmplWebViewJsAPi", "[notifyPageInfo] callbacker is null, err");
            aVar.a(iVar, "notifyPageInfo:fail", null);
            a.kT(91);
            AppMethodBeat.o(7054);
        } else {
            try {
                Bundle bundle = new Bundle();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("performance", (String) iVar.puc.get("performance"));
                jSONObject.put("injectPageDataResult", (String) iVar.puc.get("injectPageDataResult"));
                bundle.putString(com.tencent.mm.ui.e.m.ygh, jSONObject.toString());
                eVar.g(90005, bundle);
                aVar.a(iVar, "notifyPageInfo:ok", null);
                a.kT(90);
                AppMethodBeat.o(7054);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", e, "", new Object[0]);
                aVar.a(iVar, "notifyPageInfo:fail", null);
                a.kT(91);
                AppMethodBeat.o(7054);
                return false;
            } catch (RemoteException e2) {
                ab.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", e2, "", new Object[0]);
                aVar.a(iVar, "notifyPageInfo:fail", null);
                a.kT(91);
                AppMethodBeat.o(7054);
                return false;
            }
        }
        return false;
    }
}
