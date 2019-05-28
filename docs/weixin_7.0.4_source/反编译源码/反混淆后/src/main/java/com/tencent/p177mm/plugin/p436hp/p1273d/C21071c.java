package com.tencent.p177mm.plugin.p436hp.p1273d;

import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.tencent.mm.plugin.hp.d.c */
public final class C21071c {

    /* renamed from: com.tencent.mm.plugin.hp.d.c$a */
    public interface C21072a {
        /* renamed from: a */
        void mo36393a(boolean z, C28317b c28317b);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @Deprecated
    public static boolean bGz() {
        long blockSize;
        AppMethodBeat.m2504i(90682);
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
                AppMethodBeat.m2505o(90682);
                return false;
            }
        } catch (Exception e2) {
            availableBlocks = 0;
            blockSize = 0;
            if (blockSize != 0) {
            }
            AppMethodBeat.m2505o(90682);
            return false;
        }
        if (blockSize != 0 || availableBlocks <= 83886080) {
            AppMethodBeat.m2505o(90682);
            return false;
        }
        AppMethodBeat.m2505o(90682);
        return true;
    }

    /* renamed from: OH */
    public static boolean m32374OH(String str) {
        AppMethodBeat.m2504i(90683);
        if (!C5046bo.isNullOrNil(str) && str.length() == 10) {
            try {
                int intValue = Integer.decode(str).intValue();
                if ((intValue & 255) < 0 || (intValue & 255) > 31) {
                    AppMethodBeat.m2505o(90683);
                    return false;
                }
                AppMethodBeat.m2505o(90683);
                return true;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("Tinker.TinkerUtils", e, "checkAplhVersion failed.", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(90683);
        return false;
    }

    /* renamed from: OI */
    public static String m32375OI(String str) {
        AppMethodBeat.m2504i(90684);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(90684);
            return str2;
        }
        str2 = new String(Base64.decode(str, 0));
        AppMethodBeat.m2505o(90684);
        return str2;
    }

    /* renamed from: S */
    public static Properties m32376S(File file) {
        Throwable th;
        IOException e;
        ZipFile zipFile;
        AppMethodBeat.m2504i(90685);
        if (!file.isFile() || file.length() == 0) {
            AppMethodBeat.m2505o(90685);
            return null;
        }
        ZipFile zipFile2;
        try {
            zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("assets/package_meta.txt");
                if (entry == null) {
                    SharePatchFileUtil.m9368a(zipFile2);
                    AppMethodBeat.m2505o(90685);
                    return null;
                }
                Object inputStream;
                try {
                    inputStream = zipFile2.getInputStream(entry);
                    try {
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        SharePatchFileUtil.m9369ah(inputStream);
                        SharePatchFileUtil.m9368a(zipFile2);
                        AppMethodBeat.m2505o(90685);
                        return properties;
                    } catch (Throwable th2) {
                        th = th2;
                        SharePatchFileUtil.m9369ah(inputStream);
                        AppMethodBeat.m2505o(90685);
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
                SharePatchFileUtil.m9368a(zipFile2);
                AppMethodBeat.m2505o(90685);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            zipFile = null;
            try {
                new StringBuilder("fastGetPatchPackageMeta exception:").append(e.getMessage());
                SharePatchFileUtil.m9368a(zipFile);
                AppMethodBeat.m2505o(90685);
                return null;
            } catch (Throwable th42) {
                th = th42;
                zipFile2 = zipFile;
                SharePatchFileUtil.m9368a(zipFile2);
                AppMethodBeat.m2505o(90685);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            zipFile2 = null;
            SharePatchFileUtil.m9368a(zipFile2);
            AppMethodBeat.m2505o(90685);
            throw th;
        }
    }
}
