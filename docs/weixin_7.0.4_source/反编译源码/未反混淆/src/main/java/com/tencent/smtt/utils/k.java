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
public class k {
    public static String a = null;
    public static final a b = new m();
    private static final int c = 4;
    private static RandomAccessFile d = null;

    public interface a {
        boolean a(File file, File file2);
    }

    public interface b {
        boolean a(InputStream inputStream, ZipEntry zipEntry, String str);
    }

    static {
        AppMethodBeat.i(65253);
        AppMethodBeat.o(65253);
    }

    public static File a(Context context, boolean z, String str) {
        AppMethodBeat.i(65244);
        String d = z ? d(context) : c(context);
        if (d == null) {
            AppMethodBeat.o(65244);
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
                    AppMethodBeat.o(65244);
                    return null;
                }
            }
            AppMethodBeat.o(65244);
            return file2;
        }
        AppMethodBeat.o(65244);
        return null;
    }

    public static String a(Context context, int i) {
        AppMethodBeat.i(65221);
        String a = a(context, context.getApplicationInfo().packageName, i, true);
        AppMethodBeat.o(65221);
        return a;
    }

    private static String a(Context context, String str) {
        AppMethodBeat.i(65223);
        String str2 = "";
        if (context == null) {
            AppMethodBeat.o(65223);
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
                AppMethodBeat.o(65223);
                return str2;
            }
        }
        AppMethodBeat.o(65223);
        return str2;
    }

    public static String a(Context context, String str, int i, boolean z) {
        AppMethodBeat.i(65222);
        String str2;
        if (context == null) {
            str2 = "";
            AppMethodBeat.o(65222);
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
                    AppMethodBeat.o(65222);
                    return str2;
                }
                str2 = str2 + "tencent" + File.separator + "tbs" + File.separator + str;
                AppMethodBeat.o(65222);
                return str2;
            case 2:
                if (str2.equals("")) {
                    AppMethodBeat.o(65222);
                    return str2;
                }
                str2 = str2 + "tbs" + File.separator + "backup" + File.separator + str;
                AppMethodBeat.o(65222);
                return str2;
            case 3:
                if (str2.equals("")) {
                    AppMethodBeat.o(65222);
                    return str2;
                }
                str2 = str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + str;
                AppMethodBeat.o(65222);
                return str2;
            case 4:
                if (str2.equals("")) {
                    str2 = a(context, "backup");
                    AppMethodBeat.o(65222);
                    return str2;
                }
                str2 = str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + str;
                if (z) {
                    File file = new File(str2);
                    if (!(file.exists() && file.canWrite())) {
                        if (file.exists()) {
                            str2 = a(context, "backup");
                        } else {
                            file.mkdirs();
                            if (!file.canWrite()) {
                                str2 = a(context, "backup");
                            }
                        }
                    }
                }
                AppMethodBeat.o(65222);
                return str2;
            case 5:
                if (str2.equals("")) {
                    AppMethodBeat.o(65222);
                    return str2;
                }
                str2 = str2 + "tencent" + File.separator + "tbs" + File.separator + str;
                AppMethodBeat.o(65222);
                return str2;
            case 6:
                if (a != null) {
                    str2 = a;
                    AppMethodBeat.o(65222);
                    return str2;
                }
                str2 = a(context, "tbslog");
                a = str2;
                AppMethodBeat.o(65222);
                return str2;
            default:
                str2 = "";
                AppMethodBeat.o(65222);
                return str2;
        }
    }

    public static FileLock a(Context context, FileOutputStream fileOutputStream) {
        AppMethodBeat.i(65246);
        if (fileOutputStream == null) {
            AppMethodBeat.o(65246);
            return null;
        }
        try {
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            if (tryLock.isValid()) {
                AppMethodBeat.o(65246);
                return tryLock;
            }
        } catch (Exception | OverlappingFileLockException e) {
        }
        AppMethodBeat.o(65246);
        return null;
    }

    public static synchronized void a(Context context, FileLock fileLock) {
        synchronized (k.class) {
            AppMethodBeat.i(65251);
            FileChannel channel = fileLock.channel();
            if (channel != null && channel.isOpen()) {
                try {
                    fileLock.release();
                    AppMethodBeat.o(65251);
                } catch (IOException e) {
                }
            }
            AppMethodBeat.o(65251);
        }
    }

    public static void a(File file, boolean z) {
        AppMethodBeat.i(65237);
        if (file == null || !file.exists()) {
            AppMethodBeat.o(65237);
        } else if (file.isFile()) {
            file.delete();
            AppMethodBeat.o(65237);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(65237);
                return;
            }
            for (File a : listFiles) {
                a(a, z);
            }
            if (!z) {
                file.delete();
            }
            AppMethodBeat.o(65237);
        }
    }

    public static void a(File file, boolean z, String str) {
        AppMethodBeat.i(65238);
        if (file == null || !file.exists()) {
            AppMethodBeat.o(65238);
        } else if (file.isFile()) {
            file.delete();
            AppMethodBeat.o(65238);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(65238);
                return;
            }
            for (File file2 : listFiles) {
                if (!file2.getName().equals(str)) {
                    a(file2, z);
                }
            }
            if (!z) {
                file.delete();
            }
            AppMethodBeat.o(65238);
        }
    }

    public static void a(FileLock fileLock, FileOutputStream fileOutputStream) {
        AppMethodBeat.i(65247);
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
                AppMethodBeat.o(65247);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(65247);
    }

    public static boolean a(Context context) {
        boolean z = true;
        AppMethodBeat.i(65224);
        if (VERSION.SDK_INT < 23) {
            AppMethodBeat.o(65224);
        } else {
            if (context == null) {
                z = false;
            } else if (context.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                z = false;
            }
            AppMethodBeat.o(65224);
        }
        return z;
    }

    public static boolean a(File file) {
        AppMethodBeat.i(65235);
        if (file == null) {
            AppMethodBeat.o(65235);
            return false;
        } else if (file.exists() && file.isDirectory()) {
            AppMethodBeat.o(65235);
            return true;
        } else {
            b(file);
            boolean mkdirs = file.mkdirs();
            AppMethodBeat.o(65235);
            return mkdirs;
        }
    }

    public static boolean a(File file, File file2) {
        AppMethodBeat.i(65225);
        boolean a = a(file.getPath(), file2.getPath());
        AppMethodBeat.o(65225);
        return a;
    }

    public static boolean a(File file, File file2, FileFilter fileFilter) {
        AppMethodBeat.i(65232);
        boolean a = a(file, file2, fileFilter, b);
        AppMethodBeat.o(65232);
        return a;
    }

    public static boolean a(File file, File file2, FileFilter fileFilter, a aVar) {
        AppMethodBeat.i(65233);
        if (file == null || file2 == null) {
            AppMethodBeat.o(65233);
            return false;
        } else if (!file.exists()) {
            AppMethodBeat.o(65233);
            return false;
        } else if (file.isFile()) {
            boolean b = b(file, file2, fileFilter, aVar);
            AppMethodBeat.o(65233);
            return b;
        } else {
            File[] listFiles = file.listFiles(fileFilter);
            if (listFiles == null) {
                AppMethodBeat.o(65233);
                return false;
            }
            boolean z = true;
            for (File file3 : listFiles) {
                if (!a(file3, new File(file2, file3.getName()), fileFilter)) {
                    z = false;
                }
            }
            AppMethodBeat.o(65233);
            return z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(String str, long j, long j2, long j3) {
        Throwable th;
        FileInputStream fileInputStream;
        AppMethodBeat.i(65230);
        File file = new File(str);
        if (file.length() != j) {
            TbsLog.e("FileHelper", "file size doesn't match: " + file.length() + " vs " + j);
            AppMethodBeat.o(65230);
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
                TbsLog.i("FileHelper", file.getName() + ": crc = " + value + ", zipCrc = " + j3);
                if (value != j3) {
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    AppMethodBeat.o(65230);
                    return true;
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                AppMethodBeat.o(65230);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                AppMethodBeat.o(65230);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            AppMethodBeat.o(65230);
            throw th;
        }
    }

    @SuppressLint({"InlinedApi"})
    public static boolean a(String str, String str2) {
        AppMethodBeat.i(65226);
        boolean a = a(str, str2, Build.CPU_ABI, VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null, q.a("ro.product.cpu.upgradeabi", "armeabi"));
        AppMethodBeat.o(65226);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(String str, String str2, String str3, String str4, b bVar) {
        Throwable th;
        AppMethodBeat.i(65228);
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
                                if (name.regionMatches(c, str2, 0, str2.length()) && name.charAt(c + str2.length()) == IOUtils.DIR_SEPARATOR_UNIX) {
                                    obj = 1;
                                } else {
                                    if (str3 != null) {
                                        if (name.regionMatches(c, str3, 0, str3.length()) && name.charAt(c + str3.length()) == IOUtils.DIR_SEPARATOR_UNIX) {
                                            obj2 = 1;
                                            if (obj != null) {
                                            }
                                        }
                                    }
                                    if (str4 != null && name.regionMatches(c, str4, 0, str4.length()) && name.charAt(c + str4.length()) == IOUtils.DIR_SEPARATOR_UNIX && obj == null && obj2 == null) {
                                    }
                                }
                            }
                            inputStream = zipFile.getInputStream(zipEntry);
                            if (!bVar.a(inputStream, zipEntry, substring.substring(1))) {
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (zipFile != null) {
                                    zipFile.close();
                                }
                                AppMethodBeat.o(65228);
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
                AppMethodBeat.o(65228);
                return true;
            } catch (Throwable th2) {
                th = th2;
                if (zipFile != null) {
                }
                AppMethodBeat.o(65228);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            if (zipFile != null) {
                zipFile.close();
            }
            AppMethodBeat.o(65228);
            throw th;
        }
    }

    private static boolean a(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(65227);
        boolean a = a(str, str3, str4, str5, new l(str2));
        AppMethodBeat.o(65227);
        return a;
    }

    public static FileOutputStream b(Context context, boolean z, String str) {
        AppMethodBeat.i(65245);
        File a = a(context, z, str);
        if (a != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(a);
                AppMethodBeat.o(65245);
                return fileOutputStream;
            } catch (FileNotFoundException e) {
            }
        }
        AppMethodBeat.o(65245);
        return null;
    }

    public static void b(File file) {
        AppMethodBeat.i(65236);
        a(file, false);
        AppMethodBeat.o(65236);
    }

    public static boolean b(Context context) {
        AppMethodBeat.i(65241);
        long a = y.a();
        boolean z = a >= TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
        if (!z) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = ".concat(String.valueOf(a)));
        }
        AppMethodBeat.o(65241);
        return z;
    }

    public static boolean b(File file, File file2) {
        AppMethodBeat.i(65231);
        boolean a = a(file, file2, null);
        AppMethodBeat.o(65231);
        return a;
    }

    private static boolean b(File file, File file2, FileFilter fileFilter, a aVar) {
        Throwable th;
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        AppMethodBeat.i(65234);
        if (file == null || file2 == null) {
            AppMethodBeat.o(65234);
            return false;
        } else if (fileFilter == null || fileFilter.accept(file)) {
            FileChannel channel;
            try {
                if (file.exists() && file.isFile()) {
                    if (file2.exists()) {
                        if (aVar == null || !aVar.a(file, file2)) {
                            b(file2);
                        } else {
                            if (fileChannel2 != null) {
                                fileChannel2.close();
                            }
                            if (fileChannel2 != null) {
                                fileChannel2.close();
                            }
                            AppMethodBeat.o(65234);
                            return true;
                        }
                    }
                    File parentFile = file2.getParentFile();
                    if (parentFile.isFile()) {
                        b(parentFile);
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
                                b(file2);
                                if (channel != null) {
                                    channel.close();
                                }
                                if (channel2 != null) {
                                    channel2.close();
                                }
                                AppMethodBeat.o(65234);
                                return false;
                            }
                            if (channel != null) {
                                channel.close();
                            }
                            if (channel2 != null) {
                                channel2.close();
                            }
                            AppMethodBeat.o(65234);
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
                            AppMethodBeat.o(65234);
                            throw th;
                        }
                    }
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    AppMethodBeat.o(65234);
                    return false;
                }
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                AppMethodBeat.o(65234);
                return false;
            } catch (Throwable th22) {
                th = th22;
                fileChannel = fileChannel2;
                channel = fileChannel2;
            }
        } else {
            AppMethodBeat.o(65234);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @SuppressLint({"NewApi"})
    private static boolean b(InputStream inputStream, ZipEntry zipEntry, String str, String str2) {
        Throwable e;
        FileOutputStream fileOutputStream;
        IOException iOException;
        AppMethodBeat.i(65229);
        a(new File(str));
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
                if (a(str3, zipEntry.getSize(), zipEntry.getTime(), zipEntry.getCrc())) {
                    TbsLog.e("FileHelper", "file is different: ".concat(String.valueOf(str3)));
                    AppMethodBeat.o(65229);
                    return false;
                }
                if (!file.setLastModified(zipEntry.getTime())) {
                    TbsLog.e("FileHelper", "Couldn't set time for dst file ".concat(String.valueOf(file)));
                }
                AppMethodBeat.o(65229);
                return true;
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                try {
                    b(file);
                    iOException = new IOException("Couldn't write dst file ".concat(String.valueOf(file)), e);
                    AppMethodBeat.o(65229);
                    throw iOException;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.o(65229);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                AppMethodBeat.o(65229);
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            b(file);
            iOException = new IOException("Couldn't write dst file ".concat(String.valueOf(file)), e);
            AppMethodBeat.o(65229);
            throw iOException;
        } catch (Throwable th3) {
            e = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            AppMethodBeat.o(65229);
            throw e;
        }
    }

    public static String c(Context context) {
        AppMethodBeat.i(65242);
        String str = Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
        AppMethodBeat.o(65242);
        return str;
    }

    public static boolean c(File file) {
        AppMethodBeat.i(65239);
        if (file == null || !file.exists() || !file.isFile() || file.length() <= 0) {
            AppMethodBeat.o(65239);
            return false;
        }
        AppMethodBeat.o(65239);
        return true;
    }

    public static FileOutputStream d(File file) {
        AppMethodBeat.i(65240);
        IOException iOException;
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile == null || parentFile.exists() || parentFile.mkdirs())) {
                iOException = new IOException("File '" + file + "' could not be created");
                AppMethodBeat.o(65240);
                throw iOException;
            }
        } else if (file.isDirectory()) {
            iOException = new IOException("File '" + file + "' exists but is a directory");
            AppMethodBeat.o(65240);
            throw iOException;
        } else if (!file.canWrite()) {
            iOException = new IOException("File '" + file + "' cannot be written to");
            AppMethodBeat.o(65240);
            throw iOException;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        AppMethodBeat.o(65240);
        return fileOutputStream;
    }

    static String d(Context context) {
        AppMethodBeat.i(65243);
        File file = new File(context.getDir("tbs", 0), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            String absolutePath = file.getAbsolutePath();
            AppMethodBeat.o(65243);
            return absolutePath;
        }
        AppMethodBeat.o(65243);
        return null;
    }

    public static FileLock e(Context context) {
        boolean tbsCoreLoadRenameFileLockEnable;
        FileLock fileLock = null;
        AppMethodBeat.i(65248);
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #1");
        try {
            tbsCoreLoadRenameFileLockEnable = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
            tbsCoreLoadRenameFileLockEnable = true;
        }
        if (tbsCoreLoadRenameFileLockEnable) {
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #3");
            String str = "tbs_rename_lock";
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(a(context, true, str).getAbsolutePath(), "r");
                d = randomAccessFile;
                fileLock = randomAccessFile.getChannel().tryLock(0, Long.MAX_VALUE, true);
            } catch (Throwable th2) {
            }
            if (fileLock == null) {
                fileLock = g(context);
            }
            if (fileLock == null) {
                TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- failed: ".concat(String.valueOf(str)));
            } else {
                TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- success: ".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(65248);
        } else {
            FileOutputStream b = b(context, true, "tbs_rename_lock");
            if (b == null) {
                TbsLog.i("FileHelper", "init -- failed to get rename fileLock#1!");
            } else {
                fileLock = a(context, b);
                if (fileLock == null) {
                    TbsLog.i("FileHelper", "init -- failed to get rename fileLock#2!");
                } else {
                    TbsLog.i("FileHelper", "init -- get rename fileLock success!");
                }
            }
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #2 renameFileLock is ".concat(String.valueOf(fileLock)));
            AppMethodBeat.o(65248);
        }
        return fileLock;
    }

    public static FileLock f(Context context) {
        AppMethodBeat.i(65250);
        FileLock fileLock = null;
        String str = "tbs_rename_lock";
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(a(context, true, str).getAbsolutePath(), "rw");
            d = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock(0, Long.MAX_VALUE, false);
        } catch (Throwable th) {
        }
        if (fileLock == null) {
            TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- failed: ".concat(String.valueOf(str)));
        } else {
            TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- success: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(65250);
        return fileLock;
    }

    private static FileLock g(Context context) {
        AppMethodBeat.i(65249);
        FileLock fileLock = null;
        try {
            TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.setErrorCode(803);
            File a = a(context, true, "tbs_rename_lock");
            if (TbsDownloadConfig.getInstance(context).getTbsCoreLoadRenameFileLockWaitEnable()) {
                int i = 0;
                while (i < 20 && fileLock == null) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(a.getAbsolutePath(), "r");
                        d = randomAccessFile;
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
                TbsLog.i("FileHelper", "getTbsCoreLoadFileLock,retry num=" + i + "success=" + (fileLock == null));
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(65249);
        return fileLock;
    }
}
