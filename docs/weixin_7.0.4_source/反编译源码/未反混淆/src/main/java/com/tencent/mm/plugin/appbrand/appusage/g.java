package com.tencent.mm.plugin.appbrand.appusage;

import a.l;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.sdk.e.k;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J \u0010\u0016\u001a\u00020\f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageIPC;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "()V", "addCollection", "", "username", "", "versionType", "getCount", "getCountLimit", "isCollection", "", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "", "removeCollection", "reorder", "reorderList", "reason", "plugin-appbrand-integration_release"})
public final class g extends k implements af {
    public final void awX() {
    }

    public final int aC(String str, int i) {
        AppMethodBeat.i(134531);
        CharSequence charSequence = str;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        if (obj != null) {
            AppMethodBeat.o(134531);
            return -1;
        }
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.a("com.tencent.mm", new AppIdentity(str, i), a.class);
        if (iPCInteger != null) {
            int i2 = iPCInteger.value;
            AppMethodBeat.o(134531);
            return i2;
        }
        AppMethodBeat.o(134531);
        return -1;
    }

    public final boolean aD(String str, int i) {
        Object obj;
        AppMethodBeat.i(134532);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.o(134532);
            return false;
        }
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a("com.tencent.mm", new AppIdentity(str, i), ak.class);
        if (iPCBoolean != null) {
            boolean z = iPCBoolean.value;
            AppMethodBeat.o(134532);
            return z;
        }
        AppMethodBeat.o(134532);
        return false;
    }

    public final boolean aB(String str, int i) {
        Object obj;
        AppMethodBeat.i(134533);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.o(134533);
            return false;
        }
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a("com.tencent.mm", new AppIdentity(str, i), ah.class);
        if (iPCBoolean != null) {
            boolean z = iPCBoolean.value;
            AppMethodBeat.o(134533);
            return z;
        }
        AppMethodBeat.o(134533);
        return false;
    }

    public final boolean g(List<LocalUsageInfo> list, int i) {
        return false;
    }

    public final List<LocalUsageInfo> a(int i, a aVar) {
        AppMethodBeat.i(134534);
        Parcel parcel = (Parcel) XIPCInvoker.a("com.tencent.mm", new QueryParams(i, aVar), aj.class);
        if (parcel != null) {
            ArrayList arrayList = new ArrayList();
            parcel.readTypedList(arrayList, LocalUsageInfo.CREATOR);
            List list = arrayList;
            AppMethodBeat.o(134534);
            return list;
        }
        List<LocalUsageInfo> arrayList2 = new ArrayList(0);
        AppMethodBeat.o(134534);
        return arrayList2;
    }

    public final int getCount() {
        AppMethodBeat.i(134535);
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.a("com.tencent.mm", IPCVoid.eGH, ac.class);
        if (iPCInteger != null) {
            int i = iPCInteger.value;
            AppMethodBeat.o(134535);
            return i;
        }
        AppMethodBeat.o(134535);
        return 0;
    }

    public final int awY() {
        AppMethodBeat.i(134536);
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.a("com.tencent.mm", IPCVoid.eGH, ai.class);
        int i;
        if (iPCInteger != null) {
            i = iPCInteger.value;
            AppMethodBeat.o(134536);
            return i;
        }
        i = t.axI();
        AppMethodBeat.o(134536);
        return i;
    }
}
