package com.tencent.p177mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.ipcinvoker.type.IPCInteger;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af.C10117a;
import com.tencent.p177mm.sdk.p603e.C7296k;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J \u0010\u0016\u001a\u00020\f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageIPC;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "()V", "addCollection", "", "username", "", "versionType", "getCount", "getCountLimit", "isCollection", "", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "", "removeCollection", "reorder", "reorderList", "reason", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.g */
public final class C45521g extends C7296k implements C10118af {
    public final void awX() {
    }

    /* renamed from: aC */
    public final int mo21472aC(String str, int i) {
        AppMethodBeat.m2504i(134531);
        CharSequence charSequence = str;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        if (obj != null) {
            AppMethodBeat.m2505o(134531);
            return -1;
        }
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.m83628a("com.tencent.mm", new AppIdentity(str, i), C10116a.class);
        if (iPCInteger != null) {
            int i2 = iPCInteger.value;
            AppMethodBeat.m2505o(134531);
            return i2;
        }
        AppMethodBeat.m2505o(134531);
        return -1;
    }

    /* renamed from: aD */
    public final boolean mo21473aD(String str, int i) {
        Object obj;
        AppMethodBeat.m2504i(134532);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.m2505o(134532);
            return false;
        }
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.m83628a("com.tencent.mm", new AppIdentity(str, i), C42373ak.class);
        if (iPCBoolean != null) {
            boolean z = iPCBoolean.value;
            AppMethodBeat.m2505o(134532);
            return z;
        }
        AppMethodBeat.m2505o(134532);
        return false;
    }

    /* renamed from: aB */
    public final boolean mo21471aB(String str, int i) {
        Object obj;
        AppMethodBeat.m2504i(134533);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.m2505o(134533);
            return false;
        }
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.m83628a("com.tencent.mm", new AppIdentity(str, i), C10119ah.class);
        if (iPCBoolean != null) {
            boolean z = iPCBoolean.value;
            AppMethodBeat.m2505o(134533);
            return z;
        }
        AppMethodBeat.m2505o(134533);
        return false;
    }

    /* renamed from: g */
    public final boolean mo21476g(List<LocalUsageInfo> list, int i) {
        return false;
    }

    /* renamed from: a */
    public final List<LocalUsageInfo> mo21470a(int i, C10117a c10117a) {
        AppMethodBeat.m2504i(134534);
        Parcel parcel = (Parcel) XIPCInvoker.m83628a("com.tencent.mm", new QueryParams(i, c10117a), C42372aj.class);
        if (parcel != null) {
            ArrayList arrayList = new ArrayList();
            parcel.readTypedList(arrayList, LocalUsageInfo.CREATOR);
            List list = arrayList;
            AppMethodBeat.m2505o(134534);
            return list;
        }
        List<LocalUsageInfo> arrayList2 = new ArrayList(0);
        AppMethodBeat.m2505o(134534);
        return arrayList2;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(134535);
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.m83628a("com.tencent.mm", IPCVoid.eGH, C33108ac.class);
        if (iPCInteger != null) {
            int i = iPCInteger.value;
            AppMethodBeat.m2505o(134535);
            return i;
        }
        AppMethodBeat.m2505o(134535);
        return 0;
    }

    public final int awY() {
        AppMethodBeat.m2504i(134536);
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.m83628a("com.tencent.mm", IPCVoid.eGH, C46889ai.class);
        int i;
        if (iPCInteger != null) {
            i = iPCInteger.value;
            AppMethodBeat.m2505o(134536);
            return i;
        }
        i = C26783t.axI();
        AppMethodBeat.m2505o(134536);
        return i;
    }
}
