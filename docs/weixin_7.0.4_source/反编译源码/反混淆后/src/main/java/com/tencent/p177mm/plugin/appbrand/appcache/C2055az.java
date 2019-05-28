package com.tencent.p177mm.plugin.appbrand.appcache;

import android.support.p057v4.p065f.C6197a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.appbrand.appcache.C26751z.C19074a;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a.C10066a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a.C10067a;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.az */
public final class C2055az {
    private static volatile C2055az gVp = null;
    private final Map<String, Map<C2057a, Boolean>> gVq = new C6197a();
    public final C10072ap gVr = new C10072ap();

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.az$b */
    public static final class C2056b {
        public final String appId;
        public final String filePath;
        public final int gVs;
        public final int version;

        public C2056b(String str, String str2, int i, int i2) {
            this.appId = str;
            this.filePath = str2;
            this.version = i;
            this.gVs = i2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.az$a */
    public interface C2057a extends C26734a<C2056b, WxaPkgLoadProgress> {
    }

    public C2055az() {
        AppMethodBeat.m2504i(59528);
        AppMethodBeat.m2505o(59528);
    }

    public static C2055az awq() {
        AppMethodBeat.m2504i(59529);
        if (((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF() == null) {
            gVp = null;
            AppMethodBeat.m2505o(59529);
            return null;
        }
        if (gVp == null) {
            synchronized (C2055az.class) {
                try {
                    if (gVp == null) {
                        gVp = new C2055az();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(59529);
                    }
                }
            }
        }
        C2055az c2055az = gVp;
        AppMethodBeat.m2505o(59529);
        return c2055az;
    }

    public static void shutdown() {
        C2055az c2055az;
        AppMethodBeat.m2504i(59530);
        synchronized (C2055az.class) {
            try {
                c2055az = gVp;
                gVp = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(59530);
                }
            }
        }
        if (c2055az != null) {
            c2055az.gVr.gUn.shutdown();
        }
        AppMethodBeat.m2505o(59530);
    }

    /* renamed from: a */
    public static boolean m4221a(String str, int i, C2057a c2057a) {
        AppMethodBeat.m2504i(59531);
        boolean b = C2055az.m4224b("@LibraryAppId", 0, i, str, c2057a);
        AppMethodBeat.m2505o(59531);
        return b;
    }

    /* renamed from: a */
    static void m4215a(String str, C2057a c2057a) {
        AppMethodBeat.m2504i(59532);
        if (!(C5046bo.isNullOrNil(str) || c2057a == null)) {
            C2055az awq = C2055az.awq();
            if (awq != null) {
                synchronized (C2055az.class) {
                    try {
                        Map map = (Map) awq.gVq.get(str);
                        if (map == null) {
                            map = new HashMap();
                            C2055az.awq().gVq.put(str, map);
                        }
                        map.put(c2057a, Boolean.TRUE);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(59532);
                    }
                }
                return;
            }
        }
        AppMethodBeat.m2505o(59532);
    }

    /* renamed from: xJ */
    static Map<C2057a, Boolean> m4226xJ(String str) {
        AppMethodBeat.m2504i(59533);
        if (!C5046bo.isNullOrNil(str)) {
            C2055az awq = C2055az.awq();
            if (awq != null) {
                Map<C2057a, Boolean> map;
                synchronized (C2055az.class) {
                    try {
                        map = (Map) awq.gVq.remove(str);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(59533);
                    }
                }
                return map;
            }
        }
        AppMethodBeat.m2505o(59533);
        return null;
    }

    /* renamed from: xK */
    private static Map<C2057a, Boolean> m4227xK(String str) {
        AppMethodBeat.m2504i(59534);
        if (!C5046bo.isNullOrNil(str)) {
            C2055az awq = C2055az.awq();
            if (awq != null) {
                Map<C2057a, Boolean> map;
                synchronized (C2055az.class) {
                    try {
                        map = (Map) awq.gVq.get(str);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(59534);
                        }
                    }
                }
                if (map != null) {
                    map = new HashMap(map);
                }
                AppMethodBeat.m2505o(59534);
                return map;
            }
        }
        AppMethodBeat.m2505o(59534);
        return null;
    }

    /* renamed from: br */
    static void m4225br(String str, String str2) {
        AppMethodBeat.m2504i(59535);
        C2055az.m4217a(str, str2, C10067a.ENV_ERR, null);
        AppMethodBeat.m2505o(59535);
    }

    /* renamed from: a */
    static void m4214a(String str, WxaPkgLoadProgress wxaPkgLoadProgress) {
        AppMethodBeat.m2504i(59536);
        C4990ab.m7417i("MicroMsg.AppBrandWxaPkgUpdater", "hy: urlkey: %s, onProgressUpdate %s", str, wxaPkgLoadProgress);
        Map xK = C2055az.m4227xK(str);
        if (xK != null) {
            for (C2057a c2057a : xK.keySet()) {
                if (c2057a != null) {
                    c2057a.mo14966bl(wxaPkgLoadProgress);
                }
            }
            AppMethodBeat.m2505o(59536);
            return;
        }
        C4990ab.m7411d("MicroMsg.AppBrandWxaPkgUpdater", "callback progress, null callback urlKey = %s", str);
        AppMethodBeat.m2505o(59536);
    }

    /* renamed from: a */
    static boolean m4219a(C10065a c10065a, C2057a c2057a) {
        AppMethodBeat.m2504i(59537);
        if (C2055az.awq() == null) {
            C4990ab.m7412e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
            AppMethodBeat.m2505o(59537);
            return false;
        } else if (c10065a == null) {
            AppMethodBeat.m2505o(59537);
            return false;
        } else {
            C2055az.m4215a(c10065a.vdC, c2057a);
            int b = C2055az.awq().gVr.mo21430b(c10065a);
            if (b == 0 || b == 2) {
                AppMethodBeat.m2505o(59537);
                return true;
            }
            C2055az.m4217a(c10065a.vdC, c10065a.appId, C10067a.ENV_ERR, null);
            AppMethodBeat.m2505o(59537);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m4220a(String str, int i, int i2, int i3, String str2, C2057a c2057a) {
        C10065a c10065a = null;
        AppMethodBeat.m2504i(59538);
        if (C2055az.awq() == null) {
            C4990ab.m7412e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
            AppMethodBeat.m2505o(59538);
            return false;
        }
        C10065a c2050aq;
        if (!C5046bo.isNullOrNil(str) && !C5046bo.isNullOrNil(str2)) {
            switch (i) {
                case 0:
                case 12:
                case 13:
                case 14:
                    c2050aq = new C2050aq(str, i, i2, str2);
                    break;
                case 1:
                case 2:
                case 999:
                    c2050aq = new C26737ak(str, str2, i);
                    break;
                case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                case 10001:
                case 10002:
                case 10100:
                case 10101:
                case 10102:
                    c2050aq = new C38116bb(str2, str, i2, i);
                    break;
                default:
                    c2050aq = null;
                    break;
            }
        }
        c2050aq = null;
        if (c2050aq != null) {
            boolean z;
            if ("@LibraryAppId".equals(str)) {
                z = false;
            } else if (i != 0) {
                z = false;
            } else {
                z = true;
            }
            c2050aq.gVz = z;
            if (i3 > 2097152) {
                c2050aq.setReadTimeout(c2050aq.getReadTimeout() * 2);
                c2050aq.setConnectTimeout(c2050aq.getConnectTimeout() * 2);
            }
            c10065a = c2050aq;
        }
        if (c10065a == null) {
            C4990ab.m7413e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, create Null request, appId %s, pkgType %d, pkgVersion %d, url %s", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
            AppMethodBeat.m2505o(59538);
            return false;
        }
        boolean a = C2055az.m4219a(c10065a, c2057a);
        AppMethodBeat.m2505o(59538);
        return a;
    }

    /* renamed from: b */
    public static boolean m4224b(String str, int i, int i2, String str2, C2057a c2057a) {
        AppMethodBeat.m2504i(59539);
        boolean a = C2055az.m4220a(str, i, i2, 0, str2, c2057a);
        AppMethodBeat.m2505o(59539);
        return a;
    }

    /* renamed from: a */
    public static boolean m4222a(String str, int i, String str2, C2057a c2057a) {
        AppMethodBeat.m2504i(59540);
        boolean b = C2055az.m4224b(str, i, 1, str2, c2057a);
        AppMethodBeat.m2505o(59540);
        return b;
    }

    /* renamed from: a */
    public static boolean m4223a(String str, int i, String str2, C2057a c2057a, C10066a c10066a) {
        AppMethodBeat.m2504i(59541);
        if (C2055az.awq() == null) {
            C4990ab.m7412e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadDebugPkg with keyGen, get null updater instance!!!");
            AppMethodBeat.m2505o(59541);
            return false;
        }
        boolean a = C2055az.m4219a(new C26737ak(str, str2, i, c10066a), c2057a);
        AppMethodBeat.m2505o(59541);
        return a;
    }

    /* renamed from: a */
    static void m4217a(String str, String str2, C10067a c10067a, C2056b c2056b) {
        AppMethodBeat.m2504i(59542);
        Map xJ = C2055az.m4226xJ(str);
        if (xJ != null) {
            for (C2057a c2057a : xJ.keySet()) {
                if (c2057a != null) {
                    c2057a.mo14965a(str2, c10067a, c2056b);
                }
            }
            AppMethodBeat.m2505o(59542);
            return;
        }
        C4990ab.m7411d("MicroMsg.AppBrandWxaPkgUpdater", "callback, null callback appId = %s", str2);
        AppMethodBeat.m2505o(59542);
    }

    /* renamed from: a */
    static void m4216a(String str, String str2, C10067a c10067a) {
        AppMethodBeat.m2504i(59543);
        if (C2055az.awq() == null) {
            C4990ab.m7412e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadFail, get instance null !!!");
            AppMethodBeat.m2505o(59543);
            return;
        }
        C2055az.m4217a(str, str2, c10067a, null);
        AppMethodBeat.m2505o(59543);
    }

    /* renamed from: a */
    static void m4218a(String str, String str2, String str3, int i, int i2, C19074a c19074a) {
        AppMethodBeat.m2504i(59544);
        boolean kR = C33097a.m54089kR(i2);
        if (C2055az.awq() == null) {
            C4990ab.m7412e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, get instance null !!!");
            AppMethodBeat.m2505o(59544);
        } else if (C5046bo.isNullOrNil(str3)) {
            C4990ab.m7412e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
            C2055az.m4217a(str, str2, C10067a.LOCAL_FILE_NOT_FOUND, null);
            c19074a.avt();
            AppMethodBeat.m2505o(59544);
        } else if (!new File(str3).exists()) {
            C4990ab.m7412e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg file not exists");
            C2055az.m4217a(str, str2, C10067a.LOCAL_FILE_NOT_FOUND, null);
            c19074a.avt();
            AppMethodBeat.m2505o(59544);
        } else if (((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF() == null) {
            C4990ab.m7412e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
            C2055az.m4225br(str, str2);
            AppMethodBeat.m2505o(59544);
        } else {
            C31281at a = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60841a(str2, !kR ? i : 1, i2, new String[0]);
            if (a == null) {
                C4990ab.m7413e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", str2, Integer.valueOf(i), Integer.valueOf(i2));
                C2055az.m4217a(str, str2, C10067a.FAILED, null);
                AppMethodBeat.m2505o(59544);
                return;
            }
            boolean z;
            c19074a.avu();
            if (C5046bo.isNullOrNil(str2)) {
                z = false;
            } else if (str2.endsWith("__CODELIB__")) {
                z = true;
            } else {
                File file = new File(str3);
                String str4 = a.field_versionMd5;
                if (!kR) {
                    if (!C5046bo.nullAsNil(str4).equals(C1178g.m2589v(file))) {
                        C4990ab.m7413e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, record.md5(%s) != file.md5(%s)", str4, C1178g.m2589v(file));
                        z = false;
                    }
                }
                C45512ao c45512ao = new C45512ao(file);
                if (!c45512ao.gUe) {
                    c45512ao.close();
                    C4990ab.m7412e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg invalid");
                    file.delete();
                    z = false;
                } else if (c45512ao.avW()) {
                    c45512ao.close();
                    z = true;
                } else {
                    c45512ao.close();
                    C4990ab.m7412e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg readInfo failed");
                    file.delete();
                    z = false;
                }
            }
            c19074a.mo34298dz(z);
            if (z) {
                C4990ab.m7417i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", Boolean.valueOf(((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60864d(str2, i2, r1, str3)), str2, Integer.valueOf(i2), Integer.valueOf(r1), str3);
                C2055az.m4217a(str, str2, C10067a.OK, new C2056b(str2, str3, i, i2));
                AppMethodBeat.m2505o(59544);
                return;
            }
            C1173e.deleteFile(str3);
            C2055az.m4217a(str, str2, C10067a.PKG_INVALID, null);
            AppMethodBeat.m2505o(59544);
        }
    }
}
