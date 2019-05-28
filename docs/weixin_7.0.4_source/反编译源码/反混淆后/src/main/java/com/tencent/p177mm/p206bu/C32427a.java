package com.tencent.p177mm.p206bu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p209c.C25998g;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.bu.a */
public final class C32427a {
    public static final String lhL = (C6457e.eSk + "beauty/");
    public static final String xtJ = (lhL + "libalgo_rithm_jni.so");
    public static final String xtK = (lhL + "ziran_lf.png");
    public static volatile boolean xtL = false;
    public static C32427a xtM = new C32427a();
    public C4884c<C32519bf> fAP = new C181181();

    /* renamed from: com.tencent.mm.bu.a$1 */
    class C181181 extends C4884c<C32519bf> {
        C181181() {
            AppMethodBeat.m2504i(71492);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(71492);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(71493);
            final C32519bf c32519bf = (C32519bf) c4883b;
            if (c32519bf.cus.cut == 56) {
                C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "download res finish, path: %s, fileVersion: %s, fileUpdated: %s", c32519bf.cus.filePath, Integer.valueOf(c32519bf.cus.cuv), Boolean.valueOf(c32519bf.cus.cuw));
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(71491);
                        C7060h.pYm.mo15419k(914, 5, 1);
                        C32427a.m53080a(C32427a.this, c32519bf.cus.filePath, c32519bf.cus.cut, c32519bf.cus.cuu, c32519bf.cus.cuv);
                        AppMethodBeat.m2505o(71491);
                    }
                });
            }
            AppMethodBeat.m2505o(71493);
            return false;
        }
    }

    public C32427a() {
        AppMethodBeat.m2504i(71494);
        AppMethodBeat.m2505o(71494);
    }

    /* renamed from: a */
    static /* synthetic */ void m53080a(C32427a c32427a, String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(71499);
        c32427a.mo53067e(str, i, i2, i3);
        AppMethodBeat.m2505o(71499);
    }

    static {
        AppMethodBeat.m2504i(71500);
        AppMethodBeat.m2505o(71500);
    }

    public static boolean agb() {
        int i;
        boolean z;
        AppMethodBeat.m2504i(71495);
        if (C5730e.m8628ct(xtJ)) {
            C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "file %s exist, set beauty so path", xtJ);
            i = 1;
        } else {
            i = 0;
        }
        int i2;
        if (C5730e.m8628ct(xtK)) {
            C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "file %s exist, set filter res path", xtK);
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
            AppMethodBeat.m2505o(71495);
            return false;
        }
        AppMethodBeat.m2505o(71495);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x0301 A:{Catch:{ all -> 0x02cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x02ce A:{Catch:{ all -> 0x02cb }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public final synchronized void mo53067e(String str, int i, int i2, int i3) {
        Exception e;
        Throwable th;
        Object obj = 1;
        Object obj2 = null;
        synchronized (this) {
            AppMethodBeat.m2504i(71496);
            C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "upzipRes: %s", str);
            if (C5730e.m8628ct(str)) {
                C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "unzip file ret: %s", Boolean.valueOf(C32427a.m53081aJ(str, lhL)));
                if (C32427a.m53081aJ(str, lhL)) {
                    try {
                        if (C5730e.m8628ct(lhL + "meta.json")) {
                            String optString;
                            C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "meta json: %s", C5730e.m8631cy(lhL + "meta.json"));
                            JSONObject jSONObject = new JSONObject(optString);
                            JSONObject optJSONObject = jSONObject.optJSONObject("filterso");
                            jSONObject = jSONObject.optJSONObject("filterres");
                            if (!(optJSONObject == null || jSONObject == null)) {
                                String optString2 = optJSONObject.optString("name");
                                optString = optJSONObject.optString("md5");
                                optString2 = lhL + optString2;
                                String cz = C25998g.m41489cz(optString2);
                                if (C5046bo.isNullOrNil(cz) || !cz.equalsIgnoreCase(optString)) {
                                    C4990ab.m7413e("MicroMsg.BeautyDownloadLogic", "download filter so not match! %s %s", cz, optString);
                                    C7060h.pYm.mo15419k(914, 6, 1);
                                    C4990ab.m7416i("MicroMsg.BeautyDownloadLogic", "unzip failed");
                                    C5730e.m8618N(lhL, true);
                                    xtL = false;
                                    C7060h.pYm.mo8381e(15861, Integer.valueOf(2), Integer.valueOf(0));
                                    AppMethodBeat.m2505o(71496);
                                } else {
                                    optString = jSONObject.optString("name");
                                    String optString3 = jSONObject.optString("md5");
                                    optString = lhL + optString;
                                    cz = C25998g.m41489cz(optString);
                                    if (C5046bo.isNullOrNil(cz) || !cz.equalsIgnoreCase(optString3)) {
                                        C4990ab.m7413e("MicroMsg.BeautyDownloadLogic", "download filter res not match! %s %s", cz, optString3);
                                        C7060h.pYm.mo15419k(914, 7, 1);
                                        C4990ab.m7416i("MicroMsg.BeautyDownloadLogic", "unzip failed");
                                        C5730e.m8618N(lhL, true);
                                        xtL = false;
                                        C7060h.pYm.mo8381e(15861, Integer.valueOf(2), Integer.valueOf(0));
                                        AppMethodBeat.m2505o(71496);
                                    } else {
                                        Object obj3;
                                        C4990ab.m7416i("MicroMsg.BeautyDownloadLogic", "unzip res success");
                                        if (!xtJ.equalsIgnoreCase(optString2)) {
                                            C5730e.m8623aQ(optString2, xtJ);
                                        }
                                        if (!xtK.equalsIgnoreCase(optString)) {
                                            C5730e.m8623aQ(optString, xtK);
                                        }
                                        if (C5730e.m8628ct(xtJ)) {
                                            C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "unzip so path success, set beauty so path: %s", xtJ);
                                            obj3 = 1;
                                        } else {
                                            obj3 = null;
                                        }
                                        Object obj4;
                                        if (C5730e.m8628ct(xtK)) {
                                            C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "unzip filter res path success, set beauty so path: %s", xtK);
                                            obj4 = 1;
                                        } else {
                                            obj4 = null;
                                        }
                                        if (!(obj3 == null || obj4 == null)) {
                                            C4990ab.m7416i("MicroMsg.BeautyDownloadLogic", "unzipRes success");
                                            try {
                                                xtL = true;
                                                obj2 = 1;
                                            } catch (Exception e2) {
                                                e = e2;
                                                try {
                                                    C4990ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "unzipRes error: %s", e.getMessage());
                                                    try {
                                                        C7060h.pYm.mo15419k(914, 8, 1);
                                                        C4990ab.m7416i("MicroMsg.BeautyDownloadLogic", "unzip failed");
                                                        C5730e.m8618N(lhL, true);
                                                        xtL = false;
                                                        C7060h.pYm.mo8381e(15861, Integer.valueOf(2), Integer.valueOf(0));
                                                        AppMethodBeat.m2505o(71496);
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        if (obj2 != null) {
                                                            C4990ab.m7416i("MicroMsg.BeautyDownloadLogic", "unzip failed");
                                                            C5730e.m8618N(lhL, true);
                                                            xtL = false;
                                                            C7060h.pYm.mo8381e(15861, Integer.valueOf(2), Integer.valueOf(0));
                                                        } else {
                                                            C4990ab.m7416i("MicroMsg.BeautyDownloadLogic", "unzip success");
                                                            C7060h.pYm.mo15419k(914, 9, 1);
                                                            C7060h.pYm.mo8381e(15861, Integer.valueOf(1), Integer.valueOf(0));
                                                            C14845c.veg.mo27147as(i, i2, i3);
                                                        }
                                                        AppMethodBeat.m2505o(71496);
                                                        throw th;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    obj2 = obj;
                                                    if (obj2 != null) {
                                                    }
                                                    AppMethodBeat.m2505o(71496);
                                                    throw th;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (obj2 == null) {
                            C4990ab.m7416i("MicroMsg.BeautyDownloadLogic", "unzip failed");
                            C5730e.m8618N(lhL, true);
                            xtL = false;
                            C7060h.pYm.mo8381e(15861, Integer.valueOf(2), Integer.valueOf(0));
                            AppMethodBeat.m2505o(71496);
                        } else {
                            C4990ab.m7416i("MicroMsg.BeautyDownloadLogic", "unzip success");
                            C7060h.pYm.mo15419k(914, 9, 1);
                            C7060h.pYm.mo8381e(15861, Integer.valueOf(1), Integer.valueOf(0));
                            C14845c.veg.mo27147as(i, i2, i3);
                            AppMethodBeat.m2505o(71496);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        obj = null;
                        C4990ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "unzipRes error: %s", e.getMessage());
                        C7060h.pYm.mo15419k(914, 8, 1);
                        C4990ab.m7416i("MicroMsg.BeautyDownloadLogic", "unzip failed");
                        C5730e.m8618N(lhL, true);
                        xtL = false;
                        C7060h.pYm.mo8381e(15861, Integer.valueOf(2), Integer.valueOf(0));
                        AppMethodBeat.m2505o(71496);
                    }
                }
            }
            AppMethodBeat.m2505o(71496);
        }
    }

    public static boolean dmB() {
        AppMethodBeat.m2504i(71497);
        C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "isHasBeautyDownloaded: %s", Boolean.valueOf(xtL));
        boolean z = xtL;
        AppMethodBeat.m2505o(71497);
        return z;
    }

    /* renamed from: aJ */
    private static boolean m53081aJ(String str, String str2) {
        Throwable e;
        Object obj;
        AppMethodBeat.m2504i(71498);
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
                    C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "zipEntry name: %s", zipEntry.getName());
                    if (zipEntry.getName().contains("../") || zipEntry.getName().contains("..\\")) {
                        C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "skip zipEntry: %s", zipEntry);
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
                                            C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "%s zip file available: %s", zipEntry.getName(), Integer.valueOf(bufferedInputStream.available()));
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
                                            C1173e.closeOutputStream(fileOutputStream);
                                            C1173e.closeOutputStream(bufferedOutputStream);
                                            closeable = bufferedInputStream;
                                        } catch (Exception e2) {
                                            e = e2;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        bufferedOutputStream = null;
                                        try {
                                            C4990ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "", new Object[0]);
                                            C1173e.closeOutputStream(fileOutputStream);
                                            C1173e.closeOutputStream(bufferedOutputStream);
                                            closeable = bufferedInputStream;
                                        } catch (Throwable th) {
                                            e = th;
                                            C1173e.closeOutputStream(fileOutputStream);
                                            C1173e.closeOutputStream(bufferedOutputStream);
                                            AppMethodBeat.m2505o(71498);
                                            throw e;
                                        }
                                    } catch (Throwable th2) {
                                        e = th2;
                                        bufferedOutputStream = null;
                                        C1173e.closeOutputStream(fileOutputStream);
                                        C1173e.closeOutputStream(bufferedOutputStream);
                                        AppMethodBeat.m2505o(71498);
                                        throw e;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    bufferedOutputStream = null;
                                    fileOutputStream = null;
                                    C4990ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "", new Object[0]);
                                    C1173e.closeOutputStream(fileOutputStream);
                                    C1173e.closeOutputStream(bufferedOutputStream);
                                    closeable = bufferedInputStream;
                                } catch (Throwable th3) {
                                    e = th3;
                                    bufferedOutputStream = null;
                                    fileOutputStream = null;
                                    C1173e.closeOutputStream(fileOutputStream);
                                    C1173e.closeOutputStream(bufferedOutputStream);
                                    AppMethodBeat.m2505o(71498);
                                    throw e;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                closeable2 = zipFile;
                                obj = bufferedInputStream;
                                try {
                                    C4990ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "", new Object[0]);
                                    C5046bo.m7527b(closeable);
                                    C5046bo.m7527b(closeable2);
                                    AppMethodBeat.m2505o(71498);
                                    return false;
                                } catch (Throwable th4) {
                                    e = th4;
                                    zipFile = closeable2;
                                    C5046bo.m7527b(closeable);
                                    C5046bo.m7527b(zipFile);
                                    AppMethodBeat.m2505o(71498);
                                    throw e;
                                }
                            } catch (Throwable th5) {
                                e = th5;
                                obj = bufferedInputStream;
                                C5046bo.m7527b(closeable);
                                C5046bo.m7527b(zipFile);
                                AppMethodBeat.m2505o(71498);
                                throw e;
                            }
                        }
                    }
                }
                C5046bo.m7527b(closeable);
                C5046bo.m7527b(zipFile);
                AppMethodBeat.m2505o(71498);
                return true;
            } catch (Exception e6) {
                e = e6;
                closeable2 = zipFile;
                C4990ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "", new Object[0]);
                C5046bo.m7527b(closeable);
                C5046bo.m7527b(closeable2);
                AppMethodBeat.m2505o(71498);
                return false;
            } catch (Throwable th6) {
                e = th6;
                C5046bo.m7527b(closeable);
                C5046bo.m7527b(zipFile);
                AppMethodBeat.m2505o(71498);
                throw e;
            }
        } catch (Exception e7) {
            e = e7;
            C4990ab.printErrStackTrace("MicroMsg.BeautyDownloadLogic", e, "", new Object[0]);
            C5046bo.m7527b(closeable);
            C5046bo.m7527b(closeable2);
            AppMethodBeat.m2505o(71498);
            return false;
        } catch (Throwable th7) {
            e = th7;
            zipFile = null;
            C5046bo.m7527b(closeable);
            C5046bo.m7527b(zipFile);
            AppMethodBeat.m2505o(71498);
            throw e;
        }
    }
}
