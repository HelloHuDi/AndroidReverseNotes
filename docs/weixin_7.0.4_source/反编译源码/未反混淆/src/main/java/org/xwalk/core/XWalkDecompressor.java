package org.xwalk.core;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.xweb.util.b;
import g.a.b.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class XWalkDecompressor {
    private static final int LZMA_OUTSIZE = 8;
    private static final int LZMA_PROP_SIZE = 5;
    private static final String[] MANDATORY_LIBRARIES = new String[]{"libxwalkcore.so"};
    private static final String[] MANDATORY_RESOURCES = XWalkEnvironment.MANDATORY_RESOURCES;
    private static final int STREAM_BUFFER_SIZE = 1048576;
    private static final String TAG = "XWalkLib";

    public static boolean extractResource(String str, String str2) {
        IOException e;
        Throwable th;
        AppMethodBeat.i(85592);
        Log.i(TAG, "Extract resource from Apk ".concat(String.valueOf(str)));
        long uptimeMillis = SystemClock.uptimeMillis();
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(str);
            try {
                for (String str3 : MANDATORY_RESOURCES) {
                    ZipEntry entry;
                    if (isNativeLibrary(str3)) {
                        entry = zipFile.getEntry("lib" + File.separator + "armeabi" + File.separator + str3);
                    } else if (isAsset(str3)) {
                        entry = zipFile.getEntry("assets" + File.separator + str3);
                    } else {
                        entry = zipFile.getEntry(str3);
                    }
                    if (entry != null) {
                        Log.d(TAG, "Extracting ".concat(String.valueOf(str3)));
                        File file = new File(str2, str3);
                        if (file.isFile() && file.exists()) {
                            file.delete();
                        }
                        extractStreamToFile(zipFile.getInputStream(entry), new File(str2, str3));
                    } else if (isClassesDex(str3)) {
                        Log.i(TAG, str3 + " not found, may be it is new version of package");
                    } else {
                        Log.e(TAG, str3 + " not found");
                        try {
                            zipFile.close();
                        } catch (IOException | NullPointerException e2) {
                        }
                        AppMethodBeat.o(85592);
                        return false;
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException | NullPointerException e3) {
                }
                System.gc();
                Log.d(TAG, "Time to extract : " + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
                AppMethodBeat.o(85592);
                return true;
            } catch (IOException e4) {
                e = e4;
                try {
                    Log.e(TAG, "Extract error:" + e.getLocalizedMessage());
                    try {
                        zipFile.close();
                    } catch (IOException | NullPointerException e5) {
                    }
                    AppMethodBeat.o(85592);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        zipFile.close();
                    } catch (IOException | NullPointerException e6) {
                    }
                    AppMethodBeat.o(85592);
                    throw th;
                }
            }
        } catch (IOException e7) {
            e = e7;
            zipFile = null;
            Log.e(TAG, "Extract error:" + e.getLocalizedMessage());
            zipFile.close();
            AppMethodBeat.o(85592);
            return false;
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            zipFile.close();
            AppMethodBeat.o(85592);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e0 A:{SYNTHETIC, Splitter:B:38:0x00e0} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e5 A:{Catch:{ Exception -> 0x014f }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ea A:{Catch:{ Exception -> 0x014f }} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e0 A:{SYNTHETIC, Splitter:B:38:0x00e0} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e5 A:{Catch:{ Exception -> 0x014f }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ea A:{Catch:{ Exception -> 0x014f }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fa A:{SYNTHETIC, Splitter:B:50:0x00fa} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ff A:{Catch:{ Exception -> 0x0142 }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0104 A:{Catch:{ Exception -> 0x0142 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fa A:{SYNTHETIC, Splitter:B:50:0x00fa} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ff A:{Catch:{ Exception -> 0x0142 }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0104 A:{Catch:{ Exception -> 0x0142 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fa A:{SYNTHETIC, Splitter:B:50:0x00fa} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ff A:{Catch:{ Exception -> 0x0142 }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0104 A:{Catch:{ Exception -> 0x0142 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean decompressDownloadFullZip(String str, int i) {
        InputStream inputStream;
        OutputStream fileOutputStream;
        IOException e;
        Throwable th;
        AppMethodBeat.i(85593);
        Log.i(TAG, "decompress full zip from zip " + str + ",version:" + i);
        long uptimeMillis = SystemClock.uptimeMillis();
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(str);
            try {
                Enumeration entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    String encode = URLEncoder.encode(zipEntry.getName(), "UTF-8");
                    Log.i(TAG, "decompressDownloadFullZip fileName:".concat(String.valueOf(encode)));
                    if (!(encode.contains("../") || encode.contains("..\\") || zipEntry.isDirectory())) {
                        inputStream = zipFile.getInputStream(zipEntry);
                        try {
                            File file;
                            if (encode.equals(XWalkEnvironment.XWALK_CORE_APK_NAME)) {
                                file = new File(XWalkEnvironment.getDownloadApkPath(i));
                            } else {
                                file = new File(XWalkEnvironment.getExtractedCoreFile(i, encode));
                            }
                            if (file.exists()) {
                                file.delete();
                            } else {
                                File parentFile = file.getParentFile();
                                if (!parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                            }
                            fileOutputStream = new FileOutputStream(file);
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = null;
                            if (zipFile != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            AppMethodBeat.o(85593);
                            throw th;
                        }
                        try {
                            byte[] bArr = new byte[STREAM_BUFFER_SIZE];
                            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.close();
                            inputStream.close();
                        } catch (IOException e3) {
                            e = e3;
                            try {
                                Log.e(TAG, "decompressDownloadPatchZip error:" + e.getLocalizedMessage());
                                if (zipFile != null) {
                                    try {
                                        zipFile.close();
                                    } catch (Exception e4) {
                                        AppMethodBeat.o(85593);
                                        return false;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                AppMethodBeat.o(85593);
                                return false;
                            } catch (Throwable th3) {
                                th = th3;
                                if (zipFile != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                AppMethodBeat.o(85593);
                                throw th;
                            }
                        }
                    }
                }
                try {
                    zipFile.close();
                } catch (Exception e5) {
                }
                System.gc();
                Log.d(TAG, "Time to decompress : " + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
                AppMethodBeat.o(85593);
                return true;
            } catch (IOException e6) {
                e = e6;
                fileOutputStream = null;
                inputStream = null;
                Log.e(TAG, "decompressDownloadPatchZip error:" + e.getLocalizedMessage());
                if (zipFile != null) {
                }
                if (fileOutputStream != null) {
                }
                if (inputStream != null) {
                }
                AppMethodBeat.o(85593);
                return false;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                inputStream = null;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (Exception e7) {
                        AppMethodBeat.o(85593);
                        throw th;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                AppMethodBeat.o(85593);
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            fileOutputStream = null;
            inputStream = null;
            zipFile = null;
            Log.e(TAG, "decompressDownloadPatchZip error:" + e.getLocalizedMessage());
            if (zipFile != null) {
            }
            if (fileOutputStream != null) {
            }
            if (inputStream != null) {
            }
            AppMethodBeat.o(85593);
            return false;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            inputStream = null;
            zipFile = null;
            if (zipFile != null) {
            }
            if (fileOutputStream != null) {
            }
            if (inputStream != null) {
            }
            AppMethodBeat.o(85593);
            throw th;
        }
    }

    public static boolean decompressDownloadPatchZip(String str, String str2) {
        IOException e;
        Object obj;
        Throwable th;
        AppMethodBeat.i(85594);
        Log.d(TAG, "decompress from zip ".concat(String.valueOf(str)));
        long uptimeMillis = SystemClock.uptimeMillis();
        ZipFile zipFile;
        Closeable closeable;
        Closeable closeable2;
        try {
            zipFile = new ZipFile(str);
            try {
                Enumeration entries = zipFile.entries();
                closeable = null;
                closeable2 = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        String encode = URLEncoder.encode(zipEntry.getName(), "UTF-8");
                        if (!(encode.contains("../") || encode.contains("..\\") || zipEntry.isDirectory())) {
                            b.tryClose(closeable2);
                            closeable2 = zipFile.getInputStream(zipEntry);
                            File file = new File(str2, encode);
                            if (file.exists()) {
                                file.delete();
                            } else {
                                File parentFile = file.getParentFile();
                                if (!parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                            }
                            b.tryClose(closeable);
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[STREAM_BUFFER_SIZE];
                                for (int read = closeable2.read(bArr); read != -1; read = closeable2.read(bArr)) {
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                closeable = fileOutputStream;
                            } catch (IOException e2) {
                                e = e2;
                                obj = fileOutputStream;
                                try {
                                    Log.e(TAG, "decompressDownloadPatchZip error:" + e.getLocalizedMessage());
                                    try {
                                        zipFile.close();
                                    } catch (IOException | NullPointerException e3) {
                                    }
                                    b.tryClose(closeable);
                                    b.tryClose(closeable2);
                                    AppMethodBeat.o(85594);
                                    return false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        zipFile.close();
                                    } catch (IOException | NullPointerException e4) {
                                    }
                                    b.tryClose(closeable);
                                    b.tryClose(closeable2);
                                    AppMethodBeat.o(85594);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                obj = fileOutputStream;
                                zipFile.close();
                                b.tryClose(closeable);
                                b.tryClose(closeable2);
                                AppMethodBeat.o(85594);
                                throw th;
                            }
                        }
                    } catch (IOException e5) {
                        e = e5;
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException | NullPointerException e6) {
                }
                b.tryClose(closeable);
                b.tryClose(closeable2);
                System.gc();
                Log.d(TAG, "Time to decompress : " + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
                AppMethodBeat.o(85594);
                return true;
            } catch (IOException e7) {
                e = e7;
                closeable = null;
                closeable2 = null;
                Log.e(TAG, "decompressDownloadPatchZip error:" + e.getLocalizedMessage());
                zipFile.close();
                b.tryClose(closeable);
                b.tryClose(closeable2);
                AppMethodBeat.o(85594);
                return false;
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                closeable2 = null;
                zipFile.close();
                b.tryClose(closeable);
                b.tryClose(closeable2);
                AppMethodBeat.o(85594);
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            closeable = null;
            closeable2 = null;
            zipFile = null;
            Log.e(TAG, "decompressDownloadPatchZip error:" + e.getLocalizedMessage());
            zipFile.close();
            b.tryClose(closeable);
            b.tryClose(closeable2);
            AppMethodBeat.o(85594);
            return false;
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            closeable2 = null;
            zipFile = null;
            zipFile.close();
            b.tryClose(closeable);
            b.tryClose(closeable2);
            AppMethodBeat.o(85594);
            throw th;
        }
    }

    private static boolean isNativeLibrary(String str) {
        AppMethodBeat.i(85595);
        boolean endsWith = str.endsWith(".so");
        AppMethodBeat.o(85595);
        return endsWith;
    }

    private static boolean isAsset(String str) {
        AppMethodBeat.i(85596);
        if (str.endsWith(".dat") || str.endsWith(".pak") || str.endsWith(".js")) {
            AppMethodBeat.o(85596);
            return true;
        }
        AppMethodBeat.o(85596);
        return false;
    }

    private static boolean isClassesDex(String str) {
        AppMethodBeat.i(85597);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(85597);
            return false;
        }
        boolean endsWith = str.endsWith(XWalkEnvironment.XWALK_CORE_CLASSES_DEX);
        AppMethodBeat.o(85597);
        return endsWith;
    }

    private static InputStream openRawResource(String str) {
        AppMethodBeat.i(85598);
        Context applicationContext = XWalkEnvironment.getApplicationContext();
        Resources resources = applicationContext.getResources();
        InputStream openRawResource = resources.openRawResource(resources.getIdentifier(str.split("\\.")[0], "raw", applicationContext.getPackageName()));
        AppMethodBeat.o(85598);
        return openRawResource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A:{Catch:{ all -> 0x0043 }} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A:{Catch:{ all -> 0x0043 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void extractLzmaToFile(InputStream inputStream, File file) {
        InputStream bufferedInputStream;
        OutputStream bufferedOutputStream;
        IOException e;
        Throwable th;
        AppMethodBeat.i(85599);
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = null;
                try {
                    if (file.isFile()) {
                    }
                    AppMethodBeat.o(85599);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bufferedOutputStream.flush();
                    } catch (IOException | NullPointerException e3) {
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException | NullPointerException e4) {
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException | NullPointerException e5) {
                    }
                    AppMethodBeat.o(85599);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                bufferedInputStream.close();
                AppMethodBeat.o(85599);
                throw th;
            }
            try {
                byte[] bArr = new byte[5];
                if (bufferedInputStream.read(bArr, 0, 5) != 5) {
                    e = new IOException("Input lzma file is too short");
                    AppMethodBeat.o(85599);
                    throw e;
                }
                a aVar = new a();
                if (aVar.cR(bArr)) {
                    long j = 0;
                    for (int i = 0; i < 8; i++) {
                        int read = bufferedInputStream.read();
                        if (read < 0) {
                            Log.w(TAG, "Can't read stream size");
                        }
                        j |= ((long) read) << (i * 8);
                    }
                    if (aVar.a(bufferedInputStream, bufferedOutputStream, j)) {
                        try {
                            bufferedOutputStream.flush();
                        } catch (IOException | NullPointerException e6) {
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException | NullPointerException e7) {
                        }
                        try {
                            bufferedInputStream.close();
                            AppMethodBeat.o(85599);
                            return;
                        } catch (IOException | NullPointerException e8) {
                            AppMethodBeat.o(85599);
                            return;
                        }
                    }
                    e = new IOException("Error in data stream");
                    AppMethodBeat.o(85599);
                    throw e;
                }
                e = new IOException("Incorrect lzma properties");
                AppMethodBeat.o(85599);
                throw e;
            } catch (IOException e9) {
                e = e9;
                if (file.isFile()) {
                }
                AppMethodBeat.o(85599);
                throw e;
            }
        } catch (IOException e10) {
            e = e10;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            if (file.isFile()) {
                file.delete();
            }
            AppMethodBeat.o(85599);
            throw e;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            bufferedInputStream.close();
            AppMethodBeat.o(85599);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025 A:{Catch:{ all -> 0x002f }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void extractStreamToFile(InputStream inputStream, File file) {
        IOException e;
        Throwable th;
        AppMethodBeat.i(85600);
        OutputStream fileOutputStream;
        try {
            inputStream.available();
            fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[STREAM_BUFFER_SIZE];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read >= 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException | NullPointerException e2) {
                        }
                    }
                }
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException | NullPointerException e3) {
                }
                try {
                    inputStream.close();
                    AppMethodBeat.o(85600);
                } catch (IOException | NullPointerException e4) {
                    AppMethodBeat.o(85600);
                }
            } catch (IOException e5) {
                e = e5;
                try {
                    if (file.isFile()) {
                        file.delete();
                    }
                    AppMethodBeat.o(85600);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        fileOutputStream.flush();
                    } catch (IOException | NullPointerException e6) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException | NullPointerException e7) {
                    }
                    try {
                        inputStream.close();
                    } catch (IOException | NullPointerException e8) {
                    }
                    AppMethodBeat.o(85600);
                    throw th;
                }
            }
        } catch (IOException e9) {
            e = e9;
            fileOutputStream = null;
            if (file.isFile()) {
            }
            AppMethodBeat.o(85600);
            throw e;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            fileOutputStream.flush();
            fileOutputStream.close();
            inputStream.close();
            AppMethodBeat.o(85600);
            throw th;
        }
    }

    public static void copyApkToLocal(String str, String str2) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(85601);
        Log.d(TAG, "Copy to local from Apk ".concat(String.valueOf(str)));
        Closeable fileInputStream;
        Closeable fileOutputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            b.tryClose(fileInputStream);
                            b.tryClose(fileOutputStream);
                            AppMethodBeat.o(85601);
                            return;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.e("copyApkToLocal error:", e.getMessage());
                        b.tryClose(fileInputStream);
                        b.tryClose(fileOutputStream);
                        AppMethodBeat.o(85601);
                    } catch (Throwable th2) {
                        th = th2;
                        b.tryClose(fileInputStream);
                        b.tryClose(fileOutputStream);
                        AppMethodBeat.o(85601);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                Log.e("copyApkToLocal error:", e.getMessage());
                b.tryClose(fileInputStream);
                b.tryClose(fileOutputStream);
                AppMethodBeat.o(85601);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                b.tryClose(fileInputStream);
                b.tryClose(fileOutputStream);
                AppMethodBeat.o(85601);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            fileInputStream = null;
            Log.e("copyApkToLocal error:", e.getMessage());
            b.tryClose(fileInputStream);
            b.tryClose(fileOutputStream);
            AppMethodBeat.o(85601);
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            fileInputStream = null;
            b.tryClose(fileInputStream);
            b.tryClose(fileOutputStream);
            AppMethodBeat.o(85601);
            throw th;
        }
    }
}
