package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.map.lib.C1015d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hk */
public class C24387hk {
    /* renamed from: a */
    static final /* synthetic */ boolean f4733a = (!C24387hk.class.desiredAssertionStatus());
    /* renamed from: b */
    private static boolean f4734b = false;

    static {
        AppMethodBeat.m2504i(99550);
        AppMethodBeat.m2505o(99550);
    }

    /* renamed from: a */
    static boolean m37836a(Context context, String str) {
        AppMethodBeat.m2504i(99544);
        if (f4733a || context != null) {
            File b = C24387hk.m37837b(context, str);
            boolean exists = b.exists();
            C1015d.m2288a("libary:" + b.getAbsolutePath() + " is exist:" + exists);
            if (exists || C24387hk.m37838b(context)) {
                try {
                    System.load(b.getAbsolutePath());
                    AppMethodBeat.m2505o(99544);
                    return true;
                } catch (UnsatisfiedLinkError e) {
                    AppMethodBeat.m2505o(99544);
                    return false;
                }
            }
            AppMethodBeat.m2505o(99544);
            return false;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(99544);
        throw assertionError;
    }

    /* renamed from: a */
    public static File m37833a(Context context) {
        AppMethodBeat.m2504i(99545);
        File file = new File(context.getApplicationInfo().nativeLibraryDir);
        AppMethodBeat.m2505o(99545);
        return file;
    }

    /* renamed from: b */
    private static File m37837b(Context context, String str) {
        AppMethodBeat.m2504i(99546);
        File file = new File(C24387hk.m37833a(context), System.mapLibraryName(str));
        AppMethodBeat.m2505o(99546);
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00dd A:{SYNTHETIC, Splitter:B:47:0x00dd} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e2 A:{SYNTHETIC, Splitter:B:50:0x00e2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static boolean m37838b(Context context) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        AppMethodBeat.m2504i(99547);
        if (f4734b) {
            AppMethodBeat.m2505o(99547);
            return false;
        }
        f4734b = true;
        File a = C24387hk.m37833a(context);
        C24387hk.m37835a(a);
        ZipFile zipFile;
        File b;
        IOException iOException;
        try {
            zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
            String[] strArr = C44521hj.f17435a;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                ZipEntry a2 = C24387hk.m37834a(zipFile, str);
                if (a2 == null) {
                    zipFile.close();
                    C24387hk.m37835a(a);
                    AppMethodBeat.m2505o(99547);
                    return false;
                }
                b = C24387hk.m37837b(context, str);
                C1015d.m2288a("Extracting native libraries into " + b.getAbsolutePath());
                if (!f4733a && b.exists()) {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.m2505o(99547);
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
                            AppMethodBeat.m2505o(99547);
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
                            AppMethodBeat.m2505o(99547);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                        inputStream = null;
                    }
                } else {
                    iOException = new IOException();
                    AppMethodBeat.m2505o(99547);
                    throw iOException;
                }
            }
            zipFile.close();
            AppMethodBeat.m2505o(99547);
            return true;
        } catch (IOException iOException2) {
            if (b.exists() && !b.delete()) {
                C1015d.m2290b("Failed to delete " + b.getAbsolutePath());
            }
            zipFile.close();
            AppMethodBeat.m2505o(99547);
            throw iOException2;
        } catch (IOException iOException22) {
            C1015d.m2289a("Failed to unpack native libraries", iOException22);
            C24387hk.m37835a(a);
            AppMethodBeat.m2505o(99547);
            return false;
        } catch (Throwable th5) {
            fileOutputStream.close();
            AppMethodBeat.m2505o(99547);
        }
    }

    /* renamed from: a */
    private static ZipEntry m37834a(ZipFile zipFile, String str) {
        AppMethodBeat.m2504i(99548);
        ZipEntry entry = zipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(str));
        if (entry != null) {
            AppMethodBeat.m2505o(99548);
            return entry;
        }
        entry = zipFile.getEntry("lib/" + Build.CPU_ABI2 + "/" + System.mapLibraryName(str));
        AppMethodBeat.m2505o(99548);
        return entry;
    }

    /* renamed from: a */
    private static void m37835a(File file) {
        AppMethodBeat.m2504i(99549);
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.getName();
                    if (!file2.delete()) {
                        C1015d.m2290b("Failed to remove " + file2.getAbsolutePath());
                    }
                }
            }
            if (!file.delete()) {
                C1015d.m2290b("Failed to remove " + file.getAbsolutePath());
            }
            AppMethodBeat.m2505o(99549);
        } catch (Exception e) {
            C1015d.m2289a("Failed to remove old libs, ", e);
            AppMethodBeat.m2505o(99549);
        }
    }
}
