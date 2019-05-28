package com.tencent.mm.plugin.performance.b;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b implements ActivityLifecycleCallbacks {
    private long pfX;

    static class a {
        int count;
        String name;

        public a(String str, int i) {
            this.name = str;
            this.count = i;
        }

        public final String toString() {
            AppMethodBeat.i(138543);
            String str = this.name + "=" + this.count;
            AppMethodBeat.o(138543);
            return str;
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public static int bZs() {
        int i = 0;
        AppMethodBeat.i(111085);
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())})).trim().split(IOUtils.LINE_SEPARATOR_UNIX);
            int length = split.length;
            for (int i2 = i; i2 < length; i2++) {
                String str = split[i2];
                if (str.startsWith("Threads")) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(str);
                    if (matcher.find()) {
                        i = bo.ank(matcher.group());
                        AppMethodBeat.o(111085);
                        break;
                    }
                }
            }
            ab.w("MicroMsg.ThreadWatchDog", "[getProcessThreadCount] Wrong!", split[24]);
            i = bo.ank(split[24].trim());
            AppMethodBeat.o(111085);
        } catch (Exception e) {
            AppMethodBeat.o(111085);
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String convertStreamToString(InputStream inputStream) {
        Throwable th;
        AppMethodBeat.i(111086);
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
                        AppMethodBeat.o(111086);
                        return stringBuilder2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    AppMethodBeat.o(111086);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            AppMethodBeat.o(111086);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String getStringFromFile(String str) {
        Throwable th;
        AppMethodBeat.i(111087);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                String convertStreamToString = convertStreamToString(fileInputStream);
                fileInputStream.close();
                AppMethodBeat.o(111087);
                return convertStreamToString;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                AppMethodBeat.o(111087);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            AppMethodBeat.o(111087);
            throw th;
        }
    }

    public static int cy(List<a> list) {
        AppMethodBeat.i(138544);
        HashMap hashMap = new HashMap();
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        Thread[] threadArr = new Thread[(threadGroup.activeCount() * 2)];
        int enumerate = threadGroup.enumerate(threadArr);
        int i = 0;
        int i2 = 0;
        while (i < enumerate) {
            int i3;
            String name = threadArr[i].getName();
            if (bo.isNullOrNil(name)) {
                i3 = i2;
            } else {
                String replaceAll = name.replaceAll("-?[0-9]\\d*", "?");
                if (hashMap.containsKey(replaceAll)) {
                    hashMap.put(replaceAll, Integer.valueOf(((Integer) hashMap.get(replaceAll)).intValue() + 1));
                } else {
                    hashMap.put(replaceAll, Integer.valueOf(1));
                }
                i3 = i2 + 1;
            }
            i++;
            i2 = i3;
        }
        for (Entry entry : hashMap.entrySet()) {
            list.add(new a((String) entry.getKey(), ((Integer) entry.getValue()).intValue()));
        }
        Collections.sort(list, new Comparator<a>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(138542);
                int compare = Integer.compare(((a) obj2).count, ((a) obj).count);
                AppMethodBeat.o(138542);
                return compare;
            }
        });
        AppMethodBeat.o(138544);
        return i2;
    }

    public final void onActivityStopped(Activity activity) {
        Object obj;
        AppMethodBeat.i(111084);
        if (SystemClock.uptimeMillis() - this.pfX >= 10000) {
            this.pfX = SystemClock.uptimeMillis();
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                LinkedList linkedList = new LinkedList();
                int bZs = bZs();
                int cy = cy(linkedList);
                if (bZs > 500) {
                    e.pXa.a(960, 101, 1, true);
                    RuntimeException runtimeException = new RuntimeException("MicroMsg.ThreadWatchDog" + String.format("\nThreadOver[%s:%s]: %s", new Object[]{Integer.valueOf(cy), Integer.valueOf(bZs), linkedList.toString()}));
                    AppMethodBeat.o(111084);
                    throw runtimeException;
                }
                if (bZs > 300) {
                    e.pXa.X(16470, String.format("ThreadOver[%s:%s]: %s", new Object[]{Integer.valueOf(cy), Integer.valueOf(bZs), linkedList.toString()}));
                    e.pXa.a(960, 100, 1, true);
                } else if (bZs > 200) {
                    e.pXa.a(960, 102, 1, true);
                } else if (bZs > 150) {
                    e.pXa.a(960, 103, 1, true);
                }
                if (cy > 500) {
                    e.pXa.a(960, 104, 1, true);
                } else if (cy > 300) {
                    e.pXa.a(960, 105, 1, true);
                } else if (cy > 200) {
                    e.pXa.a(960, 106, 1, true);
                } else if (cy > 150) {
                    e.pXa.a(960, 107, 1, true);
                }
                ab.w("MicroMsg.ThreadWatchDog", "[wang][%s:%s]:%s", Integer.valueOf(cy), Integer.valueOf(bZs), linkedList.toString());
                ab.d("MicroMsg.ThreadWatchDog", "[wang] Cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                AppMethodBeat.o(111084);
            } catch (Throwable th) {
                ab.d("MicroMsg.ThreadWatchDog", "[wang] Cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                AppMethodBeat.o(111084);
            }
        } else {
            AppMethodBeat.o(111084);
        }
    }
}
