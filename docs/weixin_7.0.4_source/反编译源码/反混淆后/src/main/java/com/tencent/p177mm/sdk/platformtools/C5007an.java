package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* renamed from: com.tencent.mm.sdk.platformtools.an */
public final class C5007an {
    public final String toString() {
        AppMethodBeat.m2504i(52152);
        String doR = C5007an.doR();
        AppMethodBeat.m2505o(52152);
        return doR;
    }

    public static String doQ() {
        AppMethodBeat.m2504i(52153);
        String str;
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace == null || stackTrace.length < 3) {
                str = "";
                AppMethodBeat.m2505o(52153);
                return str;
            }
            str = (stackTrace[2].getClassName().substring(15) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + stackTrace[2].getMethodName()) + "(" + stackTrace[2].getLineNumber() + ")";
            AppMethodBeat.m2505o(52153);
            return str;
        } catch (Throwable th) {
            C4990ab.m7413e("MicroMsg.Util.MMStack", "getCaller e:%s", C5007an.m7449l(th));
            str = "";
            AppMethodBeat.m2505o(52153);
            return str;
        }
    }

    public static String doR() {
        AppMethodBeat.m2504i(52154);
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String str;
        if (stackTrace == null || stackTrace.length < 4) {
            str = "";
            AppMethodBeat.m2505o(52154);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 3;
        while (i < stackTrace.length) {
            if (stackTrace[i].getClassName().contains("com.tencent.mm") && !stackTrace[i].getClassName().contains("sdk.platformtools.Log")) {
                stringBuilder.append("[");
                stringBuilder.append(stackTrace[i].getClassName().substring(15));
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(stackTrace[i].getMethodName());
                stringBuilder.append("(" + stackTrace[i].getLineNumber() + ")]");
            }
            i++;
        }
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(52154);
        return str;
    }

    /* renamed from: l */
    public static String m7449l(Throwable th) {
        AppMethodBeat.m2504i(52155);
        String str;
        if (th == null) {
            str = "";
            AppMethodBeat.m2505o(52155);
            return str;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            th.printStackTrace(printStream);
            str = byteArrayOutputStream.toString();
            printStream.close();
            byteArrayOutputStream.close();
            AppMethodBeat.m2505o(52155);
            return str;
        } catch (Exception e) {
            str = "";
            AppMethodBeat.m2505o(52155);
            return str;
        }
    }

    public static String stackTraceToString(StackTraceElement[] stackTraceElementArr) {
        AppMethodBeat.m2504i(52156);
        String str;
        if (stackTraceElementArr == null || stackTraceElementArr.length < 4) {
            str = "";
            AppMethodBeat.m2505o(52156);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 3;
        while (i < stackTraceElementArr.length) {
            if (stackTraceElementArr[i].getClassName().contains("com.tencent.mm") && !stackTraceElementArr[i].getClassName().contains("sdk.platformtools.Log")) {
                stringBuilder.append("[");
                stringBuilder.append(stackTraceElementArr[i].getClassName().substring(15));
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(stackTraceElementArr[i].getMethodName());
                stringBuilder.append("(" + stackTraceElementArr[i].getLineNumber() + ")]");
            }
            i++;
        }
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(52156);
        return str;
    }
}
