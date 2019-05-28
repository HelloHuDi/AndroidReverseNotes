package com.tencent.ttpic.util;

import android.opengl.GLES20;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.view.C16373c;

public class GpuInfoUtil {
    private static final String TAG = GpuInfoUtil.class.getSimpleName();
    private static String gpuInfo;

    static {
        AppMethodBeat.m2504i(83930);
        AppMethodBeat.m2505o(83930);
    }

    public static String getGPUInfo() {
        AppMethodBeat.m2504i(83929);
        if (gpuInfo == null) {
            Looper looper;
            final Object obj = new Object();
            C163651 c163651 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(83928);
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
                            AppMethodBeat.m2505o(83928);
                        }
                    }
                }
            };
            Looper myLooper = Looper.myLooper();
            C16373c dSN = C16373c.dSN();
            if (dSN.mGlThread == null) {
                looper = null;
            } else {
                looper = dSN.mGlThread.getLooper();
            }
            if (myLooper == looper) {
                c163651.run();
            } else {
                synchronized (obj) {
                    try {
                        C16373c.dSN().queue(c163651);
                        obj.wait();
                    } catch (InterruptedException e) {
                        LogUtils.m50210v(TAG, "getGpuInfo waitDone interrupted");
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(83929);
                    }
                }
            }
        }
        String str = gpuInfo;
        AppMethodBeat.m2505o(83929);
        return str;
    }
}
