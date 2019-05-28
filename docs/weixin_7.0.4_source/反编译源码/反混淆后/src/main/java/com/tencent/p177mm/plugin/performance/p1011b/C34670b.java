package com.tencent.p177mm.plugin.performance.p1011b;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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

/* renamed from: com.tencent.mm.plugin.performance.b.b */
public final class C34670b implements ActivityLifecycleCallbacks {
    private long pfX;

    /* renamed from: com.tencent.mm.plugin.performance.b.b$a */
    static class C21430a {
        int count;
        String name;

        public C21430a(String str, int i) {
            this.name = str;
            this.count = i;
        }

        public final String toString() {
            AppMethodBeat.m2504i(138543);
            String str = this.name + "=" + this.count;
            AppMethodBeat.m2505o(138543);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.performance.b.b$1 */
    static class C346711 implements Comparator<C21430a> {
        C346711() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(138542);
            int compare = Integer.compare(((C21430a) obj2).count, ((C21430a) obj).count);
            AppMethodBeat.m2505o(138542);
            return compare;
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
        AppMethodBeat.m2504i(111085);
        try {
            String[] split = C34670b.getStringFromFile(String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())})).trim().split(IOUtils.LINE_SEPARATOR_UNIX);
            int length = split.length;
            for (int i2 = i; i2 < length; i2++) {
                String str = split[i2];
                if (str.startsWith("Threads")) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(str);
                    if (matcher.find()) {
                        i = C5046bo.ank(matcher.group());
                        AppMethodBeat.m2505o(111085);
                        break;
                    }
                }
            }
            C4990ab.m7421w("MicroMsg.ThreadWatchDog", "[getProcessThreadCount] Wrong!", split[24]);
            i = C5046bo.ank(split[24].trim());
            AppMethodBeat.m2505o(111085);
        } catch (Exception e) {
            AppMethodBeat.m2505o(111085);
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String convertStreamToString(InputStream inputStream) {
        Throwable th;
        AppMethodBeat.m2504i(111086);
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
                        AppMethodBeat.m2505o(111086);
                        return stringBuilder2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    AppMethodBeat.m2505o(111086);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            AppMethodBeat.m2505o(111086);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String getStringFromFile(String str) {
        Throwable th;
        AppMethodBeat.m2504i(111087);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                String convertStreamToString = C34670b.convertStreamToString(fileInputStream);
                fileInputStream.close();
                AppMethodBeat.m2505o(111087);
                return convertStreamToString;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                AppMethodBeat.m2505o(111087);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(111087);
            throw th;
        }
    }

    /* renamed from: cy */
    public static int m56930cy(List<C21430a> list) {
        AppMethodBeat.m2504i(138544);
        HashMap hashMap = new HashMap();
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        Thread[] threadArr = new Thread[(threadGroup.activeCount() * 2)];
        int enumerate = threadGroup.enumerate(threadArr);
        int i = 0;
        int i2 = 0;
        while (i < enumerate) {
            int i3;
            String name = threadArr[i].getName();
            if (C5046bo.isNullOrNil(name)) {
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
            list.add(new C21430a((String) entry.getKey(), ((Integer) entry.getValue()).intValue()));
        }
        Collections.sort(list, new C346711());
        AppMethodBeat.m2505o(138544);
        return i2;
    }

    public final void onActivityStopped(Activity activity) {
        Object obj;
        AppMethodBeat.m2504i(111084);
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
                int bZs = C34670b.bZs();
                int cy = C34670b.m56930cy(linkedList);
                if (bZs > 500) {
                    C7053e.pXa.mo8378a(960, 101, 1, true);
                    RuntimeException runtimeException = new RuntimeException("MicroMsg.ThreadWatchDog" + String.format("\nThreadOver[%s:%s]: %s", new Object[]{Integer.valueOf(cy), Integer.valueOf(bZs), linkedList.toString()}));
                    AppMethodBeat.m2505o(111084);
                    throw runtimeException;
                }
                if (bZs > 300) {
                    C7053e.pXa.mo8374X(16470, String.format("ThreadOver[%s:%s]: %s", new Object[]{Integer.valueOf(cy), Integer.valueOf(bZs), linkedList.toString()}));
                    C7053e.pXa.mo8378a(960, 100, 1, true);
                } else if (bZs > 200) {
                    C7053e.pXa.mo8378a(960, 102, 1, true);
                } else if (bZs > 150) {
                    C7053e.pXa.mo8378a(960, 103, 1, true);
                }
                if (cy > 500) {
                    C7053e.pXa.mo8378a(960, 104, 1, true);
                } else if (cy > 300) {
                    C7053e.pXa.mo8378a(960, 105, 1, true);
                } else if (cy > 200) {
                    C7053e.pXa.mo8378a(960, 106, 1, true);
                } else if (cy > 150) {
                    C7053e.pXa.mo8378a(960, 107, 1, true);
                }
                C4990ab.m7421w("MicroMsg.ThreadWatchDog", "[wang][%s:%s]:%s", Integer.valueOf(cy), Integer.valueOf(bZs), linkedList.toString());
                C4990ab.m7411d("MicroMsg.ThreadWatchDog", "[wang] Cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                AppMethodBeat.m2505o(111084);
            } catch (Throwable th) {
                C4990ab.m7411d("MicroMsg.ThreadWatchDog", "[wang] Cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                AppMethodBeat.m2505o(111084);
            }
        } else {
            AppMethodBeat.m2505o(111084);
        }
    }
}
