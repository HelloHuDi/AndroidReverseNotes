package com.tencent.mm.plugin.appbrand.report;

import a.l;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceTypeCache;", "", "()V", "TAG", "", "serviceTypeMap", "Landroid/util/SparseIntArray;", "addServiceTypeMap", "", "appId", "serviceType", "", "getServiceTypeMap", "default", "plugin-appbrand-integration_release"})
public final class d {
    private static final SparseIntArray iAk = new SparseIntArray();
    public static final d iAl = new d();

    public static final int Dy(String str) {
        AppMethodBeat.i(134936);
        int Dx = Dx(str);
        AppMethodBeat.o(134936);
        return Dx;
    }

    static {
        AppMethodBeat.i(134937);
        AppMethodBeat.o(134937);
    }

    private d() {
    }

    public static final void bs(String str, int i) {
        AppMethodBeat.i(134934);
        if (str != null) {
            ab.d("MicroMsg.AppBrandServiceTypeCache", "addServiceTypeMap appId: " + str + ", serviceType: " + i);
            iAk.put(str.hashCode(), i);
        }
        AppMethodBeat.o(134934);
    }

    public static /* synthetic */ int Dx(String str) {
        AppMethodBeat.i(134935);
        if (str != null) {
            int i = iAk.get(str.hashCode(), -1);
            ab.d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: " + str + ", ret " + i);
            AppMethodBeat.o(134935);
            return i;
        }
        AppMethodBeat.o(134935);
        return -1;
    }
}
