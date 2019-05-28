package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l.i;
import com.tencent.mm.plugin.appbrand.l.j;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends b {
    public static final int CTRL_INDEX = 272;
    public static final String NAME = "createUploadTask";

    public static class a extends ah {
        public static final int CTRL_INDEX = 274;
        public static final String NAME = "onUploadTaskStateChange";
    }

    public final String aBA() {
        AppMethodBeat.i(108056);
        StringBuilder stringBuilder = new StringBuilder();
        i.aIG();
        String stringBuilder2 = stringBuilder.append(i.aIA()).toString();
        AppMethodBeat.o(108056);
        return stringBuilder2;
    }

    public final String OA() {
        return "uploadTaskId";
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(c cVar, JSONObject jSONObject, String str) {
        AppMethodBeat.i(108057);
        ab.d("MicroMsg.JsApiCreateUploadTask", "JsApiCreateUploadTask");
        String appId = cVar.getAppId();
        String optString = jSONObject.optString("filePath");
        if (bo.isNullOrNil(optString)) {
            a(cVar, str, "filePath is null");
            AppMethodBeat.o(108057);
            return;
        }
        File yg = cVar.asE().yg(optString);
        if (yg == null || !yg.exists()) {
            ab.e("MicroMsg.JsApiCreateUploadTask", "upload appId(%s) tempFilePath(%s), found no real file", cVar.getAppId(), optString);
            a(cVar, str, "fail:file doesn't exist");
            AppMethodBeat.o(108057);
            return;
        }
        final String absolutePath = yg.getAbsolutePath();
        String ako = b.ako(optString);
        ab.i("MicroMsg.JsApiCreateUploadTask", "upload appId(%s) tempFilePath(%s) realFilePath(%s)", cVar.getAppId(), optString, absolutePath);
        final c cVar2 = cVar;
        final String str2 = str;
        AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.l.g.a() {
            private JSONObject hRr;
            private JSONArray hRs;

            public final void BC(String str) {
                AppMethodBeat.i(108052);
                if (g.j(cVar2, str2)) {
                    AppMethodBeat.o(108052);
                    return;
                }
                g.a(cVar2, str2, str);
                AppMethodBeat.o(108052);
            }

            public final void g(int i, String str, int i2) {
                AppMethodBeat.i(108053);
                if (i == 0) {
                    ab.d("MicroMsg.JsApiCreateUploadTask", "success: file name %s, result %s , errMsg %d", absolutePath, str, Integer.valueOf(i));
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", str);
                    hashMap.put("statusCode", Integer.valueOf(i2));
                    hashMap.put("uploadTaskId", str2);
                    hashMap.put("state", "success");
                    if (this.hRr != null) {
                        hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, this.hRr);
                    }
                    if (this.hRs != null) {
                        hashMap.put("cookies", this.hRs);
                    }
                    new a().j(cVar2).AM(new JSONObject(hashMap).toString()).aCj();
                    AppMethodBeat.o(108053);
                } else if (g.j(cVar2, str2)) {
                    AppMethodBeat.o(108053);
                } else {
                    ab.e("MicroMsg.JsApiCreateUploadTask", "error: file name %s, result %s , errMsg %d", absolutePath, str, Integer.valueOf(i));
                    g.a(cVar2, str2, str);
                    AppMethodBeat.o(108053);
                }
            }

            public final void h(int i, long j, long j2) {
                AppMethodBeat.i(108054);
                HashMap hashMap = new HashMap();
                hashMap.put("uploadTaskId", str2);
                hashMap.put("state", "progressUpdate");
                hashMap.put("progress", Integer.valueOf(i));
                hashMap.put("totalBytesSent", Long.valueOf(j));
                hashMap.put("totalBytesExpectedToSend", Long.valueOf(j2));
                new a().j(cVar2).AM(new JSONObject(hashMap).toString()).aCj();
                AppMethodBeat.o(108054);
            }

            public final void p(JSONObject jSONObject) {
                AppMethodBeat.i(108055);
                if (jSONObject == null) {
                    AppMethodBeat.o(108055);
                } else if (!jSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
                    this.hRr = jSONObject;
                    this.hRs = this.hRr.optJSONArray("cookies");
                    HashMap hashMap = new HashMap();
                    hashMap.put("uploadTaskId", str2);
                    hashMap.put("state", "headersReceived");
                    hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, this.hRr);
                    if (this.hRs != null) {
                        hashMap.put("cookies", this.hRs);
                    }
                    new a().j(cVar2).AM(new JSONObject(hashMap).toString()).aCj();
                    AppMethodBeat.o(108055);
                } else if (((com.tencent.mm.plugin.appbrand.l.a) cVar2.aa(com.tencent.mm.plugin.appbrand.l.a.class)).bQf) {
                    jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                    m mVar = new m();
                    mVar.csn.cso = "upload";
                    mVar.csn.csq = jSONObject;
                    mVar.csn.csp = str2;
                    com.tencent.mm.sdk.b.a.xxA.m(mVar);
                    AppMethodBeat.o(108055);
                } else {
                    AppMethodBeat.o(108055);
                }
            }
        };
        com.tencent.mm.plugin.appbrand.l.a aVar = (com.tencent.mm.plugin.appbrand.l.a) cVar.aa(com.tencent.mm.plugin.appbrand.l.a.class);
        Map a = j.a(jSONObject, aVar);
        String optString2 = jSONObject.optString("url");
        if (bo.isNullOrNil(optString2)) {
            ab.i("MicroMsg.JsApiCreateUploadTask", "url is null");
            a(cVar, str, "url is null or nil");
            AppMethodBeat.o(108057);
            return;
        }
        Object obj;
        boolean z;
        int optInt;
        com.tencent.mm.plugin.appbrand.l.g gVar;
        String name;
        if (aVar.ioe) {
            if (jSONObject.optBoolean("__skipDomainCheck__")) {
                obj = 1;
                z = obj == null ? false : aVar.iof;
                if (z || j.c(aVar.bQH, optString2)) {
                    if (aVar.bQx <= 0) {
                        ab.i("MicroMsg.JsApiCreateUploadTask", "concurrent <= 0 ");
                    }
                    optInt = jSONObject.optInt("timeout", 0);
                    if (optInt <= 0) {
                        optInt = j.a(aVar, 2);
                    }
                    if (optInt <= 0) {
                        optInt = 60000;
                    }
                    if (i.aIG().CO(appId) != null) {
                        gVar = new com.tencent.mm.plugin.appbrand.l.g(cVar);
                        i aIG = i.aIG();
                        if (!aIG.hGk.containsKey(appId)) {
                            aIG.hGk.put(appId, gVar);
                        }
                    } else {
                        gVar = i.aIG().CO(appId);
                    }
                    name = org.apache.commons.a.b.getName(optString);
                    if (gVar != null) {
                        ab.i("MicroMsg.JsApiCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", Boolean.valueOf(z), Integer.valueOf(optInt));
                        if (z) {
                            gVar.a(optInt, ako, absolutePath, jSONObject, a, aVar.bQH, anonymousClass1, str, NAME, name);
                        } else {
                            gVar.a(optInt, ako, absolutePath, jSONObject, a, null, anonymousClass1, str, NAME, name);
                            AppMethodBeat.o(108057);
                            return;
                        }
                    }
                    AppMethodBeat.o(108057);
                }
                ab.i("MicroMsg.JsApiCreateUploadTask", "not in domain url %s", optString2);
                a(cVar, str, "url not in domain list");
                AppMethodBeat.o(108057);
                return;
            }
        }
        obj = null;
        if (obj == null) {
        }
        if (z) {
        }
        if (aVar.bQx <= 0) {
        }
        optInt = jSONObject.optInt("timeout", 0);
        if (optInt <= 0) {
        }
        if (optInt <= 0) {
        }
        if (i.aIG().CO(appId) != null) {
        }
        name = org.apache.commons.a.b.getName(optString);
        if (gVar != null) {
        }
        AppMethodBeat.o(108057);
    }

    static void a(c cVar, String str, String str2) {
        AppMethodBeat.i(108058);
        HashMap hashMap = new HashMap();
        hashMap.put("uploadTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        new a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
        AppMethodBeat.o(108058);
    }

    static /* synthetic */ boolean j(c cVar, String str) {
        AppMethodBeat.i(108059);
        com.tencent.mm.plugin.appbrand.l.g CO = i.aIG().CO(cVar.getAppId());
        if (CO == null || !CO.CH(str)) {
            AppMethodBeat.o(108059);
            return false;
        }
        ab.i("MicroMsg.JsApiCreateUploadTask", "upload abort %s", str);
        AppMethodBeat.o(108059);
        return true;
    }
}
