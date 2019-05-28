package com.tencent.mm.compatible.e;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;

public final class m {
    static int esL = 0;
    static String esM = null;

    public static int Lw() {
        int i;
        int i2 = 15;
        AppMethodBeat.i(92941);
        int i3 = n.LD() ? 7 : n.LE() ? 3 : 1;
        if (q.etb.esO && q.etb.esQ == 0) {
            ab.d("MicroMsg.CpuChecker", "disable armv6 by server ");
            i3 &= -3;
        }
        if (q.etb.esO && q.etb.esP == 0) {
            ab.d("MicroMsg.CpuChecker", "disable armv7 by server ");
            i3 &= -5;
        }
        int numCores = n.getNumCores();
        if (numCores > 16) {
            numCores = 15;
        } else if (numCores <= 0) {
            numCores = 1;
        }
        int i4 = bo.getInt(Lx(), 0) / 1000;
        if (numCores > 4) {
            i = i4 * 4;
        } else if (numCores > 2) {
            i = i4 * 2;
        } else if (numCores > 1) {
            i = (i4 * 3) >> 1;
        } else {
            i = i4;
        }
        i /= 100;
        if (i > 30) {
            i = 30;
        } else if (i < 5) {
            i = 5;
        }
        if (i > 5 || numCores < 4) {
            i2 = i;
        }
        i3 = ((i3 + (numCores << 4)) << 8) + i2;
        esL = i3;
        AppMethodBeat.o(92941);
        return i3;
    }

    public static String Lx() {
        Throwable th;
        AppMethodBeat.i(92942);
        Closeable bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            try {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    NullPointerException nullPointerException = new NullPointerException("null was returned while reading cpuinfo_max_freq.");
                    AppMethodBeat.o(92942);
                    throw nullPointerException;
                }
                readLine = readLine.trim();
                bo.b(bufferedReader);
                AppMethodBeat.o(92942);
                return readLine;
            } catch (Throwable th2) {
                th = th2;
                try {
                    ab.printErrStackTrace("MicroMsg.CpuChecker", th, "unexpected exception occurred.", new Object[0]);
                    readLine = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    bo.b(bufferedReader);
                    AppMethodBeat.o(92942);
                    return readLine;
                } catch (Throwable th3) {
                    th = th3;
                    bo.b(bufferedReader);
                    AppMethodBeat.o(92942);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bo.b(bufferedReader);
            AppMethodBeat.o(92942);
            throw th;
        }
    }

    public static String Ly() {
        Throwable th;
        AppMethodBeat.i(92943);
        Closeable bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"));
            try {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    NullPointerException nullPointerException = new NullPointerException("null was returned while reading cpuinfo_min_freq.");
                    AppMethodBeat.o(92943);
                    throw nullPointerException;
                }
                readLine = readLine.trim();
                bo.b(bufferedReader);
                AppMethodBeat.o(92943);
                return readLine;
            } catch (Throwable th2) {
                th = th2;
                try {
                    ab.printErrStackTrace("MicroMsg.CpuChecker", th, "unexpected exception occurred.", new Object[0]);
                    readLine = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    bo.b(bufferedReader);
                    AppMethodBeat.o(92943);
                    return readLine;
                } catch (Throwable th3) {
                    th = th3;
                    bo.b(bufferedReader);
                    AppMethodBeat.o(92943);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bo.b(bufferedReader);
            AppMethodBeat.o(92943);
            throw th;
        }
    }

    public static String Lz() {
        Throwable e;
        AppMethodBeat.i(92944);
        Closeable bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
            try {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    NullPointerException nullPointerException = new NullPointerException("null was returned while reading scaling_cur_freq.");
                    AppMethodBeat.o(92944);
                    throw nullPointerException;
                }
                readLine = readLine.trim();
                bo.b(bufferedReader);
                AppMethodBeat.o(92944);
                return readLine;
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.printErrStackTrace("MicroMsg.CpuChecker", e, "unexpected exception occurred.", new Object[0]);
                    readLine = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    bo.b(bufferedReader);
                    AppMethodBeat.o(92944);
                    return readLine;
                } catch (Throwable th) {
                    e = th;
                    bo.b(bufferedReader);
                    AppMethodBeat.o(92944);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            ab.printErrStackTrace("MicroMsg.CpuChecker", e, "unexpected exception occurred.", new Object[0]);
            readLine = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            bo.b(bufferedReader);
            AppMethodBeat.o(92944);
            return readLine;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bo.b(bufferedReader);
            AppMethodBeat.o(92944);
            throw e;
        }
    }
}
