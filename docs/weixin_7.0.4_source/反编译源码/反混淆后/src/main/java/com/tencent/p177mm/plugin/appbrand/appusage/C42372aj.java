package com.tencent.p177mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/QueryCall;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "Landroid/os/Parcel;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.aj */
final class C42372aj implements C45413i<QueryParams, Parcel> {
    /* renamed from: am */
    public final /* synthetic */ Object mo4785am(Object obj) {
        AppMethodBeat.m2504i(134562);
        Parcel a = C42372aj.m74964a((QueryParams) obj);
        AppMethodBeat.m2505o(134562);
        return a;
    }

    /* renamed from: a */
    private static Parcel m74964a(QueryParams queryParams) {
        AppMethodBeat.m2504i(134561);
        Parcel obtain = Parcel.obtain();
        if (C1720g.m3531RK() && queryParams != null) {
            try {
                obtain.writeTypedList(((C10118af) C1720g.m3528K(C10118af.class)).mo21470a(queryParams.count, queryParams.haS));
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.AppBrandCollectionStorageIPC", "QueryCall, writeTypedList e = ".concat(String.valueOf(e)));
            }
        }
        C25052j.m39375o(obtain, "Parcel.obtain().apply {\n…}\n            }\n        }");
        AppMethodBeat.m2505o(134561);
        return obtain;
    }
}
