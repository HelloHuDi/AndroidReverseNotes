package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@SuppressLint({"NewApi"})
/* renamed from: com.tencent.smtt.utils.k */
public class C30950k {
    /* renamed from: a */
    public static String f13919a = null;
    /* renamed from: b */
    public static final C5821a f13920b = new C44462m();
    /* renamed from: c */
    private static final int f13921c = 4;
    /* renamed from: d */
    private static RandomAccessFile f13922d = null;

    /* renamed from: com.tencent.smtt.utils.k$a */
    public interface C5821a {
        /* renamed from: a */
        boolean mo12209a(File file, File file2);
    }

    /* renamed from: com.tencent.smtt.utils.k$b */
    public interface C16158b {
        /* renamed from: a */
        boolean mo28983a(InputStream inputStream, ZipEntry zipEntry, String str);
    }

    static {
        AppMethodBeat.m2504i(65253);
        AppMethodBeat.m2505o(65253);
    }

    /* renamed from: a */
    public static File m49544a(Context context, boolean z, String str) {
        AppMethodBeat.m2504i(65244);
        String d = z ? C30950k.m49572d(context) : C30950k.m49569c(context);
        if (d == null) {
            AppMethodBeat.m2505o(65244);
            return null;
        }
        File file = new File(d);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.canWrite()) {
            File file2 = new File(file, str);
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e) {
                    AppMethodBeat.m2505o(65244);
                    return null;
                }
            }
            AppMethodBeat.m2505o(65244);
            return file2;
        }
        AppMethodBeat.m2505o(65244);
        return null;
    }

    /* renamed from: a */
    public static String m49545a(Context context, int i) {
        AppMethodBeat.m2504i(65221);
        String a = C30950k.m49547a(context, context.getApplicationInfo().packageName, i, true);
        AppMethodBeat.m2505o(65221);
        return a;
    }

    /* renamed from: a */
    private static String m49546a(Context context, String str) {
        AppMethodBeat.m2504i(65223);
        String str2 = "";
        if (context == null) {
            AppMethodBeat.m2505o(65223);
            return str2;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        try {
            str2 = context.getExternalFilesDir(str).getAbsolutePath();
        } catch (Throwable th) {
            try {
                str2 = Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + context.getApplicationInfo().packageName + File.separator + "files" + File.separator + str;
            } catch (Exception e) {
                str2 = "";
                AppMethodBeat.m2505o(65223);
                return str2;
            }
        }
        AppMethodBeat.m2505o(65223);
        return str2;
    }

    /* renamed from: a */
    public static String m49547a(Context context, String str, int i, boolean z) {
        AppMethodBeat.m2504i(65222);
        String str2;
        if (context == null) {
            str2 = "";
            AppMethodBeat.m2505o(65222);
            return str2;
        }
        str2 = "";
        try {
            str2 = Environment.getExternalStorageDirectory() + File.separator;
        } catch (Exception e) {
        }
        switch (i) {
            case 1:
                if (str2.equals("")) {
                    AppMethodBeat.m2505o(65222);
                    return str2;
                }
                str2 = str2 + "tencent" + File.separator + "tbs" + File.separator + str;
                AppMethodBeat.m2505o(65222);
                return str2;
            case 2:
                if (str2.equals("")) {
                    AppMethodBeat.m2505o(65222);
                    return str2;
                }
                str2 = str2 + "tbs" + File.separator + "backup" + File.separator + str;
                AppMethodBeat.m2505o(65222);
                return str2;
            case 3:
                if (str2.equals("")) {
                    AppMethodBeat.m2505o(65222);
                    return str2;
                }
                str2 = str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + str;
                AppMethodBeat.m2505o(65222);
                return str2;
            case 4:
                if (str2.equals("")) {
                    str2 = C30950k.m49546a(context, "backup");
                    AppMethodBeat.m2505o(65222);
                    return str2;
                }
                str2 = str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + str;
                if (z) {
                    File file = new File(str2);
                    if (!(file.exists() && file.canWrite())) {
                        if (file.exists()) {
                            str2 = C30950k.m49546a(context, "backup");
                        } else {
                            file.mkdirs();
                            if (!file.canWrite()) {
                                str2 = C30950k.m49546a(context, "backup");
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(65222);
                return str2;
            case 5:
                if (str2.equals("")) {
                    AppMethodBeat.m2505o(65222);
                    return str2;
                }
                str2 = str2 + "tencent" + File.separator + "tbs" + File.separator + str;
                AppMethodBeat.m2505o(65222);
                return str2;
            case 6:
                if (f13919a != null) {
                    str2 = f13919a;
                    AppMethodBeat.m2505o(65222);
                    return str2;
                }
                str2 = C30950k.m49546a(context, "tbslog");
                f13919a = str2;
                AppMethodBeat.m2505o(65222);
                return str2;
            default:
                str2 = "";
                AppMethodBeat.m2505o(65222);
                return str2;
        }
    }

    /* renamed from: a */
    public static FileLock m49548a(Context context, FileOutputStream fileOutputStream) {
        AppMethodBeat.m2504i(65246);
        if (fileOutputStream == null) {
            AppMethodBeat.m2505o(65246);
            return null;
        }
        try {
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            if (tryLock.isValid()) {
                AppMethodBeat.m2505o(65246);
                return tryLock;
            }
        } catch (Exception | OverlappingFileLockException e) {
        }
        AppMethodBeat.m2505o(65246);
        return null;
    }

    /* renamed from: a */
    public static synchronized void m49549a(Context context, FileLock fileLock) {
        synchronized (C30950k.class) {
            AppMethodBeat.m2504i(65251);
            FileChannel channel = fileLock.channel();
            if (channel != null && channel.isOpen()) {
                try {
                    fileLock.release();
                    AppMethodBeat.m2505o(65251);
                } catch (IOException e) {
                }
            }
            AppMethodBeat.m2505o(65251);
        }
    }

    /* renamed from: a */
    public static void m49550a(File file, boolean z) {
        AppMethodBeat.m2504i(65237);
        if (file == null || !file.exists()) {
            AppMethodBeat.m2505o(65237);
        } else if (file.isFile()) {
            file.delete();
            AppMethodBeat.m2505o(65237);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.m2505o(65237);
                return;
            }
            for (File a : listFiles) {
                C30950k.m49550a(a, z);
            }
            if (!z) {
                file.delete();
            }
            AppMethodBeat.m2505o(65237);
        }
    }

    /* renamed from: a */
    public static void m49551a(File file, boolean z, String str) {
        AppMethodBeat.m2504i(65238);
        if (file == null || !file.exists()) {
            AppMethodBeat.m2505o(65238);
        } else if (file.isFile()) {
            file.delete();
            AppMethodBeat.m2505o(65238);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.m2505o(65238);
                return;
            }
            for (File file2 : listFiles) {
                if (!file2.getName().equals(str)) {
                    C30950k.m49550a(file2, z);
                }
            }
            if (!z) {
                file.delete();
            }
            AppMethodBeat.m2505o(65238);
        }
    }

    /* renamed from: a */
    public static void m49552a(FileLock fileLock, FileOutputStream fileOutputStream) {
        AppMethodBeat.m2504i(65247);
        if (fileLock != null) {
            try {
                FileChannel channel = fileLock.channel();
                if (channel != null && channel.isOpen()) {
                    fileLock.release();
                }
            } catch (Exception e) {
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
                AppMethodBeat.m2505o(65247);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.m2505o(65247);
    }

    /* renamed from: a */
    public static boolean m49553a(Context context) {
        boolean z = true;
        AppMethodBeat.m2504i(65224);
        if (VERSION.SDK_INT < 23) {
            AppMethodBeat.m2505o(65224);
        } else {
            if (context == null) {
                z = false;
            } else if (context.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                z = false;
            }
            AppMethodBeat.m2505o(65224);
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m49554a(File file) {
        AppMethodBeat.m2504i(65235);
        if (file == null) {
            AppMethodBeat.m2505o(65235);
            return false;
        } else if (file.exists() && file.isDirectory()) {
            AppMethodBeat.m2505o(65235);
            return true;
        } else {
            C30950k.m49564b(file);
            boolean mkdirs = file.mkdirs();
            AppMethodBeat.m2505o(65235);
            return mkdirs;
        }
    }

    /* renamed from: a */
    public static boolean m49555a(File file, File file2) {
        AppMethodBeat.m2504i(65225);
        boolean a = C30950k.m49560a(file.getPath(), file2.getPath());
        AppMethodBeat.m2505o(65225);
        return a;
    }

    /* renamed from: a */
    public static boolean m49556a(File file, File file2, FileFilter fileFilter) {
        AppMethodBeat.m2504i(65232);
        boolean a = C30950k.m49557a(file, file2, fileFilter, f13920b);
        AppMethodBeat.m2505o(65232);
        return a;
    }

    /* renamed from: a */
    public static boolean m49557a(File file, File file2, FileFilter fileFilter, C5821a c5821a) {
        AppMethodBeat.m2504i(65233);
        if (file == null || file2 == null) {
            AppMethodBeat.m2505o(65233);
            return false;
        } else if (!file.exists()) {
            AppMethodBeat.m2505o(65233);
            return false;
        } else if (file.isFile()) {
            boolean b = C30950k.m49567b(file, file2, fileFilter, c5821a);
            AppMethodBeat.m2505o(65233);
            return b;
        } else {
            File[] listFiles = file.listFiles(fileFilter);
            if (listFiles == null) {
                AppMethodBeat.m2505o(65233);
                return false;
            }
            boolean z = true;
            for (File file3 : listFiles) {
                if (!C30950k.m49556a(file3, new File(file2, file3.getName()), fileFilter)) {
                    z = false;
                }
            }
            AppMethodBeat.m2505o(65233);
            return z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m49559a(String str, long j, long j2, long j3) {
        Throwable th;
        FileInputStream fileInputStream;
        AppMethodBeat.m2504i(65230);
        File file = new File(str);
        if (file.length() != j) {
            TbsLog.m80432e("FileHelper", "file size doesn't match: " + file.length() + " vs " + j);
            AppMethodBeat.m2505o(65230);
            return true;
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                CRC32 crc32 = new CRC32();
                byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                long value = crc32.getValue();
                TbsLog.m80434i("FileHelper", file.getName() + ": crc = " + value + ", zipCrc = " + j3);
                if (value != j3) {
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    AppMethodBeat.m2505o(65230);
                    return true;
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                AppMethodBeat.m2505o(65230);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                AppMethodBeat.m2505o(65230);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(65230);
            throw th;
        }
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public static boolean m49560a(String str, String str2) {
        AppMethodBeat.m2504i(65226);
        boolean a = C30950k.m49562a(str, str2, Build.CPU_ABI, VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null, C16159q.m24514a("ro.product.cpu.upgradeabi", "armeabi"));
        AppMethodBeat.m2505o(65226);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m49561a(String str, String str2, String str3, String str4, C16158b c16158b) {
        Throwable th;
        AppMethodBeat.m2504i(65228);
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(str);
            Object obj = null;
            Object obj2 = null;
            InputStream inputStream;
            try {
                Enumeration entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    String name = zipEntry.getName();
                    if (!(name == null || name.contains("../"))) {
                        if (name.startsWith("lib/") || name.startsWith("assets/")) {
                            String substring = name.substring(name.lastIndexOf(47));
                            if (substring.endsWith(".so")) {
                                if (name.regionMatches(f13921c, str2, 0, str2.length()) && name.charAt(f13921c + str2.length()) == IOUtils.DIR_SEPARATOR_UNIX) {
                                    obj = 1;
                                } else {
                                    if (str3 != null) {
                                        if (name.regionMatches(f13921c, str3, 0, str3.length()) && name.charAt(f13921c + str3.length()) == IOUtils.DIR_SEPARATOR_UNIX) {
                                            obj2 = 1;
                                            if (obj != null) {
                                            }
                                        }
                                    }
                                    if (str4 != null && name.regionMatches(f13921c, str4, 0, str4.length()) && name.charAt(f13921c + str4.length()) == IOUtils.DIR_SEPARATOR_UNIX && obj == null && obj2 == null) {
                                    }
                                }
                            }
                            inputStream = zipFile.getInputStream(zipEntry);
                            if (!c16158b.mo28983a(inputStream, zipEntry, substring.substring(1))) {
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (zipFile != null) {
                                    zipFile.close();
                                }
                                AppMethodBeat.m2505o(65228);
                                return false;
                            } else if (inputStream != null) {
                                inputStream.close();
                            }
                        }
                    }
                }
                if (zipFile != null) {
                    zipFile.close();
                }
                AppMethodBeat.m2505o(65228);
                return true;
            } catch (Throwable th2) {
                th = th2;
                if (zipFile != null) {
                }
                AppMethodBeat.m2505o(65228);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            if (zipFile != null) {
                zipFile.close();
            }
            AppMethodBeat.m2505o(65228);
            throw th;
        }
    }

    /* renamed from: a */
    private static boolean m49562a(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(65227);
        boolean a = C30950k.m49561a(str, str3, str4, str5, new C24287l(str2));
        AppMethodBeat.m2505o(65227);
        return a;
    }

    /* renamed from: b */
    public static FileOutputStream m49563b(Context context, boolean z, String str) {
        AppMethodBeat.m2504i(65245);
        File a = C30950k.m49544a(context, z, str);
        if (a != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(a);
                AppMethodBeat.m2505o(65245);
                return fileOutputStream;
            } catch (FileNotFoundException e) {
            }
        }
        AppMethodBeat.m2505o(65245);
        return null;
    }

    /* renamed from: b */
    public static void m49564b(File file) {
        AppMethodBeat.m2504i(65236);
        C30950k.m49550a(file, false);
        AppMethodBeat.m2505o(65236);
    }

    /* renamed from: b */
    public static boolean m49565b(Context context) {
        AppMethodBeat.m2504i(65241);
        long a = C5822y.m8882a();
        boolean z = a >= TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
        if (!z) {
            TbsLog.m80432e(TbsDownloader.LOGTAG, "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = ".concat(String.valueOf(a)));
        }
        AppMethodBeat.m2505o(65241);
        return z;
    }

    /* renamed from: b */
    public static boolean m49566b(File file, File file2) {
        AppMethodBeat.m2504i(65231);
        boolean a = C30950k.m49556a(file, file2, null);
        AppMethodBeat.m2505o(65231);
        return a;
    }

    /* renamed from: b */
    private static boolean m49567b(File file, File file2, FileFilter fileFilter, C5821a c5821a) {
        Throwable th;
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        AppMethodBeat.m2504i(65234);
        if (file == null || file2 == null) {
            AppMethodBeat.m2505o(65234);
            return false;
        } else if (fileFilter == null || fileFilter.accept(file)) {
            FileChannel channel;
            try {
                if (file.exists() && file.isFile()) {
                    if (file2.exists()) {
                        if (c5821a == null || !c5821a.mo12209a(file, file2)) {
                            C30950k.m49564b(file2);
                        } else {
                            if (fileChannel2 != null) {
                                fileChannel2.close();
                            }
                            if (fileChannel2 != null) {
                                fileChannel2.close();
                            }
                            AppMethodBeat.m2505o(65234);
                            return true;
                        }
                    }
                    File parentFile = file2.getParentFile();
                    if (parentFile.isFile()) {
                        C30950k.m49564b(parentFile);
                    }
                    if (parentFile.exists() || parentFile.mkdirs()) {
                        FileChannel channel2;
                        channel = new FileInputStream(file).getChannel();
                        try {
                            channel2 = new FileOutputStream(file2).getChannel();
                        } catch (Throwable th2) {
                            th = th2;
                            fileChannel = fileChannel2;
                        }
                        try {
                            long size = channel.size();
                            if (channel2.transferFrom(channel, 0, size) != size) {
                                C30950k.m49564b(file2);
                                if (channel != null) {
                                    channel.close();
                                }
                                if (channel2 != null) {
                                    channel2.close();
                                }
                                AppMethodBeat.m2505o(65234);
                                return false;
                            }
                            if (channel != null) {
                                channel.close();
                            }
                            if (channel2 != null) {
                                channel2.close();
                            }
                            AppMethodBeat.m2505o(65234);
                            return true;
                        } catch (Throwable th3) {
                            th = th3;
                            fileChannel = channel2;
                            if (channel != null) {
                                channel.close();
                            }
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                            AppMethodBeat.m2505o(65234);
                            throw th;
                        }
                    }
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    AppMethodBeat.m2505o(65234);
                    return false;
                }
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                AppMethodBeat.m2505o(65234);
                return false;
            } catch (Throwable th22) {
                th = th22;
                fileChannel = fileChannel2;
                channel = fileChannel2;
            }
        } else {
            AppMethodBeat.m2505o(65234);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private static boolean m49568b(InputStream inputStream, ZipEntry zipEntry, String str, String str2) {
        Throwable e;
        FileOutputStream fileOutputStream;
        IOException iOException;
        AppMethodBeat.m2504i(65229);
        C30950k.m49554a(new File(str));
        String str3 = str + File.separator + str2;
        File file = new File(str3);
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (C30950k.m49559a(str3, zipEntry.getSize(), zipEntry.getTime(), zipEntry.getCrc())) {
                    TbsLog.m80432e("FileHelper", "file is different: ".concat(String.valueOf(str3)));
                    AppMethodBeat.m2505o(65229);
                    return false;
                }
                if (!file.setLastModified(zipEntry.getTime())) {
                    TbsLog.m80432e("FileHelper", "Couldn't set time for dst file ".concat(String.valueOf(file)));
                }
                AppMethodBeat.m2505o(65229);
                return true;
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                try {
                    C30950k.m49564b(file);
                    iOException = new IOException("Couldn't write dst file ".concat(String.valueOf(file)), e);
                    AppMethodBeat.m2505o(65229);
                    throw iOException;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(65229);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                AppMethodBeat.m2505o(65229);
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            C30950k.m49564b(file);
            iOException = new IOException("Couldn't write dst file ".concat(String.valueOf(file)), e);
            AppMethodBeat.m2505o(65229);
            throw iOException;
        } catch (Throwable th3) {
            e = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            AppMethodBeat.m2505o(65229);
            throw e;
        }
    }

    /* renamed from: c */
    public static String m49569c(Context context) {
        AppMethodBeat.m2504i(65242);
        String str = Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
        AppMethodBeat.m2505o(65242);
        return str;
    }

    /* renamed from: c */
    public static boolean m49570c(File file) {
        AppMethodBeat.m2504i(65239);
        if (file == null || !file.exists() || !file.isFile() || file.length() <= 0) {
            AppMethodBeat.m2505o(65239);
            return false;
        }
        AppMethodBeat.m2505o(65239);
        return true;
    }

    /* renamed from: d */
    public static FileOutputStream m49571d(File file) {
        AppMethodBeat.m2504i(65240);
        IOException iOException;
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile == null || parentFile.exists() || parentFile.mkdirs())) {
                iOException = new IOException("File '" + file + "' could not be created");
                AppMethodBeat.m2505o(65240);
                throw iOException;
            }
        } else if (file.isDirectory()) {
            iOException = new IOException("File '" + file + "' exists but is a directory");
            AppMethodBeat.m2505o(65240);
            throw iOException;
        } else if (!file.canWrite()) {
            iOException = new IOException("File '" + file + "' cannot be written to");
            AppMethodBeat.m2505o(65240);
            throw iOException;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        AppMethodBeat.m2505o(65240);
        return fileOutputStream;
    }

    /* renamed from: d */
    static String m49572d(Context context) {
        AppMethodBeat.m2504i(65243);
        File file = new File(context.getDir("tbs", 0), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            String absolutePath = file.getAbsolutePath();
            AppMethodBeat.m2505o(65243);
            return absolutePath;
        }
        AppMethodBeat.m2505o(65243);
        return null;
    }

    /* renamed from: e */
    public static FileLock m49573e(Context context) {
        boolean tbsCoreLoadRenameFileLockEnable;
        FileLock fileLock = null;
        AppMethodBeat.m2504i(65248);
        TbsLog.m80434i("FileHelper", "getTbsCoreLoadFileLock #1");
        try {
            tbsCoreLoadRenameFileLockEnable = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
            tbsCoreLoadRenameFileLockEnable = true;
        }
        if (tbsCoreLoadRenameFileLockEnable) {
            TbsLog.m80434i("FileHelper", "getTbsCoreLoadFileLock #3");
            String str = "tbs_rename_lock";
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(C30950k.m49544a(context, true, str).getAbsolutePath(), "r");
                f13922d = randomAccessFile;
                fileLock = randomAccessFile.getChannel().tryLock(0, Long.MAX_VALUE, true);
            } catch (Throwable th2) {
            }
            if (fileLock == null) {
                fileLock = C30950k.m49575g(context);
            }
            if (fileLock == null) {
                TbsLog.m80434i("FileHelper", "getTbsCoreLoadFileLock -- failed: ".concat(String.valueOf(str)));
            } else {
                TbsLog.m80434i("FileHelper", "getTbsCoreLoadFileLock -- success: ".concat(String.valueOf(str)));
            }
            AppMethodBeat.m2505o(65248);
        } else {
            FileOutputStream b = C30950k.m49563b(context, true, "tbs_rename_lock");
            if (b == null) {
                TbsLog.m80434i("FileHelper", "init -- failed to get rename fileLock#1!");
            } else {
                fileLock = C30950k.m49548a(context, b);
                if (fileLock == null) {
                    TbsLog.m80434i("FileHelper", "init -- failed to get rename fileLock#2!");
                } else {
                    TbsLog.m80434i("FileHelper", "init -- get rename fileLock success!");
                }
            }
            TbsLog.m80434i("FileHelper", "getTbsCoreLoadFileLock #2 renameFileLock is ".concat(String.valueOf(fileLock)));
            AppMethodBeat.m2505o(65248);
        }
        return fileLock;
    }

    /* renamed from: f */
    public static FileLock m49574f(Context context) {
        AppMethodBeat.m2504i(65250);
        FileLock fileLock = null;
        String str = "tbs_rename_lock";
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(C30950k.m49544a(context, true, str).getAbsolutePath(), "rw");
            f13922d = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock(0, Long.MAX_VALUE, false);
        } catch (Throwable th) {
        }
        if (fileLock == null) {
            TbsLog.m80434i("FileHelper", "getTbsCoreRenameFileLock -- failed: ".concat(String.valueOf(str)));
        } else {
            TbsLog.m80434i("FileHelper", "getTbsCoreRenameFileLock -- success: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(65250);
        return fileLock;
    }

    /* renamed from: g */
    private static FileLock m49575g(Context context) {
        AppMethodBeat.m2504i(65249);
        FileLock fileLock = null;
        try {
            TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.setErrorCode(803);
            File a = C30950k.m49544a(context, true, "tbs_rename_lock");
            if (TbsDownloadConfig.getInstance(context).getTbsCoreLoadRenameFileLockWaitEnable()) {
                int i = 0;
                while (i < 20 && fileLock == null) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(a.getAbsolutePath(), "r");
                        f13922d = randomAccessFile;
                        fileLock = randomAccessFile.getChannel().tryLock(0, Long.MAX_VALUE, true);
                    } catch (Throwable th) {
                    }
                    i++;
                }
                if (fileLock != null) {
                    tbsLogInfo.setErrorCode(802);
                } else {
                    tbsLogInfo.setErrorCode(801);
                }
                TbsLogReport.getInstance(context).eventReport(EventType.TYPE_SDK_REPORT_INFO, tbsLogInfo);
                TbsLog.m80434i("FileHelper", "getTbsCoreLoadFileLock,retry num=" + i + "success=" + (fileLock == null));
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.m2505o(65249);
        return fileLock;
    }
}
