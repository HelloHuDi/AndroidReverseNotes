package com.tencent.p177mm.p213cd;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.cd.b */
public final class C1357b {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c6 A:{SYNTHETIC, Splitter:B:26:0x00c6} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d0 A:{SYNTHETIC, Splitter:B:32:0x00d0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static String dvn() {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(59032);
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        String str = "";
        String str2 = "";
        String str3 = "";
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/mounts"));
            try {
                Pattern compile = Pattern.compile("\\s+");
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = compile.split(readLine);
                    if (split.length >= 3 && split[1].equals(absolutePath)) {
                        str = split[2];
                        if (split.length > 3) {
                            str3 = split[3];
                        }
                    }
                }
                if (new StatFs(absolutePath).getBlockSize() > 0) {
                    str2 = String.format("blockSize: %d, blocks: %d / %d", new Object[]{Integer.valueOf(new StatFs(absolutePath).getBlockSize()), Integer.valueOf(new StatFs(absolutePath).getAvailableBlocks()), Integer.valueOf(new StatFs(absolutePath).getBlockCount())});
                }
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.m7412e("MicroMsg.DBUtils", "Cannot gather file system info: " + e.getMessage());
                    if (bufferedReader != null) {
                    }
                    str3 = str + 10 + str2 + 10 + str3;
                    AppMethodBeat.m2505o(59032);
                    return str3;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.m2505o(59032);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
            C4990ab.m7412e("MicroMsg.DBUtils", "Cannot gather file system info: " + e.getMessage());
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                }
            }
            str3 = str + 10 + str2 + 10 + str3;
            AppMethodBeat.m2505o(59032);
            return str3;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.m2505o(59032);
            throw th;
        }
        str3 = str + 10 + str2 + 10 + str3;
        AppMethodBeat.m2505o(59032);
        return str3;
    }
}
