package com.tencent.mm.bu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONObject;

public final class a {
    public static final String lhL = (e.eSk + "beauty/");
    public static final String xtJ = (lhL + "libalgo_rithm_jni.so");
    public static final String xtK = (lhL + "ziran_lf.png");
    public static volatile boolean xtL = false;
    public static a xtM = new a();
    public c<bf> fAP = new c<bf>() {
        {
            AppMethodBeat.i(71492);
            this.xxI = bf.class.getName().hashCode();
            AppMethodBeat.o(71492);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(71493);
            final bf bfVar = (bf) bVar;
            if (bfVar.cus.cut == 56) {
                ab.i("MicroMsg.BeautyDownloadLogic", "download res finish, path: %s, fileVersion: %s, fileUpdated: %s", bfVar.cus.filePath, Integer.valueOf(bfVar.cus.cuv), Boolean.valueOf(bfVar.cus.cuw));
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(71491);
                        h.pYm.k(914, 5, 1);
                        a.a(a.this, bfVar.cus.filePath, bfVar.cus.cut, bfVar.cus.cuu, bfVar.cus.cuv);
                        AppMethodBeat.o(71491);
                    }
                });
            }
            AppMethodBeat.o(71493);
            return false;
        }
    };

    public a() {
        AppMethodBeat.i(71494);
        AppMethodBeat.o(71494);
    }

    static /* synthetic */ void a(a aVar, String str, int i, int i2, int i3) {
        AppMethodBeat.i(71499);
        aVar.e(str, i, i2, i3);
        AppMethodBeat.o(71499);
    }

    static {
        AppMethodBeat.i(71500);
        AppMethodBeat.o(71500);
    }

    public static boolean agb() {
        int i;
        boolean z;
        AppMethodBeat.i(71495);
        if (com.tencent.mm.vfs.e.ct(xtJ)) {
            ab.i("MicroMsg.BeautyDownloadLogic", "file %s exist, set beauty so path", xtJ);
            i = 1;
        } else {
            i = 0;
        }
        int i2;
        if (com.tencent.mm.vfs.e.ct(xtK)) {
            ab.i("MicroMsg.BeautyDownloadLogic", "file %s exist, set filter res path", xtK);
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == 0 || i2 == 0) {
            z = false;
        } else {
            z = true;
        }
        xtL = z;
        if (i == 0 || i2 == 0) {
            AppMethodBeat.o(71495);
            return false;
        }
        AppMethodBeat.o(71495);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x0301 A:{Catch:{ all -> 0x02cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x02ce A:{Catch:{ all -> 0x02cb }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void e(String str, int i, int i2, int i3) {
        Exception e;
        Throwable th;
        Object obj = 1;
        Object obj2 = null;
        synchronized (this) {
            AppMethodBeat.i(71496);
            ab.i("MicroMsg.BeautyDownloadLogic", "upzipRes: %s", str);
            if (com.tencent.mm.vfs.e.ct(str)) {
                ab.i("MicroMsg.BeautyDownloadLogic", "unzip file ret: %s", Boolean.valueOf(aJ(str, lhL)));
                if (aJ(str, lhL)) {
                    try {
                        if (com.tencent.mm.vfs.e.ct(lhL + "meta.json")) {
                            String optString;
                            ab.i("MicroMsg.BeautyDownloadLogic", "meta json: %s", com.tencent.mm.vfs.e.cy(lhL + "meta.json"));
                            JSONObject jSONObject = new JSONObject(optString);
                            JSONObject optJSONObject = jSONObject.optJSONObject("filterso");
                            jSONObject = jSONObject.optJSONObject("filterres");
                            if (!(optJSONObject == null || jSONObject == null)) {
                                String optString2 = optJSONObject.optString("name");
                                optString = optJSONObject.optString("md5");
                                optString2 = lhL + optString2;
                                String cz = com.tencent.mm.c.g.cz(optString2);
                                if (bo.isNullOrNil(cz) || !cz.equalsIgnoreCase(optString)) {
                                    ab.e("MicroMsg.BeautyDownloadLogic", "download filter so not match! %s %s", cz, optString);
                                    h.pYm.k(914, 6, 1);
                                    ab.i("MicroMsg.BeautyDownloadLogic", "unzip failed");
                                    com.tencent.mm.vfs.e.N(lhL, true);
                                    xtL = false;
                                    h.pYm.e(15861, Integer.valueOf(2), Integer.valueOf(0));
                                    AppMethodBeat.o(71496);
                                } else {
                                    optString = jSONObject.optString("name");
                                    String optString3 = jSONObject.optString("md5");
                                    optString = lhL + optString;
                                    cz = com.tencent.mm.c.g.cz(optString);
                                    if (bo.isNullOrNil(cz) || !cz.equalsIgnoreCase(optString3)) {
                                        ab.e("MicroMsg.BeautyDownloadLogic", "download filter res not match! %s %s", cz, optString3);
                                        h.pYm.k(914, 7, 1);
                                        ab.i("MicroMsg.BeautyDownloadLogic", "unzip failed");
                                        com.tencent.mm.vfs.e.N(lhL, true);
                                        xtL = false;
                                        h.pYm.e(15861, Integer.valueOf(2), Integer.valueOf(0));
                                        AppMethodBeat.o(71496);
                                    } else {
                                        Object obj3;
                                        ab.i("MicroMsg.BeautyDownloadLogic", "unzip res success");
                                        if (!xtJ.equalsIgnoreCase(optString2)) {
                                            com.tencent.mm.vfs.e.aQ(optString2, xtJ);
                                        }
                                        if (!xtK.equalsIgnoreCase(optString)) {
                                            com.tencent.mm.vfs.e.aQ(optString, xtK);
                                        }
                                        if (com.tencent.mm.vfs.e.ct(xtJ)) {
                                            ab.i("MicroMsg.BeautyDownloadLogic", "unzip so path success, set beauty so path: %s", xtJ);
                                            obj3 = 1;
                                        } else {
                                            obj3 = null;
                                        }
                                        Object obj4;
                                        if (com.tencent.mm.vfs.e.ct(xtK)) {
                                            ab.i("MicroMsg.BeautyDownloadLogic", "unzip filter res path success, set beauty so path: %s", xtK);
                                            obj4 = 1;
                                        } else {
                                            obj4 = null;
                                        }
                                        if (!(obj3 == null || obj4 == null)) {
                                            ab.i("MicroMsg.BeautyDownloadLogic", "unzipRes success");
                                            try {
                                                xtL = true;
                                                obj2 = 1;
                                            } catch (Exception e2) {
                                                e = e2;
                                                try {
                                                    ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "unzipRes error: %s", e.getMessage());
                                                    try {
                                                        h.pYm.k(914, 8, 1);
                                                        ab.i("MicroMsg.BeautyDownloadLogic", "unzip failed");
                                                        com.tencent.mm.vfs.e.N(lhL, true);
                                                        xtL = false;
                                                        h.pYm.e(15861, Integer.valueOf(2), Integer.valueOf(0));
                                                        AppMethodBeat.o(71496);
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        if (obj2 != null) {
                                                            ab.i("MicroMsg.BeautyDownloadLogic", "unzip failed");
                                                            com.tencent.mm.vfs.e.N(lhL, true);
                                                            xtL = false;
                                                            h.pYm.e(15861, Integer.valueOf(2), Integer.valueOf(0));
                                                        } else {
                                                            ab.i("MicroMsg.BeautyDownloadLogic", "unzip success");
                                                            h.pYm.k(914, 9, 1);
                                                            h.pYm.e(15861, Integer.valueOf(1), Integer.valueOf(0));
                                                            com.tencent.mm.pluginsdk.g.a.a.b.c.veg.as(i, i2, i3);
                                                        }
                                                        AppMethodBeat.o(71496);
                                                        throw th;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    obj2 = obj;
                                                    if (obj2 != null) {
                                                    }
                                                    AppMethodBeat.o(71496);
                                                    throw th;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (obj2 == null) {
                            ab.i("MicroMsg.BeautyDownloadLogic", "unzip failed");
                            com.tencent.mm.vfs.e.N(lhL, true);
                            xtL = false;
                            h.pYm.e(15861, Integer.valueOf(2), Integer.valueOf(0));
                            AppMethodBeat.o(71496);
                        } else {
                            ab.i("MicroMsg.BeautyDownloadLogic", "unzip success");
                            h.pYm.k(914, 9, 1);
                            h.pYm.e(15861, Integer.valueOf(1), Integer.valueOf(0));
                            com.tencent.mm.pluginsdk.g.a.a.b.c.veg.as(i, i2, i3);
                            AppMethodBeat.o(71496);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        obj = null;
                        ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "unzipRes error: %s", e.getMessage());
                        h.pYm.k(914, 8, 1);
                        ab.i("MicroMsg.BeautyDownloadLogic", "unzip failed");
                        com.tencent.mm.vfs.e.N(lhL, true);
                        xtL = false;
                        h.pYm.e(15861, Integer.valueOf(2), Integer.valueOf(0));
                        AppMethodBeat.o(71496);
                    }
                }
            }
            AppMethodBeat.o(71496);
        }
    }

    public static boolean dmB() {
        AppMethodBeat.i(71497);
        ab.i("MicroMsg.BeautyDownloadLogic", "isHasBeautyDownloaded: %s", Boolean.valueOf(xtL));
        boolean z = xtL;
        AppMethodBeat.o(71497);
        return z;
    }

    private static boolean aJ(String str, String str2) {
        Throwable e;
        Object obj;
        AppMethodBeat.i(71498);
        Closeable closeable = null;
        Closeable closeable2 = null;
        Closeable zipFile;
        try {
            File file = new File(str2);
            file.mkdirs();
            zipFile = new ZipFile(new File(str), 1);
            try {
                Enumeration entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    ab.i("MicroMsg.BeautyDownloadLogic", "zipEntry name: %s", zipEntry.getName());
                    if (zipEntry.getName().contains("../") || zipEntry.getName().contains("..\\")) {
                        ab.i("MicroMsg.BeautyDownloadLogic", "skip zipEntry: %s", zipEntry);
                    } else {
                        File file2 = new File(file, zipEntry.getName());
                        file2.getParentFile().mkdirs();
                        if (!zipEntry.isDirectory()) {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                            try {
                                byte[] bArr = new byte[512];
                                OutputStream fileOutputStream;
                                OutputStream bufferedOutputStream;
                                try {
                                    fileOutputStream = new FileOutputStream(file2);
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 512);
                                        try {
                                            ab.i("MicroMsg.BeautyDownloadLogic", "%s zip file available: %s", zipEntry.getName(), Integer.valueOf(bufferedInputStream.available()));
                                            int read;
                                            if (bufferedInputStream.available() <= 512) {
                                                read = bufferedInputStream.read(bArr, 0, 512);
                                                if (read != -1) {
                                                    bufferedOutputStream.write(bArr, 0, read);
                                                    bufferedOutputStream.flush();
                                                }
                                            } else {
                                                while (true) {
                                                    read = bufferedInputStream.read(bArr, 0, 512);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    bufferedOutputStream.write(bArr, 0, read);
                                                }
                                                bufferedOutputStream.flush();
                                            }
                                            com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                            com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                            closeable = bufferedInputStream;
                                        } catch (Exception e2) {
                                            e = e2;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        bufferedOutputStream = null;
                                        try {
                                            ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "", new Object[0]);
                                            com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                            com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                            closeable = bufferedInputStream;
                                        } catch (Throwable th) {
                                            e = th;
                                            com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                            com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                            AppMethodBeat.o(71498);
                                            throw e;
                                        }
                                    } catch (Throwable th2) {
                                        e = th2;
                                        bufferedOutputStream = null;
                                        com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                        com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                        AppMethodBeat.o(71498);
                                        throw e;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    bufferedOutputStream = null;
                                    fileOutputStream = null;
                                    ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "", new Object[0]);
                                    com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                    com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                    closeable = bufferedInputStream;
                                } catch (Throwable th3) {
                                    e = th3;
                                    bufferedOutputStream = null;
                                    fileOutputStream = null;
                                    com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                    com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                    AppMethodBeat.o(71498);
                                    throw e;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                closeable2 = zipFile;
                                obj = bufferedInputStream;
                                try {
                                    ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "", new Object[0]);
                                    bo.b(closeable);
                                    bo.b(closeable2);
                                    AppMethodBeat.o(71498);
                                    return false;
                                } catch (Throwable th4) {
                                    e = th4;
                                    zipFile = closeable2;
                                    bo.b(closeable);
                                    bo.b(zipFile);
                                    AppMethodBeat.o(71498);
                                    throw e;
                                }
                            } catch (Throwable th5) {
                                e = th5;
                                obj = bufferedInputStream;
                                bo.b(closeable);
                                bo.b(zipFile);
                                AppMethodBeat.o(71498);
                                throw e;
                            }
                        }
                    }
                }
                bo.b(closeable);
                bo.b(zipFile);
                AppMethodBeat.o(71498);
                return true;
            } catch (Exception e6) {
                e = e6;
                closeable2 = zipFile;
                ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "", new Object[0]);
                bo.b(closeable);
                bo.b(closeable2);
                AppMethodBeat.o(71498);
                return false;
            } catch (Throwable th6) {
                e = th6;
                bo.b(closeable);
                bo.b(zipFile);
                AppMethodBeat.o(71498);
                throw e;
            }
        } catch (Exception e7) {
            e = e7;
            ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "", new Object[0]);
            bo.b(closeable);
            bo.b(closeable2);
            AppMethodBeat.o(71498);
            return false;
        } catch (Throwable th7) {
            e = th7;
            zipFile = null;
            bo.b(closeable);
            bo.b(zipFile);
            AppMethodBeat.o(71498);
            throw e;
        }
    }
}
