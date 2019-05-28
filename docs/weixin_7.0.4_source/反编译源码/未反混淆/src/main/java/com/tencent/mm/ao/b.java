package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
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

public class b {
    public static final String fAI = (e.eSk + "fonts/");
    public static final String fAJ = (fAI + "temp/");
    public static final String fAK = (fAI + "WXkatonglemiao.ttf");
    public static final String fAL = (fAI + "WXxiari.ttf");
    private static b fAM;
    private String fAN = "emoji_font_meta.json";
    public boolean fAO = false;
    public c<bf> fAP = new c<bf>() {
        {
            AppMethodBeat.i(62283);
            this.xxI = bf.class.getName().hashCode();
            AppMethodBeat.o(62283);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(62284);
            final bf bfVar = (bf) bVar;
            if (bfVar.cus.cut == 57 && bfVar.cus.cuu == 1) {
                ab.i("MicroMsg.FontResLogic", "download res finish, path: %s, fileVersion: %s, fileUpdated: %s", bfVar.cus.filePath, Integer.valueOf(bfVar.cus.cuv), Boolean.valueOf(bfVar.cus.cuw));
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(62282);
                        h.pYm.k(933, 12, 1);
                        b.a(b.this, bfVar.cus.filePath, bfVar.cus.cut, bfVar.cus.cuu, bfVar.cus.cuv);
                        AppMethodBeat.o(62282);
                    }
                });
            }
            AppMethodBeat.o(62284);
            return false;
        }
    };

    public b() {
        AppMethodBeat.i(62285);
        AppMethodBeat.o(62285);
    }

    static /* synthetic */ void a(b bVar, String str, int i, int i2, int i3) {
        AppMethodBeat.i(62292);
        bVar.e(str, i, i2, i3);
        AppMethodBeat.o(62292);
    }

    static {
        AppMethodBeat.i(62293);
        AppMethodBeat.o(62293);
    }

    public static b afY() {
        AppMethodBeat.i(62286);
        synchronized (b.class) {
            try {
                if (fAM == null) {
                    fAM = new b();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(62286);
            }
        }
        b bVar = fAM;
        return bVar;
    }

    public final boolean afZ() {
        return this.fAO;
    }

    public final boolean agb() {
        AppMethodBeat.i(62288);
        if (com.tencent.mm.vfs.e.ct(fAK) && com.tencent.mm.vfs.e.ct(fAL)) {
            ab.i("MicroMsg.FontResLogic", "font file exist");
            this.fAO = true;
        } else {
            this.fAO = false;
        }
        boolean z = this.fAO;
        AppMethodBeat.o(62288);
        return z;
    }

    public static String[] agc() {
        return new String[]{fAL, fAK};
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0122 A:{Catch:{ Exception -> 0x013e, all -> 0x0177 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0109 A:{SYNTHETIC, Splitter:B:31:0x0109} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void e(String str, int i, int i2, int i3) {
        Object obj = 1;
        synchronized (this) {
            AppMethodBeat.i(62289);
            ab.i("MicroMsg.FontResLogic", "unzipRes: %s", str);
            if (com.tencent.mm.vfs.e.ct(str)) {
                ab.i("MicroMsg.FontResLogic", "unzip file ret: %s", Boolean.valueOf(aJ(str, fAJ)));
                if (aJ(str, fAJ)) {
                    try {
                        if (com.tencent.mm.vfs.e.ct(fAJ + this.fAN)) {
                            ab.i("MicroMsg.FontResLogic", "meta json: %s", com.tencent.mm.vfs.e.cy(fAJ + this.fAN));
                            JSONObject jSONObject = new JSONObject(r2);
                            JSONObject optJSONObject = jSONObject.optJSONObject("WXkatonglemiao.ttf");
                            jSONObject = jSONObject.optJSONObject("WXxiari.ttf");
                            if (!(optJSONObject == null || jSONObject == null)) {
                                if (!b(optJSONObject, fAK)) {
                                    h.pYm.k(933, 13, 1);
                                } else if (b(jSONObject, fAL)) {
                                    ab.i("MicroMsg.FontResLogic", "unzip res success");
                                    if (agb()) {
                                        ab.i("MicroMsg.FontResLogic", "unzipRes success");
                                        if (obj != null) {
                                            ab.i("MicroMsg.FontResLogic", "unzip failed");
                                            this.fAO = false;
                                        } else {
                                            ab.i("MicroMsg.FontResLogic", "unzip success");
                                            h.pYm.k(933, 16, 1);
                                            com.tencent.mm.pluginsdk.g.a.a.b.c.veg.as(i, i2, i3);
                                        }
                                        com.tencent.mm.vfs.e.N(fAJ, true);
                                        AppMethodBeat.o(62289);
                                    }
                                } else {
                                    h.pYm.k(933, 14, 1);
                                    ab.i("MicroMsg.FontResLogic", "unzip failed");
                                    this.fAO = false;
                                    com.tencent.mm.vfs.e.N(fAJ, true);
                                    AppMethodBeat.o(62289);
                                }
                            }
                        }
                        obj = null;
                        if (obj != null) {
                        }
                        com.tencent.mm.vfs.e.N(fAJ, true);
                        AppMethodBeat.o(62289);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.FontResLogic", e, "unzipRes error: %s", e.getMessage());
                        h.pYm.k(933, 15, 1);
                    } finally {
                        ab.i("MicroMsg.FontResLogic", "unzip failed");
                        this.fAO = false;
                        com.tencent.mm.vfs.e.N(fAJ, true);
                        AppMethodBeat.o(62289);
                    }
                }
            }
            AppMethodBeat.o(62289);
        }
    }

    private static boolean b(JSONObject jSONObject, String str) {
        AppMethodBeat.i(62290);
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("md5");
        String str2 = fAJ + optString;
        String cz = com.tencent.mm.c.g.cz(str2);
        if (bo.isNullOrNil(cz) || !cz.equalsIgnoreCase(optString2)) {
            ab.e("MicroMsg.FontResLogic", "download %s not match! %s %s", optString, cz, optString2);
            AppMethodBeat.o(62290);
            return false;
        }
        if (!str.equalsIgnoreCase(str2)) {
            com.tencent.mm.vfs.e.aQ(str2, str);
        }
        AppMethodBeat.o(62290);
        return true;
    }

    private static boolean aJ(String str, String str2) {
        Throwable e;
        Object obj;
        AppMethodBeat.i(62291);
        Closeable closeable = null;
        try {
            File file = new File(str2);
            file.mkdirs();
            ZipFile zipFile = new ZipFile(new File(str), 1);
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                ab.i("MicroMsg.FontResLogic", "zipEntry name: %s", zipEntry.getName());
                if (zipEntry.getName().contains("../") || zipEntry.getName().contains("..\\")) {
                    ab.i("MicroMsg.FontResLogic", "skip zipEntry: %s", zipEntry);
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
                                        ab.i("MicroMsg.FontResLogic", "%s zip file available: %s", zipEntry.getName(), Integer.valueOf(bufferedInputStream.available()));
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
                                        ab.printErrStackTrace("MicroMsg.FontResLogic", e, "", new Object[0]);
                                        com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                        com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                        closeable = bufferedInputStream;
                                    } catch (Throwable th) {
                                        e = th;
                                        com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                        com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                        AppMethodBeat.o(62291);
                                        throw e;
                                    }
                                } catch (Throwable th2) {
                                    e = th2;
                                    bufferedOutputStream = null;
                                    com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                    com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                    AppMethodBeat.o(62291);
                                    throw e;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                bufferedOutputStream = null;
                                fileOutputStream = null;
                                ab.printErrStackTrace("MicroMsg.FontResLogic", e, "", new Object[0]);
                                com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                closeable = bufferedInputStream;
                            } catch (Throwable th3) {
                                e = th3;
                                bufferedOutputStream = null;
                                fileOutputStream = null;
                                com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                AppMethodBeat.o(62291);
                                throw e;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            obj = bufferedInputStream;
                            try {
                                ab.printErrStackTrace("MicroMsg.FontResLogic", e, "", new Object[0]);
                                bo.b(closeable);
                                AppMethodBeat.o(62291);
                                return false;
                            } catch (Throwable th4) {
                                e = th4;
                                bo.b(closeable);
                                AppMethodBeat.o(62291);
                                throw e;
                            }
                        } catch (Throwable th5) {
                            e = th5;
                            obj = bufferedInputStream;
                            bo.b(closeable);
                            AppMethodBeat.o(62291);
                            throw e;
                        }
                    }
                }
            }
            bo.b(closeable);
            AppMethodBeat.o(62291);
            return true;
        } catch (Exception e6) {
            e = e6;
            ab.printErrStackTrace("MicroMsg.FontResLogic", e, "", new Object[0]);
            bo.b(closeable);
            AppMethodBeat.o(62291);
            return false;
        }
    }

    public static void aga() {
        AppMethodBeat.i(62287);
        com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
        com.tencent.mm.pluginsdk.g.a.a.b.Ky(57);
        AppMethodBeat.o(62287);
    }
}
