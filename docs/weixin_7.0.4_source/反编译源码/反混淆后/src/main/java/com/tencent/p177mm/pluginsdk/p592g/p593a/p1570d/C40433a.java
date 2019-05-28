package com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.mm.pluginsdk.g.a.d.a */
public final class C40433a {
    /* renamed from: ek */
    public static long m69347ek(String str) {
        AppMethodBeat.m2504i(79641);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(79641);
            return 0;
        }
        File file = new File(str);
        if (file.isFile()) {
            long length = file.length();
            AppMethodBeat.m2505o(79641);
            return length;
        }
        AppMethodBeat.m2505o(79641);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008e A:{SYNTHETIC, Splitter:B:33:0x008e} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051 A:{SYNTHETIC, Splitter:B:18:0x0051} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077 A:{SYNTHETIC, Splitter:B:27:0x0077} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: D */
    public static boolean m69344D(String str, byte[] bArr) {
        Throwable e;
        AppMethodBeat.m2504i(79642);
        if (C5046bo.m7540cb(bArr)) {
            AppMethodBeat.m2505o(79642);
            return false;
        }
        File file = new File(str);
        file.delete();
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2;
        try {
            fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                try {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e2, "", new Object[0]);
                }
                AppMethodBeat.m2505o(79642);
                return true;
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e22, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(79642);
                    return false;
                } catch (Throwable th) {
                    e = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e4, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(79642);
                    throw e;
                }
            } catch (IOException e5) {
                e = e5;
                fileOutputStream = fileOutputStream2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e222) {
                            C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e222, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(79642);
                    return false;
                } catch (Throwable th2) {
                    e = th2;
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(79642);
                    throw e;
                }
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileOutputStream2 = null;
            C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
            if (fileOutputStream2 != null) {
            }
            AppMethodBeat.m2505o(79642);
            return false;
        } catch (IOException e7) {
            e = e7;
            C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
            if (fileOutputStream != null) {
            }
            AppMethodBeat.m2505o(79642);
            return false;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0022=Splitter:B:13:0x0022, B:23:0x004c=Splitter:B:23:0x004c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] aji(String str) {
        Closeable fileInputStream;
        Closeable byteArrayOutputStream;
        Throwable e;
        byte[] bArr = null;
        AppMethodBeat.m2504i(79643);
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (FileNotFoundException e2) {
                e = e2;
                byteArrayOutputStream = bArr;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                    C40433a.m69346e(fileInputStream);
                    C40433a.m69346e(byteArrayOutputStream);
                    AppMethodBeat.m2505o(79643);
                    return bArr;
                } catch (Throwable th) {
                    e = th;
                    C40433a.m69346e(fileInputStream);
                    C40433a.m69346e(byteArrayOutputStream);
                    AppMethodBeat.m2505o(79643);
                    throw e;
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = bArr;
                C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                C40433a.m69346e(fileInputStream);
                C40433a.m69346e(byteArrayOutputStream);
                AppMethodBeat.m2505o(79643);
                return bArr;
            } catch (Throwable th2) {
                e = th2;
                byteArrayOutputStream = bArr;
                C40433a.m69346e(fileInputStream);
                C40433a.m69346e(byteArrayOutputStream);
                AppMethodBeat.m2505o(79643);
                throw e;
            }
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                byteArrayOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
                C40433a.m69346e(fileInputStream);
                C40433a.m69346e(byteArrayOutputStream);
                AppMethodBeat.m2505o(79643);
            } catch (FileNotFoundException e4) {
                e = e4;
                C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                C40433a.m69346e(fileInputStream);
                C40433a.m69346e(byteArrayOutputStream);
                AppMethodBeat.m2505o(79643);
                return bArr;
            } catch (IOException e5) {
                e = e5;
                C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                C40433a.m69346e(fileInputStream);
                C40433a.m69346e(byteArrayOutputStream);
                AppMethodBeat.m2505o(79643);
                return bArr;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
            C40433a.m69346e(fileInputStream);
            C40433a.m69346e(byteArrayOutputStream);
            AppMethodBeat.m2505o(79643);
            return bArr;
        } catch (IOException e7) {
            e = e7;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
            C40433a.m69346e(fileInputStream);
            C40433a.m69346e(byteArrayOutputStream);
            AppMethodBeat.m2505o(79643);
            return bArr;
        } catch (Throwable th3) {
            e = th3;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            C40433a.m69346e(fileInputStream);
            C40433a.m69346e(byteArrayOutputStream);
            AppMethodBeat.m2505o(79643);
            throw e;
        }
        return bArr;
    }

    /* renamed from: e */
    public static void m69346e(Closeable closeable) {
        AppMethodBeat.m2504i(79644);
        if (closeable == null) {
            AppMethodBeat.m2505o(79644);
            return;
        }
        try {
            closeable.close();
            AppMethodBeat.m2505o(79644);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.ResDownloaderFileUtils", String.format("%s close failed (%s)", new Object[]{closeable.getClass().getSimpleName(), e.getMessage()}));
            AppMethodBeat.m2505o(79644);
        }
    }

    public static boolean ajj(String str) {
        AppMethodBeat.m2504i(79645);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(79645);
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.delete()) {
            AppMethodBeat.m2505o(79645);
            return true;
        }
        AppMethodBeat.m2505o(79645);
        return false;
    }

    /* renamed from: ct */
    public static boolean m69345ct(String str) {
        AppMethodBeat.m2504i(79646);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(79646);
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            AppMethodBeat.m2505o(79646);
            return true;
        }
        AppMethodBeat.m2505o(79646);
        return false;
    }
}
