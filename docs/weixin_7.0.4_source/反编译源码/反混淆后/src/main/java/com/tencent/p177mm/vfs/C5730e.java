package com.tencent.p177mm.vfs;

import android.net.Uri;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p136e.p137a.C0926b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.vfs.FileSystem.C5712a;
import com.tencent.p177mm.vfs.FileSystemManager.C5718d;
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

/* renamed from: com.tencent.mm.vfs.e */
public final class C5730e {
    public static InputStream openRead(String str) {
        AppMethodBeat.m2504i(54625);
        if (str == null || str.isEmpty()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("path is empty");
            AppMethodBeat.m2505o(54625);
            throw fileNotFoundException;
        }
        InputStream b = C5730e.m8625b(C5736j.parseUri(str), null);
        AppMethodBeat.m2505o(54625);
        return b;
    }

    /* renamed from: b */
    public static InputStream m8625b(Uri uri, C5718d c5718d) {
        FileNotFoundException fileNotFoundException;
        AppMethodBeat.m2504i(54627);
        C5718d a = FileSystemManager.dMy().mo11633a(uri, c5718d);
        if (a.valid()) {
            try {
                InputStream openRead = a.zZs.openRead(a.path);
                AppMethodBeat.m2505o(54627);
                return openRead;
            } catch (IOException e) {
                fileNotFoundException = (FileNotFoundException) new FileNotFoundException(e.getMessage()).initCause(e);
                AppMethodBeat.m2505o(54627);
                throw fileNotFoundException;
            }
        }
        fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(uri)));
        AppMethodBeat.m2505o(54627);
        throw fileNotFoundException;
    }

    /* renamed from: pH */
    public static OutputStream m8639pH(String str) {
        AppMethodBeat.m2504i(138986);
        OutputStream L = C5730e.m8617L(str, false);
        AppMethodBeat.m2505o(138986);
        return L;
    }

    /* renamed from: L */
    public static OutputStream m8617L(String str, boolean z) {
        AppMethodBeat.m2504i(54630);
        if (str == null || str.isEmpty()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("path is empty");
            AppMethodBeat.m2505o(54630);
            throw fileNotFoundException;
        }
        OutputStream a = C5730e.m8620a(C5736j.parseUri(str), null, z);
        AppMethodBeat.m2505o(54630);
        return a;
    }

    /* renamed from: a */
    static OutputStream m8620a(Uri uri, C5718d c5718d, boolean z) {
        FileNotFoundException fileNotFoundException;
        AppMethodBeat.m2504i(54632);
        C5718d a = FileSystemManager.dMy().mo11633a(uri, c5718d);
        if (a.valid()) {
            try {
                OutputStream L = a.zZs.mo11607L(a.path, z);
                AppMethodBeat.m2505o(54632);
                return L;
            } catch (IOException e) {
                fileNotFoundException = (FileNotFoundException) new FileNotFoundException(e.getMessage()).initCause(e);
                AppMethodBeat.m2505o(54632);
                throw fileNotFoundException;
            }
        }
        fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(uri)));
        AppMethodBeat.m2505o(54632);
        throw fileNotFoundException;
    }

    /* renamed from: ck */
    public static RandomAccessFile m8626ck(String str, boolean z) {
        AppMethodBeat.m2504i(54633);
        if (str == null || str.isEmpty()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("path is empty");
            AppMethodBeat.m2505o(54633);
            throw fileNotFoundException;
        }
        RandomAccessFile a = C5730e.m8621a(C5736j.parseUri(str), z);
        AppMethodBeat.m2505o(54633);
        return a;
    }

    /* renamed from: a */
    private static RandomAccessFile m8621a(Uri uri, boolean z) {
        AppMethodBeat.m2504i(54634);
        C5718d a = FileSystemManager.dMy().mo11633a(uri, null);
        if (a.valid()) {
            RandomAccessFile a2 = FileSystemManager.m8597a(a, z);
            AppMethodBeat.m2505o(54634);
            return a2;
        }
        FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(uri)));
        AppMethodBeat.m2505o(54634);
        throw fileNotFoundException;
    }

    public static Uri asY(String str) {
        AppMethodBeat.m2504i(54635);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(54635);
            return null;
        }
        C5718d a = FileSystemManager.dMy().mo11633a(C5736j.parseUri(str), null);
        if (a.valid()) {
            String a2 = FileSystemManager.m8598a(a, false, true);
            if (a2 == null) {
                AppMethodBeat.m2505o(54635);
                return null;
            }
            Uri fromFile = Uri.fromFile(new File(a2));
            AppMethodBeat.m2505o(54635);
            return fromFile;
        }
        AppMethodBeat.m2505o(54635);
        return null;
    }

    /* renamed from: a */
    public static int m8619a(String str, byte[] bArr, int i) {
        AppMethodBeat.m2504i(54636);
        if (bArr == null || bArr.length == 0 || bArr.length < i + 0) {
            AppMethodBeat.m2505o(54636);
            return -2;
        }
        OutputStream outputStream = null;
        try {
            outputStream = C5730e.m8617L(str, true);
            outputStream.write(bArr, 0, i);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    C0926b.m2100c("MicroMsg.VFSFileOp", e, "");
                    C0926b.m2108w("MicroMsg.VFSFileOp", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                }
            }
            AppMethodBeat.m2505o(54636);
            return 0;
        } catch (Exception e2) {
            C0926b.m2100c("MicroMsg.VFSFileOp", e2, "");
            C0926b.m2108w("MicroMsg.VFSFileOp", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    C0926b.m2100c("MicroMsg.VFSFileOp", e3, "");
                    C0926b.m2108w("MicroMsg.VFSFileOp", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e3.getClass().getSimpleName(), e3.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                }
            }
            AppMethodBeat.m2505o(54636);
            return -1;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    C0926b.m2100c("MicroMsg.VFSFileOp", e4, "");
                    C0926b.m2108w("MicroMsg.VFSFileOp", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                }
            }
            AppMethodBeat.m2505o(54636);
        }
    }

    public static long asZ(String str) {
        AppMethodBeat.m2504i(54637);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(54637);
            return 0;
        }
        C5718d a = FileSystemManager.dMy().mo11633a(C5736j.parseUri(str), null);
        if (a.valid()) {
            C5712a to = a.zZs.mo11621to(a.path);
            if (to == null) {
                AppMethodBeat.m2505o(54637);
                return 0;
            }
            long j = to.size;
            AppMethodBeat.m2505o(54637);
            return j;
        }
        AppMethodBeat.m2505o(54637);
        return 0;
    }

    public static long ata(String str) {
        AppMethodBeat.m2504i(54638);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(54638);
            return 0;
        }
        C5718d a = FileSystemManager.dMy().mo11633a(C5736j.parseUri(str), null);
        if (a.valid()) {
            C5712a to = a.zZs.mo11621to(a.path);
            if (to == null) {
                AppMethodBeat.m2505o(54638);
                return 0;
            }
            long j = to.zYM;
            AppMethodBeat.m2505o(54638);
            return j;
        }
        AppMethodBeat.m2505o(54638);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050 A:{SYNTHETIC, Splitter:B:25:0x0050} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009d A:{SYNTHETIC, Splitter:B:36:0x009d} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00aa A:{SYNTHETIC, Splitter:B:42:0x00aa} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public static byte[] m8632e(String str, int i, int i2) {
        IOException e;
        Throwable th;
        AppMethodBeat.m2504i(54639);
        if (str == null) {
            AppMethodBeat.m2505o(54639);
            return null;
        }
        int i3 = (i2 < 0 || i2 > 8388608) ? 4096 : i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i3);
        InputStream openRead;
        try {
            openRead = C5730e.openRead(str);
            long j = (long) i;
            while (j > 0) {
                try {
                    j -= openRead.skip(j);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        C0926b.m2107w("MicroMsg.VFSFileOp", "readFromFile failed: " + str + ", " + e.getMessage());
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e3) {
                            }
                        }
                        AppMethodBeat.m2505o(54639);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openRead != null) {
                        }
                        AppMethodBeat.m2505o(54639);
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
            C0926b.m2102d("MicroMsg.VFSFileOp", "readFromFile: %s [%d]", str, Integer.valueOf(bArr.length));
            AppMethodBeat.m2505o(54639);
            return bArr;
        } catch (IOException e6) {
            e = e6;
            openRead = null;
            C0926b.m2107w("MicroMsg.VFSFileOp", "readFromFile failed: " + str + ", " + e.getMessage());
            if (openRead != null) {
            }
            AppMethodBeat.m2505o(54639);
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
            AppMethodBeat.m2505o(54639);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046 A:{SYNTHETIC, Splitter:B:16:0x0046} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: cy */
    public static String m8631cy(String str) {
        IOException e;
        Throwable th;
        AppMethodBeat.m2504i(54640);
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(C5730e.openRead(str));
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
                AppMethodBeat.m2505o(54640);
                return stringBuilder2;
            } catch (IOException e3) {
                e = e3;
                try {
                    C0926b.m2104e("MicroMsg.VFSFileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
                    AppMethodBeat.m2505o(54640);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    AppMethodBeat.m2505o(54640);
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            inputStreamReader = null;
            C0926b.m2104e("MicroMsg.VFSFileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
            AppMethodBeat.m2505o(54640);
            throw e;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
            }
            AppMethodBeat.m2505o(54640);
            throw th;
        }
    }

    /* renamed from: q */
    public static int m8640q(String str, byte[] bArr) {
        AppMethodBeat.m2504i(138987);
        int b = C5730e.m8624b(str, bArr, bArr.length);
        AppMethodBeat.m2505o(138987);
        return b;
    }

    /* renamed from: b */
    public static int m8624b(String str, byte[] bArr, int i) {
        AppMethodBeat.m2504i(54642);
        if (bArr == null) {
            AppMethodBeat.m2505o(54642);
            return -2;
        } else if (bArr.length < i + 0) {
            AppMethodBeat.m2505o(54642);
            return -3;
        } else {
            OutputStream outputStream = null;
            try {
                outputStream = C5730e.m8617L(str, false);
                outputStream.write(bArr, 0, i);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.m2505o(54642);
                return 0;
            } catch (IOException e2) {
                C0926b.m2104e("MicroMsg.VFSFileOp", "writeFile '%s' Failed: %s", str, e2.getMessage());
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
                AppMethodBeat.m2505o(54642);
                return -1;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.m2505o(54642);
            }
        }
    }

    public static String atb(String str) {
        AppMethodBeat.m2504i(54643);
        String parent = new C5728b(str).dME().getParent();
        AppMethodBeat.m2505o(54643);
        return parent;
    }

    /* renamed from: tf */
    public static boolean m8643tf(String str) {
        AppMethodBeat.m2504i(54644);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(54644);
            return false;
        }
        C5728b c5728b = new C5728b(str);
        if (c5728b.mkdirs() || c5728b.isDirectory()) {
            AppMethodBeat.m2505o(54644);
            return true;
        }
        AppMethodBeat.m2505o(54644);
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
    /* renamed from: y */
    public static long m8644y(String str, String str2) {
        InputStream openRead;
        IOException e;
        Throwable th;
        AppMethodBeat.m2504i(54645);
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            AppMethodBeat.m2505o(54645);
            return -1;
        } else if (str.equals(str2)) {
            AppMethodBeat.m2505o(54645);
            return -1;
        } else {
            OutputStream outputStream = null;
            try {
                OutputStream L;
                openRead = C5730e.openRead(str);
                try {
                    L = C5730e.m8617L(str2, false);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        C0926b.m2104e("MicroMsg.VFSFileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                        if (openRead != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(54645);
                        return -1;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openRead != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(54645);
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
                    C0926b.m2102d("MicroMsg.VFSFileOp", "copyFile: %s -> %s", str, str2);
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
                    AppMethodBeat.m2505o(54645);
                    return j;
                } catch (IOException e5) {
                    e = e5;
                    outputStream = L;
                    C0926b.m2104e("MicroMsg.VFSFileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                    if (openRead != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(54645);
                    return -1;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = L;
                    if (openRead != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(54645);
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                openRead = null;
                C0926b.m2104e("MicroMsg.VFSFileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
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
                AppMethodBeat.m2505o(54645);
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
                AppMethodBeat.m2505o(54645);
                throw th;
            }
        }
    }

    /* renamed from: ct */
    public static boolean m8628ct(String str) {
        AppMethodBeat.m2504i(54646);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(54646);
            return false;
        }
        C5718d a = FileSystemManager.dMy().mo11633a(C5736j.parseUri(str), null);
        if (a.valid()) {
            boolean exists = a.zZs.exists(a.path);
            AppMethodBeat.m2505o(54646);
            return exists;
        }
        AppMethodBeat.m2505o(54646);
        return false;
    }

    public static boolean deleteFile(String str) {
        AppMethodBeat.m2504i(54647);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(54647);
            return false;
        }
        boolean delete = new C5728b(str).delete();
        AppMethodBeat.m2505o(54647);
        return delete;
    }

    /* renamed from: h */
    public static boolean m8633h(String str, String str2, String str3) {
        AppMethodBeat.m2504i(54648);
        boolean aQ = C5730e.m8623aQ(str + str2, str + str3);
        AppMethodBeat.m2505o(54648);
        return aQ;
    }

    /* renamed from: aQ */
    public static boolean m8623aQ(String str, String str2) {
        AppMethodBeat.m2504i(54649);
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            AppMethodBeat.m2505o(54649);
            return false;
        } else if (new C5728b(str).mo11675o(new C5728b(str2))) {
            AppMethodBeat.m2505o(54649);
            return true;
        } else if (C5730e.m8644y(str, str2) < 0) {
            AppMethodBeat.m2505o(54649);
            return false;
        } else {
            C5730e.deleteFile(str);
            AppMethodBeat.m2505o(54649);
            return true;
        }
    }

    /* renamed from: cl */
    public static List<C5712a> m8627cl(String str, boolean z) {
        AppMethodBeat.m2504i(54650);
        C5718d a = FileSystemManager.dMy().mo11633a(C5736j.parseUri(str), null);
        if (a.valid()) {
            List<C5712a> M = a.zZs.mo11608M(a.path, z);
            AppMethodBeat.m2505o(54650);
            return M;
        }
        AppMethodBeat.m2505o(54650);
        return null;
    }

    /* renamed from: is */
    public static boolean m8634is(String str, String str2) {
        AppMethodBeat.m2504i(54651);
        boolean a = C5730e.m8622a(FileSystemManager.dMy().mo11633a(C5736j.parseUri(str), null), FileSystemManager.dMy().mo11633a(C5736j.parseUri(str2), null));
        AppMethodBeat.m2505o(54651);
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
    /* renamed from: a */
    private static boolean m8622a(C5718d c5718d, C5718d c5718d2) {
        IOException e;
        OutputStream outputStream;
        Throwable th;
        AppMethodBeat.m2504i(54652);
        if (c5718d.valid() && c5718d2.valid()) {
            List<C5712a> M = c5718d.zZs.mo11608M(c5718d.path, true);
            if (M == null) {
                AppMethodBeat.m2505o(54652);
                return false;
            }
            HashSet hashSet = new HashSet();
            c5718d2.zZs.mo11619tf(c5718d2.path);
            hashSet.add(c5718d2.path);
            for (C5712a c5712a : M) {
                int length = c5718d.path.length();
                if (c5718d.path.endsWith("/")) {
                    length--;
                }
                String str = c5718d2.path + c5712a.zYK.substring(length);
                if (!c5712a.zYN) {
                    int lastIndexOf = str.lastIndexOf(47);
                    if (lastIndexOf > 0) {
                        String substring = str.substring(0, lastIndexOf);
                        if (hashSet.add(substring)) {
                            c5718d2.zZs.mo11619tf(substring);
                        }
                    }
                    InputStream dMu;
                    try {
                        dMu = c5712a.dMu();
                        try {
                            OutputStream L = c5718d2.zZs.mo11607L(str, false);
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
                                    C0926b.m2103e("MicroMsg.VFSFileOp", "Cannot copy " + c5712a.zYK + ": " + e.getMessage());
                                    if (dMu != null) {
                                    }
                                    if (outputStream != null) {
                                    }
                                    AppMethodBeat.m2505o(54652);
                                    return false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (dMu != null) {
                                    }
                                    if (outputStream != null) {
                                    }
                                    AppMethodBeat.m2505o(54652);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                outputStream = L;
                                if (dMu != null) {
                                }
                                if (outputStream != null) {
                                }
                                AppMethodBeat.m2505o(54652);
                                throw th;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            outputStream = null;
                            C0926b.m2103e("MicroMsg.VFSFileOp", "Cannot copy " + c5712a.zYK + ": " + e.getMessage());
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
                            AppMethodBeat.m2505o(54652);
                            return false;
                        } catch (Throwable th4) {
                            th = th4;
                            outputStream = null;
                            if (dMu != null) {
                            }
                            if (outputStream != null) {
                            }
                            AppMethodBeat.m2505o(54652);
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
                        AppMethodBeat.m2505o(54652);
                        throw th;
                    }
                } else if (hashSet.add(str)) {
                    c5718d2.zZs.mo11619tf(str);
                }
            }
            AppMethodBeat.m2505o(54652);
            return true;
        }
        AppMethodBeat.m2505o(54652);
        return false;
    }

    /* renamed from: it */
    public static boolean m8635it(String str, String str2) {
        AppMethodBeat.m2504i(54653);
        C5718d a = FileSystemManager.dMy().mo11633a(C5736j.parseUri(str), null);
        C5718d a2 = FileSystemManager.dMy().mo11633a(C5736j.parseUri(str2), null);
        if (a.valid() && a.zZs == a2.zZs && (a.zZs.aiR() & 32) != 0 && a.zZs.mo11612aS(str, str2)) {
            AppMethodBeat.m2505o(54653);
            return true;
        } else if (C5730e.m8622a(a, a2) && C5730e.m8618N(str, false)) {
            AppMethodBeat.m2505o(54653);
            return true;
        } else {
            AppMethodBeat.m2505o(54653);
            return false;
        }
    }

    /* renamed from: cu */
    public static boolean m8629cu(String str) {
        AppMethodBeat.m2504i(138988);
        boolean N = C5730e.m8618N(str, true);
        AppMethodBeat.m2505o(138988);
        return N;
    }

    /* renamed from: N */
    public static boolean m8618N(String str, boolean z) {
        AppMethodBeat.m2504i(54655);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(54655);
            return false;
        }
        C5718d a = FileSystemManager.dMy().mo11633a(C5736j.parseUri(str), null);
        if (a.valid()) {
            boolean N = a.zZs.mo11609N(a.path, z);
            AppMethodBeat.m2505o(54655);
            return N;
        }
        AppMethodBeat.m2505o(54655);
        return false;
    }

    public static boolean atc(String str) {
        AppMethodBeat.m2504i(54656);
        try {
            C5728b c5728b = new C5728b(str);
            if (c5728b.exists() || c5728b.createNewFile()) {
                AppMethodBeat.m2505o(54656);
                return true;
            }
            AppMethodBeat.m2505o(54656);
            return false;
        } catch (IOException e) {
            AppMethodBeat.m2505o(54656);
            return false;
        }
    }

    /* renamed from: cv */
    public static String m8630cv(String str) {
        AppMethodBeat.m2504i(54657);
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = "";
            AppMethodBeat.m2505o(54657);
            return str2;
        }
        str2 = new C5728b(str).getName();
        int lastIndexOf = str2.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf == str2.length() - 1) {
            str2 = "";
            AppMethodBeat.m2505o(54657);
            return str2;
        }
        str2 = str2.substring(lastIndexOf + 1);
        AppMethodBeat.m2505o(54657);
        return str2;
    }

    public static final String atd(String str) {
        AppMethodBeat.m2504i(54658);
        if (str == null || str.length() <= 0) {
            str = "";
            AppMethodBeat.m2505o(54658);
            return str;
        }
        String name = new C5728b(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            AppMethodBeat.m2505o(54658);
            return str;
        } else if (lastIndexOf == 0) {
            str = "";
            AppMethodBeat.m2505o(54658);
            return str;
        } else {
            str = name.substring(0, lastIndexOf);
            AppMethodBeat.m2505o(54658);
            return str;
        }
    }

    public static void ate(String str) {
        AppMethodBeat.m2504i(54659);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(54659);
            return;
        }
        C5718d a = FileSystemManager.dMy().mo11633a(C5736j.parseUri(str), null);
        if (!a.valid()) {
            AppMethodBeat.m2505o(54659);
        } else if ((a.zZs.aiR() & 4) == 0) {
            AppMethodBeat.m2505o(54659);
        } else if (a.zZs.mo11610O(a.path, true) == null) {
            AppMethodBeat.m2505o(54659);
        } else {
            try {
                a.zZs.mo11607L(a.path + "/.nomedia", false).close();
                AppMethodBeat.m2505o(54659);
            } catch (IOException e) {
                AppMethodBeat.m2505o(54659);
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
        AppMethodBeat.m2504i(54660);
        if (str == null) {
            AppMethodBeat.m2505o(54660);
        } else {
            try {
                openRead = C5730e.openRead(str);
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
                    AppMethodBeat.m2505o(54660);
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
                    AppMethodBeat.m2505o(54660);
                    throw th;
                }
            } catch (Exception e4) {
                openRead = bArr;
            } catch (Throwable th3) {
                th = th3;
                inputStream = bArr;
                if (inputStream != null) {
                }
                AppMethodBeat.m2505o(54660);
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
        AppMethodBeat.m2505o(54660);
        return bArr;
        AppMethodBeat.m2505o(54660);
        return bArr;
    }

    public static String atg(String str) {
        AppMethodBeat.m2504i(54661);
        byte[] atf = C5730e.atf(str);
        if (atf == null) {
            AppMethodBeat.m2505o(54661);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        for (byte b : atf) {
            stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(54661);
        return stringBuilder2;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0061=Splitter:B:15:0x0061, B:28:0x00a5=Splitter:B:28:0x00a5} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006c A:{SYNTHETIC, Splitter:B:18:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b0 A:{SYNTHETIC, Splitter:B:31:0x00b0} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c0 A:{SYNTHETIC, Splitter:B:39:0x00c0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: iu */
    public static int m8636iu(String str, String str2) {
        Throwable e;
        AppMethodBeat.m2504i(54662);
        ZipInputStream zipInputStream;
        try {
            zipInputStream = new ZipInputStream(C5730e.openRead(str));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!(name.contains("../") || name.contains("..\\"))) {
                            if (nextEntry.isDirectory()) {
                                new C5728b(str2 + "/" + name.substring(0, name.length() - 1)).mkdirs();
                            } else {
                                OutputStream q = C5730e.m8641q(new C5728b(str2 + "/" + name));
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
                            C0926b.m2103e("MicroMsg.VFSFileOp", "close zip stream failed.");
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    try {
                        C0926b.m2100c("MicroMsg.VFSFileOp", e, "");
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                            } catch (IOException e4) {
                                C0926b.m2103e("MicroMsg.VFSFileOp", "close zip stream failed.");
                            }
                        }
                        AppMethodBeat.m2505o(54662);
                        return -1;
                    } catch (Throwable th) {
                        e = th;
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                            } catch (IOException e5) {
                                C0926b.m2103e("MicroMsg.VFSFileOp", "close zip stream failed.");
                            }
                        }
                        AppMethodBeat.m2505o(54662);
                        throw e;
                    }
                } catch (IOException e6) {
                    e = e6;
                    C0926b.m2100c("MicroMsg.VFSFileOp", e, "");
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                        } catch (IOException e7) {
                            C0926b.m2103e("MicroMsg.VFSFileOp", "close zip stream failed.");
                        }
                    }
                    AppMethodBeat.m2505o(54662);
                    return -2;
                }
            }
            zipInputStream.close();
            AppMethodBeat.m2505o(54662);
            return 0;
        } catch (FileNotFoundException e8) {
            e = e8;
            zipInputStream = null;
            C0926b.m2100c("MicroMsg.VFSFileOp", e, "");
            if (zipInputStream != null) {
            }
            AppMethodBeat.m2505o(54662);
            return -1;
        } catch (IOException e9) {
            e = e9;
            zipInputStream = null;
            C0926b.m2100c("MicroMsg.VFSFileOp", e, "");
            if (zipInputStream != null) {
            }
            AppMethodBeat.m2505o(54662);
            return -2;
        } catch (Throwable th2) {
            e = th2;
            zipInputStream = null;
            if (zipInputStream != null) {
            }
            AppMethodBeat.m2505o(54662);
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
    /* renamed from: m */
    public static boolean m8637m(List<String> list, String str) {
        Throwable e;
        ZipOutputStream zipOutputStream;
        AppMethodBeat.m2504i(54663);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(54663);
            return false;
        }
        C5730e.m8643tf(C5730e.atb(str));
        byte[] bArr = new byte[4096];
        ZipOutputStream zipOutputStream2;
        InputStream dMu;
        try {
            zipOutputStream2 = new ZipOutputStream(C5730e.m8617L(str, false));
            try {
                for (String parseUri : list) {
                    C5718d a = FileSystemManager.dMy().mo11633a(C5736j.parseUri(parseUri), null);
                    if (a.valid()) {
                        C5712a to = a.zZs.mo11621to(a.path);
                        if (to != null) {
                            int length;
                            int i;
                            List M;
                            if (to.zYN) {
                                length = (a.path.endsWith("/") ? 0 : 1) + a.path.length();
                                M = a.zZs.mo11608M(a.path, true);
                                if (M != null) {
                                    i = length;
                                }
                            } else {
                                length = a.path.lastIndexOf(47) + 1;
                                M = Collections.singletonList(to);
                                i = length;
                            }
                            for (C5712a c5712a : M) {
                                if (!c5712a.zYN) {
                                    String str2;
                                    if (c5712a.zYK.length() < i) {
                                        str2 = c5712a.name;
                                    } else {
                                        str2 = c5712a.zYK.substring(i);
                                    }
                                    dMu = c5712a.dMu();
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
                                            C0926b.m2100c("MicroMsg.VFSFileOp", e, "Failed to write ZipFile");
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
                                            AppMethodBeat.m2505o(54663);
                                            return false;
                                        } catch (Throwable th) {
                                            e = th;
                                            zipOutputStream2 = zipOutputStream;
                                            if (dMu != null) {
                                            }
                                            if (zipOutputStream2 != null) {
                                            }
                                            AppMethodBeat.m2505o(54663);
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
                                        AppMethodBeat.m2505o(54663);
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
                AppMethodBeat.m2505o(54663);
                return true;
            } catch (IOException e8) {
                e = e8;
                zipOutputStream = zipOutputStream2;
                dMu = null;
                C0926b.m2100c("MicroMsg.VFSFileOp", e, "Failed to write ZipFile");
                if (dMu != null) {
                }
                if (zipOutputStream != null) {
                }
                AppMethodBeat.m2505o(54663);
                return false;
            } catch (Throwable th3) {
                e = th3;
                dMu = null;
                if (dMu != null) {
                }
                if (zipOutputStream2 != null) {
                }
                AppMethodBeat.m2505o(54663);
                throw e;
            }
        } catch (IOException e9) {
            e = e9;
            zipOutputStream = null;
            dMu = null;
            C0926b.m2100c("MicroMsg.VFSFileOp", e, "Failed to write ZipFile");
            if (dMu != null) {
            }
            if (zipOutputStream != null) {
            }
            AppMethodBeat.m2505o(54663);
            return false;
        } catch (Throwable th4) {
            e = th4;
            zipOutputStream2 = null;
            dMu = null;
            if (dMu != null) {
            }
            if (zipOutputStream2 != null) {
            }
            AppMethodBeat.m2505o(54663);
            throw e;
        }
    }

    /* renamed from: p */
    public static InputStream m8638p(C5728b c5728b) {
        AppMethodBeat.m2504i(54626);
        InputStream b = C5730e.m8625b(c5728b.mUri, c5728b.dMA());
        AppMethodBeat.m2505o(54626);
        return b;
    }

    /* renamed from: q */
    public static OutputStream m8641q(C5728b c5728b) {
        AppMethodBeat.m2504i(54629);
        OutputStream a = C5730e.m8620a(c5728b.mUri, c5728b.dMA(), false);
        AppMethodBeat.m2505o(54629);
        return a;
    }

    /* renamed from: r */
    public static OutputStream m8642r(C5728b c5728b) {
        AppMethodBeat.m2504i(54631);
        OutputStream a = C5730e.m8620a(c5728b.mUri, c5728b.dMA(), false);
        AppMethodBeat.m2505o(54631);
        return a;
    }
}
