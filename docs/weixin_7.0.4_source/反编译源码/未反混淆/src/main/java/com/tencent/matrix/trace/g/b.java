package com.tencent.matrix.trace.g;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class b {
    public static String getStack() {
        return a(new Throwable().getStackTrace());
    }

    private static String a(StackTraceElement[] stackTraceElementArr) {
        return a(stackTraceElementArr, "", -1);
    }

    public static String a(StackTraceElement[] stackTraceElementArr, String str, int i) {
        int i2 = 3;
        if (stackTraceElementArr == null || stackTraceElementArr.length < 3) {
            return "";
        }
        if (i < 0) {
            i = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        StringBuilder stringBuilder = new StringBuilder(" \n");
        while (i2 < stackTraceElementArr.length - 3 && i2 < i) {
            stringBuilder.append(str);
            stringBuilder.append("at ");
            stringBuilder.append(stackTraceElementArr[i2].getClassName());
            stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            stringBuilder.append(stackTraceElementArr[i2].getMethodName());
            stringBuilder.append("(" + stackTraceElementArr[i2].getLineNumber() + ")");
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            i2++;
        }
        return stringBuilder.toString();
    }

    public static String p(long j, long j2) {
        if (j <= 0) {
            return j2 > 1000 ? "0%" : "100%";
        } else {
            if (j >= j2) {
                return "100%";
            }
            return String.format("%.2f", new Object[]{Float.valueOf(((1.0f * ((float) j)) / ((float) j2)) * 100.0f)}) + "%";
        }
    }
}
