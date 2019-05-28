package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.al */
public class C43897al extends C22840bc<C17821n> {
    public final String name() {
        return JsApiQueryDownloadTask.NAME;
    }

    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, final C22841a c22841a) {
        AppMethodBeat.m2504i(6355);
        C4990ab.m7416i("MicroMsg.JsApiQueryDownloadTask", "invokeInMM");
        try {
            final JSONObject jSONObject = new JSONObject(str);
            C26006a.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(6354);
                    JSONArray optJSONArray = jSONObject.optJSONArray("appIdArray");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        long optLong = jSONObject.optLong("download_id", -1);
                        String optString = jSONObject.optString("appid");
                        FileDownloadTaskInfo hm;
                        if (optLong > 0) {
                            hm = C2896d.bij().mo7048hm(optLong);
                            if (hm == null) {
                                hm = new FileDownloadTaskInfo();
                            }
                            C43897al.m78729b(hm, c22841a);
                            AppMethodBeat.m2505o(6354);
                            return;
                        } else if (C5046bo.isNullOrNil(optString)) {
                            c22841a.mo26722d("fail", null);
                            AppMethodBeat.m2505o(6354);
                            return;
                        } else {
                            hm = C2896d.bij().mo7040Ir(optString);
                            if (hm == null) {
                                hm = new FileDownloadTaskInfo();
                            }
                            C43897al.m78729b(hm, c22841a);
                            AppMethodBeat.m2505o(6354);
                            return;
                        }
                    }
                    C43897al.m78730b(optJSONArray, c22841a);
                    AppMethodBeat.m2505o(6354);
                }
            });
            AppMethodBeat.m2505o(6355);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiQueryDownloadTask", "paras data error: " + e.getMessage());
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6355);
        }
    }

    /* renamed from: a */
    private static void m78728a(JSONObject jSONObject, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(6356);
        if (C5046bo.m7548ek(linkedList)) {
            AppMethodBeat.m2505o(6356);
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("download_id", -1);
                jSONObject2.put("state", "default");
                jSONObject.put(str, jSONObject2);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(6356);
    }
}
