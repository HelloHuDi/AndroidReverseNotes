package com.tencent.p177mm.plugin.appbrand.p329s;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.page.C38475s;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
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

/* renamed from: com.tencent.mm.plugin.appbrand.s.b */
public final class C45682b {
    private static final String fqf;
    private static ConcurrentMap<String, Boolean> iRc = new ConcurrentHashMap();
    private static Map<String, List<C19711a>> iRd = new HashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.s.b$a */
    public interface C19711a {
        /* renamed from: AN */
        void mo21737AN(String str);
    }

    static {
        AppMethodBeat.m2504i(87406);
        String str = C6457e.eSn;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "wxacache/";
        fqf = str;
        C15428j.aih(str);
        AppMethodBeat.m2505o(87406);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m84381a(C2241c c2241c, final String str, final String str2, final C19711a c19711a) {
        int i = 1;
        AppMethodBeat.m2504i(87397);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(87397);
        } else if (c19711a == null) {
            AppMethodBeat.m2505o(87397);
        } else {
            String absolutePath;
            if (str.startsWith("wxfile://")) {
                C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, url:%s", str);
                if (c2241c == null) {
                    C4990ab.m7416i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, component is null");
                } else {
                    File yg = c2241c.asE().mo34314yg(str);
                    if (yg != null && yg.exists()) {
                        absolutePath = yg.getAbsolutePath();
                        C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, localPath:%s", absolutePath);
                        if (C45682b.m84385cS(str2, absolutePath) && c19711a != null) {
                            c19711a.mo21737AN(absolutePath);
                            if (i == 0) {
                                C45682b.m84382b(c19711a);
                                AppMethodBeat.m2505o(87397);
                                return;
                            }
                        }
                    }
                }
                i = 0;
                if (i == 0) {
                }
            } else if (str.startsWith("http://") || str.startsWith("https://")) {
                C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, url:%s", str);
                absolutePath = C45682b.m84379Eg(str);
                C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, localPath:%s", absolutePath);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(87394);
                        if (!C45682b.iRd.containsKey(str)) {
                            C45682b.iRd.put(str, new ArrayList());
                        }
                        ((List) C45682b.iRd.get(str)).add(c19711a);
                        AppMethodBeat.m2505o(87394);
                    }
                });
                C7305d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(87395);
                        C45682b.m84380F(str, str2, absolutePath);
                        AppMethodBeat.m2505o(87395);
                    }
                }, "AppBrandLiveFileLoadHelperThread");
                AppMethodBeat.m2505o(87397);
                return;
            } else if (!C45682b.m84383b(c2241c, str, str2, c19711a)) {
                C45682b.m84382b(c19711a);
            }
            AppMethodBeat.m2505o(87397);
        }
    }

    /* renamed from: b */
    private static void m84382b(C19711a c19711a) {
        AppMethodBeat.m2504i(87398);
        if (c19711a != null) {
            c19711a.mo21737AN(null);
        }
        AppMethodBeat.m2505o(87398);
    }

    /* renamed from: b */
    private static boolean m84383b(C2241c c2241c, String str, String str2, C19711a c19711a) {
        AppMethodBeat.m2504i(87399);
        C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, url:%s", str);
        if (c2241c == null) {
            C4990ab.m7416i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, component is null");
            AppMethodBeat.m2505o(87399);
            return false;
        } else if (c2241c instanceof C33327h) {
            C6750i runtime = ((C33327h) c2241c).getRuntime();
            if (runtime == null) {
                C4990ab.m7416i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, runtime is null");
                AppMethodBeat.m2505o(87399);
                return false;
            }
            String Eg = C45682b.m84379Eg(str);
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, localPath:%s", Eg);
            if (!new File(Eg).exists()) {
                Bitmap j = C38475s.m65114j(runtime, str);
                if (j == null || j.isRecycled()) {
                    C4990ab.m7412e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, no bitmap in the given url");
                    AppMethodBeat.m2505o(87399);
                    return false;
                }
                try {
                    C5056d.m7625a(j, 100, CompressFormat.PNG, Eg, true);
                    if (!(j == null || j.isRecycled())) {
                        C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", j);
                        j.recycle();
                    }
                } catch (IOException e) {
                    C4990ab.m7413e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, fail to compress bitmap to file", e);
                    if (!(j == null || j.isRecycled())) {
                        C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", j);
                        j.recycle();
                    }
                    AppMethodBeat.m2505o(87399);
                    return false;
                } catch (Throwable th) {
                    if (!(j == null || j.isRecycled())) {
                        C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", j);
                        j.recycle();
                    }
                    AppMethodBeat.m2505o(87399);
                }
            }
            if (!C45682b.m84385cS(str2, Eg)) {
                C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, file exists but md5 not valid, deleted:%b", Boolean.valueOf(r4.delete()));
            } else if (c19711a != null) {
                c19711a.mo21737AN(Eg);
                AppMethodBeat.m2505o(87399);
                return true;
            }
            AppMethodBeat.m2505o(87399);
            return false;
        } else {
            C4990ab.m7416i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, can not get runtime from component");
            AppMethodBeat.m2505o(87399);
            return false;
        }
    }

    /* renamed from: cR */
    private static void m84384cR(final String str, final String str2) {
        AppMethodBeat.m2504i(87400);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87396);
                C45682b.m84386cT(str, str2);
                AppMethodBeat.m2505o(87396);
            }
        });
        AppMethodBeat.m2505o(87400);
    }

    /* renamed from: Eg */
    private static String m84379Eg(String str) {
        AppMethodBeat.m2504i(87401);
        String pE = C45682b.m84387pE(str);
        pE = String.format("%s%s", new Object[]{fqf, pE});
        AppMethodBeat.m2505o(87401);
        return pE;
    }

    /* renamed from: pE */
    private static String m84387pE(String str) {
        AppMethodBeat.m2504i(87402);
        String str2 = null;
        if (!C5046bo.isNullOrNil(str)) {
            str2 = C1178g.m2591x(str.getBytes());
        }
        AppMethodBeat.m2505o(87402);
        return str2;
    }

    /* renamed from: cS */
    private static boolean m84385cS(String str, String str2) {
        AppMethodBeat.m2504i(87403);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid target nil, no check");
            AppMethodBeat.m2505o(87403);
            return true;
        }
        C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid file:%s target:%s", C1178g.m2587cz(str2), str);
        boolean equals = str.equals(r1);
        AppMethodBeat.m2505o(87403);
        return equals;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: F */
    static /* synthetic */ void m84380F(String str, String str2, String str3) {
        Throwable e;
        AppMethodBeat.m2504i(87404);
        File file = new File(str3);
        if (file.exists()) {
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download already exists: %s", str);
            if (C45682b.m84385cS(str2, str3)) {
                C45682b.m84384cR(str, str3);
                AppMethodBeat.m2505o(87404);
                return;
            }
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download already exists, but md5 not valid. deleted:%b", Boolean.valueOf(file.delete()));
        }
        if (iRc.containsKey(str)) {
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download ing: %s", str);
            AppMethodBeat.m2505o(87404);
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
                    C5046bo.m7527b(fileOutputStream);
                    C5046bo.m7527b(bufferedInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        file.delete();
                        C4990ab.printErrStackTrace("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", e, "download file url %s ", str);
                        C5046bo.m7527b(fileOutputStream);
                        C5046bo.m7527b(bufferedInputStream);
                        C4990ab.m7416i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download done");
                        iRc.remove(str);
                        if (C45682b.m84385cS(str2, str3)) {
                        }
                    } catch (Throwable th) {
                        e = th;
                        C5046bo.m7527b(fileOutputStream);
                        C5046bo.m7527b(bufferedInputStream);
                        AppMethodBeat.m2505o(87404);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = null;
                file.delete();
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", e, "download file url %s ", str);
                C5046bo.m7527b(fileOutputStream);
                C5046bo.m7527b(bufferedInputStream);
                C4990ab.m7416i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download done");
                iRc.remove(str);
                if (C45682b.m84385cS(str2, str3)) {
                }
            } catch (Throwable th2) {
                e = th2;
                bufferedInputStream = null;
                C5046bo.m7527b(fileOutputStream);
                C5046bo.m7527b(bufferedInputStream);
                AppMethodBeat.m2505o(87404);
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            bufferedInputStream = null;
            file.delete();
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", e, "download file url %s ", str);
            C5046bo.m7527b(fileOutputStream);
            C5046bo.m7527b(bufferedInputStream);
            C4990ab.m7416i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download done");
            iRc.remove(str);
            if (C45682b.m84385cS(str2, str3)) {
            }
        } catch (Throwable th3) {
            e = th3;
            fileOutputStream = null;
            bufferedInputStream = null;
            C5046bo.m7527b(fileOutputStream);
            C5046bo.m7527b(bufferedInputStream);
            AppMethodBeat.m2505o(87404);
            throw e;
        }
        C4990ab.m7416i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download done");
        iRc.remove(str);
        if (C45682b.m84385cS(str2, str3)) {
            C45682b.m84384cR(str, str3);
            AppMethodBeat.m2505o(87404);
            return;
        }
        C4990ab.m7420w("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download md5 not valid");
        C45682b.m84384cR(str, null);
        AppMethodBeat.m2505o(87404);
    }

    /* renamed from: cT */
    static /* synthetic */ void m84386cT(String str, String str2) {
        int i = 0;
        AppMethodBeat.m2504i(87405);
        C4990ab.m7417i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "doCallback url:%s, localPath:%s", str, str2);
        List list = (List) iRd.get(str);
        if (list == null || list.size() == 0) {
            C4990ab.m7416i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "doCallback callbacks nil");
            AppMethodBeat.m2505o(87405);
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                ((C19711a) list.get(i2)).mo21737AN(str2);
                i = i2 + 1;
            } else {
                iRd.remove(str);
                AppMethodBeat.m2505o(87405);
                return;
            }
        }
    }
}
