package com.tencent.p177mm.ipcinvoker;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import java.io.FileInputStream;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ipcinvoker.e */
public final class C9548e {
    private static String eFZ;
    public static Context sContext;

    public static Context getContext() {
        AppMethodBeat.m2504i(114021);
        Assert.assertNotNull("IPCInvoker not initialize.", sContext);
        Context context = sContext;
        AppMethodBeat.m2505o(114021);
        return context;
    }

    /* renamed from: lg */
    public static boolean m17008lg(String str) {
        AppMethodBeat.m2504i(114022);
        if (str == null || !str.equals(C9548e.m17007PN())) {
            AppMethodBeat.m2505o(114022);
            return false;
        }
        AppMethodBeat.m2505o(114022);
        return true;
    }

    /* renamed from: PN */
    public static String m17007PN() {
        AppMethodBeat.m2504i(114023);
        if (eFZ == null || eFZ.length() == 0) {
            eFZ = C9548e.m17009z(sContext, Process.myPid());
        }
        String str = eFZ;
        AppMethodBeat.m2505o(114023);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ab A:{SYNTHETIC, Splitter:B:47:0x00ab} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a1 A:{SYNTHETIC, Splitter:B:41:0x00a1} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: z */
    private static String m17009z(Context context, int i) {
        Throwable e;
        AppMethodBeat.m2504i(114024);
        if (context == null) {
            AppMethodBeat.m2505o(114024);
            return null;
        }
        String str;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (!(runningAppProcesses == null || runningAppProcesses.isEmpty())) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i) {
                        str = runningAppProcessInfo.processName;
                        AppMethodBeat.m2505o(114024);
                        return str;
                    }
                }
            }
        }
        byte[] bArr = new byte[128];
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/" + i + "/cmdline");
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    int i2 = 0;
                    while (i2 < read) {
                        if (bArr[i2] > Byte.MIN_VALUE || bArr[i2] <= (byte) 0) {
                            read = i2;
                            break;
                        }
                        i2++;
                    }
                    str = new String(bArr, 0, read);
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                    AppMethodBeat.m2505o(114024);
                    return str;
                }
                try {
                    fileInputStream.close();
                } catch (Exception e3) {
                }
                AppMethodBeat.m2505o(114024);
                return null;
            } catch (Exception e4) {
                e = e4;
                try {
                    C26340b.m41916e("IPC.IPCInvokeLogic", "get running process error : %s", Log.getStackTraceString(e));
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(114024);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(114024);
                    throw e;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            C26340b.m41916e("IPC.IPCInvokeLogic", "get running process error : %s", Log.getStackTraceString(e));
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e6) {
                }
            }
            AppMethodBeat.m2505o(114024);
            return null;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e7) {
                }
            }
            AppMethodBeat.m2505o(114024);
            throw e;
        }
    }
}
