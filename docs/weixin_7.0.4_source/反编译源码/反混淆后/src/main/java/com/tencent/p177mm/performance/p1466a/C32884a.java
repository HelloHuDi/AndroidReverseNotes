package com.tencent.p177mm.performance.p1466a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.view.C31128d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.performance.a.a */
public final class C32884a implements ActivityLifecycleCallbacks, Runnable {
    private static final C32884a gfY = new C32884a();
    private volatile String activity;
    public boolean caA = true;
    private boolean gfZ = true;
    private int gga = 0;
    public int ggb;
    public int ggc;
    private long ggd = 0;
    private boolean gge = false;

    /* renamed from: com.tencent.mm.performance.a.a$a */
    public static class C32883a {
        String activity = "default";
        int ggg;
        long ggh;
        long ggi;
        long ggj;
        long ggk;
        long ggl;
        long ggm;
        long ggn;
        long ggo;
        long ggp;
        long ggq = Thread.currentThread().getId();
        Map<String, String> map;

        public C32883a() {
            AppMethodBeat.m2504i(76869);
            AppMethodBeat.m2505o(76869);
        }

        public final String toString() {
            AppMethodBeat.m2504i(76870);
            StringBuilder stringBuilder = new StringBuilder(" \n");
            stringBuilder.append(String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> MemoryInfo(%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[]{Long.valueOf(this.ggq)})).append("\n| Activity:\t ").append(this.activity).append("\n| VmSize:\t ").append(this.ggg).append("kB\n| Dalvik:\t memClass=").append(this.ggn).append(", memLargeClass=").append(this.ggo).append("b, TalMemory=").append(this.ggk).append("b, FreeMemory=").append(this.ggl).append("b, MaxMemory=").append(this.ggm).append("b\n| NATIVE:\t HeapSize=").append(this.ggh).append("b, AllocatedSize=").append(this.ggi).append("b, FreeSize=").append(this.ggj).append("b\n| Stats:\t ").append(C32883a.m53821q(this.map)).append("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:").append(this.ggp).append("ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(76870);
            return stringBuilder2;
        }

        /* renamed from: q */
        private static String m53821q(Map<String, String> map) {
            AppMethodBeat.m2504i(76871);
            String str;
            if (map == null) {
                str = BuildConfig.COMMAND;
                AppMethodBeat.m2505o(76871);
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Entry entry : map.entrySet()) {
                if (!(((String) entry.getKey()).equals("java-heap") || ((String) entry.getKey()).equals("native-heap"))) {
                    stringBuilder.append(((String) entry.getKey()).replaceFirst("summary.", "")).append("=").append((String) entry.getValue()).append(", ");
                }
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            str = stringBuilder.toString();
            AppMethodBeat.m2505o(76871);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.performance.a.a$1 */
    class C328851 implements Runnable {
        C328851() {
        }

        public final void run() {
            AppMethodBeat.m2504i(76868);
            C4990ab.m7417i("MicroMsg.MemoryWatchDog", "[dumpMemoryAsync] %s", C32884a.this.mo53444df(true));
            AppMethodBeat.m2505o(76868);
        }
    }

    static {
        AppMethodBeat.m2504i(76881);
        AppMethodBeat.m2505o(76881);
    }

    public static C32884a any() {
        return gfY;
    }

    /* renamed from: df */
    public final C32883a mo53444df(boolean z) {
        AppMethodBeat.m2504i(76872);
        long currentTimeMillis = System.currentTimeMillis();
        C32883a c32883a = new C32883a();
        if (this.activity != null) {
            c32883a.activity = this.activity;
        }
        c32883a.ggn = (long) this.ggb;
        c32883a.ggo = (long) this.ggc;
        try {
            if (VERSION.SDK_INT >= 23 && z) {
                MemoryInfo memoryInfo = new MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                c32883a.map = memoryInfo.getMemoryStats();
            }
            Matcher matcher = Pattern.compile("\\d+").matcher(C32884a.getVmSize());
            if (matcher.find()) {
                c32883a.ggg = C5046bo.ank(matcher.group());
            }
            c32883a.ggh = Debug.getNativeHeapSize();
            c32883a.ggi = Debug.getNativeHeapAllocatedSize();
            c32883a.ggj = Debug.getNativeHeapFreeSize();
            c32883a.ggk = Runtime.getRuntime().totalMemory();
            c32883a.ggl = Runtime.getRuntime().freeMemory();
            c32883a.ggm = Runtime.getRuntime().maxMemory();
            return c32883a;
        } finally {
            c32883a.ggp = System.currentTimeMillis() - currentTimeMillis;
            c32883a = (c32883a.ggp > 30 ? 1 : (c32883a.ggp == 30 ? 0 : -1));
            if (c32883a > null) {
                c32883a = this.gfZ;
                if (c32883a != null) {
                    this.gga++;
                    c32883a = this.gga;
                    if (c32883a > 10) {
                        this.gfZ = false;
                    }
                }
            }
            AppMethodBeat.m2505o(76872);
        }
    }

    private void anz() {
        AppMethodBeat.m2504i(76873);
        C7305d.xDG.execute(new C328851());
        AppMethodBeat.m2505o(76873);
    }

    private static String getVmSize() {
        AppMethodBeat.m2504i(76874);
        String str;
        try {
            String[] split = C32884a.getStringFromFile(String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())})).trim().split(IOUtils.LINE_SEPARATOR_UNIX);
            for (String str2 : split) {
                if (str2.startsWith("VmSize")) {
                    AppMethodBeat.m2505o(76874);
                    return str2;
                }
            }
            C4990ab.m7421w("MicroMsg.MemoryWatchDog", "[getVmSize] Wrong!", split[12]);
            str2 = split[12];
            AppMethodBeat.m2505o(76874);
            return str2;
        } catch (Exception e) {
            str2 = "";
            AppMethodBeat.m2505o(76874);
            return str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String convertStreamToString(InputStream inputStream) {
        Throwable th;
        AppMethodBeat.m2504i(76875);
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuilder.append(readLine).append(10);
                    } else {
                        bufferedReader.close();
                        String stringBuilder2 = stringBuilder.toString();
                        AppMethodBeat.m2505o(76875);
                        return stringBuilder2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    AppMethodBeat.m2505o(76875);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            AppMethodBeat.m2505o(76875);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String getStringFromFile(String str) {
        Throwable th;
        AppMethodBeat.m2504i(76876);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                String convertStreamToString = C32884a.convertStreamToString(fileInputStream);
                fileInputStream.close();
                AppMethodBeat.m2505o(76876);
                return convertStreamToString;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                AppMethodBeat.m2505o(76876);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(76876);
            throw th;
        }
    }

    private boolean anA() {
        AppMethodBeat.m2504i(76877);
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = uptimeMillis - this.ggd > 5000;
        this.ggd = uptimeMillis;
        AppMethodBeat.m2505o(76877);
        return z;
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.m2504i(76878);
        this.activity = activity.getClass().getSimpleName();
        if (anA()) {
            if (this.gfZ) {
                C4990ab.m7417i("MicroMsg.MemoryWatchDog", "[onActivityResumed] activity:%s %s", this.activity, mo53444df(false));
                AppMethodBeat.m2505o(76878);
                return;
            }
            anz();
        }
        AppMethodBeat.m2505o(76878);
    }

    public final void onActivityStopped(Activity activity) {
        AppMethodBeat.m2504i(76879);
        if (anA()) {
            if (this.gfZ) {
                C4990ab.m7417i("MicroMsg.MemoryWatchDog", "[onActivityStopped] activity:%s %s", activity.getClass().getSimpleName(), mo53444df(false));
                AppMethodBeat.m2505o(76879);
                return;
            }
            anz();
        }
        AppMethodBeat.m2505o(76879);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void run() {
        int i = 0;
        AppMethodBeat.m2504i(76880);
        C32883a df = mo53444df(true);
        C4990ab.m7417i("MicroMsg.MemoryWatchDog", "[AutoCheck] %s", df);
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(959);
        iDKey.SetValue(1);
        if (df.ggk - df.ggl < DownloadHelper.SAVE_LENGTH) {
            iDKey.SetKey(120);
        } else if (df.ggk - df.ggl < 209715200) {
            iDKey.SetKey(121);
        } else if (df.ggk - df.ggl < 314572800) {
            iDKey.SetKey(122);
        } else if (df.ggk - df.ggl < 419430400) {
            iDKey.SetKey(123);
        } else if (df.ggk - df.ggl < 524288000) {
            iDKey.SetKey(124);
        } else if (df.ggk - df.ggl < 629145600) {
            iDKey.SetKey(125);
        } else if (df.ggk - df.ggl < 734003200) {
            iDKey.SetKey(126);
        } else if (df.ggk - df.ggl < 838860800) {
            iDKey.SetKey(C31128d.MIC_SketchMark);
        } else {
            iDKey.SetKey(128);
        }
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(959);
        iDKey.SetValue(1);
        if (df.ggi < DownloadHelper.SAVE_LENGTH) {
            iDKey.SetKey(131);
        } else if (df.ggi < 209715200) {
            iDKey.SetKey(132);
        } else if (df.ggi < 314572800) {
            iDKey.SetKey(C19394e.CTRL_INDEX);
        } else if (df.ggi < 419430400) {
            iDKey.SetKey(C19392d.CTRL_INDEX);
        } else if (df.ggi < 524288000) {
            iDKey.SetKey(C44697b.CTRL_INDEX);
        } else if (df.ggi < 629145600) {
            iDKey.SetKey(C19395n.CTRL_INDEX);
        } else if (df.ggi < 734003200) {
            iDKey.SetKey(137);
        } else if (df.ggi < 838860800) {
            iDKey.SetKey(138);
        } else {
            iDKey.SetKey(C33333a.CTRL_INDEX);
        }
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(959);
        iDKey.SetValue(1);
        if (df.ggg < 2097152) {
            iDKey.SetKey(ErrorCode.NEEDDOWNLOAD_3);
        } else if (((float) df.ggg) < 2516582.5f) {
            iDKey.SetKey(ErrorCode.NEEDDOWNLOAD_4);
        } else if (((float) df.ggg) < 2936012.8f) {
            iDKey.SetKey(144);
        } else if (((float) df.ggg) < 3145728.0f) {
            iDKey.SetKey(145);
        } else if (((float) df.ggg) < 3565158.5f) {
            iDKey.SetKey(146);
        } else if (((float) df.ggg) < 3984588.8f) {
            iDKey.SetKey(ErrorCode.NEEDDOWNLOAD_8);
        } else {
            iDKey.SetKey(148);
        }
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(959);
        iDKey.SetValue(1);
        iDKey.SetKey(151);
        arrayList.add(iDKey);
        C7053e.pXa.mo8379b(arrayList, false);
        int intValue = Integer.decode(C5058f.CLIENT_VERSION).intValue();
        if ((intValue & 255) >= 48 && (intValue & 255) <= 95) {
            i = 1;
        }
        if (i == 0 && !this.gge && ((float) df.ggg) > 3984588.8f) {
            C7053e.pXa.mo8382g("MicroMsg.MemoryWatchDog", df.toString(), null);
            C7053e c7053e = C7053e.pXa;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("| Activity:\t ").append(df.activity).append("\n| VmSize:\t ").append(df.ggg).append("kB\n| Dalvik:\t memClass=").append(df.ggn).append(", memLargeClass=").append(df.ggo).append("b, TalMemory=").append(df.ggk).append("b, FreeMemory=").append(df.ggl).append("b, MaxMemory=").append(df.ggm).append("b\n| NATIVE:\t HeapSize=").append(df.ggh).append("b, AllocatedSize=").append(df.ggi).append("b, FreeSize=").append(df.ggj).append("b\n");
            c7053e.mo8374X(17068, stringBuilder.toString());
            this.gge = true;
        }
        C7305d.xDG.mo10159p(this, this.caA ? 300000 : 1800000);
        AppMethodBeat.m2505o(76880);
    }
}
