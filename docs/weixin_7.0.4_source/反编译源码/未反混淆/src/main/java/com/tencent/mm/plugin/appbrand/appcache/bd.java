package com.tencent.mm.plugin.appbrand.appcache;

import com.facebook.internal.Utility;
import com.tencent.mars.zstd.ZstdInputStream;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.az.a;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class bd {
    public static boolean a(String str, String str2, int i, int i2, a aVar) {
        AppMethodBeat.i(59550);
        boolean a = az.a(new bc(str, str2, i, i2, aVar), aVar);
        AppMethodBeat.o(59550);
        return a;
    }

    public static void a(bc bcVar, m mVar, z.a aVar) {
        AppMethodBeat.i(59551);
        ab.e("MicroMsg.AppBrand.ZstdLogic", "onZstdPkgDownloadFail, request(%s %d)", bcVar.appId, Integer.valueOf(bcVar.gVu));
        aVar.a(mVar);
        ax xF = ((d) g.K(d.class)).xF();
        if (xF == null) {
            ab.e("MicroMsg.AppBrand.ZstdLogic", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
            az.a(bcVar.vdC, bcVar.appId, b.a.a.ENV_ERR, null);
            AppMethodBeat.o(59551);
            return;
        }
        az.xJ(bcVar.vdC);
        at a = xF.a(bcVar.appId, bcVar.gVu, bcVar.cBc, "downloadURL");
        if (a == null) {
            ab.e("MicroMsg.AppBrand.ZstdLogic", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", bcVar.appId, Integer.valueOf(bcVar.gVu));
            AppMethodBeat.o(59551);
            return;
        }
        az.b(bcVar.appId, bcVar.cBc, bcVar.gVu, a.field_downloadURL, bcVar.gTR);
        AppMethodBeat.o(59551);
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
    static boolean a(bc bcVar) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(59552);
        String filePath = bcVar.getFilePath();
        File file = new File(filePath);
        if (file.exists()) {
            File file2 = new File(bcVar.aws());
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
                            e.deleteFile(filePath);
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                            }
                            try {
                                zstdInputStream.close();
                            } catch (IOException e3) {
                            }
                            AppMethodBeat.o(59552);
                            return true;
                        } catch (Exception e4) {
                            e = e4;
                            try {
                                ab.e("MicroMsg.AppBrand.ZstdLogic", "mayProcessZstd exp: %s", e);
                                if (fileOutputStream != null) {
                                }
                                if (zstdInputStream != null) {
                                }
                                AppMethodBeat.o(59552);
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileOutputStream != null) {
                                }
                                if (zstdInputStream != null) {
                                }
                                AppMethodBeat.o(59552);
                                throw th;
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        fileOutputStream = null;
                        ab.e("MicroMsg.AppBrand.ZstdLogic", "mayProcessZstd exp: %s", e);
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
                        AppMethodBeat.o(59552);
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
                        AppMethodBeat.o(59552);
                        throw th;
                    }
                } catch (Exception e10) {
                    e = e10;
                    fileOutputStream = null;
                    zstdInputStream = null;
                    ab.e("MicroMsg.AppBrand.ZstdLogic", "mayProcessZstd exp: %s", e);
                    if (fileOutputStream != null) {
                    }
                    if (zstdInputStream != null) {
                    }
                    AppMethodBeat.o(59552);
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    zstdInputStream = null;
                    if (fileOutputStream != null) {
                    }
                    if (zstdInputStream != null) {
                    }
                    AppMethodBeat.o(59552);
                    throw th;
                }
            }
            ab.e("MicroMsg.AppBrand.ZstdLogic", "mayProcessZstd targetFile delete failed");
            AppMethodBeat.o(59552);
            return false;
        }
        ab.e("MicroMsg.AppBrand.ZstdLogic", "mayProcessZstd downloadFile not exists");
        AppMethodBeat.o(59552);
        return false;
    }
}
