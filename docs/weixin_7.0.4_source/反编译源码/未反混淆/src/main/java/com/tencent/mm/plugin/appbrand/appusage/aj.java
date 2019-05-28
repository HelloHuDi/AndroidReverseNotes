package com.tencent.mm.plugin.appbrand.appusage;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/QueryCall;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "Landroid/os/Parcel;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
final class aj implements i<QueryParams, Parcel> {
    public final /* synthetic */ Object am(Object obj) {
        AppMethodBeat.i(134562);
        Parcel a = a((QueryParams) obj);
        AppMethodBeat.o(134562);
        return a;
    }

    private static Parcel a(QueryParams queryParams) {
        AppMethodBeat.i(134561);
        Parcel obtain = Parcel.obtain();
        if (g.RK() && queryParams != null) {
            try {
                obtain.writeTypedList(((af) g.K(af.class)).a(queryParams.count, queryParams.haS));
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrandCollectionStorageIPC", "QueryCall, writeTypedList e = ".concat(String.valueOf(e)));
            }
        }
        j.o(obtain, "Parcel.obtain().apply {\n…}\n            }\n        }");
        AppMethodBeat.o(134561);
        return obtain;
    }
}
