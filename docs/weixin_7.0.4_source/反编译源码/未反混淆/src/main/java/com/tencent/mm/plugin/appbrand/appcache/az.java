package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class az {
    private static volatile az gVp = null;
    private final Map<String, Map<a, Boolean>> gVq = new android.support.v4.f.a();
    public final ap gVr = new ap();

    public static final class b {
        public final String appId;
        public final String filePath;
        public final int gVs;
        public final int version;

        public b(String str, String str2, int i, int i2) {
            this.appId = str;
            this.filePath = str2;
            this.version = i;
            this.gVs = i2;
        }
    }

    public interface a extends com.tencent.mm.plugin.appbrand.appcache.a.b.a<b, WxaPkgLoadProgress> {
    }

    public az() {
        AppMethodBeat.i(59528);
        AppMethodBeat.o(59528);
    }

    public static az awq() {
        AppMethodBeat.i(59529);
        if (((d) g.K(d.class)).xF() == null) {
            gVp = null;
            AppMethodBeat.o(59529);
            return null;
        }
        if (gVp == null) {
            synchronized (az.class) {
                try {
                    if (gVp == null) {
                        gVp = new az();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(59529);
                    }
                }
            }
        }
        az azVar = gVp;
        AppMethodBeat.o(59529);
        return azVar;
    }

    public static void shutdown() {
        az azVar;
        AppMethodBeat.i(59530);
        synchronized (az.class) {
            try {
                azVar = gVp;
                gVp = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(59530);
                }
            }
        }
        if (azVar != null) {
            azVar.gVr.gUn.shutdown();
        }
        AppMethodBeat.o(59530);
    }

    public static boolean a(String str, int i, a aVar) {
        AppMethodBeat.i(59531);
        boolean b = b("@LibraryAppId", 0, i, str, aVar);
        AppMethodBeat.o(59531);
        return b;
    }

    static void a(String str, a aVar) {
        AppMethodBeat.i(59532);
        if (!(bo.isNullOrNil(str) || aVar == null)) {
            az awq = awq();
            if (awq != null) {
                synchronized (az.class) {
                    try {
                        Map map = (Map) awq.gVq.get(str);
                        if (map == null) {
                            map = new HashMap();
                            awq().gVq.put(str, map);
                        }
                        map.put(aVar, Boolean.TRUE);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(59532);
                    }
                }
                return;
            }
        }
        AppMethodBeat.o(59532);
    }

    static Map<a, Boolean> xJ(String str) {
        AppMethodBeat.i(59533);
        if (!bo.isNullOrNil(str)) {
            az awq = awq();
            if (awq != null) {
                Map<a, Boolean> map;
                synchronized (az.class) {
                    try {
                        map = (Map) awq.gVq.remove(str);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(59533);
                    }
                }
                return map;
            }
        }
        AppMethodBeat.o(59533);
        return null;
    }

    private static Map<a, Boolean> xK(String str) {
        AppMethodBeat.i(59534);
        if (!bo.isNullOrNil(str)) {
            az awq = awq();
            if (awq != null) {
                Map<a, Boolean> map;
                synchronized (az.class) {
                    try {
                        map = (Map) awq.gVq.get(str);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(59534);
                        }
                    }
                }
                if (map != null) {
                    map = new HashMap(map);
                }
                AppMethodBeat.o(59534);
                return map;
            }
        }
        AppMethodBeat.o(59534);
        return null;
    }

    static void br(String str, String str2) {
        AppMethodBeat.i(59535);
        a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
        AppMethodBeat.o(59535);
    }

    static void a(String str, WxaPkgLoadProgress wxaPkgLoadProgress) {
        AppMethodBeat.i(59536);
        ab.i("MicroMsg.AppBrandWxaPkgUpdater", "hy: urlkey: %s, onProgressUpdate %s", str, wxaPkgLoadProgress);
        Map xK = xK(str);
        if (xK != null) {
            for (a aVar : xK.keySet()) {
                if (aVar != null) {
                    aVar.bl(wxaPkgLoadProgress);
                }
            }
            AppMethodBeat.o(59536);
            return;
        }
        ab.d("MicroMsg.AppBrandWxaPkgUpdater", "callback progress, null callback urlKey = %s", str);
        AppMethodBeat.o(59536);
    }

    static boolean a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar, a aVar2) {
        AppMethodBeat.i(59537);
        if (awq() == null) {
            ab.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
            AppMethodBeat.o(59537);
            return false;
        } else if (aVar == null) {
            AppMethodBeat.o(59537);
            return false;
        } else {
            a(aVar.vdC, aVar2);
            int b = awq().gVr.b(aVar);
            if (b == 0 || b == 2) {
                AppMethodBeat.o(59537);
                return true;
            }
            a(aVar.vdC, aVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
            AppMethodBeat.o(59537);
            return false;
        }
    }

    public static boolean a(String str, int i, int i2, int i3, String str2, a aVar) {
        com.tencent.mm.plugin.appbrand.appcache.a.a aVar2 = null;
        AppMethodBeat.i(59538);
        if (awq() == null) {
            ab.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
            AppMethodBeat.o(59538);
            return false;
        }
        com.tencent.mm.plugin.appbrand.appcache.a.a aqVar;
        if (!bo.isNullOrNil(str) && !bo.isNullOrNil(str2)) {
            switch (i) {
                case 0:
                case 12:
                case 13:
                case 14:
                    aqVar = new aq(str, i, i2, str2);
                    break;
                case 1:
                case 2:
                case 999:
                    aqVar = new ak(str, str2, i);
                    break;
                case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                case 10001:
                case 10002:
                case 10100:
                case 10101:
                case 10102:
                    aqVar = new bb(str2, str, i2, i);
                    break;
                default:
                    aqVar = null;
                    break;
            }
        }
        aqVar = null;
        if (aqVar != null) {
            boolean z;
            if ("@LibraryAppId".equals(str)) {
                z = false;
            } else if (i != 0) {
                z = false;
            } else {
                z = true;
            }
            aqVar.gVz = z;
            if (i3 > 2097152) {
                aqVar.setReadTimeout(aqVar.getReadTimeout() * 2);
                aqVar.setConnectTimeout(aqVar.getConnectTimeout() * 2);
            }
            aVar2 = aqVar;
        }
        if (aVar2 == null) {
            ab.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, create Null request, appId %s, pkgType %d, pkgVersion %d, url %s", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
            AppMethodBeat.o(59538);
            return false;
        }
        boolean a = a(aVar2, aVar);
        AppMethodBeat.o(59538);
        return a;
    }

    public static boolean b(String str, int i, int i2, String str2, a aVar) {
        AppMethodBeat.i(59539);
        boolean a = a(str, i, i2, 0, str2, aVar);
        AppMethodBeat.o(59539);
        return a;
    }

    public static boolean a(String str, int i, String str2, a aVar) {
        AppMethodBeat.i(59540);
        boolean b = b(str, i, 1, str2, aVar);
        AppMethodBeat.o(59540);
        return b;
    }

    public static boolean a(String str, int i, String str2, a aVar, com.tencent.mm.plugin.appbrand.appcache.a.a.a aVar2) {
        AppMethodBeat.i(59541);
        if (awq() == null) {
            ab.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadDebugPkg with keyGen, get null updater instance!!!");
            AppMethodBeat.o(59541);
            return false;
        }
        boolean a = a(new ak(str, str2, i, aVar2), aVar);
        AppMethodBeat.o(59541);
        return a;
    }

    static void a(String str, String str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a aVar, b bVar) {
        AppMethodBeat.i(59542);
        Map xJ = xJ(str);
        if (xJ != null) {
            for (a aVar2 : xJ.keySet()) {
                if (aVar2 != null) {
                    aVar2.a(str2, aVar, bVar);
                }
            }
            AppMethodBeat.o(59542);
            return;
        }
        ab.d("MicroMsg.AppBrandWxaPkgUpdater", "callback, null callback appId = %s", str2);
        AppMethodBeat.o(59542);
    }

    static void a(String str, String str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a aVar) {
        AppMethodBeat.i(59543);
        if (awq() == null) {
            ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadFail, get instance null !!!");
            AppMethodBeat.o(59543);
            return;
        }
        a(str, str2, aVar, null);
        AppMethodBeat.o(59543);
    }

    static void a(String str, String str2, String str3, int i, int i2, com.tencent.mm.plugin.appbrand.appcache.z.a aVar) {
        AppMethodBeat.i(59544);
        boolean kR = com.tencent.mm.plugin.appbrand.appcache.j.a.kR(i2);
        if (awq() == null) {
            ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, get instance null !!!");
            AppMethodBeat.o(59544);
        } else if (bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
            a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.LOCAL_FILE_NOT_FOUND, null);
            aVar.avt();
            AppMethodBeat.o(59544);
        } else if (!new File(str3).exists()) {
            ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg file not exists");
            a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.LOCAL_FILE_NOT_FOUND, null);
            aVar.avt();
            AppMethodBeat.o(59544);
        } else if (((d) g.K(d.class)).xF() == null) {
            ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
            br(str, str2);
            AppMethodBeat.o(59544);
        } else {
            at a = ((d) g.K(d.class)).xF().a(str2, !kR ? i : 1, i2, new String[0]);
            if (a == null) {
                ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", str2, Integer.valueOf(i), Integer.valueOf(i2));
                a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.FAILED, null);
                AppMethodBeat.o(59544);
                return;
            }
            boolean z;
            aVar.avu();
            if (bo.isNullOrNil(str2)) {
                z = false;
            } else if (str2.endsWith("__CODELIB__")) {
                z = true;
            } else {
                File file = new File(str3);
                String str4 = a.field_versionMd5;
                if (!kR) {
                    if (!bo.nullAsNil(str4).equals(com.tencent.mm.a.g.v(file))) {
                        ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, record.md5(%s) != file.md5(%s)", str4, com.tencent.mm.a.g.v(file));
                        z = false;
                    }
                }
                ao aoVar = new ao(file);
                if (!aoVar.gUe) {
                    aoVar.close();
                    ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg invalid");
                    file.delete();
                    z = false;
                } else if (aoVar.avW()) {
                    aoVar.close();
                    z = true;
                } else {
                    aoVar.close();
                    ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg readInfo failed");
                    file.delete();
                    z = false;
                }
            }
            aVar.dz(z);
            if (z) {
                ab.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", Boolean.valueOf(((d) g.K(d.class)).xF().d(str2, i2, r1, str3)), str2, Integer.valueOf(i2), Integer.valueOf(r1), str3);
                a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.OK, new b(str2, str3, i, i2));
                AppMethodBeat.o(59544);
                return;
            }
            e.deleteFile(str3);
            a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.PKG_INVALID, null);
            AppMethodBeat.o(59544);
        }
    }
}
