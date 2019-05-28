package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public enum as {
    ;

    public enum a {
        public static final a gUI = null;
        public static final a gUJ = null;
        public static final a gUK = null;
        public static final a gUL = null;
        public static final a gUM = null;
        public static final a gUN = null;
        private static final /* synthetic */ a[] gUO = null;

        private a(String str, int i) {
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(59514);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(59514);
            return aVar;
        }

        public static a[] values() {
            AppMethodBeat.i(59513);
            a[] aVarArr = (a[]) gUO.clone();
            AppMethodBeat.o(59513);
            return aVarArr;
        }

        static {
            AppMethodBeat.i(59516);
            gUI = new a("APP_READY", 0);
            gUJ = new a("APP_MANIFEST_NULL", 1);
            gUK = new a("PKG_EXPIRED", 2);
            gUL = new a("APP_NOT_INSTALLED", 3);
            gUM = new a("APP_BROKEN", 4);
            gUN = new a("ENV_ERR", 5);
            gUO = new a[]{gUI, gUJ, gUK, gUL, gUM, gUN};
            AppMethodBeat.o(59516);
        }

        public final int awj() {
            AppMethodBeat.i(59515);
            int ordinal = super.ordinal();
            AppMethodBeat.o(59515);
            return ordinal;
        }
    }

    private static WxaPkgWrappingInfo ar(String str, int i) {
        AppMethodBeat.i(59519);
        if (!"@LibraryAppId".equals(str) || (i >= 0 && an.VERSION < i)) {
            AppMethodBeat.o(59519);
            return null;
        }
        ab.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", Integer.valueOf(an.VERSION), str, Integer.valueOf(0), Integer.valueOf(i));
        WxaPkgWrappingInfo avV = an.avV();
        AppMethodBeat.o(59519);
        return avV;
    }

    public static Pair<a, WxaPkgWrappingInfo> dE(boolean z) {
        AppMethodBeat.i(59520);
        Pair p = p(z, false);
        AppMethodBeat.o(59520);
        return p;
    }

    public static Pair<a, WxaPkgWrappingInfo> p(boolean z, boolean z2) {
        AppMethodBeat.i(59521);
        if (z && !(z2 && an.gTU == a.DEVELOP)) {
            d dVar = (d) g.K(d.class);
            if (dVar != null) {
                ax xF = dVar.xF();
                if (xF != null) {
                    WxaPkgWrappingInfo ar = ar("@LibraryAppId", xF.au("@LibraryAppId", 0));
                    if (ar != null) {
                        ab.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, dbMax %d, local %d, use local", Integer.valueOf(r0), Integer.valueOf(an.VERSION));
                        Pair<a, WxaPkgWrappingInfo> create = Pair.create(a.gUI, ar);
                        AppMethodBeat.o(59521);
                        return create;
                    }
                }
            }
            Pair create2 = Pair.create(a.gUI, an.avV());
            AppMethodBeat.o(59521);
            return create2;
        }
        ab.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, release %b, skipLocalDevPack %b, localPackMode %s, checkRecordResult %s", Boolean.valueOf(z), Boolean.valueOf(z2), an.gTU, v("@LibraryAppId", z ? 0 : 999, -1).first);
        AppMethodBeat.o(59521);
        return v("@LibraryAppId", z ? 0 : 999, -1);
    }

    public static Pair<a, WxaPkgWrappingInfo> v(String str, int i, int i2) {
        AppMethodBeat.i(59522);
        if (!g.RN().eJb || ((d) g.K(d.class)).xF() == null) {
            ab.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
            Pair create = Pair.create(a.gUN, null);
            AppMethodBeat.o(59522);
            return create;
        }
        at a;
        String[] strArr = new String[]{"pkgPath", "versionMd5", "version", "createTime", "startTime", "endTime"};
        if (!com.tencent.mm.plugin.appbrand.appcache.j.a.np(i) || i2 <= 0) {
            a = ((d) g.K(d.class)).xF().a(str, i, strArr);
        } else {
            a = ((d) g.K(d.class)).xF().a(str, i2, i, strArr);
        }
        Pair<a, WxaPkgWrappingInfo> create2;
        if (a == null) {
            ab.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
            create2 = Pair.create(a.gUJ, null);
            AppMethodBeat.o(59522);
            return create2;
        }
        int i3;
        if (i == 999) {
            ab.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg for dev_lib, time_scope[%d, %d]", Long.valueOf(a.field_startTime), Long.valueOf(a.field_endTime));
            if (a.field_endTime > 0 && a.field_endTime <= bo.anT()) {
                create2 = Pair.create(a.gUK, null);
                AppMethodBeat.o(59522);
                return create2;
            }
        }
        String str2 = a.field_pkgPath;
        String str3 = a.field_versionMd5;
        if (i2 < 0) {
            i3 = a.field_version;
        } else {
            i3 = i2;
        }
        long j = a.field_createTime;
        WxaPkgWrappingInfo wxaPkgWrappingInfo = null;
        if (bo.isNullOrNil(str2) || !e.ct(str2)) {
            ab.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", str2, str, Integer.valueOf(i), Integer.valueOf(i3));
            create2 = Pair.create(a.gUM, null);
            AppMethodBeat.o(59522);
            return create2;
        }
        String atg = e.atg(str2);
        if (bo.isNullOrNil(str3) || str3.equals(atg)) {
            if (!bo.isNullOrNil(str)) {
                if (str.endsWith("__CODELIB__")) {
                    wxaPkgWrappingInfo = WxaPkgWrappingInfo.xN(str2);
                } else {
                    wxaPkgWrappingInfo = WxaPkgWrappingInfo.xM(str2);
                }
            }
            if (wxaPkgWrappingInfo == null) {
                ab.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "obtain wxPkg failed, appId = %s, debugType = %d, version = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
                create2 = Pair.create(a.gUM, null);
                AppMethodBeat.o(59522);
                return create2;
            }
            wxaPkgWrappingInfo.gVu = i3;
            wxaPkgWrappingInfo.gVv = j;
            wxaPkgWrappingInfo.gSP = str2;
            wxaPkgWrappingInfo.gVw = false;
            wxaPkgWrappingInfo.gVt = i;
            wxaPkgWrappingInfo.cvZ = atg;
            ab.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, startTime = %d, endTime = %d, return %s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(a.field_startTime), Long.valueOf(a.field_endTime), wxaPkgWrappingInfo);
            create2 = Pair.create(a.gUI, wxaPkgWrappingInfo);
            AppMethodBeat.o(59522);
            return create2;
        }
        ab.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "md5 mismatch | realMd5 = %s, manifestMd5 = %s, appId = %s, debugType = %d, version = %d", atg, str3, str, Integer.valueOf(i), Integer.valueOf(i2));
        create2 = Pair.create(a.gUM, null);
        AppMethodBeat.o(59522);
        return create2;
    }
}
