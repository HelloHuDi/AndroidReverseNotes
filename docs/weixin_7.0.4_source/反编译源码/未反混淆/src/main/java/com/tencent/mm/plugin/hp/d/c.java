package com.tencent.mm.plugin.hp.d;

import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class c {

    public interface a {
        void a(boolean z, b bVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @Deprecated
    public static boolean bGz() {
        long blockSize;
        AppMethodBeat.i(90682);
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            try {
                blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            } catch (Exception e) {
                blockSize = 0;
                if (blockSize != 0) {
                }
                AppMethodBeat.o(90682);
                return false;
            }
        } catch (Exception e2) {
            availableBlocks = 0;
            blockSize = 0;
            if (blockSize != 0) {
            }
            AppMethodBeat.o(90682);
            return false;
        }
        if (blockSize != 0 || availableBlocks <= 83886080) {
            AppMethodBeat.o(90682);
            return false;
        }
        AppMethodBeat.o(90682);
        return true;
    }

    public static boolean OH(String str) {
        AppMethodBeat.i(90683);
        if (!bo.isNullOrNil(str) && str.length() == 10) {
            try {
                int intValue = Integer.decode(str).intValue();
                if ((intValue & 255) < 0 || (intValue & 255) > 31) {
                    AppMethodBeat.o(90683);
                    return false;
                }
                AppMethodBeat.o(90683);
                return true;
            } catch (Exception e) {
                ab.printErrStackTrace("Tinker.TinkerUtils", e, "checkAplhVersion failed.", new Object[0]);
            }
        }
        AppMethodBeat.o(90683);
        return false;
    }

    public static String OI(String str) {
        AppMethodBeat.i(90684);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(90684);
            return str2;
        }
        str2 = new String(Base64.decode(str, 0));
        AppMethodBeat.o(90684);
        return str2;
    }

    public static Properties S(File file) {
        Throwable th;
        IOException e;
        ZipFile zipFile;
        AppMethodBeat.i(90685);
        if (!file.isFile() || file.length() == 0) {
            AppMethodBeat.o(90685);
            return null;
        }
        ZipFile zipFile2;
        try {
            zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("assets/package_meta.txt");
                if (entry == null) {
                    SharePatchFileUtil.a(zipFile2);
                    AppMethodBeat.o(90685);
                    return null;
                }
                Object inputStream;
                try {
                    inputStream = zipFile2.getInputStream(entry);
                    try {
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        SharePatchFileUtil.ah(inputStream);
                        SharePatchFileUtil.a(zipFile2);
                        AppMethodBeat.o(90685);
                        return properties;
                    } catch (Throwable th2) {
                        th = th2;
                        SharePatchFileUtil.ah(inputStream);
                        AppMethodBeat.o(90685);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
            } catch (IOException e2) {
                e = e2;
                zipFile = zipFile2;
            } catch (Throwable th4) {
                th = th4;
                SharePatchFileUtil.a(zipFile2);
                AppMethodBeat.o(90685);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            zipFile = null;
            try {
                new StringBuilder("fastGetPatchPackageMeta exception:").append(e.getMessage());
                SharePatchFileUtil.a(zipFile);
                AppMethodBeat.o(90685);
                return null;
            } catch (Throwable th42) {
                th = th42;
                zipFile2 = zipFile;
                SharePatchFileUtil.a(zipFile2);
                AppMethodBeat.o(90685);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            zipFile2 = null;
            SharePatchFileUtil.a(zipFile2);
            AppMethodBeat.o(90685);
            throw th;
        }
    }
}
