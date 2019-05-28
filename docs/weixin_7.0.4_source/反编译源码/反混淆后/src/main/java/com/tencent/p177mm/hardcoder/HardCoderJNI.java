package com.tencent.p177mm.hardcoder;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1607a.C1606c;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.hardcoder.HardCoderJNI */
public class HardCoderJNI {
    public static final int CALLBACK_TYPE_BASE = 0;
    public static final int CALLBACK_TYPE_DATA = 2;
    public static final int CALLBACK_TYPE_STATUS = 1;
    public static final int CONFIGURE_TYPE_BASE = 0;
    public static final int CONFIGURE_TYPE_QP_MEDIACODEC = 1;
    public static final int CPU_LEVEL_0 = 0;
    public static final int CPU_LEVEL_1 = 1;
    public static final int CPU_LEVEL_2 = 2;
    public static final int CPU_LEVEL_3 = 3;
    public static final int ERROR_CODE_CHECKENV_FAIL = -2;
    public static final int ERROR_CODE_DISCONNECT = -6;
    public static final int ERROR_CODE_FAILED = -1;
    public static final int ERROR_CODE_HCPERFMANAGER_NULL = -5;
    public static final int ERROR_CODE_NOT_ENABLE = -3;
    public static final int ERROR_CODE_NOT_FOREGROUND = -4;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERR_CLIENT_CONNECT = -20000;
    public static final int ERR_CLIENT_DISCONNECT = -20001;
    public static final int ERR_CLIENT_RESPONSE = -20002;
    public static final int FUNC_BASE = 1000;
    public static final int FUNC_CANCEL_CPU_CORE_FOR_THREAD = 1005;
    public static final int FUNC_CANCEL_CPU_HIGH_FREQ = 1003;
    public static final int FUNC_CANCEL_GPU_HIGH_FREQ = 1017;
    public static final int FUNC_CANCEL_HIGH_IO_FREQ = 1007;
    public static final int FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE = 1014;
    public static final int FUNC_CHECK_PERMISSION = 1001;
    public static final int FUNC_CONFIGURE = 1018;
    public static final int FUNC_CPU_CORE_FOR_THREAD = 1004;
    public static final int FUNC_CPU_HIGH_FREQ = 1002;
    public static final int FUNC_GPU_HIGH_FREQ = 1016;
    public static final int FUNC_HIGH_IO_FREQ = 1006;
    public static final int FUNC_REG_ANR_CALLBACK = 1010;
    public static final int FUNC_REG_PRELOAD_BOOT_RESOURCE = 1011;
    public static final int FUNC_REG_SYSTEM_EVENT_CALLBACK = 1015;
    public static final int FUNC_RESET_SCREEN_RESOLUTION = 1009;
    public static final int FUNC_SET_SCREEN_RESOLUTION = 1008;
    public static final int FUNC_TERMINATE_APP = 1012;
    public static final int FUNC_UNIFY_CPU_IO_THREAD_CORE = 1013;
    public static final int GPU_LEVEL_0 = 0;
    public static final int GPU_LEVEL_1 = 1;
    public static final int IO_LEVEL_0 = 0;
    public static final int IO_LEVEL_1 = 1;
    public static final int IO_LEVEL_2 = 2;
    public static final int IO_LEVEL_3 = 3;
    public static final int SYSTEM_EVENT_BASE = 0;
    public static final int SYSTEM_EVENT_BLUETOOTH_ACCEPTCALL = 3;
    public static final int SYSTEM_EVENT_BLUETOOTH_HANGUPCALL = 4;
    public static final String SYSTEM_EVENT_CODE = "system_event_code";
    public static final int SYSTEM_EVENT_SLIDE_CLOSE = 2;
    public static final int SYSTEM_EVENT_SLIDE_OPEN = 1;
    private static final String TAG = "HardCoder.HardCoderJNI";
    private static AnrCallback anrCallback = null;
    private static boolean checkEnv = false;
    public static final String clientSock = ".hardcoder.client.sock";
    private static boolean connect = false;
    private static boolean hcDebug = false;
    private static boolean hcEnable = true;
    private static C1607a hcPerfManager = null;
    private static Method sGetStringPropsMethod = null;
    public static final boolean sHCDEBUG = false;
    public static final boolean sHCENABLE = true;
    private static volatile Class<?> sSystemPropertiesClazz = null;
    public static SceneReportCallback sceneReportCallback = null;
    public static final String serverPropKey = "persist.sys.hardcoder.name";
    private static SystemEventCallback systemEventCallback;
    public static int tickRate = 100;

    /* renamed from: com.tencent.mm.hardcoder.HardCoderJNI$AnrCallback */
    public interface AnrCallback {
        void onANR(String str);
    }

    /* renamed from: com.tencent.mm.hardcoder.HardCoderJNI$HCPerfManagerThread */
    public interface HCPerfManagerThread {
        Thread newThread(Runnable runnable, String str, int i);
    }

    /* renamed from: com.tencent.mm.hardcoder.HardCoderJNI$SceneReportCallback */
    public interface SceneReportCallback {
        void sceneReport(int i, long j);
    }

    /* renamed from: com.tencent.mm.hardcoder.HardCoderJNI$SystemEventCallback */
    public interface SystemEventCallback {
        void onEvent(int i);
    }

    /* renamed from: com.tencent.mm.hardcoder.HardCoderJNI$1 */
    static class C16031 implements HCPerfManagerThread {
        C16031() {
        }

        public final Thread newThread(Runnable runnable, String str, int i) {
            AppMethodBeat.m2504i(93906);
            Thread thread = new Thread(runnable, str);
            AppMethodBeat.m2505o(93906);
            return thread;
        }
    }

    public static native int cancelCpuCoreForThread(int[] iArr, int i, long j);

    public static native int cancelCpuHighFreq(int i, long j);

    public static native int cancelGpuHighFreq(int i, long j);

    public static native int cancelHighIOFreq(int i, long j);

    public static native int cancelUnifyCpuIOThreadCoreGpu(boolean z, boolean z2, boolean z3, boolean z4, int[] iArr, int i, long j);

    public static native int checkPermission(int i, int i2, int i3, long j);

    public static native int configure(byte[] bArr, int i, long j);

    private static native int getTickRate();

    private static native int initHardCoder(String str, int i, String str2);

    public static native int isRunning();

    public static native int registerANRCallback(int i, long j);

    public static native int registerBootPreloadResource(String[] strArr, int i, long j);

    public static native int registerSystemEventCallback(int i, long j);

    public static native int requestCpuCoreForThread(int i, long j, int[] iArr, int i2, int i3, long j2);

    public static native int requestCpuHighFreq(int i, long j, int i2, int i3, int i4, long j2);

    public static native int requestGpuHighFreq(int i, long j, int i2, int i3, int i4, long j2);

    public static native int requestHighIOFreq(int i, long j, int i2, int i3, int i4, long j2);

    public static native int requestScreenResolution(int i, String str, int i2, long j);

    public static native int requestUnifyCpuIOThreadCoreGpu(int i, long j, int i2, int i3, int i4, int[] iArr, int i5, int i6, long j2);

    public static native int resetScreenResolution(int i, long j);

    private static native void setDebug(boolean z);

    private static native void setHCEnable(boolean z);

    public static native void setRetryConnectInterval(int i);

    public static native int startTraceCpuLoad(int i, int i2);

    public static native int stopTraceCpuLoad(int i);

    public static native int terminateApp(int i, long j);

    static {
        AppMethodBeat.m2504i(93918);
        System.loadLibrary("hardcoder");
        AppMethodBeat.m2505o(93918);
    }

    private HardCoderJNI() {
    }

    public static boolean isCheckEnv() {
        return checkEnv;
    }

    public static void setCheckEnv(boolean z) {
        checkEnv = z;
    }

    public static boolean isHcDebug() {
        return hcDebug;
    }

    public static void setHcDebug(boolean z) {
        AppMethodBeat.m2504i(93907);
        hcDebug = z;
        if (checkEnv) {
            HardCoderJNI.setDebug(z);
        }
        AppMethodBeat.m2505o(93907);
    }

    public static boolean isHcEnable() {
        return hcEnable;
    }

    public static void setHcEnable(boolean z) {
        AppMethodBeat.m2504i(93908);
        hcEnable = z;
        if (checkEnv) {
            HardCoderJNI.setHCEnable(z);
        }
        AppMethodBeat.m2505o(93908);
    }

    public static int initHardCoder(String str, int i, String str2, HCPerfManagerThread hCPerfManagerThread, Context context) {
        AppMethodBeat.m2504i(93909);
        if (HardCoderJNI.isHcEnable()) {
            if (hcPerfManager == null) {
                if (hCPerfManagerThread == null) {
                    hCPerfManagerThread = new C16031();
                }
                if (context == null || (context instanceof Activity)) {
                    context = context.getApplicationContext();
                }
                hcPerfManager = new C1607a(hCPerfManagerThread, context);
            }
            tickRate = HardCoderJNI.getTickRate();
            int initHardCoder = HardCoderJNI.initHardCoder(str, i, str2);
            AppMethodBeat.m2505o(93909);
            return initHardCoder;
        }
        C1611c.m3271i(TAG, String.format("initHardCoder isHcEnable false, hcEnable:%b, checkEnv:%b, ret:-2", new Object[]{Boolean.valueOf(HardCoderJNI.isHcEnable()), Boolean.valueOf(HardCoderJNI.isCheckEnv())}));
        AppMethodBeat.m2505o(93909);
        return -3;
    }

    public static int startPerformance(int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, String str) {
        AppMethodBeat.m2504i(93910);
        int startPerformance = HardCoderJNI.startPerformance(i, i2, i3, 0, new int[]{i4}, i5, i6, j, i7, str);
        AppMethodBeat.m2505o(93910);
        return startPerformance;
    }

    public static int startPerformance(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, long j, int i7, String str) {
        AppMethodBeat.m2504i(93911);
        if (hcPerfManager == null) {
            C1611c.m3270e(TAG, "startPerformance error HCPerfManager is null, please initHardCoder first!");
            AppMethodBeat.m2505o(93911);
            return -5;
        } else if (connect) {
            int a = hcPerfManager.mo5058a(i, i2, i3, i4, iArr, i5, i6, j, i7, str);
            C1611c.m3271i(TAG, String.format("hcPerfManager startPerformance:%d, scene:%d", new Object[]{Integer.valueOf(a), Integer.valueOf(i6)}));
            AppMethodBeat.m2505o(93911);
            return a;
        } else {
            C1611c.m3270e(TAG, "startPerformance error disconnect");
            AppMethodBeat.m2505o(93911);
            return -6;
        }
    }

    public static int stopPerformance(int i) {
        AppMethodBeat.m2504i(93912);
        if (hcPerfManager == null) {
            C1611c.m3270e(TAG, "stopPerformance error HCPerfManager is null, please initHardCoder first!");
            AppMethodBeat.m2505o(93912);
            return -5;
        } else if (connect) {
            C1607a c1607a = hcPerfManager;
            C1606c c1606c = new C1606c();
            c1606c.eDE = System.currentTimeMillis();
            c1606c.aBR = i;
            C1611c.m3269d("HardCoder.HCPerfManager", String.format("stop ret:%b, hashcode:%x", new Object[]{Boolean.valueOf(i != 0 ? c1607a.eDC.offer(c1606c) : false), Integer.valueOf(i)}));
            C1611c.m3271i(TAG, String.format("hcPerfManager stopPerformance:%d, ret:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(r0)}));
            if (i != 0 ? c1607a.eDC.offer(c1606c) : false) {
                AppMethodBeat.m2505o(93912);
                return 0;
            }
            AppMethodBeat.m2505o(93912);
            return -1;
        } else {
            C1611c.m3270e(TAG, "stopPerformance error disconnect");
            AppMethodBeat.m2505o(93912);
            return -6;
        }
    }

    public static int startTraceCpuLoad(int i) {
        AppMethodBeat.m2504i(93913);
        int startTraceCpuLoad = HardCoderJNI.startTraceCpuLoad(i, 20);
        AppMethodBeat.m2505o(93913);
        return startTraceCpuLoad;
    }

    public static int registerANRCallback(AnrCallback anrCallback) {
        AppMethodBeat.m2504i(93914);
        anrCallback = anrCallback;
        int registerANRCallback = HardCoderJNI.registerANRCallback(Process.myTid(), SystemClock.elapsedRealtime());
        AppMethodBeat.m2505o(93914);
        return registerANRCallback;
    }

    public static int registerSystemEventCallback(SystemEventCallback systemEventCallback) {
        AppMethodBeat.m2504i(93915);
        systemEventCallback = systemEventCallback;
        int registerSystemEventCallback = HardCoderJNI.registerSystemEventCallback(Process.myTid(), SystemClock.elapsedRealtime());
        AppMethodBeat.m2505o(93915);
        return registerSystemEventCallback;
    }

    public static void onData(int i, long j, int i2, int i3, int i4, byte[] bArr) {
        AppMethodBeat.m2504i(93916);
        C1611c.m3271i(TAG, "onData callbackType:" + i + " timestamp:" + j + " errCode:" + i2 + " funcid:" + i3 + " dataType:" + i4);
        switch (i) {
            case 1:
                if (i2 == ERR_CLIENT_CONNECT) {
                    connect = true;
                    AppMethodBeat.m2505o(93916);
                    return;
                } else if (i2 == ERR_CLIENT_DISCONNECT) {
                    connect = false;
                    AppMethodBeat.m2505o(93916);
                    return;
                }
                break;
            case 2:
                switch (i3) {
                    case 1010:
                        if (anrCallback != null) {
                            anrCallback.onANR(new String(bArr));
                            break;
                        }
                        break;
                    case 1015:
                        if (systemEventCallback != null) {
                            JSONObject jSONObject;
                            try {
                                jSONObject = new JSONObject(new String(bArr));
                            } catch (JSONException e) {
                                C1611c.m3271i(TAG, "onData parse system event e:" + e.getMessage());
                                jSONObject = null;
                            }
                            int optInt = jSONObject.optInt(SYSTEM_EVENT_CODE, 0);
                            C1611c.m3271i(TAG, "onData SYSTEM_EVENT_CODE: ".concat(String.valueOf(optInt)));
                            systemEventCallback.onEvent(optInt);
                            AppMethodBeat.m2505o(93916);
                            return;
                        }
                        break;
                }
                break;
        }
        AppMethodBeat.m2505o(93916);
    }

    public static String readServerAddr() {
        AppMethodBeat.m2504i(93917);
        String str;
        try {
            if (sSystemPropertiesClazz == null) {
                Class cls = Class.forName("android.os.SystemProperties");
                sSystemPropertiesClazz = cls;
                Method declaredMethod = cls.getDeclaredMethod("get", new Class[]{String.class, String.class});
                sGetStringPropsMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            str = (String) sGetStringPropsMethod.invoke(null, new Object[]{serverPropKey, ""});
            C1611c.m3271i(TAG, String.format("readServerAddr, serverprop[%s] result[%s]", new Object[]{serverPropKey, str}));
            AppMethodBeat.m2505o(93917);
            return str;
        } catch (Throwable th) {
            C1611c.printErrStackTrace(TAG, th, "readServerAddr", new Object[0]);
            str = "";
            AppMethodBeat.m2505o(93917);
            return str;
        }
    }

    public static void setSceneReportCallback(SceneReportCallback sceneReportCallback) {
        sceneReportCallback = sceneReportCallback;
    }
}
