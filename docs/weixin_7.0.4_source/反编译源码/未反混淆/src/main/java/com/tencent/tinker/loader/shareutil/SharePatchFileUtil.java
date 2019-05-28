package com.tencent.tinker.loader.shareutil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.xwalk.core.XWalkEnvironment;

public class SharePatchFileUtil {
    private static char[] caT = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static File jh(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, "tinker");
    }

    public static File ji(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, "tinker_temp");
    }

    public static File jj(Context context) {
        File ji = ji(context);
        if (ji == null) {
            return null;
        }
        return new File(ji, "tinker_last_crash");
    }

    public static File auo(String str) {
        return new File(str + "/patch.info");
    }

    public static File aup(String str) {
        return new File(str + "/info.lock");
    }

    public static String auq(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return "patch-" + str.substring(0, 8);
    }

    public static String aur(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return auq(str) + ".apk";
    }

    public static boolean aus(String str) {
        if (str == null || str.length() != 32) {
            return false;
        }
        return true;
    }

    public static String jk(Context context) {
        Object e;
        Throwable th;
        File jj = jj(context);
        if (!ap(jj)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Object bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(jj)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                        stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
                    } else {
                        ah(bufferedReader);
                        return stringBuffer.toString();
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        new StringBuilder("checkTinkerLastUncaughtCrash exception: ").append(e);
                        ah(bufferedReader);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        ah(bufferedReader);
                        throw th;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            new StringBuilder("checkTinkerLastUncaughtCrash exception: ").append(e);
            ah(bufferedReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            ah(bufferedReader);
            throw th;
        }
    }

    @SuppressLint({"NewApi"})
    public static void ah(Object obj) {
        if (obj != null) {
            if (obj instanceof Closeable) {
                try {
                    ((Closeable) obj).close();
                } catch (Throwable th) {
                }
            } else if (VERSION.SDK_INT >= 19 && (obj instanceof AutoCloseable)) {
                try {
                    ((AutoCloseable) obj).close();
                } catch (Throwable th2) {
                }
            } else if (obj instanceof ZipFile) {
                try {
                    ((ZipFile) obj).close();
                } catch (Throwable th3) {
                }
            } else {
                throw new IllegalArgumentException("obj: " + obj + " cannot be closed.");
            }
        }
    }

    public static final boolean ap(File file) {
        return file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0;
    }

    public static final boolean aq(File file) {
        return ("vivo".equalsIgnoreCase(Build.MANUFACTURER) || "oppo".equalsIgnoreCase(Build.MANUFACTURER)) && (!file.exists() || file.length() == 0);
    }

    public static long ar(File file) {
        long j = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (file.isFile()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            long ar;
            if (file2.isDirectory()) {
                ar = ar(file2);
            } else {
                ar = file2.length();
            }
            j += ar;
        }
        return j;
    }

    public static final boolean as(File file) {
        boolean z = true;
        if (file != null && file.exists()) {
            new StringBuilder("safeDeleteFile, try to delete path: ").append(file.getPath());
            z = file.delete();
            if (!z) {
                new StringBuilder("Failed to delete file, try to delete when exit. path: ").append(file.getPath());
                file.deleteOnExit();
            }
        }
        return z;
    }

    public static final boolean cu(String str) {
        if (str == null) {
            return false;
        }
        return t(new File(str));
    }

    public static final boolean t(File file) {
        int i = 0;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            as(file);
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    t(listFiles[i]);
                    i++;
                }
                as(file);
            }
        }
        return true;
    }

    public static boolean g(File file, String str) {
        if (str == null) {
            return false;
        }
        String at = at(file);
        if (at != null) {
            return str.equals(at);
        }
        return false;
    }

    public static boolean aut(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(".dex");
    }

    public static boolean h(File file, String str) {
        return b(file, XWalkEnvironment.XWALK_CORE_CLASSES_DEX, str);
    }

    public static boolean b(File file, String str, String str2) {
        Throwable th;
        ZipFile zipFile = null;
        if (file == null || str2 == null || str == null) {
            return false;
        }
        Object obj = "";
        if (aut(file.getName())) {
            obj = at(file);
        } else {
            ZipFile zipFile2;
            try {
                zipFile2 = new ZipFile(file);
                try {
                    ZipEntry entry = zipFile2.getEntry(str);
                    if (entry == null) {
                        new StringBuilder("There's no entry named: classes.dex in ").append(file.getAbsolutePath());
                        a(zipFile2);
                        return false;
                    }
                    Object inputStream;
                    try {
                        inputStream = zipFile2.getInputStream(entry);
                        obj = M(inputStream);
                    } catch (Throwable th2) {
                        new StringBuilder("exception occurred when get md5: ").append(file.getAbsolutePath());
                    } finally {
                        ah(inputStream);
                    }
                    a(zipFile2);
                } catch (Throwable th3) {
                    th = th3;
                    a(zipFile2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                zipFile2 = null;
                a(zipFile2);
                throw th;
            }
        }
        return str2.equals(obj);
    }

    public static void j(File file, File file2) {
        Object fileInputStream;
        Object fileOutputStream;
        Throwable th;
        if (ap(file) && file2 != null && !file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            File parentFile = file2.getParentFile();
            if (!(parentFile == null || parentFile.exists())) {
                parentFile.mkdirs();
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2, false);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    ah(fileInputStream);
                    ah(fileOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            ah(fileInputStream);
                            ah(fileOutputStream);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ah(fileInputStream);
                    ah(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                fileInputStream = null;
                ah(fileInputStream);
                ah(fileOutputStream);
                throw th;
            }
        }
    }

    public static String a(JarFile jarFile, JarEntry jarEntry) {
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        Object bufferedInputStream;
        try {
            byte[] bArr = new byte[16384];
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        stringBuilder.append(new String(bArr, 0, read));
                    } else {
                        ah(bufferedInputStream);
                        return stringBuilder.toString();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    ah(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            ah(bufferedInputStream);
            throw th;
        }
    }

    private static String M(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder stringBuilder = new StringBuilder(32);
            byte[] bArr = new byte[102400];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            for (byte b : digest) {
                stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String cq(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr = new char[(length * 2)];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr[i2] = caT[(b >>> 4) & 15];
                int i4 = i3 + 1;
                cArr[i3] = caT[b & 15];
                i++;
                i2 = i4;
            }
            return new String(cArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String at(File file) {
        Throwable th;
        Object obj;
        String str = null;
        if (file != null && file.exists()) {
            Object fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    str = M(fileInputStream);
                    ah(fileInputStream);
                } catch (Exception e) {
                    ah(fileInputStream);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    obj = fileInputStream;
                    ah(obj);
                    throw th;
                }
            } catch (Exception e2) {
                fileInputStream = str;
                ah(fileInputStream);
                return str;
            } catch (Throwable th3) {
                th = th3;
                obj = str;
                ah(obj);
                throw th;
            }
        }
        return str;
    }

    public static String k(File file, File file2) {
        String name;
        if (ShareTinkerInternals.dSr()) {
            try {
                String dSs = ShareTinkerInternals.dSs();
                File parentFile = file.getParentFile();
                name = file.getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    name = name.substring(0, lastIndexOf);
                }
                return parentFile.getAbsolutePath() + "/oat/" + dSs + "/" + name + ".odex";
            } catch (Exception e) {
                throw new TinkerRuntimeException("getCurrentInstructionSet fail:", e);
            }
        }
        name = file.getName();
        if (!name.endsWith(".dex")) {
            int lastIndexOf2 = name.lastIndexOf(".");
            if (lastIndexOf2 < 0) {
                name = name + ".dex";
            } else {
                StringBuilder stringBuilder = new StringBuilder(lastIndexOf2 + 4);
                stringBuilder.append(name, 0, lastIndexOf2);
                stringBuilder.append(".dex");
                name = stringBuilder.toString();
            }
        }
        return new File(file2, name).getPath();
    }

    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    public static boolean i(File file, String str) {
        Throwable th;
        Throwable th2;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("resources.arsc");
                if (entry == null) {
                    a(zipFile2);
                    return false;
                }
                InputStream inputStream = zipFile2.getInputStream(entry);
                String M = M(inputStream);
                if (M == null || !M.equals(str)) {
                    ah(inputStream);
                    a(zipFile2);
                    return false;
                }
                ah(inputStream);
                a(zipFile2);
                return true;
            } catch (Throwable th3) {
                th2 = th3;
                zipFile = zipFile2;
                a(zipFile);
                throw th2;
            }
        } catch (Throwable th4) {
            th = th4;
            try {
                new StringBuilder("checkResourceArscMd5 throwable:").append(th.getMessage());
                a(zipFile);
                return false;
            } catch (Throwable th5) {
                th2 = th5;
                a(zipFile);
                throw th2;
            }
        }
    }

    public static void au(File file) {
        if (file != null) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
    }
}
