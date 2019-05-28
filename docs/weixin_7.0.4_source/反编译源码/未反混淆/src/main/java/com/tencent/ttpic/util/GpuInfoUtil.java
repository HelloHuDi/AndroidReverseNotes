package com.tencent.ttpic.util;

import android.opengl.GLES20;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.view.c;

public class GpuInfoUtil {
    private static final String TAG = GpuInfoUtil.class.getSimpleName();
    private static String gpuInfo;

    static {
        AppMethodBeat.i(83930);
        AppMethodBeat.o(83930);
    }

    public static String getGPUInfo() {
        AppMethodBeat.i(83929);
        if (gpuInfo == null) {
            Looper looper;
            final Object obj = new Object();
            AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(83928);
                    if (GpuInfoUtil.gpuInfo == null) {
                        String glGetString = GLES20.glGetString(7937);
                        String glGetString2 = GLES20.glGetString(7936);
                        GpuInfoUtil.gpuInfo = glGetString + "; " + glGetString2 + "; " + GLES20.glGetString(7938);
                    }
                    synchronized (obj) {
                        try {
                            obj.notifyAll();
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(83928);
                        }
                    }
                }
            };
            Looper myLooper = Looper.myLooper();
            c dSN = c.dSN();
            if (dSN.mGlThread == null) {
                looper = null;
            } else {
                looper = dSN.mGlThread.getLooper();
            }
            if (myLooper == looper) {
                anonymousClass1.run();
            } else {
                synchronized (obj) {
                    try {
                        c.dSN().queue(anonymousClass1);
                        obj.wait();
                    } catch (InterruptedException e) {
                        LogUtils.v(TAG, "getGpuInfo waitDone interrupted");
                    } catch (Throwable th) {
                        AppMethodBeat.o(83929);
                    }
                }
            }
        }
        String str = gpuInfo;
        AppMethodBeat.o(83929);
        return str;
    }
}
