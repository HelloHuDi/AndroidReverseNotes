package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class al extends bc<n> {
    public final String name() {
        return JsApiQueryDownloadTask.NAME;
    }

    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, final bc.a aVar) {
        AppMethodBeat.i(6355);
        ab.i("MicroMsg.JsApiQueryDownloadTask", "invokeInMM");
        try {
            final JSONObject jSONObject = new JSONObject(str);
            com.tencent.mm.ce.a.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(6354);
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
                            al.b(hm, aVar);
                            AppMethodBeat.o(6354);
                            return;
                        } else if (bo.isNullOrNil(optString)) {
                            aVar.d("fail", null);
                            AppMethodBeat.o(6354);
                            return;
                        } else {
                            hm = d.bij().Ir(optString);
                            if (hm == null) {
                                hm = new FileDownloadTaskInfo();
                            }
                            al.b(hm, aVar);
                            AppMethodBeat.o(6354);
                            return;
                        }
                    }
                    al.b(optJSONArray, aVar);
                    AppMethodBeat.o(6354);
                }
            });
            AppMethodBeat.o(6355);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiQueryDownloadTask", "paras data error: " + e.getMessage());
            aVar.d("fail", null);
            AppMethodBeat.o(6355);
        }
    }

    private static void a(JSONObject jSONObject, LinkedList<String> linkedList) {
        AppMethodBeat.i(6356);
        if (bo.ek(linkedList)) {
            AppMethodBeat.o(6356);
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
        AppMethodBeat.o(6356);
    }
}
