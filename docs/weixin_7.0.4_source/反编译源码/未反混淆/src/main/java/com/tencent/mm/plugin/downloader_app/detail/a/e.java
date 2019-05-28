package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends bc {
    public final String name() {
        return JsApiQueryDownloadTask.NAME;
    }

    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(136074);
        ab.i("MicroMsg.JsApiQueryDownloadTask", "invokeInMM");
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("appIdArray");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                long optLong = jSONObject.optLong("download_id", -1);
                String optString = jSONObject.optString("appid");
                FileDownloadTaskInfo hm;
                if (optLong > 0) {
                    hm = d.bij().hm(optLong);
                    if (hm == null) {
                        hm = new FileDownloadTaskInfo();
                    }
                    a(hm, aVar);
                    AppMethodBeat.o(136074);
                    return;
                } else if (bo.isNullOrNil(optString)) {
                    aVar.d("fail", null);
                    AppMethodBeat.o(136074);
                    return;
                } else {
                    hm = d.bij().Ir(optString);
                    if (hm == null) {
                        hm = new FileDownloadTaskInfo();
                    }
                    a(hm, aVar);
                    AppMethodBeat.o(136074);
                    return;
                }
            }
            a(optJSONArray, aVar);
            AppMethodBeat.o(136074);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiQueryDownloadTask", "paras data error: " + e.getMessage());
            aVar.d("fail", null);
            AppMethodBeat.o(136074);
        }
    }

    private static void a(FileDownloadTaskInfo fileDownloadTaskInfo, bc.a aVar) {
        String str;
        AppMethodBeat.i(136075);
        JSONObject jSONObject = new JSONObject();
        switch (fileDownloadTaskInfo.status) {
            case -1:
                str = "api_not_support";
                break;
            case 1:
                str = "downloading";
                break;
            case 2:
                if (fileDownloadTaskInfo.kNt && !at.isWifi(ah.getContext())) {
                    str = "download_wait_for_wifi";
                    break;
                } else {
                    str = "download_pause";
                    break;
                }
                break;
            case 3:
                if (!com.tencent.mm.a.e.ct(fileDownloadTaskInfo.path)) {
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
            jSONObject.put("download_id", fileDownloadTaskInfo.id);
            jSONObject.put("state", str);
            if (str == "downloading" && fileDownloadTaskInfo.jrb != 0) {
                jSONObject.put("progress", (fileDownloadTaskInfo.kNr / fileDownloadTaskInfo.jrb) * 100);
            }
            aVar.d(null, jSONObject);
            AppMethodBeat.o(136075);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
            AppMethodBeat.o(136075);
        }
    }

    private static void a(JSONArray jSONArray, bc.a aVar) {
        AppMethodBeat.i(136076);
        JSONObject jSONObject = new JSONObject();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            linkedList.add(jSONArray.optString(i));
        }
        d.bij();
        LinkedList M = d.M(linkedList);
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
                        if (fileDownloadTaskInfo.kNt && !at.isWifi(ah.getContext())) {
                            str = "download_wait_for_wifi";
                            break;
                        } else {
                            str = "download_pause";
                            break;
                        }
                        break;
                    case 3:
                        if (!com.tencent.mm.a.e.ct(fileDownloadTaskInfo.path)) {
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
                    jSONObject3.put("download_id", fileDownloadTaskInfo.id);
                    jSONObject3.put("state", str);
                    if (str == "downloading" && fileDownloadTaskInfo.jrb != 0) {
                        jSONObject3.put("progress", (fileDownloadTaskInfo.kNr / fileDownloadTaskInfo.jrb) * 100);
                    }
                    jSONObject.put(fileDownloadTaskInfo.appId, jSONObject3);
                    linkedList.remove(fileDownloadTaskInfo.appId);
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
                }
            }
            a(jSONObject, linkedList);
            jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", jSONObject.toString());
            } catch (JSONException e2) {
            }
            aVar.d(null, jSONObject2);
            AppMethodBeat.o(136076);
            return;
        }
        ab.e("MicroMsg.JsApiQueryDownloadTask", "taskInfos is null");
        a(jSONObject, linkedList);
        jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("result", jSONObject.toString());
        } catch (JSONException e3) {
        }
        aVar.d(null, jSONObject2);
        AppMethodBeat.o(136076);
    }

    private static void a(JSONObject jSONObject, LinkedList<String> linkedList) {
        AppMethodBeat.i(136077);
        if (bo.ek(linkedList)) {
            AppMethodBeat.o(136077);
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
                ab.e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
            }
        }
        AppMethodBeat.o(136077);
    }
}
