package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19085f;
import com.tencent.p177mm.plugin.appbrand.appstorage.C26754q;
import com.tencent.p177mm.plugin.appbrand.appstorage.C38122r;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.n */
public class C27087n extends C10296a<C33327h> {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorage";
    private C27088a hXr = new C194871();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.n$1 */
    class C194871 implements C27088a {
        C194871() {
        }

        /* renamed from: a */
        public final void mo34610a(String str, C33327h c33327h, int i) {
            AppMethodBeat.m2504i(102072);
            c33327h.mo6107M(i, C27087n.this.mo73394j(str, null));
            AppMethodBeat.m2505o(102072);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.n$a */
    interface C27088a {
        /* renamed from: a */
        void mo34610a(String str, C33327h c33327h, int i);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(102079);
        C33327h c33327h = (C33327h) c2241c;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("data");
        String optString3 = jSONObject.optString("dataType");
        int optInt = jSONObject.optInt("storageId", 0);
        if (C5046bo.isNullOrNil(optString)) {
            c33327h.mo6107M(i, mo73394j("fail:key is empty", null));
            AppMethodBeat.m2505o(102079);
        } else if (C38122r.m64503nw(optInt)) {
            c33327h.mo6107M(i, mo73394j("fail:nonexistent storage space", null));
            AppMethodBeat.m2505o(102079);
        } else {
            String c = mo34609c(c33327h);
            if (C5046bo.isNullOrNil(c)) {
                c33327h.mo6107M(i, mo73394j("fail:appID is empty", null));
                AppMethodBeat.m2505o(102079);
                return;
            }
            if ((optString2 == null ? 0 : optString2.length()) + optString.length() > ((C25697b) c33327h.getRuntime()).mo43489xZ().bQO.hfL) {
                c33327h.mo6107M(i, mo73394j("fail:entry size limit reached", null));
                AppMethodBeat.m2505o(102079);
                return;
            }
            int i2 = c33327h.getRuntime().mo15034ye().hhe;
            if (i2 == 2) {
                m43041a(c33327h, i, optInt, optString, optString2, optString3, c, this.hXr);
                AppMethodBeat.m2505o(102079);
            } else if (i2 == 3) {
                m43041a(c33327h, i, optInt, optString, optString2, optString3, c, this.hXr);
                m43043b(c33327h, i, optInt, optString, optString2, optString3, c, null);
                AppMethodBeat.m2505o(102079);
            } else {
                m43043b(c33327h, i, optInt, optString, optString2, optString3, c, this.hXr);
                AppMethodBeat.m2505o(102079);
            }
        }
    }

    public C27087n() {
        AppMethodBeat.m2504i(102075);
        AppMethodBeat.m2505o(102075);
    }

    /* renamed from: a */
    private void m43041a(C33327h c33327h, int i, int i2, String str, String str2, String str3, String str4, C27088a c27088a) {
        AppMethodBeat.m2504i(102076);
        final long currentTimeMillis = System.currentTimeMillis();
        final int i3 = i2;
        final String str5 = str4;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final C27088a c27088a2 = c27088a;
        final C33327h c33327h2 = c33327h;
        final int i4 = i;
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102073);
                C19085f c19085f = C19085f.gXv;
                String a = C45621p.m84206a(C19085f.m29665b(i3, str5, str6, str7, str8));
                if (c27088a2 != null) {
                    c27088a2.mo34610a(a, c33327h2, i4);
                }
                C27087n.m43042b(2, C38122r.m64499by(str6, str7), currentTimeMillis, c33327h2);
                AppMethodBeat.m2505o(102073);
            }
        }, "JsApiSetStorage");
        AppMethodBeat.m2505o(102076);
    }

    /* renamed from: b */
    private void m43043b(C33327h c33327h, int i, int i2, String str, String str2, String str3, String str4, C27088a c27088a) {
        AppMethodBeat.m2504i(102077);
        final long currentTimeMillis = System.currentTimeMillis();
        final MainProcessTask jsApiSetStorageTask = new JsApiSetStorageTask();
        jsApiSetStorageTask.appId = str4;
        jsApiSetStorageTask.hXg = i2;
        jsApiSetStorageTask.mo53868C(str, str2, str3);
        final C27088a c27088a2 = c27088a;
        final C33327h c33327h2 = c33327h;
        final int i3 = i;
        final String str5 = str;
        final String str6 = str2;
        jsApiSetStorageTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102074);
                if (c27088a2 != null) {
                    c27088a2.mo34610a(jsApiSetStorageTask.result, c33327h2, i3);
                }
                C27087n.m43042b(1, C38122r.m64499by(str5, str6), currentTimeMillis, c33327h2);
                jsApiSetStorageTask.aBW();
                AppMethodBeat.m2505o(102074);
            }
        };
        jsApiSetStorageTask.aBV();
        AppBrandMainProcessService.m54349a(jsApiSetStorageTask);
        AppMethodBeat.m2505o(102077);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public String mo34609c(C33327h c33327h) {
        AppMethodBeat.m2504i(102078);
        String str = c33327h.getRuntime().mAppId;
        AppMethodBeat.m2505o(102078);
        return str;
    }

    /* renamed from: b */
    static /* synthetic */ void m43042b(int i, int i2, long j, C33327h c33327h) {
        AppMethodBeat.m2504i(102080);
        C26754q.m42583a(i, 1, i2, 1, System.currentTimeMillis() - j, c33327h);
        AppMethodBeat.m2505o(102080);
    }
}
