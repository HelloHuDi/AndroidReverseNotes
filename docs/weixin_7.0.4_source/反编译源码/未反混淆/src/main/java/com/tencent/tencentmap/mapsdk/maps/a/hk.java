package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.map.lib.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class hk {
    static final /* synthetic */ boolean a = (!hk.class.desiredAssertionStatus());
    private static boolean b = false;

    static {
        AppMethodBeat.i(99550);
        AppMethodBeat.o(99550);
    }

    static boolean a(Context context, String str) {
        AppMethodBeat.i(99544);
        if (a || context != null) {
            File b = b(context, str);
            boolean exists = b.exists();
            d.a("libary:" + b.getAbsolutePath() + " is exist:" + exists);
            if (exists || b(context)) {
                try {
                    System.load(b.getAbsolutePath());
                    AppMethodBeat.o(99544);
                    return true;
                } catch (UnsatisfiedLinkError e) {
                    AppMethodBeat.o(99544);
                    return false;
                }
            }
            AppMethodBeat.o(99544);
            return false;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(99544);
        throw assertionError;
    }

    public static File a(Context context) {
        AppMethodBeat.i(99545);
        File file = new File(context.getApplicationInfo().nativeLibraryDir);
        AppMethodBeat.o(99545);
        return file;
    }

    private static File b(Context context, String str) {
        AppMethodBeat.i(99546);
        File file = new File(a(context), System.mapLibraryName(str));
        AppMethodBeat.o(99546);
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00dd A:{SYNTHETIC, Splitter:B:47:0x00dd} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e2 A:{SYNTHETIC, Splitter:B:50:0x00e2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(Context context) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        AppMethodBeat.i(99547);
        if (b) {
            AppMethodBeat.o(99547);
            return false;
        }
        b = true;
        File a = a(context);
        a(a);
        ZipFile zipFile;
        File b;
        IOException iOException;
        try {
            zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
            String[] strArr = hj.a;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                ZipEntry a2 = a(zipFile, str);
                if (a2 == null) {
                    zipFile.close();
                    a(a);
                    AppMethodBeat.o(99547);
                    return false;
                }
                b = b(context, str);
                d.a("Extracting native libraries into " + b.getAbsolutePath());
                if (!a && b.exists()) {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(99547);
                    throw assertionError;
                } else if (b.createNewFile()) {
                    try {
                        inputStream = zipFile.getInputStream(a2);
                        try {
                            fileOutputStream = new FileOutputStream(b);
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = null;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            AppMethodBeat.o(99547);
                            throw th;
                        }
                        try {
                            byte[] bArr = new byte[16384];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            fileOutputStream.close();
                            if (VERSION.SDK_INT >= 9) {
                                b.setReadable(true, false);
                                b.setExecutable(true, false);
                                b.setWritable(true);
                            }
                            i++;
                        } catch (Throwable th3) {
                            th = th3;
                            if (inputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.o(99547);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                        inputStream = null;
                    }
                } else {
                    iOException = new IOException();
                    AppMethodBeat.o(99547);
                    throw iOException;
                }
            }
            zipFile.close();
            AppMethodBeat.o(99547);
            return true;
        } catch (IOException iOException2) {
            if (b.exists() && !b.delete()) {
                d.b("Failed to delete " + b.getAbsolutePath());
            }
            zipFile.close();
            AppMethodBeat.o(99547);
            throw iOException2;
        } catch (IOException iOException22) {
            d.a("Failed to unpack native libraries", iOException22);
            a(a);
            AppMethodBeat.o(99547);
            return false;
        } catch (Throwable th5) {
            fileOutputStream.close();
            AppMethodBeat.o(99547);
        }
    }

    private static ZipEntry a(ZipFile zipFile, String str) {
        AppMethodBeat.i(99548);
        ZipEntry entry = zipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(str));
        if (entry != null) {
            AppMethodBeat.o(99548);
            return entry;
        }
        entry = zipFile.getEntry("lib/" + Build.CPU_ABI2 + "/" + System.mapLibraryName(str));
        AppMethodBeat.o(99548);
        return entry;
    }

    private static void a(File file) {
        AppMethodBeat.i(99549);
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.getName();
                    if (!file2.delete()) {
                        d.b("Failed to remove " + file2.getAbsolutePath());
                    }
                }
            }
            if (!file.delete()) {
                d.b("Failed to remove " + file.getAbsolutePath());
            }
            AppMethodBeat.o(99549);
        } catch (Exception e) {
            d.a("Failed to remove old libs, ", e);
            AppMethodBeat.o(99549);
        }
    }
}
