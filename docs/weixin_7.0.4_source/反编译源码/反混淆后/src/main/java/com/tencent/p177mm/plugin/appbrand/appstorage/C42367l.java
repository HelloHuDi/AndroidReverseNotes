package com.tencent.p177mm.plugin.appbrand.appstorage;

import com.tencent.luggage.p147g.C37399a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.l */
public final class C42367l {
    /* renamed from: C */
    public static long m74939C(File file) {
        long j = 0;
        AppMethodBeat.m2504i(105366);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            AppMethodBeat.m2505o(105366);
        } else {
            for (File file2 : listFiles) {
                long length;
                if (file2.isFile()) {
                    length = file2.length();
                } else {
                    length = C42367l.m74939C(file2);
                }
                j += length;
            }
            AppMethodBeat.m2505o(105366);
        }
        return j;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0070=Splitter:B:30:0x0070, B:21:0x004a=Splitter:B:21:0x004a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: D */
    static ByteBuffer m74940D(File file) {
        Throwable e;
        Throwable th;
        AppMethodBeat.m2504i(105367);
        ByteBuffer allocateDirect;
        if (file != null && file.exists() && file.isFile()) {
            int length = (int) file.length();
            if (length < 0) {
                allocateDirect = ByteBuffer.allocateDirect(0);
                AppMethodBeat.m2505o(105367);
                return allocateDirect;
            }
            allocateDirect = ByteBuffer.allocateDirect(length);
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 4096);
                        if (read != -1) {
                            allocateDirect.put(bArr, 0, read);
                        } else {
                            allocateDirect.flip();
                            C5046bo.m7527b(fileInputStream);
                            AppMethodBeat.m2505o(105367);
                            return allocateDirect;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e, "readAsDirectByteBuffer", new Object[0]);
                        C37399a.m63003j(allocateDirect);
                        C5046bo.m7527b(fileInputStream);
                        allocateDirect = ByteBuffer.allocateDirect(0);
                        AppMethodBeat.m2505o(105367);
                        return allocateDirect;
                    } catch (Throwable th2) {
                        th = th2;
                        C5046bo.m7527b(fileInputStream);
                        AppMethodBeat.m2505o(105367);
                        throw th;
                    }
                } catch (BufferOverflowException e3) {
                    C4990ab.m7413e("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "BufferOverflow, file_length %d, byte_allocated %d", Long.valueOf(file.length()), Integer.valueOf(allocateDirect.capacity()));
                    C37399a.m63003j(allocateDirect);
                    C5046bo.m7527b(fileInputStream);
                    allocateDirect = ByteBuffer.allocateDirect(0);
                    AppMethodBeat.m2505o(105367);
                    return allocateDirect;
                }
            } catch (IOException e4) {
                e = e4;
                fileInputStream = null;
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e, "readAsDirectByteBuffer", new Object[0]);
                C37399a.m63003j(allocateDirect);
                C5046bo.m7527b(fileInputStream);
                allocateDirect = ByteBuffer.allocateDirect(0);
                AppMethodBeat.m2505o(105367);
                return allocateDirect;
            } catch (BufferOverflowException e5) {
                fileInputStream = null;
                C4990ab.m7413e("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "BufferOverflow, file_length %d, byte_allocated %d", Long.valueOf(file.length()), Integer.valueOf(allocateDirect.capacity()));
                C37399a.m63003j(allocateDirect);
                C5046bo.m7527b(fileInputStream);
                allocateDirect = ByteBuffer.allocateDirect(0);
                AppMethodBeat.m2505o(105367);
                return allocateDirect;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                C5046bo.m7527b(fileInputStream);
                AppMethodBeat.m2505o(105367);
                throw th;
            }
        }
        allocateDirect = ByteBuffer.allocateDirect(0);
        AppMethodBeat.m2505o(105367);
        return allocateDirect;
    }

    /* renamed from: a */
    public static int m74943a(ZipInputStream zipInputStream, String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(105368);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (!(name.contains("../") || name.contains("..\\"))) {
                        if (nextEntry.isDirectory()) {
                            new File(str + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                        } else {
                            File file = new File(str + File.separator + name);
                            file.getParentFile().mkdirs();
                            file.createNewFile();
                            Closeable fileOutputStream;
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                while (true) {
                                    try {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                        fileOutputStream.flush();
                                    } catch (Exception e2) {
                                        e = e2;
                                        try {
                                            AppMethodBeat.m2505o(105368);
                                            throw e;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            C5046bo.m7527b(fileOutputStream);
                                            AppMethodBeat.m2505o(105368);
                                            throw th;
                                        }
                                    }
                                }
                                C5046bo.m7527b(fileOutputStream);
                            } catch (Exception e3) {
                                e = e3;
                                fileOutputStream = null;
                                AppMethodBeat.m2505o(105368);
                                throw e;
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                                C5046bo.m7527b(fileOutputStream);
                                AppMethodBeat.m2505o(105368);
                                throw th;
                            }
                        }
                    }
                }
                C5046bo.m7527b(zipInputStream);
                AppMethodBeat.m2505o(105368);
                return 0;
            }
        } catch (FileNotFoundException e4) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e4, "unzipBytes", new Object[0]);
            C5046bo.m7527b(zipInputStream);
            AppMethodBeat.m2505o(105368);
            return -1;
        } catch (IOException e5) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e5, "unzipBytes", new Object[0]);
            C5046bo.m7527b(zipInputStream);
            AppMethodBeat.m2505o(105368);
            return -2;
        } catch (OutOfMemoryError e6) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e6, "unzipBytes", new Object[0]);
            C5046bo.m7527b(zipInputStream);
            AppMethodBeat.m2505o(105368);
            return -3;
        } catch (Throwable th4) {
            C5046bo.m7527b(zipInputStream);
            AppMethodBeat.m2505o(105368);
        }
    }

    /* renamed from: a */
    static void m74944a(File file, FileFilter fileFilter) {
        AppMethodBeat.m2504i(105369);
        File[] listFiles = file.listFiles(fileFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    C42367l.m74944a(file2, fileFilter);
                }
            }
        }
        AppMethodBeat.m2505o(105369);
    }

    /* renamed from: E */
    static void m74941E(File file) {
        AppMethodBeat.m2504i(105370);
        if (file == null || !file.isDirectory()) {
            AppMethodBeat.m2505o(105370);
            return;
        }
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        C42367l.m74941E(file2);
                    }
                    file2.delete();
                }
            }
            file.delete();
        }
        AppMethodBeat.m2505o(105370);
    }

    /* renamed from: F */
    public static boolean m74942F(File file) {
        AppMethodBeat.m2504i(105371);
        if (file == null) {
            NullPointerException nullPointerException = new NullPointerException("file should not be NULL");
            AppMethodBeat.m2505o(105371);
            throw nullPointerException;
        } else if (file.exists()) {
            try {
                C42366k c42366k = new C42366k();
                if (FileStat.stat(file.getAbsolutePath(), c42366k) == 0) {
                    C4990ab.m7417i("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "constainsSymLink, path %s, stat.st_mode %d", file.getAbsolutePath(), Integer.valueOf(c42366k.st_mode));
                    if ((c42366k.st_mode & 61440) == 40960) {
                        AppMethodBeat.m2505o(105371);
                        return true;
                    }
                    AppMethodBeat.m2505o(105371);
                    return false;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(105371);
            return false;
        } else {
            AppMethodBeat.m2505o(105371);
            return false;
        }
    }

    /* renamed from: yj */
    public static String m74945yj(String str) {
        AppMethodBeat.m2504i(105372);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(105372);
            return str;
        }
        int i = 0;
        while (i < str.length() && IOUtils.DIR_SEPARATOR_UNIX == str.charAt(i)) {
            i++;
        }
        str = str.substring(i);
        AppMethodBeat.m2505o(105372);
        return str;
    }

    /* renamed from: yk */
    public static String m74946yk(String str) {
        int i = 0;
        AppMethodBeat.m2504i(105373);
        C4990ab.m7411d("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "eliminateDuplicateSlashForPkgFile, original file name = [%s]", str);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(105373);
            return str2;
        }
        String trim = str.trim();
        if (trim.startsWith("/")) {
            while (i < trim.length() && IOUtils.DIR_SEPARATOR_UNIX == trim.charAt(i)) {
                i++;
            }
            str2 = "/" + trim.substring(i);
            AppMethodBeat.m2505o(105373);
            return str2;
        }
        str2 = "/".concat(String.valueOf(trim));
        AppMethodBeat.m2505o(105373);
        return str2;
    }
}
