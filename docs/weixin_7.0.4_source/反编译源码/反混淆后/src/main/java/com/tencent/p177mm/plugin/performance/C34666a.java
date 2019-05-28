package com.tencent.p177mm.plugin.performance;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.widget.Toast;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.performance.a */
public final class C34666a implements ActivityLifecycleCallbacks {
    public static final C34666a peX = new C34666a();
    public boolean aFV;
    public boolean caA = false;
    public Handler handler;
    private long mLastTime;
    HandlerThread oAl = new HandlerThread("PowerTest");
    public C34668a peW = new C34668a();
    public volatile boolean peY = false;
    private HashMap<String, Long> peZ = new HashMap();
    private HashMap<Integer, Long> pfa = new HashMap();

    /* renamed from: com.tencent.mm.plugin.performance.a$c */
    static class C12801c {
        String name;
        long pfd;
        long pfe;
        int tid;

        private C12801c() {
        }

        /* synthetic */ C12801c(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.m2504i(111023);
            String format = String.format("%s(%s) diff:%s", new Object[]{this.name, Integer.valueOf(this.tid), Long.valueOf(this.pfe)});
            AppMethodBeat.m2505o(111023);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.plugin.performance.a$1 */
    class C286641 implements Comparator<C12801c> {
        C286641() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(111020);
            int compare = Long.compare(((C12801c) obj2).pfe, ((C12801c) obj).pfe);
            AppMethodBeat.m2505o(111020);
            return compare;
        }
    }

    /* renamed from: com.tencent.mm.plugin.performance.a$b */
    static class C34667b {
        String name;
        long pfd;
        long pfe;
        long pff;
        int pid;

        private C34667b() {
        }

        /* synthetic */ C34667b(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.m2504i(111022);
            int indexOf = this.name.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            String substring = indexOf > 0 ? this.name.substring(indexOf + 1) : "main";
            substring = String.format(" %s(%s) diff:%s allThreadSumDiff:%s", new Object[]{substring, Integer.valueOf(this.pid), Long.valueOf(this.pfe), Long.valueOf(this.pff)});
            AppMethodBeat.m2505o(111022);
            return substring;
        }

        public final int hashCode() {
            return this.pid;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof C34667b) && ((C34667b) obj).pid == this.pid) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.performance.a$a */
    public class C34668a implements Runnable {
        public boolean pfc;

        C34668a() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111021);
            List<C34667b> linkedList = new LinkedList();
            int a = C34666a.m56913a(C34666a.this, this.pfc, (List) linkedList);
            if (a > 0) {
                Object obj = null;
                for (C34667b c34667b : linkedList) {
                    long j = c34667b.pff / ((long) a);
                    if (j > 0) {
                        Object obj2;
                        ArrayList arrayList = new ArrayList(4);
                        IDKey iDKey = new IDKey();
                        iDKey.SetID(1013);
                        iDKey.SetKey(C34666a.m56911a(j, c34667b));
                        iDKey.SetValue(1);
                        arrayList.add(iDKey);
                        iDKey = new IDKey();
                        iDKey.SetValue(j);
                        iDKey.SetID(1013);
                        iDKey.SetKey(C34666a.m56912a(c34667b));
                        arrayList.add(iDKey);
                        iDKey = new IDKey();
                        iDKey.SetID(1013);
                        iDKey.SetKey(C34666a.m56918b(c34667b));
                        iDKey.SetValue(1);
                        arrayList.add(iDKey);
                        C7053e.pXa.mo8379b(arrayList, false);
                        if (j > 1000) {
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                }
                if (obj != null && C5047bp.dpJ()) {
                    Toast.makeText(C4996ah.getContext(), String.format("微信后台 %s min严重耗电!", new Object[]{Integer.valueOf(a)}), Downloads.MIN_WAIT_FOR_NETWORK).show();
                }
            }
            C34666a.this.peY = true;
            AppMethodBeat.m2505o(111021);
        }
    }

    static {
        AppMethodBeat.m2504i(111038);
        AppMethodBeat.m2505o(111038);
    }

    private C34666a() {
        AppMethodBeat.m2504i(111024);
        AppMethodBeat.m2505o(111024);
    }

    public final void onActivityStarted(Activity activity) {
        AppMethodBeat.m2504i(111025);
        if (this.caA) {
            AppMethodBeat.m2505o(111025);
            return;
        }
        C4990ab.m7417i("MicroMsg.PowerTest", "come back Foreground! isHasRunAtBackground:%s", Boolean.valueOf(this.peY));
        this.handler.removeCallbacks(this.peW);
        if (this.peY && !this.peW.pfc) {
            this.peW.pfc = true;
            this.handler.post(this.peW);
        }
        AppMethodBeat.m2505o(111025);
    }

    /* renamed from: a */
    private static void m56915a(long j, long j2, HashMap<C34667b, List<C12801c>> hashMap) {
        AppMethodBeat.m2504i(111026);
        StringBuilder stringBuilder = new StringBuilder(" \n");
        stringBuilder.append("********************************* PowerTest ******************************\n");
        stringBuilder.append(String.format("during:%smin", new Object[]{Long.valueOf(j2)})).append("    diff:").append(j).append(String.format("    average:%s/min", new Object[]{Long.valueOf(j / j2)})).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("*****************************微信各进程耗电信息*****************************\n");
        for (Entry entry : hashMap.entrySet()) {
            C34667b c34667b = (C34667b) entry.getKey();
            if (c34667b.pff > 0) {
                stringBuilder.append("| *").append(c34667b.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                for (C12801c c12801c : (List) entry.getValue()) {
                    stringBuilder.append("|    -> ").append(c12801c.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
        }
        stringBuilder.append("********************************************************************\n");
        C4990ab.m7416i("MicroMsg.PowerTest", stringBuilder.toString());
        AppMethodBeat.m2505o(111026);
    }

    /* renamed from: a */
    private void m56916a(Set<C34667b> set, boolean z) {
        AppMethodBeat.m2504i(111027);
        for (C34667b c34667b : C34666a.m56920g(set)) {
            if (z) {
                c34667b.pfe = c34667b.pfd - (this.pfa.containsKey(Integer.valueOf(c34667b.pid)) ? ((Long) this.pfa.get(Integer.valueOf(c34667b.pid))).longValue() : 0);
                set.add(c34667b);
            } else {
                this.pfa.put(Integer.valueOf(c34667b.pid), Long.valueOf(c34667b.pfd));
            }
        }
        AppMethodBeat.m2505o(111027);
    }

    /* renamed from: a */
    private List<C12801c> m56914a(int i, C34667b c34667b, List<C12801c> list, boolean z) {
        C12801c c12801c;
        AppMethodBeat.m2504i(111028);
        LinkedList linkedList = new LinkedList();
        for (C12801c c12801c2 : C34666a.m56910AK(i)) {
            String str = i + "#" + c12801c2.tid;
            if (z) {
                long longValue = this.peZ.containsKey(str) ? ((Long) this.peZ.get(str)).longValue() : 0;
                if (longValue == 0 && c12801c2.pfd > 0) {
                    C4990ab.m7421w("MicroMsg.PowerTest", "[dumpThread] new Thread? %s", c12801c2);
                }
                c12801c2.pfe = c12801c2.pfd - longValue;
                if (c12801c2.pfe > 0) {
                    c34667b.pff += c12801c2.pfe;
                    linkedList.add(c12801c2);
                }
            } else {
                this.peZ.put(str, Long.valueOf(c12801c2.pfd));
            }
        }
        Collections.sort(linkedList, new C286641());
        int i2 = 0;
        Iterator it = linkedList.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                c12801c2 = (C12801c) it.next();
                if (((float) c12801c2.pfe) >= ((float) c34667b.pff) * 0.1f && i3 < 12) {
                    list.add(c12801c2);
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(111028);
                return list;
            }
        }
    }

    /* renamed from: g */
    private static Set<C34667b> m56920g(Set<C34667b> set) {
        AppMethodBeat.m2504i(111029);
        String str = "/proc/";
        File file = new File(str);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.m2505o(111029);
                return set;
            }
            for (File name : listFiles) {
                try {
                    String stringFromFile = C34666a.getStringFromFile(str + name.getName() + "/stat");
                    if (stringFromFile != null) {
                        String[] split = stringFromFile.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "").split(" ");
                        C34667b c34667b = new C34667b();
                        c34667b.pid = C5046bo.ank(split[0]);
                        c34667b.name = split[1].replace("(", "").replace(")", "");
                        if (c34667b.name.contains("ncent.mm") || c34667b.name.contains(".mm:")) {
                            c34667b.pfd = C34666a.m56919eT(0, c34667b.pid);
                            set.add(c34667b);
                            C4990ab.m7417i("MicroMsg.PowerTest", "[getAllSelfProcess] file:%s content:%s", name.getName(), stringFromFile);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.m2505o(111029);
        return set;
    }

    /* renamed from: AK */
    private static Set<C12801c> m56910AK(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(111030);
        HashSet hashSet = new HashSet();
        String format = String.format("/proc/%s/task/", new Object[]{Integer.valueOf(i)});
        File file = new File(format);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.m2505o(111030);
                return hashSet;
            }
            int length = listFiles.length;
            while (i2 < length) {
                try {
                    String stringFromFile = C34666a.getStringFromFile(format + listFiles[i2].getName() + "/stat");
                    if (stringFromFile != null) {
                        String[] split = stringFromFile.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "").split(" ");
                        C12801c c12801c = new C12801c();
                        c12801c.tid = C5046bo.ank(split[0]);
                        c12801c.name = split[1].replace("(", "").replace(")", "");
                        if (c12801c.tid == i) {
                            c12801c.name = "main";
                        }
                        if (C5046bo.isNullOrNil(c12801c.name)) {
                            c12801c.name = "unKnow-" + c12801c.tid;
                        }
                        c12801c.pfd = C34666a.m56919eT(c12801c.tid, i);
                        hashSet.add(c12801c);
                    }
                } catch (Exception e) {
                }
                i2++;
            }
        }
        AppMethodBeat.m2505o(111030);
        return hashSet;
    }

    /* renamed from: eT */
    private static long m56919eT(int i, int i2) {
        String format;
        long j = -1;
        AppMethodBeat.m2504i(111031);
        if (i == 0) {
            format = String.format("/proc/%s/stat", new Object[]{Integer.valueOf(i2)});
        } else {
            format = String.format("/proc/%s/task/%s/stat", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        }
        try {
            format = C34666a.getStringFromFile(format);
            if (format == null) {
                AppMethodBeat.m2505o(111031);
                return j;
            }
            String[] split = format.split(" ");
            long anl = C5046bo.anl(split[13]);
            long anl2 = C5046bo.anl(split[14]);
            long anl3 = C5046bo.anl(split[15]);
            j = C5046bo.anl(split[16]) + ((anl + anl2) + anl3);
            AppMethodBeat.m2505o(111031);
            return j;
        } catch (Exception e) {
            AppMethodBeat.m2505o(111031);
            return j;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String convertStreamToString(InputStream inputStream) {
        Throwable th;
        AppMethodBeat.m2504i(111032);
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuilder.append(readLine).append(10);
                    } else {
                        bufferedReader.close();
                        String stringBuilder2 = stringBuilder.toString();
                        AppMethodBeat.m2505o(111032);
                        return stringBuilder2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    AppMethodBeat.m2505o(111032);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            AppMethodBeat.m2505o(111032);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String getStringFromFile(String str) {
        Throwable th;
        AppMethodBeat.m2504i(111033);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                String convertStreamToString = C34666a.convertStreamToString(fileInputStream);
                fileInputStream.close();
                AppMethodBeat.m2505o(111033);
                return convertStreamToString;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                AppMethodBeat.m2505o(111033);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(111033);
            throw th;
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    /* renamed from: b */
    static /* synthetic */ int m56918b(C34667b c34667b) {
        int i = 0;
        AppMethodBeat.m2504i(111037);
        if (c34667b.pid != Process.myPid()) {
            if (c34667b.name.contains(".mm:tools")) {
                i = 20;
            } else if (c34667b.name.contains(".mm:push")) {
                i = 40;
            } else if (c34667b.name.contains(".mm:exdevice")) {
                i = 60;
            } else if (c34667b.name.contains(".mm:sandbox")) {
                i = 80;
            } else if (c34667b.name.contains(".mm:appbrand")) {
                i = 100;
            } else if (c34667b.name.contains(".mm:toolsmp")) {
                i = 120;
            }
        }
        i += 18;
        AppMethodBeat.m2505o(111037);
        return i;
    }
}
