package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.app.AppOpsManager;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
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
import com.tencent.mm.a.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.model.av;
import com.tencent.mm.model.cf;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.c;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.recovery.Recovery;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.util.VideoMaterialUtil;
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

public class l implements c, d {
    public static final long ceA = bo.anU();
    private static final String ceI;
    private static final String ceJ;
    private static String ceK = "";
    private static final String ceL = ("version:" + com.tencent.mm.protocal.d.vxo);
    private static long[] ceM = new long[]{0, 0, 0};
    private static com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a sCrashExtraMessageGetter = new com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a() {
        public final String Bu() {
            StringBuilder stringBuilder = new StringBuilder();
            String processName = ah.getProcessName();
            if (processName != null && (processName.contains(":tools") || processName.contains(":appbrand"))) {
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                processName = WebView.getCrashExtraMessage(ah.getContext());
                if (processName != null && processName.length() > 0) {
                    processName = processName + String.format(Locale.US, "client_version:%s;", new Object[]{f.CLIENT_VERSION});
                    if (processName.length() > Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                        processName = processName.substring(processName.length() - 8192);
                    }
                    stringBuilder.append("#qbrowser.crashmsg=" + Base64.encodeToString(processName.getBytes(), 2));
                    ab.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", processName);
                }
            }
            return stringBuilder.toString();
        }
    };
    private ao ceB = null;
    private a ceC;
    private volatile long ceD = 0;
    HashSet<String> ceE;
    String ceF;
    String ceG;
    ConditionVariable ceH;
    volatile b ceN;

    class a extends FileObserver {
        a(String str) {
            super(str, 712);
        }

        public final void onEvent(int i, String str) {
            Object obj = null;
            if (System.currentTimeMillis() - l.this.ceD < 120000) {
                obj = 1;
            }
            if (obj == null) {
                synchronized (l.this.ceE) {
                    switch (i) {
                        case 8:
                            ab.i("MicroMsg.MMCrashReporter", "Detected trace file changed: ".concat(String.valueOf(str)));
                            l.this.ceH.open();
                            if (l.this.ceN == null) {
                                l.this.ceN = new b(l.this, (byte) 0);
                                com.tencent.mm.sdk.g.d.post(l.this.ceN, "MMCrashReporter_parseANRTrace");
                                break;
                            }
                            break;
                        case 64:
                        case 512:
                            l.this.ceE.remove(str);
                            break;
                        case 128:
                            break;
                    }
                    l.this.ceE.add(str);
                }
            }
        }
    }

    class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(l lVar, byte b) {
            this();
        }

        private static ProcessErrorStateInfo Bv() {
            List<ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) ah.getContext().getSystemService("activity")).getProcessesInErrorState();
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
            ab.i("MicroMsg.MMCrashReporter", "ANR Parser started.");
            ProcessErrorStateInfo processErrorStateInfo = null;
            while (l.this.ceH.block(10000)) {
                l.this.ceH.close();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
                processErrorStateInfo = Bv();
                if (processErrorStateInfo != null) {
                    break;
                }
            }
            if (processErrorStateInfo == null) {
                processErrorStateInfo = Bv();
                if (processErrorStateInfo == null) {
                    ab.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
                    l.this.ceN = null;
                    return;
                }
            }
            ProcessErrorStateInfo processErrorStateInfo2 = processErrorStateInfo;
            ab.i("MicroMsg.MMCrashReporter", "Got ANR process: " + processErrorStateInfo2.processName + " @ " + processErrorStateInfo2.pid);
            synchronized (l.this.ceE) {
                arrayList = new ArrayList(l.this.ceE.size());
                int lastIndexOf = l.this.ceG.lastIndexOf(46);
                if (lastIndexOf != -1) {
                    str = l.this.ceG.substring(0, lastIndexOf) + '_' + processErrorStateInfo2.processName + l.this.ceG.substring(lastIndexOf);
                    if (l.this.ceE.remove(str)) {
                        arrayList.add(str);
                    }
                }
                if (l.this.ceE.remove(l.this.ceG)) {
                    arrayList.add(l.this.ceG);
                }
                arrayList.addAll(l.this.ceE);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                str = l.a(l.this.ceF + IOUtils.DIR_SEPARATOR_UNIX + ((String) it.next()), processErrorStateInfo2.pid, currentTimeMillis, processErrorStateInfo2);
                if (str != null) {
                    ab.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", r0);
                    l.this.s(str, processErrorStateInfo2.pid);
                    break;
                }
                ab.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", r0);
            }
            ab.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
            l.this.ceN = null;
        }
    }

    static {
        String LM = q.LM();
        ceI = LM;
        ceJ = p.getString(LM.hashCode());
    }

    private static String Bo() {
        String T = av.fly.T("login_weixin_username", "");
        if (bo.isNullOrNil(T)) {
            return av.fly.T("login_user_name", "never_login_crash");
        }
        return T;
    }

    public static boolean cT(String str) {
        Object obj = null;
        ceK = str;
        if (com.tencent.mm.plugin.p.d.bQU() == null) {
            Object cls;
            try {
                cls = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "setup sanbox Failed printing stack trace1.", new Object[0]);
                cls = obj;
            }
            try {
                obj = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, ah.getContext().getClassLoader());
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "setup sanbox Failed printing stack trace2.", new Object[0]);
            }
            ab.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + cls + " thisProcName: " + ceK);
            ab.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + obj + " thisProcName: " + ceK);
            Class hM = com.tencent.mm.bp.d.hM("sandbox", ".SubCoreSandBox");
            ab.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + hM + " thisProcName: " + ceK);
            if (hM != null) {
                try {
                    com.tencent.mm.plugin.p.c cVar = (com.tencent.mm.plugin.p.c) hM.newInstance();
                    com.tencent.mm.plugin.p.d.a(cVar);
                    ab.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + cVar + " thisProcName: " + ceK);
                } catch (Exception e3) {
                    ab.printErrStackTrace("MicroMsg.MMCrashReporter", e3, "", new Object[0]);
                    ab.w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", e3.getClass().getSimpleName(), e3.getMessage());
                }
            }
        }
        c cVar2;
        try {
            cVar2 = (c) Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
            cVar2.aX(ah.getContext());
            av.fly.T("last_login_uin", ceJ);
            com.tencent.mm.sdk.a.b.a(cVar2);
            AnonymousClass2 anonymousClass2 = new Object() {
            };
            return true;
        } catch (Exception e4) {
            ab.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
            cVar2 = new l();
            cVar2.aX(ah.getContext());
            com.tencent.mm.sdk.a.b.a(cVar2);
            String str2 = com.tencent.mm.compatible.e.ab.get("ro.product.cpu.abi");
            if (str2 == null || str2.length() == 0 || !(str2.equals("x86") || str2.equals("x86-64"))) {
                k.a("wechatCrashForJni", l.class.getClassLoader());
                str2 = ceL;
                if (str.contains(":tools") || str.contains(":appbrand") || str.contains(":support")) {
                    str2 = str2 + IOUtils.LINE_SEPARATOR_UNIX + WebView.getCrashExtraMessage(ah.getContext()) + String.format(Locale.US, "client_version:%s;", new Object[]{f.CLIENT_VERSION}) + IOUtils.LINE_SEPARATOR_UNIX;
                    ab.i("MicroMsg.MMCrashReporter", "append crash extra message : %s", str2);
                }
                CrashMonitorForJni.setCrashExtraMessageGetter(sCrashExtraMessageGetter);
                CrashMonitorForJni.setClientVersionMsg(str2);
            }
            cf.oO(e.eSj);
            return false;
        }
    }

    public static void a(ao.c cVar) {
        ao.a(cVar);
    }

    private static void cU(String str) {
        while (str.length() > 896) {
            try {
                int lastIndexOf = str.substring(0, 896).lastIndexOf(IOUtils.LINE_SEPARATOR_UNIX);
                if (-1 == lastIndexOf) {
                    break;
                }
                ab.e("MicroMsg.MMCrashReporter", str.substring(0, lastIndexOf));
                str = str.substring(lastIndexOf + 1);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed printing stack trace.", new Object[0]);
                return;
            }
        }
        ab.e("MicroMsg.MMCrashReporter", str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fc A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f9 A:{SYNTHETIC, Splitter:B:35:0x00f9} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0153 A:{SYNTHETIC, Splitter:B:54:0x0153} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aX(final Context context) {
        Throwable e;
        ao.a((d) this);
        if (ceK.endsWith(":push")) {
            String str;
            try {
                str = com.tencent.mm.compatible.e.ab.get("dalvik.vm.stack-trace-file");
                if (str == null || str.length() == 0) {
                    str = "/data/anr/traces.txt";
                }
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed finding out ANR trace file path, using default.", new Object[0]);
                str = "/data/anr/traces.txt";
            }
            File file = new File(str);
            this.ceF = file.getParent();
            if (this.ceF == null || this.ceF.length() == 0) {
                this.ceF = "/";
            }
            this.ceG = file.getName();
            this.ceH = new ConditionVariable();
            ab.i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: ".concat(String.valueOf(str)));
            this.ceE = new HashSet();
            this.ceC = new a(this.ceF);
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
                    ab.i("MicroMsg.MMCrashReporter", "Uploading previous crash: ".concat(String.valueOf(obj)));
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
                                        i = bo.getInt(matcher.group(1), 0);
                                    }
                                }
                                stringBuilder.append(readLine).append(10);
                            }
                            if (stringBuilder.toString().startsWith(ceL)) {
                                readLine = stringBuilder.toString().substring(stringBuilder.toString().indexOf(ceL) + ceL.length());
                                if (readLine != null && readLine.trim().length() > 0) {
                                    b(i, readLine, true);
                                }
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                            }
                        } catch (IOException e4) {
                            e = e4;
                            try {
                                ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed uploading previous crash: ".concat(String.valueOf(obj)), new Object[0]);
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
                        ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed uploading previous crash: ".concat(String.valueOf(obj)), new Object[0]);
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

    public final void A(String str, String str2) {
        if (com.tencent.mm.plugin.p.d.bQU() != null) {
            Intent intent = new Intent();
            intent.setAction("custom_exception");
            intent.putExtra("userName", Bo());
            intent.putExtra("tag", str2);
            intent.putExtra("exceptionMsg", str);
            com.tencent.mm.plugin.p.d.bQU().x(ah.getContext(), intent);
        }
    }

    public final void a(com.tencent.mm.sdk.a.a aVar) {
        ao.a(aVar);
    }

    /* JADX WARNING: Missing block: B:16:0x0050, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r0) == false) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(ao aoVar, String str, Throwable th) {
        String abq;
        String str2 = "";
        if (th instanceof AssertionFailedError) {
            String message = th.getMessage();
            if (!bo.isNullOrNil(message)) {
                Iterator it = aoVar.xzu.entrySet().iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        Entry entry = (Entry) it.next();
                        String str3 = (String) entry.getKey();
                        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(message) && message.startsWith(str3)) {
                            abq = ((com.tencent.mm.sdk.platformtools.ao.b) entry.getValue()).abq();
                            break;
                        }
                    }
                }
                abq = "";
            }
        }
        abq = str2;
        u.f(th);
        c(k(abq, true) + str, 0, false);
    }

    private static void c(String str, int i, boolean z) {
        cU(str);
        h.pYm.a(11338, true, true, Integer.valueOf(2));
        h.pYm.a(25, 0, 1, true);
        if (ah.getProcessName().endsWith(":push")) {
            h.pYm.a(25, 2, 1, true);
        } else if (ah.doG() || ah.doG()) {
            h.pYm.a(25, 3, 1, true);
        } else if (ah.getProcessName().endsWith(":exdevice")) {
            h.pYm.a(25, 4, 1, true);
        } else if (ah.bqo()) {
            h.pYm.a(25, 1, 1, true);
        }
        h hVar = h.pYm;
        h.cgt();
        if (f.aV(ah.getContext()) == 1) {
            int aW = f.aW(ah.getContext());
            ab.i("MicroMsg.MMCrashReporter", "google play crash size limit %s", Integer.valueOf(aW));
            if (str.length() > aW) {
                str = str.substring(0, aW);
            }
        }
        f.e(ah.getContext(), ah.getProcessName(), z ? "jni" : "java");
        if (i > 0 && str.length() > i) {
            str = str.substring(0, i);
        }
        if (com.tencent.mm.plugin.p.d.bQU() != null) {
            Intent intent = new Intent();
            intent.setAction("uncatch_exception");
            intent.putExtra("exceptionPid", Process.myPid());
            intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
            intent.putExtra("userName", Bo());
            intent.putExtra("exceptionMsg", Base64.encodeToString(str.getBytes(), 2));
            com.tencent.mm.plugin.p.d.bQU().x(ah.getContext(), intent);
        }
    }

    public final void g(int i, String str) {
        b(i, str, false);
    }

    private static void b(int i, String str, boolean z) {
        String str2 = null;
        if (i == 6) {
            try {
                String Bp = Bp();
                if (Bp != null) {
                    str2 = a(Bp, Process.myPid(), System.currentTimeMillis(), null);
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed reporting JNI crash.", new Object[0]);
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        stringBuilder.append("#[jin_crash]sig=").append(i).append(10);
        stringBuilder.append("#crash.previous=").append(z).append(10);
        stringBuilder.append(k("", false));
        stringBuilder.append(str).append(10);
        if (str2 != null) {
            stringBuilder.append("******* ANR Trace *******\n");
            stringBuilder.append(str2);
        }
        c(stringBuilder.toString(), i == 6 ? 0 : Utility.DEFAULT_STREAM_BUFFER_SIZE, true);
        ab.e("MicroMsg.MMCrashReporter", "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        if (!z) {
            ab.appenderClose();
        }
    }

    private static String Bp() {
        String str;
        try {
            str = com.tencent.mm.compatible.e.ab.get("dalvik.vm.stack-trace-file");
            if (str == null || str.length() == 0) {
                str = "/data/anr/traces.txt";
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed finding out ANR trace file path, using default.", new Object[0]);
            str = "/data/anr/traces.txt";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            String processName = ah.getProcessName();
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
    static String a(String str, int i, long j, ProcessErrorStateInfo processErrorStateInfo) {
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
                        ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed parsing ANR trace file.", new Object[0]);
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
            ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed parsing ANR trace file.", new Object[0]);
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
    public final void s(String str, int i) {
        Recovery.dPX();
        h.pYm.a(11339, true, true, Integer.valueOf(5000), Integer.valueOf(0));
        h.pYm.a(26, 0, 1, true);
        cU(str);
        h hVar = h.pYm;
        h.cgt();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ceD >= 120000) {
            this.ceD = currentTimeMillis;
            f.e(ah.getContext(), ah.getProcessName(), "anr");
            StringBuilder stringBuilder = new StringBuilder(4096);
            stringBuilder.append(k("", true));
            stringBuilder.append("******* ANR Trace *******\n");
            if (str != null && str.length() > VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB) {
                str = str.substring(0, VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB);
            }
            stringBuilder.append(str);
            if (com.tencent.mm.plugin.p.d.bQU() != null) {
                Intent intent = new Intent();
                intent.setAction("uncatch_exception");
                intent.putExtra("tag", "anr");
                intent.putExtra("exceptionPid", i);
                intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
                intent.putExtra("userName", av.fly.T("login_user_name", "never_login_crash"));
                intent.putExtra("exceptionMsg", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
                com.tencent.mm.plugin.p.d.bQU().x(ah.getContext(), intent);
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void s(Context context, String str) {
        if (VERSION.SDK_INT < 26) {
            synchronized (ceM) {
                try {
                    PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{str, new Stub() {
                        public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                            if (packageStats != null) {
                                try {
                                    l.ceM[0] = packageStats.cacheSize;
                                    l.ceM[1] = packageStats.dataSize;
                                    l.ceM[2] = packageStats.codeSize;
                                    ab.i("MicroMsg.MMCrashReporter", "onGetStatsCompleted succeeded[%b] cacheSize :%d ,dataSize :%d ,codeSize :%d ", Boolean.valueOf(z), Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                } catch (Throwable th) {
                                    ab.printErrStackTrace("MicroMsg.MMCrashReporter", th, "onGetStatsCompleted", new Object[0]);
                                    return;
                                }
                            }
                            ab.i("MicroMsg.MMCrashReporter", "onGetStatsCompleted pStats is null succeeded[%b]", Boolean.valueOf(z));
                            synchronized (l.ceM) {
                                l.ceM.notify();
                            }
                        }
                    }});
                    ceM.wait(500);
                } catch (Exception e) {
                    ceM[0] = -1;
                    ceM[1] = -1;
                    ceM[2] = -1;
                    ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "crash e:", new Object[0]);
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
            ab.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "summer getStats crash1 e:", new Object[0]);
        }
        context.getSystemService("storage");
        try {
            queryStatsForUid = storageStatsManager.queryStatsForUid(StorageManager.UUID_DEFAULT, i);
        } catch (Exception e3) {
            ab.printErrStackTrace("MicroMsg.MMCrashReporter", e3, "summer getStats crash2 e:", new Object[0]);
            queryStatsForUid = null;
        }
        ceM[0] = queryStatsForUid.getCacheBytes();
        ceM[1] = queryStatsForUid.getDataBytes();
        ceM[2] = queryStatsForUid.getAppBytes();
        ab.i("MicroMsg.MMCrashReporter", "summer getStats mode[%s] granted[%s] [%s, %s, %s] stack[%s]", Integer.valueOf(checkOpNoThrow), Boolean.valueOf(z), Long.valueOf(ceM[0]), Long.valueOf(ceM[1]), Long.valueOf(ceM[2]), bo.dpG());
    }

    private static String Bq() {
        try {
            return com.tencent.mm.plugin.normsg.a.b.oTO.bVL() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } catch (Throwable th) {
            return "-1";
        }
    }

    private static String Br() {
        try {
            return com.tencent.mm.plugin.normsg.a.b.oTO.bVM() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } catch (Throwable th) {
            return "-1";
        }
    }

    private static String Bs() {
        try {
            return com.tencent.mm.plugin.normsg.a.b.oTO.bVN() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
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
    private static String k(String str, boolean z) {
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
        Context context = ah.getContext();
        stringBuilderPrinter.println("#client.version=" + com.tencent.mm.protocal.d.vxo);
        stringBuilderPrinter.println("#client.verhistory=" + cf.aaH());
        stringBuilderPrinter.println("#client.imei=" + q.LL());
        stringBuilderPrinter.println("#accinfo.revision=" + f.REV);
        stringBuilderPrinter.println("#accinfo.uin=" + av.fly.T("last_login_uin", ceJ));
        stringBuilderPrinter.println("#accinfo.dev=" + ceI);
        stringBuilderPrinter.println("#accinfo.runtime=" + (bo.anU() - ceA) + "(" + bo.nullAsNil(ceK) + ")");
        stringBuilderPrinter.println("#accinfo.build=" + f.TIME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + f.HOSTNAME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + g.cdf);
        stringBuilderPrinter.println("#qbrwoser.corever=" + WebView.getInstalledTbsCoreVersion(context));
        stringBuilderPrinter.println("#qbrowser.ver=" + WebView.getTbsSDKVersion(context));
        stringBuilderPrinter.println("#status.dwx_bt=" + Bs());
        stringBuilderPrinter.println("#status.xh=" + Bq());
        stringBuilderPrinter.println("#status.x86_env=" + Br());
        stringBuilderPrinter.println("#xsdkver=190301");
        try {
            stringBuilderPrinter.println("#xcorever=" + XWalkEnvironment.getInstalledNewstVersion(ah.getContext()));
            stringBuilderPrinter.println("#syswebcore=" + XWalkEnvironment.safeGetChromiunVersion());
        } catch (Exception e2) {
            ab.e("MicroMsg.MMCrashReporter", "get syswebcore failed: " + e2.getMessage());
        }
        ab.i("MicroMsg.MMCrashReporter", "Activity dump before crash report, [%s]", com.tencent.mm.ac.a.SY());
        String string = ah.getContext().getSharedPreferences("webview_url_prefs", 4).getString("url", null);
        if (string != null) {
            stringBuilderPrinter.println("#qbrowser.url=".concat(String.valueOf(string)));
            Editor edit = ah.getContext().getSharedPreferences("webview_url_prefs", 4).edit();
            edit.remove("url");
            edit.apply();
        }
        if (z) {
            stringBuilderPrinter.println(sCrashExtraMessageGetter.Bu());
        }
        stringBuilderPrinter.println("#accinfo.env=" + (com.tencent.mm.sdk.a.b.foreground ? "f" : "b") + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Thread.currentThread().getName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + com.tencent.mm.sdk.a.b.xxv);
        String str2 = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(e.eSl);
            int memoryClass = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
            int largeMemoryClass = ((ActivityManager) context.getSystemService("activity")).getLargeMemoryClass();
            s(ah.getContext(), ah.getContext().getPackageName());
            format = String.format("%dMB %dMB %s:%d:%d:%d %d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(memoryClass), Integer.valueOf(largeMemoryClass), r3.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), Long.valueOf(ceM[0]), Long.valueOf(ceM[1]), Long.valueOf(ceM[2]), e.eSl, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e22) {
            ab.e("MicroMsg.MMCrashReporter", "check data size failed :%s", e22.getMessage());
            string = str2;
        }
        stringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(format)));
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        String str3 = "";
        ActivityManager activityManager = (ActivityManager) ah.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j2 = 0;
        if (com.tencent.mm.compatible.util.d.iW(16)) {
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
                    j = bo.getLong(stringBuffer.toString(), -1);
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
                        ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "", new Object[0]);
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
                        if (com.tencent.mm.plugin.performance.b.b.bZs() > com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW) {
                        }
                        stringBuilderPrinter.println("#accinfo.memory=".concat(String.valueOf(format)));
                        if (!bo.isNullOrNil(str)) {
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
                ab.printErrStackTrace("MicroMsg.MMCrashReporter", e, "", new Object[0]);
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
                if (com.tencent.mm.plugin.performance.b.b.bZs() > com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW) {
                }
                stringBuilderPrinter.println("#accinfo.memory=".concat(String.valueOf(format)));
                if (bo.isNullOrNil(str)) {
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
        if (com.tencent.mm.plugin.performance.b.b.bZs() > com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW) {
            int cy = com.tencent.mm.plugin.performance.b.b.cy(new LinkedList());
            format = format + String.format("[threadInfo(%s:%s) %s]", new Object[]{Integer.valueOf(cy), Integer.valueOf(i), r2});
        }
        stringBuilderPrinter.println("#accinfo.memory=".concat(String.valueOf(format)));
        if (bo.isNullOrNil(str)) {
            stringBuilderPrinter.println("#".concat(String.valueOf(str)));
        }
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }
}
