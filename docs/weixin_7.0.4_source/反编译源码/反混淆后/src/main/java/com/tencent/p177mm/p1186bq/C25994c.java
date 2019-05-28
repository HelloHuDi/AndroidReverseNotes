package com.tencent.p177mm.p1186bq;

import android.os.StatFs;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* renamed from: com.tencent.mm.bq.c */
public final class C25994c {
    private static String akA(String str) {
        AppMethodBeat.m2504i(28269);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(28269);
            return str2;
        }
        str2 = str.replaceAll(" ", "").trim().replaceAll("kB", "").trim().replaceAll("\\t", "").trim();
        AppMethodBeat.m2505o(28269);
        return str2;
    }

    public static String dlN() {
        String replace;
        Throwable th;
        AppMethodBeat.m2504i(28270);
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8"));
            try {
                StringBuilder stringBuilder = new StringBuilder(256);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!C5046bo.isNullOrNil(readLine)) {
                        stringBuilder.append(C25994c.akA(readLine)).append(';');
                    }
                }
                replace = stringBuilder.toString().replace(',', '_');
                C5046bo.m7527b(bufferedReader);
                AppMethodBeat.m2505o(28270);
            } catch (Throwable th2) {
                th = th2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", th, "unexpected exception occurred.", new Object[0]);
                    replace = "";
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(28270);
                    return replace;
                } catch (Throwable th3) {
                    th = th3;
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(28270);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            C5046bo.m7527b(bufferedReader);
            AppMethodBeat.m2505o(28270);
            throw th;
        }
        return replace;
    }

    public static String dlO() {
        String replace;
        Throwable th;
        AppMethodBeat.m2504i(28271);
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/meminfo"), "UTF-8"));
            try {
                StringBuilder stringBuilder = new StringBuilder(256);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!C5046bo.isNullOrNil(readLine)) {
                        stringBuilder.append(C25994c.akA(readLine)).append(';');
                    }
                }
                replace = stringBuilder.toString().replace(',', '_');
                C5046bo.m7527b(bufferedReader);
                AppMethodBeat.m2505o(28271);
            } catch (Throwable th2) {
                th = th2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", th, "unexpected exception occurred.", new Object[0]);
                    replace = "";
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(28271);
                    return replace;
                } catch (Throwable th3) {
                    th = th3;
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(28271);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            C5046bo.m7527b(bufferedReader);
            AppMethodBeat.m2505o(28271);
            throw th;
        }
        return replace;
    }

    public static String dlP() {
        AppMethodBeat.m2504i(28272);
        String str = "";
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics = C4996ah.getContext().getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            float f = displayMetrics.density;
            float f2 = displayMetrics.xdpi;
            float f3 = displayMetrics.ydpi;
            str = (((("" + "width:" + String.valueOf(i) + ";") + "height:" + String.valueOf(i2) + ";") + "density:" + String.valueOf(f) + ";") + "xd:" + String.valueOf(f2) + ";") + "yd:" + String.valueOf(f3) + ";";
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.PostTaskHardwareInfo", "exception:%s", C5046bo.m7574l(e));
        }
        str = str.replace(",", "_");
        AppMethodBeat.m2505o(28272);
        return str;
    }

    public static String getRomInfo() {
        AppMethodBeat.m2504i(28273);
        String str = "";
        try {
            StatFs statFs = new StatFs(C1448h.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str = ((str + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";") + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.PostTaskHardwareInfo", "exception:%s", C5046bo.m7574l(e));
        }
        str = str.replace(",", "_");
        AppMethodBeat.m2505o(28273);
        return str;
    }

    public static String dlQ() {
        AppMethodBeat.m2504i(28274);
        String str = "";
        try {
            StatFs statFs = new StatFs(C1448h.getExternalStorageDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str = ((str + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";") + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.PostTaskHardwareInfo", "exception:%s", C5046bo.m7574l(e));
        }
        str = str.replace(",", "_");
        AppMethodBeat.m2505o(28274);
        return str;
    }

    public static String dlR() {
        AppMethodBeat.m2504i(28275);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(71, null);
        AppMethodBeat.m2505o(28275);
        return str;
    }
}
