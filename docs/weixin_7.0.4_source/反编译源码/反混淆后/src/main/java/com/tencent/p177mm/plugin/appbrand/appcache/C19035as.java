package com.tencent.p177mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.appcache.C38104an.C33072a;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.as */
public enum C19035as {
    ;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.as$a */
    public enum C19036a {
        public static final C19036a gUI = null;
        public static final C19036a gUJ = null;
        public static final C19036a gUK = null;
        public static final C19036a gUL = null;
        public static final C19036a gUM = null;
        public static final C19036a gUN = null;
        private static final /* synthetic */ C19036a[] gUO = null;

        private C19036a(String str, int i) {
        }

        public static C19036a valueOf(String str) {
            AppMethodBeat.m2504i(59514);
            C19036a c19036a = (C19036a) Enum.valueOf(C19036a.class, str);
            AppMethodBeat.m2505o(59514);
            return c19036a;
        }

        public static C19036a[] values() {
            AppMethodBeat.m2504i(59513);
            C19036a[] c19036aArr = (C19036a[]) gUO.clone();
            AppMethodBeat.m2505o(59513);
            return c19036aArr;
        }

        static {
            AppMethodBeat.m2504i(59516);
            gUI = new C19036a("APP_READY", 0);
            gUJ = new C19036a("APP_MANIFEST_NULL", 1);
            gUK = new C19036a("PKG_EXPIRED", 2);
            gUL = new C19036a("APP_NOT_INSTALLED", 3);
            gUM = new C19036a("APP_BROKEN", 4);
            gUN = new C19036a("ENV_ERR", 5);
            gUO = new C19036a[]{gUI, gUJ, gUK, gUL, gUM, gUN};
            AppMethodBeat.m2505o(59516);
        }

        public final int awj() {
            AppMethodBeat.m2504i(59515);
            int ordinal = super.ordinal();
            AppMethodBeat.m2505o(59515);
            return ordinal;
        }
    }

    /* renamed from: ar */
    private static WxaPkgWrappingInfo m29612ar(String str, int i) {
        AppMethodBeat.m2504i(59519);
        if (!"@LibraryAppId".equals(str) || (i >= 0 && C38104an.VERSION < i)) {
            AppMethodBeat.m2505o(59519);
            return null;
        }
        C4990ab.m7417i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", Integer.valueOf(C38104an.VERSION), str, Integer.valueOf(0), Integer.valueOf(i));
        WxaPkgWrappingInfo avV = C38104an.avV();
        AppMethodBeat.m2505o(59519);
        return avV;
    }

    /* renamed from: dE */
    public static Pair<C19036a, WxaPkgWrappingInfo> m29613dE(boolean z) {
        AppMethodBeat.m2504i(59520);
        Pair p = C19035as.m29614p(z, false);
        AppMethodBeat.m2505o(59520);
        return p;
    }

    /* renamed from: p */
    public static Pair<C19036a, WxaPkgWrappingInfo> m29614p(boolean z, boolean z2) {
        AppMethodBeat.m2504i(59521);
        if (z && !(z2 && C38104an.gTU == C33072a.DEVELOP)) {
            C33065d c33065d = (C33065d) C1720g.m3528K(C33065d.class);
            if (c33065d != null) {
                C38105ax xF = c33065d.mo53635xF();
                if (xF != null) {
                    WxaPkgWrappingInfo ar = C19035as.m29612ar("@LibraryAppId", xF.mo60853au("@LibraryAppId", 0));
                    if (ar != null) {
                        C4990ab.m7417i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, dbMax %d, local %d, use local", Integer.valueOf(r0), Integer.valueOf(C38104an.VERSION));
                        Pair<C19036a, WxaPkgWrappingInfo> create = Pair.create(C19036a.gUI, ar);
                        AppMethodBeat.m2505o(59521);
                        return create;
                    }
                }
            }
            Pair create2 = Pair.create(C19036a.gUI, C38104an.avV());
            AppMethodBeat.m2505o(59521);
            return create2;
        }
        C4990ab.m7417i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, release %b, skipLocalDevPack %b, localPackMode %s, checkRecordResult %s", Boolean.valueOf(z), Boolean.valueOf(z2), C38104an.gTU, C19035as.m29615v("@LibraryAppId", z ? 0 : 999, -1).first);
        AppMethodBeat.m2505o(59521);
        return C19035as.m29615v("@LibraryAppId", z ? 0 : 999, -1);
    }

    /* renamed from: v */
    public static Pair<C19036a, WxaPkgWrappingInfo> m29615v(String str, int i, int i2) {
        AppMethodBeat.m2504i(59522);
        if (!C1720g.m3534RN().eJb || ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF() == null) {
            C4990ab.m7413e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
            Pair create = Pair.create(C19036a.gUN, null);
            AppMethodBeat.m2505o(59522);
            return create;
        }
        C31281at a;
        String[] strArr = new String[]{"pkgPath", "versionMd5", "version", "createTime", "startTime", "endTime"};
        if (!C33097a.m54090np(i) || i2 <= 0) {
            a = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60842a(str, i, strArr);
        } else {
            a = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60841a(str, i2, i, strArr);
        }
        Pair<C19036a, WxaPkgWrappingInfo> create2;
        if (a == null) {
            C4990ab.m7413e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
            create2 = Pair.create(C19036a.gUJ, null);
            AppMethodBeat.m2505o(59522);
            return create2;
        }
        int i3;
        if (i == 999) {
            C4990ab.m7417i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg for dev_lib, time_scope[%d, %d]", Long.valueOf(a.field_startTime), Long.valueOf(a.field_endTime));
            if (a.field_endTime > 0 && a.field_endTime <= C5046bo.anT()) {
                create2 = Pair.create(C19036a.gUK, null);
                AppMethodBeat.m2505o(59522);
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
        if (C5046bo.isNullOrNil(str2) || !C5730e.m8628ct(str2)) {
            C4990ab.m7413e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", str2, str, Integer.valueOf(i), Integer.valueOf(i3));
            create2 = Pair.create(C19036a.gUM, null);
            AppMethodBeat.m2505o(59522);
            return create2;
        }
        String atg = C5730e.atg(str2);
        if (C5046bo.isNullOrNil(str3) || str3.equals(atg)) {
            if (!C5046bo.isNullOrNil(str)) {
                if (str.endsWith("__CODELIB__")) {
                    wxaPkgWrappingInfo = WxaPkgWrappingInfo.m54057xN(str2);
                } else {
                    wxaPkgWrappingInfo = WxaPkgWrappingInfo.m54056xM(str2);
                }
            }
            if (wxaPkgWrappingInfo == null) {
                C4990ab.m7413e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "obtain wxPkg failed, appId = %s, debugType = %d, version = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
                create2 = Pair.create(C19036a.gUM, null);
                AppMethodBeat.m2505o(59522);
                return create2;
            }
            wxaPkgWrappingInfo.gVu = i3;
            wxaPkgWrappingInfo.gVv = j;
            wxaPkgWrappingInfo.gSP = str2;
            wxaPkgWrappingInfo.gVw = false;
            wxaPkgWrappingInfo.gVt = i;
            wxaPkgWrappingInfo.cvZ = atg;
            C4990ab.m7417i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, startTime = %d, endTime = %d, return %s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(a.field_startTime), Long.valueOf(a.field_endTime), wxaPkgWrappingInfo);
            create2 = Pair.create(C19036a.gUI, wxaPkgWrappingInfo);
            AppMethodBeat.m2505o(59522);
            return create2;
        }
        C4990ab.m7413e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "md5 mismatch | realMd5 = %s, manifestMd5 = %s, appId = %s, debugType = %d, version = %d", atg, str3, str, Integer.valueOf(i), Integer.valueOf(i2));
        create2 = Pair.create(C19036a.gUM, null);
        AppMethodBeat.m2505o(59522);
        return create2;
    }
}
