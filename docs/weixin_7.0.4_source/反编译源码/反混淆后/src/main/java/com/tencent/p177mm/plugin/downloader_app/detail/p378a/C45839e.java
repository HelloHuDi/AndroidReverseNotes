package com.tencent.p177mm.plugin.downloader_app.detail.p378a;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.downloader_app.detail.a.e */
public class C45839e extends C22840bc {
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
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(136074);
        C4990ab.m7416i("MicroMsg.JsApiQueryDownloadTask", "invokeInMM");
        try {
            JSONObject jSONObject = new JSONObject(str);
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
                    C45839e.m84854a(hm, c22841a);
                    AppMethodBeat.m2505o(136074);
                    return;
                } else if (C5046bo.isNullOrNil(optString)) {
                    c22841a.mo26722d("fail", null);
                    AppMethodBeat.m2505o(136074);
                    return;
                } else {
                    hm = C2896d.bij().mo7040Ir(optString);
                    if (hm == null) {
                        hm = new FileDownloadTaskInfo();
                    }
                    C45839e.m84854a(hm, c22841a);
                    AppMethodBeat.m2505o(136074);
                    return;
                }
            }
            C45839e.m84855a(optJSONArray, c22841a);
            AppMethodBeat.m2505o(136074);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiQueryDownloadTask", "paras data error: " + e.getMessage());
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(136074);
        }
    }

    /* renamed from: a */
    private static void m84854a(FileDownloadTaskInfo fileDownloadTaskInfo, C22841a c22841a) {
        String str;
        AppMethodBeat.m2504i(136075);
        JSONObject jSONObject = new JSONObject();
        switch (fileDownloadTaskInfo.status) {
            case -1:
                str = "api_not_support";
                break;
            case 1:
                str = "downloading";
                break;
            case 2:
                if (fileDownloadTaskInfo.kNt && !C5023at.isWifi(C4996ah.getContext())) {
                    str = "download_wait_for_wifi";
                    break;
                } else {
                    str = "download_pause";
                    break;
                }
                break;
            case 3:
                if (!C1173e.m2561ct(fileDownloadTaskInfo.path)) {
                    str = "default";
                    break;
                } else {
                    str = "download_succ";
                    break;
                }
            case 4:
                str = "download_fail";
                break;
            default:
                str = "default";
                break;
        }
        try {
            jSONObject.put("download_id", fileDownloadTaskInfo.f16167id);
            jSONObject.put("state", str);
            if (str == "downloading" && fileDownloadTaskInfo.jrb != 0) {
                jSONObject.put("progress", (fileDownloadTaskInfo.kNr / fileDownloadTaskInfo.jrb) * 100);
            }
            c22841a.mo26722d(null, jSONObject);
            AppMethodBeat.m2505o(136075);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
            AppMethodBeat.m2505o(136075);
        }
    }

    /* renamed from: a */
    private static void m84855a(JSONArray jSONArray, C22841a c22841a) {
        AppMethodBeat.m2504i(136076);
        JSONObject jSONObject = new JSONObject();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            linkedList.add(jSONArray.optString(i));
        }
        C2896d.bij();
        LinkedList M = C2896d.m5150M(linkedList);
        JSONObject jSONObject2;
        if (M.size() > 0) {
            Iterator it = M.iterator();
            while (it.hasNext()) {
                String str;
                FileDownloadTaskInfo fileDownloadTaskInfo = (FileDownloadTaskInfo) it.next();
                JSONObject jSONObject3 = new JSONObject();
                switch (fileDownloadTaskInfo.status) {
                    case -1:
                        str = "api_not_support";
                        break;
                    case 1:
                        str = "downloading";
                        break;
                    case 2:
                        if (fileDownloadTaskInfo.kNt && !C5023at.isWifi(C4996ah.getContext())) {
                            str = "download_wait_for_wifi";
                            break;
                        } else {
                            str = "download_pause";
                            break;
                        }
                        break;
                    case 3:
                        if (!C1173e.m2561ct(fileDownloadTaskInfo.path)) {
                            str = "default";
                            break;
                        } else {
                            str = "download_succ";
                            break;
                        }
                    case 4:
                        str = "download_fail";
                        break;
                    default:
                        str = "default";
                        break;
                }
                try {
                    jSONObject3.put("download_id", fileDownloadTaskInfo.f16167id);
                    jSONObject3.put("state", str);
                    if (str == "downloading" && fileDownloadTaskInfo.jrb != 0) {
                        jSONObject3.put("progress", (fileDownloadTaskInfo.kNr / fileDownloadTaskInfo.jrb) * 100);
                    }
                    jSONObject.put(fileDownloadTaskInfo.appId, jSONObject3);
                    linkedList.remove(fileDownloadTaskInfo.appId);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
                }
            }
            C45839e.m84856a(jSONObject, linkedList);
            jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", jSONObject.toString());
            } catch (JSONException e2) {
            }
            c22841a.mo26722d(null, jSONObject2);
            AppMethodBeat.m2505o(136076);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiQueryDownloadTask", "taskInfos is null");
        C45839e.m84856a(jSONObject, linkedList);
        jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("result", jSONObject.toString());
        } catch (JSONException e3) {
        }
        c22841a.mo26722d(null, jSONObject2);
        AppMethodBeat.m2505o(136076);
    }

    /* renamed from: a */
    private static void m84856a(JSONObject jSONObject, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(136077);
        if (C5046bo.m7548ek(linkedList)) {
            AppMethodBeat.m2505o(136077);
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
        AppMethodBeat.m2505o(136077);
    }
}
