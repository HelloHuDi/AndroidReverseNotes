package com.tencent.p177mm.plugin.appbrand.appcache;

import com.facebook.internal.Utility;
import com.tencent.mars.zstd.ZstdInputStream;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az.C2057a;
import com.tencent.p177mm.plugin.appbrand.appcache.C26751z.C19074a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a.C10067a;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40432m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.bd */
public final class C10089bd {
    /* renamed from: a */
    public static boolean m17684a(String str, String str2, int i, int i2, C2057a c2057a) {
        AppMethodBeat.m2504i(59550);
        boolean a = C2055az.m4219a(new C26746bc(str, str2, i, i2, c2057a), c2057a);
        AppMethodBeat.m2505o(59550);
        return a;
    }

    /* renamed from: a */
    public static void m17682a(C26746bc c26746bc, C40432m c40432m, C19074a c19074a) {
        AppMethodBeat.m2504i(59551);
        C4990ab.m7413e("MicroMsg.AppBrand.ZstdLogic", "onZstdPkgDownloadFail, request(%s %d)", c26746bc.appId, Integer.valueOf(c26746bc.gVu));
        c19074a.mo34289a(c40432m);
        C38105ax xF = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF();
        if (xF == null) {
            C4990ab.m7412e("MicroMsg.AppBrand.ZstdLogic", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
            C2055az.m4217a(c26746bc.vdC, c26746bc.appId, C10067a.ENV_ERR, null);
            AppMethodBeat.m2505o(59551);
            return;
        }
        C2055az.m4226xJ(c26746bc.vdC);
        C31281at a = xF.mo60841a(c26746bc.appId, c26746bc.gVu, c26746bc.cBc, "downloadURL");
        if (a == null) {
            C4990ab.m7413e("MicroMsg.AppBrand.ZstdLogic", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", c26746bc.appId, Integer.valueOf(c26746bc.gVu));
            AppMethodBeat.m2505o(59551);
            return;
        }
        C2055az.m4224b(c26746bc.appId, c26746bc.cBc, c26746bc.gVu, a.field_downloadURL, c26746bc.gTR);
        AppMethodBeat.m2505o(59551);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x009d A:{SYNTHETIC, Splitter:B:39:0x009d} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a2 A:{SYNTHETIC, Splitter:B:42:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007b A:{SYNTHETIC, Splitter:B:23:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080 A:{SYNTHETIC, Splitter:B:26:0x0080} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007b A:{SYNTHETIC, Splitter:B:23:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080 A:{SYNTHETIC, Splitter:B:26:0x0080} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009d A:{SYNTHETIC, Splitter:B:39:0x009d} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a2 A:{SYNTHETIC, Splitter:B:42:0x00a2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static boolean m17683a(C26746bc c26746bc) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(59552);
        String filePath = c26746bc.getFilePath();
        File file = new File(filePath);
        if (file.exists()) {
            File file2 = new File(c26746bc.aws());
            if (!file2.exists() || file2.delete()) {
                ZstdInputStream zstdInputStream;
                FileOutputStream fileOutputStream;
                try {
                    zstdInputStream = new ZstdInputStream(new FileInputStream(file));
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                            while (true) {
                                int read = zstdInputStream.read(bArr, 0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.flush();
                            C5730e.deleteFile(filePath);
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                            }
                            try {
                                zstdInputStream.close();
                            } catch (IOException e3) {
                            }
                            AppMethodBeat.m2505o(59552);
                            return true;
                        } catch (Exception e4) {
                            e = e4;
                            try {
                                C4990ab.m7413e("MicroMsg.AppBrand.ZstdLogic", "mayProcessZstd exp: %s", e);
                                if (fileOutputStream != null) {
                                }
                                if (zstdInputStream != null) {
                                }
                                AppMethodBeat.m2505o(59552);
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileOutputStream != null) {
                                }
                                if (zstdInputStream != null) {
                                }
                                AppMethodBeat.m2505o(59552);
                                throw th;
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        fileOutputStream = null;
                        C4990ab.m7413e("MicroMsg.AppBrand.ZstdLogic", "mayProcessZstd exp: %s", e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        if (zstdInputStream != null) {
                            try {
                                zstdInputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        AppMethodBeat.m2505o(59552);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        if (zstdInputStream != null) {
                            try {
                                zstdInputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        AppMethodBeat.m2505o(59552);
                        throw th;
                    }
                } catch (Exception e10) {
                    e = e10;
                    fileOutputStream = null;
                    zstdInputStream = null;
                    C4990ab.m7413e("MicroMsg.AppBrand.ZstdLogic", "mayProcessZstd exp: %s", e);
                    if (fileOutputStream != null) {
                    }
                    if (zstdInputStream != null) {
                    }
                    AppMethodBeat.m2505o(59552);
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    zstdInputStream = null;
                    if (fileOutputStream != null) {
                    }
                    if (zstdInputStream != null) {
                    }
                    AppMethodBeat.m2505o(59552);
                    throw th;
                }
            }
            C4990ab.m7412e("MicroMsg.AppBrand.ZstdLogic", "mayProcessZstd targetFile delete failed");
            AppMethodBeat.m2505o(59552);
            return false;
        }
        C4990ab.m7412e("MicroMsg.AppBrand.ZstdLogic", "mayProcessZstd downloadFile not exists");
        AppMethodBeat.m2505o(59552);
        return false;
    }
}
