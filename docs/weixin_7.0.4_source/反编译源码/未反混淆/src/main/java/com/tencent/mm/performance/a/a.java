package com.tencent.mm.performance.a;

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
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.ttpic.baseutils.IOUtils;
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

public final class a implements ActivityLifecycleCallbacks, Runnable {
    private static final a gfY = new a();
    private volatile String activity;
    public boolean caA = true;
    private boolean gfZ = true;
    private int gga = 0;
    public int ggb;
    public int ggc;
    private long ggd = 0;
    private boolean gge = false;

    public static class a {
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

        public a() {
            AppMethodBeat.i(76869);
            AppMethodBeat.o(76869);
        }

        public final String toString() {
            AppMethodBeat.i(76870);
            StringBuilder stringBuilder = new StringBuilder(" \n");
            stringBuilder.append(String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> MemoryInfo(%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[]{Long.valueOf(this.ggq)})).append("\n| Activity:\t ").append(this.activity).append("\n| VmSize:\t ").append(this.ggg).append("kB\n| Dalvik:\t memClass=").append(this.ggn).append(", memLargeClass=").append(this.ggo).append("b, TalMemory=").append(this.ggk).append("b, FreeMemory=").append(this.ggl).append("b, MaxMemory=").append(this.ggm).append("b\n| NATIVE:\t HeapSize=").append(this.ggh).append("b, AllocatedSize=").append(this.ggi).append("b, FreeSize=").append(this.ggj).append("b\n| Stats:\t ").append(q(this.map)).append("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:").append(this.ggp).append("ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(76870);
            return stringBuilder2;
        }

        private static String q(Map<String, String> map) {
            AppMethodBeat.i(76871);
            String str;
            if (map == null) {
                str = BuildConfig.COMMAND;
                AppMethodBeat.o(76871);
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
            AppMethodBeat.o(76871);
            return str;
        }
    }

    static {
        AppMethodBeat.i(76881);
        AppMethodBeat.o(76881);
    }

    public static a any() {
        return gfY;
    }

    public final a df(boolean z) {
        AppMethodBeat.i(76872);
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a();
        if (this.activity != null) {
            aVar.activity = this.activity;
        }
        aVar.ggn = (long) this.ggb;
        aVar.ggo = (long) this.ggc;
        try {
            if (VERSION.SDK_INT >= 23 && z) {
                MemoryInfo memoryInfo = new MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                aVar.map = memoryInfo.getMemoryStats();
            }
            Matcher matcher = Pattern.compile("\\d+").matcher(getVmSize());
            if (matcher.find()) {
                aVar.ggg = bo.ank(matcher.group());
            }
            aVar.ggh = Debug.getNativeHeapSize();
            aVar.ggi = Debug.getNativeHeapAllocatedSize();
            aVar.ggj = Debug.getNativeHeapFreeSize();
            aVar.ggk = Runtime.getRuntime().totalMemory();
            aVar.ggl = Runtime.getRuntime().freeMemory();
            aVar.ggm = Runtime.getRuntime().maxMemory();
            return aVar;
        } finally {
            aVar.ggp = System.currentTimeMillis() - currentTimeMillis;
            aVar = (aVar.ggp > 30 ? 1 : (aVar.ggp == 30 ? 0 : -1));
            if (aVar > null) {
                aVar = this.gfZ;
                if (aVar != null) {
                    this.gga++;
                    aVar = this.gga;
                    if (aVar > 10) {
                        this.gfZ = false;
                    }
                }
            }
            AppMethodBeat.o(76872);
        }
    }

    private void anz() {
        AppMethodBeat.i(76873);
        d.xDG.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(76868);
                ab.i("MicroMsg.MemoryWatchDog", "[dumpMemoryAsync] %s", a.this.df(true));
                AppMethodBeat.o(76868);
            }
        });
        AppMethodBeat.o(76873);
    }

    private static String getVmSize() {
        AppMethodBeat.i(76874);
        String str;
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())})).trim().split(IOUtils.LINE_SEPARATOR_UNIX);
            for (String str2 : split) {
                if (str2.startsWith("VmSize")) {
                    AppMethodBeat.o(76874);
                    return str2;
                }
            }
            ab.w("MicroMsg.MemoryWatchDog", "[getVmSize] Wrong!", split[12]);
            str2 = split[12];
            AppMethodBeat.o(76874);
            return str2;
        } catch (Exception e) {
            str2 = "";
            AppMethodBeat.o(76874);
            return str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String convertStreamToString(InputStream inputStream) {
        Throwable th;
        AppMethodBeat.i(76875);
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
                        AppMethodBeat.o(76875);
                        return stringBuilder2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    AppMethodBeat.o(76875);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            AppMethodBeat.o(76875);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String getStringFromFile(String str) {
        Throwable th;
        AppMethodBeat.i(76876);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                String convertStreamToString = convertStreamToString(fileInputStream);
                fileInputStream.close();
                AppMethodBeat.o(76876);
                return convertStreamToString;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                AppMethodBeat.o(76876);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            AppMethodBeat.o(76876);
            throw th;
        }
    }

    private boolean anA() {
        AppMethodBeat.i(76877);
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = uptimeMillis - this.ggd > 5000;
        this.ggd = uptimeMillis;
        AppMethodBeat.o(76877);
        return z;
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.i(76878);
        this.activity = activity.getClass().getSimpleName();
        if (anA()) {
            if (this.gfZ) {
                ab.i("MicroMsg.MemoryWatchDog", "[onActivityResumed] activity:%s %s", this.activity, df(false));
                AppMethodBeat.o(76878);
                return;
            }
            anz();
        }
        AppMethodBeat.o(76878);
    }

    public final void onActivityStopped(Activity activity) {
        AppMethodBeat.i(76879);
        if (anA()) {
            if (this.gfZ) {
                ab.i("MicroMsg.MemoryWatchDog", "[onActivityStopped] activity:%s %s", activity.getClass().getSimpleName(), df(false));
                AppMethodBeat.o(76879);
                return;
            }
            anz();
        }
        AppMethodBeat.o(76879);
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
        AppMethodBeat.i(76880);
        a df = df(true);
        ab.i("MicroMsg.MemoryWatchDog", "[AutoCheck] %s", df);
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
            iDKey.SetKey(com.tencent.view.d.MIC_SketchMark);
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
            iDKey.SetKey(e.CTRL_INDEX);
        } else if (df.ggi < 419430400) {
            iDKey.SetKey(com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX);
        } else if (df.ggi < 524288000) {
            iDKey.SetKey(b.CTRL_INDEX);
        } else if (df.ggi < 629145600) {
            iDKey.SetKey(n.CTRL_INDEX);
        } else if (df.ggi < 734003200) {
            iDKey.SetKey(137);
        } else if (df.ggi < 838860800) {
            iDKey.SetKey(138);
        } else {
            iDKey.SetKey(com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX);
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
        com.tencent.mm.plugin.report.e.pXa.b(arrayList, false);
        int intValue = Integer.decode(f.CLIENT_VERSION).intValue();
        if ((intValue & 255) >= 48 && (intValue & 255) <= 95) {
            i = 1;
        }
        if (i == 0 && !this.gge && ((float) df.ggg) > 3984588.8f) {
            com.tencent.mm.plugin.report.e.pXa.g("MicroMsg.MemoryWatchDog", df.toString(), null);
            com.tencent.mm.plugin.report.e eVar = com.tencent.mm.plugin.report.e.pXa;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("| Activity:\t ").append(df.activity).append("\n| VmSize:\t ").append(df.ggg).append("kB\n| Dalvik:\t memClass=").append(df.ggn).append(", memLargeClass=").append(df.ggo).append("b, TalMemory=").append(df.ggk).append("b, FreeMemory=").append(df.ggl).append("b, MaxMemory=").append(df.ggm).append("b\n| NATIVE:\t HeapSize=").append(df.ggh).append("b, AllocatedSize=").append(df.ggi).append("b, FreeSize=").append(df.ggj).append("b\n");
            eVar.X(17068, stringBuilder.toString());
            this.gge = true;
        }
        d.xDG.p(this, this.caA ? 300000 : 1800000);
        AppMethodBeat.o(76880);
    }
}
