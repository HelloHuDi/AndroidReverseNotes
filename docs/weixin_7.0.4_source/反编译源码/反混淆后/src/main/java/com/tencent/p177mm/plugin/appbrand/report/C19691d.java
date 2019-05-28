package com.tencent.p177mm.plugin.appbrand.report;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceTypeCache;", "", "()V", "TAG", "", "serviceTypeMap", "Landroid/util/SparseIntArray;", "addServiceTypeMap", "", "appId", "serviceType", "", "getServiceTypeMap", "default", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.report.d */
public final class C19691d {
    private static final SparseIntArray iAk = new SparseIntArray();
    public static final C19691d iAl = new C19691d();

    /* renamed from: Dy */
    public static final int m30510Dy(String str) {
        AppMethodBeat.m2504i(134936);
        int Dx = C19691d.m30509Dx(str);
        AppMethodBeat.m2505o(134936);
        return Dx;
    }

    static {
        AppMethodBeat.m2504i(134937);
        AppMethodBeat.m2505o(134937);
    }

    private C19691d() {
    }

    /* renamed from: bs */
    public static final void m30511bs(String str, int i) {
        AppMethodBeat.m2504i(134934);
        if (str != null) {
            C4990ab.m7410d("MicroMsg.AppBrandServiceTypeCache", "addServiceTypeMap appId: " + str + ", serviceType: " + i);
            iAk.put(str.hashCode(), i);
        }
        AppMethodBeat.m2505o(134934);
    }

    /* renamed from: Dx */
    public static /* synthetic */ int m30509Dx(String str) {
        AppMethodBeat.m2504i(134935);
        if (str != null) {
            int i = iAk.get(str.hashCode(), -1);
            C4990ab.m7410d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: " + str + ", ret " + i);
            AppMethodBeat.m2505o(134935);
            return i;
        }
        AppMethodBeat.m2505o(134935);
        return -1;
    }
}
