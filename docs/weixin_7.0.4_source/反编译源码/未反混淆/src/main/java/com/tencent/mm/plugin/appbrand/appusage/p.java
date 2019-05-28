package com.tencent.mm.plugin.appbrand.appusage;

import a.f.b.j;
import a.l;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandLocalUsageStorageNewImpl;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "()V", "TAG", "", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "getCount", "", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "remove", "removeUsage", "", "username", "versionType", "plugin-appbrand-integration_release"})
public final class p extends k implements ag {
    private final String TAG = "MicroMsg.AppBrandLocalUsageStorageNewImpl";

    public final boolean aE(String str, int i) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(134539);
        al.j(str, null, i);
        if (!f.auT().aL(str, i)) {
            try {
                if (f.auT().aM(str, i)) {
                    z = false;
                    z2 = z;
                    AppMethodBeat.o(134539);
                    return z2;
                }
            } catch (Exception e) {
                ab.printErrStackTrace(this.TAG, e, "removeUsage", new Object[0]);
            }
        }
        z = true;
        z2 = z;
        AppMethodBeat.o(134539);
        return z2;
    }

    public final List<? extends LocalUsageInfo> nA(int i) {
        AppMethodBeat.i(134540);
        if (i <= 0) {
            List emptyList = Collections.emptyList();
            j.o(emptyList, "Collections.emptyList<LocalUsageInfo>()");
            AppMethodBeat.o(134540);
            return emptyList;
        }
        ArrayList f = w.f(f.auT().a(null, i, 0));
        j.o(f, "obtainHistoryList(SubCor…istories(null, count, 0))");
        List<? extends LocalUsageInfo> list = f;
        AppMethodBeat.o(134540);
        return list;
    }

    public final void c(a aVar) {
        AppMethodBeat.i(134541);
        a(aVar, Looper.getMainLooper());
        AppMethodBeat.o(134541);
    }

    public final void a(a aVar, Looper looper) {
        AppMethodBeat.i(134542);
        f.auT().a(aVar, looper);
        f.auO().a(aVar, looper);
        AppMethodBeat.o(134542);
    }

    public final void d(a aVar) {
        AppMethodBeat.i(134543);
        f.auT().d(aVar);
        f.auO().d(aVar);
        AppMethodBeat.o(134543);
    }
}
