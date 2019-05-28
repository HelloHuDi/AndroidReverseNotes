package com.tencent.p177mm.plugin.appbrand.jsapi.p308i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18319m;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.p321l.C19538j;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.plugin.appbrand.p321l.C42599g;
import com.tencent.p177mm.plugin.appbrand.p321l.C42599g.C33423a;
import com.tencent.p177mm.plugin.appbrand.p321l.C42601i;
import com.tencent.p177mm.sdk.p1574f.C44216b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.p1431a.C36638b;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.g */
public final class C38312g extends C10433b {
    public static final int CTRL_INDEX = 272;
    public static final String NAME = "createUploadTask";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.g$a */
    public static class C38311a extends C42467ah {
        public static final int CTRL_INDEX = 274;
        public static final String NAME = "onUploadTaskStateChange";
    }

    public final String aBA() {
        AppMethodBeat.m2504i(108056);
        StringBuilder stringBuilder = new StringBuilder();
        C42601i.aIG();
        String stringBuilder2 = stringBuilder.append(C42601i.aIA()).toString();
        AppMethodBeat.m2505o(108056);
        return stringBuilder2;
    }

    /* renamed from: OA */
    public final String mo21946OA() {
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
    /* renamed from: a */
    public final void mo21947a(C2241c c2241c, JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(108057);
        C4990ab.m7410d("MicroMsg.JsApiCreateUploadTask", "JsApiCreateUploadTask");
        String appId = c2241c.getAppId();
        String optString = jSONObject.optString("filePath");
        if (C5046bo.isNullOrNil(optString)) {
            C38312g.m64835a(c2241c, str, "filePath is null");
            AppMethodBeat.m2505o(108057);
            return;
        }
        File yg = c2241c.asE().mo34314yg(optString);
        if (yg == null || !yg.exists()) {
            C4990ab.m7413e("MicroMsg.JsApiCreateUploadTask", "upload appId(%s) tempFilePath(%s), found no real file", c2241c.getAppId(), optString);
            C38312g.m64835a(c2241c, str, "fail:file doesn't exist");
            AppMethodBeat.m2505o(108057);
            return;
        }
        final String absolutePath = yg.getAbsolutePath();
        String ako = C44216b.ako(optString);
        C4990ab.m7417i("MicroMsg.JsApiCreateUploadTask", "upload appId(%s) tempFilePath(%s) realFilePath(%s)", c2241c.getAppId(), optString, absolutePath);
        final C2241c c2241c2 = c2241c;
        final String str2 = str;
        C383101 c383101 = new C33423a() {
            private JSONObject hRr;
            private JSONArray hRs;

            /* renamed from: BC */
            public final void mo53911BC(String str) {
                AppMethodBeat.m2504i(108052);
                if (C38312g.m64836j(c2241c2, str2)) {
                    AppMethodBeat.m2505o(108052);
                    return;
                }
                C38312g.m64835a(c2241c2, str2, str);
                AppMethodBeat.m2505o(108052);
            }

            /* renamed from: g */
            public final void mo53912g(int i, String str, int i2) {
                AppMethodBeat.m2504i(108053);
                if (i == 0) {
                    C4990ab.m7411d("MicroMsg.JsApiCreateUploadTask", "success: file name %s, result %s , errMsg %d", absolutePath, str, Integer.valueOf(i));
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
                    new C38311a().mo61032j(c2241c2).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                    AppMethodBeat.m2505o(108053);
                } else if (C38312g.m64836j(c2241c2, str2)) {
                    AppMethodBeat.m2505o(108053);
                } else {
                    C4990ab.m7413e("MicroMsg.JsApiCreateUploadTask", "error: file name %s, result %s , errMsg %d", absolutePath, str, Integer.valueOf(i));
                    C38312g.m64835a(c2241c2, str2, str);
                    AppMethodBeat.m2505o(108053);
                }
            }

            /* renamed from: h */
            public final void mo53913h(int i, long j, long j2) {
                AppMethodBeat.m2504i(108054);
                HashMap hashMap = new HashMap();
                hashMap.put("uploadTaskId", str2);
                hashMap.put("state", "progressUpdate");
                hashMap.put("progress", Integer.valueOf(i));
                hashMap.put("totalBytesSent", Long.valueOf(j));
                hashMap.put("totalBytesExpectedToSend", Long.valueOf(j2));
                new C38311a().mo61032j(c2241c2).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                AppMethodBeat.m2505o(108054);
            }

            /* renamed from: p */
            public final void mo53914p(JSONObject jSONObject) {
                AppMethodBeat.m2504i(108055);
                if (jSONObject == null) {
                    AppMethodBeat.m2505o(108055);
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
                    new C38311a().mo61032j(c2241c2).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                    AppMethodBeat.m2505o(108055);
                } else if (((C38414a) c2241c2.mo5937aa(C38414a.class)).bQf) {
                    jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                    C18319m c18319m = new C18319m();
                    c18319m.csn.cso = "upload";
                    c18319m.csn.csq = jSONObject;
                    c18319m.csn.csp = str2;
                    C4879a.xxA.mo10055m(c18319m);
                    AppMethodBeat.m2505o(108055);
                } else {
                    AppMethodBeat.m2505o(108055);
                }
            }
        };
        C38414a c38414a = (C38414a) c2241c.mo5937aa(C38414a.class);
        Map a = C19538j.m30267a(jSONObject, c38414a);
        String optString2 = jSONObject.optString("url");
        if (C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7416i("MicroMsg.JsApiCreateUploadTask", "url is null");
            C38312g.m64835a(c2241c, str, "url is null or nil");
            AppMethodBeat.m2505o(108057);
            return;
        }
        Object obj;
        boolean z;
        int optInt;
        C42599g c42599g;
        String name;
        if (c38414a.ioe) {
            if (jSONObject.optBoolean("__skipDomainCheck__")) {
                obj = 1;
                z = obj == null ? false : c38414a.iof;
                if (z || C19538j.m30275c(c38414a.bQH, optString2)) {
                    if (c38414a.bQx <= 0) {
                        C4990ab.m7416i("MicroMsg.JsApiCreateUploadTask", "concurrent <= 0 ");
                    }
                    optInt = jSONObject.optInt("timeout", 0);
                    if (optInt <= 0) {
                        optInt = C19538j.m30265a(c38414a, 2);
                    }
                    if (optInt <= 0) {
                        optInt = 60000;
                    }
                    if (C42601i.aIG().mo68036CO(appId) != null) {
                        c42599g = new C42599g(c2241c);
                        C42601i aIG = C42601i.aIG();
                        if (!aIG.hGk.containsKey(appId)) {
                            aIG.hGk.put(appId, c42599g);
                        }
                    } else {
                        c42599g = C42601i.aIG().mo68036CO(appId);
                    }
                    name = C36638b.getName(optString);
                    if (c42599g != null) {
                        C4990ab.m7417i("MicroMsg.JsApiCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", Boolean.valueOf(z), Integer.valueOf(optInt));
                        if (z) {
                            c42599g.mo68033a(optInt, ako, absolutePath, jSONObject, a, c38414a.bQH, c383101, str, NAME, name);
                        } else {
                            c42599g.mo68033a(optInt, ako, absolutePath, jSONObject, a, null, c383101, str, NAME, name);
                            AppMethodBeat.m2505o(108057);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(108057);
                }
                C4990ab.m7417i("MicroMsg.JsApiCreateUploadTask", "not in domain url %s", optString2);
                C38312g.m64835a(c2241c, str, "url not in domain list");
                AppMethodBeat.m2505o(108057);
                return;
            }
        }
        obj = null;
        if (obj == null) {
        }
        if (z) {
        }
        if (c38414a.bQx <= 0) {
        }
        optInt = jSONObject.optInt("timeout", 0);
        if (optInt <= 0) {
        }
        if (optInt <= 0) {
        }
        if (C42601i.aIG().mo68036CO(appId) != null) {
        }
        name = C36638b.getName(optString);
        if (c42599g != null) {
        }
        AppMethodBeat.m2505o(108057);
    }

    /* renamed from: a */
    static void m64835a(C2241c c2241c, String str, String str2) {
        AppMethodBeat.m2504i(108058);
        HashMap hashMap = new HashMap();
        hashMap.put("uploadTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        new C38311a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
        AppMethodBeat.m2505o(108058);
    }

    /* renamed from: j */
    static /* synthetic */ boolean m64836j(C2241c c2241c, String str) {
        AppMethodBeat.m2504i(108059);
        C42599g CO = C42601i.aIG().mo68036CO(c2241c.getAppId());
        if (CO == null || !CO.mo68031CH(str)) {
            AppMethodBeat.m2505o(108059);
            return false;
        }
        C4990ab.m7417i("MicroMsg.JsApiCreateUploadTask", "upload abort %s", str);
        AppMethodBeat.m2505o(108059);
        return true;
    }
}
