package com.tencent.ttpic.baseutils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    private static final String TAG = ZipUtils.class.getSimpleName();

    static {
        AppMethodBeat.m2504i(49799);
        AppMethodBeat.m2505o(49799);
    }

    public static boolean zip(File file, File file2) {
        AppMethodBeat.m2504i(49795);
        boolean zip = zip(new File[]{file}, file2);
        AppMethodBeat.m2505o(49795);
        return zip;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0042 A:{SYNTHETIC, Splitter:B:21:0x0042} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b A:{SYNTHETIC, Splitter:B:26:0x004b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zip(File[] fileArr, File file) {
        Throwable th;
        ZipOutputStream zipOutputStream = null;
        boolean z = false;
        AppMethodBeat.m2504i(49796);
        if (fileArr == null || fileArr.length <= 0 || file == null) {
            AppMethodBeat.m2505o(49796);
        } else {
            ZipOutputStream zipOutputStream2;
            try {
                byte[] bArr = new byte[4096];
                zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file, false)));
                try {
                    for (File doZip : fileArr) {
                        doZip(zipOutputStream2, doZip, null, bArr);
                    }
                    zipOutputStream2.flush();
                    zipOutputStream2.closeEntry();
                    z = true;
                    try {
                        zipOutputStream2.close();
                    } catch (IOException e) {
                    }
                } catch (IOException e2) {
                    if (zipOutputStream2 != null) {
                    }
                    AppMethodBeat.m2505o(49796);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    zipOutputStream = zipOutputStream2;
                    if (zipOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(49796);
                    throw th;
                }
            } catch (IOException e3) {
                zipOutputStream2 = null;
                if (zipOutputStream2 != null) {
                    try {
                        zipOutputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.m2505o(49796);
                return z;
            } catch (Throwable th3) {
                th = th3;
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e5) {
                    }
                }
                AppMethodBeat.m2505o(49796);
                throw th;
            }
            AppMethodBeat.m2505o(49796);
        }
        return z;
    }

    private static void doZip(ZipOutputStream zipOutputStream, File file, String str, byte[] bArr) {
        AppMethodBeat.m2504i(49797);
        IOException iOException;
        if (zipOutputStream == null || file == null) {
            iOException = new IOException("I/O Object got NullPointerException");
            AppMethodBeat.m2505o(49797);
            throw iOException;
        } else if (file.exists()) {
            String name;
            if (TextUtils.isEmpty(str)) {
                name = file.getName();
            } else {
                name = str + File.separator + file.getName();
            }
            if (file.isFile()) {
                BufferedInputStream bufferedInputStream;
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(name));
                        while (true) {
                            int read = bufferedInputStream.read(bArr, 0, bArr.length);
                            if (-1 != read) {
                                zipOutputStream.write(bArr, 0, read);
                            } else {
                                try {
                                    bufferedInputStream.close();
                                    AppMethodBeat.m2505o(49797);
                                    return;
                                } catch (IOException e) {
                                    AppMethodBeat.m2505o(49797);
                                    return;
                                }
                            }
                        }
                    } catch (IOException e2) {
                        iOException = e2;
                    }
                } catch (IOException e3) {
                    iOException = e3;
                    bufferedInputStream = null;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    AppMethodBeat.m2505o(49797);
                    throw iOException;
                }
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File doZip : listFiles) {
                        doZip(zipOutputStream, doZip, name, bArr);
                    }
                }
            }
            AppMethodBeat.m2505o(49797);
        } else {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Target File is missing");
            AppMethodBeat.m2505o(49797);
            throw fileNotFoundException;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0107 A:{SYNTHETIC, Splitter:B:49:0x0107} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x010c A:{Catch:{ IOException -> 0x0128, all -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0133 A:{SYNTHETIC, Splitter:B:67:0x0133} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0138 A:{Catch:{ IOException -> 0x0160, all -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x014c A:{SYNTHETIC, Splitter:B:80:0x014c} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0151 A:{Catch:{ IOException -> 0x0183 }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0168 A:{SYNTHETIC, Splitter:B:96:0x0168} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x016d A:{Catch:{ IOException -> 0x0189 }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0168 A:{SYNTHETIC, Splitter:B:96:0x0168} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x016d A:{Catch:{ IOException -> 0x0189 }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0133 A:{SYNTHETIC, Splitter:B:67:0x0133} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0138 A:{Catch:{ IOException -> 0x0160, all -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0165 A:{Splitter:B:22:0x004c, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0168 A:{SYNTHETIC, Splitter:B:96:0x0168} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x016d A:{Catch:{ IOException -> 0x0189 }} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0165 A:{Splitter:B:22:0x004c, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0165 A:{Splitter:B:22:0x004c, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0107 A:{SYNTHETIC, Splitter:B:49:0x0107} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x010c A:{Catch:{ IOException -> 0x0128, all -> 0x0165 }} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:59:0x0120, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:61:?, code skipped:
            com.tencent.ttpic.baseutils.LogUtils.m50206e(r1);
            r3 = r2;
            r5 = r4;
     */
    /* JADX WARNING: Missing block: B:62:0x0128, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:63:0x0129, code skipped:
            com.tencent.ttpic.baseutils.LogUtils.m50206e(r1);
     */
    /* JADX WARNING: Missing block: B:64:0x012c, code skipped:
            r3 = r2;
            r5 = r4;
     */
    /* JADX WARNING: Missing block: B:75:0x0142, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:76:0x0143, code skipped:
            r2 = r1;
            r3 = r6;
            r4 = r7;
            r5 = r0;
     */
    /* JADX WARNING: Missing block: B:94:0x0165, code skipped:
            r0 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized String unZip(String str, String str2) {
        String str3;
        Throwable e;
        Throwable th;
        Throwable e2;
        ZipInputStream zipInputStream;
        FileInputStream fileInputStream;
        String str4;
        synchronized (ZipUtils.class) {
            AppMethodBeat.m2504i(49798);
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.m2505o(49798);
                str3 = null;
            } else {
                File file = new File(str);
                if (file.exists()) {
                    File file2 = new File(str2);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    FileInputStream fileInputStream2;
                    ZipInputStream zipInputStream2;
                    try {
                        fileInputStream2 = new FileInputStream(file);
                        try {
                            zipInputStream2 = new ZipInputStream(new BufferedInputStream(fileInputStream2));
                            BufferedOutputStream bufferedOutputStream = null;
                            FileOutputStream fileOutputStream = null;
                            str3 = null;
                            while (true) {
                                try {
                                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                                    if (nextEntry != null) {
                                        LogUtils.m50199d(TAG, "unZip entry = ".concat(String.valueOf(nextEntry)));
                                        String name = nextEntry.getName();
                                        if (!name.contains("../")) {
                                            if (nextEntry.isDirectory()) {
                                                String str5 = str2 + File.separator + name;
                                                LogUtils.m50199d(TAG, "unZip entry is folder, path = ".concat(String.valueOf(str5)));
                                                file2 = new File(str5);
                                                if (!file2.exists()) {
                                                    file2.mkdirs();
                                                }
                                                FileUtils.deleteFiles(str5, null);
                                                if (TextUtils.isEmpty(str3)) {
                                                    str3 = file2.getPath();
                                                }
                                            } else {
                                                byte[] bArr = new byte[4096];
                                                name = str2 + File.separator + name;
                                                LogUtils.m50199d(TAG, "unZip entry is file, path = ".concat(String.valueOf(name)));
                                                FileOutputStream fileOutputStream2;
                                                BufferedOutputStream bufferedOutputStream2;
                                                try {
                                                    fileOutputStream2 = new FileOutputStream(new File(name));
                                                    try {
                                                        bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream2, 4096);
                                                        while (true) {
                                                            try {
                                                                int read = zipInputStream2.read(bArr);
                                                                if (read == -1) {
                                                                    break;
                                                                }
                                                                bufferedOutputStream2.write(bArr, 0, read);
                                                            } catch (IOException e3) {
                                                                e = e3;
                                                                try {
                                                                    LogUtils.m50206e(e);
                                                                    if (bufferedOutputStream2 != null) {
                                                                    }
                                                                    if (fileOutputStream2 != null) {
                                                                    }
                                                                    bufferedOutputStream = bufferedOutputStream2;
                                                                    fileOutputStream = fileOutputStream2;
                                                                } catch (Throwable th2) {
                                                                    e = th2;
                                                                    if (bufferedOutputStream2 != null) {
                                                                    }
                                                                    if (fileOutputStream2 != null) {
                                                                    }
                                                                    AppMethodBeat.m2505o(49798);
                                                                    throw e;
                                                                }
                                                            }
                                                        }
                                                        bufferedOutputStream2.flush();
                                                        bufferedOutputStream2.close();
                                                        fileOutputStream2.close();
                                                        bufferedOutputStream = bufferedOutputStream2;
                                                        fileOutputStream = fileOutputStream2;
                                                    } catch (IOException e4) {
                                                        e = e4;
                                                        bufferedOutputStream2 = bufferedOutputStream;
                                                        LogUtils.m50206e(e);
                                                        if (bufferedOutputStream2 != null) {
                                                        }
                                                        if (fileOutputStream2 != null) {
                                                        }
                                                        bufferedOutputStream = bufferedOutputStream2;
                                                        fileOutputStream = fileOutputStream2;
                                                    } catch (Throwable th3) {
                                                        e = th3;
                                                        bufferedOutputStream2 = bufferedOutputStream;
                                                        if (bufferedOutputStream2 != null) {
                                                        }
                                                        if (fileOutputStream2 != null) {
                                                        }
                                                        AppMethodBeat.m2505o(49798);
                                                        throw e;
                                                    }
                                                } catch (IOException e5) {
                                                    e = e5;
                                                    bufferedOutputStream2 = bufferedOutputStream;
                                                    fileOutputStream2 = fileOutputStream;
                                                    LogUtils.m50206e(e);
                                                    if (bufferedOutputStream2 != null) {
                                                        bufferedOutputStream2.close();
                                                    }
                                                    if (fileOutputStream2 != null) {
                                                        fileOutputStream2.close();
                                                    }
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    fileOutputStream = fileOutputStream2;
                                                } catch (Throwable th4) {
                                                    e = th4;
                                                    bufferedOutputStream2 = bufferedOutputStream;
                                                    fileOutputStream2 = fileOutputStream;
                                                    if (bufferedOutputStream2 != null) {
                                                        bufferedOutputStream2.close();
                                                    }
                                                    if (fileOutputStream2 != null) {
                                                        fileOutputStream2.close();
                                                    }
                                                    AppMethodBeat.m2505o(49798);
                                                    throw e;
                                                }
                                            }
                                        }
                                    } else {
                                        try {
                                            break;
                                        } catch (IOException e6) {
                                            LogUtils.m50206e(e6);
                                        }
                                    }
                                } catch (IOException e7) {
                                    LogUtils.m50206e(e7);
                                    AppMethodBeat.m2505o(49798);
                                    throw e;
                                } catch (Throwable th5) {
                                }
                            }
                            zipInputStream2.close();
                            fileInputStream2.close();
                        } catch (IOException e22) {
                            th = e22;
                            zipInputStream = null;
                            fileInputStream = fileInputStream2;
                            str4 = null;
                            try {
                                LogUtils.m50206e(th);
                                if (zipInputStream != null) {
                                    try {
                                        zipInputStream.close();
                                    } catch (IOException e8) {
                                        LogUtils.m50206e(e8);
                                        str3 = str4;
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                str3 = str4;
                                AppMethodBeat.m2505o(49798);
                                return str3;
                            } catch (Throwable th6) {
                                e22 = th6;
                                zipInputStream2 = zipInputStream;
                                fileInputStream2 = fileInputStream;
                                if (zipInputStream2 != null) {
                                }
                                if (fileInputStream2 != null) {
                                }
                                AppMethodBeat.m2505o(49798);
                                throw e22;
                            }
                        } catch (Throwable th7) {
                            e22 = th7;
                            zipInputStream2 = null;
                            if (zipInputStream2 != null) {
                                try {
                                    zipInputStream2.close();
                                } catch (IOException e62) {
                                    LogUtils.m50206e(e62);
                                    AppMethodBeat.m2505o(49798);
                                    throw e22;
                                }
                            }
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            AppMethodBeat.m2505o(49798);
                            throw e22;
                        }
                    } catch (IOException e222) {
                        th = e222;
                        zipInputStream = null;
                        fileInputStream = null;
                        str4 = null;
                        LogUtils.m50206e(th);
                        if (zipInputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        str3 = str4;
                        AppMethodBeat.m2505o(49798);
                        return str3;
                    } catch (Throwable th8) {
                        e222 = th8;
                        zipInputStream2 = null;
                        fileInputStream2 = null;
                        if (zipInputStream2 != null) {
                        }
                        if (fileInputStream2 != null) {
                        }
                        AppMethodBeat.m2505o(49798);
                        throw e222;
                    }
                    AppMethodBeat.m2505o(49798);
                } else {
                    AppMethodBeat.m2505o(49798);
                    str3 = null;
                }
            }
        }
        return str3;
    }
}
