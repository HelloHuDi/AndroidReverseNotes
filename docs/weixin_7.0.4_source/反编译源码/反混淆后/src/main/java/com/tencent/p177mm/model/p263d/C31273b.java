package com.tencent.p177mm.model.p263d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.p052pm.IPackageStatsObserver;
import android.content.p052pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.database.Cursor;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.Base64;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p263d.C9659c.C9660a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p215cf.C45280e;
import com.tencent.p177mm.p707ba.C25854m;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
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
import java.util.List;
import java.util.Locale;

/* renamed from: com.tencent.mm.model.d.b */
public final class C31273b implements C9660a {
    private static final String ceI;
    private static final String ceJ;
    private static C31273b fpj;
    public static final String fpk = (C6457e.eSl + "/tencent/MicroMsg/SQLTrace/");
    public static List<String> fpu = Arrays.asList(new String[]{"FTS5IndexMicroMsg_encrypt.db"});
    long[] ceM = new long[]{0, 0, 0};
    private SharedPreferences ehZ = C4996ah.doB();
    private long foP = 0;
    public volatile boolean foQ = false;
    public long fpl;
    public long fpm;
    public long fpn;
    public long fpo;
    long fpp;
    private long fpq;
    private long fpr;
    private long fpt;

    /* renamed from: com.tencent.mm.model.d.b$1 */
    public class C96561 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(16391);
            File file = new File(C31273b.fpk + "MMSQL.trace");
            if (!file.exists()) {
                C4990ab.m7420w("MicroMsg.SQLTraceManager", "SqlTrace file is not  exists");
                AppMethodBeat.m2505o(16391);
            } else if (C1720g.m3534RN().mo5161QY()) {
                long currentTimeMillis = System.currentTimeMillis();
                long bO = C31273b.m50473bO(C4996ah.getContext());
                boolean z = false;
                if (bO > currentTimeMillis) {
                    z = true;
                } else if (currentTimeMillis - bO > 86400000) {
                    z = true;
                } else if (currentTimeMillis - bO > C31273b.this.fpr && C31273b.this.foQ) {
                    z = true;
                }
                C4990ab.m7417i("MicroMsg.SQLTraceManager", "check need upload ,file size is %d,time out  %b", Long.valueOf(file.length()), Boolean.valueOf(z));
                if (z && r2 > C31273b.this.fpq) {
                    C31273b c31273b = C31273b.this;
                    Context context = C4996ah.getContext();
                    String packageName = C4996ah.getContext().getPackageName();
                    try {
                        PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{packageName, new C96572()});
                    } catch (Exception e) {
                        c31273b.ceM[0] = -1;
                        c31273b.ceM[1] = -1;
                        c31273b.ceM[2] = -1;
                    }
                    if (C31273b.this.ceM[1] != 0 || C31273b.this.foP > 1) {
                        C4990ab.m7417i("MicroMsg.SQLTraceManager", "start file upload ,file length is %d ", Long.valueOf(file.length()));
                        if (file.length() > C31273b.this.fpp) {
                            C4990ab.m7412e("MicroMsg.SQLTraceManager", "log file invaild format");
                        } else {
                            String ph = C31273b.m50487ph(C31273b.fpk + "MMSQL.trace");
                            C4990ab.m7416i("MicroMsg.SQLTraceManager", "read content success");
                            C31273b.this.mo51235pg(ph);
                        }
                        C4990ab.m7417i("MicroMsg.SQLTraceManager", "set last Upload Time %d ", Long.valueOf(System.currentTimeMillis()));
                        C31273b.m50470a(C31273b.this, file);
                        C31273b.this.foQ = false;
                        C31273b.this.foP = 0;
                        C31273b.m50478c(C4996ah.getContext(), System.currentTimeMillis());
                        AppMethodBeat.m2505o(16391);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.SQLTraceManager", "wait for get packageStats");
                    C31273b.this.foP = 1 + C31273b.this.foP;
                }
                AppMethodBeat.m2505o(16391);
            } else {
                C4990ab.m7420w("MicroMsg.SQLTraceManager", "acc not ready ");
                AppMethodBeat.m2505o(16391);
            }
        }
    }

    /* renamed from: com.tencent.mm.model.d.b$2 */
    class C96572 extends Stub {
        C96572() {
        }

        public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
            AppMethodBeat.m2504i(16392);
            C31273b.this.ceM[0] = packageStats.cacheSize;
            C31273b.this.ceM[1] = packageStats.dataSize;
            C31273b.this.ceM[2] = packageStats.codeSize;
            C4990ab.m7417i("MicroMsg.SQLTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
            AppMethodBeat.m2505o(16392);
        }
    }

    /* renamed from: com.tencent.mm.model.d.b$3 */
    public class C96583 implements Runnable {
        final /* synthetic */ String fpw;

        public C96583(String str) {
            this.fpw = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x00eb A:{SYNTHETIC, Splitter:B:28:0x00eb} */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0100 A:{SYNTHETIC, Splitter:B:35:0x0100} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            AppMethodBeat.m2504i(16393);
            C31273b c31273b = C31273b.this;
            String str = C31273b.fpk + "MMSQL.trace";
            String str2 = this.fpw + IOUtils.LINE_SEPARATOR_UNIX;
            if (C1445f.m3070Mn()) {
                File file;
                try {
                    file = new File(C31273b.fpk);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    c31273b.mo51234b(new File(C31273b.fpk, "MMSQL.trace"), false);
                } catch (Exception e2) {
                    C4990ab.m7412e("MicroMsg.SQLTraceManager", "init dir fail");
                }
                file = new File(str);
                if (file.length() > c31273b.fpp) {
                    C4990ab.m7412e("MicroMsg.SQLTraceManager", "log file invaild foramt,recreate");
                    c31273b.mo51234b(file, true);
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
                            C4990ab.printErrStackTrace("MicroMsg.SQLTraceManager", e3, "appendToFile fail with exception", new Object[0]);
                        }
                    } catch (IOException e4) {
                        e = e4;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.SQLTraceManager", e, "appendToFile fail with exception", new Object[0]);
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Exception e32) {
                                    C4990ab.printErrStackTrace("MicroMsg.SQLTraceManager", e32, "appendToFile fail with exception", new Object[0]);
                                }
                            }
                            c31273b.mo51236z(new File(C31273b.fpk + "MMSQL.trace"));
                            AppMethodBeat.m2505o(16393);
                            return;
                        } catch (Throwable th) {
                            e = th;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Exception e5) {
                                    C4990ab.printErrStackTrace("MicroMsg.SQLTraceManager", e5, "appendToFile fail with exception", new Object[0]);
                                }
                            }
                            AppMethodBeat.m2505o(16393);
                            throw e;
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                    randomAccessFile = null;
                    C4990ab.printErrStackTrace("MicroMsg.SQLTraceManager", e, "appendToFile fail with exception", new Object[0]);
                    if (randomAccessFile != null) {
                    }
                    c31273b.mo51236z(new File(C31273b.fpk + "MMSQL.trace"));
                    AppMethodBeat.m2505o(16393);
                    return;
                } catch (Throwable th2) {
                    e = th2;
                    randomAccessFile = null;
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.m2505o(16393);
                    throw e;
                }
                c31273b.mo51236z(new File(C31273b.fpk + "MMSQL.trace"));
                AppMethodBeat.m2505o(16393);
                return;
            }
            C4990ab.m7416i("MicroMsg.SQLTraceManager", "sdcard is not  Available,appendToFile fail ");
            AppMethodBeat.m2505o(16393);
        }
    }

    /* renamed from: ph */
    static /* synthetic */ String m50487ph(String str) {
        AppMethodBeat.m2504i(16414);
        String pe = C31273b.m50486pe(str);
        AppMethodBeat.m2505o(16414);
        return pe;
    }

    static {
        AppMethodBeat.m2504i(16416);
        String LM = C1427q.m3028LM();
        ceI = LM;
        ceJ = C1183p.getString(LM.hashCode());
        AppMethodBeat.m2505o(16416);
    }

    public static C31273b abr() {
        AppMethodBeat.m2504i(16394);
        if (fpj == null) {
            fpj = new C31273b();
        }
        C31273b c31273b = fpj;
        AppMethodBeat.m2505o(16394);
        return c31273b;
    }

    public C31273b() {
        AppMethodBeat.m2504i(16395);
        abs();
        AppMethodBeat.m2505o(16395);
    }

    private void abs() {
        AppMethodBeat.m2504i(16396);
        this.fpl = this.ehZ.getLong("sql_trace_main_thread_select_interval_time", 300);
        this.fpm = this.ehZ.getLong("sql_trace_main_thread_update_interval_time", 500);
        this.fpn = this.ehZ.getLong("sql_trace_child_thread_interval_time", 1500);
        long bR = C31273b.m50476bR(C4996ah.getContext());
        if (bR > 0) {
            this.fpl += bR;
            this.fpm += bR;
            this.fpn += bR;
            C4990ab.m7417i("MicroMsg.SQLTraceManager", "auto adapte Time %d", Long.valueOf(bR));
        }
        this.fpo = this.ehZ.getLong("sql_trace_child_transaction_interval_time", 5000);
        this.fpt = this.ehZ.getLong("sql_trace_file_full_size", 30720);
        this.fpp = this.ehZ.getLong("sql_trace_log_file_max_size", 35840);
        this.fpq = this.ehZ.getLong("sql_trace_upload_file_min_size", 10240);
        this.fpr = this.ehZ.getLong("sql_upload_time_interval", 21600000);
        mo51236z(new File(fpk, "MMSQL.trace"));
        C4990ab.m7417i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d", Long.valueOf(this.fpl), Long.valueOf(this.fpm), Long.valueOf(this.fpn), Long.valueOf(this.fpo), Long.valueOf(this.fpt), Long.valueOf(this.fpp), Long.valueOf(this.fpq), Long.valueOf(this.fpr));
        AppMethodBeat.m2505o(16396);
    }

    public static void setup() {
        AppMethodBeat.m2504i(16397);
        if (C4996ah.xzd) {
            C4990ab.m7416i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: ".concat(String.valueOf(C1173e.deleteFile(fpk + "MMSQL.trace"))));
        }
        AppMethodBeat.m2505o(16397);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: z */
    public final void mo51236z(File file) {
        boolean z = true;
        AppMethodBeat.m2504i(16398);
        if (file.exists()) {
            this.foQ = file.length() > this.fpt;
            if (this.foQ) {
                long bQ = C31273b.m50475bQ(C4996ah.getContext());
                String str = "MicroMsg.SQLTraceManager";
                String str2 = "has mark lastFullTime %b";
                Object[] objArr = new Object[1];
                if (bQ == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                C4990ab.m7417i(str, str2, objArr);
                if (bQ == 0) {
                    C31273b.m50479d(C4996ah.getContext(), System.currentTimeMillis());
                }
                AppMethodBeat.m2505o(16398);
                return;
            }
        }
        this.foQ = false;
        AppMethodBeat.m2505o(16398);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b A:{SYNTHETIC, Splitter:B:13:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054 A:{SYNTHETIC, Splitter:B:21:0x0054} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: pe */
    public static String m50486pe(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        AppMethodBeat.m2504i(16399);
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
                    C4990ab.printErrStackTrace("MicroMsg.SQLTraceManager", e, "", new Object[0]);
                }
                AppMethodBeat.m2505o(16399);
                return str2;
            } catch (IOException e2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(16399);
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                }
                AppMethodBeat.m2505o(16399);
                throw th;
            }
        } catch (IOException e3) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                    C4990ab.printErrStackTrace("MicroMsg.SQLTraceManager", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(16399);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e5) {
                    C4990ab.printErrStackTrace("MicroMsg.SQLTraceManager", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(16399);
            throw th;
        }
    }

    /* renamed from: a */
    private static long m50468a(String str, C7480h c7480h) {
        AppMethodBeat.m2504i(16400);
        Cursor a = c7480h.mo10104a("select count(*) from ".concat(String.valueOf(str)), null, 2);
        long j = 0;
        if (a.moveToFirst()) {
            j = a.getLong(0);
        }
        a.close();
        AppMethodBeat.m2505o(16400);
        return j;
    }

    private String abm() {
        Object format;
        String format2;
        AppMethodBeat.m2504i(16401);
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
            C4990ab.m7413e("MicroMsg.SQLTraceManager", "check data size failed :%s", e.getMessage());
            format2 = str;
        }
        printStream.println("#accinfo.data=".concat(String.valueOf(format2)));
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        long bR = C31273b.m50476bR(C4996ah.getContext());
        if (bR > 0) {
            printStream.println("#logfile.autoAdapteTime :".concat(String.valueOf(bR)));
        }
        if (C31273b.m50475bQ(C4996ah.getContext()) != 0) {
            long bQ = C31273b.m50475bQ(C4996ah.getContext()) - C31273b.m50474bP(C4996ah.getContext());
            printStream.println("#logfile.fulllast :".concat(String.valueOf(bQ)));
            if (bQ > 0 && bQ < 28800000) {
                PreferenceManager.getDefaultSharedPreferences(C4996ah.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", bR + 100).commit();
                C4990ab.m7417i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", Long.valueOf(bR));
                abs();
            }
        } else {
            printStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - C31273b.m50474bP(C4996ah.getContext())));
        }
        C25854m[] lU = C41787r.aix().mo20547lU(21);
        if (lU == null || lU.length == 0 || lU[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + lU[0].f13661id + " version=" + lU[0].version);
        }
        if (this.ceM[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.ceM[0] + " data size= " + this.ceM[1] + " code size =" + this.ceM[2]);
        }
        StringBuilder stringBuilder = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        C9638aw.m17190ZK();
        printStream.println(stringBuilder.append(new File(C18628c.m29071Rw()).length()).toString());
        stringBuilder = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        StringBuilder stringBuilder2 = new StringBuilder();
        C9638aw.m17190ZK();
        printStream.println(stringBuilder.append(new File(stringBuilder2.append(C18628c.m29068Rt()).append("SnsMicroMsg.db").toString()).length()).toString());
        C9638aw.m17190ZK();
        C31273b.m50469a(C18628c.m29076XK(), printStream, Arrays.asList(new String[]{ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo"}));
        printStream.println("#sql.content:");
        format2 = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
        }
        AppMethodBeat.m2505o(16401);
        return format2;
    }

    /* renamed from: a */
    private static void m50469a(C7480h c7480h, PrintStream printStream, List<String> list) {
        AppMethodBeat.m2504i(16402);
        if (c7480h == null || !c7480h.isOpen()) {
            C4990ab.m7416i("MicroMsg.SQLTraceManager", "db is not open!");
            AppMethodBeat.m2505o(16402);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            Cursor a = c7480h.mo10104a("select name from sqlite_master where type='table' ", null, 2);
            while (a.moveToNext()) {
                String string = a.getString(0);
                printStream.println("#table : " + string + " count=" + C31273b.m50468a(string, c7480h));
            }
            a.close();
        } else {
            for (String str : list) {
                printStream.println("#table : " + str + " count=" + C31273b.m50468a(str, c7480h));
            }
        }
        C4990ab.m7417i("MicroMsg.SQLTraceManager", "dump all table count last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(16402);
    }

    /* renamed from: a */
    public static void m50471a(String str, String str2, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(16403);
        stringBuilder.append(str).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(str2).append(" ");
        AppMethodBeat.m2505o(16403);
    }

    /* renamed from: pg */
    public final void mo51235pg(String str) {
        AppMethodBeat.m2504i(16404);
        if (str == null) {
            str = "";
        }
        Intent intent = new Intent();
        intent.setClassName(C4996ah.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionPid", Process.myPid());
        intent.putExtra("userName", C31273b.m50466Bo());
        intent.putExtra("tag", "SqlTrace");
        intent.putExtra("exceptionMsg", Base64.encodeToString((abm() + str).getBytes(), 2));
        C4996ah.getContext().sendBroadcast(intent);
        AppMethodBeat.m2505o(16404);
    }

    /* renamed from: Bo */
    private static String m50466Bo() {
        AppMethodBeat.m2504i(16405);
        String T = C6665av.fly.mo5292T("login_weixin_username", "");
        if (C5046bo.isNullOrNil(T)) {
            T = C6665av.fly.mo5292T("login_user_name", "never_login_crash");
        }
        AppMethodBeat.m2505o(16405);
        return T;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo51234b(File file, boolean z) {
        AppMethodBeat.m2504i(16406);
        C4990ab.m7417i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", Boolean.valueOf(z));
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            mo51236z(file);
            AppMethodBeat.m2505o(16406);
        }
        try {
            file.createNewFile();
            Context context = C4996ah.getContext();
            PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_create_time", System.currentTimeMillis()).commit();
            C31273b.m50479d(C4996ah.getContext(), 0);
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.SQLTraceManager", "recreate log file fail");
        }
        mo51236z(file);
        AppMethodBeat.m2505o(16406);
    }

    /* renamed from: c */
    public static void m50478c(Context context, long j) {
        AppMethodBeat.m2504i(16407);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_report_lastUploadTime", j).commit();
        AppMethodBeat.m2505o(16407);
    }

    /* renamed from: bO */
    public static long m50473bO(Context context) {
        AppMethodBeat.m2504i(16408);
        long j = PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_report_lastUploadTime", 0);
        AppMethodBeat.m2505o(16408);
        return j;
    }

    /* renamed from: bP */
    private static long m50474bP(Context context) {
        AppMethodBeat.m2504i(16409);
        long j = PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_create_time", 0);
        AppMethodBeat.m2505o(16409);
        return j;
    }

    /* renamed from: d */
    private static void m50479d(Context context, long j) {
        AppMethodBeat.m2504i(16410);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_full_time", j).commit();
        AppMethodBeat.m2505o(16410);
    }

    /* renamed from: bQ */
    private static long m50475bQ(Context context) {
        AppMethodBeat.m2504i(16411);
        long j = PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_full_time", 0);
        AppMethodBeat.m2505o(16411);
        return j;
    }

    /* renamed from: bR */
    private static long m50476bR(Context context) {
        AppMethodBeat.m2504i(16412);
        long j = PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_autoAdaptaTime", 0);
        AppMethodBeat.m2505o(16412);
        return j;
    }

    public final void abn() {
        AppMethodBeat.m2504i(16413);
        C4990ab.m7416i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
        abs();
        AppMethodBeat.m2505o(16413);
    }
}
