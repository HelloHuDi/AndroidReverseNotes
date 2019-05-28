package com.tencent.p177mm.sdk.platformtools;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.recovery.Recovery;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.sdk.platformtools.CrashMonitorForJni */
public class CrashMonitorForJni {
    private static final String TAG = "MicroMsg.CrashMonitorForJni";
    private static C4979a sCrashExtraMessageGetter;

    /* renamed from: com.tencent.mm.sdk.platformtools.CrashMonitorForJni$a */
    public interface C4979a {
        /* renamed from: Bu */
        String mo10218Bu();
    }

    public static native void setClientVersionMsg(String str);

    public static void setCrashExtraMessageGetter(C4979a c4979a) {
        sCrashExtraMessageGetter = c4979a;
    }

    private static void OnCrash(int i, int i2, String str) {
        AppMethodBeat.m2504i(126235);
        Recovery.dPW();
        new StringBuilder("OnCrash sig:").append(i).append("  stack:").append(str);
        C4872b.m7237g(i, str);
        AppMethodBeat.m2505o(126235);
    }

    private static CharSequence getAllThreadJavaStack() {
        AppMethodBeat.m2504i(126236);
        StringBuilder stringBuilder = new StringBuilder(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        StringBuilder stringBuilder2 = new StringBuilder(2048);
        for (Entry entry : Thread.getAllStackTraces().entrySet()) {
            Thread thread = (Thread) entry.getKey();
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry.getValue();
            stringBuilder2.setLength(0);
            stringBuilder2.append("\n (").append(thread.getId()).append(") [").append(thread.getName()).append("] ************\n");
            int i = 0;
            for (int i2 = 0; i2 < stackTraceElementArr.length; i2++) {
                if (stackTraceElementArr[i2].toString().startsWith("com.tencent.mm.")) {
                    i = 1;
                }
                stringBuilder2.append("\tat ").append(stackTraceElementArr[i2].toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            if (i != 0) {
                stringBuilder.append(stringBuilder2);
            }
        }
        AppMethodBeat.m2505o(126236);
        return stringBuilder;
    }

    public static String getCrashThreadJavaStack() {
        AppMethodBeat.m2504i(126237);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        C4979a c4979a = sCrashExtraMessageGetter;
        if (c4979a != null) {
            printWriter.append(IOUtils.LINE_SEPARATOR_UNIX);
            printWriter.append(c4979a.mo10218Bu());
            printWriter.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        Throwable th = new Throwable("\n******* Java stack for JNI crash *******");
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace.length > 1) {
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[(stackTrace.length - 1)];
            for (int i = 0; i < stackTraceElementArr.length; i++) {
                stackTraceElementArr[i] = stackTrace[i + 1];
            }
            th.setStackTrace(stackTraceElementArr);
        }
        th.printStackTrace(printWriter);
        printWriter.append(CrashMonitorForJni.getAllThreadJavaStack());
        printWriter.append(10);
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.m2505o(126237);
        return stringWriter2;
    }
}
