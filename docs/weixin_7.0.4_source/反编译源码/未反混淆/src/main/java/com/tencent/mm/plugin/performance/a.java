package com.tencent.mm.plugin.performance;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.widget.Toast;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
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

public final class a implements ActivityLifecycleCallbacks {
    public static final a peX = new a();
    public boolean aFV;
    public boolean caA = false;
    public Handler handler;
    private long mLastTime;
    HandlerThread oAl = new HandlerThread("PowerTest");
    public a peW = new a();
    public volatile boolean peY = false;
    private HashMap<String, Long> peZ = new HashMap();
    private HashMap<Integer, Long> pfa = new HashMap();

    static class c {
        String name;
        long pfd;
        long pfe;
        int tid;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(111023);
            String format = String.format("%s(%s) diff:%s", new Object[]{this.name, Integer.valueOf(this.tid), Long.valueOf(this.pfe)});
            AppMethodBeat.o(111023);
            return format;
        }
    }

    static class b {
        String name;
        long pfd;
        long pfe;
        long pff;
        int pid;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(111022);
            int indexOf = this.name.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            String substring = indexOf > 0 ? this.name.substring(indexOf + 1) : "main";
            substring = String.format(" %s(%s) diff:%s allThreadSumDiff:%s", new Object[]{substring, Integer.valueOf(this.pid), Long.valueOf(this.pfe), Long.valueOf(this.pff)});
            AppMethodBeat.o(111022);
            return substring;
        }

        public final int hashCode() {
            return this.pid;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof b) && ((b) obj).pid == this.pid) {
                return true;
            }
            return false;
        }
    }

    public class a implements Runnable {
        public boolean pfc;

        a() {
        }

        public final void run() {
            AppMethodBeat.i(111021);
            List<b> linkedList = new LinkedList();
            int a = a.a(a.this, this.pfc, (List) linkedList);
            if (a > 0) {
                Object obj = null;
                for (b bVar : linkedList) {
                    long j = bVar.pff / ((long) a);
                    if (j > 0) {
                        Object obj2;
                        ArrayList arrayList = new ArrayList(4);
                        IDKey iDKey = new IDKey();
                        iDKey.SetID(1013);
                        iDKey.SetKey(a.a(j, bVar));
                        iDKey.SetValue(1);
                        arrayList.add(iDKey);
                        iDKey = new IDKey();
                        iDKey.SetValue(j);
                        iDKey.SetID(1013);
                        iDKey.SetKey(a.a(bVar));
                        arrayList.add(iDKey);
                        iDKey = new IDKey();
                        iDKey.SetID(1013);
                        iDKey.SetKey(a.b(bVar));
                        iDKey.SetValue(1);
                        arrayList.add(iDKey);
                        e.pXa.b(arrayList, false);
                        if (j > 1000) {
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                }
                if (obj != null && bp.dpJ()) {
                    Toast.makeText(ah.getContext(), String.format("微信后台 %s min严重耗电!", new Object[]{Integer.valueOf(a)}), Downloads.MIN_WAIT_FOR_NETWORK).show();
                }
            }
            a.this.peY = true;
            AppMethodBeat.o(111021);
        }
    }

    static {
        AppMethodBeat.i(111038);
        AppMethodBeat.o(111038);
    }

    private a() {
        AppMethodBeat.i(111024);
        AppMethodBeat.o(111024);
    }

    public final void onActivityStarted(Activity activity) {
        AppMethodBeat.i(111025);
        if (this.caA) {
            AppMethodBeat.o(111025);
            return;
        }
        ab.i("MicroMsg.PowerTest", "come back Foreground! isHasRunAtBackground:%s", Boolean.valueOf(this.peY));
        this.handler.removeCallbacks(this.peW);
        if (this.peY && !this.peW.pfc) {
            this.peW.pfc = true;
            this.handler.post(this.peW);
        }
        AppMethodBeat.o(111025);
    }

    private static void a(long j, long j2, HashMap<b, List<c>> hashMap) {
        AppMethodBeat.i(111026);
        StringBuilder stringBuilder = new StringBuilder(" \n");
        stringBuilder.append("********************************* PowerTest ******************************\n");
        stringBuilder.append(String.format("during:%smin", new Object[]{Long.valueOf(j2)})).append("    diff:").append(j).append(String.format("    average:%s/min", new Object[]{Long.valueOf(j / j2)})).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("*****************************微信各进程耗电信息*****************************\n");
        for (Entry entry : hashMap.entrySet()) {
            b bVar = (b) entry.getKey();
            if (bVar.pff > 0) {
                stringBuilder.append("| *").append(bVar.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                for (c cVar : (List) entry.getValue()) {
                    stringBuilder.append("|    -> ").append(cVar.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
        }
        stringBuilder.append("********************************************************************\n");
        ab.i("MicroMsg.PowerTest", stringBuilder.toString());
        AppMethodBeat.o(111026);
    }

    private void a(Set<b> set, boolean z) {
        AppMethodBeat.i(111027);
        for (b bVar : g(set)) {
            if (z) {
                bVar.pfe = bVar.pfd - (this.pfa.containsKey(Integer.valueOf(bVar.pid)) ? ((Long) this.pfa.get(Integer.valueOf(bVar.pid))).longValue() : 0);
                set.add(bVar);
            } else {
                this.pfa.put(Integer.valueOf(bVar.pid), Long.valueOf(bVar.pfd));
            }
        }
        AppMethodBeat.o(111027);
    }

    private List<c> a(int i, b bVar, List<c> list, boolean z) {
        c cVar;
        AppMethodBeat.i(111028);
        LinkedList linkedList = new LinkedList();
        for (c cVar2 : AK(i)) {
            String str = i + "#" + cVar2.tid;
            if (z) {
                long longValue = this.peZ.containsKey(str) ? ((Long) this.peZ.get(str)).longValue() : 0;
                if (longValue == 0 && cVar2.pfd > 0) {
                    ab.w("MicroMsg.PowerTest", "[dumpThread] new Thread? %s", cVar2);
                }
                cVar2.pfe = cVar2.pfd - longValue;
                if (cVar2.pfe > 0) {
                    bVar.pff += cVar2.pfe;
                    linkedList.add(cVar2);
                }
            } else {
                this.peZ.put(str, Long.valueOf(cVar2.pfd));
            }
        }
        Collections.sort(linkedList, new Comparator<c>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(111020);
                int compare = Long.compare(((c) obj2).pfe, ((c) obj).pfe);
                AppMethodBeat.o(111020);
                return compare;
            }
        });
        int i2 = 0;
        Iterator it = linkedList.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                cVar2 = (c) it.next();
                if (((float) cVar2.pfe) >= ((float) bVar.pff) * 0.1f && i3 < 12) {
                    list.add(cVar2);
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(111028);
                return list;
            }
        }
    }

    private static Set<b> g(Set<b> set) {
        AppMethodBeat.i(111029);
        String str = "/proc/";
        File file = new File(str);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(111029);
                return set;
            }
            for (File name : listFiles) {
                try {
                    String stringFromFile = getStringFromFile(str + name.getName() + "/stat");
                    if (stringFromFile != null) {
                        String[] split = stringFromFile.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "").split(" ");
                        b bVar = new b();
                        bVar.pid = bo.ank(split[0]);
                        bVar.name = split[1].replace("(", "").replace(")", "");
                        if (bVar.name.contains("ncent.mm") || bVar.name.contains(".mm:")) {
                            bVar.pfd = eT(0, bVar.pid);
                            set.add(bVar);
                            ab.i("MicroMsg.PowerTest", "[getAllSelfProcess] file:%s content:%s", name.getName(), stringFromFile);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.o(111029);
        return set;
    }

    private static Set<c> AK(int i) {
        int i2 = 0;
        AppMethodBeat.i(111030);
        HashSet hashSet = new HashSet();
        String format = String.format("/proc/%s/task/", new Object[]{Integer.valueOf(i)});
        File file = new File(format);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(111030);
                return hashSet;
            }
            int length = listFiles.length;
            while (i2 < length) {
                try {
                    String stringFromFile = getStringFromFile(format + listFiles[i2].getName() + "/stat");
                    if (stringFromFile != null) {
                        String[] split = stringFromFile.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "").split(" ");
                        c cVar = new c();
                        cVar.tid = bo.ank(split[0]);
                        cVar.name = split[1].replace("(", "").replace(")", "");
                        if (cVar.tid == i) {
                            cVar.name = "main";
                        }
                        if (bo.isNullOrNil(cVar.name)) {
                            cVar.name = "unKnow-" + cVar.tid;
                        }
                        cVar.pfd = eT(cVar.tid, i);
                        hashSet.add(cVar);
                    }
                } catch (Exception e) {
                }
                i2++;
            }
        }
        AppMethodBeat.o(111030);
        return hashSet;
    }

    private static long eT(int i, int i2) {
        String format;
        long j = -1;
        AppMethodBeat.i(111031);
        if (i == 0) {
            format = String.format("/proc/%s/stat", new Object[]{Integer.valueOf(i2)});
        } else {
            format = String.format("/proc/%s/task/%s/stat", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        }
        try {
            format = getStringFromFile(format);
            if (format == null) {
                AppMethodBeat.o(111031);
                return j;
            }
            String[] split = format.split(" ");
            long anl = bo.anl(split[13]);
            long anl2 = bo.anl(split[14]);
            long anl3 = bo.anl(split[15]);
            j = bo.anl(split[16]) + ((anl + anl2) + anl3);
            AppMethodBeat.o(111031);
            return j;
        } catch (Exception e) {
            AppMethodBeat.o(111031);
            return j;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String convertStreamToString(InputStream inputStream) {
        Throwable th;
        AppMethodBeat.i(111032);
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
                        AppMethodBeat.o(111032);
                        return stringBuilder2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    AppMethodBeat.o(111032);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            AppMethodBeat.o(111032);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String getStringFromFile(String str) {
        Throwable th;
        AppMethodBeat.i(111033);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                String convertStreamToString = convertStreamToString(fileInputStream);
                fileInputStream.close();
                AppMethodBeat.o(111033);
                return convertStreamToString;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                AppMethodBeat.o(111033);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            AppMethodBeat.o(111033);
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

    static /* synthetic */ int b(b bVar) {
        int i = 0;
        AppMethodBeat.i(111037);
        if (bVar.pid != Process.myPid()) {
            if (bVar.name.contains(".mm:tools")) {
                i = 20;
            } else if (bVar.name.contains(".mm:push")) {
                i = 40;
            } else if (bVar.name.contains(".mm:exdevice")) {
                i = 60;
            } else if (bVar.name.contains(".mm:sandbox")) {
                i = 80;
            } else if (bVar.name.contains(".mm:appbrand")) {
                i = 100;
            } else if (bVar.name.contains(".mm:toolsmp")) {
                i = 120;
            }
        }
        i += 18;
        AppMethodBeat.o(111037);
        return i;
    }
}
