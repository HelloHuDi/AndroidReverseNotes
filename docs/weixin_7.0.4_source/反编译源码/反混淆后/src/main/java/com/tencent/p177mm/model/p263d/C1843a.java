package com.tencent.p177mm.model.p263d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.p052pm.IPackageStatsObserver;
import android.content.p052pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p263d.C9659c.C9660a;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p215cf.C45280e;
import com.tencent.p177mm.p707ba.C25854m;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5013ao.C5010b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7306ak.C4999b;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* renamed from: com.tencent.mm.model.d.a */
public class C1843a implements C9660a {
    private static final String ceI;
    private static final String ceJ;
    public static String ceK = "";
    private static C1843a foM;
    private static final String foN = (C6457e.eSl + "/tencent/MicroMsg/Handler/");
    public static final String foO = (foN + "Handler.trace");
    private static final long foR = Looper.getMainLooper().getThread().getId();
    private static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    long[] ceM;
    private SharedPreferences ehZ;
    private long foP;
    private volatile boolean foQ;
    private long foS;
    private long foT;
    private long foU;
    private long foV;
    private long foW;
    private long foX;
    private long foY;
    private int foZ;
    private int fpa;
    private int fpb;
    private Long[] fpc;
    public long fpd;
    private long fpe;
    private String fpf;
    private LinkedList<C1849a> fpg;

    /* renamed from: com.tencent.mm.model.d.a$5 */
    class C18445 extends Stub {
        C18445() {
        }

        public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
            AppMethodBeat.m2504i(16378);
            C1843a.this.ceM[0] = packageStats.cacheSize;
            C1843a.this.ceM[1] = packageStats.dataSize;
            C1843a.this.ceM[2] = packageStats.codeSize;
            C4990ab.m7417i("MicroMsg.HandlerTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
            AppMethodBeat.m2505o(16378);
        }
    }

    /* renamed from: com.tencent.mm.model.d.a$1 */
    public class C18461 implements C4999b {
        /* renamed from: a */
        public final void mo5424a(Message message, Runnable runnable, Thread thread, long j, long j2, float f) {
            AppMethodBeat.m2504i(16372);
            if (thread == null) {
                AppMethodBeat.m2505o(16372);
                return;
            }
            long id = thread.getId();
            String str = null;
            if (j > C1843a.this.foS) {
                if (message != null) {
                    str = "|HMonitor dispatch|msg = " + message + "|handler = " + message.getTarget() + "|threadName = " + thread.getName() + "|threadId = " + thread.getId() + "|priority = " + thread.getPriority() + "|usedTime = " + j + "|cpuTime = " + j2;
                } else if (runnable != null) {
                    str = "|HMonitor run task|" + C7306ak.dump(runnable, true);
                }
            } else if (j > C1843a.this.foT && id == C1843a.foR) {
                if (message != null) {
                    str = "|HMonitor dispatch|msg = " + message + "|handler = " + message.getTarget() + "|threadName = " + thread.getName() + "|threadId = " + thread.getId() + "|priority = " + thread.getPriority() + "|usedTime = " + j + "|cpuTime = " + j2;
                } else if (runnable != null) {
                    str = "|HMonitor run task|" + C7306ak.dump(runnable, true);
                }
            }
            if (C9638aw.m17180RS().oAl.getLooper() == null) {
                C4990ab.m7420w("MicroMsg.HandlerTraceManager", "worker thread's looper is dead");
                AppMethodBeat.m2505o(16372);
                return;
            }
            if (runnable != null && j > C1843a.this.foY && id == C1843a.this.fpe) {
                C1849a c1849a = new C1849a();
                c1849a.fpi = j;
                c1849a.info = C7306ak.dump(runnable, false);
                if (C1843a.this.fpg.size() >= C1843a.this.foZ) {
                    C1843a.this.fpg.pop();
                }
                C1843a.this.fpg.add(c1849a);
            }
            if (runnable != null && id == C1843a.this.fpe && f > 0.0f && f <= 100.0f) {
                Long[] g;
                if (f < 30.0f) {
                    g = C1843a.this.fpc;
                    int i = (int) (f / 2.0f);
                    g[i] = Long.valueOf(g[i].longValue() + 1);
                } else if (f < 40.0f) {
                    g = C1843a.this.fpc;
                    g[15] = Long.valueOf(g[15].longValue() + 1);
                } else if (f < 50.0f) {
                    g = C1843a.this.fpc;
                    g[16] = Long.valueOf(g[16].longValue() + 1);
                } else {
                    g = C1843a.this.fpc;
                    g[17] = Long.valueOf(g[17].longValue() + 1);
                }
            }
            if (System.currentTimeMillis() - C1843a.this.fpd > ((long) C1843a.this.fpb)) {
                C1843a.this.fpd = System.currentTimeMillis();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= 18) {
                        break;
                    }
                    if (C1843a.this.fpc[i3].longValue() > 0) {
                        C7060h.pYm.mo8378a(230, (long) i3, C1843a.this.fpc[i3].longValue(), false);
                    }
                    i2 = i3 + 1;
                }
            }
            if (str == null) {
                AppMethodBeat.m2505o(16372);
                return;
            }
            if (!C4872b.foreground) {
                C4990ab.m7416i("MicroMsg.HandlerTraceManager", str);
            }
            if (C1843a.this.foQ) {
                AppMethodBeat.m2505o(16372);
                return;
            }
            C1843a.m3793a(C1843a.this, C1843a.sDateFormat.format(new Date()) + str + IOUtils.LINE_SEPARATOR_UNIX);
            AppMethodBeat.m2505o(16372);
        }
    }

    /* renamed from: com.tencent.mm.model.d.a$2 */
    public class C18472 implements C5010b {
        public final String abq() {
            AppMethodBeat.m2504i(16373);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("worker thread id = " + C9638aw.m17180RS().oAl.getLooper().getThread().getId() + "[" + C9638aw.m17180RS().doL() + "]\n");
            stringBuilder.append("#cpu freq(KHz)[max=" + C45290m.m83510Lx() + ", min=" + C45290m.m83511Ly() + ", cur=" + C45290m.m83512Lz() + "]\n");
            LinkedList linkedList = new LinkedList(C1843a.this.fpg);
            Iterator it = linkedList.iterator();
            stringBuilder.append("#done tasks size = " + linkedList.size() + 10);
            if (it != null) {
                int i = 0;
                while (it.hasNext() && i < C1843a.this.fpa) {
                    stringBuilder.append("[index = " + i + " | taskinfo:" + ((C1849a) it.next()).info + "]\n");
                    i++;
                }
            }
            stringBuilder.append("\n#waiting" + C9638aw.m17180RS().doN().dump(false));
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(16373);
            return stringBuilder2;
        }
    }

    /* renamed from: com.tencent.mm.model.d.a$4 */
    public class C18484 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(16376);
            File file = new File(C1843a.foO);
            if (!file.exists()) {
                C4990ab.m7420w("MicroMsg.HandlerTraceManager", "summer handler trace file is not exists");
                AppMethodBeat.m2505o(16376);
            } else if (C1720g.m3534RN().mo5161QY()) {
                long j = C1843a.this.ehZ.getLong("handler_report_lastUploadTime", 0);
                long currentTimeMillis = System.currentTimeMillis();
                Object obj = (currentTimeMillis - j > C1843a.this.foW || j > currentTimeMillis) ? 1 : null;
                if (C1843a.this.foQ && obj != null) {
                    C4990ab.m7417i("MicroMsg.HandlerTraceManager", "summer check need upload ,file size is %d,time out %b", Long.valueOf(file.length()), Boolean.TRUE);
                    C1843a c1843a = C1843a.this;
                    Context context = C4996ah.getContext();
                    String packageName = C4996ah.getContext().getPackageName();
                    try {
                        PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{packageName, new C18445()});
                    } catch (Exception e) {
                        c1843a.ceM[0] = -1;
                        c1843a.ceM[1] = -1;
                        c1843a.ceM[2] = -1;
                    }
                    if (C1843a.this.ceM[1] != 0 || C1843a.this.foP > 1) {
                        if (file.length() > C1843a.this.foV) {
                            C4990ab.m7412e("MicroMsg.HandlerTraceManager", "summer log file invaild format");
                        } else {
                            String pf = C1843a.m3812pf(C1843a.foO);
                            C1843a c1843a2 = C1843a.this;
                            Intent intent = new Intent();
                            intent.setClassName(C4996ah.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
                            intent.setAction("uncatch_exception");
                            intent.putExtra("exceptionPid", Process.myPid());
                            String str = "userName";
                            String T = C6665av.fly.mo5292T("login_weixin_username", "");
                            if (C5046bo.isNullOrNil(T)) {
                                T = C6665av.fly.mo5292T("login_user_name", "never_login_crash");
                            }
                            intent.putExtra(str, T);
                            intent.putExtra("tag", "handler");
                            intent.putExtra("exceptionMsg", Base64.encodeToString((c1843a2.abm() + pf).getBytes(), 2));
                            C4996ah.getContext().sendBroadcast(intent);
                        }
                        C1843a.m3792a(C1843a.this, file);
                        C1843a.this.foQ = false;
                        C1843a.this.foP = 0;
                        C1843a.this.ehZ.edit().putLong("handler_report_lastUploadTime", System.currentTimeMillis()).commit();
                        AppMethodBeat.m2505o(16376);
                        return;
                    }
                    C1843a.this.foP = 1 + C1843a.this.foP;
                }
                AppMethodBeat.m2505o(16376);
            } else {
                C4990ab.m7420w("MicroMsg.HandlerTraceManager", "summer acc not ready ");
                AppMethodBeat.m2505o(16376);
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(16377);
            String str = super.toString() + "|checkAndUpload";
            AppMethodBeat.m2505o(16377);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.model.d.a$a */
    static class C1849a implements Comparable<C1849a> {
        long fpi;
        String info;

        C1849a() {
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (((C1849a) obj).fpi - this.fpi);
        }
    }

    /* renamed from: pf */
    static /* synthetic */ String m3812pf(String str) {
        AppMethodBeat.m2504i(16388);
        String pe = C1843a.m3811pe(str);
        AppMethodBeat.m2505o(16388);
        return pe;
    }

    static {
        AppMethodBeat.m2504i(16390);
        String LM = C1427q.m3028LM();
        ceI = LM;
        ceJ = C1183p.getString(LM.hashCode());
        AppMethodBeat.m2505o(16390);
    }

    private C1843a() {
        AppMethodBeat.m2504i(16379);
        this.ceM = new long[]{0, 0, 0};
        this.foP = 0;
        this.foQ = false;
        this.foS = 8000;
        this.foT = 800;
        this.foU = 25600;
        this.foV = 35840;
        this.foW = 86400000;
        this.foX = 180000;
        this.foY = 5000;
        this.foZ = 120;
        this.fpa = 50;
        this.fpb = 1800000;
        this.ehZ = C4996ah.doB();
        this.fpc = new Long[18];
        this.fpd = 0;
        this.fpe = 0;
        this.fpf = "";
        this.fpg = new LinkedList();
        this.foS = this.ehZ.getLong("handler_debug_log_time", 8000);
        this.foT = this.ehZ.getLong("handler_debug_log_time_main", 800);
        this.foU = this.ehZ.getLong("handler_trace_file_full_size", 25600);
        this.foV = this.ehZ.getLong("handler_log_file_max_size", 35840);
        this.foW = this.ehZ.getLong("handler_upload_time_interval", 86400000);
        this.fpe = C9638aw.m17180RS().oAl.getLooper().getThread().getId();
        Arrays.fill(this.fpc, Long.valueOf(0));
        AppMethodBeat.m2505o(16379);
    }

    public static C1843a abl() {
        AppMethodBeat.m2504i(16380);
        if (foM == null) {
            synchronized (C1843a.class) {
                try {
                    if (foM == null) {
                        foM = new C1843a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(16380);
                    }
                }
            }
        }
        C1843a c1843a = foM;
        AppMethodBeat.m2505o(16380);
        return c1843a;
    }

    /* renamed from: z */
    private void m3816z(File file) {
        boolean z = true;
        AppMethodBeat.m2504i(16381);
        if (file.exists()) {
            this.foQ = file.length() > this.foU;
            if (this.foQ) {
                long j = this.ehZ.getLong("handler_trace_log_file_full_time", 0);
                String str = "MicroMsg.HandlerTraceManager";
                String str2 = "has mark lastFullTime %b";
                Object[] objArr = new Object[1];
                if (j == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                C4990ab.m7417i(str, str2, objArr);
                if (j == 0) {
                    this.ehZ.edit().putLong("handler_trace_log_file_full_time", System.currentTimeMillis()).commit();
                }
                AppMethodBeat.m2505o(16381);
                return;
            }
        }
        this.foQ = false;
        AppMethodBeat.m2505o(16381);
    }

    /* Access modifiers changed, original: final */
    public final String abm() {
        Object format;
        String format2;
        AppMethodBeat.m2504i(16382);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        printStream.println("#client.version=" + C7243d.vxo);
        printStream.println("#accinfo.revision=" + C5058f.REV);
        printStream.println("#accinfo.uin=" + C6665av.fly.mo5292T("last_login_uin", ceJ));
        printStream.println("#accinfo.dev=" + ceI);
        printStream.println("#accinfo.build=" + C5058f.TIME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C5058f.HOSTNAME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C5059g.cdf);
        String str = "";
        try {
            StatFs statFs = new StatFs(C1448h.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(C6457e.eSl);
            format2 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) C4996ah.getContext().getSystemService("activity")).getMemoryClass()), r4.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), C6457e.eSl, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", e.getMessage());
            format2 = str;
        }
        printStream.println("#accinfo.data=".concat(String.valueOf(format2)));
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        printStream.println("#logfile.fulllast :".concat(String.valueOf(this.ehZ.getLong("handler_trace_log_file_full_time", 0) - this.ehZ.getLong("handler_trace_log_file_create_time", 0))));
        if (this.ceM[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.ceM[0] + " data size=" + this.ceM[1] + " code size=" + this.ceM[2]);
        }
        C25854m[] lU = C41787r.aix().mo20547lU(21);
        if (lU == null || lU.length == 0 || lU[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + lU[0].f13661id + " version=" + lU[0].version);
        }
        printStream.println("#handler.content:");
        format2 = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
        }
        AppMethodBeat.m2505o(16382);
        return format2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d A:{SYNTHETIC, Splitter:B:11:0x002d} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039 A:{SYNTHETIC, Splitter:B:17:0x0039} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: pe */
    private static String m3811pe(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        AppMethodBeat.m2504i(16383);
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str2 = new String(C45280e.m83490ce(bArr));
                try {
                    fileInputStream2.close();
                } catch (Exception e) {
                }
                AppMethodBeat.m2505o(16383);
                return str2;
            } catch (IOException e2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                    }
                }
                AppMethodBeat.m2505o(16383);
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                AppMethodBeat.m2505o(16383);
                throw th;
            }
        } catch (IOException e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(16383);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
            }
            AppMethodBeat.m2505o(16383);
            throw th;
        }
    }

    /* renamed from: b */
    private void m3796b(File file, boolean z) {
        AppMethodBeat.m2504i(16384);
        C4990ab.m7417i("MicroMsg.HandlerTraceManager", "build log file ,needRecreate %b", Boolean.valueOf(z));
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            m3816z(file);
            AppMethodBeat.m2505o(16384);
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.HandlerTraceManager", "recreate log file fail");
        }
        Editor edit = this.ehZ.edit();
        edit.putLong("handler_trace_log_file_create_time", System.currentTimeMillis());
        edit.putLong("handler_trace_log_file_full_time", 0).commit();
        m3816z(file);
        AppMethodBeat.m2505o(16384);
    }

    public final void abn() {
        AppMethodBeat.m2504i(16385);
        C4990ab.m7416i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
        this.foS = this.ehZ.getLong("handler_debug_log_time", 8000);
        this.foT = this.ehZ.getLong("handler_debug_log_time_main", 800);
        this.foU = this.ehZ.getLong("handler_trace_file_full_size", 25600);
        this.foV = this.ehZ.getLong("handler_log_file_max_size", 35840);
        this.foW = this.ehZ.getLong("handler_upload_time_interval", 86400000);
        this.foX = this.ehZ.getLong("handler_worker_assert_time", 180000);
        this.foY = this.ehZ.getLong("handler_worker_warn_time", 5000);
        this.foZ = (int) this.ehZ.getLong("handler_worker_warn_task_max_size", 120);
        this.fpa = (int) this.ehZ.getLong("handler_worker_warn_task_keep_size", 50);
        this.fpb = (int) this.ehZ.getLong("handler_worker_warn_task_keep_size", 1800000);
        m3816z(new File(foO));
        AppMethodBeat.m2505o(16385);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098 A:{SYNTHETIC, Splitter:B:30:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008e A:{SYNTHETIC, Splitter:B:24:0x008e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static /* synthetic */ void m3794a(C1843a c1843a, String str, String str2) {
        Throwable e;
        AppMethodBeat.m2504i(16387);
        if (C1445f.m3070Mn()) {
            File file;
            try {
                file = new File(foN);
                if (!file.exists()) {
                    file.mkdirs();
                }
                c1843a.m3796b(new File(foN, "Handler.trace"), false);
            } catch (Exception e2) {
            }
            file = new File(str);
            if (file.length() > c1843a.foV) {
                C4990ab.m7412e("MicroMsg.HandlerTraceManager", "summer log file invaild foramt, recreate");
                c1843a.m3796b(file, true);
            }
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    randomAccessFile.seek(randomAccessFile.length());
                    randomAccessFile.write(C45280e.m83490ce(str2.getBytes()));
                    try {
                        randomAccessFile.close();
                    } catch (Exception e3) {
                    }
                } catch (IOException e4) {
                    e = e4;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.HandlerTraceManager", e, "summer appendToFile fail with exception", new Object[0]);
                        if (randomAccessFile != null) {
                        }
                        c1843a.m3816z(new File(foO));
                        AppMethodBeat.m2505o(16387);
                        return;
                    } catch (Throwable th) {
                        e = th;
                        if (randomAccessFile != null) {
                        }
                        AppMethodBeat.m2505o(16387);
                        throw e;
                    }
                }
            } catch (IOException e5) {
                e = e5;
                randomAccessFile = null;
                C4990ab.printErrStackTrace("MicroMsg.HandlerTraceManager", e, "summer appendToFile fail with exception", new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e6) {
                    }
                }
                c1843a.m3816z(new File(foO));
                AppMethodBeat.m2505o(16387);
                return;
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e7) {
                    }
                }
                AppMethodBeat.m2505o(16387);
                throw e;
            }
            c1843a.m3816z(new File(foO));
            AppMethodBeat.m2505o(16387);
            return;
        }
        C4990ab.m7416i("MicroMsg.HandlerTraceManager", "summer sdcard is not Available, appendToFile fail ");
        AppMethodBeat.m2505o(16387);
    }
}
