package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public final class an {
    public final String toString() {
        AppMethodBeat.i(52152);
        String doR = doR();
        AppMethodBeat.o(52152);
        return doR;
    }

    public static String doQ() {
        AppMethodBeat.i(52153);
        String str;
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace == null || stackTrace.length < 3) {
                str = "";
                AppMethodBeat.o(52153);
                return str;
            }
            str = (stackTrace[2].getClassName().substring(15) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + stackTrace[2].getMethodName()) + "(" + stackTrace[2].getLineNumber() + ")";
            AppMethodBeat.o(52153);
            return str;
        } catch (Throwable th) {
            ab.e("MicroMsg.Util.MMStack", "getCaller e:%s", l(th));
            str = "";
            AppMethodBeat.o(52153);
            return str;
        }
    }

    public static String doR() {
        AppMethodBeat.i(52154);
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String str;
        if (stackTrace == null || stackTrace.length < 4) {
            str = "";
            AppMethodBeat.o(52154);
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
        AppMethodBeat.o(52154);
        return str;
    }

    public static String l(Throwable th) {
        AppMethodBeat.i(52155);
        String str;
        if (th == null) {
            str = "";
            AppMethodBeat.o(52155);
            return str;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            th.printStackTrace(printStream);
            str = byteArrayOutputStream.toString();
            printStream.close();
            byteArrayOutputStream.close();
            AppMethodBeat.o(52155);
            return str;
        } catch (Exception e) {
            str = "";
            AppMethodBeat.o(52155);
            return str;
        }
    }

    public static String stackTraceToString(StackTraceElement[] stackTraceElementArr) {
        AppMethodBeat.i(52156);
        String str;
        if (stackTraceElementArr == null || stackTraceElementArr.length < 4) {
            str = "";
            AppMethodBeat.o(52156);
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
        AppMethodBeat.o(52156);
        return str;
    }
}
