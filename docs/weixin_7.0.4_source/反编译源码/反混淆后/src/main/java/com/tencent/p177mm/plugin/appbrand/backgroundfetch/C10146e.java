package com.tencent.p177mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p242c.C1695b;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.e */
public final class C10146e implements C1695b, C26798h {
    private C42388d hcd;

    /* renamed from: SH */
    public final void mo5202SH() {
        AppMethodBeat.m2504i(129801);
        this.hcd = C42340f.ave();
        AppMethodBeat.m2505o(129801);
    }

    /* renamed from: SI */
    public final void mo5203SI() {
        this.hcd = null;
    }

    /* renamed from: a */
    public final boolean mo21499a(String str, int i, String str2, String str3, String str4, int i2, long j) {
        AppMethodBeat.m2504i(129802);
        if (this.hcd == null) {
            AppMethodBeat.m2505o(129802);
            return false;
        }
        boolean a = this.hcd.mo67888a(str, i, str2, str3, str4, i2, j);
        if (a) {
            C4990ab.m7411d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy set success(time:%s), app(%s_%d)", Long.valueOf(j), str, Integer.valueOf(i));
        } else {
            C4990ab.m7411d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy set fail, app(%s_%d)", str, Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(129802);
        return a;
    }

    /* renamed from: ao */
    public final boolean mo21502ao(String str, int i) {
        AppMethodBeat.m2504i(129803);
        if (this.hcd == null) {
            AppMethodBeat.m2505o(129803);
            return false;
        }
        boolean ao = this.hcd.mo67891ao(str, i);
        if (ao) {
            C4990ab.m7411d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy delete success, app(%s_%d)", str, Integer.valueOf(i));
        } else {
            C4990ab.m7411d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy delete fail, app(%s_%d)", str, Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(129803);
        return ao;
    }

    /* renamed from: aQ */
    public final long mo21500aQ(String str, int i) {
        AppMethodBeat.m2504i(129804);
        if (this.hcd == null) {
            AppMethodBeat.m2505o(129804);
            return 0;
        }
        long aQ = this.hcd.mo67889aQ(str, i);
        if (aQ > 0) {
            C4990ab.m7411d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getUpdateTime success(time:%s), app(%s_%d)", Long.valueOf(aQ), str, Integer.valueOf(i));
        } else {
            C4990ab.m7411d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getUpdateTime fail, app(%s_%d)", str, Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(129804);
        return aQ;
    }

    /* renamed from: aR */
    public final AppBrandBackgroundFetchDataParcel mo21501aR(String str, int i) {
        AppMethodBeat.m2504i(129805);
        if (this.hcd == null) {
            AppMethodBeat.m2505o(129805);
            return null;
        }
        AppBrandBackgroundFetchDataParcel aR = this.hcd.mo67890aR(str, i);
        if (aR == null) {
            C4990ab.m7411d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getByAppId fail, app(%s_%d)", str, Integer.valueOf(i));
        } else {
            C4990ab.m7411d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getByAppId success, app(%s_%d)", str, Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(129805);
        return aR;
    }
}
