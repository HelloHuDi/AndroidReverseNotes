package com.tencent.p177mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.app.AppOpsManager;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.p052pm.IPackageStatsObserver;
import android.content.p052pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.p177mm.compatible.p221e.C1414ab;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C1842cf;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p179ac.C1185a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.p1283p.C21428c;
import com.tencent.p177mm.plugin.p1283p.C21429d;
import com.tencent.p177mm.plugin.performance.p1011b.C34670b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4871a;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p599a.C4873c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5013ao;
import com.tencent.p177mm.sdk.platformtools.C5013ao.C5010b;
import com.tencent.p177mm.sdk.platformtools.C5013ao.C5011c;
import com.tencent.p177mm.sdk.platformtools.C5013ao.C5012d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.p177mm.sdk.platformtools.CrashMonitorForJni.C4979a;
import com.tencent.recovery.Recovery;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
import com.tencent.xweb.WebView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.AssertionFailedError;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.app.l */
public class C25794l implements C4873c, C5012d {
    public static final long ceA = C5046bo.anU();
    private static final String ceI;
    private static final String ceJ;
    private static String ceK = "";
    private static final String ceL = ("version:" + C7243d.vxo);
    private static long[] ceM = new long[]{0, 0, 0};
    private static C4979a sCrashExtraMessageGetter = new C257921();
    private C5013ao ceB = null;
    private C25796a ceC;
    private volatile long ceD = 0;
    HashSet<String> ceE;
    String ceF;
    String ceG;
    ConditionVariable ceH;
    volatile C25797b ceN;

    /* renamed from: com.tencent.mm.app.l$1 */
    static class C257921 implements C4979a {
        C257921() {
        }

        /* renamed from: Bu */
        public final String mo10218Bu() {
            StringBuilder stringBuilder = new StringBuilder();
            String processName = C4996ah.getProcessName();
            if (processName != null && (processName.contains(":tools") || processName.contains(":appbrand"))) {
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                processName = WebView.getCrashExtraMessage(C4996ah.getContext());
                if (processName != null && processName.length() > 0) {
                    processName = processName + String.format(Locale.US, "client_version:%s;", new Object[]{C5058f.CLIENT_VERSION});
                    if (processName.length() > Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                        processName = processName.substring(processName.length() - 8192);
                    }
                    stringBuilder.append("#qbrowser.crashmsg=" + Base64.encodeToString(processName.getBytes(), 2));
                    C4990ab.m7419v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", processName);
                }
            }
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.tencent.mm.app.l$2 */
    static class C257932 {
        C257932() {
        }
    }

    /* renamed from: com.tencent.mm.app.l$4 */
    static class C257954 extends Stub {
        C257954() {
        }

        public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
            if (packageStats != null) {
                try {
                    C25794l.ceM[0] = packageStats.cacheSize;
                    C25794l.ceM[1] = packageStats.dataSize;
                    C25794l.ceM[2] = packageStats.codeSize;
                    C4990ab.m7417i("MicroMsg.MMCrashReporter", "onGetStatsCompleted succeeded[%b] cacheSize :%d ,dataSize :%d ,codeSize :%d ", Boolean.valueOf(z), Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                } catch (Throwable th) {
                    C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", th, "onGetStatsCompleted", new Object[0]);
                    return;
                }
            }
            C4990ab.m7417i("MicroMsg.MMCrashReporter", "onGetStatsCompleted pStats is null succeeded[%b]", Boolean.valueOf(z));
            synchronized (C25794l.ceM) {
                C25794l.ceM.notify();
            }
        }
    }

    /* renamed from: com.tencent.mm.app.l$a */
    class C25796a extends FileObserver {
        C25796a(String str) {
            super(str, 712);
        }

        public final void onEvent(int i, String str) {
            Object obj = null;
            if (System.currentTimeMillis() - C25794l.this.ceD < 120000) {
                obj = 1;
            }
            if (obj == null) {
                synchronized (C25794l.this.ceE) {
                    switch (i) {
                        case 8:
                            C4990ab.m7416i("MicroMsg.MMCrashReporter", "Detected trace file changed: ".concat(String.valueOf(str)));
                            C25794l.this.ceH.open();
                            if (C25794l.this.ceN == null) {
                                C25794l.this.ceN = new C25797b(C25794l.this, (byte) 0);
                                C7305d.post(C25794l.this.ceN, "MMCrashReporter_parseANRTrace");
                                break;
                            }
                            break;
                        case 64:
                        case 512:
                            C25794l.this.ceE.remove(str);
                            break;
                        case 128:
                            break;
                    }
                    C25794l.this.ceE.add(str);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.app.l$b */
    class C25797b implements Runnable {
        private C25797b() {
        }

        /* synthetic */ C25797b(C25794l c25794l, byte b) {
            this();
        }

        /* renamed from: Bv */
        private static ProcessErrorStateInfo m41026Bv() {
            List<ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) C4996ah.getContext().getSystemService("activity")).getProcessesInErrorState();
            if (processesInErrorState == null) {
                return null;
            }
            for (ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.uid == Process.myUid() && processErrorStateInfo.condition == 2) {
                    return processErrorStateInfo;
                }
            }
            return null;
        }

        public final void run() {
            ArrayList arrayList;
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7416i("MicroMsg.MMCrashReporter", "ANR Parser started.");
            ProcessErrorStateInfo processErrorStateInfo = null;
            while (C25794l.this.ceH.block(10000)) {
                C25794l.this.ceH.close();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
                processErrorStateInfo = C25797b.m41026Bv();
                if (processErrorStateInfo != null) {
                    break;
                }
            }
            if (processErrorStateInfo == null) {
                processErrorStateInfo = C25797b.m41026Bv();
                if (processErrorStateInfo == null) {
                    C4990ab.m7420w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
                    C25794l.this.ceN = null;
                    return;
                }
            }
            ProcessErrorStateInfo processErrorStateInfo2 = processErrorStateInfo;
            C4990ab.m7416i("MicroMsg.MMCrashReporter", "Got ANR process: " + processErrorStateInfo2.processName + " @ " + processErrorStateInfo2.pid);
            synchronized (C25794l.this.ceE) {
                arrayList = new ArrayList(C25794l.this.ceE.size());
                int lastIndexOf = C25794l.this.ceG.lastIndexOf(46);
                if (lastIndexOf != -1) {
                    str = C25794l.this.ceG.substring(0, lastIndexOf) + '_' + processErrorStateInfo2.processName + C25794l.this.ceG.substring(lastIndexOf);
                    if (C25794l.this.ceE.remove(str)) {
                        arrayList.add(str);
                    }
                }
                if (C25794l.this.ceE.remove(C25794l.this.ceG)) {
                    arrayList.add(C25794l.this.ceG);
                }
                arrayList.addAll(C25794l.this.ceE);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                str = C25794l.m41012a(C25794l.this.ceF + IOUtils.DIR_SEPARATOR_UNIX + ((String) it.next()), processErrorStateInfo2.pid, currentTimeMillis, processErrorStateInfo2);
                if (str != null) {
                    C4990ab.m7417i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", r0);
                    C25794l.this.mo43750s(str, processErrorStateInfo2.pid);
                    break;
                }
                C4990ab.m7417i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", r0);
            }
            C4990ab.m7416i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
            C25794l.this.ceN = null;
        }
    }

    static {
        String LM = C1427q.m3028LM();
        ceI = LM;
        ceJ = C1183p.getString(LM.hashCode());
    }

    /* renamed from: Bo */
    private static String m41005Bo() {
        String T = C6665av.fly.mo5292T("login_weixin_username", "");
        if (C5046bo.isNullOrNil(T)) {
            return C6665av.fly.mo5292T("login_user_name", "never_login_crash");
        }
        return T;
    }

    /* renamed from: cT */
    public static boolean m41016cT(String str) {
        Object obj = null;
        ceK = str;
        if (C21429d.bQU() == null) {
            Object cls;
            try {
                cls = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "setup sanbox Failed printing stack trace1.", new Object[0]);
                cls = obj;
            }
            try {
                obj = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, C4996ah.getContext().getClassLoader());
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "setup sanbox Failed printing stack trace2.", new Object[0]);
            }
            C4990ab.m7416i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + cls + " thisProcName: " + ceK);
            C4990ab.m7416i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + obj + " thisProcName: " + ceK);
            Class hM = C25985d.m41475hM("sandbox", ".SubCoreSandBox");
            C4990ab.m7416i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + hM + " thisProcName: " + ceK);
            if (hM != null) {
                try {
                    C21428c c21428c = (C21428c) hM.newInstance();
                    C21429d.m32854a(c21428c);
                    C4990ab.m7416i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + c21428c + " thisProcName: " + ceK);
                } catch (Exception e3) {
                    C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e3, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", e3.getClass().getSimpleName(), e3.getMessage());
                }
            }
        }
        C4873c c4873c;
        try {
            c4873c = (C4873c) Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
            c4873c.mo10039aX(C4996ah.getContext());
            C6665av.fly.mo5292T("last_login_uin", ceJ);
            C4872b.m7235a(c4873c);
            C257932 c257932 = new C257932();
            return true;
        } catch (Exception e4) {
            C4990ab.m7420w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
            c4873c = new C25794l();
            c4873c.mo10039aX(C4996ah.getContext());
            C4872b.m7235a(c4873c);
            String str2 = C1414ab.get("ro.product.cpu.abi");
            if (str2 == null || str2.length() == 0 || !(str2.equals("x86") || str2.equals("x86-64"))) {
                C1449k.m3079a("wechatCrashForJni", C25794l.class.getClassLoader());
                str2 = ceL;
                if (str.contains(":tools") || str.contains(":appbrand") || str.contains(":support")) {
                    str2 = str2 + IOUtils.LINE_SEPARATOR_UNIX + WebView.getCrashExtraMessage(C4996ah.getContext()) + String.format(Locale.US, "client_version:%s;", new Object[]{C5058f.CLIENT_VERSION}) + IOUtils.LINE_SEPARATOR_UNIX;
                    C4990ab.m7417i("MicroMsg.MMCrashReporter", "append crash extra message : %s", str2);
                }
                CrashMonitorForJni.setCrashExtraMessageGetter(sCrashExtraMessageGetter);
                CrashMonitorForJni.setClientVersionMsg(str2);
            }
            C1842cf.m3789oO(C6457e.eSj);
            return false;
        }
    }

    /* renamed from: a */
    public static void m41013a(C5011c c5011c) {
        C5013ao.m7457a(c5011c);
    }

    /* renamed from: cU */
    private static void m41017cU(String str) {
        while (str.length() > 896) {
            try {
                int lastIndexOf = str.substring(0, 896).lastIndexOf(IOUtils.LINE_SEPARATOR_UNIX);
                if (-1 == lastIndexOf) {
                    break;
                }
                C4990ab.m7412e("MicroMsg.MMCrashReporter", str.substring(0, lastIndexOf));
                str = str.substring(lastIndexOf + 1);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed printing stack trace.", new Object[0]);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.MMCrashReporter", str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fc A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f9 A:{SYNTHETIC, Splitter:B:35:0x00f9} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0153 A:{SYNTHETIC, Splitter:B:54:0x0153} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aX */
    public final void mo10039aX(final Context context) {
        Throwable e;
        C5013ao.m7458a((C5012d) this);
        if (ceK.endsWith(":push")) {
            String str;
            try {
                str = C1414ab.get("dalvik.vm.stack-trace-file");
                if (str == null || str.length() == 0) {
                    str = "/data/anr/traces.txt";
                }
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed finding out ANR trace file path, using default.", new Object[0]);
                str = "/data/anr/traces.txt";
            }
            File file = new File(str);
            this.ceF = file.getParent();
            if (this.ceF == null || this.ceF.length() == 0) {
                this.ceF = "/";
            }
            this.ceG = file.getName();
            this.ceH = new ConditionVariable();
            C4990ab.m7416i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: ".concat(String.valueOf(str)));
            this.ceE = new HashSet();
            this.ceC = new C25796a(this.ceF);
            this.ceC.startWatching();
            File[] listFiles = new File(context.getFilesDir(), AppMeasurement.CRASH_ORIGIN).listFiles(new FilenameFilter() {
                String ceO = context.getPackageName();

                public final boolean accept(File file, String str) {
                    return str.startsWith(this.ceO);
                }
            });
            if (listFiles != null) {
                StringBuilder stringBuilder = new StringBuilder(16384);
                Pattern compile = Pattern.compile("^signal (\\d+) \\([A-Z]+\\), code ");
                for (Object obj : listFiles) {
                    int i = -1;
                    C4990ab.m7416i("MicroMsg.MMCrashReporter", "Uploading previous crash: ".concat(String.valueOf(obj)));
                    BufferedReader bufferedReader;
                    try {
                        bufferedReader = new BufferedReader(new FileReader(obj));
                        try {
                            String readLine;
                            stringBuilder.setLength(0);
                            while (true) {
                                readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (i < 0) {
                                    Matcher matcher = compile.matcher(readLine);
                                    if (matcher.matches()) {
                                        i = C5046bo.getInt(matcher.group(1), 0);
                                    }
                                }
                                stringBuilder.append(readLine).append(10);
                            }
                            if (stringBuilder.toString().startsWith(ceL)) {
                                readLine = stringBuilder.toString().substring(stringBuilder.toString().indexOf(ceL) + ceL.length());
                                if (readLine != null && readLine.trim().length() > 0) {
                                    C25794l.m41014b(i, readLine, true);
                                }
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                            }
                        } catch (IOException e4) {
                            e = e4;
                            try {
                                C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed uploading previous crash: ".concat(String.valueOf(obj)), new Object[0]);
                                if (bufferedReader == null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                obj.delete();
                            } catch (Throwable th) {
                                e = th;
                                if (bufferedReader != null) {
                                }
                                throw e;
                            }
                        }
                    } catch (IOException e6) {
                        e = e6;
                        bufferedReader = null;
                        C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed uploading previous crash: ".concat(String.valueOf(obj)), new Object[0]);
                        if (bufferedReader == null) {
                        }
                        obj.delete();
                    } catch (Throwable th2) {
                        e = th2;
                        bufferedReader = null;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e7) {
                            }
                        }
                        throw e;
                    }
                    obj.delete();
                }
            }
        }
    }

    /* renamed from: A */
    public final void mo10037A(String str, String str2) {
        if (C21429d.bQU() != null) {
            Intent intent = new Intent();
            intent.setAction("custom_exception");
            intent.putExtra("userName", C25794l.m41005Bo());
            intent.putExtra("tag", str2);
            intent.putExtra("exceptionMsg", str);
            C21429d.bQU().mo36884x(C4996ah.getContext(), intent);
        }
    }

    /* renamed from: a */
    public final void mo10038a(C4871a c4871a) {
        C5013ao.m7455a(c4871a);
    }

    /* JADX WARNING: Missing block: B:16:0x0050, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r0) == false) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo4541a(C5013ao c5013ao, String str, Throwable th) {
        String abq;
        String str2 = "";
        if (th instanceof AssertionFailedError) {
            String message = th.getMessage();
            if (!C5046bo.isNullOrNil(message)) {
                Iterator it = c5013ao.xzu.entrySet().iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        Entry entry = (Entry) it.next();
                        String str3 = (String) entry.getKey();
                        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(message) && message.startsWith(str3)) {
                            abq = ((C5010b) entry.getValue()).abq();
                            break;
                        }
                    }
                }
                abq = "";
            }
        }
        abq = str2;
        C1269u.m2728f(th);
        C25794l.m41015c(C25794l.m41018k(abq, true) + str, 0, false);
    }

    /* renamed from: c */
    private static void m41015c(String str, int i, boolean z) {
        C25794l.m41017cU(str);
        C7060h.pYm.mo8377a(11338, true, true, Integer.valueOf(2));
        C7060h.pYm.mo8378a(25, 0, 1, true);
        if (C4996ah.getProcessName().endsWith(":push")) {
            C7060h.pYm.mo8378a(25, 2, 1, true);
        } else if (C4996ah.doG() || C4996ah.doG()) {
            C7060h.pYm.mo8378a(25, 3, 1, true);
        } else if (C4996ah.getProcessName().endsWith(":exdevice")) {
            C7060h.pYm.mo8378a(25, 4, 1, true);
        } else if (C4996ah.bqo()) {
            C7060h.pYm.mo8378a(25, 1, 1, true);
        }
        C7060h c7060h = C7060h.pYm;
        C7060h.cgt();
        if (C1255f.m2693aV(C4996ah.getContext()) == 1) {
            int aW = C1255f.m2694aW(C4996ah.getContext());
            C4990ab.m7417i("MicroMsg.MMCrashReporter", "google play crash size limit %s", Integer.valueOf(aW));
            if (str.length() > aW) {
                str = str.substring(0, aW);
            }
        }
        C1255f.m2695e(C4996ah.getContext(), C4996ah.getProcessName(), z ? "jni" : "java");
        if (i > 0 && str.length() > i) {
            str = str.substring(0, i);
        }
        if (C21429d.bQU() != null) {
            Intent intent = new Intent();
            intent.setAction("uncatch_exception");
            intent.putExtra("exceptionPid", Process.myPid());
            intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
            intent.putExtra("userName", C25794l.m41005Bo());
            intent.putExtra("exceptionMsg", Base64.encodeToString(str.getBytes(), 2));
            C21429d.bQU().mo36884x(C4996ah.getContext(), intent);
        }
    }

    /* renamed from: g */
    public final void mo10040g(int i, String str) {
        C25794l.m41014b(i, str, false);
    }

    /* renamed from: b */
    private static void m41014b(int i, String str, boolean z) {
        String str2 = null;
        if (i == 6) {
            try {
                String Bp = C25794l.m41006Bp();
                if (Bp != null) {
                    str2 = C25794l.m41012a(Bp, Process.myPid(), System.currentTimeMillis(), null);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed reporting JNI crash.", new Object[0]);
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        stringBuilder.append("#[jin_crash]sig=").append(i).append(10);
        stringBuilder.append("#crash.previous=").append(z).append(10);
        stringBuilder.append(C25794l.m41018k("", false));
        stringBuilder.append(str).append(10);
        if (str2 != null) {
            stringBuilder.append("******* ANR Trace *******\n");
            stringBuilder.append(str2);
        }
        C25794l.m41015c(stringBuilder.toString(), i == 6 ? 0 : Utility.DEFAULT_STREAM_BUFFER_SIZE, true);
        C4990ab.m7412e("MicroMsg.MMCrashReporter", "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        if (!z) {
            C4990ab.appenderClose();
        }
    }

    /* renamed from: Bp */
    private static String m41006Bp() {
        String str;
        try {
            str = C1414ab.get("dalvik.vm.stack-trace-file");
            if (str == null || str.length() == 0) {
                str = "/data/anr/traces.txt";
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed finding out ANR trace file path, using default.", new Object[0]);
            str = "/data/anr/traces.txt";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            String processName = C4996ah.getProcessName();
            if (processName == null || processName.length() == 0) {
                processName = "com.tencent.mm";
            }
            processName = str.substring(0, lastIndexOf) + '_' + processName + str.substring(lastIndexOf);
            if (new File(processName).isFile()) {
                return processName;
            }
        }
        return !new File(str).isFile() ? null : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c0 A:{SYNTHETIC, Splitter:B:39:0x00c0} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cf A:{SYNTHETIC, Splitter:B:48:0x00cf} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static String m41012a(String str, int i, long j, ProcessErrorStateInfo processErrorStateInfo) {
        Throwable e;
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder(4096);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str2 = "----- pid " + i + " at ";
        if (processErrorStateInfo != null) {
            stringBuilder.append(processErrorStateInfo.longMsg).append(10);
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        switch (obj) {
                            case null:
                                if (!readLine.startsWith(str2)) {
                                    break;
                                }
                                int length = str2.length();
                                long time = simpleDateFormat.parse(readLine.substring(length, length + 19)).getTime() - j;
                                if (time >= -60000 && time <= 60000) {
                                    obj = 1;
                                    break;
                                }
                            case 1:
                                stringBuilder.append(readLine).append(10);
                                if (!readLine.startsWith("DALVIK THREADS")) {
                                    if (!readLine.startsWith("-----")) {
                                        break;
                                    }
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                    }
                                    return null;
                                }
                                obj = 2;
                                break;
                            case 2:
                                if (!readLine.startsWith("----- end ")) {
                                    stringBuilder.append(readLine).append(10);
                                    break;
                                }
                                String stringBuilder2 = stringBuilder.toString();
                                try {
                                    bufferedReader.close();
                                    return stringBuilder2;
                                } catch (IOException e3) {
                                    return stringBuilder2;
                                }
                            default:
                                break;
                        }
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                } catch (Exception e5) {
                    e = e5;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed parsing ANR trace file.", new Object[0]);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e6) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e7) {
                            }
                        }
                        throw e;
                    }
                }
            }
        } catch (Exception e8) {
            e = e8;
            bufferedReader = null;
            C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed parsing ANR trace file.", new Object[0]);
            if (bufferedReader != null) {
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw e;
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: s */
    public final void mo43750s(String str, int i) {
        Recovery.dPX();
        C7060h.pYm.mo8377a(11339, true, true, Integer.valueOf(5000), Integer.valueOf(0));
        C7060h.pYm.mo8378a(26, 0, 1, true);
        C25794l.m41017cU(str);
        C7060h c7060h = C7060h.pYm;
        C7060h.cgt();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ceD >= 120000) {
            this.ceD = currentTimeMillis;
            C1255f.m2695e(C4996ah.getContext(), C4996ah.getProcessName(), "anr");
            StringBuilder stringBuilder = new StringBuilder(4096);
            stringBuilder.append(C25794l.m41018k("", true));
            stringBuilder.append("******* ANR Trace *******\n");
            if (str != null && str.length() > VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB) {
                str = str.substring(0, VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB);
            }
            stringBuilder.append(str);
            if (C21429d.bQU() != null) {
                Intent intent = new Intent();
                intent.setAction("uncatch_exception");
                intent.putExtra("tag", "anr");
                intent.putExtra("exceptionPid", i);
                intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
                intent.putExtra("userName", C6665av.fly.mo5292T("login_user_name", "never_login_crash"));
                intent.putExtra("exceptionMsg", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
                C21429d.bQU().mo36884x(C4996ah.getContext(), intent);
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: s */
    private static void m41019s(Context context, String str) {
        if (VERSION.SDK_INT < 26) {
            synchronized (ceM) {
                try {
                    PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{str, new C257954()});
                    ceM.wait(500);
                } catch (Exception e) {
                    ceM[0] = -1;
                    ceM[1] = -1;
                    ceM[2] = -1;
                    C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "crash e:", new Object[0]);
                    synchronized (ceM) {
                        ceM.notify();
                    }
                }
            }
            return;
        }
        boolean z;
        StorageStats queryStatsForUid;
        int checkOpNoThrow = ((AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), str);
        if (checkOpNoThrow == 3) {
            z = context.checkCallingOrSelfPermission("android.permission.PACKAGE_USAGE_STATS") == 0;
        } else {
            z = checkOpNoThrow == 0;
        }
        StorageStatsManager storageStatsManager = (StorageStatsManager) context.getSystemService("storagestats");
        int i = -1;
        try {
            i = context.getPackageManager().getPackageUid(str, 128);
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "summer getStats crash1 e:", new Object[0]);
        }
        context.getSystemService("storage");
        try {
            queryStatsForUid = storageStatsManager.queryStatsForUid(StorageManager.UUID_DEFAULT, i);
        } catch (Exception e3) {
            C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e3, "summer getStats crash2 e:", new Object[0]);
            queryStatsForUid = null;
        }
        ceM[0] = queryStatsForUid.getCacheBytes();
        ceM[1] = queryStatsForUid.getDataBytes();
        ceM[2] = queryStatsForUid.getAppBytes();
        C4990ab.m7417i("MicroMsg.MMCrashReporter", "summer getStats mode[%s] granted[%s] [%s, %s, %s] stack[%s]", Integer.valueOf(checkOpNoThrow), Boolean.valueOf(z), Long.valueOf(ceM[0]), Long.valueOf(ceM[1]), Long.valueOf(ceM[2]), C5046bo.dpG());
    }

    /* renamed from: Bq */
    private static String m41007Bq() {
        try {
            return C6998b.oTO.bVL() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } catch (Throwable th) {
            return "-1";
        }
    }

    /* renamed from: Br */
    private static String m41008Br() {
        try {
            return C6998b.oTO.bVM() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } catch (Throwable th) {
            return "-1";
        }
    }

    /* renamed from: Bs */
    private static String m41009Bs() {
        try {
            return C6998b.oTO.bVN() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } catch (Throwable th) {
            return "-1";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x04bd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x05c1 A:{SYNTHETIC, Splitter:B:67:0x05c1} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x05b5 A:{SYNTHETIC, Splitter:B:61:0x05b5} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x03fd  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x04bd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0506  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: k */
    private static String m41018k(String str, boolean z) {
        Object format;
        int i;
        long j;
        Throwable e;
        int[] iArr;
        MemoryInfo[] processMemoryInfo;
        long freeMemory;
        long maxMemory;
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder(256);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = C4996ah.getContext();
        stringBuilderPrinter.println("#client.version=" + C7243d.vxo);
        stringBuilderPrinter.println("#client.verhistory=" + C1842cf.aaH());
        stringBuilderPrinter.println("#client.imei=" + C1427q.m3027LL());
        stringBuilderPrinter.println("#accinfo.revision=" + C5058f.REV);
        stringBuilderPrinter.println("#accinfo.uin=" + C6665av.fly.mo5292T("last_login_uin", ceJ));
        stringBuilderPrinter.println("#accinfo.dev=" + ceI);
        stringBuilderPrinter.println("#accinfo.runtime=" + (C5046bo.anU() - ceA) + "(" + C5046bo.nullAsNil(ceK) + ")");
        stringBuilderPrinter.println("#accinfo.build=" + C5058f.TIME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C5058f.HOSTNAME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C5059g.cdf);
        stringBuilderPrinter.println("#qbrwoser.corever=" + WebView.getInstalledTbsCoreVersion(context));
        stringBuilderPrinter.println("#qbrowser.ver=" + WebView.getTbsSDKVersion(context));
        stringBuilderPrinter.println("#status.dwx_bt=" + C25794l.m41009Bs());
        stringBuilderPrinter.println("#status.xh=" + C25794l.m41007Bq());
        stringBuilderPrinter.println("#status.x86_env=" + C25794l.m41008Br());
        stringBuilderPrinter.println("#xsdkver=190301");
        try {
            stringBuilderPrinter.println("#xcorever=" + XWalkEnvironment.getInstalledNewstVersion(C4996ah.getContext()));
            stringBuilderPrinter.println("#syswebcore=" + XWalkEnvironment.safeGetChromiunVersion());
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.MMCrashReporter", "get syswebcore failed: " + e2.getMessage());
        }
        C4990ab.m7417i("MicroMsg.MMCrashReporter", "Activity dump before crash report, [%s]", C1185a.m2613SY());
        String string = C4996ah.getContext().getSharedPreferences("webview_url_prefs", 4).getString("url", null);
        if (string != null) {
            stringBuilderPrinter.println("#qbrowser.url=".concat(String.valueOf(string)));
            Editor edit = C4996ah.getContext().getSharedPreferences("webview_url_prefs", 4).edit();
            edit.remove("url");
            edit.apply();
        }
        if (z) {
            stringBuilderPrinter.println(sCrashExtraMessageGetter.mo10218Bu());
        }
        stringBuilderPrinter.println("#accinfo.env=" + (C4872b.foreground ? "f" : "b") + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Thread.currentThread().getName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C4872b.xxv);
        String str2 = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(C6457e.eSl);
            int memoryClass = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
            int largeMemoryClass = ((ActivityManager) context.getSystemService("activity")).getLargeMemoryClass();
            C25794l.m41019s(C4996ah.getContext(), C4996ah.getContext().getPackageName());
            format = String.format("%dMB %dMB %s:%d:%d:%d %d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(memoryClass), Integer.valueOf(largeMemoryClass), r3.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), Long.valueOf(ceM[0]), Long.valueOf(ceM[1]), Long.valueOf(ceM[2]), C6457e.eSl, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e22) {
            C4990ab.m7413e("MicroMsg.MMCrashReporter", "check data size failed :%s", e22.getMessage());
            string = str2;
        }
        stringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(format)));
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        String str3 = "";
        ActivityManager activityManager = (ActivityManager) C4996ah.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j2 = 0;
        if (C1443d.m3068iW(16)) {
            j2 = memoryInfo.totalMem;
        } else {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    char[] toCharArray = randomAccessFile.readLine().toCharArray();
                    int length = toCharArray.length;
                    i = 0;
                    while (i < length) {
                        if (toCharArray[i] <= '9' && toCharArray[i] >= '0') {
                            stringBuffer.append(toCharArray[i]);
                        }
                        i++;
                    }
                    j = C5046bo.getLong(stringBuffer.toString(), -1);
                    if (j > 0) {
                        j2 = j << 10;
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Exception e3) {
                    }
                } catch (Exception e4) {
                    e = e4;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "", new Object[0]);
                        if (randomAccessFile != null) {
                        }
                        str2 = (str3 + "[total: " + j2 + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
                        iArr = new int[]{Process.myPid()};
                        processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
                        if (processMemoryInfo != null) {
                        }
                        string = str2;
                        j2 = Runtime.getRuntime().totalMemory();
                        freeMemory = Runtime.getRuntime().freeMemory();
                        maxMemory = Runtime.getRuntime().maxMemory();
                        j = j2 - freeMemory;
                        format = string + String.format("Runtime Mem[%s:%s:%s:%s] vmSize:%s", new Object[]{Long.valueOf(j2), Long.valueOf(freeMemory), Long.valueOf(j), Long.valueOf(maxMemory), LogLogic.getVmSize()});
                        if (C34670b.bZs() > C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW) {
                        }
                        stringBuilderPrinter.println("#accinfo.memory=".concat(String.valueOf(format)));
                        if (!C5046bo.isNullOrNil(str)) {
                        }
                        stringBuilderPrinter.println("#crashContent=");
                        return stringBuilder.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                randomAccessFile = null;
                C4990ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "", new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e6) {
                    }
                }
                str2 = (str3 + "[total: " + j2 + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
                iArr = new int[]{Process.myPid()};
                processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
                if (processMemoryInfo != null) {
                }
                string = str2;
                j2 = Runtime.getRuntime().totalMemory();
                freeMemory = Runtime.getRuntime().freeMemory();
                maxMemory = Runtime.getRuntime().maxMemory();
                j = j2 - freeMemory;
                format = string + String.format("Runtime Mem[%s:%s:%s:%s] vmSize:%s", new Object[]{Long.valueOf(j2), Long.valueOf(freeMemory), Long.valueOf(j), Long.valueOf(maxMemory), LogLogic.getVmSize()});
                if (C34670b.bZs() > C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW) {
                }
                stringBuilderPrinter.println("#accinfo.memory=".concat(String.valueOf(format)));
                if (C5046bo.isNullOrNil(str)) {
                }
                stringBuilderPrinter.println("#crashContent=");
                return stringBuilder.toString();
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e7) {
                    }
                }
                throw th;
            }
        }
        str2 = (str3 + "[total: " + j2 + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
        iArr = new int[]{Process.myPid()};
        processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
        if (processMemoryInfo != null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null) {
            string = str2;
        } else {
            MemoryInfo memoryInfo2 = processMemoryInfo[0];
            string = str2 + "[pid(" + iArr[0] + "):" + (memoryInfo2.getTotalPss() << 10) + " " + (memoryInfo2.getTotalPrivateDirty() << 10) + " " + (memoryInfo2.getTotalSharedDirty() << 10) + "]";
        }
        j2 = Runtime.getRuntime().totalMemory();
        freeMemory = Runtime.getRuntime().freeMemory();
        maxMemory = Runtime.getRuntime().maxMemory();
        j = j2 - freeMemory;
        format = string + String.format("Runtime Mem[%s:%s:%s:%s] vmSize:%s", new Object[]{Long.valueOf(j2), Long.valueOf(freeMemory), Long.valueOf(j), Long.valueOf(maxMemory), LogLogic.getVmSize()});
        if (C34670b.bZs() > C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW) {
            int cy = C34670b.m56930cy(new LinkedList());
            format = format + String.format("[threadInfo(%s:%s) %s]", new Object[]{Integer.valueOf(cy), Integer.valueOf(i), r2});
        }
        stringBuilderPrinter.println("#accinfo.memory=".concat(String.valueOf(format)));
        if (C5046bo.isNullOrNil(str)) {
            stringBuilderPrinter.println("#".concat(String.valueOf(str)));
        }
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }
}
