package com.tencent.mm.model.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.Base64;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ba.m;
import com.tencent.mm.ba.r;
import com.tencent.mm.cd.h;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.d.c.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
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

public final class b implements a {
    private static final String ceI;
    private static final String ceJ;
    private static b fpj;
    public static final String fpk = (e.eSl + "/tencent/MicroMsg/SQLTrace/");
    public static List<String> fpu = Arrays.asList(new String[]{"FTS5IndexMicroMsg_encrypt.db"});
    long[] ceM = new long[]{0, 0, 0};
    private SharedPreferences ehZ = ah.doB();
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

    /* renamed from: com.tencent.mm.model.d.b$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ String fpw;

        public AnonymousClass3(String str) {
            this.fpw = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x00eb A:{SYNTHETIC, Splitter:B:28:0x00eb} */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0100 A:{SYNTHETIC, Splitter:B:35:0x0100} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            AppMethodBeat.i(16393);
            b bVar = b.this;
            String str = b.fpk + "MMSQL.trace";
            String str2 = this.fpw + IOUtils.LINE_SEPARATOR_UNIX;
            if (f.Mn()) {
                File file;
                try {
                    file = new File(b.fpk);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    bVar.b(new File(b.fpk, "MMSQL.trace"), false);
                } catch (Exception e2) {
                    ab.e("MicroMsg.SQLTraceManager", "init dir fail");
                }
                file = new File(str);
                if (file.length() > bVar.fpp) {
                    ab.e("MicroMsg.SQLTraceManager", "log file invaild foramt,recreate");
                    bVar.b(file, true);
                }
                RandomAccessFile randomAccessFile;
                try {
                    randomAccessFile = new RandomAccessFile(str, "rw");
                    try {
                        randomAccessFile.seek(randomAccessFile.length());
                        randomAccessFile.write(com.tencent.mm.cf.e.ce(str2.getBytes()));
                        try {
                            randomAccessFile.close();
                        } catch (Exception e3) {
                            ab.printErrStackTrace("MicroMsg.SQLTraceManager", e3, "appendToFile fail with exception", new Object[0]);
                        }
                    } catch (IOException e4) {
                        e = e4;
                        try {
                            ab.printErrStackTrace("MicroMsg.SQLTraceManager", e, "appendToFile fail with exception", new Object[0]);
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Exception e32) {
                                    ab.printErrStackTrace("MicroMsg.SQLTraceManager", e32, "appendToFile fail with exception", new Object[0]);
                                }
                            }
                            bVar.z(new File(b.fpk + "MMSQL.trace"));
                            AppMethodBeat.o(16393);
                            return;
                        } catch (Throwable th) {
                            e = th;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Exception e5) {
                                    ab.printErrStackTrace("MicroMsg.SQLTraceManager", e5, "appendToFile fail with exception", new Object[0]);
                                }
                            }
                            AppMethodBeat.o(16393);
                            throw e;
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                    randomAccessFile = null;
                    ab.printErrStackTrace("MicroMsg.SQLTraceManager", e, "appendToFile fail with exception", new Object[0]);
                    if (randomAccessFile != null) {
                    }
                    bVar.z(new File(b.fpk + "MMSQL.trace"));
                    AppMethodBeat.o(16393);
                    return;
                } catch (Throwable th2) {
                    e = th2;
                    randomAccessFile = null;
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.o(16393);
                    throw e;
                }
                bVar.z(new File(b.fpk + "MMSQL.trace"));
                AppMethodBeat.o(16393);
                return;
            }
            ab.i("MicroMsg.SQLTraceManager", "sdcard is not  Available,appendToFile fail ");
            AppMethodBeat.o(16393);
        }
    }

    static /* synthetic */ String ph(String str) {
        AppMethodBeat.i(16414);
        String pe = pe(str);
        AppMethodBeat.o(16414);
        return pe;
    }

    static {
        AppMethodBeat.i(16416);
        String LM = q.LM();
        ceI = LM;
        ceJ = p.getString(LM.hashCode());
        AppMethodBeat.o(16416);
    }

    public static b abr() {
        AppMethodBeat.i(16394);
        if (fpj == null) {
            fpj = new b();
        }
        b bVar = fpj;
        AppMethodBeat.o(16394);
        return bVar;
    }

    public b() {
        AppMethodBeat.i(16395);
        abs();
        AppMethodBeat.o(16395);
    }

    private void abs() {
        AppMethodBeat.i(16396);
        this.fpl = this.ehZ.getLong("sql_trace_main_thread_select_interval_time", 300);
        this.fpm = this.ehZ.getLong("sql_trace_main_thread_update_interval_time", 500);
        this.fpn = this.ehZ.getLong("sql_trace_child_thread_interval_time", 1500);
        long bR = bR(ah.getContext());
        if (bR > 0) {
            this.fpl += bR;
            this.fpm += bR;
            this.fpn += bR;
            ab.i("MicroMsg.SQLTraceManager", "auto adapte Time %d", Long.valueOf(bR));
        }
        this.fpo = this.ehZ.getLong("sql_trace_child_transaction_interval_time", 5000);
        this.fpt = this.ehZ.getLong("sql_trace_file_full_size", 30720);
        this.fpp = this.ehZ.getLong("sql_trace_log_file_max_size", 35840);
        this.fpq = this.ehZ.getLong("sql_trace_upload_file_min_size", 10240);
        this.fpr = this.ehZ.getLong("sql_upload_time_interval", 21600000);
        z(new File(fpk, "MMSQL.trace"));
        ab.i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d", Long.valueOf(this.fpl), Long.valueOf(this.fpm), Long.valueOf(this.fpn), Long.valueOf(this.fpo), Long.valueOf(this.fpt), Long.valueOf(this.fpp), Long.valueOf(this.fpq), Long.valueOf(this.fpr));
        AppMethodBeat.o(16396);
    }

    public static void setup() {
        AppMethodBeat.i(16397);
        if (ah.xzd) {
            ab.i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: ".concat(String.valueOf(com.tencent.mm.a.e.deleteFile(fpk + "MMSQL.trace"))));
        }
        AppMethodBeat.o(16397);
    }

    /* Access modifiers changed, original: final */
    public final void z(File file) {
        boolean z = true;
        AppMethodBeat.i(16398);
        if (file.exists()) {
            this.foQ = file.length() > this.fpt;
            if (this.foQ) {
                long bQ = bQ(ah.getContext());
                String str = "MicroMsg.SQLTraceManager";
                String str2 = "has mark lastFullTime %b";
                Object[] objArr = new Object[1];
                if (bQ == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                ab.i(str, str2, objArr);
                if (bQ == 0) {
                    d(ah.getContext(), System.currentTimeMillis());
                }
                AppMethodBeat.o(16398);
                return;
            }
        }
        this.foQ = false;
        AppMethodBeat.o(16398);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b A:{SYNTHETIC, Splitter:B:13:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054 A:{SYNTHETIC, Splitter:B:21:0x0054} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String pe(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        AppMethodBeat.i(16399);
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str2 = new String(com.tencent.mm.cf.e.ce(bArr));
                try {
                    fileInputStream2.close();
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SQLTraceManager", e, "", new Object[0]);
                }
                AppMethodBeat.o(16399);
                return str2;
            } catch (IOException e2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(16399);
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                }
                AppMethodBeat.o(16399);
                throw th;
            }
        } catch (IOException e3) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                    ab.printErrStackTrace("MicroMsg.SQLTraceManager", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.o(16399);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e5) {
                    ab.printErrStackTrace("MicroMsg.SQLTraceManager", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.o(16399);
            throw th;
        }
    }

    private static long a(String str, h hVar) {
        AppMethodBeat.i(16400);
        Cursor a = hVar.a("select count(*) from ".concat(String.valueOf(str)), null, 2);
        long j = 0;
        if (a.moveToFirst()) {
            j = a.getLong(0);
        }
        a.close();
        AppMethodBeat.o(16400);
        return j;
    }

    private String abm() {
        Object format;
        String format2;
        AppMethodBeat.i(16401);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        printStream.println("#client.version=" + d.vxo);
        printStream.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.f.REV);
        printStream.println("#accinfo.uin=" + av.fly.T("last_login_uin", ceJ));
        printStream.println("#accinfo.dev=" + ceI);
        printStream.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.f.TIME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + com.tencent.mm.sdk.platformtools.f.HOSTNAME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + g.cdf);
        String str = "";
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.h.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(e.eSl);
            format2 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) ah.getContext().getSystemService("activity")).getMemoryClass()), r4.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), e.eSl, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            ab.e("MicroMsg.SQLTraceManager", "check data size failed :%s", e.getMessage());
            format2 = str;
        }
        printStream.println("#accinfo.data=".concat(String.valueOf(format2)));
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        long bR = bR(ah.getContext());
        if (bR > 0) {
            printStream.println("#logfile.autoAdapteTime :".concat(String.valueOf(bR)));
        }
        if (bQ(ah.getContext()) != 0) {
            long bQ = bQ(ah.getContext()) - bP(ah.getContext());
            printStream.println("#logfile.fulllast :".concat(String.valueOf(bQ)));
            if (bQ > 0 && bQ < 28800000) {
                PreferenceManager.getDefaultSharedPreferences(ah.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", bR + 100).commit();
                ab.i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", Long.valueOf(bR));
                abs();
            }
        } else {
            printStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - bP(ah.getContext())));
        }
        m[] lU = r.aix().lU(21);
        if (lU == null || lU.length == 0 || lU[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + lU[0].id + " version=" + lU[0].version);
        }
        if (this.ceM[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.ceM[0] + " data size= " + this.ceM[1] + " code size =" + this.ceM[2]);
        }
        StringBuilder stringBuilder = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        aw.ZK();
        printStream.println(stringBuilder.append(new File(c.Rw()).length()).toString());
        stringBuilder = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        StringBuilder stringBuilder2 = new StringBuilder();
        aw.ZK();
        printStream.println(stringBuilder.append(new File(stringBuilder2.append(c.Rt()).append("SnsMicroMsg.db").toString()).length()).toString());
        aw.ZK();
        a(c.XK(), printStream, Arrays.asList(new String[]{ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo"}));
        printStream.println("#sql.content:");
        format2 = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
        }
        AppMethodBeat.o(16401);
        return format2;
    }

    private static void a(h hVar, PrintStream printStream, List<String> list) {
        AppMethodBeat.i(16402);
        if (hVar == null || !hVar.isOpen()) {
            ab.i("MicroMsg.SQLTraceManager", "db is not open!");
            AppMethodBeat.o(16402);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            Cursor a = hVar.a("select name from sqlite_master where type='table' ", null, 2);
            while (a.moveToNext()) {
                String string = a.getString(0);
                printStream.println("#table : " + string + " count=" + a(string, hVar));
            }
            a.close();
        } else {
            for (String str : list) {
                printStream.println("#table : " + str + " count=" + a(str, hVar));
            }
        }
        ab.i("MicroMsg.SQLTraceManager", "dump all table count last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(16402);
    }

    public static void a(String str, String str2, StringBuilder stringBuilder) {
        AppMethodBeat.i(16403);
        stringBuilder.append(str).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(str2).append(" ");
        AppMethodBeat.o(16403);
    }

    public final void pg(String str) {
        AppMethodBeat.i(16404);
        if (str == null) {
            str = "";
        }
        Intent intent = new Intent();
        intent.setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionPid", Process.myPid());
        intent.putExtra("userName", Bo());
        intent.putExtra("tag", "SqlTrace");
        intent.putExtra("exceptionMsg", Base64.encodeToString((abm() + str).getBytes(), 2));
        ah.getContext().sendBroadcast(intent);
        AppMethodBeat.o(16404);
    }

    private static String Bo() {
        AppMethodBeat.i(16405);
        String T = av.fly.T("login_weixin_username", "");
        if (bo.isNullOrNil(T)) {
            T = av.fly.T("login_user_name", "never_login_crash");
        }
        AppMethodBeat.o(16405);
        return T;
    }

    /* Access modifiers changed, original: final */
    public final void b(File file, boolean z) {
        AppMethodBeat.i(16406);
        ab.i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", Boolean.valueOf(z));
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            z(file);
            AppMethodBeat.o(16406);
        }
        try {
            file.createNewFile();
            Context context = ah.getContext();
            PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_create_time", System.currentTimeMillis()).commit();
            d(ah.getContext(), 0);
        } catch (IOException e) {
            ab.e("MicroMsg.SQLTraceManager", "recreate log file fail");
        }
        z(file);
        AppMethodBeat.o(16406);
    }

    public static void c(Context context, long j) {
        AppMethodBeat.i(16407);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_report_lastUploadTime", j).commit();
        AppMethodBeat.o(16407);
    }

    public static long bO(Context context) {
        AppMethodBeat.i(16408);
        long j = PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_report_lastUploadTime", 0);
        AppMethodBeat.o(16408);
        return j;
    }

    private static long bP(Context context) {
        AppMethodBeat.i(16409);
        long j = PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_create_time", 0);
        AppMethodBeat.o(16409);
        return j;
    }

    private static void d(Context context, long j) {
        AppMethodBeat.i(16410);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_full_time", j).commit();
        AppMethodBeat.o(16410);
    }

    private static long bQ(Context context) {
        AppMethodBeat.i(16411);
        long j = PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_full_time", 0);
        AppMethodBeat.o(16411);
        return j;
    }

    private static long bR(Context context) {
        AppMethodBeat.i(16412);
        long j = PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_autoAdaptaTime", 0);
        AppMethodBeat.o(16412);
        return j;
    }

    public final void abn() {
        AppMethodBeat.i(16413);
        ab.i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
        abs();
        AppMethodBeat.o(16413);
    }
}
