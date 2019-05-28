package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.file.ae;
import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.plugin.appbrand.l.c;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d extends b {
    public static final int CTRL_INDEX = 269;
    public static final String NAME = "createDownloadTask";

    public static class a extends ah {
        public static final int CTRL_INDEX = 271;
        public static final String NAME = "onDownloadTaskStateChange";
    }

    public final String aBA() {
        AppMethodBeat.i(108025);
        StringBuilder stringBuilder = new StringBuilder();
        c.aIB();
        String stringBuilder2 = stringBuilder.append(c.aIA()).toString();
        AppMethodBeat.o(108025);
        return stringBuilder2;
    }

    public final String OA() {
        return "downloadTaskId";
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, final String str) {
        AppMethodBeat.i(108026);
        ab.d("MicroMsg.JsApiCreateDownloadTask", "JsApiCreateDownloadTask");
        final String optString = jSONObject.optString("filePath");
        AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.l.b.a() {
            private JSONObject hRr;
            private JSONArray hRs;

            public final void c(int i, String str, String str2, int i2) {
                AppMethodBeat.i(108021);
                ab.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %s", Integer.valueOf(i), str, str2, Integer.valueOf(i2));
                String ajn;
                if (bo.isNullOrNil(optString)) {
                    if (i != b.FAILED) {
                        Object obj;
                        com.tencent.mm.plugin.appbrand.jsapi.c cVar = cVar;
                        ajn = com.tencent.mm.sdk.f.b.ajn(str);
                        if (bo.isNullOrNil(ajn) && "audio/mp4".equals(str)) {
                            ajn = "mp4";
                        }
                        j jVar = new j();
                        if (cVar.asE().a(new File(str2), ajn, true, jVar) != com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                            obj = null;
                        } else {
                            ajn = (String) jVar.value;
                        }
                        if (obj != null) {
                            ab.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode localId %s", obj);
                            HashMap hashMap = new HashMap();
                            hashMap.put("downloadTaskId", str);
                            hashMap.put("tempFilePath", obj);
                            hashMap.put("statusCode", Integer.valueOf(i2));
                            hashMap.put("state", "success");
                            if (this.hRr != null) {
                                hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, this.hRr);
                            }
                            if (this.hRs != null) {
                                hashMap.put("cookies", this.hRs);
                            }
                            new a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
                            AppMethodBeat.o(108021);
                            return;
                        }
                    }
                    if (d.i(cVar, str)) {
                        AppMethodBeat.o(108021);
                        return;
                    }
                    d.a(cVar, str, "download fail");
                    AppMethodBeat.o(108021);
                    return;
                }
                ajn = ae.a(cVar, new File(str2), optString, null);
                if (b.FAILED != i && "ok".equals(ajn)) {
                    ab.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode filePath %s", optString);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("downloadTaskId", str);
                    hashMap2.put("filePath", optString);
                    hashMap2.put("statusCode", Integer.valueOf(i2));
                    hashMap2.put("state", "success");
                    if (this.hRr != null) {
                        hashMap2.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, this.hRr);
                    }
                    if (this.hRs != null) {
                        hashMap2.put("cookies", this.hRs);
                    }
                    new a().j(cVar).AM(new JSONObject(hashMap2).toString()).aCj();
                    AppMethodBeat.o(108021);
                } else if (d.i(cVar, str)) {
                    AppMethodBeat.o(108021);
                } else {
                    d.a(cVar, str, ajn);
                    AppMethodBeat.o(108021);
                }
            }

            public final void g(int i, long j, long j2) {
                AppMethodBeat.i(108022);
                HashMap hashMap = new HashMap();
                hashMap.put("downloadTaskId", str);
                hashMap.put("state", "progressUpdate");
                hashMap.put("progress", Integer.valueOf(i));
                hashMap.put("totalBytesWritten", Long.valueOf(j));
                hashMap.put("totalBytesExpectedToWrite", Long.valueOf(j2));
                new a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
                AppMethodBeat.o(108022);
            }

            public final void AD(String str) {
                AppMethodBeat.i(108023);
                if (d.i(cVar, str)) {
                    AppMethodBeat.o(108023);
                    return;
                }
                d.a(cVar, str, str);
                AppMethodBeat.o(108023);
            }

            public final void p(JSONObject jSONObject) {
                AppMethodBeat.i(108024);
                if (jSONObject == null) {
                    AppMethodBeat.o(108024);
                } else if (!jSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
                    this.hRr = jSONObject;
                    this.hRs = this.hRr.optJSONArray("cookies");
                    HashMap hashMap = new HashMap();
                    hashMap.put("downloadTaskId", str);
                    hashMap.put("state", "headersReceived");
                    hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, this.hRr);
                    if (this.hRs != null) {
                        hashMap.put("cookies", this.hRs);
                    }
                    new a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
                    AppMethodBeat.o(108024);
                } else if (((com.tencent.mm.plugin.appbrand.l.a) cVar.aa(com.tencent.mm.plugin.appbrand.l.a.class)).bQf) {
                    jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                    m mVar = new m();
                    mVar.csn.cso = "download";
                    mVar.csn.csq = jSONObject;
                    mVar.csn.csp = str;
                    com.tencent.mm.sdk.b.a.xxA.m(mVar);
                    AppMethodBeat.o(108024);
                } else {
                    AppMethodBeat.o(108024);
                }
            }
        };
        com.tencent.mm.plugin.appbrand.l.a aVar = (com.tencent.mm.plugin.appbrand.l.a) cVar.aa(com.tencent.mm.plugin.appbrand.l.a.class);
        Map a = com.tencent.mm.plugin.appbrand.l.j.a(jSONObject, aVar);
        String optString2 = jSONObject.optString("url");
        if (bo.isNullOrNil(optString2)) {
            ab.i("MicroMsg.JsApiCreateDownloadTask", "url is null");
            a(cVar, str, "url is null or nil");
            AppMethodBeat.o(108026);
            return;
        }
        int i = (aVar.ioe && jSONObject.optBoolean("__skipDomainCheck__")) ? 1 : 0;
        boolean z = i != 0 ? false : aVar.iof;
        if (!z || com.tencent.mm.plugin.appbrand.l.j.c(aVar.bQI, optString2)) {
            if (aVar.bQy <= 0) {
                ab.i("MicroMsg.JsApiCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
            }
            int i2 = 60000;
            i = jSONObject.optInt("timeout", 0);
            if (i <= 0) {
                i = com.tencent.mm.plugin.appbrand.l.j.a(aVar, 3);
            }
            if (i > 0) {
                i2 = i;
            }
            ab.i("MicroMsg.JsApiCreateDownloadTask", "lm:configTimeout: %d,timeout: %d", Integer.valueOf(i), Integer.valueOf(i2));
            a(cVar, aVar, z, jSONObject, i2, a, anonymousClass1, str);
            AppMethodBeat.o(108026);
            return;
        }
        ab.i("MicroMsg.JsApiCreateDownloadTask", "not in domain url %s", optString2);
        a(cVar, str, "url not in domain list");
        AppMethodBeat.o(108026);
    }

    /* JADX WARNING: Missing block: B:20:0x00a5, code skipped:
            r2 = new com.tencent.mm.plugin.appbrand.l.a.b(r9.hvw, r4, r9.ior + com.tencent.mm.sdk.platformtools.ag.ck(r4) + "temp", r9.ibJ, new com.tencent.mm.plugin.appbrand.l.b.AnonymousClass1(r20, r19));
            r2.ipC = r18;
            r2.azs = r17;
            r2.isRunning = true;
            r2.ioN = r8;
            r2.ipD = r10;
            r2.ios = r9.ios;
            r2.hvr = r20;
            r2.ioR = r11;
            r3 = r9.iov;
     */
    /* JADX WARNING: Missing block: B:21:0x00f0, code skipped:
            monitor-enter(r3);
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            r9.iov.add(r2);
     */
    /* JADX WARNING: Missing block: B:24:0x00f6, code skipped:
            monitor-exit(r3);
     */
    /* JADX WARNING: Missing block: B:25:0x00f7, code skipped:
            r5 = r9.iou;
     */
    /* JADX WARNING: Missing block: B:26:0x00f9, code skipped:
            monitor-enter(r5);
     */
    /* JADX WARNING: Missing block: B:29:0x0100, code skipped:
            if (r9.iou.containsKey(r4) != false) goto L_0x014a;
     */
    /* JADX WARNING: Missing block: B:30:0x0102, code skipped:
            r3 = new java.util.concurrent.ConcurrentLinkedQueue();
            r9.iou.put(r4, r3);
     */
    /* JADX WARNING: Missing block: B:31:0x010c, code skipped:
            r3.offer(r2);
     */
    /* JADX WARNING: Missing block: B:32:0x010f, code skipped:
            monitor-exit(r5);
     */
    /* JADX WARNING: Missing block: B:34:0x0116, code skipped:
            if (r9.iou.get(r4) == null) goto L_0x015c;
     */
    /* JADX WARNING: Missing block: B:36:0x0125, code skipped:
            if (((java.util.concurrent.ConcurrentLinkedQueue) r9.iou.get(r4)).size() <= 1) goto L_0x015c;
     */
    /* JADX WARNING: Missing block: B:37:0x0127, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkDownload", "hy: more than one same url in the queue, just add and wait");
     */
    /* JADX WARNING: Missing block: B:45:0x0143, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(108027);
     */
    /* JADX WARNING: Missing block: B:47:?, code skipped:
            r3 = (java.util.concurrent.ConcurrentLinkedQueue) r9.iou.get(r4);
     */
    /* JADX WARNING: Missing block: B:49:0x0155, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(108027);
     */
    /* JADX WARNING: Missing block: B:50:0x015c, code skipped:
            r9.CF(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.l.a aVar, boolean z, JSONObject jSONObject, int i, Map<String, String> map, com.tencent.mm.plugin.appbrand.l.b.a aVar2, String str) {
        String appId;
        b bVar;
        AppMethodBeat.i(108027);
        b CJ = c.aIB().CJ(cVar.getAppId());
        if (CJ == null) {
            CJ = new b(cVar);
            c aIB = c.aIB();
            appId = cVar.getAppId();
            if (!aIB.hGk.containsKey(appId)) {
                aIB.hGk.put(appId, CJ);
            }
            bVar = CJ;
        } else {
            bVar = CJ;
        }
        if (bVar != null) {
            ab.i("MicroMsg.JsApiCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", Boolean.valueOf(z), Integer.valueOf(i));
            int i2 = aVar.hfK;
            ArrayList arrayList;
            if (z) {
                arrayList = aVar.bQI;
            } else {
                arrayList = null;
            }
            String str2 = "createDownloadTask";
            appId = com.tencent.mm.plugin.appbrand.l.j.CS(jSONObject.optString("url"));
            synchronized (bVar.iov) {
                try {
                    if (bVar.iov.size() >= bVar.ioq) {
                        aVar2.AD("max_connected");
                        ab.i("MicroMsg.AppBrandNetworkDownload", "max connected mDownloadTaskList.size():%d,mMaxConnected:%d", Integer.valueOf(bVar.iov.size()), Integer.valueOf(bVar.ioq));
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(108027);
                }
            }
        }
        AppMethodBeat.o(108027);
    }

    public static void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str, String str2) {
        AppMethodBeat.i(108028);
        HashMap hashMap = new HashMap();
        hashMap.put("downloadTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        new a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
        AppMethodBeat.o(108028);
    }

    static /* synthetic */ boolean i(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str) {
        AppMethodBeat.i(108029);
        b CJ = c.aIB().CJ(cVar.getAppId());
        if (CJ == null || !CJ.CH(str)) {
            AppMethodBeat.o(108029);
            return false;
        }
        ab.i("MicroMsg.JsApiCreateDownloadTask", "download abort %s", str);
        AppMethodBeat.o(108029);
        return true;
    }
}
