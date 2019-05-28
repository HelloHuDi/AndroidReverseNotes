package com.tencent.mm.vfs;

import android.net.Uri;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.e.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.FileSystemManager.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class e {
    public static InputStream openRead(String str) {
        AppMethodBeat.i(54625);
        if (str == null || str.isEmpty()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("path is empty");
            AppMethodBeat.o(54625);
            throw fileNotFoundException;
        }
        InputStream b = b(j.parseUri(str), null);
        AppMethodBeat.o(54625);
        return b;
    }

    public static InputStream b(Uri uri, d dVar) {
        FileNotFoundException fileNotFoundException;
        AppMethodBeat.i(54627);
        d a = FileSystemManager.dMy().a(uri, dVar);
        if (a.valid()) {
            try {
                InputStream openRead = a.zZs.openRead(a.path);
                AppMethodBeat.o(54627);
                return openRead;
            } catch (IOException e) {
                fileNotFoundException = (FileNotFoundException) new FileNotFoundException(e.getMessage()).initCause(e);
                AppMethodBeat.o(54627);
                throw fileNotFoundException;
            }
        }
        fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(uri)));
        AppMethodBeat.o(54627);
        throw fileNotFoundException;
    }

    public static OutputStream pH(String str) {
        AppMethodBeat.i(138986);
        OutputStream L = L(str, false);
        AppMethodBeat.o(138986);
        return L;
    }

    public static OutputStream L(String str, boolean z) {
        AppMethodBeat.i(54630);
        if (str == null || str.isEmpty()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("path is empty");
            AppMethodBeat.o(54630);
            throw fileNotFoundException;
        }
        OutputStream a = a(j.parseUri(str), null, z);
        AppMethodBeat.o(54630);
        return a;
    }

    static OutputStream a(Uri uri, d dVar, boolean z) {
        FileNotFoundException fileNotFoundException;
        AppMethodBeat.i(54632);
        d a = FileSystemManager.dMy().a(uri, dVar);
        if (a.valid()) {
            try {
                OutputStream L = a.zZs.L(a.path, z);
                AppMethodBeat.o(54632);
                return L;
            } catch (IOException e) {
                fileNotFoundException = (FileNotFoundException) new FileNotFoundException(e.getMessage()).initCause(e);
                AppMethodBeat.o(54632);
                throw fileNotFoundException;
            }
        }
        fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(uri)));
        AppMethodBeat.o(54632);
        throw fileNotFoundException;
    }

    public static RandomAccessFile ck(String str, boolean z) {
        AppMethodBeat.i(54633);
        if (str == null || str.isEmpty()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("path is empty");
            AppMethodBeat.o(54633);
            throw fileNotFoundException;
        }
        RandomAccessFile a = a(j.parseUri(str), z);
        AppMethodBeat.o(54633);
        return a;
    }

    private static RandomAccessFile a(Uri uri, boolean z) {
        AppMethodBeat.i(54634);
        d a = FileSystemManager.dMy().a(uri, null);
        if (a.valid()) {
            RandomAccessFile a2 = FileSystemManager.a(a, z);
            AppMethodBeat.o(54634);
            return a2;
        }
        FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(uri)));
        AppMethodBeat.o(54634);
        throw fileNotFoundException;
    }

    public static Uri asY(String str) {
        AppMethodBeat.i(54635);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(54635);
            return null;
        }
        d a = FileSystemManager.dMy().a(j.parseUri(str), null);
        if (a.valid()) {
            String a2 = FileSystemManager.a(a, false, true);
            if (a2 == null) {
                AppMethodBeat.o(54635);
                return null;
            }
            Uri fromFile = Uri.fromFile(new File(a2));
            AppMethodBeat.o(54635);
            return fromFile;
        }
        AppMethodBeat.o(54635);
        return null;
    }

    public static int a(String str, byte[] bArr, int i) {
        AppMethodBeat.i(54636);
        if (bArr == null || bArr.length == 0 || bArr.length < i + 0) {
            AppMethodBeat.o(54636);
            return -2;
        }
        OutputStream outputStream = null;
        try {
            outputStream = L(str, true);
            outputStream.write(bArr, 0, i);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    b.c("MicroMsg.VFSFileOp", e, "");
                    b.w("MicroMsg.VFSFileOp", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                }
            }
            AppMethodBeat.o(54636);
            return 0;
        } catch (Exception e2) {
            b.c("MicroMsg.VFSFileOp", e2, "");
            b.w("MicroMsg.VFSFileOp", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    b.c("MicroMsg.VFSFileOp", e3, "");
                    b.w("MicroMsg.VFSFileOp", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e3.getClass().getSimpleName(), e3.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                }
            }
            AppMethodBeat.o(54636);
            return -1;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    b.c("MicroMsg.VFSFileOp", e4, "");
                    b.w("MicroMsg.VFSFileOp", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                }
            }
            AppMethodBeat.o(54636);
        }
    }

    public static long asZ(String str) {
        AppMethodBeat.i(54637);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(54637);
            return 0;
        }
        d a = FileSystemManager.dMy().a(j.parseUri(str), null);
        if (a.valid()) {
            a to = a.zZs.to(a.path);
            if (to == null) {
                AppMethodBeat.o(54637);
                return 0;
            }
            long j = to.size;
            AppMethodBeat.o(54637);
            return j;
        }
        AppMethodBeat.o(54637);
        return 0;
    }

    public static long ata(String str) {
        AppMethodBeat.i(54638);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(54638);
            return 0;
        }
        d a = FileSystemManager.dMy().a(j.parseUri(str), null);
        if (a.valid()) {
            a to = a.zZs.to(a.path);
            if (to == null) {
                AppMethodBeat.o(54638);
                return 0;
            }
            long j = to.zYM;
            AppMethodBeat.o(54638);
            return j;
        }
        AppMethodBeat.o(54638);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050 A:{SYNTHETIC, Splitter:B:25:0x0050} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009d A:{SYNTHETIC, Splitter:B:36:0x009d} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00aa A:{SYNTHETIC, Splitter:B:42:0x00aa} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] e(String str, int i, int i2) {
        IOException e;
        Throwable th;
        AppMethodBeat.i(54639);
        if (str == null) {
            AppMethodBeat.o(54639);
            return null;
        }
        int i3 = (i2 < 0 || i2 > 8388608) ? 4096 : i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i3);
        InputStream openRead;
        try {
            openRead = openRead(str);
            long j = (long) i;
            while (j > 0) {
                try {
                    j -= openRead.skip(j);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        b.w("MicroMsg.VFSFileOp", "readFromFile failed: " + str + ", " + e.getMessage());
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e3) {
                            }
                        }
                        AppMethodBeat.o(54639);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openRead != null) {
                        }
                        AppMethodBeat.o(54639);
                        throw th;
                    }
                }
            }
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            if (i2 < 0) {
                i2 = BaseClientBuilder.API_PRIORITY_OTHER;
            }
            while (true) {
                int read = openRead.read(bArr, 0, Math.min(i2, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
                if (read != -1 && i2 > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                    i2 -= read;
                } else if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e4) {
                    }
                }
            }
            if (openRead != null) {
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
            }
            b.d("MicroMsg.VFSFileOp", "readFromFile: %s [%d]", str, Integer.valueOf(bArr.length));
            AppMethodBeat.o(54639);
            return bArr;
        } catch (IOException e6) {
            e = e6;
            openRead = null;
            b.w("MicroMsg.VFSFileOp", "readFromFile failed: " + str + ", " + e.getMessage());
            if (openRead != null) {
            }
            AppMethodBeat.o(54639);
            return null;
        } catch (Throwable th3) {
            th = th3;
            openRead = null;
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e7) {
                }
            }
            AppMethodBeat.o(54639);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046 A:{SYNTHETIC, Splitter:B:16:0x0046} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String cy(String str) {
        IOException e;
        Throwable th;
        AppMethodBeat.i(54640);
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(openRead(str));
            try {
                char[] cArr = new char[512];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringBuilder.append(cArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                        }
                    }
                }
                inputStreamReader.close();
                String stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.o(54640);
                return stringBuilder2;
            } catch (IOException e3) {
                e = e3;
                try {
                    b.e("MicroMsg.VFSFileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
                    AppMethodBeat.o(54640);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    AppMethodBeat.o(54640);
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            inputStreamReader = null;
            b.e("MicroMsg.VFSFileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
            AppMethodBeat.o(54640);
            throw e;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
            }
            AppMethodBeat.o(54640);
            throw th;
        }
    }

    public static int q(String str, byte[] bArr) {
        AppMethodBeat.i(138987);
        int b = b(str, bArr, bArr.length);
        AppMethodBeat.o(138987);
        return b;
    }

    public static int b(String str, byte[] bArr, int i) {
        AppMethodBeat.i(54642);
        if (bArr == null) {
            AppMethodBeat.o(54642);
            return -2;
        } else if (bArr.length < i + 0) {
            AppMethodBeat.o(54642);
            return -3;
        } else {
            OutputStream outputStream = null;
            try {
                outputStream = L(str, false);
                outputStream.write(bArr, 0, i);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.o(54642);
                return 0;
            } catch (IOException e2) {
                b.e("MicroMsg.VFSFileOp", "writeFile '%s' Failed: %s", str, e2.getMessage());
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
                AppMethodBeat.o(54642);
                return -1;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.o(54642);
            }
        }
    }

    public static String atb(String str) {
        AppMethodBeat.i(54643);
        String parent = new b(str).dME().getParent();
        AppMethodBeat.o(54643);
        return parent;
    }

    public static boolean tf(String str) {
        AppMethodBeat.i(54644);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(54644);
            return false;
        }
        b bVar = new b(str);
        if (bVar.mkdirs() || bVar.isDirectory()) {
            AppMethodBeat.o(54644);
            return true;
        }
        AppMethodBeat.o(54644);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0084 A:{SYNTHETIC, Splitter:B:36:0x0084} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089 A:{SYNTHETIC, Splitter:B:39:0x0089} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0094 A:{SYNTHETIC, Splitter:B:45:0x0094} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0099 A:{SYNTHETIC, Splitter:B:48:0x0099} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0084 A:{SYNTHETIC, Splitter:B:36:0x0084} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089 A:{SYNTHETIC, Splitter:B:39:0x0089} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0094 A:{SYNTHETIC, Splitter:B:45:0x0094} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0099 A:{SYNTHETIC, Splitter:B:48:0x0099} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long y(String str, String str2) {
        InputStream openRead;
        IOException e;
        Throwable th;
        AppMethodBeat.i(54645);
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            AppMethodBeat.o(54645);
            return -1;
        } else if (str.equals(str2)) {
            AppMethodBeat.o(54645);
            return -1;
        } else {
            OutputStream outputStream = null;
            try {
                OutputStream L;
                openRead = openRead(str);
                try {
                    L = L(str2, false);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        b.e("MicroMsg.VFSFileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                        if (openRead != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.o(54645);
                        return -1;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openRead != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.o(54645);
                        throw th;
                    }
                }
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    long j = 0;
                    while (true) {
                        int read = openRead.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        L.write(bArr, 0, read);
                        j += (long) read;
                    }
                    b.d("MicroMsg.VFSFileOp", "copyFile: %s -> %s", str, str2);
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (L != null) {
                        try {
                            L.close();
                        } catch (IOException e4) {
                        }
                    }
                    AppMethodBeat.o(54645);
                    return j;
                } catch (IOException e5) {
                    e = e5;
                    outputStream = L;
                    b.e("MicroMsg.VFSFileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                    if (openRead != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.o(54645);
                    return -1;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = L;
                    if (openRead != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.o(54645);
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                openRead = null;
                b.e("MicroMsg.VFSFileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e7) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e8) {
                    }
                }
                AppMethodBeat.o(54645);
                return -1;
            } catch (Throwable th4) {
                th = th4;
                openRead = null;
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e9) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e10) {
                    }
                }
                AppMethodBeat.o(54645);
                throw th;
            }
        }
    }

    public static boolean ct(String str) {
        AppMethodBeat.i(54646);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(54646);
            return false;
        }
        d a = FileSystemManager.dMy().a(j.parseUri(str), null);
        if (a.valid()) {
            boolean exists = a.zZs.exists(a.path);
            AppMethodBeat.o(54646);
            return exists;
        }
        AppMethodBeat.o(54646);
        return false;
    }

    public static boolean deleteFile(String str) {
        AppMethodBeat.i(54647);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(54647);
            return false;
        }
        boolean delete = new b(str).delete();
        AppMethodBeat.o(54647);
        return delete;
    }

    public static boolean h(String str, String str2, String str3) {
        AppMethodBeat.i(54648);
        boolean aQ = aQ(str + str2, str + str3);
        AppMethodBeat.o(54648);
        return aQ;
    }

    public static boolean aQ(String str, String str2) {
        AppMethodBeat.i(54649);
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            AppMethodBeat.o(54649);
            return false;
        } else if (new b(str).o(new b(str2))) {
            AppMethodBeat.o(54649);
            return true;
        } else if (y(str, str2) < 0) {
            AppMethodBeat.o(54649);
            return false;
        } else {
            deleteFile(str);
            AppMethodBeat.o(54649);
            return true;
        }
    }

    public static List<a> cl(String str, boolean z) {
        AppMethodBeat.i(54650);
        d a = FileSystemManager.dMy().a(j.parseUri(str), null);
        if (a.valid()) {
            List<a> M = a.zZs.M(a.path, z);
            AppMethodBeat.o(54650);
            return M;
        }
        AppMethodBeat.o(54650);
        return null;
    }

    public static boolean is(String str, String str2) {
        AppMethodBeat.i(54651);
        boolean a = a(FileSystemManager.dMy().a(j.parseUri(str), null), FileSystemManager.dMy().a(j.parseUri(str2), null));
        AppMethodBeat.o(54651);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0104 A:{SYNTHETIC, Splitter:B:58:0x0104} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0109 A:{SYNTHETIC, Splitter:B:61:0x0109} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0104 A:{SYNTHETIC, Splitter:B:58:0x0104} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0109 A:{SYNTHETIC, Splitter:B:61:0x0109} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e2 A:{SYNTHETIC, Splitter:B:40:0x00e2} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e7 A:{SYNTHETIC, Splitter:B:43:0x00e7} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0104 A:{SYNTHETIC, Splitter:B:58:0x0104} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0109 A:{SYNTHETIC, Splitter:B:61:0x0109} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(d dVar, d dVar2) {
        IOException e;
        OutputStream outputStream;
        Throwable th;
        AppMethodBeat.i(54652);
        if (dVar.valid() && dVar2.valid()) {
            List<a> M = dVar.zZs.M(dVar.path, true);
            if (M == null) {
                AppMethodBeat.o(54652);
                return false;
            }
            HashSet hashSet = new HashSet();
            dVar2.zZs.tf(dVar2.path);
            hashSet.add(dVar2.path);
            for (a aVar : M) {
                int length = dVar.path.length();
                if (dVar.path.endsWith("/")) {
                    length--;
                }
                String str = dVar2.path + aVar.zYK.substring(length);
                if (!aVar.zYN) {
                    int lastIndexOf = str.lastIndexOf(47);
                    if (lastIndexOf > 0) {
                        String substring = str.substring(0, lastIndexOf);
                        if (hashSet.add(substring)) {
                            dVar2.zZs.tf(substring);
                        }
                    }
                    InputStream dMu;
                    try {
                        dMu = aVar.dMu();
                        try {
                            OutputStream L = dVar2.zZs.L(str, false);
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = dMu.read(bArr);
                                    if (read < 0) {
                                        break;
                                    }
                                    L.write(bArr, 0, read);
                                }
                                if (dMu != null) {
                                    try {
                                        dMu.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                if (L != null) {
                                    try {
                                        L.close();
                                    } catch (Exception e3) {
                                    }
                                }
                            } catch (IOException e4) {
                                e = e4;
                                outputStream = L;
                                try {
                                    b.e("MicroMsg.VFSFileOp", "Cannot copy " + aVar.zYK + ": " + e.getMessage());
                                    if (dMu != null) {
                                    }
                                    if (outputStream != null) {
                                    }
                                    AppMethodBeat.o(54652);
                                    return false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (dMu != null) {
                                    }
                                    if (outputStream != null) {
                                    }
                                    AppMethodBeat.o(54652);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                outputStream = L;
                                if (dMu != null) {
                                }
                                if (outputStream != null) {
                                }
                                AppMethodBeat.o(54652);
                                throw th;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            outputStream = null;
                            b.e("MicroMsg.VFSFileOp", "Cannot copy " + aVar.zYK + ": " + e.getMessage());
                            if (dMu != null) {
                                try {
                                    dMu.close();
                                } catch (Exception e6) {
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception e7) {
                                }
                            }
                            AppMethodBeat.o(54652);
                            return false;
                        } catch (Throwable th4) {
                            th = th4;
                            outputStream = null;
                            if (dMu != null) {
                            }
                            if (outputStream != null) {
                            }
                            AppMethodBeat.o(54652);
                            throw th;
                        }
                    } catch (IOException e8) {
                        e = e8;
                        outputStream = null;
                        dMu = null;
                    } catch (Throwable th5) {
                        th = th5;
                        outputStream = null;
                        dMu = null;
                        if (dMu != null) {
                            try {
                                dMu.close();
                            } catch (Exception e9) {
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e10) {
                            }
                        }
                        AppMethodBeat.o(54652);
                        throw th;
                    }
                } else if (hashSet.add(str)) {
                    dVar2.zZs.tf(str);
                }
            }
            AppMethodBeat.o(54652);
            return true;
        }
        AppMethodBeat.o(54652);
        return false;
    }

    public static boolean it(String str, String str2) {
        AppMethodBeat.i(54653);
        d a = FileSystemManager.dMy().a(j.parseUri(str), null);
        d a2 = FileSystemManager.dMy().a(j.parseUri(str2), null);
        if (a.valid() && a.zZs == a2.zZs && (a.zZs.aiR() & 32) != 0 && a.zZs.aS(str, str2)) {
            AppMethodBeat.o(54653);
            return true;
        } else if (a(a, a2) && N(str, false)) {
            AppMethodBeat.o(54653);
            return true;
        } else {
            AppMethodBeat.o(54653);
            return false;
        }
    }

    public static boolean cu(String str) {
        AppMethodBeat.i(138988);
        boolean N = N(str, true);
        AppMethodBeat.o(138988);
        return N;
    }

    public static boolean N(String str, boolean z) {
        AppMethodBeat.i(54655);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(54655);
            return false;
        }
        d a = FileSystemManager.dMy().a(j.parseUri(str), null);
        if (a.valid()) {
            boolean N = a.zZs.N(a.path, z);
            AppMethodBeat.o(54655);
            return N;
        }
        AppMethodBeat.o(54655);
        return false;
    }

    public static boolean atc(String str) {
        AppMethodBeat.i(54656);
        try {
            b bVar = new b(str);
            if (bVar.exists() || bVar.createNewFile()) {
                AppMethodBeat.o(54656);
                return true;
            }
            AppMethodBeat.o(54656);
            return false;
        } catch (IOException e) {
            AppMethodBeat.o(54656);
            return false;
        }
    }

    public static String cv(String str) {
        AppMethodBeat.i(54657);
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = "";
            AppMethodBeat.o(54657);
            return str2;
        }
        str2 = new b(str).getName();
        int lastIndexOf = str2.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf == str2.length() - 1) {
            str2 = "";
            AppMethodBeat.o(54657);
            return str2;
        }
        str2 = str2.substring(lastIndexOf + 1);
        AppMethodBeat.o(54657);
        return str2;
    }

    public static final String atd(String str) {
        AppMethodBeat.i(54658);
        if (str == null || str.length() <= 0) {
            str = "";
            AppMethodBeat.o(54658);
            return str;
        }
        String name = new b(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            AppMethodBeat.o(54658);
            return str;
        } else if (lastIndexOf == 0) {
            str = "";
            AppMethodBeat.o(54658);
            return str;
        } else {
            str = name.substring(0, lastIndexOf);
            AppMethodBeat.o(54658);
            return str;
        }
    }

    public static void ate(String str) {
        AppMethodBeat.i(54659);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(54659);
            return;
        }
        d a = FileSystemManager.dMy().a(j.parseUri(str), null);
        if (!a.valid()) {
            AppMethodBeat.o(54659);
        } else if ((a.zZs.aiR() & 4) == 0) {
            AppMethodBeat.o(54659);
        } else if (a.zZs.O(a.path, true) == null) {
            AppMethodBeat.o(54659);
        } else {
            try {
                a.zZs.L(a.path + "/.nomedia", false).close();
                AppMethodBeat.o(54659);
            } catch (IOException e) {
                AppMethodBeat.o(54659);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0043 A:{SYNTHETIC, Splitter:B:26:0x0043} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] atf(String str) {
        InputStream openRead;
        Throwable th;
        InputStream inputStream;
        byte[] bArr = null;
        AppMethodBeat.i(54660);
        if (str == null) {
            AppMethodBeat.o(54660);
        } else {
            try {
                openRead = openRead(str);
                try {
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    byte[] bArr2 = new byte[2048];
                    while (true) {
                        int read = openRead.read(bArr2);
                        if (read < 0) {
                            break;
                        }
                        instance.update(bArr2, 0, read);
                    }
                    bArr = instance.digest();
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e) {
                        }
                    }
                    AppMethodBeat.o(54660);
                } catch (Exception e2) {
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = openRead;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    AppMethodBeat.o(54660);
                    throw th;
                }
            } catch (Exception e4) {
                openRead = bArr;
            } catch (Throwable th3) {
                th = th3;
                inputStream = bArr;
                if (inputStream != null) {
                }
                AppMethodBeat.o(54660);
                throw th;
            }
        }
        return bArr;
        if (openRead != null) {
            try {
                openRead.close();
            } catch (IOException e5) {
            }
        }
        AppMethodBeat.o(54660);
        return bArr;
        AppMethodBeat.o(54660);
        return bArr;
    }

    public static String atg(String str) {
        AppMethodBeat.i(54661);
        byte[] atf = atf(str);
        if (atf == null) {
            AppMethodBeat.o(54661);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        for (byte b : atf) {
            stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(54661);
        return stringBuilder2;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0061=Splitter:B:15:0x0061, B:28:0x00a5=Splitter:B:28:0x00a5} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006c A:{SYNTHETIC, Splitter:B:18:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b0 A:{SYNTHETIC, Splitter:B:31:0x00b0} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c0 A:{SYNTHETIC, Splitter:B:39:0x00c0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int iu(String str, String str2) {
        Throwable e;
        AppMethodBeat.i(54662);
        ZipInputStream zipInputStream;
        try {
            zipInputStream = new ZipInputStream(openRead(str));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!(name.contains("../") || name.contains("..\\"))) {
                            if (nextEntry.isDirectory()) {
                                new b(str2 + "/" + name.substring(0, name.length() - 1)).mkdirs();
                            } else {
                                OutputStream q = q(new b(str2 + "/" + name));
                                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    q.write(bArr, 0, read);
                                }
                                q.close();
                            }
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            b.e("MicroMsg.VFSFileOp", "close zip stream failed.");
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    try {
                        b.c("MicroMsg.VFSFileOp", e, "");
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                            } catch (IOException e4) {
                                b.e("MicroMsg.VFSFileOp", "close zip stream failed.");
                            }
                        }
                        AppMethodBeat.o(54662);
                        return -1;
                    } catch (Throwable th) {
                        e = th;
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                            } catch (IOException e5) {
                                b.e("MicroMsg.VFSFileOp", "close zip stream failed.");
                            }
                        }
                        AppMethodBeat.o(54662);
                        throw e;
                    }
                } catch (IOException e6) {
                    e = e6;
                    b.c("MicroMsg.VFSFileOp", e, "");
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                        } catch (IOException e7) {
                            b.e("MicroMsg.VFSFileOp", "close zip stream failed.");
                        }
                    }
                    AppMethodBeat.o(54662);
                    return -2;
                }
            }
            zipInputStream.close();
            AppMethodBeat.o(54662);
            return 0;
        } catch (FileNotFoundException e8) {
            e = e8;
            zipInputStream = null;
            b.c("MicroMsg.VFSFileOp", e, "");
            if (zipInputStream != null) {
            }
            AppMethodBeat.o(54662);
            return -1;
        } catch (IOException e9) {
            e = e9;
            zipInputStream = null;
            b.c("MicroMsg.VFSFileOp", e, "");
            if (zipInputStream != null) {
            }
            AppMethodBeat.o(54662);
            return -2;
        } catch (Throwable th2) {
            e = th2;
            zipInputStream = null;
            if (zipInputStream != null) {
            }
            AppMethodBeat.o(54662);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00be A:{SYNTHETIC, Splitter:B:44:0x00be} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c3 A:{SYNTHETIC, Splitter:B:47:0x00c3} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ff A:{SYNTHETIC, Splitter:B:68:0x00ff} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0104 A:{SYNTHETIC, Splitter:B:71:0x0104} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ff A:{SYNTHETIC, Splitter:B:68:0x00ff} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0104 A:{SYNTHETIC, Splitter:B:71:0x0104} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00be A:{SYNTHETIC, Splitter:B:44:0x00be} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c3 A:{SYNTHETIC, Splitter:B:47:0x00c3} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ff A:{SYNTHETIC, Splitter:B:68:0x00ff} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0104 A:{SYNTHETIC, Splitter:B:71:0x0104} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m(List<String> list, String str) {
        Throwable e;
        ZipOutputStream zipOutputStream;
        AppMethodBeat.i(54663);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(54663);
            return false;
        }
        tf(atb(str));
        byte[] bArr = new byte[4096];
        ZipOutputStream zipOutputStream2;
        InputStream dMu;
        try {
            zipOutputStream2 = new ZipOutputStream(L(str, false));
            try {
                for (String parseUri : list) {
                    d a = FileSystemManager.dMy().a(j.parseUri(parseUri), null);
                    if (a.valid()) {
                        a to = a.zZs.to(a.path);
                        if (to != null) {
                            int length;
                            int i;
                            List M;
                            if (to.zYN) {
                                length = (a.path.endsWith("/") ? 0 : 1) + a.path.length();
                                M = a.zZs.M(a.path, true);
                                if (M != null) {
                                    i = length;
                                }
                            } else {
                                length = a.path.lastIndexOf(47) + 1;
                                M = Collections.singletonList(to);
                                i = length;
                            }
                            for (a aVar : M) {
                                if (!aVar.zYN) {
                                    String str2;
                                    if (aVar.zYK.length() < i) {
                                        str2 = aVar.name;
                                    } else {
                                        str2 = aVar.zYK.substring(i);
                                    }
                                    dMu = aVar.dMu();
                                    try {
                                        zipOutputStream2.putNextEntry(new ZipEntry(str2));
                                        while (true) {
                                            length = dMu.read(bArr);
                                            if (length < 0) {
                                                break;
                                            }
                                            zipOutputStream2.write(bArr, 0, length);
                                        }
                                        dMu.close();
                                        zipOutputStream2.closeEntry();
                                    } catch (IOException e2) {
                                        e = e2;
                                        zipOutputStream = zipOutputStream2;
                                        try {
                                            b.c("MicroMsg.VFSFileOp", e, "Failed to write ZipFile");
                                            if (dMu != null) {
                                                try {
                                                    dMu.close();
                                                } catch (IOException e3) {
                                                }
                                            }
                                            if (zipOutputStream != null) {
                                                try {
                                                    zipOutputStream.close();
                                                } catch (IOException e4) {
                                                }
                                            }
                                            AppMethodBeat.o(54663);
                                            return false;
                                        } catch (Throwable th) {
                                            e = th;
                                            zipOutputStream2 = zipOutputStream;
                                            if (dMu != null) {
                                            }
                                            if (zipOutputStream2 != null) {
                                            }
                                            AppMethodBeat.o(54663);
                                            throw e;
                                        }
                                    } catch (Throwable th2) {
                                        e = th2;
                                        if (dMu != null) {
                                            try {
                                                dMu.close();
                                            } catch (IOException e5) {
                                            }
                                        }
                                        if (zipOutputStream2 != null) {
                                            try {
                                                zipOutputStream2.close();
                                            } catch (IOException e6) {
                                            }
                                        }
                                        AppMethodBeat.o(54663);
                                        throw e;
                                    }
                                }
                            }
                        }
                    }
                }
                try {
                    zipOutputStream2.close();
                } catch (IOException e7) {
                }
                AppMethodBeat.o(54663);
                return true;
            } catch (IOException e8) {
                e = e8;
                zipOutputStream = zipOutputStream2;
                dMu = null;
                b.c("MicroMsg.VFSFileOp", e, "Failed to write ZipFile");
                if (dMu != null) {
                }
                if (zipOutputStream != null) {
                }
                AppMethodBeat.o(54663);
                return false;
            } catch (Throwable th3) {
                e = th3;
                dMu = null;
                if (dMu != null) {
                }
                if (zipOutputStream2 != null) {
                }
                AppMethodBeat.o(54663);
                throw e;
            }
        } catch (IOException e9) {
            e = e9;
            zipOutputStream = null;
            dMu = null;
            b.c("MicroMsg.VFSFileOp", e, "Failed to write ZipFile");
            if (dMu != null) {
            }
            if (zipOutputStream != null) {
            }
            AppMethodBeat.o(54663);
            return false;
        } catch (Throwable th4) {
            e = th4;
            zipOutputStream2 = null;
            dMu = null;
            if (dMu != null) {
            }
            if (zipOutputStream2 != null) {
            }
            AppMethodBeat.o(54663);
            throw e;
        }
    }

    public static InputStream p(b bVar) {
        AppMethodBeat.i(54626);
        InputStream b = b(bVar.mUri, bVar.dMA());
        AppMethodBeat.o(54626);
        return b;
    }

    public static OutputStream q(b bVar) {
        AppMethodBeat.i(54629);
        OutputStream a = a(bVar.mUri, bVar.dMA(), false);
        AppMethodBeat.o(54629);
        return a;
    }

    public static OutputStream r(b bVar) {
        AppMethodBeat.i(54631);
        OutputStream a = a(bVar.mUri, bVar.dMA(), false);
        AppMethodBeat.o(54631);
        return a;
    }
}
