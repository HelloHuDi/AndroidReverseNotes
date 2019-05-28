package com.tencent.mm.bq;

import android.os.StatFs;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public final class c {
    private static String akA(String str) {
        AppMethodBeat.i(28269);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(28269);
            return str2;
        }
        str2 = str.replaceAll(" ", "").trim().replaceAll("kB", "").trim().replaceAll("\\t", "").trim();
        AppMethodBeat.o(28269);
        return str2;
    }

    public static String dlN() {
        String replace;
        Throwable th;
        AppMethodBeat.i(28270);
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8"));
            try {
                StringBuilder stringBuilder = new StringBuilder(256);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!bo.isNullOrNil(readLine)) {
                        stringBuilder.append(akA(readLine)).append(';');
                    }
                }
                replace = stringBuilder.toString().replace(',', '_');
                bo.b(bufferedReader);
                AppMethodBeat.o(28270);
            } catch (Throwable th2) {
                th = th2;
                try {
                    ab.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", th, "unexpected exception occurred.", new Object[0]);
                    replace = "";
                    bo.b(bufferedReader);
                    AppMethodBeat.o(28270);
                    return replace;
                } catch (Throwable th3) {
                    th = th3;
                    bo.b(bufferedReader);
                    AppMethodBeat.o(28270);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bo.b(bufferedReader);
            AppMethodBeat.o(28270);
            throw th;
        }
        return replace;
    }

    public static String dlO() {
        String replace;
        Throwable th;
        AppMethodBeat.i(28271);
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/meminfo"), "UTF-8"));
            try {
                StringBuilder stringBuilder = new StringBuilder(256);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!bo.isNullOrNil(readLine)) {
                        stringBuilder.append(akA(readLine)).append(';');
                    }
                }
                replace = stringBuilder.toString().replace(',', '_');
                bo.b(bufferedReader);
                AppMethodBeat.o(28271);
            } catch (Throwable th2) {
                th = th2;
                try {
                    ab.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", th, "unexpected exception occurred.", new Object[0]);
                    replace = "";
                    bo.b(bufferedReader);
                    AppMethodBeat.o(28271);
                    return replace;
                } catch (Throwable th3) {
                    th = th3;
                    bo.b(bufferedReader);
                    AppMethodBeat.o(28271);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bo.b(bufferedReader);
            AppMethodBeat.o(28271);
            throw th;
        }
        return replace;
    }

    public static String dlP() {
        AppMethodBeat.i(28272);
        String str = "";
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics = ah.getContext().getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            float f = displayMetrics.density;
            float f2 = displayMetrics.xdpi;
            float f3 = displayMetrics.ydpi;
            str = (((("" + "width:" + String.valueOf(i) + ";") + "height:" + String.valueOf(i2) + ";") + "density:" + String.valueOf(f) + ";") + "xd:" + String.valueOf(f2) + ";") + "yd:" + String.valueOf(f3) + ";";
        } catch (Exception e) {
            ab.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bo.l(e));
        }
        str = str.replace(",", "_");
        AppMethodBeat.o(28272);
        return str;
    }

    public static String getRomInfo() {
        AppMethodBeat.i(28273);
        String str = "";
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str = ((str + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";") + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Exception e) {
            ab.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bo.l(e));
        }
        str = str.replace(",", "_");
        AppMethodBeat.o(28273);
        return str;
    }

    public static String dlQ() {
        AppMethodBeat.i(28274);
        String str = "";
        try {
            StatFs statFs = new StatFs(h.getExternalStorageDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str = ((str + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";") + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Exception e) {
            ab.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bo.l(e));
        }
        str = str.replace(",", "_");
        AppMethodBeat.o(28274);
        return str;
    }

    public static String dlR() {
        AppMethodBeat.i(28275);
        aw.ZK();
        String str = (String) com.tencent.mm.model.c.Ry().get(71, null);
        AppMethodBeat.o(28275);
        return str;
    }
}
