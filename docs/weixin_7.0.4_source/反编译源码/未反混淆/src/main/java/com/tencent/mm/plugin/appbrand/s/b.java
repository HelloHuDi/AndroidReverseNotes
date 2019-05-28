package com.tencent.mm.plugin.appbrand.s;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class b {
    private static final String fqf;
    private static ConcurrentMap<String, Boolean> iRc = new ConcurrentHashMap();
    private static Map<String, List<a>> iRd = new HashMap();

    public interface a {
        void AN(String str);
    }

    static {
        AppMethodBeat.i(87406);
        String str = e.eSn;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "wxacache/";
        fqf = str;
        j.aih(str);
        AppMethodBeat.o(87406);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(c cVar, final String str, final String str2, final a aVar) {
        int i = 1;
        AppMethodBeat.i(87397);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(87397);
        } else if (aVar == null) {
            AppMethodBeat.o(87397);
        } else {
            String absolutePath;
            if (str.startsWith("wxfile://")) {
                ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, url:%s", str);
                if (cVar == null) {
                    ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, component is null");
                } else {
                    File yg = cVar.asE().yg(str);
                    if (yg != null && yg.exists()) {
                        absolutePath = yg.getAbsolutePath();
                        ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, localPath:%s", absolutePath);
                        if (cS(str2, absolutePath) && aVar != null) {
                            aVar.AN(absolutePath);
                            if (i == 0) {
                                b(aVar);
                                AppMethodBeat.o(87397);
                                return;
                            }
                        }
                    }
                }
                i = 0;
                if (i == 0) {
                }
            } else if (str.startsWith("http://") || str.startsWith("https://")) {
                ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, url:%s", str);
                absolutePath = Eg(str);
                ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, localPath:%s", absolutePath);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(87394);
                        if (!b.iRd.containsKey(str)) {
                            b.iRd.put(str, new ArrayList());
                        }
                        ((List) b.iRd.get(str)).add(aVar);
                        AppMethodBeat.o(87394);
                    }
                });
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(87395);
                        b.F(str, str2, absolutePath);
                        AppMethodBeat.o(87395);
                    }
                }, "AppBrandLiveFileLoadHelperThread");
                AppMethodBeat.o(87397);
                return;
            } else if (!b(cVar, str, str2, aVar)) {
                b(aVar);
            }
            AppMethodBeat.o(87397);
        }
    }

    private static void b(a aVar) {
        AppMethodBeat.i(87398);
        if (aVar != null) {
            aVar.AN(null);
        }
        AppMethodBeat.o(87398);
    }

    private static boolean b(c cVar, String str, String str2, a aVar) {
        AppMethodBeat.i(87399);
        ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, url:%s", str);
        if (cVar == null) {
            ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, component is null");
            AppMethodBeat.o(87399);
            return false;
        } else if (cVar instanceof h) {
            i runtime = ((h) cVar).getRuntime();
            if (runtime == null) {
                ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, runtime is null");
                AppMethodBeat.o(87399);
                return false;
            }
            String Eg = Eg(str);
            ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, localPath:%s", Eg);
            if (!new File(Eg).exists()) {
                Bitmap j = s.j(runtime, str);
                if (j == null || j.isRecycled()) {
                    ab.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, no bitmap in the given url");
                    AppMethodBeat.o(87399);
                    return false;
                }
                try {
                    com.tencent.mm.sdk.platformtools.d.a(j, 100, CompressFormat.PNG, Eg, true);
                    if (!(j == null || j.isRecycled())) {
                        ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", j);
                        j.recycle();
                    }
                } catch (IOException e) {
                    ab.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, fail to compress bitmap to file", e);
                    if (!(j == null || j.isRecycled())) {
                        ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", j);
                        j.recycle();
                    }
                    AppMethodBeat.o(87399);
                    return false;
                } catch (Throwable th) {
                    if (!(j == null || j.isRecycled())) {
                        ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", j);
                        j.recycle();
                    }
                    AppMethodBeat.o(87399);
                }
            }
            if (!cS(str2, Eg)) {
                ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, file exists but md5 not valid, deleted:%b", Boolean.valueOf(r4.delete()));
            } else if (aVar != null) {
                aVar.AN(Eg);
                AppMethodBeat.o(87399);
                return true;
            }
            AppMethodBeat.o(87399);
            return false;
        } else {
            ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, can not get runtime from component");
            AppMethodBeat.o(87399);
            return false;
        }
    }

    private static void cR(final String str, final String str2) {
        AppMethodBeat.i(87400);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87396);
                b.cT(str, str2);
                AppMethodBeat.o(87396);
            }
        });
        AppMethodBeat.o(87400);
    }

    private static String Eg(String str) {
        AppMethodBeat.i(87401);
        String pE = pE(str);
        pE = String.format("%s%s", new Object[]{fqf, pE});
        AppMethodBeat.o(87401);
        return pE;
    }

    private static String pE(String str) {
        AppMethodBeat.i(87402);
        String str2 = null;
        if (!bo.isNullOrNil(str)) {
            str2 = g.x(str.getBytes());
        }
        AppMethodBeat.o(87402);
        return str2;
    }

    private static boolean cS(String str, String str2) {
        AppMethodBeat.i(87403);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid target nil, no check");
            AppMethodBeat.o(87403);
            return true;
        }
        ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid file:%s target:%s", g.cz(str2), str);
        boolean equals = str.equals(r1);
        AppMethodBeat.o(87403);
        return equals;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void F(String str, String str2, String str3) {
        Throwable e;
        AppMethodBeat.i(87404);
        File file = new File(str3);
        if (file.exists()) {
            ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download already exists: %s", str);
            if (cS(str2, str3)) {
                cR(str, str3);
                AppMethodBeat.o(87404);
                return;
            }
            ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download already exists, but md5 not valid. deleted:%b", Boolean.valueOf(file.delete()));
        }
        if (iRc.containsKey(str)) {
            ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download ing: %s", str);
            AppMethodBeat.o(87404);
            return;
        }
        iRc.put(str, Boolean.TRUE);
        Closeable fileOutputStream;
        Closeable bufferedInputStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 16384);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    bo.b(fileOutputStream);
                    bo.b(bufferedInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        file.delete();
                        ab.printErrStackTrace("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", e, "download file url %s ", str);
                        bo.b(fileOutputStream);
                        bo.b(bufferedInputStream);
                        ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download done");
                        iRc.remove(str);
                        if (cS(str2, str3)) {
                        }
                    } catch (Throwable th) {
                        e = th;
                        bo.b(fileOutputStream);
                        bo.b(bufferedInputStream);
                        AppMethodBeat.o(87404);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = null;
                file.delete();
                ab.printErrStackTrace("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", e, "download file url %s ", str);
                bo.b(fileOutputStream);
                bo.b(bufferedInputStream);
                ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download done");
                iRc.remove(str);
                if (cS(str2, str3)) {
                }
            } catch (Throwable th2) {
                e = th2;
                bufferedInputStream = null;
                bo.b(fileOutputStream);
                bo.b(bufferedInputStream);
                AppMethodBeat.o(87404);
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            bufferedInputStream = null;
            file.delete();
            ab.printErrStackTrace("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", e, "download file url %s ", str);
            bo.b(fileOutputStream);
            bo.b(bufferedInputStream);
            ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download done");
            iRc.remove(str);
            if (cS(str2, str3)) {
            }
        } catch (Throwable th3) {
            e = th3;
            fileOutputStream = null;
            bufferedInputStream = null;
            bo.b(fileOutputStream);
            bo.b(bufferedInputStream);
            AppMethodBeat.o(87404);
            throw e;
        }
        ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download done");
        iRc.remove(str);
        if (cS(str2, str3)) {
            cR(str, str3);
            AppMethodBeat.o(87404);
            return;
        }
        ab.w("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download md5 not valid");
        cR(str, null);
        AppMethodBeat.o(87404);
    }

    static /* synthetic */ void cT(String str, String str2) {
        int i = 0;
        AppMethodBeat.i(87405);
        ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "doCallback url:%s, localPath:%s", str, str2);
        List list = (List) iRd.get(str);
        if (list == null || list.size() == 0) {
            ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "doCallback callbacks nil");
            AppMethodBeat.o(87405);
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                ((a) list.get(i2)).AN(str2);
                i = i2 + 1;
            } else {
                iRd.remove(str);
                AppMethodBeat.o(87405);
                return;
            }
        }
    }
}
