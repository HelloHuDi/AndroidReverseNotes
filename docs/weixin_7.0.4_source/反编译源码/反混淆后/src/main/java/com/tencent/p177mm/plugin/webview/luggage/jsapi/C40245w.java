package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.downloader.p943h.C33913a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.pluginsdk.permission.C14900a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.w */
public class C40245w extends C22840bc<C17821n> {
    public final String name() {
        return JsApiInstallDownloadTask.NAME;
    }

    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, final C22841a c22841a) {
        AppMethodBeat.m2504i(6319);
        C4990ab.m7416i("MicroMsg.JsApiInstallDownloadTask", "invokeInOwn");
        try {
            long optLong = new JSONObject(str).optLong("download_id");
            if (optLong <= 0) {
                C4990ab.m7416i("MicroMsg.JsApiInstallDownloadTask", "data is null");
                c22841a.mo26722d("fail_invalid_data", null);
                AppMethodBeat.m2505o(6319);
                return;
            }
            FileDownloadTaskInfo hm = C2896d.bij().mo7048hm(optLong);
            if (hm.status == -1) {
                C4990ab.m7412e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, apilevel not supported");
                c22841a.mo26722d("fail", null);
                AppMethodBeat.m2505o(6319);
            } else if (hm.status != 3) {
                C4990ab.m7412e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, invalid status = " + hm.status);
                c22841a.mo26722d("fail", null);
                AppMethodBeat.m2505o(6319);
            } else {
                C33913a.m55499a(hm.f16167id, false, new C14900a() {
                    /* renamed from: dT */
                    public final void mo9734dT(boolean z) {
                        AppMethodBeat.m2504i(6318);
                        if (z) {
                            c22841a.mo26722d(null, null);
                            AppMethodBeat.m2505o(6318);
                            return;
                        }
                        c22841a.mo26722d("fail", null);
                        AppMethodBeat.m2505o(6318);
                    }
                });
                AppMethodBeat.m2505o(6319);
            }
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiInstallDownloadTask", "paras data error: " + e.getMessage());
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6319);
        }
    }
}
