package com.tencent.p177mm.compatible.p221e;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;

/* renamed from: com.tencent.mm.compatible.e.m */
public final class C45290m {
    static int esL = 0;
    static String esM = null;

    /* renamed from: Lw */
    public static int m83509Lw() {
        int i;
        int i2 = 15;
        AppMethodBeat.m2504i(92941);
        int i3 = C1422n.m3014LD() ? 7 : C1422n.m3015LE() ? 3 : 1;
        if (C1427q.etb.esO && C1427q.etb.esQ == 0) {
            C4990ab.m7410d("MicroMsg.CpuChecker", "disable armv6 by server ");
            i3 &= -3;
        }
        if (C1427q.etb.esO && C1427q.etb.esP == 0) {
            C4990ab.m7410d("MicroMsg.CpuChecker", "disable armv7 by server ");
            i3 &= -5;
        }
        int numCores = C1422n.getNumCores();
        if (numCores > 16) {
            numCores = 15;
        } else if (numCores <= 0) {
            numCores = 1;
        }
        int i4 = C5046bo.getInt(C45290m.m83510Lx(), 0) / 1000;
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
        AppMethodBeat.m2505o(92941);
        return i3;
    }

    /* renamed from: Lx */
    public static String m83510Lx() {
        Throwable th;
        AppMethodBeat.m2504i(92942);
        Closeable bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            try {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    NullPointerException nullPointerException = new NullPointerException("null was returned while reading cpuinfo_max_freq.");
                    AppMethodBeat.m2505o(92942);
                    throw nullPointerException;
                }
                readLine = readLine.trim();
                C5046bo.m7527b(bufferedReader);
                AppMethodBeat.m2505o(92942);
                return readLine;
            } catch (Throwable th2) {
                th = th2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.CpuChecker", th, "unexpected exception occurred.", new Object[0]);
                    readLine = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(92942);
                    return readLine;
                } catch (Throwable th3) {
                    th = th3;
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(92942);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            C5046bo.m7527b(bufferedReader);
            AppMethodBeat.m2505o(92942);
            throw th;
        }
    }

    /* renamed from: Ly */
    public static String m83511Ly() {
        Throwable th;
        AppMethodBeat.m2504i(92943);
        Closeable bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"));
            try {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    NullPointerException nullPointerException = new NullPointerException("null was returned while reading cpuinfo_min_freq.");
                    AppMethodBeat.m2505o(92943);
                    throw nullPointerException;
                }
                readLine = readLine.trim();
                C5046bo.m7527b(bufferedReader);
                AppMethodBeat.m2505o(92943);
                return readLine;
            } catch (Throwable th2) {
                th = th2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.CpuChecker", th, "unexpected exception occurred.", new Object[0]);
                    readLine = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(92943);
                    return readLine;
                } catch (Throwable th3) {
                    th = th3;
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(92943);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            C5046bo.m7527b(bufferedReader);
            AppMethodBeat.m2505o(92943);
            throw th;
        }
    }

    /* renamed from: Lz */
    public static String m83512Lz() {
        Throwable e;
        AppMethodBeat.m2504i(92944);
        Closeable bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
            try {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    NullPointerException nullPointerException = new NullPointerException("null was returned while reading scaling_cur_freq.");
                    AppMethodBeat.m2505o(92944);
                    throw nullPointerException;
                }
                readLine = readLine.trim();
                C5046bo.m7527b(bufferedReader);
                AppMethodBeat.m2505o(92944);
                return readLine;
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.CpuChecker", e, "unexpected exception occurred.", new Object[0]);
                    readLine = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(92944);
                    return readLine;
                } catch (Throwable th) {
                    e = th;
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(92944);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            C4990ab.printErrStackTrace("MicroMsg.CpuChecker", e, "unexpected exception occurred.", new Object[0]);
            readLine = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            C5046bo.m7527b(bufferedReader);
            AppMethodBeat.m2505o(92944);
            return readLine;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            C5046bo.m7527b(bufferedReader);
            AppMethodBeat.m2505o(92944);
            throw e;
        }
    }
}
