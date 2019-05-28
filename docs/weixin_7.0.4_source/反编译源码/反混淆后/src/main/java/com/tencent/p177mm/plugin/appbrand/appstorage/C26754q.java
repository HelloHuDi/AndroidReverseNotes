package com.tencent.p177mm.plugin.appbrand.appstorage;

import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.p326n.C33458b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"KV_STORAGE_ACTION_GET", "", "KV_STORAGE_ACTION_INFO", "KV_STORAGE_ACTION_SET", "KV_STORAGE_SCHEME_DB", "KV_STORAGE_SCHEME_MMKV", "TAG", "", "report", "", "scheme", "action", "dataSize", "count", "cost", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "luggage-wechat-full-sdk_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.q */
public final class C26754q {
    /* renamed from: a */
    public static final void m42583a(int i, int i2, int i3, int i4, long j, C33327h c33327h) {
        AppMethodBeat.m2504i(102457);
        C25052j.m39376p(c33327h, "service");
        C6750i runtime = c33327h.getRuntime();
        C16597h ye = runtime != null ? runtime.mo15034ye() : null;
        if (ye == null) {
            C4990ab.m7416i("KVStoragePerformanceReport", "sysConfig is null");
            AppMethodBeat.m2505o(102457);
        } else if (ye.hhf) {
            C4990ab.m7416i("KVStoragePerformanceReport", "report scheme=" + i + "  action=" + i2 + "  dataSize=" + i3 + "  count=" + i4 + "  cost=" + j);
            ((C33458b) C37384e.m62986C(C33458b.class)).mo53944e(16336, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j));
            AppMethodBeat.m2505o(102457);
        } else {
            C4990ab.m7416i("KVStoragePerformanceReport", "performance report off");
            AppMethodBeat.m2505o(102457);
        }
    }
}
