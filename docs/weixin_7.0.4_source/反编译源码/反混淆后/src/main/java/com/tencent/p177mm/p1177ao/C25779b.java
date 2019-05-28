package com.tencent.p177mm.p1177ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p209c.C25998g;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b;
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

/* renamed from: com.tencent.mm.ao.b */
public class C25779b {
    public static final String fAI = (C6457e.eSk + "fonts/");
    public static final String fAJ = (fAI + "temp/");
    public static final String fAK = (fAI + "WXkatonglemiao.ttf");
    public static final String fAL = (fAI + "WXxiari.ttf");
    private static C25779b fAM;
    private String fAN = "emoji_font_meta.json";
    public boolean fAO = false;
    public C4884c<C32519bf> fAP = new C257801();

    /* renamed from: com.tencent.mm.ao.b$1 */
    class C257801 extends C4884c<C32519bf> {
        C257801() {
            AppMethodBeat.m2504i(62283);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(62283);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(62284);
            final C32519bf c32519bf = (C32519bf) c4883b;
            if (c32519bf.cus.cut == 57 && c32519bf.cus.cuu == 1) {
                C4990ab.m7417i("MicroMsg.FontResLogic", "download res finish, path: %s, fileVersion: %s, fileUpdated: %s", c32519bf.cus.filePath, Integer.valueOf(c32519bf.cus.cuv), Boolean.valueOf(c32519bf.cus.cuw));
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(62282);
                        C7060h.pYm.mo15419k(933, 12, 1);
                        C25779b.m40986a(C25779b.this, c32519bf.cus.filePath, c32519bf.cus.cut, c32519bf.cus.cuu, c32519bf.cus.cuv);
                        AppMethodBeat.m2505o(62282);
                    }
                });
            }
            AppMethodBeat.m2505o(62284);
            return false;
        }
    }

    public C25779b() {
        AppMethodBeat.m2504i(62285);
        AppMethodBeat.m2505o(62285);
    }

    /* renamed from: a */
    static /* synthetic */ void m40986a(C25779b c25779b, String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(62292);
        c25779b.mo43743e(str, i, i2, i3);
        AppMethodBeat.m2505o(62292);
    }

    static {
        AppMethodBeat.m2504i(62293);
        AppMethodBeat.m2505o(62293);
    }

    public static C25779b afY() {
        AppMethodBeat.m2504i(62286);
        synchronized (C25779b.class) {
            try {
                if (fAM == null) {
                    fAM = new C25779b();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(62286);
            }
        }
        C25779b c25779b = fAM;
        return c25779b;
    }

    public final boolean afZ() {
        return this.fAO;
    }

    public final boolean agb() {
        AppMethodBeat.m2504i(62288);
        if (C5730e.m8628ct(fAK) && C5730e.m8628ct(fAL)) {
            C4990ab.m7416i("MicroMsg.FontResLogic", "font file exist");
            this.fAO = true;
        } else {
            this.fAO = false;
        }
        boolean z = this.fAO;
        AppMethodBeat.m2505o(62288);
        return z;
    }

    public static String[] agc() {
        return new String[]{fAL, fAK};
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0122 A:{Catch:{ Exception -> 0x013e, all -> 0x0177 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0109 A:{SYNTHETIC, Splitter:B:31:0x0109} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public final synchronized void mo43743e(String str, int i, int i2, int i3) {
        Object obj = 1;
        synchronized (this) {
            AppMethodBeat.m2504i(62289);
            C4990ab.m7417i("MicroMsg.FontResLogic", "unzipRes: %s", str);
            if (C5730e.m8628ct(str)) {
                C4990ab.m7417i("MicroMsg.FontResLogic", "unzip file ret: %s", Boolean.valueOf(C25779b.m40987aJ(str, fAJ)));
                if (C25779b.m40987aJ(str, fAJ)) {
                    try {
                        if (C5730e.m8628ct(fAJ + this.fAN)) {
                            C4990ab.m7417i("MicroMsg.FontResLogic", "meta json: %s", C5730e.m8631cy(fAJ + this.fAN));
                            JSONObject jSONObject = new JSONObject(r2);
                            JSONObject optJSONObject = jSONObject.optJSONObject("WXkatonglemiao.ttf");
                            jSONObject = jSONObject.optJSONObject("WXxiari.ttf");
                            if (!(optJSONObject == null || jSONObject == null)) {
                                if (!C25779b.m40988b(optJSONObject, fAK)) {
                                    C7060h.pYm.mo15419k(933, 13, 1);
                                } else if (C25779b.m40988b(jSONObject, fAL)) {
                                    C4990ab.m7416i("MicroMsg.FontResLogic", "unzip res success");
                                    if (agb()) {
                                        C4990ab.m7416i("MicroMsg.FontResLogic", "unzipRes success");
                                        if (obj != null) {
                                            C4990ab.m7416i("MicroMsg.FontResLogic", "unzip failed");
                                            this.fAO = false;
                                        } else {
                                            C4990ab.m7416i("MicroMsg.FontResLogic", "unzip success");
                                            C7060h.pYm.mo15419k(933, 16, 1);
                                            C14845c.veg.mo27147as(i, i2, i3);
                                        }
                                        C5730e.m8618N(fAJ, true);
                                        AppMethodBeat.m2505o(62289);
                                    }
                                } else {
                                    C7060h.pYm.mo15419k(933, 14, 1);
                                    C4990ab.m7416i("MicroMsg.FontResLogic", "unzip failed");
                                    this.fAO = false;
                                    C5730e.m8618N(fAJ, true);
                                    AppMethodBeat.m2505o(62289);
                                }
                            }
                        }
                        obj = null;
                        if (obj != null) {
                        }
                        C5730e.m8618N(fAJ, true);
                        AppMethodBeat.m2505o(62289);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.FontResLogic", e, "unzipRes error: %s", e.getMessage());
                        C7060h.pYm.mo15419k(933, 15, 1);
                    } finally {
                        C4990ab.m7416i("MicroMsg.FontResLogic", "unzip failed");
                        this.fAO = false;
                        C5730e.m8618N(fAJ, true);
                        AppMethodBeat.m2505o(62289);
                    }
                }
            }
            AppMethodBeat.m2505o(62289);
        }
    }

    /* renamed from: b */
    private static boolean m40988b(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(62290);
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("md5");
        String str2 = fAJ + optString;
        String cz = C25998g.m41489cz(str2);
        if (C5046bo.isNullOrNil(cz) || !cz.equalsIgnoreCase(optString2)) {
            C4990ab.m7413e("MicroMsg.FontResLogic", "download %s not match! %s %s", optString, cz, optString2);
            AppMethodBeat.m2505o(62290);
            return false;
        }
        if (!str.equalsIgnoreCase(str2)) {
            C5730e.m8623aQ(str2, str);
        }
        AppMethodBeat.m2505o(62290);
        return true;
    }

    /* renamed from: aJ */
    private static boolean m40987aJ(String str, String str2) {
        Throwable e;
        Object obj;
        AppMethodBeat.m2504i(62291);
        Closeable closeable = null;
        try {
            File file = new File(str2);
            file.mkdirs();
            ZipFile zipFile = new ZipFile(new File(str), 1);
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                C4990ab.m7417i("MicroMsg.FontResLogic", "zipEntry name: %s", zipEntry.getName());
                if (zipEntry.getName().contains("../") || zipEntry.getName().contains("..\\")) {
                    C4990ab.m7417i("MicroMsg.FontResLogic", "skip zipEntry: %s", zipEntry);
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
                                        C4990ab.m7417i("MicroMsg.FontResLogic", "%s zip file available: %s", zipEntry.getName(), Integer.valueOf(bufferedInputStream.available()));
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
                                        C4990ab.printErrStackTrace("MicroMsg.FontResLogic", e, "", new Object[0]);
                                        C1173e.closeOutputStream(fileOutputStream);
                                        C1173e.closeOutputStream(bufferedOutputStream);
                                        closeable = bufferedInputStream;
                                    } catch (Throwable th) {
                                        e = th;
                                        C1173e.closeOutputStream(fileOutputStream);
                                        C1173e.closeOutputStream(bufferedOutputStream);
                                        AppMethodBeat.m2505o(62291);
                                        throw e;
                                    }
                                } catch (Throwable th2) {
                                    e = th2;
                                    bufferedOutputStream = null;
                                    C1173e.closeOutputStream(fileOutputStream);
                                    C1173e.closeOutputStream(bufferedOutputStream);
                                    AppMethodBeat.m2505o(62291);
                                    throw e;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                bufferedOutputStream = null;
                                fileOutputStream = null;
                                C4990ab.printErrStackTrace("MicroMsg.FontResLogic", e, "", new Object[0]);
                                C1173e.closeOutputStream(fileOutputStream);
                                C1173e.closeOutputStream(bufferedOutputStream);
                                closeable = bufferedInputStream;
                            } catch (Throwable th3) {
                                e = th3;
                                bufferedOutputStream = null;
                                fileOutputStream = null;
                                C1173e.closeOutputStream(fileOutputStream);
                                C1173e.closeOutputStream(bufferedOutputStream);
                                AppMethodBeat.m2505o(62291);
                                throw e;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            obj = bufferedInputStream;
                            try {
                                C4990ab.printErrStackTrace("MicroMsg.FontResLogic", e, "", new Object[0]);
                                C5046bo.m7527b(closeable);
                                AppMethodBeat.m2505o(62291);
                                return false;
                            } catch (Throwable th4) {
                                e = th4;
                                C5046bo.m7527b(closeable);
                                AppMethodBeat.m2505o(62291);
                                throw e;
                            }
                        } catch (Throwable th5) {
                            e = th5;
                            obj = bufferedInputStream;
                            C5046bo.m7527b(closeable);
                            AppMethodBeat.m2505o(62291);
                            throw e;
                        }
                    }
                }
            }
            C5046bo.m7527b(closeable);
            AppMethodBeat.m2505o(62291);
            return true;
        } catch (Exception e6) {
            e = e6;
            C4990ab.printErrStackTrace("MicroMsg.FontResLogic", e, "", new Object[0]);
            C5046bo.m7527b(closeable);
            AppMethodBeat.m2505o(62291);
            return false;
        }
    }

    public static void aga() {
        AppMethodBeat.m2504i(62287);
        C14845c.veg;
        C14839b.m23095Ky(57);
        AppMethodBeat.m2505o(62287);
    }
}
