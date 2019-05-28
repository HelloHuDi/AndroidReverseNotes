package com.tencent.p177mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandLocalUsageStorageNewImpl;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "()V", "TAG", "", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "getCount", "", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "remove", "removeUsage", "", "username", "versionType", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.p */
public final class C42381p extends C7296k implements C26767ag {
    private final String TAG = "MicroMsg.AppBrandLocalUsageStorageNewImpl";

    /* renamed from: aE */
    public final boolean mo44539aE(String str, int i) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.m2504i(134539);
        C42374al.m74967j(str, null, i);
        if (!C42340f.auT().mo73333aL(str, i)) {
            try {
                if (C42340f.auT().mo73334aM(str, i)) {
                    z = false;
                    z2 = z;
                    AppMethodBeat.m2505o(134539);
                    return z2;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.TAG, e, "removeUsage", new Object[0]);
            }
        }
        z = true;
        z2 = z;
        AppMethodBeat.m2505o(134539);
        return z2;
    }

    /* renamed from: nA */
    public final List<? extends LocalUsageInfo> mo44540nA(int i) {
        AppMethodBeat.m2504i(134540);
        if (i <= 0) {
            List emptyList = Collections.emptyList();
            C25052j.m39375o(emptyList, "Collections.emptyList<LocalUsageInfo>()");
            AppMethodBeat.m2505o(134540);
            return emptyList;
        }
        ArrayList f = C45522w.m83927f(C42340f.auT().mo73328a(null, i, 0));
        C25052j.m39375o(f, "obtainHistoryList(SubCor…istories(null, count, 0))");
        List<? extends LocalUsageInfo> list = f;
        AppMethodBeat.m2505o(134540);
        return list;
    }

    /* renamed from: c */
    public final void mo10116c(C4931a c4931a) {
        AppMethodBeat.m2504i(134541);
        mo10114a(c4931a, Looper.getMainLooper());
        AppMethodBeat.m2505o(134541);
    }

    /* renamed from: a */
    public final void mo10114a(C4931a c4931a, Looper looper) {
        AppMethodBeat.m2504i(134542);
        C42340f.auT().mo10114a(c4931a, looper);
        C42340f.auO().mo10114a(c4931a, looper);
        AppMethodBeat.m2505o(134542);
    }

    /* renamed from: d */
    public final void mo10117d(C4931a c4931a) {
        AppMethodBeat.m2504i(134543);
        C42340f.auT().mo10117d(c4931a);
        C42340f.auO().mo10117d(c4931a);
        AppMethodBeat.m2505o(134543);
    }
}
