package com.tencent.p177mm.plugin.appbrand.jsapi.p308i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18319m;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C33307ae;
import com.tencent.p177mm.plugin.appbrand.p321l.C10567c;
import com.tencent.p177mm.plugin.appbrand.p321l.C19538j;
import com.tencent.p177mm.plugin.appbrand.p321l.C27146b;
import com.tencent.p177mm.plugin.appbrand.p321l.C27146b.C27147a;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.sdk.p1574f.C44216b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.d */
public class C45603d extends C10433b {
    public static final int CTRL_INDEX = 269;
    public static final String NAME = "createDownloadTask";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.d$a */
    public static class C33328a extends C42467ah {
        public static final int CTRL_INDEX = 271;
        public static final String NAME = "onDownloadTaskStateChange";
    }

    public final String aBA() {
        AppMethodBeat.m2504i(108025);
        StringBuilder stringBuilder = new StringBuilder();
        C10567c.aIB();
        String stringBuilder2 = stringBuilder.append(C10567c.aIA()).toString();
        AppMethodBeat.m2505o(108025);
        return stringBuilder2;
    }

    /* renamed from: OA */
    public final String mo21946OA() {
        return "downloadTaskId";
    }

    /* renamed from: a */
    public final void mo21947a(final C2241c c2241c, JSONObject jSONObject, final String str) {
        AppMethodBeat.m2504i(108026);
        C4990ab.m7410d("MicroMsg.JsApiCreateDownloadTask", "JsApiCreateDownloadTask");
        final String optString = jSONObject.optString("filePath");
        C104351 c104351 = new C27147a() {
            private JSONObject hRr;
            private JSONArray hRs;

            /* renamed from: c */
            public final void mo21951c(int i, String str, String str2, int i2) {
                AppMethodBeat.m2504i(108021);
                C4990ab.m7417i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %s", Integer.valueOf(i), str, str2, Integer.valueOf(i2));
                String ajn;
                if (C5046bo.isNullOrNil(optString)) {
                    if (i != C27146b.FAILED) {
                        Object obj;
                        C2241c c2241c = c2241c;
                        ajn = C44216b.ajn(str);
                        if (C5046bo.isNullOrNil(ajn) && "audio/mp4".equals(str)) {
                            ajn = "mp4";
                        }
                        C19681j c19681j = new C19681j();
                        if (c2241c.asE().mo5835a(new File(str2), ajn, true, c19681j) != C45518j.OK) {
                            obj = null;
                        } else {
                            ajn = (String) c19681j.value;
                        }
                        if (obj != null) {
                            C4990ab.m7417i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode localId %s", obj);
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
                            new C33328a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                            AppMethodBeat.m2505o(108021);
                            return;
                        }
                    }
                    if (C45603d.m84160i(c2241c, str)) {
                        AppMethodBeat.m2505o(108021);
                        return;
                    }
                    C45603d.m84159a(c2241c, str, "download fail");
                    AppMethodBeat.m2505o(108021);
                    return;
                }
                ajn = C33307ae.m54481a(c2241c, new File(str2), optString, null);
                if (C27146b.FAILED != i && "ok".equals(ajn)) {
                    C4990ab.m7417i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode filePath %s", optString);
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
                    new C33328a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap2).toString()).aCj();
                    AppMethodBeat.m2505o(108021);
                } else if (C45603d.m84160i(c2241c, str)) {
                    AppMethodBeat.m2505o(108021);
                } else {
                    C45603d.m84159a(c2241c, str, ajn);
                    AppMethodBeat.m2505o(108021);
                }
            }

            /* renamed from: g */
            public final void mo21952g(int i, long j, long j2) {
                AppMethodBeat.m2504i(108022);
                HashMap hashMap = new HashMap();
                hashMap.put("downloadTaskId", str);
                hashMap.put("state", "progressUpdate");
                hashMap.put("progress", Integer.valueOf(i));
                hashMap.put("totalBytesWritten", Long.valueOf(j));
                hashMap.put("totalBytesExpectedToWrite", Long.valueOf(j2));
                new C33328a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                AppMethodBeat.m2505o(108022);
            }

            /* renamed from: AD */
            public final void mo21950AD(String str) {
                AppMethodBeat.m2504i(108023);
                if (C45603d.m84160i(c2241c, str)) {
                    AppMethodBeat.m2505o(108023);
                    return;
                }
                C45603d.m84159a(c2241c, str, str);
                AppMethodBeat.m2505o(108023);
            }

            /* renamed from: p */
            public final void mo21953p(JSONObject jSONObject) {
                AppMethodBeat.m2504i(108024);
                if (jSONObject == null) {
                    AppMethodBeat.m2505o(108024);
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
                    new C33328a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                    AppMethodBeat.m2505o(108024);
                } else if (((C38414a) c2241c.mo5937aa(C38414a.class)).bQf) {
                    jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                    C18319m c18319m = new C18319m();
                    c18319m.csn.cso = "download";
                    c18319m.csn.csq = jSONObject;
                    c18319m.csn.csp = str;
                    C4879a.xxA.mo10055m(c18319m);
                    AppMethodBeat.m2505o(108024);
                } else {
                    AppMethodBeat.m2505o(108024);
                }
            }
        };
        C38414a c38414a = (C38414a) c2241c.mo5937aa(C38414a.class);
        Map a = C19538j.m30267a(jSONObject, c38414a);
        String optString2 = jSONObject.optString("url");
        if (C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7416i("MicroMsg.JsApiCreateDownloadTask", "url is null");
            C45603d.m84159a(c2241c, str, "url is null or nil");
            AppMethodBeat.m2505o(108026);
            return;
        }
        int i = (c38414a.ioe && jSONObject.optBoolean("__skipDomainCheck__")) ? 1 : 0;
        boolean z = i != 0 ? false : c38414a.iof;
        if (!z || C19538j.m30275c(c38414a.bQI, optString2)) {
            if (c38414a.bQy <= 0) {
                C4990ab.m7416i("MicroMsg.JsApiCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
            }
            int i2 = 60000;
            i = jSONObject.optInt("timeout", 0);
            if (i <= 0) {
                i = C19538j.m30265a(c38414a, 3);
            }
            if (i > 0) {
                i2 = i;
            }
            C4990ab.m7417i("MicroMsg.JsApiCreateDownloadTask", "lm:configTimeout: %d,timeout: %d", Integer.valueOf(i), Integer.valueOf(i2));
            mo67976a(c2241c, c38414a, z, jSONObject, i2, a, c104351, str);
            AppMethodBeat.m2505o(108026);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiCreateDownloadTask", "not in domain url %s", optString2);
        C45603d.m84159a(c2241c, str, "url not in domain list");
        AppMethodBeat.m2505o(108026);
    }

    /* JADX WARNING: Missing block: B:20:0x00a5, code skipped:
            r2 = new com.tencent.p177mm.plugin.appbrand.p321l.p1537a.C38413b(r9.hvw, r4, r9.ior + com.tencent.p177mm.sdk.platformtools.C4995ag.m7428ck(r4) + "temp", r9.ibJ, new com.tencent.p177mm.plugin.appbrand.p321l.C27146b.C195371(r20, r19));
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.AppBrandNetworkDownload", "hy: more than one same url in the queue, just add and wait");
     */
    /* JADX WARNING: Missing block: B:45:0x0143, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108027);
     */
    /* JADX WARNING: Missing block: B:47:?, code skipped:
            r3 = (java.util.concurrent.ConcurrentLinkedQueue) r9.iou.get(r4);
     */
    /* JADX WARNING: Missing block: B:49:0x0155, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108027);
     */
    /* JADX WARNING: Missing block: B:50:0x015c, code skipped:
            r9.mo44817CF(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo67976a(C2241c c2241c, C38414a c38414a, boolean z, JSONObject jSONObject, int i, Map<String, String> map, C27147a c27147a, String str) {
        String appId;
        C27146b c27146b;
        AppMethodBeat.m2504i(108027);
        C27146b CJ = C10567c.aIB().mo22076CJ(c2241c.getAppId());
        if (CJ == null) {
            CJ = new C27146b(c2241c);
            C10567c aIB = C10567c.aIB();
            appId = c2241c.getAppId();
            if (!aIB.hGk.containsKey(appId)) {
                aIB.hGk.put(appId, CJ);
            }
            c27146b = CJ;
        } else {
            c27146b = CJ;
        }
        if (c27146b != null) {
            C4990ab.m7417i("MicroMsg.JsApiCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", Boolean.valueOf(z), Integer.valueOf(i));
            int i2 = c38414a.hfK;
            ArrayList arrayList;
            if (z) {
                arrayList = c38414a.bQI;
            } else {
                arrayList = null;
            }
            String str2 = "createDownloadTask";
            appId = C19538j.m30261CS(jSONObject.optString("url"));
            synchronized (c27146b.iov) {
                try {
                    if (c27146b.iov.size() >= c27146b.ioq) {
                        c27147a.mo21950AD("max_connected");
                        C4990ab.m7417i("MicroMsg.AppBrandNetworkDownload", "max connected mDownloadTaskList.size():%d,mMaxConnected:%d", Integer.valueOf(c27146b.iov.size()), Integer.valueOf(c27146b.ioq));
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(108027);
                }
            }
        }
        AppMethodBeat.m2505o(108027);
    }

    /* renamed from: a */
    public static void m84159a(C2241c c2241c, String str, String str2) {
        AppMethodBeat.m2504i(108028);
        HashMap hashMap = new HashMap();
        hashMap.put("downloadTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        new C33328a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
        AppMethodBeat.m2505o(108028);
    }

    /* renamed from: i */
    static /* synthetic */ boolean m84160i(C2241c c2241c, String str) {
        AppMethodBeat.m2504i(108029);
        C27146b CJ = C10567c.aIB().mo22076CJ(c2241c.getAppId());
        if (CJ == null || !CJ.mo44819CH(str)) {
            AppMethodBeat.m2505o(108029);
            return false;
        }
        C4990ab.m7417i("MicroMsg.JsApiCreateDownloadTask", "download abort %s", str);
        AppMethodBeat.m2505o(108029);
        return true;
    }
}
