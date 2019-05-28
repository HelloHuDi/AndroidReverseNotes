package com.tencent.mm.pluginsdk.g.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class a {
    public static long ek(String str) {
        AppMethodBeat.i(79641);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(79641);
            return 0;
        }
        File file = new File(str);
        if (file.isFile()) {
            long length = file.length();
            AppMethodBeat.o(79641);
            return length;
        }
        AppMethodBeat.o(79641);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008e A:{SYNTHETIC, Splitter:B:33:0x008e} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051 A:{SYNTHETIC, Splitter:B:18:0x0051} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077 A:{SYNTHETIC, Splitter:B:27:0x0077} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean D(String str, byte[] bArr) {
        Throwable e;
        AppMethodBeat.i(79642);
        if (bo.cb(bArr)) {
            AppMethodBeat.o(79642);
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
                    ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e2, "", new Object[0]);
                }
                AppMethodBeat.o(79642);
                return true;
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (IOException e22) {
                            ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e22, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(79642);
                    return false;
                } catch (Throwable th) {
                    e = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e4, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(79642);
                    throw e;
                }
            } catch (IOException e5) {
                e = e5;
                fileOutputStream = fileOutputStream2;
                try {
                    ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e222) {
                            ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e222, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(79642);
                    return false;
                } catch (Throwable th2) {
                    e = th2;
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.o(79642);
                    throw e;
                }
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileOutputStream2 = null;
            ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
            if (fileOutputStream2 != null) {
            }
            AppMethodBeat.o(79642);
            return false;
        } catch (IOException e7) {
            e = e7;
            ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
            if (fileOutputStream != null) {
            }
            AppMethodBeat.o(79642);
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
        AppMethodBeat.i(79643);
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (FileNotFoundException e2) {
                e = e2;
                byteArrayOutputStream = bArr;
                try {
                    ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                    e(fileInputStream);
                    e(byteArrayOutputStream);
                    AppMethodBeat.o(79643);
                    return bArr;
                } catch (Throwable th) {
                    e = th;
                    e(fileInputStream);
                    e(byteArrayOutputStream);
                    AppMethodBeat.o(79643);
                    throw e;
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = bArr;
                ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                e(fileInputStream);
                e(byteArrayOutputStream);
                AppMethodBeat.o(79643);
                return bArr;
            } catch (Throwable th2) {
                e = th2;
                byteArrayOutputStream = bArr;
                e(fileInputStream);
                e(byteArrayOutputStream);
                AppMethodBeat.o(79643);
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
                e(fileInputStream);
                e(byteArrayOutputStream);
                AppMethodBeat.o(79643);
            } catch (FileNotFoundException e4) {
                e = e4;
                ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                e(fileInputStream);
                e(byteArrayOutputStream);
                AppMethodBeat.o(79643);
                return bArr;
            } catch (IOException e5) {
                e = e5;
                ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                e(fileInputStream);
                e(byteArrayOutputStream);
                AppMethodBeat.o(79643);
                return bArr;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
            e(fileInputStream);
            e(byteArrayOutputStream);
            AppMethodBeat.o(79643);
            return bArr;
        } catch (IOException e7) {
            e = e7;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
            e(fileInputStream);
            e(byteArrayOutputStream);
            AppMethodBeat.o(79643);
            return bArr;
        } catch (Throwable th3) {
            e = th3;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            e(fileInputStream);
            e(byteArrayOutputStream);
            AppMethodBeat.o(79643);
            throw e;
        }
        return bArr;
    }

    public static void e(Closeable closeable) {
        AppMethodBeat.i(79644);
        if (closeable == null) {
            AppMethodBeat.o(79644);
            return;
        }
        try {
            closeable.close();
            AppMethodBeat.o(79644);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
            ab.e("MicroMsg.ResDownloaderFileUtils", String.format("%s close failed (%s)", new Object[]{closeable.getClass().getSimpleName(), e.getMessage()}));
            AppMethodBeat.o(79644);
        }
    }

    public static boolean ajj(String str) {
        AppMethodBeat.i(79645);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(79645);
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.delete()) {
            AppMethodBeat.o(79645);
            return true;
        }
        AppMethodBeat.o(79645);
        return false;
    }

    public static boolean ct(String str) {
        AppMethodBeat.i(79646);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(79646);
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            AppMethodBeat.o(79646);
            return true;
        }
        AppMethodBeat.o(79646);
        return false;
    }
}
