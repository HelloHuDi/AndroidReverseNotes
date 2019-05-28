package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class l {
    public static long C(File file) {
        long j = 0;
        AppMethodBeat.i(105366);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            AppMethodBeat.o(105366);
        } else {
            for (File file2 : listFiles) {
                long length;
                if (file2.isFile()) {
                    length = file2.length();
                } else {
                    length = C(file2);
                }
                j += length;
            }
            AppMethodBeat.o(105366);
        }
        return j;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0070=Splitter:B:30:0x0070, B:21:0x004a=Splitter:B:21:0x004a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static ByteBuffer D(File file) {
        Throwable e;
        Throwable th;
        AppMethodBeat.i(105367);
        ByteBuffer allocateDirect;
        if (file != null && file.exists() && file.isFile()) {
            int length = (int) file.length();
            if (length < 0) {
                allocateDirect = ByteBuffer.allocateDirect(0);
                AppMethodBeat.o(105367);
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
                            bo.b(fileInputStream);
                            AppMethodBeat.o(105367);
                            return allocateDirect;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        ab.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e, "readAsDirectByteBuffer", new Object[0]);
                        a.j(allocateDirect);
                        bo.b(fileInputStream);
                        allocateDirect = ByteBuffer.allocateDirect(0);
                        AppMethodBeat.o(105367);
                        return allocateDirect;
                    } catch (Throwable th2) {
                        th = th2;
                        bo.b(fileInputStream);
                        AppMethodBeat.o(105367);
                        throw th;
                    }
                } catch (BufferOverflowException e3) {
                    ab.e("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "BufferOverflow, file_length %d, byte_allocated %d", Long.valueOf(file.length()), Integer.valueOf(allocateDirect.capacity()));
                    a.j(allocateDirect);
                    bo.b(fileInputStream);
                    allocateDirect = ByteBuffer.allocateDirect(0);
                    AppMethodBeat.o(105367);
                    return allocateDirect;
                }
            } catch (IOException e4) {
                e = e4;
                fileInputStream = null;
                ab.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e, "readAsDirectByteBuffer", new Object[0]);
                a.j(allocateDirect);
                bo.b(fileInputStream);
                allocateDirect = ByteBuffer.allocateDirect(0);
                AppMethodBeat.o(105367);
                return allocateDirect;
            } catch (BufferOverflowException e5) {
                fileInputStream = null;
                ab.e("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "BufferOverflow, file_length %d, byte_allocated %d", Long.valueOf(file.length()), Integer.valueOf(allocateDirect.capacity()));
                a.j(allocateDirect);
                bo.b(fileInputStream);
                allocateDirect = ByteBuffer.allocateDirect(0);
                AppMethodBeat.o(105367);
                return allocateDirect;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                bo.b(fileInputStream);
                AppMethodBeat.o(105367);
                throw th;
            }
        }
        allocateDirect = ByteBuffer.allocateDirect(0);
        AppMethodBeat.o(105367);
        return allocateDirect;
    }

    public static int a(ZipInputStream zipInputStream, String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(105368);
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
                                            AppMethodBeat.o(105368);
                                            throw e;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            bo.b(fileOutputStream);
                                            AppMethodBeat.o(105368);
                                            throw th;
                                        }
                                    }
                                }
                                bo.b(fileOutputStream);
                            } catch (Exception e3) {
                                e = e3;
                                fileOutputStream = null;
                                AppMethodBeat.o(105368);
                                throw e;
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                                bo.b(fileOutputStream);
                                AppMethodBeat.o(105368);
                                throw th;
                            }
                        }
                    }
                }
                bo.b(zipInputStream);
                AppMethodBeat.o(105368);
                return 0;
            }
        } catch (FileNotFoundException e4) {
            ab.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e4, "unzipBytes", new Object[0]);
            bo.b(zipInputStream);
            AppMethodBeat.o(105368);
            return -1;
        } catch (IOException e5) {
            ab.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e5, "unzipBytes", new Object[0]);
            bo.b(zipInputStream);
            AppMethodBeat.o(105368);
            return -2;
        } catch (OutOfMemoryError e6) {
            ab.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e6, "unzipBytes", new Object[0]);
            bo.b(zipInputStream);
            AppMethodBeat.o(105368);
            return -3;
        } catch (Throwable th4) {
            bo.b(zipInputStream);
            AppMethodBeat.o(105368);
        }
    }

    static void a(File file, FileFilter fileFilter) {
        AppMethodBeat.i(105369);
        File[] listFiles = file.listFiles(fileFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2, fileFilter);
                }
            }
        }
        AppMethodBeat.o(105369);
    }

    static void E(File file) {
        AppMethodBeat.i(105370);
        if (file == null || !file.isDirectory()) {
            AppMethodBeat.o(105370);
            return;
        }
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        E(file2);
                    }
                    file2.delete();
                }
            }
            file.delete();
        }
        AppMethodBeat.o(105370);
    }

    public static boolean F(File file) {
        AppMethodBeat.i(105371);
        if (file == null) {
            NullPointerException nullPointerException = new NullPointerException("file should not be NULL");
            AppMethodBeat.o(105371);
            throw nullPointerException;
        } else if (file.exists()) {
            try {
                k kVar = new k();
                if (FileStat.stat(file.getAbsolutePath(), kVar) == 0) {
                    ab.i("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "constainsSymLink, path %s, stat.st_mode %d", file.getAbsolutePath(), Integer.valueOf(kVar.st_mode));
                    if ((kVar.st_mode & 61440) == 40960) {
                        AppMethodBeat.o(105371);
                        return true;
                    }
                    AppMethodBeat.o(105371);
                    return false;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e, "", new Object[0]);
            }
            AppMethodBeat.o(105371);
            return false;
        } else {
            AppMethodBeat.o(105371);
            return false;
        }
    }

    public static String yj(String str) {
        AppMethodBeat.i(105372);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(105372);
            return str;
        }
        int i = 0;
        while (i < str.length() && IOUtils.DIR_SEPARATOR_UNIX == str.charAt(i)) {
            i++;
        }
        str = str.substring(i);
        AppMethodBeat.o(105372);
        return str;
    }

    public static String yk(String str) {
        int i = 0;
        AppMethodBeat.i(105373);
        ab.d("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "eliminateDuplicateSlashForPkgFile, original file name = [%s]", str);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(105373);
            return str2;
        }
        String trim = str.trim();
        if (trim.startsWith("/")) {
            while (i < trim.length() && IOUtils.DIR_SEPARATOR_UNIX == trim.charAt(i)) {
                i++;
            }
            str2 = "/" + trim.substring(i);
            AppMethodBeat.o(105373);
            return str2;
        }
        str2 = "/".concat(String.valueOf(trim));
        AppMethodBeat.o(105373);
        return str2;
    }
}
