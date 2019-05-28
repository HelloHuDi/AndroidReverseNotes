package com.tencent.p177mm.plugin.webview.luggage.p1141a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p940b.C33903a.C11501b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.a.b */
public final class C22811b {
    public static C11501b ukQ;

    /* renamed from: com.tencent.mm.plugin.webview.luggage.a.b$1 */
    public static class C169251 implements C11501b {
        /* renamed from: E */
        public final void mo23220E(int i, long j) {
            AppMethodBeat.m2504i(6421);
            C42911a hv;
            JSONObject jSONObject;
            Bundle bundle;
            switch (i) {
                case 1:
                    hv = C2895c.m5147hv(j);
                    if (hv != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("appid", hv.field_appId);
                            jSONObject.put("download_id", hv.field_downloadId);
                            jSONObject.put("state", "download_start");
                            bundle = new Bundle();
                            bundle.putString("name", "wxdownload:state_change");
                            bundle.putString("data", jSONObject.toString());
                            ToolsProcessIPCService.m63913a(bundle, C29775a.class, null);
                            AppMethodBeat.m2505o(6421);
                            return;
                        } catch (JSONException e) {
                        }
                    }
                    AppMethodBeat.m2505o(6421);
                    return;
                case 2:
                    hv = C2895c.m5147hv(j);
                    if (hv != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("appid", hv.field_appId);
                            jSONObject.put("download_id", hv.field_downloadId);
                            if (hv.field_fromDownloadApp && hv.field_downloadInWifi && !C5023at.isWifi(C4996ah.getContext())) {
                                jSONObject.put("state", "download_wait_for_wifi");
                            } else {
                                jSONObject.put("state", "download_pause");
                            }
                            bundle = new Bundle();
                            bundle.putString("name", "wxdownload:state_change");
                            bundle.putString("data", jSONObject.toString());
                            ToolsProcessIPCService.m63913a(bundle, C29775a.class, null);
                            AppMethodBeat.m2505o(6421);
                            return;
                        } catch (JSONException e2) {
                        }
                    }
                    AppMethodBeat.m2505o(6421);
                    return;
                case 3:
                    hv = C2895c.m5147hv(j);
                    if (hv != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("appid", hv.field_appId);
                            jSONObject.put("download_id", hv.field_downloadId);
                            jSONObject.put("state", "download_succ");
                            bundle = new Bundle();
                            bundle.putString("name", "wxdownload:state_change");
                            bundle.putString("data", jSONObject.toString());
                            ToolsProcessIPCService.m63913a(bundle, C29775a.class, null);
                            AppMethodBeat.m2505o(6421);
                            return;
                        } catch (JSONException e3) {
                        }
                    }
                    AppMethodBeat.m2505o(6421);
                    return;
                case 4:
                    hv = C2895c.m5147hv(j);
                    if (hv != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("appid", hv.field_appId);
                            jSONObject.put("download_id", hv.field_downloadId);
                            jSONObject.put("state", "download_removed");
                            bundle = new Bundle();
                            bundle.putString("name", "wxdownload:state_change");
                            bundle.putString("data", jSONObject.toString());
                            ToolsProcessIPCService.m63913a(bundle, C29775a.class, null);
                            AppMethodBeat.m2505o(6421);
                            return;
                        } catch (JSONException e4) {
                        }
                    }
                    AppMethodBeat.m2505o(6421);
                    return;
                case 5:
                    hv = C2895c.m5147hv(j);
                    if (hv != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("appid", hv.field_appId);
                            jSONObject.put("download_id", hv.field_downloadId);
                            jSONObject.put("state", "download_fail");
                            bundle = new Bundle();
                            bundle.putString("name", "wxdownload:state_change");
                            bundle.putString("data", jSONObject.toString());
                            ToolsProcessIPCService.m63913a(bundle, C29775a.class, null);
                            AppMethodBeat.m2505o(6421);
                            return;
                        } catch (JSONException e5) {
                        }
                    }
                    AppMethodBeat.m2505o(6421);
                    return;
                case 6:
                    hv = C2895c.m5147hv(j);
                    if (hv != null && hv.field_totalSize != 0) {
                        int i2 = (int) ((((double) hv.field_downloadedSize) / ((double) hv.field_totalSize)) * 100.0d);
                        C4990ab.m7411d("MicroMsg.JsDownloadEventDispatch", "onDownloadTaskProgressChanged, progressFloat: %f", Float.valueOf((((float) hv.field_downloadedSize) / ((float) hv.field_totalSize)) * 100.0f));
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("appid", hv.field_appId);
                            jSONObject2.put("download_id", hv.field_downloadId);
                            jSONObject2.put("progress", i2);
                            jSONObject2.put("progress_float", (double) r2);
                            bundle = new Bundle();
                            bundle.putString("name", "wxdownload:progress_change");
                            bundle.putString("data", jSONObject2.toString());
                            ToolsProcessIPCService.m63913a(bundle, C29775a.class, null);
                            AppMethodBeat.m2505o(6421);
                            return;
                        } catch (JSONException e6) {
                            break;
                        }
                    }
                    C4990ab.m7420w("MicroMsg.JsDownloadEventDispatch", "loadDownloadProgress failed");
                    AppMethodBeat.m2505o(6421);
                    return;
                    break;
                case 7:
                    hv = C2895c.m5147hv(j);
                    if (hv != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("appid", hv.field_appId);
                            jSONObject.put("download_id", hv.field_downloadId);
                            jSONObject.put("state", "download_resumed");
                            bundle = new Bundle();
                            bundle.putString("name", "wxdownload:state_change");
                            bundle.putString("data", jSONObject.toString());
                            ToolsProcessIPCService.m63913a(bundle, C29775a.class, null);
                            AppMethodBeat.m2505o(6421);
                            return;
                        } catch (JSONException e7) {
                        }
                    }
                    AppMethodBeat.m2505o(6421);
                    return;
            }
            AppMethodBeat.m2505o(6421);
        }
    }
}
