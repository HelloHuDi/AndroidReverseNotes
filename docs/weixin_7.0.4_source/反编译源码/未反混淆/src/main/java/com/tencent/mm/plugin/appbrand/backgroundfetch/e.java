package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.platformtools.ab;

public final class e implements b, h {
    private d hcd;

    public final void SH() {
        AppMethodBeat.i(129801);
        this.hcd = f.ave();
        AppMethodBeat.o(129801);
    }

    public final void SI() {
        this.hcd = null;
    }

    public final boolean a(String str, int i, String str2, String str3, String str4, int i2, long j) {
        AppMethodBeat.i(129802);
        if (this.hcd == null) {
            AppMethodBeat.o(129802);
            return false;
        }
        boolean a = this.hcd.a(str, i, str2, str3, str4, i2, j);
        if (a) {
            ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy set success(time:%s), app(%s_%d)", Long.valueOf(j), str, Integer.valueOf(i));
        } else {
            ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy set fail, app(%s_%d)", str, Integer.valueOf(i));
        }
        AppMethodBeat.o(129802);
        return a;
    }

    public final boolean ao(String str, int i) {
        AppMethodBeat.i(129803);
        if (this.hcd == null) {
            AppMethodBeat.o(129803);
            return false;
        }
        boolean ao = this.hcd.ao(str, i);
        if (ao) {
            ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy delete success, app(%s_%d)", str, Integer.valueOf(i));
        } else {
            ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy delete fail, app(%s_%d)", str, Integer.valueOf(i));
        }
        AppMethodBeat.o(129803);
        return ao;
    }

    public final long aQ(String str, int i) {
        AppMethodBeat.i(129804);
        if (this.hcd == null) {
            AppMethodBeat.o(129804);
            return 0;
        }
        long aQ = this.hcd.aQ(str, i);
        if (aQ > 0) {
            ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getUpdateTime success(time:%s), app(%s_%d)", Long.valueOf(aQ), str, Integer.valueOf(i));
        } else {
            ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getUpdateTime fail, app(%s_%d)", str, Integer.valueOf(i));
        }
        AppMethodBeat.o(129804);
        return aQ;
    }

    public final AppBrandBackgroundFetchDataParcel aR(String str, int i) {
        AppMethodBeat.i(129805);
        if (this.hcd == null) {
            AppMethodBeat.o(129805);
            return null;
        }
        AppBrandBackgroundFetchDataParcel aR = this.hcd.aR(str, i);
        if (aR == null) {
            ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getByAppId fail, app(%s_%d)", str, Integer.valueOf(i));
        } else {
            ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getByAppId success, app(%s_%d)", str, Integer.valueOf(i));
        }
        AppMethodBeat.o(129805);
        return aR;
    }
}
